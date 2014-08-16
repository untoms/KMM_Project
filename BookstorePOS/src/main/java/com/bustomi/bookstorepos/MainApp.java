/*
 * Dikembangkan untuk keperluan proyek Magang D3 TI UNS tahun 2014.
 * bustomiraharjo@gmail.com
 * Bustomi Raharjo | M3112150 | D3 TI-C FMIPA UNS 2012 \^_^v
 */

package com.bustomi.bookstorepos;

import com.bustomi.bookstorepos.view.MainFrame;
import com.bustomi.bookstorepos.view.dialog.DialogLogin;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author PacuL
 */

public class MainApp  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException 
                        | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    DialogLogin login=new DialogLogin();
                    login.setVisible(true);
                    MainFrame frame;
                    if (!login.isDisplayable()) {
                        frame = new MainFrame();
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame.setVisible(true);
                        frame.renderHakAkses();                        
                    }
                }
            }
        });
           
    }
}
