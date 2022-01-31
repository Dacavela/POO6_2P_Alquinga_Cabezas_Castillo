/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PopUpUbicacionController implements Initializable {

    @FXML
    private AnchorPane paneContenedor;
    @FXML
    private TextField txtDireccion;
    @FXML
    private Button btnFinalizar;

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
            paneContenedor.setBackground(background);
        } 
        catch (Exception e) {
                System.out.println("No se encuentra la imagen");
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }    

    @FXML
    private void pinMapa(MouseEvent event) {
        paneContenedor.getChildren().clear();
        System.out.print("X: "+event.getX());
        System.out.println("   Y:"+event.getY());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                  Platform.runLater(new Runnable() {

            String nombreImage = "";

            @Override
            public void run() {
                try ( FileInputStream input = new FileInputStream(App.pathImage + "mapPin.png")) {
                    Image im = new Image(input);
                    ImageView imgv = new ImageView();
                    imgv.setImage(im);
                    imgv.setFitHeight(70);
                    imgv.setPreserveRatio(true);
                    imgv.setLayoutX(event.getX()-33.0);
                    //imgv.setLayoutX(320.6666666666666);
                    imgv.setLayoutY(event.getY()-62.0);
                    
                    paneContenedor.getChildren().add(imgv);

                } catch (IOException e) {
                    System.out.println("No se encuentra la imagen");

                }

            }

        });
            }
        });
        t.start();
        
    }
    

    @FXML
    private void finalizar(ActionEvent event) {
        
        
        
    }
    
}
