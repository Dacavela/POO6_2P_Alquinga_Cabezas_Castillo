/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class OpcionesController implements Initializable {

    @FXML
    private Button ConocerUbicBtn;
    @FXML
    private Button PruebaDomBtn;
    @FXML
    private Text NamePaText;
    @FXML
    private Text idBienvenido;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void setLabel(String usuario){
        idBienvenido.setText(usuario);
    }
    

    @FXML
    private void ConocerUbicaciones(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Ubicaciones.fxml"));
        try
        {
            Parent root1 = loader.load();
            UbicacionesController contr = loader.getController();
            Scene sen = new Scene(root1,1325,700);
            Stage stag = new Stage();
            stag.setScene(sen);
            stag.show();
            
        } catch (IOException ex)
        {

        try {
            App.setRoot("Ubicaciones");
        } catch (IOException ex1) {

            ex.printStackTrace();
        }
    }
    }
    @FXML
    public void SolicitarPruebaDomicilio(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AgendarPrueba.fxml"));
        try
        {
            Parent root1 = loader.load();
            AgendarPruebaController contr = loader.getController();
            Scene sen = new Scene(root1,1325,700);
            Stage stag = new Stage();
            stag.setScene(sen);
            stag.show();
            
        } catch (IOException ex)
        {

        try {
            App.setRoot("AgendarPrueba");
        } catch (IOException ex1) {

            ex.printStackTrace();
        }
    }
        }
    }
    

  
    

