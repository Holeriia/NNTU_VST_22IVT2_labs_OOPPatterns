package concreteclasses.workers;

import baseclasses.workers.WorkerType;

public class Photographer implements WorkerType {
    @Override
    public String getType() {
        return "Photographer";
    }
}
