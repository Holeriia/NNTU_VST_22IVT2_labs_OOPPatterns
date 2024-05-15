package event;

//Интерфейс компонента
public interface EventComponent {

	void display();
	void add(EventComponent component);
	void remove(EventComponent component);
	String getName();
	
}