/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

import java.sql.Date;

/**
 *
 * @author abdelhamid
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date ddn; // date de naicence
    private String address;
    private String ldn; // nombre carte nationale
    private String phone;
    private int sex;
    private String userType;

    
    
    public User() {
    }

    public User(int id, String userName, String password, String firstName, String lastName, Date ddn, String address, String ldn, String phone, String userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ddn = ddn;
        this.address = address;
        this.ldn = ldn;
        this.phone = phone;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDdn() {
        return ddn;
    }

    public void setDdn(Date ddn) {
        this.ddn = ddn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLdn() {
        return ldn;
    }

    public void setLdn(String ldn) {
        this.ldn = ldn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }    
    
    
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
