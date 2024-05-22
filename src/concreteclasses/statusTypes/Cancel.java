package concreteclasses.statusTypes;

import baseclasses.orders.StatusType;

public class Cancel implements StatusType{
	public String getType() {
        return "Отменен";
    }
}
