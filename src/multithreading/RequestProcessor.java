package multithreading;

import java.util.concurrent.atomic.AtomicBoolean;

import baseclasses.orders.Order;


public class RequestProcessor implements Runnable {
    private final RequestQueue requestQueue;
    private final int id;
    private final AtomicBoolean running;

    public RequestProcessor(RequestQueue requestQueue, int id, AtomicBoolean running) {
        this.requestQueue = requestQueue;
        this.id = id;
        this.running = running;
    }

    @Override
    public void run() {
        System.out.println("Поток " + id + " начал работу");
        try {
            while (running.get()) {
                Runnable request = requestQueue.getRequest();
                if (request != null) {
                    request.run();
                    System.out.println("Заказ обработан потоком " + id);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("Поток " + id + " завершил работу");
        }
    }
}

