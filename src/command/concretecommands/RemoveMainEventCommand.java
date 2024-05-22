package command.concretecommands;

import baseclasses.events.CompositeEvent;
import baseclasses.orders.Order;
import command.Command;

public class RemoveMainEventCommand implements Command {
    private Order order;
    private CompositeEvent removedEvent;

    public RemoveMainEventCommand(Order order) {
        this.order = order;
    }

    public void execute() {
        removedEvent = order.getMainEvent();
        order.removeMainEvent();
        System.out.println("Мероприятие " + order.getName() + " откреплено от заказа.");
    }

    public void undo() {
        order.setMainEvent(removedEvent);
        System.out.println("Отмена откреплния мероприятия: " + order.getName() + ", Прикреплено: " + removedEvent.getName());
    }
}
