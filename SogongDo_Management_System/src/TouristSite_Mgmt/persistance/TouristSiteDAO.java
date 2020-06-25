/*
    모듈 설계자 : 이희수

    검토자 : 박성용
    검토 날짜: 2020/06/12

    수정 일자 :
    수정 내용 :
*/
package TouristSite_Mgmt.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TouristSiteDAO {
	private DataSource ds;
	
	public TouristSiteDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<TouristSiteDTO> getTouristSiteByName(String name){
		List<TouristSiteDTO> list = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlstr = "select * from tourist_site where tourist_Site_Name like ?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setString(1, name);
		
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				int tourist_site_id = resultSet.getInt("Tourist_Site_ID");
				String tourist_site_name = resultSet.getString("tourist_Site_Name");
	
				TouristSiteDTO temp = new TouristSiteDTO(tourist_site_id, tourist_site_name);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		return list;
	}

	public List<TouristSiteDTO> getAllTouristSite() {
		List<TouristSiteDTO> list = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlstr = "select * from tourist_site";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
		
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				int tourist_site_id = resultSet.getInt("Tourist_Site_ID");
				String tourist_site_name = resultSet.getString("tourist_Site_Name");
	
				TouristSiteDTO temp = new TouristSiteDTO(tourist_site_id, tourist_site_name);
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public TouristSiteDTO getTouristSite(int id) {
		TouristSiteDTO temp = null;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlstr = "select * from tourist_site where tourist_site_id =?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setInt(1, id);
			
			resultSet = pstmt.executeQuery();
	
			if (resultSet.next()) {
				int tourist_site_id = resultSet.getInt("Tourist_Site_ID");
				String tourist_site_name = resultSet.getString("tourist_Site_Name");
				temp = new TouristSiteDTO(tourist_site_id, tourist_site_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return temp;
	}

	public void insertTouristSite(TouristSiteDTO touristSite) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlstr = "insert into tourist_site values(null, ?)";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setString(1, touristSite.getTourist_site_name());
	        pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void updateTouristSite(TouristSiteDTO touristSite) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlstr = "update tourist_site set tourist_site_name =? where tourist_site_id = ?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setString(1, touristSite.getTourist_site_name());
			pstmt.setInt(2, touristSite.getTourist_site_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteTouristSite(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlstr = "delete from tourist_site where tourist_site_id = ?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// -------------------- TouristSite Attribute Data Access

	public TouristSiteAttributeDTO getAttribute(int id) {
		TouristSiteAttributeDTO temp = null;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String sqlstr = "select * from tourist_site_attribute where tourist_site_id =?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setInt(1, id);		
			resultSet = pstmt.executeQuery();
			
			if (resultSet.next()) {
				int tourist_site_id = resultSet.getInt("Tourist_Site_ID");
				String tourist_site_address = resultSet.getString("Tourist_Site_Address");
				String tourist_site_phone_number = resultSet.getString("Tourist_Site_Phone_Number");
				int registration_number = resultSet.getInt("Registration_Number");
				String representative_name = resultSet.getString("Representative_Name");
				temp = new TouristSiteAttributeDTO(tourist_site_id, tourist_site_address, tourist_site_phone_number, registration_number, representative_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
				if(resultSet != null) resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return temp;
	}
	
	public void insertAttribute(TouristSiteAttributeDTO Attribute) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlstr = "insert into tourist_site_attribute values(?,?,?,?,?)";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setInt(1, Attribute.getTourist_site_id());
			pstmt.setString(2, Attribute.getTourist_site_address());
			pstmt.setString(3, Attribute.getTourist_site_phone_number());
			pstmt.setInt(4, Attribute.getRegistration_number());
			pstmt.setString(5, Attribute.getRepresentative_name());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateAttribute(TouristSiteAttributeDTO Attribute) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlstr = "update tourist_site_attribute set tourist_site_address =?, tourist_site_phone_number = ?, registration_number = ?"
				+ ", representative_name = ? where tourist_site_id = ?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setString(1, Attribute.getTourist_site_address());
			pstmt.setString(2, Attribute.getTourist_site_phone_number());
			pstmt.setInt(3, Attribute.getRegistration_number());
			pstmt.setString(4, Attribute.getRepresentative_name());
			pstmt.setInt(5, Attribute.getTourist_site_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteAttribute(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String sqlstr = "delete from tourist_site_attribute where tourist_site_id = ?";
		
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlstr);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
