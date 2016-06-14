/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author AD ZO
 */
public class Main extends Application {

    //Déclaration des variable pour l'option de DRAG
    public Stage mainStage;
    public double xOffset;
    public double yOffset;
    
    private static Main instance = null;

    @Override
    public void start(Stage mainStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMain.fxml"));
        mainStage.setTitle("TFT - By GoldenDev - V1.0");
        mainStage.initStyle(StageStyle.UNDECORATED);
        Scene scene = new Scene(root);
//        mainStage.setOpacity(1);
//        scene.setFill(null);
//        scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());
        mainStage.setScene(scene);
       //mainStage.setResizable(false);
        Image ico = new Image("resources/Icons/Main_TFT.png");
        mainStage.getIcons().add(ico);
//        mainStage.minWidthProperty().bind(scene.heightProperty().multiply(2));
//        mainStage.minHeightProperty().bind(scene.widthProperty().divide(2));
        mainStage.show();
        
        /**
         * 
         * *    Setting the Drag option
         * 
         */
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                 xOffset = event.getSceneX();
                 yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainStage.setX(event.getScreenX() - xOffset);
                mainStage.setY(event.getScreenY() - yOffset);
            }
        });
        /**
         * 
         * 
         */
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private Main(){
        
    }
    
    public static Main getInstance(){
        if(instance == null){
            instance = new Main();
        }
        return instance;
    }
    

}
