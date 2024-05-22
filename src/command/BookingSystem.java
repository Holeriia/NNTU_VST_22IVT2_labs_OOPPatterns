package command;

import java.util.ArrayList;
import java.util.List;

import baseclasses.orders.Order;

public class BookingSystem {
	private List<Order> orders;
    private Invoker invoker;

    public BookingSystem() {
        this.orders = new ArrayList<>();
        CommandHistory commandHistory = new CommandHistory();
        this.invoker = new Invoker(commandHistory);
    }

    public void addOrder(Order order) {
        orders.add(order);
        System.out.println("Заказ " + order.getName() + " добавлен в систему.");
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        System.out.println("Заказ " + order.getName() + " удален из системы.");
    }

    public void executeCommand(Command command) {
        invoker.executeCommand(command);
    }

    public void undoLastCommand() {
        invoker.undoLastCommand();
    }

    // Добавлен геттер для списка заказов
    public List<Order> getOrders() {
        return orders;
    }
}
