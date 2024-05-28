package concreteclasses.venuefactories;

import baseclasses.venues.Location;
import concreteclasses.venues.WeddingHall;

public class WeddingHallFactory {
	public Location createLocation(String name, int capacity) {
        return new Location(name, new WeddingHall(), capacity);
    }
}
