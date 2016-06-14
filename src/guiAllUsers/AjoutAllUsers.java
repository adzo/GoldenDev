/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

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
 * @author AD ZO
 */
public class AjoutAllUsers extends Application {
    
    @Override
    public void start(Stage ajoutAllUsers) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAjoutAllUsers.fxml"));
            Scene scene = new Scene(root);
            ajoutAllUsers.setTitle("Ajout d'un utilisateur");
            ajoutAllUsers.setScene(scene);
            ajoutAllUsers.setResizable(false);
            ajoutAllUsers.show();
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
