package concreteclasses.venuefactories;

import baseclasses.venues.Location;
import concreteclasses.venues.OutdoorVenue;

public class OutdoorVenueFactory {
	public Location createLocation(String name, int capacity) {
        return new Location(name, new OutdoorVenue(), capacity);
    }
}
