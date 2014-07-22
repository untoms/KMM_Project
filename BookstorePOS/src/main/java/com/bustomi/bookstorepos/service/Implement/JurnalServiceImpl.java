/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.laporan.Jurnal;
import com.bustomi.bookstorepos.service.JurnalService;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class JurnalServiceImpl implements JurnalService{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Jurnal jurnal) {
        sessionFactory.getCurrentSession().save(jurnal);
    }

    @Override
    public List<Jurnal> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Jurnal.class).list();
    }
    
}
