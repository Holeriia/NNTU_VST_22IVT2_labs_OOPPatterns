package concreteclasses.venuefactories;

import baseclasses.factories.VenueFabrikInterface;
import baseclasses.venues.Type_Venue;
import baseclasses.venues.VenueInterface;
import concreteclasses.venues.Open_Venue;


public class Open_VenueFabrik implements VenueFabrikInterface{
//конструктор для открытой площадки
	public VenueInterface createVenue(){
		return new Open_Venue();
	}

	@Override
	public VenueInterface createVenue(String name, int copasity, Type_Venue Type) {
		// TODO Auto-generated method stub
		return null;
	}
}

