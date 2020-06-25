package Facility_Mgmt.persistence;

public class FacilityAttributeDTO extends FacilityDTO{
	private int facilityStatus;
	private String facilityManager;
	private String facilityPhoneNumber;
	
	public FacilityAttributeDTO(String touristSiteName, int facilityID, String facilityName, int facilityStatus, String facilityManager,
			String facilityPhoneNumber) {
		super(touristSiteName, facilityID, facilityName);
		this.facilityStatus = facilityStatus;
		this.facilityManager = facilityManager;
		this.facilityPhoneNumber = facilityPhoneNumber;
	}
	
	public void setFacilityStatus(int facilityStatus) {
		this.facilityStatus = facilityStatus;
	}
	public void setFacilityManager(String facilityManager) {
		this.facilityManager = facilityManager;
	}
	public void setFacilityPhoneNumber(String facilityPhoneNumber) {
		this.facilityPhoneNumber = facilityPhoneNumber;
	}
	public int getFacilityStatus() {
		return this.facilityStatus;
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