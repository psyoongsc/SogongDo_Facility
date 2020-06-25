package persistance;

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

public class FacilityChargeDAO {
	private DataSource ds;

	public FacilityChargeDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<FacilityChargeDTO> select() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select Charge_ID, Tourist_Site_Name, Facilities_Name, Charge from tourist_site, facilities, facilities_charge "
				+"where tourist_site.Tourist_Site_ID=facilities_charge.Tourist_Site_ID and facilities.Facilities_ID=facilities_charge.Facilities_ID";
		ArrayList<FacilityChargeDTO> articles = new ArrayList<FacilityChargeDTO>();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int chargeID = rs.getInt("Charge_ID");
				String touristSiteName = rs.getString("Tourist_Site_Name");
				String facilityName = rs.getString("Facilities_Name");
				int charge = rs.getInt("Charge");
				FacilityChargeDTO dto = new FacilityChargeDTO(chargeID, touristSiteName, facilityName, charge);
				articles.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}
	
	public void insert(int touristSiteID, int facilityID, int charge) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into facilities_charge(Tourist_Site_ID, Facilities_ID, Charge)"
				+"values(?,?,?)";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, touristSiteID);
			pstmt.setInt(2, facilityID);
			pstmt.setInt(3, charge);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int chargeID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from facilities_charge where Charge_ID=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chargeID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int chargeID, int touristSiteID, int facilityID, int charge) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update facilities_charge set Tourist_Site_ID=?, Facilities_ID=?, Charge=? "
				+"where Charge_ID=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, touristSiteID);
			pstmt.setInt(2, facilityID);
			pstmt.setInt(3, charge);
			pstmt.setInt(4, chargeID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
