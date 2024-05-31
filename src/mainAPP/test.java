package mainAPP;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import baseclasses.Booking;
import baseclasses.events.CompositeEvent;
import baseclasses.events.EventComponent;
import baseclasses.guests.Guest;
import baseclasses.orders.Order;
import baseclasses.venues.Location;
import baseclasses.workers.Worker;
import baseclasses.workers.WorkerType;
import command.BookingSystem;
import concreteclasses.eventfactories.BanquetFactory;
import concreteclasses.eventfactories.CeremonyFactory;
import concreteclasses.eventfactories.PhotoSessionFactory;
import concreteclasses.statusTypes.Active;
import concreteclasses.workers.Photographer;
import decorators.GuestDecorator;
import decorators.LocationDecorator;
import observer.Editor;
import baseclasses.orders.StatusType;
import command.Command;
import command.concretecommands.ChangeMainEventCommand;
import command.concretecommands.CreateOrderCommand;
import command.concretecommands.RemoveMainEventCommand;

import multithreading.OrderManager;
import multithreading.RequestProcessor;
import multithreading.RequestQueue;

public class test {
    public static void main(String[] args) {
        int requestCount = 15; // Количество заказов

        OrderManager orderManager = new OrderManager();
        RequestQueue requestQueue = new RequestQueue();
        AtomicBoolean running = new AtomicBoolean(true);

        // Создание и запуск потоков-обработчиков
        int nThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < nThreads; i++) {
            executor.submit(new RequestProcessor(requestQueue, i + 1, running));
        }

        // Добавление запросов на обработку (писатели)
        for (int i = 0; i < requestCount; i++) {
            int orderId = i;
            requestQueue.addRequest(() -> {
                Order order = new Order("Order " + orderId, null, "Client" + orderId, LocalDateTime.now(), new Active());
                orderManager.addOrder(order);
            });
        }

        // Ожидание обработки всех заказов
        requestQueue.awaitCompletion();

        // Остановка всех потоков
        running.set(false);
        executor.shutdown();
    }
}