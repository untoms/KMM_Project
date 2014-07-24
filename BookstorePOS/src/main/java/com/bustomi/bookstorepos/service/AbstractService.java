/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service;

import com.bustomi.bookstorepos.entity.Entity;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 * @param <T>
 * @param <Id>
 */
public abstract class AbstractService<T extends Entity<?>, Id extends Serializable>
    implements InterfaceService<T, Id>{
    
    private SessionFactory sessionFactory;

    @SuppressWarnings("ProtectedField")
    protected Class<T> clazz;

    public AbstractService(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    @Override
    public void save(T entity) {
        currentSession().saveOrUpdate(entity);
    }

    @Transactional
    @Override
    public void update(T entity) {
        currentSession().update(entity);
    }

    @Transactional
    @Override
    public void delete(T entity) {
        currentSession().delete(entity);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public T find(Id id) {
        return (T) currentSession().get(clazz, id);
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return currentSession().createCriteria(clazz).list();
    }
    
}
