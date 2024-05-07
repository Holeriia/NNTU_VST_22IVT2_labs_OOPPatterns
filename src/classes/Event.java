package classes;

//import java.util.ArrayList;
//import java.util.List;

//Конкретный компонент - мероприятие
public class Event implements EventComponent {
 private String name;

 public Event() {
	super();
}

public Event(String name) {
     this.name = name;
 }
 
 public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public void add(EventComponent component) {
     // Не поддерживается для простого мероприятия
 }

 public void remove(EventComponent component) {
     // Не поддерживается для простого мероприятия
 }

 public void display() {
     System.out.println(name);
 }
 
// public void addGuest(Guest guest) {
//     guest.add(guest);
// }
}


