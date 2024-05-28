package decorators;

import java.util.ArrayList;
import java.util.List;

import baseclasses.events.EventComponent;
import baseclasses.workers.Worker;

public class WorkerDecorator extends EventDecorator{
	private List<Worker> workers = new ArrayList<>();

    public WorkerDecorator(EventComponent decoratedEvent) {
        super(decoratedEvent);
    }

    public void add(Worker worker) {
        workers.add(worker);
    }

    public void remove(Worker worker) {
        workers.remove(worker);
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Список специалистов: ");
        for (Worker worker : workers) {
            System.out.println("- " + worker.getName() + " (" + worker.getTypeWorker().getType() + ")");
        }
    }
    
    public List<EventComponent> getSubEvents() {
        return component.getSubEvents();
    }
}
