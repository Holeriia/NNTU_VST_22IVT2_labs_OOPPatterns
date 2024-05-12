package workerFactory;

import worker.Fireworks_Master;
import worker.Phtographer;

public class DefaultWorkerFactory extends Worker_Factory{


	@Override
	Phtographer createPhtographer(String name) {
		return new Phtographer(name);
	}

	@Override
	Fireworks_Master createFireworks_Master(String name) {
		return new Fireworks_Master(name);
	}

}
