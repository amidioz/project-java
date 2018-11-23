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
public class MaladieDao {
     public Maladie getMaladie(int id){
        Maladie maladie = null;
        Consultation consultation;
        ConsultationDao consultationDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from maladie WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                consultationDao = new ConsultationDao();
                
                consultation = consultationDao.getConsultation(rs.getInt("consultation_id"));
                maladie.setId(id);
                maladie.setConsultation(consultation);
                maladie.setPrix(rs.getFloat("prix"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return maladie;
    }
    
    public int addMaladie(Maladie maladie){  
        ConsultationDao consultationDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `maladie` (`consultation_id`,`prix`) VALUES(?,?)");
            
            consultationDao = new ConsultationDao();
            consultationDao.addConsultation(maladie.getConsultation());
            
            ps.setInt(1, consultationDao.getConsultation(maladie.getConsultation().getId()).getId());
            ps.setFloat(2, maladie.getPrix());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteMaladie(int id){  
        ConsultationDao consultationDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `maladie` WHERE id=?");
            ps.setInt(1, id);
            
            consultationDao = new ConsultationDao();
            consultationDao.deleteConsultation(getMaladie(id).getConsultation().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateMaladie(Maladie maladie){    return 0;}
}
