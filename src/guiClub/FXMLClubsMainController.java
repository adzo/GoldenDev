/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiClub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Abdelaziz
 */
public class FXMLClubsMainController implements Initializable {

    @FXML
    private Pane center;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void openList() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/guiClub/FXMLListeClub.fxml"));
        center.getChildren().clear();
        center.getChildren().add(root);
        
    }
    
}
