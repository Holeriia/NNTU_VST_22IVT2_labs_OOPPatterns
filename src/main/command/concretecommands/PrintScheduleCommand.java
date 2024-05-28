package command.concretecommands;

import java.time.format.DateTimeFormatter;
import java.util.List;

import baseclasses.Booking;
import baseclasses.events.CompositeEvent;
import baseclasses.events.EventComponent;
import baseclasses.guests.Guest;
import baseclasses.orders.Order;
import baseclasses.venues.Location;
import baseclasses.workers.Worker;
import command.Command;
import decorators.EventDecorator;
import decorators.GuestDecorator;
import decorators.LocationDecorator;
import decorators.WorkerDecorator;

public class PrintScheduleCommand implements Command {
    private Order order;
    private String indent = "";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm");

    public PrintScheduleCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        printSchedule(order.getMainEvent(), indent);
        // Обработка подсобытий
        for (EventComponent subEvent : order.getMainEvent().getSubEvents()) {
            printSchedule(subEvent, indent + "  ");
        }
    }

    private void printSchedule(EventComponent event, String indent) {
        System.out.println(indent + event.getName());

        // Проверяем, есть ли у события декоратор GuestDecorator
        GuestDecorator guestDecorator = findGuestDecorator(event);
        if (guestDecorator != null) {
            StringBuilder guestsBuilder = new StringBuilder();
            for (Guest guest : guestDecorator.getGuests()) {
                guestsBuilder.append(guest.getName()).append(", ");
            }
            // Убираем последнюю запятую и пробел
            if (guestsBuilder.length() > 0) {
                guestsBuilder.setLength(guestsBuilder.length() - 2);
                System.out.println(indent + "  Гости: " + guestsBuilder.toString());
            }
        }

        // Проверяем, есть ли у события декоратор WorkerDecorator
        WorkerDecorator workerDecorator = findWorkerDecorator(event);
        if (workerDecorator != null) {
            for (Worker worker : workerDecorator.getWorkers()) {
                List<Booking> bookings = worker.getBookings();
                if (!bookings.isEmpty()) {
                    System.out.println(indent + "  " + bookings.get(0).getStartTime().format(formatter) + " - " + worker.getName());
                }
            }
        }

        // Проверяем, есть ли у события декоратор LocationDecorator
        LocationDecorator locationDecorator = findLocationDecorator(event);
        if (locationDecorator != null) {
            Location location = locationDecorator.getLocation();
            if (location != null) {
                List<Booking> bookings = location.getBookings();
                if (!bookings.isEmpty()) {
                    System.out.println(indent + "  " + bookings.get(0).getStartTime().format(formatter) + " - " + location.getName());
                }
            }
        }

        // Обрабатываем подсобытия
        for (EventComponent subEvent : event.getSubEvents()) {
            // Рекурсивный вызов для обработки подсобытий
            if (subEvent instanceof CompositeEvent) {
                printSchedule((CompositeEvent) subEvent, indent + "  ");
            }
        }
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

	@Override
	public void undo() {
		// Для данной команды отмена не предусмотрена
	}
}