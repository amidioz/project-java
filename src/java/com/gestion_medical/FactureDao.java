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
public class FactureDao {
     public Facture getFacture(int id){
        Facture facture = null;
        Consultation consultation;
        ConsultationDao consultationDao;
        Comptable comptable;
        ComptableDao comptableDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from facture WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                consultationDao = new ConsultationDao();
                comptableDao = new ComptableDao();
                
                consultation = consultationDao.getConsultation(rs.getInt("consultation_id"));
                comptable = comptableDao.getComptable(rs.getInt("comptable_id"));
                facture.setId(id);
                facture.setConsultation(consultation);
                facture.setComptable(comptable);
                facture.setPrixTotal(rs.getFloat("prix_total"));
                facture.setState(rs.getBoolean("state"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return facture;
    }
    
    public int addFacture(Facture facture){  
        ConsultationDao consultationDao;
        ComptableDao comptableDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `facture` (`consultation_id`,`comptable_id`,`prix_total`,`state`) VALUES(?,?,?,?)");
            
            consultationDao = new ConsultationDao();
            comptableDao = new ComptableDao();
            consultationDao.addConsultation(facture.getConsultation());
            comptableDao.addComptable(facture.getComptable());
            
            ps.setInt(1, consultationDao.getConsultation(facture.getConsultation().getId()).getId());
            ps.setInt(2, comptableDao.getComptable(facture.getComptable().getId()).getId());
            ps.setFloat(3, facture.getPrixTotal());
            ps.setBoolean(4, facture.isState());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteFacture(int id){  
        ConsultationDao consultationDao;
        ComptableDao comptableDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `facture` WHERE id=?");
            ps.setInt(1, id);
            
            consultationDao = new ConsultationDao();
            comptableDao = new ComptableDao();
            consultationDao.deleteConsultation(getFacture(id).getConsultation().getId());
            comptableDao.deleteComptable(getFacture(id).getComptable().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateFacture(Facture facture){    return 0;}
}
