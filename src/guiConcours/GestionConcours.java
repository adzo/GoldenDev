/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiConcours;

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
public class GestionConcours  extends Application{
    private static GestionConcours instance = null;

    public static GestionConcours  getInstance(){
        if(instance == null){
            instance = new GestionConcours ();
        }
        return instance;
    }
        @Override
        public void start(Stage gestionConcours ) throws IOException   {
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("FXMLGestionConcours.fxml"));
            Scene scene = new Scene(root);
            gestionConcours.setTitle("Gestion Concours");
           gestionConcours.initStyle(StageStyle.TRANSPARENT);
 
            gestionConcours.setScene(scene);
            gestionConcours.setResizable(false);
            gestionConcours.show();
        } catch (LoadException ex) {
            Logger.getLogger(GestionConcours.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}