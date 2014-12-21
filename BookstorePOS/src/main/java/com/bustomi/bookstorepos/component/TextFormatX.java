/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.component;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author bustomi
 */
public class TextFormatX extends JFormattedTextField{
    
//    private Shape shape;
//    
//    private boolean fokus;
//       
//    private Color color;
//   
//    public TextFormatX() {
//       
//        setOpaque(false);
//        setBorder(new EmptyBorder(3, 3, 3, 3));
//        
//        addFocusListener(new FocusAdapter() {
//
//            @Override
//            public void focusGained(FocusEvent fe) {
//                setFokus(true);
//            }
//
//            @Override
//            public void focusLost(FocusEvent fe) {
//                setFokus(false);
//            }
//        
//            
//        });
//    }
//
//    public boolean isFokus() {
//        return fokus;
//    }
//
//    public void setFokus(boolean fokus) {
//        this.fokus = fokus;
//        repaint();
//    }
//    
//    @Override
//    protected void paintComponent(Graphics g) {
//        
//        Graphics2D gd=(Graphics2D) g.create();
//        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//        gd.setStroke(new BasicStroke(3f));
//        shape=new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10);
//        if (isFokus()) {
//            color=new Color(255,255,255,75);
//        }else{
//            color=new Color(255,255,255,50);
//        }
//        setForeground(Color.WHITE);        
//        setDisabledTextColor(Color.LIGHT_GRAY);
//        gd.setColor(color);
//        gd.fill(shape); 
//        
//        gd.dispose();
//        super.paintComponent(g);
//    }
    
}
