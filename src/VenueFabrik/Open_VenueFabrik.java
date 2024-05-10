package VenueFabrik;
import Venue.Open_Venue;
import Venue.Type_Venue;
import Venue.VenueInterface;

public class Open_VenueFabrik implements VenueFabrikInterface{
	public VenueInterface createVenue(){
		return new Open_Venue();
	}

	@Override
	public VenueInterface createCastomVenue(String name, int copasity, Type_Venue Type) {
		// TODO Auto-generated method stub
		return null;
	}
}

