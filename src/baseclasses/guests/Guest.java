package baseclasses.guests;

import java.time.format.DateTimeFormatter;

import baseclasses.Booking;
import baseclasses.venues.VenueInterface;
import observer.EventObserver;


public class Guest implements EventObserver{
	private String name;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //не трогать(форматирование )

//Конструктор
	public Guest(String name) {
		super();
		this.name = name;
	}
//Оповещение гостей
	@Override
	public void update(String eventName, Booking book, VenueInterface venue) {
		System.out.println("Уважаемый " + name + ", вы приглашены на мероприятие'" + eventName + 
	    " которое будет проходить c " + book.getStartTime().format(formatter) + " по " + book.getEndTime().format(formatter) + " на площадке: " + venue.getname() );
	    }
	}

