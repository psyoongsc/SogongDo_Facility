package LodgeFacility_Mgmt.persistence;

import Facility_Mgmt.persistence.FacilityDTO;

public class LodgeFacilityDTO extends FacilityDTO{
	private int lodgeFacilityID;
	private int lodgeNumber;
	private int roomNumber;
	
	public LodgeFacilityDTO(String touristStiteName, int facilityID, String facilityName, int lodgeFacilityID, int lodgeNumber, int roomNumber) {
		super(touristStiteName, facilityID, facilityName);
		this.lodgeFacilityID = lodgeFacilityID;
		this.lodgeNumber = lodgeNumber;
		this.roomNumber = roomNumber;
	}
	
	public void setLodgeFacilityID(int lodgeFacilityID) {
		this.lodgeFacilityID = lodgeFacilityID;
	}
	public void setLodgeNumber(int lodgeNumber) {
		this.lodgeNumber = lodgeNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getLodgeFacilityID() {
		return this.lodgeFacilityID;
	}
	public int getLodgeNumber() {
		return this.lodgeNumber;
	}
	public int getRoomNumber() {
		return this.roomNumber;
	}
}

/**
	모듈 설계자 : 박성용
	
	검토자 :
	검토 날짜:
	
	수정 일자 :
	수정 내용 :
**/