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
public class LaboratoireDao {
     public Laboratoire getLaboratoire(int id){
        Laboratoire laboratoire = null;
        User user;
        UserDao userDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from laboratoire WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                
                user = userDao.getUser(rs.getInt("user_id"));
                laboratoire.setId(id);
                laboratoire.setUser(user);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return laboratoire;
    }
    
    public int addLaboratoire(Laboratoire laboratoire){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `laboratoire` (`user_id`) VALUES(?)");
            
            userDao = new UserDao();
            userDao.addUser(laboratoire.getUser());
            
            ps.setInt(1, userDao.getUser(laboratoire.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteLaboratoire(int id){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `laboratoire` WHERE id=?");
            ps.setInt(1, id);
            
            userDao = new UserDao();
            userDao.deleteUser(getLaboratoire(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateLaboratoire(Laboratoire laboratoire){    return 0;}
}
