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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

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
    @FXML
    private Pane preview;
    @FXML
    private Label target;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/guiAllUsers/FXMLAfficherAllUsers.fxml"));
//            subContainer.setContent(root);
//            subContainer.setText("Liste des Users");

            preview.getChildren().clear();
            preview.getChildren().add(root);

        } catch (IOException ex) {
            Logger.getLogger(FXMLGuiAllUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void upDateAllUser() throws IOException {
        if (AllUsers.modifiedUser == null) {
            target.setText("Aucun user n'est selectionné");
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> target.setText("")));
            timeline.play();
            
        } else{
            try {
            Stage modif = new Stage();
            
                    modif.setOnCloseRequest(new EventHandler<WindowEvent>() {
             public void handle(WindowEvent we) {
                
                 try {
                     reloadTable();
                 } catch (IOException ex) {
                     Logger.getLogger(FXMLGuiAllUsersController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
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
    }

    public void addAllUsers(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();
        stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                try {
                    reloadTable();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLGuiAllUsersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        AjoutAllUsers ajoutAllUsers = new AjoutAllUsers();
        stage1.initModality(Modality.APPLICATION_MODAL);
        ajoutAllUsers.start(stage1);
        stage1.setTitle("Ajouter un nouveau utilisateur");
        stage1.show();
    }

    public void deleteAllUsers() throws IOException {
        Alert alert;
        if (AllUsers.modifiedUser == null) {
            target.setText("Aucun user n'est selectionné");
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> target.setText("")));
            timeline.play();
        } else {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm delete");
            alert.setHeaderText("Do you want to delete this user");
            alert.setContentText("Cette action est irreversible le " + AllUsers.modifiedUser.getType() + " sera supprimé de la base definitivement");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                // ... user chose OK
                AllUsersDAO p = new AllUsersDAO();
                p.supprimer();
                this.reloadTable();
                AllUsers.modifiedUser = null;
            } else {
                // ... user chose CANCEL or closed the dialog
            }
        }
    }

    /**
     *
     * @throws IOException
     */
    public void reloadTable() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/guiAllUsers/FXMLAfficherAllUsers.fxml"));
//            subContainer.setContent(root);
//            subContainer.setText("Liste des Users");

        preview.getChildren().clear();
        preview.getChildren().add(root);
    }
}
