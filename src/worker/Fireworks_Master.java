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
	
	
}