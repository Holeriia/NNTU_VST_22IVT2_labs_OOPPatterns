package concreteclasses.statusTypes;

import baseclasses.orders.StatusType;

public class WaitPayment implements StatusType{
	public String getType() {
        return "Ждет оплаты";
    }
}
