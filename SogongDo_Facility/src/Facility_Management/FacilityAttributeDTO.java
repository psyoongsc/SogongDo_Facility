package Facility_Management;

public class FacilityAttributeDTO extends FacilityDTO{
	private int facilityState;
	private String facilityManager;
	private String facilityPhoneNumber;
	
	public FacilityAttributeDTO(String touristSite, String facility, int facilityState, String facilityManager,
			String facilityPhoneNumber) {
		super(touristSite, facility);
		this.facilityState = facilityState;
		this.facilityManager = facilityManager;
		this.facilityPhoneNumber = facilityPhoneNumber;
	}
	
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

/**
	��� ������ : �ڼ���
	
	������ :
	���� ��¥:
	
	���� ���� :
	���� ���� :
**/