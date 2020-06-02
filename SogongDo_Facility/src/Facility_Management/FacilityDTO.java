package Facility_Management;

public class FacilityDTO {
	protected String touristSite;
	protected String facility;
	
	public FacilityDTO(String touristSite, String facility) {
		this.touristSite = touristSite;
		this.facility = facility;
	}
	
	public void setTouristSite(String touristSite) {
		this.touristSite = touristSite;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getTouristStie() {
		return this.touristSite;
	}
	public String getFacility() {
		return this.facility;
	}
}


/**
	모듈 설계자 : 박성용

	검토자 :
	검토 날짜:

	수정 일자 :
	수정 내용 :
**/