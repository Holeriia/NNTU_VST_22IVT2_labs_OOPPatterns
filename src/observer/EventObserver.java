package observer;

import baseclasses.Booking;
import baseclasses.venues.VenueInterface;

//интерфейс наблюдателей
public interface EventObserver {
	void update(String eventName, Booking book, VenueInterface venue);
}
