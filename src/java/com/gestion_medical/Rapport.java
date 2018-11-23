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
public class Rapport {
    private int id;
    private Infermier infermier;
    private Patien patien;
    private Date date;
    private String content;

    public Rapport() {
    }

    public Rapport(int id, Infermier infermier, Patien patien, Date date, String content) {
        this.id = id;
        this.infermier = infermier;
        this.patien = patien;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Infermier getInfermier() {
        return infermier;
    }

    public void setInfermier(Infermier infermier) {
        this.infermier = infermier;
    }

    public Patien getPatien() {
        return patien;
    }

    public void setPatien(Patien patien) {
        this.patien = patien;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
