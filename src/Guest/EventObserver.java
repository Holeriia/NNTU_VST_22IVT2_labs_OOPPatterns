package Guest;

import Booking.Booking;
import event.EventComponent;
import venue.VenueInterface;

//интерфейс наблюдателей
public interface EventObserver {
	void update(String eventName, Booking book, VenueInterface venue);

}
