package example.dao;

import com.mysql.jdbc.Driver;
import example.dto.Role;

import java.sql.*;

public class RoleDao {
  private static String dburl="jdbc:mysql://localhost:3306/connectdb?useSSL=false";
  private static String dbUser="connectuser";
  private static String dbpasswd="connectuser123!@#";

  public Role getRole(Integer roleId){
    Role role= null;
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;

    try{
      Class.forName("com.mysql.jdbc.Driver");  //driver 로딩
      conn= DriverManager.getConnection(dburl,dbUser,dbpasswd);  //접속할 수 있는 커넥션 객체
      String sql="SELECT role_id,description FROM role WHERE role_id = ?";  //?= ?만 바뀌기 때문에 실행될 때 효율증가
      ps=conn.prepareStatement(sql);
      ps.setInt(1, roleId);  // ? 값 설정
      rs=ps.executeQuery(); //실행해 주세요.
      if(rs.next()){  //next는 값이 있으면 true;
        int id=rs.getInt(1);
        String description=rs.getString("description");
        role=new Role(id,description);
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      if(rs!=null){
        try {
          rs.close();
        } catch (SQLException e){
          e.printStackTrace();
        }
      }
      if(ps!=null){
        try {
          ps.close();
        } catch (SQLException e){
          e.printStackTrace();
        }
      }
      if(conn!=null){
        try {
          conn.close();
        } catch (SQLException e){
          e.printStackTrace();
        }
      }
    }
    return role;
  }

}
