/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

import java.io.File;

/**
 *
 * @author Salem Rezzag
 */
public class Facture {
    private int id;
    private Consultation consultation;
    private Comptable comptable;
    private float prixTotal;
    private boolean state;

    public Facture() {
    }

    public Facture(int id, Consultation consultation, Comptable comptable, float prixTotal, boolean state) {
        this.id = id;
        this.consultation = consultation;
        this.comptable = comptable;
        this.prixTotal = prixTotal;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Comptable getComptable() {
        return comptable;
    }

    public void setComptable(Comptable comptable) {
        this.comptable = comptable;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
