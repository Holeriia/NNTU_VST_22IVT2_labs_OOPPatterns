package venue;

import java.util.List;

import Booking.Booking;
import event.EventComponent;

public class Open_Venue extends VenueInterface{

//Конструктор	
	public Open_Venue() {
		this.capacity = 100;
		this.name = "Какая-то площадка 1";
		this.Type = Type_Venue.Open;
	}
}
