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
public class User_login_session {
    private User user;
    private String userNameFake;
    private Date date;

    public User_login_session() {
    }

    public User_login_session(User user, String userNameFake, Date date) {
        this.user = user;
        this.userNameFake = userNameFake;
        this.date = date;
    }

 

    public String getUserNameFake() {
        return userNameFake;
    }

    public void setUserNameFake(String userNameFake) {
        this.userNameFake = userNameFake;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
