package baseclasses.orders;

import java.time.LocalDateTime;
import java.util.Objects;

import baseclasses.events.CompositeEvent;
import command.Command;

public class Order implements Command{
	private String name;
	private CompositeEvent mainEvent;
	private String clientName;
	private LocalDateTime creationDate;
	private StatusType status;
	
	public Order(String name, CompositeEvent mainEvent, String clientName, LocalDateTime creationDate,
			StatusType status) {
		super();
		this.name = name;
		this.mainEvent = mainEvent;
		this.clientName = clientName;
		this.creationDate = creationDate;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CompositeEvent getMainEvent() {
		return mainEvent;
	}

	public void setMainEvent(CompositeEvent mainEvent) {
		this.mainEvent = mainEvent;
	}
	
	public void removeMainEvent() {
        this.mainEvent = null;
    }

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(clientName, other.clientName) && Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(mainEvent, other.mainEvent) && Objects.equals(name, other.name)
				&& Objects.equals(status, other.status);
	}



	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}	
}
