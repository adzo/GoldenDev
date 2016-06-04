/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMainDash;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author AD ZO
 */
public class MainDash extends Application {
    
   
    @Override
    public void start(Stage AdminMainSTage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainDash.fxml"));
        Scene scene = new Scene(root);
        AdminMainSTage.setTitle("Login");
        AdminMainSTage.setScene(scene);
        AdminMainSTage.setResizable(true);
        AdminMainSTage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
