/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.Saldo;

/**
 *
 * @author PacuL
 */
public interface SaldoService {
    
    void save(Saldo saldo);

    void update(Saldo saldo);

    Saldo find(String kode);
    
}
