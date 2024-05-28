package concreteclasses.eventfactories;

import baseclasses.events.EventComponent;
import baseclasses.events.SimpleEvent;
import baseclasses.factories.EventFactory;
import baseclasses.venues.Location;
import baseclasses.workers.Worker;
import concreteclasses.venuefactories.OutdoorVenueFactory;
import concreteclasses.venuefactories.WeddingHallFactory;
import concreteclasses.workerfactories.FireworksMasterFactory;
import decorators.GuestDecorator;
import decorators.LocationDecorator;
import decorators.WorkerDecorator;
import baseclasses.workers.WorkerType;
import concreteclasses.workers.Fireworks_Master;
import concreteclasses.workers.Photographer;

public class PhotoSessionFactory implements EventFactory {
    @Override
    public EventComponent createEvent() {
        SimpleEvent photoSession = new SimpleEvent("Фотосессия");

        // Decorate the event with the location
        LocationDecorator locationDecorator = new LocationDecorator(photoSession);
        WorkerDecorator workerDecorator = new WorkerDecorator(locationDecorator);

        WorkerType photographerType = new Photographer();
        Worker actualPhotographer = new Worker("", photographerType);
        
        WeddingHallFactory weddingHallFactory = new WeddingHallFactory();
        Location weddingHall = weddingHallFactory.createLocation("", 0);

        locationDecorator.setLocation(weddingHall);
        workerDecorator.add(actualPhotographer);

        // Return the top-most decorator
        return workerDecorator;
    }
}