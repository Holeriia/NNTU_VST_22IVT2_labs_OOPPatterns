package baseclasses.events;

public class SimpleEvent implements EventComponent {
    private String name;

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
}
