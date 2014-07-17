/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PacuL
 */
    
@MappedSuperclass
public abstract class TransactionEntity extends AutoIncreamentEntity {

    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "terakhir_diubah")
    private Date terakhir_diubah;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_transaksi")
    private Date waktu_transaksi;

    public Date getTerakhir_diubah() {
        return terakhir_diubah;
    }

    public void setTerakhir_diubah(Date terakhir_diubah) {
        this.terakhir_diubah = terakhir_diubah;
    }

    public Date getWaktu_transaksi() {
        return waktu_transaksi;
    }

    public void setWaktu_transaksi(Date waktu_transaksi) {
        this.waktu_transaksi = waktu_transaksi;
    }
}
