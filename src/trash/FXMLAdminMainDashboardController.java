/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLAdminMainDashboardController implements Initializable {

    public void afficherUsers(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/guiAfficherAllUsers/FXMLAfficherAllUsers.fxml"));
            tab.setContent(root);
            tab.setText("Liste des users");
        } catch (IOException ex) {
            Logger.getLogger(FXMLAdminMainDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void play(){
        System.out.println("Clicked");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    @FXML
    private Tab tab;
    
    
    
}
