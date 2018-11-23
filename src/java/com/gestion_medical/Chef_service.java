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
public class Chef_service {
    private int id;
    private Service service;
    private User user;
 
    public Chef_service() {
    }
 
    public Chef_service(int id, Service service, User user) {
        this.id = id;
        this.service = service;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
