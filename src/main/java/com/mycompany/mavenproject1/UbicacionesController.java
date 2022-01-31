/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.modelo.ManejoArchivos.Archivos.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Platform;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class UbicacionesController implements Initializable {

    @FXML

    private Pane root;

    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try ( FileInputStream input = new FileInputStream(App.pathImage + "mapa.png")) {
            System.out.println(input.toString());
            Image im = new Image(input); 
            
            //EJEMPLO PARA PONER UNA IMAGEN COMO FONDO. puede ser para  un control o un contenedor que tenga el metodo setBackground
            BackgroundImage backgroundImage = new BackgroundImage(im, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background background = new Background(backgroundImage);
            root.setBackground(background);
            mostrarubi();
        } 
        catch (Exception e) {
                System.out.println("No se encuentra la imagen");
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }    
    public void mostrarubi(){
        ArrayList<String> sucursales = leerUbi();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                  for(String s: sucursales){
                      mostIma(s);
                  }
            }
        });
        t.start();
    
    }
    public void mostIma(String s){
        ArrayList<String> sucursales = leerUbi();
        Platform.runLater(new Runnable() {


            @Override
            public void run() {
                
                try ( FileInputStream input = new FileInputStream(App.pathImage + "mapPin.png")) {
                    
                        String[] lineaSep = s.split("-");
                        Image im = new Image(input);
                    ImageView imgv = new ImageView();
                    imgv.setImage(im);
                    imgv.setFitHeight(70);
                    imgv.setPreserveRatio(true);
                    imgv.setLayoutX(Double.parseDouble(lineaSep[0]));
                    imgv.setLayoutY(Double.parseDouble(lineaSep[1]));
                    
                    root.getChildren().addAll(imgv);
                        System.out.println(s);
                } catch (IOException e) {
                    System.out.println("No se encuentra la imagen");
                }
            }
        });
    
    }
        
        
    }
    
    


    
    


