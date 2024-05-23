package baseclasses.events;

import java.util.ArrayList;
import java.util.List;

public class CompositeEvent implements EventComponent {
    private String name;
    private List<EventComponent> subEvents;

    public CompositeEvent(String name) {
        this.name = name;
        this.subEvents = new ArrayList<>();
    }
    @Override
    public void add(EventComponent event) {
        subEvents.add(event);
    }
    @Override
    public void remove(EventComponent event) {
        subEvents.remove(event);
    }

    @Override
    public void display() {
        System.out.print(name);
        System.out.print("  ");
        for (EventComponent event : subEvents) {
            event.display();
        }
    }
    
    public List<EventComponent> getSubEvents() {
        return subEvents;
    }

    @Override
    public String getName() {
        return name;
    }
}
