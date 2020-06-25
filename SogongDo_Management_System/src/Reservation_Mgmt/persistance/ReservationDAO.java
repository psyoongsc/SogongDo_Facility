package Reservation_Mgmt.persistance;

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

public class ReservationDAO {
	private DataSource ds;

	public ReservationDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 조회
	public ArrayList<ReservationDTO> inquiry() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sogongdo.reservation WHERE isCancel = '0'";
		ArrayList<ReservationDTO> reservationArr = new ArrayList<ReservationDTO>();

		Statement st2 = null;
		ResultSet rs2 = null;
		String facilitiesName = "";

		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String reserveID = rs.getString("Reservation_ID");
				String facilitiesID = rs.getString("Facilities_ID");
				String memberID = rs.getString("Member_ID");
				String reserveName = rs.getString("Reservation_Name");
				String reservePnum = rs.getString("Reservation_Phone_Number");
				String HeadCount = rs.getString("HeadCount");
				String reserveDate = rs.getString("Reservation_Date");
				String reserveStart = rs.getString("Reservation_Start");
				String reserveEnd = rs.getString("Reservation_End");
				String isCancel = rs.getString("isCancel");
				String carNum = rs.getString("Car_Num");
				String carName = rs.getString("Car_Name");

				String sqlF = "SELECT Facilities_Name FROM sogongdo.facilities WHERE Facilities_ID = '" + facilitiesID
						+ "'";
				st2 = conn.createStatement();
				rs2 = st2.executeQuery(sqlF);

				while (rs2.next()) {
					facilitiesName = rs2.getString("Facilities_Name");
				}

				ReservationDTO dto = new ReservationDTO(reserveID, facilitiesName, memberID, reserveName, reservePnum,
						HeadCount, reserveDate, reserveStart, reserveEnd, carNum, carName, isCancel);

