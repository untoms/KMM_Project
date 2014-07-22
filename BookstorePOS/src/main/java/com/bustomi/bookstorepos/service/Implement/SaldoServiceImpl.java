/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.Saldo;
import com.bustomi.bookstorepos.service.SaldoService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
public class SaldoServiceImpl implements SaldoService{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Saldo saldo) {
        sessionFactory.getCurrentSession().save(saldo);
    }

    @Override
    @Transactional
    public void update(Saldo saldo) {
        sessionFactory.getCurrentSession().save(saldo);
    }

    @Override
    @Transactional (readOnly = true)
    public Saldo find(String kode) {
        return (Saldo) sessionFactory.getCurrentSession().get(Saldo.class, kode);
    }
    
}
