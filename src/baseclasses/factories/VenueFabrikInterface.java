package baseclasses.factories;

import baseclasses.venues.VenueInterface;
import baseclasses.venues.Type_Venue;

//Фабричный метод
public interface VenueFabrikInterface {
	public VenueInterface createVenue();
	public VenueInterface createVenue(String name, int copasity, Type_Venue Type);
}
