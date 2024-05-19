package concreteclasses.venues;

import baseclasses.venues.Type_Venue;
import baseclasses.venues.VenueInterface;

public class Open_Venue extends VenueInterface{

//Конструктор	
	public Open_Venue() {
		this.capacity = 100;
		this.name = "Какая-то площадка 1";
		this.Type = Type_Venue.Open;
	}
}
