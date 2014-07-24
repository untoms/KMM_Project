/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.Pengarang;
import com.bustomi.bookstorepos.service.PengarangService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class PengarangServiceImpl extends SimpleAbstractService<Pengarang, Integer>implements PengarangService{

    public PengarangServiceImpl() {
        super(Pengarang.class);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Pengarang find(String nama) {
        return (Pengarang) currentSession().createQuery("From Pengarang p where p.nama= :t_nama").
                setParameter("t_nama", nama).uniqueResult();        
    }
        
}
