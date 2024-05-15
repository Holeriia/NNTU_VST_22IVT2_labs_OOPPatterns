package venue;

import Booking.Booking;
import event.EventComponent;

public class Closed_Venue extends VenueInterface{
	
//Конструктор
	public Closed_Venue() {
		this.capacity = 100;
		this.name = "Какая-то площадка 2";
		this.Type = Type_Venue.Closed;
	}
}
