/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.Pelanggan;
import com.bustomi.bookstorepos.service.AbstractService;
import com.bustomi.bookstorepos.service.PelangganService;
import org.springframework.stereotype.Service;

/**
 *
 * @author PacuL
 */
@Service
public class PelangganServiceImpl extends AbstractService<Pelanggan, String>implements PelangganService{

    public PelangganServiceImpl() {
        super(Pelanggan.class);
    }
        
}
