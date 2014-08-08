/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.view.tablemodel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author bustomi
 */
public class HurufRender extends DefaultTableCellRenderer{
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        JLabel label= (JLabel) super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(CENTER);
        if (bln) {
            label.setBackground(new Color(47, 79, 79,50));
        }else{
            if (i%2!=0) {
                label.setBackground(new Color(255,255,255,100));
            }else{
                label.setBackground(new Color(255,255,255,25));
            }
        }
        return  label;
    }

 
}
