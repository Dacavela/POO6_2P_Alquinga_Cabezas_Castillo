/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

//import static com.mycompany.mavenproject1.App.setRoot;
import com.mycompany.mavenproject1.modelo.ManejoArchivos.Archivos;
import com.mycompany.mavenproject1.modelo.Paciente;
import com.mycompany.mavenproject1.modelo.RegistroException;
import com.mycompany.mavenproject1.modelo.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private ArrayList<Usuario> lista;
    private ArrayList<Paciente> listaPaciente;
    
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
        lista=Archivos.leerUsuario();
        listaPaciente=Archivos.leerPaciente();
        
    }    

    @FXML
    private void mostrarNombre(InputMethodEvent event) {
        
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String usuario=txtUser.getText();
        String contrasena=txtPassword.getText();
        try{
        for(Usuario u:lista){
            if(u.getUsuario().equals(usuario) && u.getPassword().equals(contrasena)){
                String tipo=u.getTipo();                
                if(tipo.equals("P")){
                    boolean genero=Archivos.leerGenero(u);
                    
                    FXMLLoader fxmlloader=App.loadFXMLLoader("Opciones");
                    App.setRoot(fxmlloader);
                    OpcionesController oc=fxmlloader.getController();
                    if(genero==true){
                        oc.setLabel("BIENVENIDA "+usuario);
                    }
                    else
                        oc.setLabel("BIENVENIDO "+ usuario);
                    
                }else{
                    App.setRoot("OpcionesLaboratorista");
                }
            }else{
                throw new RegistroException("Datos invalidos");
            }
                
        }
        }catch(IOException ex){
            System.out.println("No se encontro el root");
        } catch (RegistroException ex) {
            Alert a=new Alert(AlertType.ERROR,"Usuario o contraseña invalidos");
            a.show();
        }
    }

    @FXML
    private void crearNuevaCuenta(MouseEvent event) {
    try{
        
        App.setRoot("registroVista");
        
    }catch(Exception e){}
    }
    
    
}
