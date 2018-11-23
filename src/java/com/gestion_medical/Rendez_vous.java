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
public class Rendez_vous {
    private int id;
    private Patien patien;
    private Medcin medcin;
    private Date_rdv date_rdv;
    private String remarque;
    private int statut;
    private Date date;

    public Rendez_vous() {
    }

    public Rendez_vous(int id, Patien patien, Medcin medcin, Date_rdv date_rdv, String remarque, int statut, Date date) {
        this.id = id;
        this.patien = patien;
        this.medcin = medcin;
        this.date_rdv = date_rdv;
        this.remarque = remarque;
        this.statut = statut;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patien getPatien() {
        return patien;
    }

    public void setPatien(Patien patien) {
        this.patien = patien;
    }

    public Medcin getMedcin() {
        return medcin;
    }

    public void setMedcin(Medcin medcin) {
        this.medcin = medcin;
    }

    public Date_rdv getDate_rdv() {
        return date_rdv;
    }

    public void setDate_rdv(Date_rdv date_rdv) {
        this.date_rdv = date_rdv;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }    
}
