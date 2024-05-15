package venueFactory;
import venue.Type_Venue;
import venue.VenueInterface;

//Фабричный метод
public interface VenueFabrikInterface {
	public VenueInterface createVenue();
	public VenueInterface createVenue(String name, int copasity, Type_Venue Type);

}
