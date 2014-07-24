/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.User.Grup;
import com.bustomi.bookstorepos.service.GrupService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class GrupServiceImpl extends SimpleAbstractService<Grup, Integer>implements GrupService{

    public GrupServiceImpl() {
        super(Grup.class);
    }
        
    @Transactional(readOnly = true)
    @Override
    public Grup find(String nama) {
        return (Grup) currentSession().createQuery("From Grup g where g.nama= :t_nama").
                setParameter("t_nama", nama).uniqueResult();        
    }
            
}
