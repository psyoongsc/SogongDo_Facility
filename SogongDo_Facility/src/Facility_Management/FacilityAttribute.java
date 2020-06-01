package Facility_Management;

public class FacilityAttribute extends Facility{
	private int facilityState;
	private String facilityManager;
	private String facilityPhoneNumber;
	
	public void setFacilityState(int facilityState) {
		this.facilityState = facilityState;
	}
	public void setFacilityManager(String facilityManager) {
		this.facilityManager = facilityManager;
	}
	public void setFacilityPhoneNumber(String facilityPhoneNumber) {
		this.facilityPhoneNumber = facilityPhoneNumber;
	}
	public int getFacilityState() {
		return this.facilityState;
	}
	public String getFacilityManager() {
		return this.facilityManager;
	}
	public String getFacilityPhoneNumber() {
		return this.facilityPhoneNumber;
	}
}
