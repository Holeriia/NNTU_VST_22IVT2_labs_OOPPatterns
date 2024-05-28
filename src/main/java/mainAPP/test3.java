package mainAPP;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import baseclasses.events.CompositeEvent;
import baseclasses.events.EventComponent;
import baseclasses.events.SimpleEvent;
import observer.Editor;
import baseclasses.Booking;

import baseclasses.guests.Guest;
import baseclasses.orders.Order;
import baseclasses.orders.StatusType;
import decorators.GuestDecorator;

import baseclasses.venues.Location;
import decorators.LocationDecorator;
import baseclasses.venues.LocationType;
import concreteclasses.venues.WeddingHall;
import concreteclasses.venues.OutdoorVenue;

import baseclasses.workers.Worker;
import decorators.WorkerDecorator;
import baseclasses.workers.WorkerType;
import command.BookingSystem;
import command.Command;
import command.concretecommands.ChangeMainEventCommand;
import command.concretecommands.CreateOrderCommand;
import command.concretecommands.PrintScheduleCommand;
import command.concretecommands.RemoveMainEventCommand;
import concreteclasses.workers.Fireworks_Master;
import concreteclasses.workers.Photographer;

import baseclasses.factories.EventFactory;

import concreteclasses.eventfactories.*;
import concreteclasses.statusTypes.Active;
import concreteclasses.venuefactories.WeddingHallFactory;

public class test3 {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Создание редактора
		Editor editor =context.getBean("editor", Editor.class);

        // Создание фабрик и событий
		CeremonyFactory ceremonyFactory =context.getBean("ceremonyFactory", CeremonyFactory.class);
		BanquetFactory banquetFactory = context.getBean("banquetFactory", BanquetFactory.class);
		PhotoSessionFactory photoSessionFactory = context.getBean("photoSessionFactory", PhotoSessionFactory.class);
				
				
        EventComponent ceremony = ceremonyFactory.createEvent();
        EventComponent banquet = banquetFactory.createEvent();
        EventComponent photoSession = photoSessionFactory.createEvent();
              
        Guest guest1 = context.getBean("guest", Guest.class);
        Guest guest2 = context.getBean("guest", Guest.class);
        guest1.setName("Иван Иванов");
        guest2.setName("Леруа Мерлен");
        List<Guest> guests = Arrays.asList(guest1, guest2);

        editor.addGuestsToEvent(banquet, guests);

        // Создание работника и типа работника
        WorkerType photographerType = new Photographer();
        Worker worker2 = context.getBean("worker", Worker.class);
        worker2.setName("Самый четкий работник");
        worker2.setTypeWorker(photographerType);

        //Создание локации и типа локации
        WeddingHallFactory weddingHallFactory = context.getBean("weddingHallFactory", WeddingHallFactory.class);
        Location weddingHall = weddingHallFactory.createLocation("Место венчания", 200);

        // Создание бронирования
        LocalDateTime start = LocalDateTime.of(2024, 5, 10, 10, 0);
        LocalDateTime end = LocalDateTime.of(2024, 5, 10, 12, 0);
        Booking booking = context.getBean("booking", Booking.class);
        booking.setStartTime(start);
        booking.setEndTime(end);
        booking.setEvent(photoSession);
       
        // Назначение работника и мероприятия на событие
        editor.bookEventForWorker(booking, photographerType, worker2);
        editor.bookEventForLocation(booking, weddingHall.getType(), weddingHall);

        // Отображение активных бронирований
        worker2.showActiveBookings();
        weddingHall.showActiveBookings();
        
        // Пример отображения
       // CompositeEvent wedding = new CompositeEvent("Свадьба");
        
        CompositeEvent wedding = context.getBean("compositeEvent", CompositeEvent.class);
        wedding.setName("Свадьба");
        wedding.add(ceremony);
        wedding.add(banquet);
        wedding.add(photoSession);
       
        BookingSystem bookingSystem = context.getBean("bookingSystem", BookingSystem.class);
        StatusType activeStatus =  context.getBean("active", Active.class);


       // Создание команды для создания заказа
       Command createOrderCommand = new CreateOrderCommand(bookingSystem, "Заказ 1", wedding, "Валерия Серова", LocalDateTime.now(), activeStatus);
       bookingSystem.executeCommand(createOrderCommand);

       // Получаем созданный заказ из списка заказов
       Order order = bookingSystem.getOrders().get(0);

       // Создание команды для изменения основного мероприятия заказа
       CompositeEvent newEvent = context.getBean("compositeEvent", CompositeEvent.class);
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