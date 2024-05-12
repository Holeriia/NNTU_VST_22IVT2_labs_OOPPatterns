package venueFactory;
import venue.Type_Venue;
import venue.VenueInterface;

public interface VenueFabrikInterface {
	public VenueInterface createVenue();
	public VenueInterface createCastomVenue(String name, int copasity, Type_Venue Type);

}
