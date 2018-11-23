/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

/**
 *
 * @author Panika
 */
public class Medcin {
    private int id;
    private Service service;
    private Specialite specialite;
    private User user;

    public Medcin() {
    }

    public Medcin(int id, Service service, Specialite specialite, User user) {
        this.id = id;
        this.service = service;
        this.specialite = specialite;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
