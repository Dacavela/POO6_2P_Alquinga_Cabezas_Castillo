/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

//import static com.mycompany.mavenproject1.App.setRoot;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DhuDu
 */
public class InicioVistaController implements Initializable {

    @FXML
    private ImageView imgLogo;
    @FXML
    private Label lblVithas;
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblNewAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mostrarNombre(InputMethodEvent event) {
        
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        System.out.println("iniciando sesion");
    }

    @FXML
    private void crearNuevaCuenta(MouseEvent event) {
    try{
        
        App.setRoot("registroVista");
        
    }catch(Exception e){}
    }
    
    
}
