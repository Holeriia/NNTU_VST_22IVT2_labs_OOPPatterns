package observer;

public interface Subject {
    void subscribeToWorkers(Observer observer);
    void unsubscribeFromWorkers(Observer observer);
    void notifyWorkerObservers(String message);

    void subscribeToGuests(Observer observer);
    void unsubscribeFromGuests(Observer observer);
    void notifyGuestObservers(String message);
}