package Facility_Mgmt.persistence;

public class FacilityDTO {
	protected String touristSiteName;
	protected int facilityID;
	protected String facilityName;
	
	public FacilityDTO(String touristSiteName, int facilityID, String facilityName) {
		super();
		this.touristSiteName = touristSiteName;
		this.facilityID = facilityID;
		this.facilityName = facilityName;
	}
	
	public String getTouristSiteName() {
		return touristSiteName;
	}
	public void setTouristSiteID(String touristSiteName) {
		this.touristSiteName = touristSiteName;
	}
	public int getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
}


/**
	모듈 설계자 : 박성용

	검토자 :
	검토 날짜:

	수정 일자 :
	수정 내용 :
**/