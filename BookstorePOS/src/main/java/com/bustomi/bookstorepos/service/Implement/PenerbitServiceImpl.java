/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.Penerbit;
import com.bustomi.bookstorepos.service.PenerbitService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class PenerbitServiceImpl extends SimpleAbstractService<Penerbit, Integer>implements PenerbitService{

    public PenerbitServiceImpl() {
        super(Penerbit.class);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Penerbit find(String nama) {
        return (Penerbit) currentSession().createQuery("From Penerbit p where p.nama= :t_nama").
                setParameter("t_nama", nama).uniqueResult();        
    }
        
}
