package worker;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import Booking.Booking;
import event.EventComponent;
import venue.VenueInterface;


public abstract class Worker implements EventComponent {
	protected String name;
	protected String TypeWorker;
	protected List<Booking> list  = new ArrayList<>();
	protected List<EventComponent> components;
   
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //не трогать(форматирование )

	
// Метод для проверки возможности бронирования в определенное время
    public boolean isBookingAvailable(LocalDateTime startTime, LocalDateTime endTime) {
        for (Booking booking : list) {
            if (booking.getStartTime().isBefore(endTime) && booking.getEndTime().isAfter(startTime)) {
                // Время бронирования пересекается с уже существующим бронированием
            	System.out.println("Время совпадает с другим бронированием:" + booking);
                return false;
            }
        }
        // Нет пересечений с существующими бронированиями
        return true;
    }
    
	public void add(EventComponent component) {
		if(components == null) {
			components = new ArrayList<>();
		}
		components.add(component);
		
	}
	public void remove(EventComponent component) {
		if(components != null) {
			components.remove(component);
		}
		
	}
	@Override
	public String getName() {
		return name;
	}
//Геттер последнего события в списке
	public static <T> T getLastElement(List<T> list) {
        if (list.isEmpty()) {
            return null; // Возвращаем null, если список пуст
        }
        return list.get(list.size() - 1); // Возвращаем последний элемент
    }
//Метод для добавлени бронирования
	public void addBooking(Booking book) {
		list.add(book);		
	}
	public void removeBooking(Booking book) {
		list.remove(book);		
	}
	
//Метод для вывода всей брони у рабочего
	public void checkBooking() {
		for (Booking component : list) {
	         System.out.println(component);
	     }
	}
	
//Метод для оповещения рабочих
	 public void update(String eventName,VenueInterface venue) {
		 Booking book = getLastElement(list);
		 EventComponent event = book.getEvent();
		 

	        System.out.println("Уважаемый " + name + ", вам назначена работа " + event.getName() + 
	        		" которое будет проходить c " + book.getStartTime().format(formatter) + " по " + book.getEndTime().format(formatter) 
	        		+ " на площадке: " + venue.getname() );
	    }

	 
		public void display() {
			System.out.println(TypeWorker + " " + name);
//			if(components != null) {
//				for (EventComponent component : components) {
//			         component.display();
//			     }
//			}
			
		}
}
