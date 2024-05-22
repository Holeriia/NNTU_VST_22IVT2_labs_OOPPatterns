package concreteclasses.eventfactories;

import baseclasses.events.EventComponent;
import baseclasses.events.SimpleEvent;
import baseclasses.factories.EventFactory;
import baseclasses.venues.Location;
import baseclasses.workers.Worker;
import concreteclasses.venuefactories.OutdoorVenueFactory;
import concreteclasses.venuefactories.WeddingHallFactory;
import concreteclasses.workerfactories.FireworksMasterFactory;
import concreteclasses.workerfactories.OfficiantFactory;
import decorators.GuestDecorator;
import decorators.LocationDecorator;
import decorators.WorkerDecorator;

public class CeremonyFactory implements EventFactory {
    @Override
    public EventComponent createEvent() {
        SimpleEvent ceremony = new SimpleEvent("Церемония");

        // Decorate the event with the location
        LocationDecorator locationDecorator = new LocationDecorator(ceremony);
        WorkerDecorator workerDecorator = new WorkerDecorator(locationDecorator);
        GuestDecorator guestDecorator = new GuestDecorator(workerDecorator);

        OfficiantFactory officiantFactory = new OfficiantFactory();
        Worker actualOfficiant = officiantFactory.createWorker("");

        workerDecorator.add(actualOfficiant);

        // Return the top-most decorator
        return guestDecorator;
    }
}