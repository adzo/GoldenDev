/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMedecin;

import guiMain.Main;
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
import javafx.stage.StageStyle;

/**
 *
 * @author AD ZO
 */
public class AjoutMedecin extends Application {
    
    private static AjoutMedecin instance = null;

    public static AjoutMedecin getInstance(){
        if(instance == null){
            instance = new AjoutMedecin();
        }
        return instance;
    }
    @Override
    public void start(Stage ajoutMedecin) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAjoutMedecin.fxml"));
        ajoutMedecin.setTitle("Ajout Medecin");
        //ajoutMedecin.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
        //ajoutMedecin.setOpacity(1);
        scene.setFill(null);
        //scene.getStylesheets().add(Main.class.getResource("main.css")
           // .toExternalForm());
        ajoutMedecin.setScene(scene);
        //ajoutMedecin.setResizable(true);
        ajoutMedecin.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
