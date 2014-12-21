/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.transaksi.Pembelian;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PacuL
 */
public interface PembelianService {

    void save(Pembelian pembelian);
    void update(Pembelian pembelian);
    List<Pembelian> findAll(Date from, Date to);    
    List<Pembelian> findAll();    
    List<Pembelian> findHutang();
    List<Pembelian> findHutangTgl(Date from, Date to);
    List<Pembelian> grafik(Date from, Date to);
}