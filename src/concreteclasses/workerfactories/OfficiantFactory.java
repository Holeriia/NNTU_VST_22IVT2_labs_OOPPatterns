package concreteclasses.workerfactories;

import baseclasses.factories.WorkerFactory;
import baseclasses.workers.Worker;
import concreteclasses.workers.Officiant;

public class OfficiantFactory implements WorkerFactory {
    @Override
    public Worker createWorker(String name) {
        return new Worker(name, new Officiant());
    }
}