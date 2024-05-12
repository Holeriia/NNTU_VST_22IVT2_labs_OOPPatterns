package workerFactory;

import worker.Fireworks_Master;
import worker.Phtographer;

public abstract class Worker_Factory {
	abstract Phtographer createPhtographer(String name);
	abstract Fireworks_Master createFireworks_Master(String name);	
}
