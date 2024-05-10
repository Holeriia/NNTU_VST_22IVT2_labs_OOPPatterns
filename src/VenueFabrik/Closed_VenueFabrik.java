package VenueFabrik;
import Venue.Closed_Venue;
import Venue.Type_Venue;
import Venue.VenueInterface;

public class Closed_VenueFabrik implements VenueFabrikInterface{
	public VenueInterface createVenue(){
		return new Closed_Venue();
	}

	@Override
	public VenueInterface createCastomVenue(String name, int copasity, Type_Venue Type) {
		// TODO Auto-generated method stub
		return null;
	}
}

