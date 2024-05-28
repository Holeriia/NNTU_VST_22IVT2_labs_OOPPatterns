package baseclasses.events;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SimpleEvent implements EventComponent {
    private String name;

    public SimpleEvent() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public SimpleEvent(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public void add(EventComponent component) {
        component.add(component);
    }

    @Override
    public void remove(EventComponent component) {
        component.remove(component);
    }

    @Override
    public String getName() {
        return name;
    }

	@Override
	public List<EventComponent> getSubEvents() {
		return Collections.emptyList();
	}
}
