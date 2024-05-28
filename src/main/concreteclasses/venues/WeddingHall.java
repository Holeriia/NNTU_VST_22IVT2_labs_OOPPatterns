package concreteclasses.venues;

import baseclasses.venues.LocationType;

public class WeddingHall implements LocationType {
    @Override
    public String getType() {
        return "Wedding Hall";
    }
}
