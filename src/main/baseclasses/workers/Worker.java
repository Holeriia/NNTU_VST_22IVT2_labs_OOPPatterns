package baseclasses.workers;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import baseclasses.Booking;
import observer.Observer;

public class Worker implements Observer {
    protected String name;
    protected WorkerType typeWorker;
    protected List<Booking> list = new ArrayList<>();

    public Worker(String name, WorkerType Type) {
        this.name = name;
        this.typeWorker = Type;
    }

    public String getName() {
        return name;
    }

    public WorkerType getTypeWorker() {
        return typeWorker;
    }

    public List<Booking> getBookings() {
        return list;
    }
    
    // Метод для вывода активных заказов
    public void showActiveBookings() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"); // Формат для вывода даты и времени
        
        System.out.println("Активные заказы для " + name + ":");
        for (Booking booking : list) {
            // Печатаем информацию о каждом бронировании
            System.out.println(booking.getEvent().getName() + ": " +
                               booking.getStartTime().format(formatter) + " - " +
                               booking.getEndTime().format(formatter));
        }
    }

	@Override
	public void update(String message) {
		System.out.println("Телефон пользователя " + name + ": Изменение в графике работы. " + message);
		
	}
}