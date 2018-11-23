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
public class SpecialiteDao {
     public Specialite getSpecialite(int id){
        Specialite specialite = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from specialite WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                specialite.setId(id);
                specialite.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return specialite;
    }
    
    public int addSpecialite(Specialite specialite){  
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `specialite` (`name`) VALUES(?)");
            
            ps.setString(1, specialite.getName());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteSpecialite(int id){  
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `specialite` WHERE id=?");
            ps.setInt(1, id);
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateSpecialite(Specialite specialite){    return 0;}
}
