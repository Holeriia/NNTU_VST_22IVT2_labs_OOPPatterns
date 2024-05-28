package concreteclasses.workers;

import baseclasses.workers.WorkerType;

public class Officiant implements WorkerType {
   
	
    public Officiant() {
		super();
	}

	public String getType() {
        return "Officiant";
    }
}
