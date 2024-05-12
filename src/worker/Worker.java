package worker;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Booking.Booking;
import event.EventComponent;

public abstract class Worker implements EventComponent{
	protected String name;
	protected String TypeWorker;
	protected List<Booking> list  = new ArrayList<>();
	protected List<EventComponent> components;
	
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
}
