package Venue;

import classes.EventComponent;

public class Open_Venue extends VenueInterface{

	
	public Open_Venue() {
		this.capacity = 100;
		this.name = "Какая-то площадка";
		this.Type = Type_Venue.Open;
	}
	
	
	@Override
	public void add(EventComponent component) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(EventComponent component) {
		// TODO Auto-generated method stub
		
	}	
}
