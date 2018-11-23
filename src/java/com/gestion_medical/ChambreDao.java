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
public class ChambreDao {
     public Chambre getChambre(int id){
        Chambre chambre = null;
        Service service;
        ServiceDao serviceDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from chambre WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                serviceDao = new ServiceDao();
                
                service = serviceDao.getService(rs.getInt("service_id"));
                
                chambre.setId(id);
                chambre.setCapacite(rs.getInt("capacite"));
                chambre.setService(service);
                chambre.setPrix(rs.getFloat("prix"));
                
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return chambre;
    }
    
    public int addChambre(Chambre chambre){  
        ServiceDao serviceDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("INSERT INTO `chambre` (`capacite`,`service_id`,`prix`) VALUES(?,?,?)");
            
            serviceDao = new ServiceDao();
            serviceDao.addService(chambre.getService());
            
            ps.setInt(1, chambre.getCapacite());
            ps.setInt(2, serviceDao.getService(chambre.getService().getId()).getId());
            ps.setFloat(3, chambre.getPrix());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int deleteChambre(int id){  
        ServiceDao serviceDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `chambre` WHERE id=?");
            ps.setInt(1, id);
            
            serviceDao = new ServiceDao();
            serviceDao.deleteService(getChambre(id).getService().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateChambre(Chambre chambre){    return 0;}
}
