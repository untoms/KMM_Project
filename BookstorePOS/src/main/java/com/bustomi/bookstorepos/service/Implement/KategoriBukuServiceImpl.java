/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.KategoriBuku;
import com.bustomi.bookstorepos.service.KategoriBukuService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class KategoriBukuServiceImpl extends SimpleAbstractService<KategoriBuku, Integer>implements KategoriBukuService{

    public KategoriBukuServiceImpl() {
        super(KategoriBuku.class);
    }
    
    @Transactional(readOnly = true)
    @Override
    public KategoriBuku find(String nama) {
        return (KategoriBuku) currentSession().createQuery("From KategoriBuku k where k.nama= :t_nama").
                setParameter("t_nama", nama).uniqueResult();        
    }
        
}
