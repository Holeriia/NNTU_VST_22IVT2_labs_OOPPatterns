package concreteclasses.venuefactories;

import baseclasses.factories.VenueFabrikInterface;
import baseclasses.venues.Type_Venue;
import baseclasses.venues.VenueInterface;
import concreteclasses.venues.Closed_Venue;


public class Closed_VenueFabrik implements VenueFabrikInterface{
	
//конструктор для закрытой площадки
	public VenueInterface createVenue(){
		return new Closed_Venue();
	}

	@Override
	public VenueInterface createVenue(String name, int copasity, Type_Venue Type) {
		// TODO Auto-generated method stub
		return null;
	}
}

