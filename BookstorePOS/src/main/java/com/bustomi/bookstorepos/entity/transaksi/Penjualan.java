/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.transaksi;

import com.bustomi.bookstorepos.entity.TransactionEntity;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.entity.master.Pelanggan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author PacuL
 */
@Entity
@Table (name = "Penjualan")
public class Penjualan extends TransactionEntity{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Pelanggan_Id")
    private Pelanggan pelanggan;

    @OneToMany(fetch= FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "penjualan")
    private List<DetailPenjualan> daftarPenjualan = new ArrayList<>();

    @Column(name = "Total")
    private BigDecimal total;
    
    @Column(name = "Diskon")
    private BigDecimal diskon;
        
    @Transient
    private BigDecimal uang;
    
    @Column(name = "Keuntungan")
    private BigDecimal keuntungan;
    
    @Transient
    private Long jumlah;
    
    @Transient
    private BigDecimal totals;
    
    @Transient
    private Date waktu;
    
    public void tambahDaftarPenjualan(DetailPenjualan detailPenjualan) {
        detailPenjualan.setPenjualan(this);
        daftarPenjualan.add(detailPenjualan);
        total = BigDecimal.ZERO;
        BigDecimal totalBeli = BigDecimal.ZERO;
        for (DetailPenjualan detail : daftarPenjualan) {
            total = total.add(detail.getSubTotal() );
            totalBeli = totalBeli.add(detail.getItem().getHarga_beli().multiply(
                    new BigDecimal(detail.getJumlah()))) ;
        }
        total=total.subtract(diskon);
        keuntungan = total.subtract(totalBeli) ;
    }

    public void hapusDaftarPenjualan(DetailPenjualan detailPenjualan) {
        detailPenjualan.setPenjualan(null);
        daftarPenjualan.remove(detailPenjualan);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public List<DetailPenjualan> getDaftarPenjualan() {
        return daftarPenjualan;
    }

    public void setDaftarPenjualan(List<DetailPenjualan> daftarPenjualan) {
        this.daftarPenjualan = daftarPenjualan;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getUang() {
        return uang;
    }

    public void setUang(BigDecimal uang) {
        this.uang = uang;
    }

    public BigDecimal getKeuntungan() {
        return keuntungan;
    }

    public void setKeuntungan(BigDecimal keuntungan) {
        this.keuntungan = keuntungan;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public BigDecimal getTotals() {
        return totals;
    }

    public void setTotals(BigDecimal totals) {
        this.totals = totals;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public BigDecimal getDiskon() {
        return diskon;
    }

    public void setDiskon(BigDecimal diskon) {
        this.diskon = diskon;
    }    
}
