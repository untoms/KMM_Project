/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PacuL
 */
@MappedSuperclass
public class Person extends Entity<String>{
        
    @Id
    @Column (name = "id", nullable = false, length = 35)
    private String id;
    
    @Column (name = "kota", nullable = false, length = 35)
    private String kota;
    
    @Column (name = "alamat", nullable = false, length = 255)
    private String alamat;
    
    @Column (name = "telepon", nullable = false, length = 25)
    private String telepon;
    
    @Column (name = "email", nullable = true, length = 50)
    private String email;
    
    @Column (name = "kodepos", nullable = true, length = 6)
    private String kodepos;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column (name = "tgl_lahir", nullable = true)
    private Date tgl_lahir;
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
    
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }
    
    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
        
}
