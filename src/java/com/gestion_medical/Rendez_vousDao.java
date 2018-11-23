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
public class Rendez_vousDao {
     public Rendez_vous getRendez_vous(int id){
        Rendez_vous rendez_vous = null;
        Patien patien;
        PatienDao patienDao;
        Medcin medcin;
        MedcinDao medcinDao;
        Date_rdv date_rdv;
        Date_rdvDao date_rdvDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from rendez-vous WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                patienDao = new PatienDao();
                medcinDao = new MedcinDao();
                date_rdvDao = new Date_rdvDao();
                
                patien = patienDao.getPatien(rs.getInt("patient_id"));
                medcin = medcinDao.getMedcin(rs.getInt("medcin_id"));
                date_rdv = date_rdvDao.getDate_rdv(rs.getInt("date_rdv_id"));
                rendez_vous.setId(id);
                rendez_vous.setPatien(patien);
                rendez_vous.setMedcin(medcin);
                rendez_vous.setDate_rdv(date_rdv);
                rendez_vous.setRemarque(rs.getString("remarque"));
                rendez_vous.setStatut(rs.getInt("statut"));
                rendez_vous.setDate(rs.getDate("date"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return rendez_vous;
    }
    
    public int addRendez_vous(Rendez_vous rendez_vous){  
        PatienDao patienDao;
        MedcinDao medcinDao;
        Date_rdvDao date_rdvDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `rendez-vous` (`patient_id`,`medcin_id`,`date_rdv_id`,`remarque`,`statut`,`date`) VALUES(?,?,?,?,?,?)");
            
            patienDao = new PatienDao();
            medcinDao = new MedcinDao();
            date_rdvDao = new Date_rdvDao();
            patienDao.addPatien(rendez_vous.getPatien());
            medcinDao.addMedcin(rendez_vous.getMedcin());
            date_rdvDao.addDate_rdv(rendez_vous.getDate_rdv());
            
            ps.setInt(1, patienDao.getPatien(rendez_vous.getPatien().getId()).getId());
            ps.setInt(2, medcinDao.getMedcin(rendez_vous.getMedcin().getId()).getId());
            ps.setFloat(3, date_rdvDao.getDate_rdv(rendez_vous.getDate_rdv().getId()).getId());
            ps.setString(4, rendez_vous.getRemarque());
            ps.setInt(5, rendez_vous.getStatut());
            ps.setDate(6, rendez_vous.getDate());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteRendez_vous(int id){  
        PatienDao patienDao;
        MedcinDao medcinDao;
        Date_rdvDao date_rdvDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `rendez-vous` WHERE id=?");
            ps.setInt(1, id);
            
            patienDao = new PatienDao();
            medcinDao = new MedcinDao();
            date_rdvDao = new Date_rdvDao();
            patienDao.deletePatien(getRendez_vous(id).getPatien().getId());
            medcinDao.deleteMedcin(getRendez_vous(id).getMedcin().getId());
            date_rdvDao.deleteDate_rdv(getRendez_vous(id).getDate_rdv().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateRendez_vous(Rendez_vous rendez_vous){    return 0;}
}
