package command.concretecommands;

import baseclasses.events.CompositeEvent;
import baseclasses.orders.Order;
import command.Command;

public class ChangeMainEventCommand implements Command {
    private Order order;
    private CompositeEvent newEvent;
    private CompositeEvent oldEvent;

    public ChangeMainEventCommand(Order order, CompositeEvent newEvent) {
        this.order = order;
        this.newEvent = newEvent;
    }

    @Override
    public void execute() {
        oldEvent = order.getMainEvent();
        order.setMainEvent(newEvent);
        System.out.println("Мероприятие заказа : " + order.getName() + ", заменено на : " + newEvent.getName());
    }

    @Override
    public void undo() {
        order.setMainEvent(oldEvent);
        System.out.println("Мероприятие заказа " + order.getName() + ", восстановлено, мероприятие снова " + oldEvent.getName());
    }
}