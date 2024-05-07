package NNTU_VST_22IVT2_OOPPatterns;

import classes.CompositeEvent;
import classes.Event;
import classes.EventComponent;
import factories.EventFactory;
import factories.WeddingFactory;

public class main_app {

	public static void main(String[] args) {
		
//		EventComponent e = new CompositeEvent("Wedding");
//		EventComponent e1 = new Event("Photosession");
//		EventComponent e2 = new Event("Eat");
//		e.add(e1);		
//		e.add(e2);
//		e.display();
//		EventComponent e0 = new CompositeEvent("start");
//		e0.add(e);
//		e0.display();
//		System.out.println();
		
		 EventFactory weddingFactory = new WeddingFactory();

	        // Создание свадьбы через фабрику
	    EventComponent weddingEvent = weddingFactory.createEvent();

	        // Добавление гостей к свадьбе
	       // weddingEvent.addGuest(new Guest("John"));
	        //weddingEvent.addGuest(new Guest("Alice"));

	        // Отображение свадьбы
	        weddingEvent.display();
	}

}
