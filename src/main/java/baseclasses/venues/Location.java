package baseclasses.venues;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import baseclasses.Booking;
import baseclasses.events.EventComponent;
import decorators.LocationDecorator;

public class Location {
	protected String name;
    protected LocationType type;
    protected int capacity;
    protected List<Booking> list = new ArrayList<>();

    
    public Location() {
	}

	public Location(String name, LocationType type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

	
    public void setName(String name) {
		this.name = name;
	}

	public void setType(LocationType type) {
		this.type = type;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Booking> getBookings() {
        return list;
    }

    public Location getLocationByType(EventComponent event, LocationType locationType) {
        if (event instanceof LocationDecorator) {
            LocationDecorator locationDecorator = (LocationDecorator) event;
            Location location = locationDecorator.getLocation();
            if (location != null && location.getType().getType().equals(locationType.getType())) {
                return location;
            }
        } else {
            System.out.println("Событие не имеет декоратора локации.");
        }
        return null;
    }

    public void showActiveBookings() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"); // Формат для вывода даты и времени
        
        System.out.println("Активные брони для " + name + ":");
        for (Booking booking : list) {
            // Печатаем информацию о каждом бронировании
            System.out.println(booking.getEvent().getName() + ": " +
                               booking.getStartTime().format(formatter) + " - " +
                               booking.getEndTime().format(formatter));
        }
    }
}
