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
public class Maladie {
    private int id;
    private Consultation consultation;
    private float prix;

    public Maladie() {
    }

    public Maladie(int id, Consultation consultation, float prix) {
        this.id = id;
        this.consultation = consultation;
        this.prix = prix;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
