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
public class RapportDao {
     public Rapport getRapport(int id){
        Rapport rapport = null;
        Infermier infermier;
        InfermierDao infermierDao;
        Patien patien;
        PatienDao patienDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from rapport WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                infermierDao = new InfermierDao();
                patienDao = new PatienDao();
                
                infermier = infermierDao.getInfermier(rs.getInt("infirmier_id"));
                patien = patienDao.getPatien(rs.getInt("patient_id"));
                rapport.setId(id);
                rapport.setInfermier(infermier);
                rapport.setPatien(patien);
                rapport.setDate(rs.getDate("date"));
                rapport.setContent(rs.getString("content"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return rapport;
    }
    
    public int addRapport(Rapport rapport){  
        InfermierDao infermierDao;
        PatienDao patienDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `rapport` (`infirmier_id`,`patient_id`,`date`,`content`) VALUES(?,?,?,?)");
            
            infermierDao = new InfermierDao();
            patienDao = new PatienDao();
            infermierDao.addInfermier(rapport.getInfermier());
            patienDao.addPatien(rapport.getPatien());
            
            ps.setInt(1, infermierDao.getInfermier(rapport.getInfermier().getId()).getId());
            ps.setInt(2, patienDao.getPatien(rapport.getPatien().getId()).getId());
            ps.setDate(3, rapport.getDate());
            ps.setString(4, rapport.getContent());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteRapport(int id){  
        InfermierDao infermierDao;
        PatienDao patienDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `rapport` WHERE id=?");
            ps.setInt(1, id);
            
            infermierDao = new InfermierDao();
            patienDao = new PatienDao();
            infermierDao.deleteInfermier(getRapport(id).getInfermier().getId());
            patienDao.deletePatien(getRapport(id).getPatien().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateRapport(Rapport rapport){    return 0;}
}
