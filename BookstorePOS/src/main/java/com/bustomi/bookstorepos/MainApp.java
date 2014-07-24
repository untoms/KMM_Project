/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos;

import com.bustomi.bookstorepos.manager.SpringManager;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author PacuL
 */

public class MainApp implements Runnable {

//    private FormMainApp form;

    public MainApp() {
//        form = new FormMainApp();
    }

    public void start() {
        SwingUtilities.invokeLater(this);
    }

    @Override
    public void run() {
//        form.setVisible(true);
//        LoginView view = new LoginView(form);
//        view.display(form, null);
    }

    /**
     * @param args the command line arguments
     * @throws java.security.spec.InvalidKeySpecException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
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
