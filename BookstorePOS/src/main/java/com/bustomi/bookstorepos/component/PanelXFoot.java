/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author bustomi
 */
public class PanelXFoot extends JPanel{
    
     private Shape shape;
       
    private Color color;   

    public PanelXFoot() {
        setOpaque(false);
    }
  
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D gd=(Graphics2D) g.create();
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        shape=new Rectangle(getWidth(), getHeight());
        color=Color.LIGHT_GRAY;
        gd.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        gd.draw(shape);
        gd.setColor(color);
        gd.fill(shape); 
        
        gd.dispose();        
    }
    
}
