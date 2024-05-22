package baseclasses.factories;

import baseclasses.workers.Worker;
import concreteclasses.workers.Fireworks_Master;
import concreteclasses.workers.Photographer;

public interface WorkerFactory {
    Worker createWorker(String name);
}
