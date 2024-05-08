package VenueFabrik;
import Venue.Closed_Venue;
import Venue.VenueInterface;

public class Closed_VenueFabrik implements VenueFabrikInterface{
	public VenueInterface createVenue(){
		return new Closed_Venue();
	}
}

