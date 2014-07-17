/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity.transaksi;

import com.bustomi.bookstorepos.entity.TransactionEntity;
import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.entity.master.Pemasok;
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
@Table (name = "Pembelian")
public class Pembelian extends TransactionEntity{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Pemasok_Id")
    private Pemasok pemasok;

    @OneToMany(mappedBy = "pembelian", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailPembelian> daftarPembelian = new ArrayList<>();

    @Column(name = "Total")
    private BigDecimal total;
    
    public void tambahDetailPembelian(DetailPembelian detailPembelian) {
        detailPembelian.setPembelian(this);
        daftarPembelian.add(detailPembelian);
        total = BigDecimal.ZERO;
        for (DetailPembelian detail : daftarPembelian) {
            total=total.add(detail.getSubTotal());
        }
    }

    public void hapusDetailPembelian(DetailPembelian detailPembelian) {
        detailPembelian.setPembelian(null);
        daftarPembelian.remove(detailPembelian);
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

    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }

    public List<DetailPembelian> getDaftarPembelian() {
        return daftarPembelian;
    }

    public void setDaftarPembelian(List<DetailPembelian> daftarPembelian) {
        this.daftarPembelian = daftarPembelian;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
