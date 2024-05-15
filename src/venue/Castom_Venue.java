package venue;

//Класса для ввода площадок не включенных в основной список площадок компании
public class Castom_Venue  extends VenueInterface{
//Конструктор
	public Castom_Venue() {}
//Сетторы
	public void setName(String name) {
		this.name = name;
	}
	public void setCopacity(int copasity) {
		this.capacity = copasity;
	}
	public void setType(Type_Venue Type) {
		this.Type = Type;
	}
	


	
}
