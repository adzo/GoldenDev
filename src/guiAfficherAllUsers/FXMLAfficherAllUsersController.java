/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAfficherAllUsers;

import dao.AllUsersDAO;
import entities.AllUsers;
import java.awt.List;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLAfficherAllUsersController implements Initializable {

    @FXML
    private TableView<AllUsers> tableAllUsers;
    @FXML
    private TableColumn<AllUsers, Integer> id;
    @FXML
    private TableColumn<AllUsers, String> login;
    @FXML
    private TableColumn<AllUsers, String> mdp;
    @FXML
    private TableColumn<AllUsers, String> type;
    
    AllUsersDAO p = new AllUsersDAO();
    ObservableList<AllUsers> data;
    
    AllUsers u = new AllUsers();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        login.setCellValueFactory(new PropertyValueFactory<>("login"));
        mdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        u.listes = p.afficherTout();
        data = FXCollections.observableArrayList(u.listes);
        tableAllUsers.setItems(data);
        
        
    }    
    
}
