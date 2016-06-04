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
public class DeleteAllUsers extends Application {
    
    private static DeleteAllUsers instance = null;

    public static DeleteAllUsers getInstance(){
        if(instance == null){
            instance = new DeleteAllUsers();
        }
        return instance;
    }
    
    
    
    @Override
    public void start(Stage deleteAllUsers) {
         AllUsers u = new AllUsers(5, "adzo", "123456", "arbitre");
        AllUsers.modifiedUser = u;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDeleteAllUsers.fxml"));
            
            Scene scene = new Scene(root);
            deleteAllUsers.setTitle("Warning: suppression d'un utilisateur");
            deleteAllUsers.setScene(scene);
            
            deleteAllUsers.setResizable(false);
            deleteAllUsers.show();
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
