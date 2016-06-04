/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import dao.AllUsersDAO;
import entities.AllUsers;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private Button delete;

    /**
     *
     * @param event
     */
    @FXML
    public void selectedUser(MouseEvent event) {
        AllUsers.modifiedUser = tableAllUsers.getSelectionModel().getSelectedItem();
        System.out.println(AllUsers.modifiedUser);
    }

    public void deleteAllUser() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirm delete");
        alert.setHeaderText("Do you want to delete this user");
        alert.setContentText("Are you ok with this?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            AllUsersDAO p = new AllUsersDAO();
            p.supprimer();
            this.refreshTable();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
    

    }
    
    public void refreshTable(){
        u.listes = p.afficherTout();
        data = FXCollections.observableArrayList(u.listes);
        tableAllUsers.setItems(data);
    }

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
