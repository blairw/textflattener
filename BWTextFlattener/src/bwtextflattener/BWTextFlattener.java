/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bwtextflattener;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author blair
 */
public class BWTextFlattener extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        // set up loader and controller
        FXMLLoader myLoader = new FXMLLoader();
        FXMLDocumentController myController = new FXMLDocumentController();
        
        // configure loader
        myLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        myLoader.setController(myController);

        // actually load
        Parent root = myLoader.load();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
