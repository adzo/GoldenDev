/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAfficherAllUsers;

import guiAjoutAllUsers.AjoutAllUsers;
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
import javafx.stage.Stage;

/**
 *
 * @author AD ZO
 */
public class AfficherAllUsers extends Application {
    
    @Override
    public void start(Stage afficherAllUsers) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAfficherAllUsers.fxml"));
            
            Scene scene = new Scene(root);
            afficherAllUsers.setTitle("Affichage des utilisateurs");
            afficherAllUsers.setScene(scene);
            
            afficherAllUsers.setResizable(false);
            afficherAllUsers.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutAllUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
