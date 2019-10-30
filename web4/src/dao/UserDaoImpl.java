package dao;

import JdbcUtils.JdbcUtils;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByUsername(String username){
        Connection c=null;
        PreparedStatement prst=null;
        try{
            c=JdbcUtils.getConnection();
            prst=c.prepareStatement("SELECT * FROM user WHERE username=?");
            prst.setString(1,username);
            ResultSet rs=prst.executeQuery();
            if(rs==null){
                return null;
            }
            if(rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new RuntimeException();
        }finally {
            try {
                if(prst!=null)prst.close();
                if(c!=null)c.close();
            } catch (SQLException e) {
               throw new RuntimeException();
            }
        }
    }
    @Override
    public void add(User user) {
        Connection c=null;
        PreparedStatement prst=null;
        try{
            c = JdbcUtils.getConnection();
            String sql="insert into user values(?,?)";
            prst=c.prepareStatement(sql);
            prst.setString(1,user.getUsername());
            prst.setString(2,user.getPassword());
            prst.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException();
        }finally{
             {
                try {
                    if(prst!=null) prst.close();
                    if(c!=null) c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

