package concreteclasses.workers;

import baseclasses.workers.WorkerType;

public class Photographer implements WorkerType {
	
    public Photographer() {
		super();
	}

	@Override
    public String getType() {
        return "Photographer";
    }
}
