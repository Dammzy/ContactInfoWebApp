/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.*;
 

/**
 *
 * @author ADEKANMBI
 */
public class UserDAO {
    private Connection conn;

    public UserDAO(Connection conn) {
        
        this.conn = conn;
    }
    
    public boolean userRegister(User u)
    {
       boolean f=false;
       
       try {
           String sql = "insert into users(name,email,password) values(?,?,?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           
           ps.setString(1, u.getName());
           ps.setString(2, u.getEmail());
           ps.setString(3, u.getPassword());
           
           int i = ps.executeUpdate();
           if (i == 1) {
               f = true;
           }
           
       } catch (Exception e) {
          e.printStackTrace();
       }
       
       return f;
       
    }
    
    
    public User loginUser(String e) {
        User user=null;
        try {
           String sql="SELECT * from users WHERE email=?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, e);
           
           
           ResultSet rs = ps.executeQuery();
           
           if(rs.next()){
               user = new User();
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
               user.setEmail(rs.getString("email"));
               user.setPassword(rs.getString("password"));
               
               
           }
           
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
