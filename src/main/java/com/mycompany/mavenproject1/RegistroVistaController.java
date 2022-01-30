/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.modelo.ManejoArchivos.Archivos;
import com.mycompany.mavenproject1.modelo.Paciente;
import com.mycompany.mavenproject1.modelo.RegistroException;
import static com.mycompany.mavenproject1.modelo.Validaciones.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
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
    private String gender = "";
    private ArrayList<TextField> listaFields = new ArrayList<>();
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
        listaFields.add(txtCedula);
        listaFields.add(txtNombres);
        listaFields.add(txtApellidos);
        listaFields.add(tctCiudad);
        listaFields.add(txtEmail);
        listaFields.add(txtTelefono);
        listaFields.add(txtUsuarioReg);
        listaFields.add(txtContraReg);
        
        
        
        
        ToggleGroup tg = new ToggleGroup();
        this.rbtnFemenino.setToggleGroup(tg);
        this.rbtnMasculino.setToggleGroup(tg);
        this.rbtnOtro.setToggleGroup(tg);
        
        
        
    }    

    @FXML
    private void registroPaciente(ActionEvent event) {
        //Validacion Campos Vacios
        try{
        if(camposVacios()){
            throw new RegistroException("Los campos no deben estar vacios");
            
        }else{
            Paciente p1 = new Paciente(validNameUser(txtUsuarioReg),
            validPassword(txtContraReg),
            "P",validarCedula(txtCedula),
            validarNames(txtNombres),
            validarNames(txtApellidos),
            txtFnac.getValue().toString(),
            gender,
            validarNames(tctCiudad),
            validarEmail(txtEmail),
            validarCelular(txtTelefono));
            
            Archivos.escribirPaciente(p1);
            Archivos.escribirUsuario(p1);
            Alert a =new Alert(AlertType.CONFIRMATION,"Datos guardados exitosamente");
            a.show();
            App.setRoot("inicioVista");
            }}catch(RegistroException e){
                Alert alerta = new Alert(AlertType.ERROR);
                alerta.setHeaderText(null);
                alerta.setContentText(e.getMessage());
                alerta.showAndWait();
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    
    }
        
    
  public boolean camposVacios() throws RegistroException{
      
      for(TextField e : listaFields){
          if(e.getText().equals("")){
              return true;
          }
      try{
          if(txtFnac.getValue().toString().equals("")){
            return true;
        }
      }catch(RuntimeException e1){
          return true;
      }
      //RadioButton Genero
        if(rbtnMasculino.isSelected()){
            gender = rbtnMasculino.getText();
        }else if(rbtnFemenino.isSelected()){
            gender = rbtnFemenino.getText();
        }else if(rbtnOtro.isSelected()){
            gender = rbtnOtro.getText();
        }else{
            return true;
        
        }
        
      }return false;
  }
}
