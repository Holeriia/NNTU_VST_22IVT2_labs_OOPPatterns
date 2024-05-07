package classes;

import java.util.ArrayList;
import java.util.List;

public class CompositeEvent implements EventComponent {
	 private List<EventComponent> components = new ArrayList<>();
	 private String name;

	 public CompositeEvent(String name) {
	     this.name = name;
	 }

	 public void add(EventComponent component) {
	     components.add(component);
	 }

	 public void remove(EventComponent component) {
	     components.remove(component);
	 }

	 public void display() {
	     System.out.println(name);
	     for (EventComponent component : components) {
	         component.display();
	     }
	 }

//	@Override
//	public void addGuest(Guest guest) {
//        for (EventComponent component : components) {
//            component.addGuest(guest);
//        }
//    }
}