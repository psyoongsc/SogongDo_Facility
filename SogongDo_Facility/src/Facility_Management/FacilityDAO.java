package Facility_Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FacilityDAO {
	private DataSource ds;
	
	public FacilityDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean enrollFacilityInfo(FacilityDTO facilityInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		return isSuccess;
	}
	
	public boolean updateFacilityInfo(FacilityDTO facilityInfo) {
		boolean isSuccess = false;
		
		return isSuccess;
	}
	
	public boolean deleteFacilityInfo(FacilityDTO facilityInfo) {
		boolean isSuccess = false;
		
		return isSuccess;
	}
	
	public ArrayList<FacilityDTO> displayFacilityInfo() {
		ArrayList<FacilityDTO> facilityList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select b.Toutist_Site_Name, a.Facilities_Name\r\n" + 
				"from facilities a, toutist_site b\r\n" + 
				"where b.Tourist_Site_ID=1 AND a.Tourist_Site_ID=b.Tourist_Site_ID";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String touristSite = rs.getString("Toutist_Site_Name");
				String facility = rs.getString("Facilities_Name");
				
				FacilityDTO dto = new FacilityDTO(touristSite, facility);
				facilityList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return facilityList;
	}
}
