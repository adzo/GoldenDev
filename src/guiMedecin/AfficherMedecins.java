/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMedecin;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mohamedaziz
 */
public class AfficherMedecins extends Application {
    
    @Override
    public void start(Stage afficherMedecin)  {
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("/guiMedecin/FXMLAfficherMedecins.fxml"));
            Scene scene = new Scene(root);
            afficherMedecin.setTitle("Affichage des Medecins");
            afficherMedecin.setScene(scene);
            afficherMedecin.setResizable(false);
            afficherMedecin.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherMedecins.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
