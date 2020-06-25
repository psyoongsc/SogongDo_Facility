/*
    모듈 설계자 : 이희수

    검토자 : 박성용
    검토 날짜: 2020/06/12

    수정 일자 :
    수정 내용 :
*/
package TouristSite_Mgmt.persistance;

public class TouristSiteDTO {
    private int tourist_site_id;
    private String tourist_site_name;
    
	public TouristSiteDTO(int id, String name) {
		tourist_site_id = id;
    	tourist_site_name = name;
	}
	
	public TouristSiteDTO(String name) {
		tourist_site_id = 0;
    	tourist_site_name = name;
	}

	public int getTourist_site_id() {
		return tourist_site_id;
	}

	public void setTourist_site_id(int tourist_site_id) {
		this.tourist_site_id = tourist_site_id;
	}

	public String getTourist_site_name() {
		return tourist_site_name;
	}

	public void setTourist_site_name(String tourist_site_name) {
		this.tourist_site_name = tourist_site_name;
	}
   
}
