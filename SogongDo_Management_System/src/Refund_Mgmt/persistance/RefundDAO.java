package Refund_Mgmt.persistance;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RefundDAO {
	private DataSource ds;

	public RefundDAO() {
		try {
			Context context = new InitialContext();  
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public ArrayList<RefundDTO> selectRefund(){ 
		ArrayList<RefundDTO> refunds = new ArrayList<RefundDTO>();
		
		try {
		Connection conn = ds.getConnection();
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM sogongdo.refund;";
		ResultSet rs = st.executeQuery(sql);
		
		
			while (rs.next()) {
				int reservation_ID = rs.getInt("Reservation_ID");
				int refund_Amount = rs.getInt("Refund_Amount");
				String refund_Method = rs.getString("Refund_Method");
				String refund_Date = rs.getString("Refund_Date");
				String refund_Account = rs.getString("Refund_Account");
				RefundDTO pDTO = new RefundDTO(reservation_ID, refund_Amount, refund_Method, refund_Date, refund_Account);
				refunds.add(pDTO);
			}
			if(rs != null) try { rs.close(); } catch(SQLException sqle) {}
            if(st != null) try { st.close(); } catch(SQLException sqle) {}
            if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return refunds;
	}
	
	
	public int enrollRefund(RefundDTO refunds) {
		int reservation_ID = refunds.getReservation_ID();
		int refund_Amount = refunds.getRefund_Amount();
		String refund_Method = refunds.getRefund_Method();
		String refund_Date = refunds.getRefund_Date();
		String refund_Account = refunds.getRefund_Account();
		 int rowCount = 0;
		try {
			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM sogongdo.refund;";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				if(String.valueOf(reservation_ID).equals(rs.getString("Reservation_ID"))) return -1;
			}
			
			sql = "INSERT INTO `sogongdo`.`refund`(`Reservation_ID`,`Refund_Amount`,`Refund_Method`,`Refund_Date`,`Refund_Account`)\r\n" 
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reservation_ID);
			pstmt.setInt(2, refund_Amount);
			pstmt.setString(3, refund_Method);
			pstmt.setString(4, refund_Date);
			pstmt.setString(5, refund_Account);
			rowCount = pstmt.executeUpdate();
			
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount; 
	}
	
	
	public int updateRefund(RefundDTO refunds) {
		
		int reservation_ID = refunds.getReservation_ID();
		int refund_Amount = refunds.getRefund_Amount();
		String refund_Method = refunds.getRefund_Method();
		String refund_Date = refunds.getRefund_Date();
		String refund_Account = refunds.getRefund_Account();
		 int rowCount=0;
		try {
			Connection conn = ds.getConnection();
			String sql = "UPDATE `sogongdo`.`refund` SET `Reservation_ID` = ?,`Refund_Amount` = ?,`Refund_Method` = ?"
					+ ",`Refund_Date` = ?,`Refund_Account` = ?\r\n" + 
					"WHERE `Reservation_ID` = ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reservation_ID);
			pstmt.setInt(2, refund_Amount);
			pstmt.setString(3, refund_Method);
			pstmt.setString(4, refund_Date);
			pstmt.setString(5, refund_Account);
			pstmt.setInt(6, reservation_ID);
			rowCount = pstmt.executeUpdate();
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	
	public void deleteRefund(String id) {
		try {
			Connection conn = ds.getConnection();
			String sql = "DELETE FROM `sogongdo`.`refund` WHERE Reservation_ID = ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}