package concreteclasses.venuefactories;

import baseclasses.venues.Location;
import concreteclasses.venues.OutdoorVenue;

public class OutdoorVenueFactory {
	
	public OutdoorVenueFactory() {
		super();
	}

	public Location createLocation(String name, int capacity) {
        return new Location(name, new OutdoorVenue(), capacity);
    }
}
