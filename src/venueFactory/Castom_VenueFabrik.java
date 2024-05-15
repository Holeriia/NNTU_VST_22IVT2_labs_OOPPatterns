package venueFactory;

import venue.Castom_Venue;
import venue.Type_Venue;
import venue.VenueInterface;

public class Castom_VenueFabrik implements VenueFabrikInterface{
	
//Конструктор для площадки которая не включена в основной список площадок компании
	public VenueInterface createVenue(String name, int copasity, Type_Venue Type){
		Castom_Venue venue = new Castom_Venue();
		venue.setName(name);
		venue.setCopacity(copasity);
		venue.setType(Type);
		return venue;
	}

	@Override
	public VenueInterface createVenue() {
		// TODO Auto-generated method stub
		return null;
	}

}
