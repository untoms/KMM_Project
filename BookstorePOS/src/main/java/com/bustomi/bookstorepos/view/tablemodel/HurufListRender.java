/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.view.tablemodel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author bustomi
 */
public class HurufListRender implements ListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label= new JLabel();
        
        if (value != null) {
            label =new JLabel(value.toString());
        }
        
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setForeground(Color.white);
        label.setOpaque(true);
        if (isSelected) {
            label.setBackground(new Color(47, 79, 79,50));
        }else{
            if (index%2!=0) {
                label.setBackground(new Color(255,255,255,100));
            }else{
                label.setBackground(new Color(255,255,255,25));
            }
        }
        return  label;
    }

 
}
