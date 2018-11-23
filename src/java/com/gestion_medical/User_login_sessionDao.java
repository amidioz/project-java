/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestion_medical;

import static com.gestion_medical.Dao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author abdelhamid
 */
public class User_login_sessionDao {
    public User_login_session getUser_login_session(int user_id){
        User_login_session user_login_session = null;
        User user;
        UserDao userDao;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("SELECT * from user-login-session WHERE user_id=?");
            ps.setInt(1, user_id);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                userDao = new UserDao();
                
                user = userDao.getUser(rs.getInt("user_id"));
                user_login_session.setUserNameFake(rs.getString("user_name_fake"));
                user_login_session.setUser(user);
                user_login_session.setDate(rs.getDate("date"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return user_login_session;
    }
    
    public int addUser_login_session(int user_id){  return 0;}
    
    public int deleteUser_login_session(int user_id){  
        UserDao userDao;
        int i=0;
        PreparedStatement ps = null;
        try{
            Connection con = getConnection();
            ps = con.prepareStatement("DELETE FROM `user-login-session` WHERE user_id=?");
            ps.setInt(1, user_id);
            
            userDao = new UserDao();
            userDao.deleteUser(getUser_login_session(user_id).getUser().getId());
            
            i = ps.executeUpdate();
            
            ps.close();
            con.close();
        }catch(Exception e){ }
        
        return i;
    }
    
    public int upDateUser_login_session(User_login_session user_login_session){    return 0;}
}
