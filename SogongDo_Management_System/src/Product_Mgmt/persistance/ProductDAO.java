package Product_Mgmt.persistance;

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

public class ProductDAO {
	private DataSource ds;

	public ProductDAO() {
		try {
			Context context = new InitialContext();  //������ �ҽ� �ʱ�ȭ
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");// jdbc/MySQL ���ҽ� �̸�
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ǰ �˻�
	public ArrayList<ProductDTO> searchProduct(String productName){ 
		ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
		try {//���� ���� �ؼ� ���� �ѱ��.
		Connection conn = ds.getConnection(); //������ �ҽ��� ����
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM sogongdo.product WHERE Product_Name LIKE '%"+productName+"%';";
		ResultSet rs = st.executeQuery(sql);
		
			while (rs.next()) {
				String product_ID = rs.getString("Product_ID");
				String product_Name = rs.getString("Product_Name");
				String product_Kinds = rs.getString("Product_Kinds");
				int product_Price = rs.getInt("Product_Price");
				int product_Stock = rs.getInt("Product_Stock");
				
				ProductDTO pDTO = new ProductDTO(product_ID,product_Name,product_Kinds,product_Price,product_Stock);
				products.add(pDTO);
			}
			  if(rs != null) try { rs.close(); } catch(SQLException sqle) {}
	            if(st != null) try { st.close(); } catch(SQLException sqle) {}
	            if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	
	
	//��ǰ ��ȸ
	public ArrayList<ProductDTO> displayProduct(){ 
		ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
		
		try {//���� ���� �ؼ� ���� �ѱ��.
		Connection conn = ds.getConnection(); //������ �ҽ��� ����
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM sogongdo.product;";
		ResultSet rs = st.executeQuery(sql);
		
		
			while (rs.next()) {
				String product_ID = rs.getString("Product_ID");
				String product_Name = rs.getString("Product_Name");
				String product_Kinds = rs.getString("Product_Kinds");
				int product_Price = rs.getInt("Product_Price");
				int product_Stock = rs.getInt("Product_Stock");
				
				ProductDTO pDTO = new ProductDTO(product_ID,product_Name,product_Kinds,product_Price,product_Stock);
				products.add(pDTO);
			}
			if(rs != null) try { rs.close(); } catch(SQLException sqle) {}
            if(st != null) try { st.close(); } catch(SQLException sqle) {}
            if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	//���
	public int enrollProduct(ProductDTO products) {
		 String product_Name = products.getProduct_Name();
		 String product_Kinds = products.getProduct_Kinds();
		 int product_Price = products.getProduct_Price();
		 int product_Stock = products.getProduct_Stock();
		 int rowCount = 0;
		try {//���� ���� �ؼ� ���� �ѱ��.
			Connection conn = ds.getConnection(); //������ �ҽ��� ����
			Statement st = conn.createStatement();
			String sql = "SELECT * FROM sogongdo.product;";
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				if(product_Name.equals(rs.getString("Product_Name"))) return -1; //�ߺ� �˻�
			}
			
			sql = "INSERT INTO `sogongdo`.`product`(`Product_Name`,`Product_Kinds`,`Product_Price`,`Product_Stock`)\r\n" 
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, product_Name);
			pstmt.setString(2, product_Kinds);
			pstmt.setInt(3, product_Price);
			pstmt.setInt(4, product_Stock);
			rowCount = pstmt.executeUpdate();
			
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount; //��� ����
	}
	
	//����
	public int updateProduct(ProductDTO products) {
		 String product_ID = products.getProduct_ID();
		 String product_Name = products.getProduct_Name();
		 String product_Kinds = products.getProduct_Kinds();
		 int product_Price = products.getProduct_Price();
		 int product_Stock = products.getProduct_Stock();
		 int rowCount=0;
		try {//���� ���� �ؼ� ���� �ѱ��.
			Connection conn = ds.getConnection(); //������ �ҽ��� ����
			String sql = "UPDATE `sogongdo`.`product` SET `Product_Name` = ?,`Product_Kinds` = ?,`Product_Price` = ?,`Product_Stock` = ?\r\n" + 
					"WHERE `Product_ID` = ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, product_Name);
			pstmt.setString(2, product_Kinds);
			pstmt.setInt(3, product_Price);
			pstmt.setInt(4, product_Stock);
			pstmt.setString(5, product_ID);
			rowCount = pstmt.executeUpdate();
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	//����
	public void deleteProduct(String id) {
		try {//���� ���� �ؼ� ���� �ѱ��.
			Connection conn = ds.getConnection(); //������ �ҽ��� ����
			String sql = "DELETE FROM `sogongdo`.`product` WHERE Product_ID = ?";
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

/*
��� ������ : �ڼ���
������ : �ڼ���, ����ȯ
���� ��¥: 2020-06-05
���� ���� : 2020-06-08
���� ���� : ��� / ���� �Լ� ���� Ÿ��(int) ����
*/