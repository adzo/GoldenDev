/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiLogin;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author AD ZO
 */
public class Login extends Application {
    public Stage loginStage;
    
        public double xOffset;
        public double yOffset;
    @Override
    public void start(Stage loginStage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
        loginStage.setTitle("Login");
        loginStage.initStyle(StageStyle.TRANSPARENT);
        //loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.setOpacity(1);
        Scene scene = new Scene(root);
        scene.setFill(null);
        scene.getStylesheets().add(Login.class.getResource("main.css")
            .toExternalForm());
        
        loginStage.setScene(scene);
        
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
                loginStage.setX(event.getScreenX() - xOffset);
                loginStage.setY(event.getScreenY() - yOffset);
            }
        });

        
        
        loginStage.setResizable(false);
        loginStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public Login(){
        
    }

}
