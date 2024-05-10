package VenueFabrik;
import Venue.Type_Venue;
import Venue.VenueInterface;

public interface VenueFabrikInterface {
	public VenueInterface createVenue();
	public VenueInterface createCastomVenue(String name, int copasity, Type_Venue Type);

}
