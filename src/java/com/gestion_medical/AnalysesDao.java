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
public class AnalysesDao {
     public Analyses getAnalyses(int id){
        Analyses analyses = null;
        Consultation consultation;
        ConsultationDao consultationDao;
        Laboratoire laboratoire;
        LaboratoireDao laboratoireDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from analyses WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                consultationDao = new ConsultationDao();
                laboratoireDao = new LaboratoireDao();
                
                consultation = consultationDao.getConsultation(rs.getInt("consultation_id"));
                laboratoire = laboratoireDao.getLaboratoire(rs.getInt("laboratoire_id"));
                analyses.setConsultation(consultation);
                analyses.setId(id);
                analyses.setLaboratoire(laboratoire);
                analyses.setPrix(rs.getFloat("prix"));
                
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return analyses;
    }
    
    public int addAnalyses(Analyses analyses){  
        ConsultationDao consultationDao;
        LaboratoireDao laboratoireDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `patien` (`consultation_id`,`laboratoire_id`,`prix`) VALUES(?,?,?)");
            
            consultationDao = new ConsultationDao();
            laboratoireDao = new LaboratoireDao();
            consultationDao.addConsultation(analyses.getConsultation());
            laboratoireDao.addLaboratoire(analyses.getLaboratoire());
            
            ps.setInt(1, consultationDao.getConsultation(analyses.getConsultation().getId()).getId());
            ps.setInt(2, laboratoireDao.getLaboratoire(analyses.getLaboratoire().getId()).getId());
            ps.setFloat(3, analyses.getPrix());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteAnalyses(int id){  
        ConsultationDao consultationDao;
        LaboratoireDao laboratoireDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `analyses` WHERE id=?");
            ps.setInt(1, id);
            
            consultationDao = new ConsultationDao();
            laboratoireDao = new LaboratoireDao();
            consultationDao.deleteConsultation(getAnalyses(id).getConsultation().getId());
            laboratoireDao.deleteLaboratoire(getAnalyses(id).getLaboratoire().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateAnalyses(Analyses analyses){    return 0;}
}
