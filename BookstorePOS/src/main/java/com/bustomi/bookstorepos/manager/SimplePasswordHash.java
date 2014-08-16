/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PacuL
 */
public class SimplePasswordHash {
        
    private String pass;
    
    private String generatedSecuredPasswordHash;
    
    private static SimplePasswordHash Instance;

    public SimplePasswordHash(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGeneratedSecuredPasswordHash()  {
        try {
            generatedSecuredPasswordHash = md5(pass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SimplePasswordHash.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generatedSecuredPasswordHash;
    }
       
    public static SimplePasswordHash getInstance(String pass) {
        
        if (SimplePasswordHash.Instance == null) {
            SimplePasswordHash.Instance = new SimplePasswordHash(pass);            
        }        
        return Instance;
    }
           
    private String md5(String passwordToHash) throws NoSuchAlgorithmException {
        String generatedPassword = null;
        
        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Add password bytes to digest
        md.update(passwordToHash.getBytes());
        //Get the hash's bytes 
        byte[] bytes = md.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        generatedPassword = sb.toString();

        return generatedPassword;
       
    }
}
