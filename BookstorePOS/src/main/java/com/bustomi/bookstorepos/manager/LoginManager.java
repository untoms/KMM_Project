/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos.manager;

import com.bustomi.bookstorepos.entity.User.User;
import com.bustomi.bookstorepos.service.UserService;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 *
 * @author PacuL
 */
public class LoginManager {
    
    private static LoginManager INSTANCE;

    public static LoginManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoginManager();
        }
        return LoginManager.INSTANCE;
    }

    private String id;

    private LoginManager() {
        // singleton class
    }

    public boolean login(String username, String password) {
        if (getUserService().contains(username, SimplePasswordHash.getInstance(password).getGeneratedSecuredPasswordHash())) {
            this.id = username;
            return true;
        } else {
            return false;
        }
    }

    public void logout() throws NoSuchAlgorithmException  {
        getUser().setTerakhir_logout(new Date());
        User user=getUser();
        getUserService().save(user);
        this.id = null;
    }

    public User getUser() throws NoSuchAlgorithmException {
        if (id == null) {
            return null;
        } else {
            return getUserService().find(id);
        }
    }

    private UserService getUserService()  {
        return SpringManager.getInstance().getBean(UserService.class);
    }
    
}
