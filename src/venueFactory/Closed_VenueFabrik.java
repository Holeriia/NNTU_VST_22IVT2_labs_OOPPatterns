package venueFactory;
import venue.Closed_Venue;
import venue.Type_Venue;
import venue.VenueInterface;

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

