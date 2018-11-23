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
public class Service_Patien {
    private Patien patien;
    private Service service;

    public Service_Patien() {
    }

    public Service_Patien(Patien patien, Service service) {
        this.patien = patien;
        this.service = service;
    }

    public Patien getPatien() {
        return patien;
    }

    public void setPatien(Patien patien) {
        this.patien = patien;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
