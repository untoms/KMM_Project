/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author bustomi
 */
public class PanelX extends JPanel{
    
     private Shape shape;
       
    private Color color;   

    public PanelX() {
        setOpaque(false);
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D gd=(Graphics2D) g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        shape=new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10);
        color=new Color(255,255,255,25);
        gd.draw(shape);
        gd.setColor(color);
        gd.fill(shape); 
        
        gd.dispose();        
    }
    
}
