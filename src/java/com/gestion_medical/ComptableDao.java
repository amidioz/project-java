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
public class ComptableDao {
     public Comptable getComptable(int id){
        Comptable comptable = null;
        User user;
        UserDao userDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from comptable WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                
                user = userDao.getUser(rs.getInt("user_id"));
                comptable.setId(id);
                comptable.setDebutTravaux(rs.getDate("debut_travaux"));
                comptable.setFinTravaux(rs.getDate("fin_travaux"));
                comptable.setUser(user);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return comptable;
    }
    
    public int addComptable(Comptable comptable){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `comptable` (`debut_travaux`,`fin_travaux`,`user_id`) VALUES(?,?,?)");
            
            userDao = new UserDao();
            userDao.addUser(comptable.getUser());
            
            ps.setDate(1, comptable.getDebutTravaux());
            ps.setDate(2, comptable.getFinTravaux());
            ps.setInt(3, userDao.getUser(comptable.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteComptable(int id){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `comptable` WHERE id=?");
            ps.setInt(1, id);
            
            userDao = new UserDao();
            userDao.deleteUser(getComptable(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateComptable(Comptable comptable){    return 0;}
}
