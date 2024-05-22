package command.concretecommands;

import baseclasses.events.CompositeEvent;
import baseclasses.orders.Order;
import command.Command;

public class AddEventToOrderCommand implements Command {
    private Order order;
    private CompositeEvent event;

    public AddEventToOrderCommand(Order order, CompositeEvent event) {
        this.order = order;
        this.event = event;
    }

    public void execute() {
        order.setMainEvent(event);
        System.out.println("Мероприятие " + event.getName() + "прикреплено к заказу.");
    }

    public void undo() {
        order.removeMainEvent();
        System.out.println("Мероприятие " + event.getName() + "откреплено от заказа.");
    }
}
