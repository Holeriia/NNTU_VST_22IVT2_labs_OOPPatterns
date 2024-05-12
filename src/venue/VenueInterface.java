package venue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Booking.Booking;
import event.EventComponent;

public abstract class VenueInterface implements EventComponent{

	protected String name;
	protected Type_Venue Type;
	protected int capacity;
	protected List<Booking> list = new ArrayList<>();
	protected List<EventComponent> components;
	
	public void addBooking(Booking book) {
		this.list.add(book);		
	}
	public void removeBooking(Booking book) {
		this.list.remove(book);		
	}
	
	public void display() {
		System.out.println("Площадка:" + name);
		System.out.println("Вместимость:" + capacity);
		System.out.println("Тип:" + Type);
		
		if(list.size()!=0) {
			for(int i = 0; i<list.size(); i++) {
			System.out.println("Время "+ i + "бронирования:" + list.get(i));
			}
		}
		if(components != null) {
			for (EventComponent component : components) {
		         component.display();
		     }
		}
		
	}
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
    
    @Override
	public void add(EventComponent component) {
		if(components == null) {
			components = new ArrayList<>();
		}
		components.add(component);
		
	}
	@Override
	public void remove(EventComponent component) {
		if(components != null) {
			components.remove(component);
		}
		
	}
	
	

}
