/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import java.io.IOException;
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
public class GuiAllUsers extends Application {
    
    @Override
    public void start(Stage allUsersStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLGuiAllUsers.fxml"));
        Scene scene = new Scene(root);
        allUsersStage.setTitle("All Users");
        allUsersStage.setScene(scene);
        allUsersStage.setResizable(false);
        allUsersStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
