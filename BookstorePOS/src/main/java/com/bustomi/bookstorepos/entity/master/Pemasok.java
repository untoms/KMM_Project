/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.Entity;
import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "Pemasok")
public class Pemasok extends Entity<String>{
    
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
    
    @OneToMany(mappedBy = "pemasok")
    private List<Pembelian> daftarPembelian;

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

    public List<Pembelian> getDaftarPembelian() {
        return Collections.unmodifiableList(daftarPembelian);
    }

    public void setDaftarPembelian(List<Pembelian> daftarPembelian) {
        this.daftarPembelian = daftarPembelian;
    }
        
}
