package classes;


//Конкретный компонент - мероприятие
public class Event implements EventComponent {
 private String name;

 public Event() {}

 public Event(String name) {
     this.name = name;
 }
 
 public String getName() {
	return name;
}


 public void add(EventComponent component) {}

 public void remove(EventComponent component) {}

 public void display() {
     System.out.println(name);
 }
 
}
 

