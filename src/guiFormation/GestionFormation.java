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
public class GestionFormation  extends Application{
    private static GestionFormation instance = null;

    public static GestionFormation getInstance(){
        if(instance == null){
            instance = new GestionFormation();
        }
        return instance;
    }
        @Override
        public void start(Stage gestionFormation) throws IOException   {
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("/guiFormation/FXMLGestionFormations.fxml"));
            Scene scene = new Scene(root);
            gestionFormation.setTitle("Gestion Formation");
           gestionFormation.initStyle(StageStyle.TRANSPARENT);
 
            gestionFormation.setScene(scene);
            gestionFormation.setResizable(false);
            gestionFormation.show();
        } catch (LoadException ex) {
            Logger.getLogger(GestionFormation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}