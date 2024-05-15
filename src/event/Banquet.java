package event;

import java.util.ArrayList;
import java.util.List;

public class Banquet implements EventComponent{
	private String name;						//название события
	private int number_of_guests;				//количество гостей
	private List<EventComponent> components;
	
//конструктор
	public Banquet(int number_of_guests) {
		super();
		this.name = "Банкет";
		this.number_of_guests = number_of_guests;
	}

//Геттеры и сетторы
	public String getName() {
		return name;
	}

	public int getNumber_of_guests() {
		return number_of_guests;
	}

	public void setNumber_of_guests(int number_of_guests) {
		this.number_of_guests = number_of_guests;
	}
	


	
	
//Переопределение методов интерфейса
	@Override
	public void display() {
		System.out.println("Event{" + name + " number of guests: " + number_of_guests + "}");		
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
