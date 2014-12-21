/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.manager;

import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.service.UserService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PacuL
 */
public class LoginManager {
    
    private static LoginManager INSTANCE;
    
    public static LoginManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginManager();
        }
        return LoginManager.INSTANCE;
    }

    private String id;

    private LoginManager() {
        // singleton class
    }

    public boolean login(String username, String password) {
        if (getUserService().contains(username, sandi(password)) ){
            this.id = username;
            return true;
        } else {
            SimplePasswordHash.getInstance(null).setPass(null);
            return false;
        }
    }

    public void logout()   {
        getUser().setTerakhir_logout(new Date());
        User user=getUser();
        getUserService().update(user);
        
        this.id = null;
    }

    public User getUser() {
        if (id == null) {
            return null;
        } else {
            return getUserService().find(id);
        }
    }

    private UserService getUserService()  {
        return SpringManager.getInstance().getBean(UserService.class);
    }
    
    public String sandi(String pass){
        // Create MessageDigest instance for MD5
        MessageDigest md = null;
        
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Add password bytes to digest
        md.update(pass.getBytes());
        //Get the hash's bytes 
        byte[] bytes = md.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        String generatedPassword = sb.toString();

        return generatedPassword;
    }
        
}
