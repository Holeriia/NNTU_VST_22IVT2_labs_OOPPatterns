package baseclasses.guests;

import observer.Observer;

public class Guest implements Observer{
	private String name;
    
//Конструктор
	public Guest(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void update(String message) {
        System.out.println("Телефон пользователя " + name + ": " + message);
    }
	
}

