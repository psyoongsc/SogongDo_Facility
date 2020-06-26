package Payment_Mgmt.persistance;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PaymentDAO {
	private DataSource ds;

	public PaymentDAO() {
		try {
			Context context = new InitialContext();  
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-geneIdd catch block
			e.printStackTrace();
		}
	}
	
	
	
	public ArrayList<PaymentDTO> selectPayment(){ 
		ArrayList<PaymentDTO> payments = new ArrayList<PaymentDTO>();
		
		try {
		Connection conn = ds.getConnection();
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM sogongdo.payment;";
		ResultSet rs = st.executeQuery(sql);
		
		
		while (rs.next()) {
			int reservation_ID = rs.getInt("Reservation_ID");
			int charge_ID = rs.getInt("Charge_ID");
			int discount_Id = rs.getInt("Discount_Id");
			String payment_Method = rs.getString("Payment_Method");
			int payment_Amount = rs.getInt("Payment_Amount");
			String payment_Date = rs.getString("Payment_Date");
				
			PaymentDTO dto = new PaymentDTO(reservation_ID,charge_ID,discount_Id,payment_Method,
						payment_Amount, payment_Date);
				payments.add(dto);
			}
			if(rs != null) try { rs.close(); } catch(SQLException sqle) {}
            if(st != null) try { st.close(); } catch(SQLException sqle) {}
            if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payments;
	}
	
	
	public int enrollPayment(PaymentDTO payments) {
		int reservation_ID = payments.getReservation_ID();
		int charge_ID = payments.getCharge_ID();
		int discount_Id = payments.getDiscount_Id();
		String payment_Method = payments.getPayment_Method();
		int payment_Amount = payments.getPayment_Amount();
		String payment_Date = payments.getPayment_Date();
		 int rowCount = 0;
		try {
			Connection conn = ds.getConnection();
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM sogongdo.payment;";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				if(String.valueOf(reservation_ID).equals(rs.getString("Reservation_ID"))) return -1;
			}
			
			sql = "INSERT INTO `sogongdo`.`payment`(`Reservation_ID`,`Charge_ID`,`Discount_Id`,`Payment_Method`,`Payment_Amount`,`Payment_Date`)\r\n" 
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reservation_ID);
			pstmt.setInt(2, charge_ID);
			if(discount_Id == 0) {
				pstmt.setNull(3, discount_Id);
			}else {pstmt.setInt(3, discount_Id);}
			pstmt.setString(4, payment_Method);
			pstmt.setInt(5, payment_Amount);
			pstmt.setString(6, payment_Date);
			rowCount = pstmt.executeUpdate();
			
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount; 
	}
	
	
	public int updatePayment(PaymentDTO payments) {
		int reservation_ID = payments.getReservation_ID();
		int charge_ID = payments.getCharge_ID();
		int discount_Id = payments.getDiscount_Id();
		String payment_Method = payments.getPayment_Method();
		int payment_Amount = payments.getPayment_Amount();
		String payment_Date = payments.getPayment_Date();
		 int rowCount=0;
		try {
			Connection conn = ds.getConnection();
			String sql = "UPDATE `sogongdo`.`payment` SET `Reservation_ID` = ?,`Charge_ID` = ?,`Discount_Id` = ?"
					+ ",`Payment_Method` = ?,`Payment_Amount` = ?,`Payment_Date` = ?\r\n" + 
					"WHERE `Reservation_ID` = ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, reservation_ID);
			pstmt.setInt(2, charge_ID);
			if(discount_Id == 0) {
				pstmt.setNull(3, discount_Id);
			}else {pstmt.setInt(3, discount_Id);}
			pstmt.setString(4, payment_Method);
			pstmt.setInt(5, payment_Amount);
			pstmt.setString(6, payment_Date);
			pstmt.setInt(7, reservation_ID);
			rowCount = pstmt.executeUpdate();
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	
	public void deletePayment(String id) {
		try {
			Connection conn = ds.getConnection();
			String sql = "DELETE FROM `sogongdo`.`payment` WHERE Reservation_ID = ?";
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