package decorators;

import baseclasses.venues.Location;

import java.util.List;

import baseclasses.events.EventComponent;


public class LocationDecorator extends EventDecorator {
    private Location location;

    public LocationDecorator(EventComponent decoratedEvent) {
        super(decoratedEvent);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public void display() {
        super.display();
        if (location != null) {
            System.out.println("Локация: " + location.getName());
        }
    }
    
    public List<EventComponent> getSubEvents() {
        return component.getSubEvents();
    }
}
