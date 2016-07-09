/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ift
 */
public class AfficherArbitre  extends Application{
 
        @Override
        public void start(Stage afficherArbitre)  {
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("/guiArbitre/FXMLAfficherArbitre.fxml"));
            Scene scene = new Scene(root);
            afficherArbitre.setTitle("Affichage des Arbitres");
            afficherArbitre.setScene(scene);
            afficherArbitre.setResizable(false);
            afficherArbitre.show();
        } catch (IOException ex) {
            Logger.getLogger(AfficherArbitre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
