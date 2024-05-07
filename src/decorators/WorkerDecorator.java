package decorators;

import classes.EventComponent;
import classes.Worker;

public class WorkerDecorator implements EventComponent {
    private EventComponent decoratedEvent;
    private Worker worker;

    public WorkerDecorator(EventComponent decoratedEvent, Worker worker) {
        this.decoratedEvent = decoratedEvent;
        this.worker = worker;
    }

    public void add(EventComponent component) {
        decoratedEvent.add(component);
    }

    public void remove(EventComponent component) {
        decoratedEvent.remove(component);
    }

    public void display() {
        decoratedEvent.display();
        System.out.println("Добавлен работник: " + worker.getName() + ", профессия: " + worker.getType());
    }

//    public void addGuest(Guest guest) {
//        decoratedEvent.addGuest(guest);
//    }
}
