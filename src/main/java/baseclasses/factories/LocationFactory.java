package baseclasses.factories;

import baseclasses.venues.Location;

public interface LocationFactory {
    Location createLocation(String name, int capacity);
}