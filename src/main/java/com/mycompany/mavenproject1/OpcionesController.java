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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
        try {
            App.setRoot("Ubicaciones");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void SolicitarPruebaDomicilio(ActionEvent event) {
        try {
            App.setRoot("AgendarPrueba");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void SolicitarPruebaDomicilio(MouseEvent event) {
    }
    
}
