/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMedecin;

import dao.MedecinDAO;
import entities.AllUsers;
import entities.Medecin;
import guiLogin.FXMLLoginController;
import guiMain.Main;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLAjoutMedecinController implements Initializable {
    
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    
    @FXML
    private TextField adress;
    
    @FXML
    private DatePicker dateNaissance;
    @FXML
    private Button submit;
    @FXML
    private Label targetText;
    
    
    @FXML
    public void ajouterMedecin(ActionEvent event) throws IOException{
        targetText.setText("");
        String nomT;
        String prenomT;
        String adressT;
        int idT;
        int cinT;
        Date dateT;
        LocalDate localDate;
        localDate = dateNaissance.getValue();
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.MONTH, localDate.getMonthValue()-1);
        cal.set(Calendar.DATE, localDate.getDayOfMonth());
        cal.set(Calendar.YEAR, localDate.getYear());
        
        dateT = cal.getTime();
        
        idT = AllUsers.modifiedUser.getId();
        nomT = nom.getText();
        prenomT = prenom.getText();
        adressT = adress.getText();
        cinT =Integer.parseInt(cin.getText());
        
        Medecin m = new Medecin(idT, nomT, prenomT, dateT, cinT, adressT);
        
        MedecinDAO p = new MedecinDAO();
        p.add(m);
        targetText.setText("Medecin ajouté");
        
    }
    
    
    //Ouvrir l'interface d'ajout du medecin
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
