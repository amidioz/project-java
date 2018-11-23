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
public class RadioDao {
     public Radio getRadio(int id){
        Radio radio = null;
        Consultation consultation;
        ConsultationDao consultationDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from radio WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                consultationDao = new ConsultationDao();
                
                consultation = consultationDao.getConsultation(rs.getInt("consultation_id"));
                radio.setId(id);
                radio.setConsultation(consultation);
                radio.setPrix(rs.getFloat("prix"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return radio;
    }
    
    public int addRadio(Radio radio){  
        ConsultationDao consultationDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `radio` (`consultation_id`,`prix`) VALUES(?,?)");
            
            consultationDao = new ConsultationDao();
            consultationDao.addConsultation(radio.getConsultation());
            
            ps.setInt(1, consultationDao.getConsultation(radio.getConsultation().getId()).getId());
            ps.setFloat(2, radio.getPrix());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteRadio(int id){  
        ConsultationDao consultationDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `radio` WHERE id=?");
            ps.setInt(1, id);
            
            consultationDao = new ConsultationDao();
            consultationDao.deleteConsultation(getRadio(id).getConsultation().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateRadio(Radio radio){    return 0;}
}
