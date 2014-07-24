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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @OneToMany(mappedBy = "penjualan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailPenjualan> daftarPenjualan = new ArrayList<>();

    @Column(name = "Total")
    private BigDecimal total;
    
    @Column(name = "Uang")
    private BigDecimal uang;
    
    @Column(name = "Keuntungan")
    private BigDecimal keuntungan;
    
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
    
}
