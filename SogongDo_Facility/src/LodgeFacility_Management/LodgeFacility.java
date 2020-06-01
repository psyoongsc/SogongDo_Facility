package LodgeFacility_Management;

import Facility_Management.Facility;

public class LodgeFacility extends Facility{
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
