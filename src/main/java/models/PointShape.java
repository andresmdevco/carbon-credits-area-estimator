/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author andre
 */
public class PointShape {

    public static boolean isPointInShape(int x, int y, Shape shape) {
        int startX = Math.min(shape.getStartX(), shape.getEndX());
        int startY = Math.min(shape.getStartY(), shape.getEndY());
        int endX = Math.max(shape.getStartX(), shape.getEndX());
        int endY = Math.max(shape.getStartY(), shape.getEndY());

        switch (shape.getShapeType()) {
            case "Circulo":
                // Calcular el centro y el radio del círculo
                int radius = Math.max(endX - startX, endY - startY) / 2;
                int centerX = startX + radius;
                int centerY = startY + radius;
                // Verificar si el punto está dentro del círculo
                int dx = x - centerX;
                int dy = y - centerY;
                return (dx * dx + dy * dy) <= (radius * radius);
            case "Cuadrado":
                // Asegurar que el punto esté dentro de un cuadrado del tamaño correcto
                int size = Math.max(Math.abs(shape.getStartX() - shape.getEndX()),
                                    Math.abs(shape.getStartY() - shape.getEndY()));
                endX = startX + size;
                endY = startY + size;
                break;
            case "Elipse":
                // Implementar lógica para elipse si es necesario
                break;
            case "Rectangulo":
                // Implementar lógica para rectángulo si es necesario
                break;
            default:
                return false;
        }

        return x >= startX && x <= endX && y >= startY && y <= endY;
    }
}