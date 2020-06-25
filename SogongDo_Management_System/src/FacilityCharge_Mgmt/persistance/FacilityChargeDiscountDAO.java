package FacilityCharge_Mgmt.persistance;

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

public class FacilityChargeDiscountDAO {
	private DataSource ds;

	public FacilityChargeDiscountDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<FacilityChargeDiscountDTO> select() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select facilities_charge.Charge_ID, Facilities_Name, Discount_Reason, Discount_Rate from facilities_charge, facilities_charge_discount, facilities "
				+"where facilities_charge.Charge_ID=facilities_charge_discount.Charge_ID and facilities_charge.Facilities_ID=facilities.Facilities_ID";
		ArrayList<FacilityChargeDiscountDTO> articles = new ArrayList<FacilityChargeDiscountDTO>();
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
				String facilityName = rs.getString("Facilities_Name");
				String discountReason = rs.getString("Discount_Reason");
				int discountRate = rs.getInt("Discount_Rate");
				FacilityChargeDiscountDTO dto = new FacilityChargeDiscountDTO(chargeID, facilityName, discountReason, discountRate);
				articles.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return articles;
	}
	
	public void insert(int chargeID, String discountReason, int discountRate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into facilities_charge_discount(Charge_ID, Discount_Reason, Discount_Rate)"
				+"values(?,?,?)";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chargeID);
			pstmt.setString(2, discountReason);
			pstmt.setInt(3, discountRate);
			pstmt.executeUpdate();
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
	}
	
	public void delete(int chargeID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from facilities_charge_discount where Charge_ID=?";
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
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(int chargeID, String discountReason, int discountRate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update facilities_charge_discount set Discount_Reason=?, Discount_Rate=? "
				+"where Charge_ID=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, discountReason);
			pstmt.setInt(2, discountRate);
			pstmt.setInt(3, chargeID);
			pstmt.executeUpdate();
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
	}
}
