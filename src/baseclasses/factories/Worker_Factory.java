package baseclasses.factories;

import concreteclasses.workers.Fireworks_Master;
import concreteclasses.workers.Phtographer;

//Абстрактная фабрика для создания рабочих
public abstract class Worker_Factory {
	abstract Phtographer createPhtographer(String name);
	abstract Fireworks_Master createFireworks_Master(String name);	
}
