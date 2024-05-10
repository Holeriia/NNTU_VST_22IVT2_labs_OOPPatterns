package NNTU_VST_22IVT2_OOPPatterns;

import classes.CompositeEvent;
import classes.Event;
import classes.EventComponent;
import factories.EventFactory;
import factories.WeddingFactory;
import VenueFabrik.VenueFabrikInterface;
import VenueFabrik.Open_VenueFabrik;
import Venue.Type_Venue;
import VenueFabrik.Castom_VenueFabrik;
import VenueFabrik.Closed_VenueFabrik;

public class main_app {

	public static void main(String[] args) {
		
		EventComponent e = new CompositeEvent("Wedding");
//		EventComponent e1 = new Event("Photosession");
//		EventComponent e2 = new Event("Eat");
//		e.add(e1);		
//		e.add(e2);
//		e.display();

		
//		 EventFactory weddingFactory = new WeddingFactory();
//
//	        // Создание свадьбы через фабрику
//	    EventComponent weddingEvent = weddingFactory.createEvent();
//
//	        // Добавление гостей к свадьбе
//	       // weddingEvent.addGuest(new Guest("John"));
//	        //weddingEvent.addGuest(new Guest("Alice"));
//
//	        // Отображение свадьбы
//	        weddingEvent.display();
		
		
//Создание помещений пример:
		VenueFabrikInterface fabric = new Open_VenueFabrik();
		EventComponent venue = fabric.createVenue();
		venue.display();
		
		VenueFabrikInterface fabric1 = new Closed_VenueFabrik();
		EventComponent venue1 = fabric1.createVenue();
		venue1.display();
		
		VenueFabrikInterface fabric3 = new Castom_VenueFabrik();
		EventComponent venue2 = fabric3.createCastomVenue("Килька бар", 1000, Type_Venue.Closed);
		venue2.display();
		

	}

}
