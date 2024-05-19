package baseclasses.events;

import java.util.ArrayList;
import java.util.List;
import baseclasses.Booking;
import baseclasses.venues.VenueInterface;
import baseclasses.workers.Worker;
import observer.EventObserver;

public class CompositeEvent implements EventComponent {
	private List<EventComponent> components = new ArrayList<>();
	private List<EventObserver> observers = new ArrayList<>();
	private String name;
	private VenueInterface venue;
	private Booking Book;

	public CompositeEvent(String name) {
		this.name = name;
	}

//Методы для работы с Booking
	public Booking getBook() {
		return Book;
	}

	public void setBook(Booking book) {
		Book = book;
	}

//Методы для работы с локацией
	public VenueInterface getVenue() {
		return venue;
	}

	public void setVenue(VenueInterface venue) {
		this.venue = venue;
	}

//Поиск локации в общей куче
	private EventComponent checkVenue() {
		for (EventComponent component : components) {
			if (component instanceof VenueInterface) {
				return component;
			}
		}
		return null;
	}

//Методы для добавления элементов событий
	public void add(EventComponent component) {
		components.add(component);
	}

	public void add(List<EventComponent> componentList) {
		components.addAll(componentList);
	}

//Метод для удаления элемента события
	public void remove(EventComponent component) {
		components.remove(component);
	}

//Методы для добавления и удаления наблюдателей-гостей
	public void addObserver(EventObserver observer) {
		observers.add(observer);
	}

	public void addObserver(List<EventObserver> observer) {
		observers.addAll(observer);
	}

	public void removeObserver(EventObserver observer) {
		observers.remove(observer);
	}

//Метод для вывода в консоль информации
	public void display() {
		System.out.println(name);
		for (EventComponent component : components) {
			component.display();
		}
	}

//Метод для оповещения гостей (оповещения работников хромает.......)
	public void notifyObservers() {
		Booking book = (Booking) this.getBook();
		VenueInterface venue = (VenueInterface) this.getVenue();
		for (EventObserver observer : observers) {
			observer.update(name, book, venue);
		}

		for (EventComponent component : components) {
			if (component instanceof Worker) {
				Worker worker1 = (Worker) component;
				worker1.update(name, venue);

			}
		}
	}

	@Override
	public String getName() {
		return name;
	}
}