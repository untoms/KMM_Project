/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.AutoIncreamentEntity;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@Entity
@Table (name = "Satuan")
public class Satuan extends AutoIncreamentEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    
    @Column (name = "nama")
    private String nama;
    
    @OneToMany (mappedBy = "satuan")
    private List<Barang> daftarBarang;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Barang> getDaftarBarang() {
        return Collections.unmodifiableList(daftarBarang);
    }

    public void setDaftarBarang(List<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }

    @Override
    public String toString() {
        return getNama();
    }
       
}
