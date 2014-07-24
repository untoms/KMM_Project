/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.SimpleEntity;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "Penerbit")
public class Penerbit extends SimpleEntity<Integer>{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
    
    @Column (name = "alamat", nullable = true, length = 255)
    private String alamat;
    
    @Column (name = "email", nullable = true, length = 50)
    private String email;
    
    @Column (name = "telepon", nullable = true, length = 25)
    private String telepon;
    
    @OneToMany (mappedBy = "penerbit")
    private List<Buku> daftarBuku;

    public List<Buku> getDaftarBuku() {
        return Collections.unmodifiableList(daftarBuku);
    }

    public void setDaftarBuku(List<Buku> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }
        
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}
