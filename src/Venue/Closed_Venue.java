package Venue;

import classes.EventComponent;

public class Closed_Venue extends VenueInterface{
	
	public Closed_Venue() {
		this.capacity = 100;
		this.name = "Какая-то площадка";
		this.Type = Type_Venue.Closed;
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
