package Refund_Mgmt.persistance;

public class RefundDTO {
	public int Reservation_ID;
	public int Refund_Amount;
	public String Refund_Method;
	public String Refund_Date;
	public String Refund_Account;
    
    public RefundDTO() {}

	public RefundDTO(int reservation_ID, int refund_Amount, String refund_Method, String refund_Date,
			String refund_Account) {
		super();
		Reservation_ID = reservation_ID;
		Refund_Amount = refund_Amount;
		Refund_Method = refund_Method;
		Refund_Date = refund_Date;
		Refund_Account = refund_Account;
	}

	public int getReservation_ID() {
		return Reservation_ID;
	}

	public void setReservation_ID(int reservation_ID) {
		Reservation_ID = reservation_ID;
	}

	public int getRefund_Amount() {
		return Refund_Amount;
	}

	public void setRefund_Amount(int refund_Amount) {
		Refund_Amount = refund_Amount;
	}

	public String getRefund_Method() {
		return Refund_Method;
	}

	public void setRefund_Method(String refund_Method) {
		Refund_Method = refund_Method;
	}

	public String getRefund_Date() {
		return Refund_Date;
	}

	public void setRefund_Date(String refund_Date) {
		Refund_Date = refund_Date;
	}

	public String getRefund_Account() {
		return Refund_Account;
	}

	public void setRefund_Account(String refund_Account) {
		Refund_Account = refund_Account;
	}
    
}