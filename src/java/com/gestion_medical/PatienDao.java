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
public class PatienDao {
     public Patien getPatien(int id){
        UserDao userDao;
        User user;
        Patien patien = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from patien WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                patien = new Patien();
                user = new User();
                
                user = userDao.getUser(rs.getInt("user_id"));
                patien.setId(rs.getInt("id"));
                patien.setUser(user);
                
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return patien;
    }
    
    public int addPatien(Patien patien){ 
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `patien` (`user_id`) VALUES(?)");
            
            userDao = new UserDao();
            userDao.addUser(patien.getUser());
            
            ps.setInt(1, userDao.getUser(patien.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deletePatien(int id){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `patien` WHERE id=?");
            ps.setInt(1, id);
            
            userDao = new UserDao();
            userDao.deleteUser(getPatien(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDatePatien(Patien patien){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("UPDATE `patien` SET `user_id`=? WHERE id=?");
            ps.setInt(1, patien.getUser().getId());
            ps.setInt(2, patien.getId());
            
            userDao = new UserDao();
            userDao.upDateUser(patien.getUser());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
}
