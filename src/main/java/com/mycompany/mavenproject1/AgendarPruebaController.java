/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import com.mycompany.mavenproject1.modelo.CamposIncompletosException;
import com.mycompany.mavenproject1.modelo.Cita;
import com.mycompany.mavenproject1.modelo.Prueba;
import static com.mycompany.mavenproject1.modelo.Prueba.obtenerPrueba;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AgendarPruebaController implements Initializable {
        Double subtotal = 0.00;
        Double dom = 5.00;
        Double to = 0.00;
        ArrayList<Cita> guardarServicio = new ArrayList<>();
    @FXML
    private ComboBox<String> cmbTipo;
    @FXML
    private ComboBox<Prueba> cmbPrueba;
    @FXML
    private TextField TextFCantidad;
    @FXML
    private Button idbtnAgregar;
    @FXML
    private VBox root;

    private Label precioTipo;
    @FXML
    private VBox fPane;
    @FXML
    private HBox hBinferior;
    @FXML
    private Button btnContinuar;
    Label subtot = new Label();
    Label pDom = new Label();
    Label tot = new Label();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         
        hBinferior.setAlignment(Pos.CENTER_RIGHT);
        VBox vBtotal = new VBox();
        vBtotal.setPadding(new Insets(0,80,0,0));
        vBtotal.setAlignment(Pos.CENTER_RIGHT);
        
        hBinferior.getChildren().add(vBtotal);
        vBtotal.getChildren().addAll(subtot,pDom,tot);
        
        precioTipo.setText("");
        cmbTipo.getItems().setAll(Prueba.tiP);
        cmbTipo.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                precioTipo.setText("");
                TextFCantidad.clear();
                cmbPrueba.getItems().clear();
                cmbPrueba.getItems().setAll(obtenerPrueba(cmbTipo.getValue()));
                
            }
            });
        
        cmbPrueba.valueProperty().addListener(new ChangeListener<Prueba>() {
            @Override
            public void changed(ObservableValue<? extends Prueba> observable, Prueba oldValue, Prueba newValue){
                Double pr = cmbPrueba.getValue().getPrecio();
                precioTipo.setText(pr.toString());
            }
        });
        
        
        
        
    }    
    
    @FXML
    private void ActionAgregar(ActionEvent event) {
        try
        {
            camposVacios();
            Prueba p = cmbPrueba.getValue();

            Double precio = Double.parseDouble(precioTipo.getText()) * Double.parseDouble(TextFCantidad.getText());

            HBox agregado = new HBox();

            agregado.setMinWidth(200);
            agregado.setAlignment(Pos.CENTER_RIGHT);
            Label Nombre = new Label();
            Label Cantidad = new Label();
            Label Precio = new Label();
            Nombre.setPadding(new Insets(0, 0, 0, 0));
            Cantidad.setPadding(new Insets(0, 0, 0, 0));
            Precio.setPadding(new Insets(0, 80, 0, 0));
            Nombre.setText(p.getNombrePrueba());
            Cantidad.setText(TextFCantidad.getText());
            Precio.setText(precio.toString());
            agregado.getChildren().addAll(Nombre, Cantidad, Precio);
            agregado.setSpacing(175);
            fPane.getChildren().add(agregado);
            subtotal += precio;

            to = subtotal + dom;

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    subtot.setText("Subtotal:     " + subtotal.toString());
                    pDom.setText("Servicio domicilio:     " + dom.toString());

                    tot.setText("Total:     " + to.toString());
                }
            });

        } catch (NumberFormatException | CamposIncompletosException e1)
        {
            Alert a = new Alert(Alert.AlertType.ERROR, "Datos Incompletos");
            a.showAndWait();

        } catch (NullPointerException e4)
        {
            Alert a = new Alert(Alert.AlertType.ERROR, "Datos Incompletos");
            a.showAndWait();
        }
    }
    public void camposVacios() throws CamposIncompletosException{
        if(cmbTipo.getValue().equals("")){
            throw new CamposIncompletosException("Campos incompletos");
        }if(cmbPrueba == null){
            throw new CamposIncompletosException("Campos incompletos");
        }if(TextFCantidad.getText().equals("")){
            throw new CamposIncompletosException("Campos incompletos");
        }
    
    }

    @FXML
    private void continuar(ActionEvent event) {
        if(subtotal != 0.0){
            try
            {
                App.setRoot("popUpUbicacion");
            } catch (IOException ex)
            {
            }
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "No ha elegido Servicio");
            a.showAndWait();
        }
    } 
    }    
