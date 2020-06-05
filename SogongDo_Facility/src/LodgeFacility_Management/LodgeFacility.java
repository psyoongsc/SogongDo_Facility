package LodgeFacility_Management;

import Facility_Management.persistence.FacilityDTO;

public class LodgeFacility{
	private int lodgeNumber;
	private int roomNumber;
	
	public void setLodgeNumber(int lodgeNumber) {
		this.lodgeNumber = lodgeNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
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