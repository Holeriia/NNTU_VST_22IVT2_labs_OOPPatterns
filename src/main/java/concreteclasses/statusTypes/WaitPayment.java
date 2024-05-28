package concreteclasses.statusTypes;

import baseclasses.orders.StatusType;

public class WaitPayment implements StatusType{
	
	public WaitPayment() {
		super();
	}

	public String getType() {
        return "Ждет оплаты";
    }
}
