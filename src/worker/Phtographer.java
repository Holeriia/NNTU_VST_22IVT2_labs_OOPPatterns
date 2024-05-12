package worker;
import java.util.ArrayList;
import java.util.List;

import Booking.Booking;
import event.EventComponent;

public class Phtographer extends Worker {
	
	public Phtographer(String name) {
		super();
		this.name = name;
		TypeWorker = "Фотографф";
	}
	public void addBooking(Booking book) {
		list.add(book);		
	}
	public void removeBooking(Booking book) {
		list.remove(book);		
	}
	
	public void checkBooking() {
		for (Booking component : list) {
	         System.out.println(component);
	     }
	}

	@Override
	public void display() {
		System.out.println(TypeWorker + " " + name);
		if(components != null) {
			for (EventComponent component : components) {
		         component.display();
		     }
		}
		
	}
	


	
}
