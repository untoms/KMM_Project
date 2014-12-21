/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.laporan;

import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.entity.master.Pelanggan;
import com.bustomi.bookstorepos.entity.master.Pemasok;
import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import com.bustomi.bookstorepos.entity.transaksi.Penjualan;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author PacuL
 */
public class Keuntungan {
    
    private Long id;
    private String jenis;
    private Date tanggal;
    private User user;
    private Pelanggan pelanggan;
    private Pemasok pemasok;
    private BigDecimal total;
    private BigDecimal keuntungan;

    public Keuntungan(Penjualan penjualan) {
        this.id = penjualan.getId();
        this.jenis = "Penjualan";
        this.tanggal = penjualan.getWaktu_transaksi();
        this.user = penjualan.getUser();
        this.pelanggan = penjualan.getPelanggan();
        this.pemasok = null;
        this.total = penjualan.getTotal();
        this.keuntungan = penjualan.getKeuntungan();
    }
    
    public Keuntungan(Pembelian pembelian) {
        this.id = pembelian.getId();
        this.jenis = "Pembelian";
        this.tanggal = pembelian.getWaktu_transaksi();
        this.user = pembelian.getUser();
        this.pelanggan = null;
        this.pemasok = pembelian.getPemasok();
        this.total = pembelian.getBayar();
        this.keuntungan = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }   

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getKeuntungan() {
        return keuntungan;
    }

    public void setKeuntungan(BigDecimal keuntungan) {
        this.keuntungan = keuntungan;
    }
        
}
