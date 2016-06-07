/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

import dao.AllUsersDAO;
import entities.AllUsers;
import guiMedecin.AjoutMedecin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLAjoutAllUsersController implements Initializable {

    @FXML
    private Text textTarget;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private ComboBox typeUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     *
     */
    @FXML
    public void vider() {
        textTarget.setText("");
    }

    //Qualité du mot de passe
    public void qualitePass() {
        String pass1;
        pass1 = password1.getText();
        if (pass1.length() < 5) {
            textTarget.setText("Mot de passe faible!!");
        } else {
            textTarget.setText("");
        }
    }

    //Verification du mot de pass
    public void verifierPass() {
        String pass1;
        pass1 = password1.getText();
        String pass2;
        pass2 = password2.getText();
        if (!pass1.equals(pass2)) {
            textTarget.setText("Password doesn't match");
        } else {
            textTarget.setText("");
        }

    }

    public void ajouterAllUsers(ActionEvent event) throws IOException {
        textTarget.setText("");
        if (!login.getText().equals("") && !password1.getText().equals("") && !password2.getText().equals("")) {
            String log;
            String pass = "";
            String type;
            log = login.getText();
            type = (String) typeUser.getValue();
            if (password1.getText().equals(password2.getText())) {
                pass = password1.getText();
                if (type != null) {
                    AllUsers s = new AllUsers(log, pass, type);
                    AllUsersDAO p = new AllUsersDAO();
                    if (!p.existe(s)) {
                        p.ajouter(s);
                        AllUsers.modifiedUser = p.recherche(s);
                        System.out.println(AllUsers.modifiedUser);

                        textTarget.setText("Utilisateur ajouté");
                        Stage stage =  (Stage) ((Node) (event.getSource())).getScene().getWindow();
                        stage.fireEvent(new WindowEvent(stage,WindowEvent.WINDOW_CLOSE_REQUEST));
                        ((Node) (event.getSource())).getScene().getWindow().hide();
                        if (type.equals("Medecin"))  {
                            this.ouvrirAjoutMedecin(event);
                        }
                    } else {
                        textTarget.setText("Login Déja utilisé réessayer de nouveau!!");

                    }

                } else {
                    textTarget.setText("Précisez votre type d'utilisateur");
                }
            } else {
                textTarget.setText("Password doesn't match");
            }
        }
    

    
        else { textTarget.setText("Champs manquants");
    }
        
     
}


public void ouvrirAjoutMedecin(ActionEvent event) throws IOException{
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage ajoutMedecinDashboard = new Stage();
        ajoutMedecinDashboard.setResizable(true);
        AjoutMedecin mainWindow = AjoutMedecin.getInstance();
        mainWindow.start(ajoutMedecinDashboard);
        System.out.println(AllUsers.connected);

    }

}