/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.transaksi;

import com.bustomi.bookstorepos.entity.AutoIncreamentEntity;
import com.bustomi.bookstorepos.entity.master.Item;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author PacuL
 */
@Entity
@Table (name = "Detail_Pembelian")
public class DetailPembelian extends AutoIncreamentEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "jumlah", nullable = false)
    private Integer jumlah;
    
    @Column(name = "harga", nullable = false)
    private BigDecimal harga;

    @Transient
    private BigDecimal subTotal;    
    
    @ManyToOne
    @JoinColumn(name = "Item_Id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "Pembelian_Id")
    private Pembelian pembelian;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;        
        this.harga = item.getHarga_jual();
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
        this.subTotal=this.harga.multiply(new BigDecimal(this.jumlah));
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }
    
    
    
}
