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
public class Rectangle extends Shape {
    int width, height;

    public Rectangle(int width, int height, String shapeType, Color color, int startX, int startY, int endX, int endY) {
        super(shapeType, color, startX, startY, endX, endY);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    } 
}
