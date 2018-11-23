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
public class Chef_serviceDao {
     public Chef_service getChef_service(int id){
        Chef_service chef_service = null;
        Service service;
        ServiceDao serviceDao;
        User user;
        UserDao userDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from chef-service WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                serviceDao = new ServiceDao();
                userDao = new UserDao();
                
                service = serviceDao.getService(rs.getInt("service_id"));
                user = userDao.getUser(rs.getInt("user_id"));
                chef_service.setId(id);
                chef_service.setService(service);
                chef_service.setUser(user);
                
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return chef_service;
    }
    
    public int addChef_service(Chef_service chef_service){  
        ServiceDao serviceDao;
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `chef-service` (`service_id`,`user_id`) VALUES(?,?)");
            
            serviceDao = new ServiceDao();
            userDao = new UserDao();
            serviceDao.addService(chef_service.getService());
            userDao.addUser(chef_service.getUser());
            
            ps.setInt(1, serviceDao.getService(chef_service.getService().getId()).getId());
            ps.setInt(2, userDao.getUser(chef_service.getUser().getUserName()).getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteChef_service(int id){  
        ServiceDao serviceDao;
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `chef-service` WHERE id=?");
            ps.setInt(1, id);
            
            serviceDao = new ServiceDao();
            userDao = new UserDao();
            serviceDao.deleteService(getChef_service(id).getService().getId());
            userDao.deleteUser(getChef_service(id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateChef_service(Chef_service chef_service){    return 0;}
}
