/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.transaksi.Penjualan;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PacuL
 */
public interface PenjualanService {

    void save(Penjualan penjualan);

    List<Penjualan> findAll(Date from, Date to);
    List<Penjualan> findAll();
    List<Penjualan> grafik(Date from, Date to);
    Long hitungtrans();
}