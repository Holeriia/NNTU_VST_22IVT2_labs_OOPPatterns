package event;

import java.util.ArrayList;
import java.util.List;

public class Fireworks implements EventComponent{
	private String name;
	private int duration;
	private List<EventComponent> components;
	
	public Fireworks(int duration) {
		super();
		this.name = "Фейверк";
		this.duration = duration;
	}
	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public void display() {
		System.out.println("Event{" + name + " duration: " + duration + "}");
		if(components != null) {
			for (EventComponent component : components) {
		         component.display();
		     }
		}
	}
	@Override
	public void add(EventComponent component) {
		if(components == null) {
			components = new ArrayList<>();
		}
		components.add(component);
		
	}
	@Override
	public void remove(EventComponent component) {
		if(components != null) {
			components.remove(component);
		}
		
	}


	

}
