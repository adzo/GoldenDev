/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiLogin;

import dao.AllUsersDAO;
import entities.AllUsers;
import guiMain.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLLoginController implements Initializable {

    public static KeyEvent keyPressed;
    public static Node node;

    @FXML
    private TextField login;
    @FXML
    private PasswordField pass;
    @FXML
    private Label textTarget;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

//       login.setOnKeyPressed(new EventHandler<KeyEvent>() {
//        @Override
//        public void handle(KeyEvent keyEvent) {
//            if (keyEvent.getCode() == KeyCode.ENTER)  {
//                ActionEvent event = new ActionEvent();
//                 this.verifierLogin(event);  
//            }
//    }
//});
//    public void keyPressed(KeyEvent kEvent) throws IOException {
//        if (kEvent.getCode() == KeyCode.ENTER) {
//            ActionEvent event = new ActionEvent();
//            
//            this.verifierLogin(event);
//            keyPressed = kEvent;
//        }
//    }

    public void verifierLogin(ActionEvent event) throws IOException {

        String log = login.getText();
        //String typ;
        String password = pass.getText();
        if (!log.equals("") && !password.equals("")) {
            AllUsers s = new AllUsers();
            AllUsersDAO p = new AllUsersDAO();
            s = p.verifier(log, password);
            if (s != null) {
                //typ = s.getType();
                textTarget.setText(s.getType() + " connecté");
                AllUsers.connected = s;
                System.out.println(AllUsers.connected);

                this.ouvrirMain(event);
            } else {
                textTarget.setText("Login erroné!!");
            }
        } else {
            textTarget.setText("Champs vides!!");
        }
    }

    public void ouvrirMain(ActionEvent event) {
        try {
            
                ((Node) (event.getSource())).getScene().getWindow().hide();
            
            Stage mainDashboard = new Stage();
            //mainDashboard.initStyle(StageStyle.UNDECORATED);
            mainDashboard.setResizable(true);
            Main mainWindow = Main.getInstance();
            //mainDashboard.initModality(Modality.APPLICATION_MODAL);
            mainWindow.start(mainDashboard);
            System.out.println(AllUsers.connected);

        } catch (IOException ex) {
            Logger.getLogger(FXMLLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void quit() {
        Platform.exit();

    }

    @FXML
    private void close() {
        Platform.exit();
    }

}
