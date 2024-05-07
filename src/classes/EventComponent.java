package classes;

//Интерфейс компонента
public interface EventComponent {
	void add(EventComponent component);
	void remove(EventComponent component);
	void display();
	
	//void addGuest(Guest guest);
}