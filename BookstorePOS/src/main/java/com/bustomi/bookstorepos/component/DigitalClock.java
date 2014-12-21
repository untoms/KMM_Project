/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class DigitalClock extends JLabel{
    
    Timer timer;
    
    public DigitalClock() {
        
        timer=new Timer(1000, new ClockTickAction());
        timer.start();
    }    
    
    private class ClockTickAction implements ActionListener {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //... Get the current time.
            Calendar now = Calendar.getInstance();
            int h = now.get(Calendar.HOUR_OF_DAY);
            int m = now.get(Calendar.MINUTE);
            int s = now.get(Calendar.SECOND);
            setText(sdf.format(new Date(System.currentTimeMillis())));
        }
    }
}
