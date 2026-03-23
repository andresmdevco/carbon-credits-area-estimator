/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import views.MainWindow;



/**
 *
 * @author andre
 */
public class MainController {

    private MainWindow mainWindow;

    public MainController() {
        this.mainWindow = new MainWindow();
    }

    public void start() {
        mainWindow.setVisible(true);
    }
}