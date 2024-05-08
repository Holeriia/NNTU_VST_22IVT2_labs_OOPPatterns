package VenueFabrik;
import Venue.Open_Venue;
import Venue.VenueInterface;

public class Open_VenueFabrik implements VenueFabrikInterface{
	public VenueInterface createVenue(){
		return new Open_Venue();
	}
}

