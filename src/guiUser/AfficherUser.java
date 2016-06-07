/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiUser;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author AD ZO
 */
public class AfficherUser extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
      
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAfficherUser.fxml")); 
            Scene scene = new Scene(root);
            stage.setTitle("Affichage des simples utilisateurs");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
