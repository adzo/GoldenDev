/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import dao.AllUsersDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLDeleteAllUsersController implements Initializable {

    @FXML
    private Button confirm;
    @FXML
    private Button cancel;
    
    public void deleteAllUser(){
        AllUsersDAO p = new AllUsersDAO();
        p.supprimer();
    }
    
    public void cancel(ActionEvent event){
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
