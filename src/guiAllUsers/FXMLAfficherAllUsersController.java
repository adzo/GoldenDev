/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import dao.AllUsersDAO;
import entities.AllUsers;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        if (event.getClickCount() == 1){
        AllUsers.modifiedUser = tableAllUsers.getSelectionModel().getSelectedItem();
        System.out.println(AllUsers.modifiedUser);
        }else if (event.getClickCount() ==2){
            AllUsers.modifiedUser = tableAllUsers.getSelectionModel().getSelectedItem();
            this.ouvrirModifierPassword();
            
            System.out.println("Souris clické deux fois!!");
        }
    }

    public void ouvrirModifierPassword(){
        try {
            Stage modif = new Stage();
            
             modif.setOnCloseRequest(new EventHandler<WindowEvent>() {
             public void handle(WindowEvent we) {
                
                     refreshTable();
                     AllUsers.modifiedUser = null;
            }
        });
            
            Parent root = FXMLLoader.load(getClass().getResource("FXMLModifierPassword.fxml"));
            Scene scene = new Scene(root);
            modif.setTitle("modifier mot de pass");
            modif.setScene(scene);
            modif.initModality(Modality.APPLICATION_MODAL);
            modif.setResizable(false);
            modif.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAfficherAllUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        final int size = tableAllUsers.getItems().size() -1;
        tableAllUsers.scrollTo(size);
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
        final int size = tableAllUsers.getItems().size() -1;
        tableAllUsers.scrollTo(size);
        
      

    }

}
