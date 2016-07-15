/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

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
 * @author ift
 */
public class ModifArbitre extends Application {
        private static ModifArbitre instance = null;

    public static ModifArbitre getInstance() {
        if(instance==null){
            instance= new ModifArbitre();
        }
        return instance;
    }
        @Override
    public void start(Stage modifArbitre){
         try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLModifArbitre.fxml"));
            
            Scene scene = new Scene(root);
            modifArbitre.setTitle("Modifier Arbitre");
            modifArbitre.setScene(scene);
            
            modifArbitre.setResizable(false);
            modifArbitre.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutArbitre.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
