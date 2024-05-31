package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class RequestQueue {
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private static final Runnable POISON_PILL = () -> {};

    public void addRequest(Runnable request) {
        queue.add(request);
    }

    public Runnable getRequest() throws InterruptedException {
        Runnable request = queue.take();
        if (request == POISON_PILL) {
            queue.put(POISON_PILL); // возвращаем маркер обратно в очередь для других потоков
            return null;
        }
        return request;
    }

    public void awaitCompletion() {
        try {
            queue.put(POISON_PILL);
            while (!queue.isEmpty()) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
