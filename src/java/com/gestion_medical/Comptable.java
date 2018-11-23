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
public class Comptable {
    private int id;
    private Date debutTravaux;
    private Date finTravaux;
    private User user;

    public Comptable() {
    }

    public Comptable(int id, Date debutTravaux, Date finTravaux, User user) {
        this.id = id;
        this.debutTravaux = debutTravaux;
        this.finTravaux = finTravaux;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDebutTravaux() {
        return debutTravaux;
    }

    public void setDebutTravaux(Date debutTravaux) {
        this.debutTravaux = debutTravaux;
    }

    public Date getFinTravaux() {
        return finTravaux;
    }

    public void setFinTravaux(Date finTravaux) {
        this.finTravaux = finTravaux;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }    
}
