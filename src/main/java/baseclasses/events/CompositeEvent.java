package baseclasses.events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class CompositeEvent implements EventComponent {
	private String name;
    private List<EventComponent> subEvents= new ArrayList<>();

    public CompositeEvent() {}
    
    public void setName(String name) {
		this.name = name;
	}

	public void setSubEvents(List<EventComponent> subEvents) {
		this.subEvents = subEvents;
	}

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
