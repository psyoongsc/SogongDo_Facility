package Facility_Mgmt.persistence;

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
		String sql = "insert into facilities(Tourist_Site_ID, Facilities_Name) \r\n" + 
				"values\r\n" + 
				"((select Tourist_Site_ID from tourist_site where Tourist_Site_Name = ?),?)";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, facilityInfo.getTouristSiteName());
			pstmt.setString(2, facilityInfo.getFacilityName());
			
			int affectedRow = pstmt.executeUpdate();
			
			if(affectedRow == 1)
				isSuccess = true;
			else
				isSuccess = false;
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean updateFacilityInfo(FacilityDTO facilityInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE `sogongdo`.`facilities`\r\n" + 
				"SET\r\n" + 
				"`Facilities_Name` = ?\r\n" + 
				"WHERE `Facilities_ID` = ?";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, facilityInfo.facilityName);
			pstmt.setInt(2, facilityInfo.facilityID);
			
			int affectedRow = pstmt.executeUpdate();
			
			if(affectedRow == 1)
				isSuccess = true;
			else
				isSuccess = false;
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public boolean deleteFacilityInfo(FacilityDTO facilityInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM `sogongdo`.`facilities`\r\n" + 
				"WHERE `Facilities_ID` = ?";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, facilityInfo.facilityID);
			
			int affectedRow = pstmt.executeUpdate();
			
			if(affectedRow == 1)
				isSuccess = true;
			else
				isSuccess = false;
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return isSuccess;
	}
	
	public ArrayList<FacilityDTO> displayFacilityInfo() {
		ArrayList<FacilityDTO> facilityList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select b.Tourist_Site_Name, a.Facilities_ID, a.Facilities_Name\r\n" + 
				"from facilities a, tourist_site b\r\n" + 
				"where a.Tourist_Site_ID=b.Tourist_Site_ID";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String touristSiteName = rs.getString("Tourist_Site_Name");
				String facilityName = rs.getString("Facilities_Name");
				int facilityID = rs.getInt("Facilities_ID");
				
				FacilityDTO dto = new FacilityDTO(touristSiteName, facilityID, facilityName);
				facilityList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return facilityList;
	}
}
