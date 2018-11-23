/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

/**
 *
 * @author Salem Rezzag
 */
public class Consultation {
    private int id;
    private Patien patien;
    private Medcin medcin;
    private Rendez_vous rendez_vous;

    public Consultation() {
    }

    public Consultation(int id, Patien patien, Medcin medcin, Rendez_vous rendez_vous) {
        this.id = id;
        this.patien = patien;
        this.medcin = medcin;
        this.rendez_vous = rendez_vous;
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

    public Rendez_vous getRendez_vous() {
        return rendez_vous;
    }

    public void setRendez_vous(Rendez_vous rendez_vous) {
        this.rendez_vous = rendez_vous;
    }   
}
