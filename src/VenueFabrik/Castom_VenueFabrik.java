package VenueFabrik;

import Venue.Castom_Venue;
import Venue.Type_Venue;
import Venue.VenueInterface;

public class Castom_VenueFabrik implements VenueFabrikInterface{
	
	public VenueInterface createCastomVenue(String name, int copasity, Type_Venue Type){
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
