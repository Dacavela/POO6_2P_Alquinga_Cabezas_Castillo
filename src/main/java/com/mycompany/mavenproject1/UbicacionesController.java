/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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
        ImageView imgvLab=null;
        try{
            FileInputStream file=new FileInputStream(App.pathImage+"mapa.png");
            FileInputStream nuevFile=new FileInputStream(App.pathFile+"imagenLab.jpg");
            ImageView imv=new ImageView(new Image(file,root.getHeight(),root.getWidth(),true,true));
            imgvLab=new ImageView(new Image(nuevFile,20,20,true,true));            
            root.getChildren().add(imv);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
        
        
        
        
        
        
    }   
    
    
    class HiloContador1 implements Runnable{

        @Override
        public void run() {
            int numero=numeroAleatorio();
            while(numero>0){
                try {
                    Thread.sleep(numero*1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                numero--;
            }
        }
    
    }
    
    class HiloContador2 implements Runnable{

        @Override
        public void run() {
            int numero=5;
            while(numero>0){
                try {
                    Thread.sleep(numero*1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                numero--;
            }
        }
    
    }
    
    
    
    
    
    
    public int numeroAleatorio(){
        int numero=(int) (Math.random()*10+1);
        return numero;                
    }
    
    
}
