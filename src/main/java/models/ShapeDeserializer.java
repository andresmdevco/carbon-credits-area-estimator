/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import Drawable.Drawable;
import Drawable.DrawableCircle;
import Drawable.DrawableEllipse;
import Drawable.DrawableRectangle;
import Drawable.DrawableSquare;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.awt.Color;
import java.io.IOException;

/**
 *
 * @author andre
 */

public class ShapeDeserializer extends JsonDeserializer<Drawable> {

    @Override
    public Drawable deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        // Leer el árbol JSON
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        // Obtener los campos del nodo JSON
        String shapeType = node.get("shapeType").asText();
        Color color = new Color(node.get("color").asInt());
        int startX = node.get("startX").asInt();
        int startY = node.get("startY").asInt();
        int endX = node.get("endX").asInt();
        int endY = node.get("endY").asInt();

        // Crear el objeto Drawable utilizando createDrawable
        Drawable newDrawable = createDrawable(shapeType, color, startX, startY, endX, endY);
        
        // Devolver el nuevo Drawable creado
        return newDrawable;
    }

    // Método para crear un Drawable según el tipo de figura
    private Drawable createDrawable(String shapeType, Color color, int startX, int startY, int endX, int endY) {
        switch (shapeType.toLowerCase()) {
            case "circulo" -> {
                return new DrawableCircle(Math.abs(endX - startX), shapeType, color, startX, startY, endX, endY);
            }
            case "cuadrado" -> {
                return new DrawableSquare(Math.abs(endX - startX), shapeType, color, startX, startY, endX, endY);
            }
            case "elipse" -> {
                return new DrawableEllipse(Math.abs(endX - startX), Math.abs(endY - startY), shapeType, color, startX, startY, endX, endY);
            }
            case "rectangulo" -> {
                return new DrawableRectangle(Math.abs(endX - startX), Math.abs(endY - startY), shapeType, color, startX, startY, endX, endY);
            }
            default -> throw new IllegalArgumentException("Forma no reconocida: " + shapeType);
        }
    }
}