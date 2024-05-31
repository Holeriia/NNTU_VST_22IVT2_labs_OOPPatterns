package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import baseclasses.orders.Order;


public class OrderManager {
    private final List<Order> orders = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addOrder(Order order) {
        lock.writeLock().lock();
        try {
            orders.add(order);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Order> getOrders() {
        lock.readLock().lock();
        try {
            return Collections.unmodifiableList(new ArrayList<>(orders));
        } finally {
            lock.readLock().unlock();
        }
    }

    public int getOrderCount() {
        lock.readLock().lock();
        try {
            return orders.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}