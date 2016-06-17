/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiSplash;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Abdelaziz
 */
public class Splash extends Application {
    
    @Override
    public void start(Stage splash) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLSplash.fxml"));
            Scene scene = new Scene(root);
            splash.initStyle(StageStyle.UNDECORATED);
//            splash.initModality(Modality.APPLICATION_MODAL);
            splash.setTitle("Splash");
            splash.setScene(scene);
            splash.setResizable(false);
            splash.show();
        } catch (IOException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
