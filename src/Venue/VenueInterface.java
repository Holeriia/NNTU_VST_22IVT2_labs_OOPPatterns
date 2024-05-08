package Venue;

import classes.EventComponent;

public abstract class VenueInterface implements EventComponent{

	protected String name;
	protected Type_Venue Type;
	protected int capacity;
	
	public void display() {
		System.out.println("Площадка:" + name);
		System.out.println("Вместимость:" + capacity);
		System.out.println("Тип:" + Type);
	}
	
	

}
