package concreteclasses.statusTypes;

import baseclasses.orders.StatusType;

public class Cancel implements StatusType{
	
	public Cancel() {
		super();
	}

	public String getType() {
        return "Отменен";
    }
}
