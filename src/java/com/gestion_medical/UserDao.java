/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

import static com.gestion_medical.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abdelhamid
 */
public class UserDao {
    public User getUser(String userName,String password){
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from user WHERE userName=? and password=?");
            ps.setString(1, userName);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDdn(rs.getDate("ddn"));
                user.setAddress(rs.getString("address"));
                user.setLdn(rs.getString("ldn"));
                user.setPhone(rs.getString("phone"));
                user.setSex(rs.getInt("sex"));
                user.setUserType(rs.getString("userType"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return user;
    }
    
    public User getUser(String userName){
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from user WHERE userName=?");
            ps.setString(1, userName);
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDdn(rs.getDate("ddn"));
                user.setAddress(rs.getString("address"));
                user.setLdn(rs.getString("ldn"));
                user.setPhone(rs.getString("phone"));
                user.setSex(rs.getInt("sex"));
                user.setUserType(rs.getString("userType"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return user;
    }
    
    public User getUser(int id){
        User user = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from user WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDdn(rs.getDate("ddn"));
                user.setAddress(rs.getString("address"));
                user.setLdn(rs.getString("ldn"));
                user.setPhone(rs.getString("phone"));
                user.setSex(rs.getInt("sex"));
                user.setUserType(rs.getString("userType"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return user;
    }
    
    public int addUser(User user){  
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `user` (`username`, `password`, `firstname`, `lastname`, `ddn`, `address`, `ldn`, `phone`, `usertype`, `sex`) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setDate(5, user.getDdn());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getLdn());
            ps.setString(8, user.getPhone());
            ps.setString(9, user.getUserType());
            ps.setInt(10, user.getSex());
            
            if(getUser(user.getUserName()) == null){
                i = ps.executeUpdate();
            }
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteUser(int id){  
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `user` WHERE id=?");
            ps.setInt(1, id);
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateUser(User user){
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("UPDATE `user` SET `username`=?,`password`=?,`firstname`=?,`lastname`=?,`ddn`=?,`address`=?,`ldn`=?,`phone`=?,`usertype`=?,`sex`=? WHERE id=?");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setDate(5, user.getDdn());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getLdn());
            ps.setString(8, user.getPhone());
            ps.setString(9, user.getUserType());
            ps.setInt(10, user.getSex());
            ps.setInt(11, user.getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    
}
