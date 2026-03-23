/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Drawable.Drawable;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class DrawablesDao {
    ArrayList <Drawable> drawables;
    
    //void save(Drawable drawable);
    //List<Drawable> load();
    
    
    public DrawablesDao() {
        drawables=new ArrayList();
    }
    
    public ArrayList<Drawable> getDrawables() {
        return drawables;
    }
}
