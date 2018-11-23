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
public class RecepteurDao {
     public Recepteur getRecepteur(int id){
        UserDao userDao;
        User user;
        RecepteurDao recepteurDao;
        Recepteur recepteur = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from recepteur WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                recepteur = new Recepteur();
                
                user = userDao.getUser(rs.getInt("user_id"));
                recepteur.setId(rs.getInt("id"));
                recepteur.setUser(user);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return recepteur;
    }
    
    public int addRecepteur(Recepteur recepteur){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `recepteur` (`user_id`) VALUES(?)");
            
            userDao = new UserDao();
            userDao.addUser(recepteur.getUser());
            
            ps.setInt(1, userDao.getUser(recepteur.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteRecepteur(int id){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `recepteur` WHERE id=?");
            ps.setInt(1, id);
            
            userDao = new UserDao();
            userDao.deleteUser(getRecepteur(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateRecepteur(Recepteur recepteur){    return 0;}
}
