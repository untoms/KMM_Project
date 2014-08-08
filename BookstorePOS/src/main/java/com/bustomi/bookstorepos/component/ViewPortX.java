/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import javax.swing.JViewport;

/**
 *
 * @author bustomi
 */
public class ViewPortX extends JViewport{

    public ViewPortX() {
        setOpaque(false);
    }        

    @Override
    protected void paintChildren(Graphics g) {
        final Graphics2D g2=(Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
               
        GeneralPath shape=new GeneralPath();
        shape.moveTo(0, 0);
//        shape.lineTo(0, getHeight());
//        shape.lineTo(getWidth()-10, getHeight()-10);
        shape.curveTo(0, getHeight(), getWidth()/2, 0, getWidth(), getHeight());
        shape.lineTo(getWidth(), 0);
        shape.closePath();
        
        
        g2.setColor(new Color(255,255,255,25));
        g2.fill(shape); 
        
        
//        g2.draw(shape);
        
        g2.dispose();
        
        super.paintChildren(g);
    }
    
}
