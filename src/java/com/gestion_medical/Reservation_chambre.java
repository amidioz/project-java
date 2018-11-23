/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

import java.sql.Date;

/**
 *
 * @author Salem Rezzag
 */
public class Reservation_chambre {
    private Chambre chambre;
    private Patien patien;
    private Date dateReserve;
    private Date finReserve;
    private Consultation consultation;

    public Reservation_chambre() {
    }

    public Reservation_chambre(Chambre chambre, Patien patien, Date dateReserve, Date finReserve, Consultation consultation) {
        this.chambre = chambre;
        this.patien = patien;
        this.dateReserve = dateReserve;
        this.finReserve = finReserve;
        this.consultation = consultation;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Patien getPatien() {
        return patien;
    }

    public void setPatien(Patien patien) {
        this.patien = patien;
    }

    public Date getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(Date dateReserve) {
        this.dateReserve = dateReserve;
    }

    public Date getFinReserve() {
        return finReserve;
    }

    public void setFinReserve(Date finReserve) {
        this.finReserve = finReserve;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
