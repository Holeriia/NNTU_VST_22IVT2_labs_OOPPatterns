package Booking;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import event.EventComponent;

public class Booking {

	private EventComponent event;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

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

    public EventComponent getEvent() {
    	return this.event;
    }
    
    
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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