package concreteclasses.statusTypes;

import baseclasses.orders.StatusType;

public class Active implements StatusType{
	
	public Active() {
		super();
	}

	public String getType() {
        return "Активен";
    }
}
