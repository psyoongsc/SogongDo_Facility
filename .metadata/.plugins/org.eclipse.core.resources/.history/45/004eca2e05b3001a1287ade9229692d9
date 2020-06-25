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
        String sql = "SELECT * FROM Authority";
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
                String id = rs.getString("Authority_ID");
                String aname = rs.getString("Authority_Name");
                AuthorityDTO dto = new AuthorityDTO(id,aname);
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
        String sql = "INSERT INTO Authority (`Authority_ID`,`Authority_Name`) VALUES (?,?)";
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,dto.getID());
            pst.setString(2,dto.getAuthorityName());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(AuthorityDTO dto){
        Connection conn= null;
        PreparedStatement pst = null;
        String sql = "DELETE FROM `Authority` WHERE `Authority_ID`=? AND `Authority_Name`=?";
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,dto.getID());
            pst.setString(2,dto.getAuthorityName());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(AuthorityDTO dto)
    {
        Connection conn= null;
        PreparedStatement pst = null;
        String sql = "UPDATE Authority SET `Authority_Name`=? WHERE `Authority_ID`=?";
        try{
            conn = ds.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,dto.getAuthorityName());
            pst.setString(2,dto.getID());
            pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
