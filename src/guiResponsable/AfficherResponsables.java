/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiResponsable;

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
 * @author mohamedaziz
 */
public class AfficherResponsables extends Application {
    
    @Override
    public void start(Stage afficherResponsable){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAfficherResponsables.fxml"));
            Scene scene = new Scene(root);
            afficherResponsable.setTitle("Affichage des Responsables antidopage");
            afficherResponsable.setScene(scene);
            afficherResponsable.setResizable(false);
            afficherResponsable.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherResponsables.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
