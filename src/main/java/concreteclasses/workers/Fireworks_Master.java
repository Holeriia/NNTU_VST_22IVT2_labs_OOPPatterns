package concreteclasses.workers;

import baseclasses.workers.WorkerType;

public class Fireworks_Master implements WorkerType{

	
	public Fireworks_Master() {
	}

	@Override
    public String getType() {
        return "Fireworks Master";
    }	
}
