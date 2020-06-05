package Facility_Management.persistence;

public class FacilityAttributeDTO extends FacilityDTO{
	private int facilityState;
	private String facilityManager;
	private String facilityPhoneNumber;
	
	public FacilityAttributeDTO(String touristSiteName, int facilityID, String facilityName, int facilityState, String facilityManager,
			String facilityPhoneNumber) {
		super(touristSiteName, facilityID, facilityName);
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
	모듈 설계자 : 박성용
	
	검토자 :
	검토 날짜:
	
	수정 일자 :
	수정 내용 :
**/