package NNTU_VST_22IVT2_OOPPatterns;

import event.Banquet;
import event.CompositeEvent;
import event.EventComponent;
import event.Fireworks;
import eventFactory.EventFactory;
import eventFactory.WeddingFactory;
import venue.Type_Venue;
import venue.VenueInterface;
import venueFactory.Castom_VenueFabrik;
import venueFactory.Closed_VenueFabrik;
import venueFactory.Open_VenueFabrik;
import venueFactory.VenueFabrikInterface;
import worker.Phtographer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Booking.Booking;
import Guest.EventObserver;
import Guest.Guest;

public class main_app {

	public static void main(String[] args) {
		
		CompositeEvent e = new CompositeEvent("Wedding");
		EventComponent e1 = new Fireworks(123);
		EventComponent e2 = new Banquet(58);
		Phtographer ph = new Phtographer("Bad");
		
		LocalDateTime start = LocalDateTime.of(2024, 5, 10, 10, 0);
		LocalDateTime end = LocalDateTime.of(2024, 5, 10, 12, 0);
	    Booking event = new Booking(start, end, e1);
	    
	    ph.addBooking(event);
		
	    e.setBook(event);
	    VenueFabrikInterface fabric3 = new Castom_VenueFabrik();
	    VenueInterface venue2 = fabric3.createVenue("Килька бар", 1000, Type_Venue.Closed);
		e.setVenue(venue2);
		//System.out.print(e.getVenue().getname());
		
		e.add(e1);		
		e.add(e2);
		e.add(ph);
		//e.display();
//		ph.checkBooking();
		
		List<EventObserver> guests = new ArrayList<>();
		// Создание нескольких гостей в цикле
        for (int i = 1; i <= 5; i++) {
            Guest guest = new Guest("Гость " + i);
            guests.add(guest);
        }
        
        e.addObserver(guests);
        e.notifyObservers();
	
		
////Создание помещений пример:
//		VenueFabrikInterface fabric = new Open_VenueFabrik();
//		EventComponent venue = fabric.createVenue();
//		venue.display();
//		
//		VenueFabrikInterface fabric1 = new Closed_VenueFabrik();
//		EventComponent venue1 = fabric1.createVenue();
//		venue1.display();
//		
//		VenueFabrikInterface fabric3 = new Castom_VenueFabrik();
//		EventComponent venue2 = fabric3.createCastomVenue("Килька бар", 1000, Type_Venue.Closed);
//		venue2.display();
		

	
	
//    // Пример использования класса Booking
//    LocalDateTime start = LocalDateTime.of(2024, 5, 10, 10, 0);
//    LocalDateTime end = LocalDateTime.of(2024, 5, 10, 12, 0);
//    Booking event = new Booking(start, end, venue2);
//    System.out.println("Event details: " + event);	
//	
	}	
}