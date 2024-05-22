package observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import baseclasses.Booking;
import baseclasses.events.EventComponent;
import baseclasses.venues.Location;
import baseclasses.venues.LocationType;
import baseclasses.workers.Worker;
import baseclasses.workers.WorkerType;
import baseclasses.guests.Guest;
import decorators.EventDecorator;
import decorators.LocationDecorator;
import decorators.WorkerDecorator;
import decorators.GuestDecorator;

public class Editor implements Subject {
	 private List<Observer> workerObservers = new ArrayList<>();
	 private List<Observer> guestObservers = new ArrayList<>();

    public boolean isBookingPossible(List<Booking> bookings, LocalDateTime newStartTime, LocalDateTime newEndTime) {
        for (Booking booking : bookings) {
            LocalDateTime existingStartTime = booking.getStartTime();
            LocalDateTime existingEndTime = booking.getEndTime();
            if (newStartTime.isBefore(existingEndTime) && newEndTime.isAfter(existingStartTime)) {
                return false;
            }
        }
        return true;
    }

    public void addBooking(Booking booking, Worker worker) {
        if (isBookingPossible(worker.getBookings(), booking.getStartTime(), booking.getEndTime())) {
            worker.getBookings().add(booking);
            System.out.println("Система: Бронь для работника успешно добавлена!");
            notifyGuestObservers("На мероприятие назначен \"" + worker.getName() + "\"");
        } else {
            System.out.println("Система: Извините, это время уже забронировано. Выберите другое.");
        }
    }

    public void addBooking(Booking booking, Location location) {
        if (isBookingPossible(location.getBookings(), booking.getStartTime(), booking.getEndTime())) {
            location.getBookings().add(booking);
            System.out.println("Система: Бронь для локации успешно добавлена!");
            notifyGuestObservers("У мероприятия новая локация \"" + location.getName() + "\"");
            notifyWorkerObservers("У мероприятия новая локация \"" + location.getName() + "\"");
        } else {
            System.out.println("Система: Извините, это время уже забронировано. Выберите другое.");
        }
    }

    public void subscribeToWorkers(Observer observer) {
        workerObservers.add(observer);
    }

    public void subscribeToGuests(Observer observer) {
        guestObservers.add(observer);
    }

    public void notifyWorkerObservers(String message) {
        for (Observer observer : workerObservers) {
            observer.update(message);
        }
    }

    public void notifyGuestObservers(String message) {
        for (Observer observer : guestObservers) {
            observer.update(message);
        }
    }
    
    @Override
    public void unsubscribeFromWorkers(Observer observer) {
        workerObservers.remove(observer);
    }

    @Override
    public void unsubscribeFromGuests(Observer observer) {
        guestObservers.remove(observer);
    }

	public void bookEventForWorker(Booking booking, WorkerType workerType, Worker worker) {
        EventComponent event = booking.getEvent();
        WorkerDecorator workerDecorator = findWorkerDecorator(event);

        if (workerDecorator == null) {
            System.out.println("The event does not have a WorkerDecorator.");
            return;
        }

        List<Worker> workers = workerDecorator.getWorkers();
        Worker placeholderWorker = null;
        for (Worker w : workers) {
            if (w.getTypeWorker().getType().equals(workerType.getType()) && w.getName().isEmpty()) {
                placeholderWorker = w;
                break;
            }
        }

        if (placeholderWorker == null) {
            System.out.println("No placeholder worker available for type: " + workerType.getType());
            return;
        }

        if (!worker.getTypeWorker().getType().equals(workerType.getType())) {
            System.out.println("Worker type mismatch. Expected: " + workerType.getType() + ", but got: " + worker.getTypeWorker().getType());
            return;
        }

        workerDecorator.remove(placeholderWorker);
        workerDecorator.add(worker);
        addBooking(booking, worker);
        
        // Добавление работника в список рабочих наблюдателей
        subscribeToWorkers(worker);
        // Уведомление о назначении работника на мероприятие
        notifyWorkerObservers("Работник \"" + worker.getName() + "\" назначен на мероприятие \"" + event.getName() + "\"");
    }

    public void bookEventForLocation(Booking booking, LocationType locationType, Location location) {
        EventComponent event = booking.getEvent();
        LocationDecorator locationDecorator = findLocationDecorator(event);

        if (locationDecorator == null) {
            System.out.println("The event does not have a LocationDecorator.");
            return;
        }

        Location placeholderLocation = locationDecorator.getLocation();
        if (placeholderLocation == null || !placeholderLocation.getType().getType().equals(locationType.getType())) {
            System.out.println("No placeholder location available for type: " + locationType.getType());
            return;
        }

        if (!location.getType().getType().equals(locationType.getType())) {
            System.out.println("Location type mismatch. Expected: " + locationType.getType() + ", but got: " + location.getType().getType());
            return;
        }

        locationDecorator.setLocation(location);
        addBooking(booking, location);
    }

    public void addGuestToEvent(EventComponent event, Guest guest) {
        GuestDecorator guestDecorator = findGuestDecorator(event);
        if (guestDecorator != null) {
            guestDecorator.add(guest);
            System.out.println("Гость " + guest.getName() + " добавлен к мероприятию " + event.getName());
            subscribeToGuests(guest);
            //notifyGuestObservers("Уважаемый(-ая) \"" + guest.getName() + "\", Вы приглашен(-ы) на мероприятие \"" + event.getName() + "\"");
        } else {
            System.out.println("The event does not have a GuestDecorator.");
        }
    }

    public void addGuestsToEvent(EventComponent event, List<Guest> guests) {
        for (Guest guest : guests) {
            addGuestToEvent(event, guest);
        }
        notifyGuestObservers("Вы приглашен(-ы) на мероприятие \"" + event.getName() + "\"");
    }

    private WorkerDecorator findWorkerDecorator(EventComponent event) {
        if (event instanceof WorkerDecorator) {
            return (WorkerDecorator) event;
        }
        if (event instanceof EventDecorator) {
            return findWorkerDecorator(((EventDecorator) event).getComponent());
        }
        return null;
    }

    private LocationDecorator findLocationDecorator(EventComponent event) {
        if (event instanceof LocationDecorator) {
            return (LocationDecorator) event;
        }
        if (event instanceof EventDecorator) {
            return findLocationDecorator(((EventDecorator) event).getComponent());
        }
        return null;
    }

    private GuestDecorator findGuestDecorator(EventComponent event) {
        if (event instanceof GuestDecorator) {
            return (GuestDecorator) event;
        }
        if (event instanceof EventDecorator) {
            return findGuestDecorator(((EventDecorator) event).getComponent());
        }
        return null;
    }
}