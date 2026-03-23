/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author andre
 */
public class ShapeArea {
    
    public static double calculateArea(Shape shape) {
        int width = Math.abs(shape.getStartX() - shape.getEndX());
        int height = Math.abs(shape.getStartY() - shape.getEndY());
        switch (shape.getShapeType()) {
            case "Circulo" -> {
                int radius = Math.max(width, height) / 2;
                return Math.PI * Math.pow(radius, 2);
            }
            case "Cuadrado" -> {
                return Math.PI * Math.pow(width / 2.0, 2);
            }
            case "Elipse" -> {
                return Math.PI * (width / 2.0) * (height / 2.0);
            }
            case "Rectangulo" -> {
                return width * height;
            }
            default -> {
                return 0;
            }
        }
    }
}
