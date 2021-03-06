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
public class OrdonnanceDao {
     public Ordonnance getOrdonnance(int id){
        Ordonnance ordonnance = null;
        Consultation consultation;
        ConsultationDao consultationDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from ordonnance WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                consultationDao = new ConsultationDao();
                
                consultation = consultationDao.getConsultation(rs.getInt("consultation_id"));
                ordonnance.setId(id);
                ordonnance.setConsultation(consultation);
                ordonnance.setPrix(rs.getFloat("prix"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return ordonnance;
    }
    
    public int addOrdonnance(Ordonnance ordonnance){  
        ConsultationDao consultationDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `ordonnance` (`consultation_id`,`prix`) VALUES(?,?)");
            
            consultationDao = new ConsultationDao();
            consultationDao.addConsultation(ordonnance.getConsultation());
            
            ps.setInt(1, consultationDao.getConsultation(ordonnance.getConsultation().getId()).getId());
            ps.setFloat(2, ordonnance.getPrix());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteOrdonnance(int id){  
        ConsultationDao consultationDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `ordonnance` WHERE id=?");
            ps.setInt(1, id);
            
            consultationDao = new ConsultationDao();
            consultationDao.deleteConsultation(getOrdonnance(id).getConsultation().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateOrdonnance(Ordonnance ordonnance){    return 0;}
}
