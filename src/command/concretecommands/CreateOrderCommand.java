package command.concretecommands;

import java.time.LocalDateTime;

import baseclasses.events.CompositeEvent;
import baseclasses.orders.Order;
import baseclasses.orders.StatusType;
import command.BookingSystem;
import command.Command;

public class CreateOrderCommand implements Command {
    private Order order;
    private BookingSystem bookingSystem;

    public CreateOrderCommand(BookingSystem bookingSystem, String name, CompositeEvent mainEvent, String clientName, LocalDateTime creationDate, StatusType status) {
        this.bookingSystem = bookingSystem;
        this.order = new Order(name, mainEvent, clientName, creationDate, status);
    }

    public void execute() {
        bookingSystem.addOrder(order);
        System.out.println("Заказ " + order.getName() + ", создан. Статус: " + order.getStatus().getType());
    }

    public void undo() {
        bookingSystem.removeOrder(order);
        System.out.println("Отмена заказа " + order.getName() + " успешна.");
    }
}