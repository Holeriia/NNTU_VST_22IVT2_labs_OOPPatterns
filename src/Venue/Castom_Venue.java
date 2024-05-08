package Venue;
import classes.EventComponent;

public class Castom_Venue  extends VenueInterface{

	
	public Castom_Venue() {}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setCopacity(int copasity) {
		this.capacity = copasity;
	}
	public void setType(Type_Venue Type) {
		this.Type = Type;
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
