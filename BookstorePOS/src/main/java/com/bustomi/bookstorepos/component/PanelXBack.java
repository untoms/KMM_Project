/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bustomi.bookstorepos.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author bustomi
 */
public class PanelXBack extends JPanel{
    
    private GradientPaint paint;
    
    private GeneralPath path;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        final Point center=new Point(getWidth()/2, getHeight()/2);
        final float radius=getWidth()*2;
        final float [] fractions=new float[]{0.0f,1.0f};
        final Color[] colors=new Color[]{Color.black,Color.white};
        final RadialGradientPaint radial=new RadialGradientPaint(center, radius, fractions, colors);
        
        Shape shape=new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        
        final Graphics2D g2=(Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.draw(shape);
        g2.setPaint(radial);
        g2.fill(shape);
        
        int width=getWidth();
        int height=getHeight()*5/100;
        
        Color light= new Color(1f,1f,1f,0.5f);
        Color dark= new Color(1f,1f,1f,0.0f);
        
        paint=new GradientPaint(0,0,light,0,height,dark);
        path =new GeneralPath();        
        path.moveTo(0,0);
        path.lineTo(0,height);
        path.curveTo(0,height,width/2,height/2,width,height);
        path.lineTo(width,0);
        path.closePath();
        
        g2.setPaint(paint);
        g2.fill(path);
        
        paint=new GradientPaint(0,getHeight(),light,0,getHeight()-height,dark);
        path =new GeneralPath();
        path.moveTo(0,getHeight());
        path.lineTo(0,getHeight()-height);
        path.curveTo(0,getHeight()-height,width/2,getHeight()-height,width,getHeight()-height);
        path.lineTo(width,getHeight());
        path.closePath();
        
        g2.setPaint(paint);
        g2.fill(path);

        
        g2.dispose();
    }
    
}
