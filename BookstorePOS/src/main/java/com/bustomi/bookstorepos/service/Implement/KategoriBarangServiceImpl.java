/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.KategoriBarang;
import com.bustomi.bookstorepos.service.KategoriBarangService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class KategoriBarangServiceImpl extends SimpleAbstractService<KategoriBarang, Integer>implements KategoriBarangService{

    public KategoriBarangServiceImpl() {
        super(KategoriBarang.class);
    }
    
    @Transactional(readOnly = true)
    @Override
    public KategoriBarang find(String nama) {
        return (KategoriBarang) currentSession().createQuery("From KategoriBarang k where k.nama= :t_nama").
                setParameter("t_nama", nama).uniqueResult();        
    }
        
}
