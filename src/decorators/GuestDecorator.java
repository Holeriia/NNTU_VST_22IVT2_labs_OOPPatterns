package decorators;

import java.util.ArrayList;
import java.util.List;

import baseclasses.events.EventComponent;
import baseclasses.guests.Guest;

public class GuestDecorator extends EventDecorator{
	private List<Guest> guests = new ArrayList<>();

    public GuestDecorator(EventComponent decoratedEvent) {
        super(decoratedEvent);
    }

    public void add(Guest guest) {
        guests.add(guest);
    }

    public void addGuests(List<Guest> guestList) {
        guests.addAll(guestList);
    }

    public void remove(Guest guest) {
        guests.remove(guest);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void display() {
    	//component.display();
        System.out.println("Гости: ");
        for (Guest guest : guests) {
            System.out.println("- " + guest.getName());
        }
        System.out.println();
    }
    
    public String getName() {
        return component.getName();
    }
    
    @Override
    public List<EventComponent> getSubEvents() {
        return component.getSubEvents();
    }

}
