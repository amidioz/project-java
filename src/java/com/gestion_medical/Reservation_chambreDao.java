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
import java.sql.Date;

/**
 *
 * @author abdelhamid
 */
public class Reservation_chambreDao {
    public Reservation_chambre getReservation_chambre(int chamber_id,int patient_id,Date date_reserve){
        Reservation_chambre reservation_chambre = null;
        Consultation consultation;
        ConsultationDao consultationDao;
        Chambre chambre;
        ChambreDao chambreDao;
        Patien patien;
        PatienDao patienDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from reservation_chambre WHERE chamber_id=? and patient_id=? and date_reserve=?");
            ps.setInt(1, chamber_id);
            ps.setInt(2, patient_id);
            ps.setDate(3, date_reserve);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                consultationDao = new ConsultationDao();
                chambreDao = new ChambreDao();
                patienDao = new PatienDao();
                
                consultation = consultationDao.getConsultation(rs.getInt("consultation_id"));
                chambre = chambreDao.getChambre(rs.getInt("chamber_id"));
                patien = patienDao.getPatien(rs.getInt("patient_id"));
                reservation_chambre.setChambre(chambre);
                reservation_chambre.setPatien(patien);
                reservation_chambre.setDateReserve(rs.getDate("date_reserve"));
                reservation_chambre.setFinReserve(rs.getDate("fin_reserv"));
                reservation_chambre.setConsultation(consultation);
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return reservation_chambre;
    }
    
    public int addReservation_chambre(Reservation_chambre reservation_chambre){  return 0;}
    
    public int deleteReservation_chambre(int chamber_id,int patient_id, Date date_reserve){  
        ConsultationDao consultationDao;
        PatienDao patienDao;
        ChambreDao chambreDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `reservation_chambre` WHERE chamber_id=? and patient_id=? and date_reserve=?");
            ps.setInt(1, chamber_id);
            ps.setInt(2, patient_id);
            ps.setDate(3, date_reserve);
            
            consultationDao = new ConsultationDao();
            patienDao = new PatienDao();
            chambreDao = new ChambreDao();
            consultationDao.deleteConsultation(getReservation_chambre(chamber_id, patient_id, date_reserve).getConsultation().getId());
            patienDao.deletePatien(getReservation_chambre(chamber_id, patient_id, date_reserve).getPatien().getId());
            chambreDao.deleteChambre(getReservation_chambre(chamber_id, patient_id, date_reserve).getChambre().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateReservation_chambre(Reservation_chambre reservation_chambre){    return 0;}
}
