/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.master.Satuan;
import com.bustomi.bookstorepos.service.SatuanService;
import com.bustomi.bookstorepos.service.SimpleAbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class SatuanServiceImpl extends SimpleAbstractService<Satuan, Integer>implements SatuanService{

    public SatuanServiceImpl() {
        super(Satuan.class);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Satuan find(String nama) {
        return (Satuan) currentSession().createQuery("From Satuan s where s.nama= :t_nama").
                setParameter("t_nama", nama).uniqueResult();        
    }
        
}
