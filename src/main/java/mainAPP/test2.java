package mainAPP;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import baseclasses.Booking;
import baseclasses.events.CompositeEvent;
import baseclasses.events.EventComponent;
import baseclasses.guests.Guest;
import baseclasses.orders.Order;
import baseclasses.orders.StatusType;
import baseclasses.venues.Location;
import baseclasses.workers.Worker;
import baseclasses.workers.WorkerType;
import command.BookingSystem;
import command.Command;
import command.concretecommands.ChangeMainEventCommand;
import command.concretecommands.CreateOrderCommand;
import command.concretecommands.PrintScheduleCommand;
import command.concretecommands.RemoveMainEventCommand;
import concreteclasses.eventfactories.BanquetFactory;
import concreteclasses.eventfactories.CeremonyFactory;
import concreteclasses.eventfactories.PhotoSessionFactory;
import concreteclasses.statusTypes.Active;
import concreteclasses.venuefactories.WeddingHallFactory;
import concreteclasses.workers.Photographer;
import observer.Editor;



public class test2 {

	public static void main(String[] args) {
	
				Editor editor = new Editor();
				

		        // Создание фабрик и событий
		        CeremonyFactory ceremonyFactory = new CeremonyFactory();
		        BanquetFactory banquetFactory = new BanquetFactory();
		        PhotoSessionFactory photoSessionFactory = new PhotoSessionFactory();

		        EventComponent ceremony = ceremonyFactory.createEvent();
		        EventComponent banquet = banquetFactory.createEvent();
		        EventComponent photoSession = photoSessionFactory.createEvent();
		        
		        // Добавление гостей
		        Guest guest1 = new Guest("Иван Иванов");
		        Guest guest2 = new Guest("Леруа Мерлен");
		        List<Guest> guests = Arrays.asList(guest1, guest2);

		        //editor.addGuestsToEvent(ceremony, guests);
		        editor.addGuestsToEvent(banquet, guests);

		        // Создание работника и типа работника
		        WorkerType photographerType = new Photographer();
		        Worker worker2 = new Worker("Дима Биткин", photographerType);
		        
		        //Создание локации и типа локации
		        WeddingHallFactory weddingHallFactory = new WeddingHallFactory();
		        Location weddingHall = weddingHallFactory.createLocation("Место венчания", 200);

		        // Создание бронирования
		        LocalDateTime start = LocalDateTime.of(2024, 5, 10, 10, 0);
		        LocalDateTime end = LocalDateTime.of(2024, 5, 10, 12, 0);
		        Booking booking = new Booking(start, end, photoSession);

		        // Назначение работника и мероприятия на событие
		        editor.bookEventForWorker(booking, photographerType, worker2);
		        editor.bookEventForLocation(booking, weddingHall.getType(), weddingHall);

		        // Отображение активных бронирований
		        worker2.showActiveBookings();
		        weddingHall.showActiveBookings();
		        
		        // Пример отображения
		        CompositeEvent wedding = new CompositeEvent("Свадьба");
		       wedding.add(ceremony);
		       wedding.add(banquet);
		       wedding.add(photoSession);
		       
		       BookingSystem bookingSystem = new BookingSystem();

		       //CompositeEvent mainEvent = new CompositeEvent("Main Event");
		       StatusType activeStatus = new Active();

		       // Создание команды для создания заказа
		       Command createOrderCommand = new CreateOrderCommand(bookingSystem, "Заказ 1", wedding, "Валерия Серова", LocalDateTime.now(), activeStatus);
		       bookingSystem.executeCommand(createOrderCommand);

		       // Получаем созданный заказ из списка заказов
		       Order order = bookingSystem.getOrders().get(0);

		       // Создание команды для изменения основного мероприятия заказа
		       CompositeEvent newEvent = new CompositeEvent("Новый план");
		       Command changeEventCommand = new ChangeMainEventCommand(order, newEvent);
		       bookingSystem.executeCommand(changeEventCommand);

		       // Отмена команды изменения мероприятия
		       bookingSystem.undoLastCommand();

		       // Создание команды для удаления основного мероприятия заказа
		       Command removeEventCommand = new RemoveMainEventCommand(order);
		       bookingSystem.executeCommand(removeEventCommand);

		       // Отмена команды удаления мероприятия
		       bookingSystem.undoLastCommand();
		       
		    // Создание экземпляра команды для вывода расписания
		       Command printScheduleCommand = new PrintScheduleCommand(order);
		       
		       System.out.println("Количество подсобытий у основного события " + wedding.getName() + ": " + wedding.getSubEvents().size());

		       // Выполнение команды
		       bookingSystem.executeCommand(printScheduleCommand);
			}
	}


