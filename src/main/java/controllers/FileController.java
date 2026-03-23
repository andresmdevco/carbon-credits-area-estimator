/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author andre
 */
public class FileController {
    
    public BufferedImage loadImage(File file){
        try{
            return ImageIO.read(file);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}

