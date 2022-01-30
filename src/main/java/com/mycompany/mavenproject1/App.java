package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public int ancho = 640;
    public static String pathFile="src/main/resources/files/";
    
    
    
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("inicioVista"));
        stage.setScene(scene);
        stage.hide();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        
    }
    public static void setRoot(FXMLLoader fxmlloader) throws IOException{
        scene.setRoot(fxmlloader.load());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static FXMLLoader loadFXMLLoader(String fxml) throws IOException{
        FXMLLoader fxmloader=new FXMLLoader(App.class.getResource(fxml+ ".fxml"));
        return fxmloader;
    
    }
    public static void main(String[] args) {
        launch();
    }

}