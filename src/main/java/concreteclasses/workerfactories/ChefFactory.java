package concreteclasses.workerfactories;

import baseclasses.factories.WorkerFactory;
import baseclasses.workers.Worker;
import concreteclasses.workers.Chef;

public class ChefFactory implements WorkerFactory {
	
    public ChefFactory() {
		super();
	}

	@Override
    public Worker createWorker(String name) {
        return new Worker(name, new Chef());
    }
}
