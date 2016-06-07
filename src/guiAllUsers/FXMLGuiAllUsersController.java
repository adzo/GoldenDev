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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLGuiAllUsersController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab subContainer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/guiAllUsers/FXMLAfficherAllUsers.fxml"));
            subContainer.setContent(root);
            subContainer.setText("Liste des Users");
        } catch (IOException ex) {
            Logger.getLogger(FXMLGuiAllUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
    public void upDateAllUser(){
        
    }
   
    
    public void addAllUsers(ActionEvent event) throws IOException{
        Stage stage1=new Stage();
        stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
             public void handle(WindowEvent we) {
                try {
                     reloadTable();
                 } catch (IOException ex) {
                     Logger.getLogger(FXMLGuiAllUsersController.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
        });
        
        AjoutAllUsers rechercheForm=new AjoutAllUsers();
        stage1.initModality(Modality.APPLICATION_MODAL);
        rechercheForm.start(stage1);
        stage1.setTitle("Ajouter un nouveau utilisateur");
        stage1.show();
    }
    
    public void deleteAllUsers() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm delete");
        alert.setHeaderText("Do you want to delete this user");
        alert.setContentText("Cette action est irreversible le "+AllUsers.modifiedUser.getType()+" sera supprimé de la base definitivement");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            AllUsersDAO p = new AllUsersDAO();
            p.supprimer();
            this.reloadTable();
        } else {
            // ... user chose CANCEL or closed the dialog
        }  
}

    /**
     *
     * @throws IOException
     */
    public  void reloadTable() throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("/guiAllUsers/FXMLAfficherAllUsers.fxml"));
            subContainer.setContent(root);
            subContainer.setText("Liste des Users");
    }
}
