/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bustomi.bookstorepos.entity.master;

import com.bustomi.bookstorepos.entity.Entity;
import com.bustomi.bookstorepos.entity.transaksi.DetailPembelian;
import com.bustomi.bookstorepos.entity.transaksi.DetailPenjualan;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PacuL
 */
@javax.persistence.Entity
@Table (name = "Item")
public class Item extends Entity<String>{
    @Id
    @Column (name = "id", nullable = false, length = 140)
    private String id;
    
    @Column (name= "harga_beli",nullable = false)
    private BigDecimal harga_beli;
    
    @Column (name= "harga_jual",nullable = false)
    private BigDecimal harga_jual;
    
    @Column (name = "stok",nullable = false)
    private Integer stok;
    
    @OneToOne (mappedBy = "item")
    private Buku buku;
    
    @OneToOne (mappedBy = "item")
    private Barang barang;
    
    @OneToOne (mappedBy = "item")
    private DetailPembelian detailPembelian;
    
    @OneToOne (mappedBy = "item")
    private DetailPenjualan detailPenjualan;
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getHarga_beli() {
        return harga_beli;
    }

    public void setHarga_beli(BigDecimal harga_beli) {
        this.harga_beli = harga_beli;
    }

    public BigDecimal getHarga_jual() {
        return harga_jual;
    }

    public void setHarga_jual(BigDecimal harga_jual) {
        this.harga_jual = harga_jual;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {     
        this.barang = barang;
    }

    public DetailPembelian getDetailPembelian() {
        return detailPembelian;
    }

    public void setDetailPembelian(DetailPembelian detailPembelian) {               
        this.detailPembelian = detailPembelian;
    }

    public DetailPenjualan getDetailPenjualan() {
        return detailPenjualan;
    }

    public void setDetailPenjualan(DetailPenjualan detailPenjualan) {
        this.detailPenjualan = detailPenjualan;
    }
        
}
