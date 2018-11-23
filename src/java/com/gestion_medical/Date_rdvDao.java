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
public class Date_rdvDao {
     public Date_rdv getDate_rdv(int id){
        Date_rdv date_rdv = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from date_rdv WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                date_rdv.setId(id);
                date_rdv.setDebut(rs.getDate("debut"));
                date_rdv.setFin(rs.getDate("fin"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return date_rdv;
    }
    
    public int addDate_rdv(Date_rdv date_rdv){  
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `date_rdv` (`debut`,`fin`) VALUES(?,?)");
            
            ps.setDate(1, date_rdv.getDebut());
            ps.setDate(2, date_rdv.getFin());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteDate_rdv(int id){  
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `date_rdv` WHERE id=?");
            ps.setInt(1, id);
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateDate_rdv(Date_rdv date_rdv){    return 0;}
}
