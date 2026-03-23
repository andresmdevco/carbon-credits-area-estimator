/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.awt.Color;

/**
 *
 * @author andre
 */
public class Square extends Shape{
    int width;

    public Square(int width, String shapeType, Color color, int startX, int startY, int endX, int endY) {
        super(shapeType, color, startX, startY, endX, endY);
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }    
}
