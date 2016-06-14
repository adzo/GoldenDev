/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import dao.AllUsersDAO;
import entities.AllUsers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLModifierPasswordController implements Initializable {

    @FXML
    private PasswordField oldPassword;
    @FXML
    private PasswordField newPassword1;
    @FXML
    private PasswordField newPassword2;
    @FXML
    private Label textTarget;
    @FXML
    private Button submit;
    
    public void updatePassword(ActionEvent event){
        System.out.println(AllUsers.modifiedUser.toString());
        
        String oldPass;
        String newPass1;
        String newPass2;
        
        oldPass = oldPassword.getText();
        newPass1 = newPassword1.getText();
        newPass2 = newPassword2.getText();
        System.out.println(AllUsers.modifiedUser.getMdp());
        if (AllUsers.modifiedUser.getMdp().equals(oldPass)){
            //Traitement de mise a jour
            if(newPass1.equals(newPass2)){
                //Mise a jour accordée
                AllUsers.modifiedUser.setMdp(newPass1);
                AllUsersDAO p = new AllUsersDAO();
                p.modifierPassword(AllUsers.modifiedUser);
                Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
                stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
                AllUsers.modifiedUser = null;
                textTarget.setText("Password updated with success");
            }else {
                textTarget.setText("Password doesn't match");
            }
        }else{
            textTarget.setText("Ancien mot de pass éronné");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
