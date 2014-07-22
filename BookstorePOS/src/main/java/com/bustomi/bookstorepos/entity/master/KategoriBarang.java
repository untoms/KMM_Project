/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.AutoIncreamentEntity;
import com.bustomi.bookstorepos.entity.SimpleEntity;
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
@Table (name = "Kategori_Barang")
public class KategoriBarang extends SimpleEntity<Integer>{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Integer id;
        
    @OneToMany (mappedBy = "kategoriBarang")
    private List<Barang> daftarBarang;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public List<Barang> getDaftarBarang() {
        return Collections.unmodifiableList(daftarBarang);
    }

    public void setDaftarBarang(List<Barang> daftarBarang) {
        this.daftarBarang = daftarBarang;
    }

       
}
