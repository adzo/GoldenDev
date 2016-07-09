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
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ift
 */
public class ModifierProfile  extends Application{
 private static ModifierProfile instance = null;

    public static ModifierProfile getInstance(){
        if(instance == null){
            instance = new ModifierProfile();
        }
        return instance;
    }
        @Override
        public void start(Stage modifierProfile) throws IOException   {
        try { 
            Parent root = FXMLLoader.load(getClass().getResource("/guiArbitre/FXMLModifierProfile.fxml"));
            Scene scene = new Scene(root);
            modifierProfile.setTitle("Modifier profile Arbitre");
            modifierProfile.initStyle(StageStyle.TRANSPARENT);
 
            modifierProfile.setScene(scene);
            modifierProfile.setResizable(false);
            modifierProfile.show();
        } catch (LoadException ex) {
            Logger.getLogger(ModifierProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
