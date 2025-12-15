/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Contact;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADEKANMBI
 */
public class ContactDAO {
    private Connection conn;

    public ContactDAO(Connection conn) {
        this.conn = conn;
      };
    public boolean saveContact(Contact c)
    {
        boolean f = false;
        try {
            String sql ="insert into contacts(name,phone,email,about,userID) values(?,?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getAbout());
            ps.setInt(5, c.getUserID());
            
            
            int i = ps.executeUpdate();
            
            if(i==1){
                f=true;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    public List<Contact> getAllContact(int uId)
    {
        List<Contact> list = new ArrayList<Contact>();
        Contact c = null;
        try {
            String sql = "select * from contacts where userID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, uId);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                c = new Contact();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhone(rs.getString(4));
                c.setAbout(rs.getString(5));
                list.add(c);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Contact getContactByID(int cid) {
        
        Contact c = new Contact();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from contacts where id=?");
            ps.setInt(1, cid);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setEmail(rs.getString(3));
                c.setPhone(rs.getString(4));
                c.setAbout(rs.getString(5));
            }
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return c;
    }
   
    public boolean updateContact(Contact c) {
        boolean f = false;
        try {
            String sql ="update contacts set name=?, phone=?, email=?, about=? where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getAbout());
            ps.setInt(5, c.getId());
            
            
            int i = ps.executeUpdate();
            
            if(i==1){
                f=true;
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        return f;
    }
    
    public boolean deletContactById(int cid) {
        boolean f = false;
        try {
            String sql = "delete from contacts where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
    }
}
