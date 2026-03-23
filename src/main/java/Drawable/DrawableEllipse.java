/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Drawable;

import java.awt.Color;
import java.awt.Graphics2D;
import models.Ellipse;

/**
 *
 * @author andre
 */
public class DrawableEllipse extends Ellipse implements Drawable{

    public DrawableEllipse(int width, int height, String shapeType, Color color, int startX, int startY, int endX, int endY) {
        super(width, height, shapeType, color, startX, startY, endX, endY);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int x = Math.min(this.getStartX(), this.getEndX());
        int y = Math.min(this.getStartY(), this.getEndY());
        int width = Math.abs(this.getStartX() - this.getEndX());
        int height = Math.abs(this.getStartY() - this.getEndY());
        
        g2d.drawOval(x, y, width, height);        
    }
    
    
}
