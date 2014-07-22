/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.service.Implement;

import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.service.AbstractService;
import com.bustomi.bookstorepos.service.UserService;
import org.springframework.stereotype.Service;

/**
 *
 * @author PacuL
 */
@Service
public class UserServiceImpl extends AbstractService<User, String>implements UserService{

    public UserServiceImpl() {
        super(User.class);
    }
        
}
