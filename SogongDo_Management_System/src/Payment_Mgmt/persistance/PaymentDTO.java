package Payment_Mgmt.persistance;

public class PaymentDTO {
	public int Reservation_ID;
	public int Charge_ID;
	public int Discount_Id;
	public String Payment_Method;
	public int Payment_Amount;
	public String Payment_Date;
    
    public PaymentDTO() {}
	public PaymentDTO(int reservation_ID, int charge_ID, int discount_Id, String payment_Method,
			int payment_Amount, String payment_Date) {
		super();
		Reservation_ID = reservation_ID;
		Charge_ID = charge_ID;
		Discount_Id = discount_Id;
		Payment_Method = payment_Method;
		Payment_Amount = payment_Amount;
		Payment_Date = payment_Date;
	}
	public int getReservation_ID() {
		return Reservation_ID;
	}
	public void setReservation_ID(int reservation_ID) {
		Reservation_ID = reservation_ID;
	}
	public int getCharge_ID() {
		return Charge_ID;
	}
	public void setCharge_ID(int charge_ID) {
		Charge_ID = charge_ID;
	}
	public int getDiscount_Id() {
		return Discount_Id;
	}
	public void setDiscount_Id(int discount_Id) {
		Discount_Id = discount_Id;
	}
	public String getPayment_Method() {
		return Payment_Method;
	}
	public void setPayment_Method(String payment_Method) {
		Payment_Method = payment_Method;
	}
	public int getPayment_Amount() {
		return Payment_Amount;
	}
	public void setPayment_Amount(int payment_Amount) {
		Payment_Amount = payment_Amount;
	}
	public String getPayment_Date() {
		return Payment_Date;
	}
	public void setPayment_Date(String payment_Date) {
		Payment_Date = payment_Date;
	}
	
    
    
}