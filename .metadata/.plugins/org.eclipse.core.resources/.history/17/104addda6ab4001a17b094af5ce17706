package persistance;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class AuthorityDAO {
    private DataSource ds;

    public AuthorityDAO(){
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    public ArrayList<AuthorityDTO> select() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Authorization";
        ArrayList<AuthorityDTO> articles = new ArrayList<AuthorityDTO>();
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("Authority_ID");
                String mid = rs.getString("Member_ID");
                AuthorityDTO dto = new AuthorityDTO(id,mid);
                articles.add(dto);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return articles;
    }

    public void insert(AuthorityDTO dto){
        Connection conn= null;
        PreparedStatement pst = null;
        String sql = "INSERT INTO Authorization (`Authority_ID`,`Member_ID`) VALUES (?,?)";
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,dto.getAuthority_ID());
            pst.setString(2,dto.getMember_ID());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(AuthorityDTO dto){
        Connection conn= null;
        PreparedStatement pst = null;
        String sql = "DELETE FROM `Authorization` WHERE `Authority_ID`=? AND `Member_ID`=?";
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,dto.getAuthority_ID());
            pst.setString(2,dto.getMember_ID());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(AuthorityDTO dto)
    {
        Connection conn= null;
        PreparedStatement pst = null;
        String sql = "UPDATE Authorization SET `Authority_Name`=? WHERE `Member_ID`=?";
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1,dto.getAuthority_ID());
            pst.setString(2,dto.getMember_ID());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
