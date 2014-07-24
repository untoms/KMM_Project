/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.service.AbstractService;
import com.bustomi.bookstorepos.service.UserService;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PacuL
 */
@Service
public class UserServiceImpl extends AbstractService<User, String>implements UserService{

    public UserServiceImpl() {
        super(User.class);
    }
    
    @Transactional(readOnly = true)
    @Override
    public boolean contains(String id, String password) {
        Long count = (Long) currentSession().createCriteria(clazz).
                setProjection(Projections.count("id")).add(Restrictions.eq("id", id)).
                add(Restrictions.eq("password", password)).setMaxResults(1).uniqueResult();
        return count > 0;
    }
        
}
