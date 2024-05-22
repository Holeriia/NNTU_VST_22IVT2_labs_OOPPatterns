package command.concretecommands;

import baseclasses.orders.Order;
import baseclasses.orders.StatusType;
import command.Command;

public class ChangeOrderStatusCommand implements Command {
    private Order order;
    private StatusType newStatus;
    private StatusType oldStatus;

    public ChangeOrderStatusCommand(Order order, StatusType newStatus) {
        this.order = order;
        this.newStatus = newStatus;
    }

    public void execute() {
        oldStatus = order.getStatus();
        order.setStatus(newStatus);
        System.out.println("Статус заказа изменен на: " + newStatus.getType());
    }

    public void undo() {
        order.setStatus(oldStatus);
        System.out.println("Статус заказа снова стал " + oldStatus.getType());
    }
}
