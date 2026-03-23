/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package models;

import Drawable.Drawable;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/**
 *
 * @author andre
 */

import java.io.IOException;

public class ShapeSerializer extends JsonSerializer<Drawable> { // Usamos Drawable en lugar de Shape
    @Override
    public void serialize(Drawable drawable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("shapeType", ((Shape) drawable).getShapeType());
        jsonGenerator.writeNumberField("color", ((Shape) drawable).getColor().getRGB());
        jsonGenerator.writeNumberField("startX", ((Shape) drawable).getStartX());
        jsonGenerator.writeNumberField("startY", ((Shape) drawable).getStartY());
        jsonGenerator.writeNumberField("endX", ((Shape) drawable).getEndX());
        jsonGenerator.writeNumberField("endY", ((Shape) drawable).getEndY());
        jsonGenerator.writeEndObject();
    }
}