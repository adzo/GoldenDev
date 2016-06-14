/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import entities.AllUsers;
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
public class ModifierPassword extends Application {
    
    private static ModifierPassword instance = null;

    public static ModifierPassword getInstance(){
        if(instance == null){
            instance = new ModifierPassword();
        }
        return instance;
    }
    
    @Override
    public void start(Stage modifierPassword) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLModifierPassword.fxml"));
            
            Scene scene = new Scene(root);
            modifierPassword.setTitle("Modify Password");
            modifierPassword.setScene(scene);
            
            modifierPassword.setResizable(false);
            modifierPassword.show();
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
