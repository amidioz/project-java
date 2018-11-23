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
public class InfermierDao {
     public Infermier getInfermier(int id){
        UserDao userDao;
        User user;
        InfermierDao infermierDao;
        Infermier infermier = null;
        ServiceDao serviceDao;
        Service service;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from infermier WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                infermier = new Infermier();
                serviceDao = new ServiceDao();
                
                user = userDao.getUser(rs.getInt("user_id"));
                service = serviceDao.getService(rs.getInt("service_id"));
                infermier.setId(rs.getInt("id"));
                infermier.setUser(user);
                infermier.setService(service);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return infermier;
    }
    
    public int addInfermier(Infermier infermier){  
        ServiceDao serviceDao;
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `infermier` (`service_id`,`user_id`) VALUES(?,?)");
            
            serviceDao = new ServiceDao();
            userDao = new UserDao();
            serviceDao.addService(infermier.getService());
            userDao.addUser(infermier.getUser());
            
            ps.setInt(1, serviceDao.getService(infermier.getService().getId()).getId());
            ps.setInt(2, userDao.getUser(infermier.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteInfermier(int id){  
        ServiceDao serviceDao;
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `infermier` WHERE id=?");
            ps.setInt(1, id);
            
            serviceDao = new ServiceDao();
            userDao = new UserDao();
            serviceDao.deleteService(getInfermier(id).getService().getId());
            userDao.deleteUser(getInfermier(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateInfermier(Infermier infermier){    return 0;}
}
