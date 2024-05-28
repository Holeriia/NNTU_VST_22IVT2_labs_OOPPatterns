package concreteclasses.statusTypes;

import baseclasses.orders.StatusType;

public class Active implements StatusType{
	public String getType() {
        return "Активен";
    }
}
