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
public class MedcinDao {
     public Medcin getMedcin(int id){
        UserDao userDao;
        User user;
        Medcin medcin = null;
        ServiceDao serviceDao;
        Service service;
        SpecialiteDao specialiteDao;
        Specialite specialite;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from medcin WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                medcin = new Medcin();
                serviceDao = new ServiceDao();
                specialiteDao = new SpecialiteDao();
                
                user = userDao.getUser(rs.getInt("user_id"));
                service = serviceDao.getService(rs.getInt("service_id"));
                specialite = specialiteDao.getSpecialite(rs.getInt("specialite_id"));
                medcin.setId(rs.getInt("id"));
                medcin.setUser(user);
                medcin.setService(service);
                medcin.setSpecialite(specialite);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return medcin;
    }
    
    public int addMedcin(Medcin medcin){  
        ServiceDao serviceDao;
        SpecialiteDao specialiteDao;
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `medcin` (`service_id`,`specialite_id`,`user_id`) VALUES(?,?,?)");
            
            serviceDao = new ServiceDao();
            specialiteDao = new SpecialiteDao();
            userDao = new UserDao();
            serviceDao.addService(medcin.getService());
            specialiteDao.addSpecialite(medcin.getSpecialite());
            userDao.addUser(medcin.getUser());
            
            ps.setInt(1, serviceDao.getService(medcin.getService().getId()).getId());
            ps.setInt(2, specialiteDao.getSpecialite(medcin.getSpecialite().getId()).getId());
            ps.setInt(3, userDao.getUser(medcin.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteMedcin(int id){  
        ServiceDao serviceDao;
        SpecialiteDao specialiteDao;
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `medcin` WHERE id=?");
            ps.setInt(1, id);
            
            serviceDao = new ServiceDao();
            specialiteDao = new SpecialiteDao();
            userDao = new UserDao();
            serviceDao.deleteService(getMedcin(id).getService().getId());
            specialiteDao.deleteSpecialite(getMedcin(id).getSpecialite().getId());
            userDao.deleteUser(getMedcin(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateMedcin(Medcin medcin){    return 0;}
}
