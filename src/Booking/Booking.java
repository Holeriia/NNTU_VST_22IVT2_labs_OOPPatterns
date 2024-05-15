package Booking;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import event.EventComponent;

//бронирование
public class Booking {

	private EventComponent event;			//событие
    private LocalDateTime startTime;		//время и дата начала события
    private LocalDateTime endTime;			//время и дата конца события
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");  //не трогать(форматирование )

// Конструктор для события с известным временем начала и конца
    public Booking(LocalDateTime startTime, LocalDateTime endTime, EventComponent event) {
    	this.event = event;
        this.startTime = startTime;
        this.endTime = endTime;
    }

// Геттеры и сеттеры для времени начала и конца
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
//Геттеры и сеттеры для события
    public EventComponent getEvent() {
    	return this.event;
    }    
    public void setEvent(EventComponent event) {
    	this.event = event;
    }
     

    // Переопределение метода toString() для удобного вывода информации о событии
    @Override
    public String toString() {
        return "Event{" +
                "startTime=" + startTime.format(formatter) +
                ", endTime=" + endTime.format(formatter) +
                '}';
    }
}