/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos;

import com.bustomi.bookstorepos.manager.SpringManager;
import com.bustomi.bookstorepos.view.MainFrame;
import com.bustomi.bookstorepos.view.dialog.DialogLogin;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author PacuL
 */

public class MainApp implements Runnable {

    private MainFrame form;

    public MainApp() throws NoSuchAlgorithmException {
        form = new MainFrame();
    }

    public void start() {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
        form.setVisible(true);
        DialogLogin view = new DialogLogin(form);
        view.display(form, null);
    }

    /**
     * @param args the command line arguments
     * @throws java.security.spec.InvalidKeySpecException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
    
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | 
                UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {            
            // ini spring
            SpringManager.getInstance();
            
            // run app
            MainApp app = new MainApp();
            app.start();            
        }
           
    }
}