				reservationArr.add(dto);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (rs2 != null) rs2.close();
				if (st2 != null) st2.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return reservationArr;
	}

	// 수정 -> 조회
	public ReservationDTO inquiry(String rID) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sogongdo.reservation WHERE isCancel = '0' and Reservation_ID = '" + rID + "'";
		System.out.println(sql);
		ReservationDTO reservation =null;

		Statement st2 = null;
		ResultSet rs2 = null;
		String facilitiesName = "";

		try {

			conn = ds.getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				String reserveID = rs.getString("Reservation_ID");
				String facilitiesID = rs.getString("Facilities_ID");
				String memberID = rs.getString("Member_ID");
				String reserveName = rs.getString("Reservation_Name");
				String reservePnum = rs.getString("Reservation_Phone_Number");
				String HeadCount = rs.getString("HeadCount");
				String reserveDate = rs.getString("Reservation_Date");
				String reserveStart = rs.getString("Reservation_Start");
				String reserveEnd = rs.getString("Reservation_End");
				String isCancel = rs.getString("isCancel");
				String carNum = rs.getString("Car_Num");
				String carName = rs.getString("Car_Name");

				String sqlF = "SELECT Facilities_Name FROM sogongdo.facilities WHERE Facilities_ID = '" + facilitiesID
						+ "'";
				
				System.out.println(reserveID + "/" + reserveName);
				//conn = ds.getConnection();
				st2 = conn.createStatement();
				rs2 = st2.executeQuery(sqlF);

				while (rs2.next()) {
					facilitiesName = rs2.getString("Facilities_Name");
				}

				reservation = new ReservationDTO(reserveID, facilitiesName, memberID, reserveName, reservePnum,
						HeadCount, reserveDate, reserveStart, reserveEnd, carNum, carName, isCancel);

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (rs2 != null) rs2.close();
				if (st2 != null) st2.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return reservation;
	}

	// 등록
	public int register(ReservationDTO reservation) {
		Connection conn = null;

		PreparedStatement st = null;
		Statement st2 = null;
		Statement st3 = null;
		Statement st4 = null;

		ResultSet rs2 = null; // Select 결과1
		ResultSet rs3 = null; // Select 결과2
		ResultSet count = null; // 예약개수
		String facilitiesID = "";
		String memberID = "";

		int result = 0; // Insert 결과

		String sqlM = "SELECT Member_ID FROM sogongdo.member WHERE Member_Name = '" + reservation.getReservation_Name()
				+ "'";
		String sqlC = "SELECT COUNT(*) from sogongdo.reservation WHERE isCancel = 0";
		String sqlF = "SELECT Facilities_ID FROM sogongdo.facilities WHERE Facilities_Name = '"
				+ reservation.getFacilities_Name() + "'";
		String sql1 = "INSERT INTO sogongdo.reservation (Reservation_ID,Facilities_ID, Member_ID, Reservation_Name,Reservation_Phone_Number,"
				+ "HeadCount, Reservation_Date, Reservation_Start, Reservation_End, isCancel,Car_Num, Car_Name) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "INSERT INTO sogongdo.reservation (Reservation_ID,Facilities_ID, Member_ID, Reservation_Name,Reservation_Phone_Number,"
				+ "HeadCount, Reservation_Date, Reservation_Start, Reservation_End, isCancel) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			conn = ds.getConnection();
			st2 = conn.createStatement();
			rs2 = st2.executeQuery(sqlM);

			if (rs2.next()) {
				memberID = rs2.getString("Member_ID");
			}

			//conn = ds.getConnection();
			st3 = conn.createStatement();
			rs3 = st3.executeQuery(sqlF);

			if (rs3.next()) {
				facilitiesID = rs3.getString("Facilities_ID");
			}
			
			//conn = ds.getConnection();
			st4 = conn.createStatement();
			count = st4.executeQuery(sqlC);

			int cnt = 0;
			while (count.next()) {
				cnt = count.getInt(1);
			}
			System.out.println("Reserve Count 수 : "+ cnt);

			// conn = ds.getConnection();

			if (reservation.getCar_Name() != null) {
				st = conn.prepareStatement(sql1);

				st.setString(1, Integer.toString(cnt + 1));
				st.setString(2, facilitiesID);
				st.setString(3, memberID);
				st.setString(4, reservation.getReservation_Name());
				st.setString(5, reservation.getReservation_Phone_Number());
				st.setString(6, reservation.getHeadCount());
				st.setString(7, reservation.getReservation_Date());
				st.setString(8, reservation.getReservation_Start());
				st.setString(9, reservation.getReservation_End());
				st.setString(10, reservation.getIsCancel());
				st.setString(11, reservation.getCar_Num());
				st.setString(12, reservation.getCar_Name());
			} else {
				st = conn.prepareStatement(sql2);

				st.setString(1, Integer.toString(cnt + 1));
				st.setString(2, facilitiesID);
				st.setString(3, memberID);
				st.setString(4, reservation.getReservation_Name());
				st.setString(5, reservation.getReservation_Phone_Number());
				st.setString(6, reservation.getHeadCount());
				st.setString(7, reservation.getReservation_Date());
				st.setString(8, reservation.getReservation_Start());
				st.setString(9, reservation.getReservation_End());
				st.setString(10, reservation.getIsCancel());
			}

			System.out.println(st.toString());
			result = st.executeUpdate();
			
			

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (rs2 != null) rs2.close();
				if (st != null) st.close();
				if (rs3 != null) rs3.close();
				if (st2 != null) st2.close();
				if (st3 != null) st3.close();
				if (st4 != null) st4.close();
				if (conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;

	}

	// 삭제
	public int delete(String[] id) {
		if (id.length <= 0) {
			return 0;
		} else {
			Connection conn = null;
			Statement st = null;
			int result = 0; 
			
			Statement st4 = null;
			ResultSet rs4 = null;

			PreparedStatement pst = null;
			
			int num = (Integer.parseInt(id[0]));
			
			
			String sqlC = "SELECT COUNT(*) from sogongdo.reservation WHERE isCancel = 0";
			
			String sql = "DELETE FROM sogongdo.reservation WHERE Reservation_ID IN (";
			try {
				conn = ds.getConnection();
				st = conn.createStatement();

				for (int i = 0; i < id.length; i++) {
					sql += "'" + id[i] + "',";
				}
				sql = sql.substring(0, sql.length() - 1);
				sql += ")";
				result = st.executeUpdate(sql);
				
				//conn = ds.getConnection();
				st4 = conn.createStatement();
				rs4 = st4.executeQuery(sqlC);

				int cnt = 0;
				while (rs4.next()) {
					cnt = rs4.getInt(1);
				}		
			
				//conn = ds.getConnection();
				pst = conn.prepareStatement(sql);
				
				for(int i = num; i<cnt+1;i++) {
					String sql2 = "UPDATE sogongdo.reservation SET Reservation_ID= '" + Integer.toString(i) +"'WHERE Reservation_ID = '"+Integer.toString(i+1)+"'";
					System.out.println(sql2);
					pst = conn.prepareStatement(sql2);

					pst.executeUpdate();
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (st != null) st.close();
					if (rs4 != null) rs4.close();
					if (st4 != null) st4.close();
					if (pst != null) pst.close();
					if (conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return result;
		}
	}

	// 수정
	public int update(String id, ReservationDTO reserve) {
		Connection conn = null;
		PreparedStatement st = null;
		int rs = 0;		
		Statement st2 = null;
		Statement st3 = null;

		ResultSet rs2 = null; // Select 결과1
		ResultSet rs3 = null; // Select 결과2
		
		String facilitiesID = "";
		String memberID = "";

		int result = 0; // Insert 결과

		String sqlM = "SELECT Member_ID FROM sogongdo.member WHERE Member_Name = '" + reserve.getReservation_Name()
				+ "'";

		String sql = "UPDATE sogongdo.reservation "
				+ "SET Reservation_ID=?, Facilities_ID=?, Member_ID=?,Reservation_Name=?,"
				+ "Reservation_Phone_Number =?, HeadCount = ?,"
				+ "Reservation_Date=?,Reservation_Start=?,Reservation_End=?,isCancel=?," + "Car_Num = ?, Car_Name = ?"
				+ " WHERE Reservation_ID = ?";
		String sqlF = "SELECT Facilities_ID FROM sogongdo.facilities WHERE Facilities_Name = '"
				+ reserve.getFacilities_Name() + "'";
		
		try {
			conn = ds.getConnection();
			st2 = conn.createStatement();
			rs2 = st2.executeQuery(sqlM);

			if (rs2.next()) {
				memberID = rs2.getString("Member_ID");
			}

			//conn = ds.getConnection();
			st3 = conn.createStatement();
			rs3 = st3.executeQuery(sqlF);

			if (rs3.next()) {
				facilitiesID = rs3.getString("Facilities_ID");
			}
	
			System.out.println(memberID + "/" + facilitiesID + "/" + reserve.getReservation_Name());
			
			
			//conn = ds.getConnection();
			st = conn.prepareStatement(sql);

			st.setInt(1,Integer.parseInt(reserve.getReservation_ID()));
			st.setString(2, facilitiesID);
			st.setString(3, memberID);
			st.setString(4, reserve.getReservation_Name());
			st.setString(5, reserve.getReservation_Phone_Number());
			st.setString(6, reserve.getHeadCount());
			st.setString(7, reserve.getReservation_Date());
			st.setString(8, reserve.getReservation_Start());
			st.setString(9, reserve.getReservation_End());
			st.setString(10, reserve.getIsCancel());
			st.setString(11, reserve.getCar_Num());
			st.setString(12, reserve.getCar_Name());
			st.setString(13, id);
			
			
			rs = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) st.close();
				if (rs2 != null) rs2.close();
				if (st2 != null) st2.close();
				if (rs3 != null) rs3.close();
				if (st3 != null) st3.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
