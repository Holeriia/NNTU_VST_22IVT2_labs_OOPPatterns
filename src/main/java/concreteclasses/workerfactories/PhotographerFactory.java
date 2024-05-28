package concreteclasses.workerfactories;

import baseclasses.workers.Worker;
import concreteclasses.workers.Photographer;

public class PhotographerFactory {
	
	public PhotographerFactory() {
		super();
	}

	public Worker createWorker(String name) {
        return new Worker(name, new Photographer());
    }
}
