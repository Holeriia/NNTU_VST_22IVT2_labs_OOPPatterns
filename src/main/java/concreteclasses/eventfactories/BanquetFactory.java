package concreteclasses.eventfactories;

import baseclasses.events.EventComponent;
import baseclasses.events.SimpleEvent;
import baseclasses.factories.EventFactory;
import baseclasses.workers.Worker;
import concreteclasses.workerfactories.ChefFactory;
import decorators.GuestDecorator;
import decorators.LocationDecorator;
import decorators.WorkerDecorator;

public class BanquetFactory implements EventFactory {
	
    public BanquetFactory() {
		super();
	}

	@Override
    public EventComponent createEvent() {
        SimpleEvent banquet = new SimpleEvent("Банкет");

        // Decorate the event with the location
        LocationDecorator locationDecorator = new LocationDecorator(banquet);
        WorkerDecorator workerDecorator = new WorkerDecorator(locationDecorator);
        GuestDecorator guestDecorator = new GuestDecorator(workerDecorator);

        ChefFactory chefFactory = new ChefFactory();
        Worker actualChef = chefFactory.createWorker("");

        workerDecorator.add(actualChef);

        // Return the top-most decorator
        return guestDecorator;
    }
}
