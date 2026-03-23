/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import Drawable.Drawable;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author andre
 */
public class NativeForestArea {

    public static double calculateRedAreaPercentage(List<Drawable> drawables) {
        double blueArea = 0;
        double redAreaInsideBlue = 0;

        for (Drawable drawable : drawables) {
            Shape shape = (Shape) drawable;
            double area = ShapeArea.calculateArea(shape);

            if (shape.getColor().equals(Color.BLUE)) {
                blueArea += area;

                for (Drawable innerDrawable : drawables) {
                    Shape innerShape = (Shape) innerDrawable;
                    if (innerShape.getColor().equals(Color.RED) && isInside(shape, innerShape)) {
                        redAreaInsideBlue += ShapeArea.calculateArea(innerShape);
                    }
                }
            }
        }

        return blueArea == 0 ? 0 : (redAreaInsideBlue / blueArea) * 100;
    }

    private static boolean isInside(Shape outer, Shape inner) {
        int outerStartX = Math.min(outer.getStartX(), outer.getEndX());
        int outerStartY = Math.min(outer.getStartY(), outer.getEndY());
        int outerEndX = Math.max(outer.getStartX(), outer.getEndX());
        int outerEndY = Math.max(outer.getStartY(), outer.getEndY());
        
        int innerStartX = Math.min(inner.getStartX(), inner.getEndX());
        int innerStartY = Math.min(inner.getStartY(), inner.getEndY());
        int innerEndX = Math.max(inner.getStartX(), inner.getEndX());
        int innerEndY = Math.max(inner.getStartY(), inner.getEndY());

        if (outer.getShapeType().equals("Cuadrado") || outer.getShapeType().equals("Circulo"))  {
            int outerSize = Math.max(outerEndX - outerStartX, outerEndY - outerStartY);
            outerEndX = outerStartX + outerSize;
            outerEndY = outerStartY + outerSize;
        }
        return innerStartX >= outerStartX && innerEndX <= outerEndX
                && innerStartY >= outerStartY && innerEndY <= outerEndY;
    }
}
