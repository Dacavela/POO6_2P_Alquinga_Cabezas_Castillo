/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.modelo.Paciente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author DhuDu
 */
public class RegistroVistaController implements Initializable {

    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombres;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField tctCiudad;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtUsuarioReg;
    @FXML
    private TextField txtContraReg;
    @FXML
    private DatePicker txtFnac;
    @FXML
    private RadioButton rbtnMasculino;
    @FXML
    private RadioButton rbtnFemenino;
    @FXML
    private RadioButton rbtnOtro;
    @FXML
    private Button btnRegistrarse;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        this.rbtnFemenino.setToggleGroup(tg);
        this.rbtnMasculino.setToggleGroup(tg);
        this.rbtnOtro.setToggleGroup(tg);
        
        
        
    }    

    @FXML
    private void registroPaciente(ActionEvent event) {
        String gender = "";
        if(rbtnMasculino.isSelected()){
            gender = rbtnMasculino.getText();
        }if(rbtnFemenino.isSelected()){
            gender = rbtnFemenino.getText();
        }if(rbtnOtro.isSelected()){
            gender = rbtnOtro.getText();
        }
        if(txtCedula.equals("")){
            Alert alerta = new Alert(AlertType.ERROR,"Llene todos los campos");
            alerta.show();
        }else{
            Paciente p1 = new Paciente(txtCedula.getText(),
            txtNombres.getText(),
            txtApellidos.getText(),
            txtFnac.getValue().toString(),
            gender,
            tctCiudad.getText(),
            txtEmail.getText(),
            txtTelefono.getText(),
            txtUsuarioReg.getText(),
            txtContraReg.getText(),
            "P");
    
    }
        
    }
  
}
