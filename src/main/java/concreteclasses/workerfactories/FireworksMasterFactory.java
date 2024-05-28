package concreteclasses.workerfactories;

import baseclasses.factories.WorkerFactory;
import baseclasses.workers.Worker;
import concreteclasses.workers.Fireworks_Master;

public class FireworksMasterFactory implements WorkerFactory{
	
	public FireworksMasterFactory() {
	}

	public Worker createWorker(String name) {
        return new Worker(name, new Fireworks_Master());
    }
}
