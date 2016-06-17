/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiSplash;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Abdelaziz
 */
public class FXMLSplashController implements Initializable {

    @FXML
    private ImageView background;
    @FXML
    private ImageView close;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image fond = new Image("resources/Backgrounds/splash.jpg", 300, 250, true, true);
        background.setImage(fond);
        Image closeAbout = new Image("resources/Icons/closeTooltip.png", 25, 25, true, true);
        close.setImage(closeAbout);
        
    }    
    
    public void closeThis(MouseEvent event){
       ((Node) (event.getSource())).getScene().getWindow().hide();
        System.out.println("Closing the about splash");
    }
    
}
