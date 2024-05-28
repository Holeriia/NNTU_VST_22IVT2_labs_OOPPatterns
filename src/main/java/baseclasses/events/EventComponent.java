package baseclasses.events;

import java.util.List;

//Интерфейс компонента
public interface EventComponent {
	void display();
	void add(EventComponent component);
	void remove(EventComponent component);
	String getName();
	List<EventComponent> getSubEvents();
}