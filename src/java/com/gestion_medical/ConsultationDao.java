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
public class ConsultationDao {
     public Consultation getConsultation(int id){
        Consultation consultation = null;
        Patien patien;
        PatienDao patienDao;
        Medcin medcin;
        MedcinDao medcinDao;
        Rendez_vous rendez_vous;
        Rendez_vousDao rendez_vousDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from consultation WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                medcinDao = new MedcinDao();
                patienDao = new PatienDao();
                rendez_vousDao = new Rendez_vousDao();
                
                medcin = medcinDao.getMedcin(rs.getInt("medcin_id"));
                patien = patienDao.getPatien(rs.getInt("patient_id"));
                rendez_vous = rendez_vousDao.getRendez_vous(rs.getInt("rendez-vous_id"));
                consultation.setId(id);
                consultation.setPatien(patien);
                consultation.setMedcin(medcin);
                consultation.setRendez_vous(rendez_vous);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return consultation;
    }
    
    public int addConsultation(Consultation consultation){  
        PatienDao patienDao;
        MedcinDao medcinDao;
        Rendez_vousDao rendez_vousDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `consultation` (`patient_id`,`medcin_id`,`rendez-vous_id`) VALUES(?,?,?)");
            
            patienDao = new PatienDao();
            medcinDao = new MedcinDao();
            rendez_vousDao = new Rendez_vousDao();
            patienDao.addPatien(consultation.getPatien());
            medcinDao.addMedcin(consultation.getMedcin());
            rendez_vousDao.addRendez_vous(consultation.getRendez_vous());
            
            ps.setInt(1, patienDao.getPatien(consultation.getPatien().getId()).getId());
            ps.setInt(2, medcinDao.getMedcin(consultation.getMedcin().getId()).getId());
            ps.setInt(3, rendez_vousDao.getRendez_vous(consultation.getRendez_vous().getId()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteConsultation(int id){  
        PatienDao patienDao;
        MedcinDao medcinDao;
        Rendez_vousDao rendez_vousDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `consultation` WHERE id=?");
            ps.setInt(1, id);
            
            patienDao = new PatienDao();
            medcinDao = new MedcinDao();
            rendez_vousDao = new Rendez_vousDao();
            patienDao.deletePatien(getConsultation(id).getPatien().getId());
            medcinDao.deleteMedcin(getConsultation(id).getMedcin().getId());
            rendez_vousDao.deleteRendez_vous(getConsultation(id).getRendez_vous().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateConsultation(Consultation consultation){    return 0;}
}
