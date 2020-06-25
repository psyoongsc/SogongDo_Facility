package LodgeFacility_Mgmt.persistence;

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

public class LodgeFacilityDAO {
	private DataSource ds;
	
	public LodgeFacilityDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public boolean enrollLodgeFacilityInfo(LodgeFacilityDTO lodgeFacilityInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO lodge_facilities\r\n" + 
				"(`Tourist_Site_ID`,\r\n" + 
				"`Facilities_ID`,\r\n" + 
				"`Lodge_Number`,\r\n" + 
				"`Room_Number`)\r\n" + 
				"VALUES\r\n" + 
				"((select Tourist_Site_ID from tourist_site where Tourist_Site_Name = ?),\r\n" + 
				"(select Facilities_ID from facilities where Facilities_Name = ?),\r\n" + 
				"?,?)";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lodgeFacilityInfo.getTouristSiteName());
			pstmt.setString(2, lodgeFacilityInfo.getFacilityName());
			pstmt.setInt(3, lodgeFacilityInfo.getLodgeNumber());
			pstmt.setInt(4, lodgeFacilityInfo.getRoomNumber());
			
			int affectedRow = pstmt.executeUpdate();
			
			if(affectedRow == 1)
				isSuccess = true;
			else
				isSuccess = false;
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public boolean updateLodgeFacilityInfo(LodgeFacilityDTO lodgeFacilityInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE lodge_facilities\r\n" + 
				"SET\r\n" + 
				"`Lodge_Number` = ?,\r\n" + 
				"`Room_Number` = ?\r\n" + 
				"WHERE `Lodge_Facilities_ID` = ?";
		
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lodgeFacilityInfo.getLodgeNumber());
			pstmt.setInt(2, lodgeFacilityInfo.getRoomNumber());
			pstmt.setInt(3, lodgeFacilityInfo.getLodgeFacilityID());
			
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
	
	public boolean deleteLodgeFacilityInfo(LodgeFacilityDTO lodgeFacilityInfo) {
		boolean isSuccess = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM lodge_facilities\r\n" + 
				"WHERE Lodge_Facilities_ID=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lodgeFacilityInfo.getLodgeFacilityID());
			
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
	
	public ArrayList<LodgeFacilityDTO> displayLodgeFacilityInfo() {
		ArrayList<LodgeFacilityDTO> lodgeFacilityList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select a.Tourist_Site_Name, b.Facilities_Name, c.Lodge_Facilities_ID,c.Lodge_Number, c.Room_Number\r\n" + 
				"from tourist_site a, facilities b, lodge_facilities c\r\n" + 
				"where a.Tourist_Site_ID=c.Tourist_Site_ID and b.Facilities_ID=c.Facilities_ID";
		
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
				int lodgeFacilityID = rs.getInt("Lodge_Facilities_ID");
				int lodgeNumber = rs.getInt("Lodge_Number");
				int roomNumber = rs.getInt("Room_Number");
				
				LodgeFacilityDTO dto = new LodgeFacilityDTO(touristSiteName, 0, facilityName, lodgeFacilityID, lodgeNumber, roomNumber);
				lodgeFacilityList.add(dto);
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
		
		return lodgeFacilityList;
	}
}
