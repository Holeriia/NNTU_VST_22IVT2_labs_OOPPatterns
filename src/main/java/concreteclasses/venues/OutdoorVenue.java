package concreteclasses.venues;

import baseclasses.venues.LocationType;

public class OutdoorVenue implements LocationType {
    @Override
    public String getType() {
        return "Outdoor Venue";
    }
}
