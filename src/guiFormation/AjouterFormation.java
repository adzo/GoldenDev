/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiFormation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ift
 */
public class AjouterFormation extends Application{
    private static AjouterFormation instance = null;

    public static AjouterFormation getInstance(){
        if(instance == null){
            instance = new AjouterFormation();
        }
        return instance;
    }
        @Override
        public void start(Stage ajouterFormation) throws IOException   {
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("/guiFormation/FXMLAjouterFormation.fxml"));
            Scene scene = new Scene(root);
            ajouterFormation.setTitle("Ajouter Formation");
           ajouterFormation.initStyle(StageStyle.TRANSPARENT);
 
            ajouterFormation.setScene(scene);
            ajouterFormation.setResizable(false);
            ajouterFormation.show();
        } catch (LoadException ex) {
            Logger.getLogger(AjouterFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}