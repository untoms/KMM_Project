/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.Entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "Buku")
public class Buku extends Entity<Integer>{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id",nullable = false)
    private Integer id;
    
    @Column (name = "ISBN",nullable = false, length = 45)
    private String ISBN;
        
    @Column(name = "tahun_terbit", length = 4)
    private Integer tahun_terbit;
    
    @OneToOne
    @JoinColumn (name = "Item_Id",nullable = false)
    private Item item;
    
    @ManyToOne
    @JoinColumn (name = "Kategori_Buku_Id",nullable = false)
    private KategoriBuku kategoriBuku;
    
    @ManyToOne
    @JoinColumn (name = "Penerbit_Id")
    private Penerbit penerbit;
    
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Buku_has_Pengarang", joinColumns =
    @JoinColumn(name = "Buku_I", nullable = false), inverseJoinColumns =
    @JoinColumn(name = "Pengarang_Id", nullable = false))
    private final List<Pengarang> daftarPengarang = new ArrayList<>(0);

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Override
    public String getNama() {
        return super.getNama(); //To change body of generated methods, choose Tools | Templates.
    }
   
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getTahun_terbit() {
        return tahun_terbit;
    }

    public void setTahun_terbit(Integer tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public KategoriBuku getKategoriBuku() {
        return kategoriBuku;
    }

    public void setKategoriBuku(KategoriBuku kategoriBuku) {
        this.kategoriBuku = kategoriBuku;
    }

    public Penerbit getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(Penerbit penerbit) {
        this.penerbit = penerbit;
    }
    
    public void tambahPengarang(Pengarang pengarang) {
        if (!daftarPengarang.contains(pengarang)) {
            daftarPengarang.add(pengarang);
        }
    }

    public void hapusHakAkses(Pengarang pengarang) {
        if (daftarPengarang.contains(pengarang)) {
            daftarPengarang.remove(pengarang);
        }
    }
  
    public void hapusPengarang() {
        daftarPengarang.clear();
    }

    public List<Pengarang> getDaftarPengarang() {
        return Collections.unmodifiableList(daftarPengarang);
    }
}
