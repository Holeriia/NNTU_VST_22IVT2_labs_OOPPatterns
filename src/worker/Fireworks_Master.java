package worker;

import java.util.ArrayList;
import java.util.List;

import Booking.Booking;
import event.EventComponent;

public class Fireworks_Master extends Worker{
	
	public Fireworks_Master(String name) {
		super();
		this.name = name;
		TypeWorker = "Фейверк-мастер";
	}
	public void addBooking(Booking book) {
		list.add(book);		
	}
	public void removeBooking(Booking book) {
		list.remove(book);		
	}
	@Override
	public void display() {
		System.out.println(TypeWorker + name);
		if(components != null) {
			for (EventComponent component : components) {
		         component.display();
		     }
		}
		
	}
}
