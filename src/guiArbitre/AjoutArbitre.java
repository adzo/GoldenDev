/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

import guiMain.Main;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ift
 */
public class AjoutArbitre extends Application{
     private static AjoutArbitre instance = null;

    public static AjoutArbitre getInstance(){
        if(instance == null){
            instance = new AjoutArbitre();
        }
        return instance;
    }
    @Override
    public void start(Stage ajoutArbitre) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLajoutArbitre.fxml"));
        ajoutArbitre.setTitle("Ajout Arbitre");
//        ajoutArbitre.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root);
//        ajoutArbitre.setOpacity(1);
        scene.setFill(null);
//        scene.getStylesheets().add(Main.class.getResource("main.css")
//           .toExternalForm());
        ajoutArbitre.setScene(scene);
        ajoutArbitre.setResizable(true);
        ajoutArbitre.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
}


