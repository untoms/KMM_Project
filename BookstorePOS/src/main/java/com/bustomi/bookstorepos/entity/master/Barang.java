/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@Entity
@Table (name = "Barang")
public class Barang extends com.bustomi.bookstorepos.entity.Entity<Integer>{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
    @OneToOne
    @JoinColumn (name = "Item_Id",nullable = false)
    private Item item;
    
    @ManyToOne
    @JoinColumn (name = "Kategori_Barang_Id",nullable = false)
    private KategoriBarang kategoriBarang;
    
    @ManyToOne
    @JoinColumn (name = "Satuan_Id")
    private Satuan satuan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public KategoriBarang getKategoriBarang() {
        return kategoriBarang;
    }
    
    public void setKategoriBarang(KategoriBarang kategoriBarang) {
        this.kategoriBarang = kategoriBarang;
    }

    public Satuan getSatuan() {
        return satuan;
    }

    public void setSatuan(Satuan satuan) {
        this.satuan = satuan;
    }
    
}
