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
public class Service_PatienDao {
     public Service_Patien getService_Patien(int patient_id,int service_id){
        Service_Patien service_Patien = null;
        Patien patien;
        PatienDao patienDao;
        Service service;
        ServiceDao serviceDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from service-patient WHERE patient_id=? and service_id=?");
            ps.setInt(1, patient_id);
            ps.setInt(2, service_id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                patienDao = new PatienDao();
                serviceDao = new ServiceDao();
                
                patien = patienDao.getPatien(rs.getInt("patient_id"));
                service = serviceDao.getService(rs.getInt("service_id"));
                service_Patien.setPatien(patien);
                service_Patien.setService(service);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return service_Patien;
    }
    
    public int addService_Patien(Service_Patien service_Patien){  return 0;}
    
    public int deleteService_Patien(int patient_id,int service_id){  
        PatienDao patienDao;
        ServiceDao serviceDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `service-patient` WHERE patient_id=? and service_id=?");
            ps.setInt(1, patient_id);
            ps.setInt(2, service_id);
            
            patienDao = new PatienDao();
            serviceDao = new ServiceDao();
            patienDao.deletePatien(getService_Patien(patient_id, service_id).getPatien().getId());
            serviceDao.deleteService(getService_Patien(patient_id, service_id).getService().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateService_Patien(Service_Patien service_Patien){    return 0;}
}
