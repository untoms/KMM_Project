/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.User;

import com.bustomi.bookstorepos.entity.Person;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PacuL
 */
@Entity
@Table (name = "User")
public class User extends Person{
    
    @Temporal (TemporalType.TIMESTAMP)
    @Column (name = "terakhir_login")
    private String Terakhir_login;
    
    @Temporal (TemporalType.TIMESTAMP)
    @Column (name = "terakhir_logout")
    private String Terakhir_logout;
    
    @Column (name = "password",nullable = false, length = 255)
    private String password;
    
    @ManyToOne 
    @JoinColumn (name = "Grup_Id")
    private Grup grup;

    public String getTerakhir_login() {
        return Terakhir_login;
    }

    public void setTerakhir_login(String Terakhir_login) {
        this.Terakhir_login = Terakhir_login;
    }

    public String getTerakhir_logout() {
        return Terakhir_logout;
    }

    public void setTerakhir_logout(String Terakhir_logout) {
        this.Terakhir_logout = Terakhir_logout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }
    
    
    
}
