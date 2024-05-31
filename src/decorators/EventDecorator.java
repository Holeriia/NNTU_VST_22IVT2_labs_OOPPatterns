package decorators;

import java.util.List;

import baseclasses.events.EventComponent;

//базовый класс для декораторов
public abstract class EventDecorator implements EventComponent {
    protected EventComponent component;

    public EventDecorator(EventComponent component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }

    @Override
    public void add(EventComponent component) {
        this.component.add(component);
    }

    @Override
    public void remove(EventComponent component) {
        this.component.remove(component);
    }

    @Override
    public String getName() {
        return component.getName();
    }
    
    public EventComponent getComponent() {
        return component;
    }
    
    @Override
    public List<EventComponent> getSubEvents() {
        return component.getSubEvents();
    }
}

