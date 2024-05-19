package baseclasses.factories;

import concreteclasses.workers.Fireworks_Master;
import concreteclasses.workers.Phtographer;

//конкретная фабрика для создания рабочих
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
