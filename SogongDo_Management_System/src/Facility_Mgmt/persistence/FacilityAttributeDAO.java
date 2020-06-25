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

public class FacilityAttributeDAO {
	private DataSource ds;
	
	public FacilityAttributeDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean enrollFacilityAttributeInfo(FacilityAttributeDTO facilityAttributeInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into facilities_attribute\r\n" + 
				"(`Tourist_Site_ID`,\r\n" + 
				"`Facilities_ID`,\r\n" + 
				"`Facilities_State`,\r\n" + 
				"`Facilities_Manager_Name`,\r\n" + 
				"`Facilities_Phone_Number`)\r\n" + 
				"values\r\n" + 
				"((select Tourist_Site_ID from tourist_site where Tourist_Site_Name = ?),\r\n" + 
				"(select Facilities_ID from facilities where Facilities_Name = ?),\r\n" + 
				"?,?,?)";
		
		try {//sql 변경해야함
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, facilityAttributeInfo.getTouristSiteName());
			pstmt.setString(2, facilityAttributeInfo.getFacilityName());
			pstmt.setInt(3, facilityAttributeInfo.getFacilityStatus());
			pstmt.setString(4, facilityAttributeInfo.getFacilityManager());
			pstmt.setString(5, facilityAttributeInfo.getFacilityPhoneNumber());
			
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
	
	public boolean updateFacilityAttributeInfo(FacilityAttributeDTO facilityAttributeInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE `sogongdo`.`facilities_attribute`\r\n" + 
				"SET\r\n" + 
				"`Facilities_State` = ?,\r\n" + 
				"`Facilities_Manager_Name` = ?,\r\n" + 
				"`Facilities_Phone_Number` = ?\r\n" + 
				"WHERE `Facilities_ID` = ?";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, facilityAttributeInfo.getFacilityStatus());
			pstmt.setString(2, facilityAttributeInfo.getFacilityManager());
			pstmt.setString(3, facilityAttributeInfo.getFacilityPhoneNumber());
			pstmt.setInt(4, facilityAttributeInfo.getFacilityID());
			
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
	
	public boolean deleteFacilityAttributeInfo(FacilityAttributeDTO facilityAttributeInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM `sogongdo`.`facilities_attribute`\r\n" + 
				"WHERE `Facilities_ID` = ?";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, facilityAttributeInfo.getFacilityID());
			
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
	
	public ArrayList<FacilityAttributeDTO> displayFacilityAttributeInfo() {
		ArrayList<FacilityAttributeDTO> facilityAttributeList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select b.Tourist_Site_Name, a.Facilities_ID, c.Facilities_Name, a.Facilities_State, a.Facilities_Manager_Name, a.Facilities_Phone_Number\r\n" + 
				"from facilities_attribute a, tourist_site b, facilities c\r\n" + 
				"where a.Tourist_Site_ID = b.Tourist_Site_ID and c.Facilities_ID = a.Facilities_ID";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String touristSiteName = rs.getString(1);
				int facilityID = rs.getInt(2);
				String facilityName = rs.getString(3);
				int facilityStatus = rs.getInt(4);
				String facilityManager = rs.getString(5);
				String facilityPhoneNum = rs.getString(6);
				
				FacilityAttributeDTO dto = new FacilityAttributeDTO(touristSiteName, facilityID, facilityName, facilityStatus, facilityManager, facilityPhoneNum);
				facilityAttributeList.add(dto);
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
		
		return facilityAttributeList;
	}
}
