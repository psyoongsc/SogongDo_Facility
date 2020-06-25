/*
    모듈 설계자 : 이희수

    검토자 : 박성용
    검토 날짜: 2020/06/12

    수정 일자 :
    수정 내용 :
*/
package TouristSite_Mgmt.persistance;

public class TouristSiteAttributeDTO {
    private int tourist_site_id;
    private String tourist_site_address;
    private String tourist_site_phone_number;
    private int registration_number;
    private String representative_name;
    
    public TouristSiteAttributeDTO(int tourist_site_id, String tourist_site_address, String tourist_site_phone_number, int registration_number, String representative_name)
    {
    	this.tourist_site_id = tourist_site_id;
    	this.tourist_site_address = tourist_site_address;
    	this.tourist_site_phone_number = tourist_site_phone_number;
    	this.registration_number = registration_number;
    	this.representative_name = representative_name;
    	
    }
    public int getTourist_site_id() {
		return tourist_site_id;
	}
	public void setTourist_site_id(int tourist_site_id) {
		this.tourist_site_id = tourist_site_id;
	}
	public String getTourist_site_address() {
		return tourist_site_address;
	}
	public void setTourist_site_address(String tourist_site_address) {
		this.tourist_site_address = tourist_site_address;
	}
	public String getTourist_site_phone_number() {
		return tourist_site_phone_number;
	}
	public void setTourist_site_phone_number(String tourist_site_phone_number) {
		this.tourist_site_phone_number = tourist_site_phone_number;
	}
	public int getRegistration_number() {
		return registration_number;
	}
	public void setRegistration_number(int registration_number) {
		this.registration_number = registration_number;
	}
	public String getRepresentative_name() {
		return representative_name;
	}
	public void setRepresentative_name(String representative_name) {
		this.representative_name = representative_name;
	}
	
}
