/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

import dao.ArbitreDAO;
import entities.AllUsers;
import entities.Arbitre;
import guiAllUsers.FXMLAfficherAllUsersController;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jdk.internal.dynalink.support.Guards;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLModifierProfileController implements Initializable {

    
    
    @FXML
    private Label msg;
    @FXML
    private Text msg2;
    @FXML
    private TextField cinT;
    @FXML
    private TextField nomT;
    @FXML
    private TextField prenomT; 
    @FXML
    private TextArea adressT;
    @FXML
    private DatePicker dateNaisT;
    @FXML
    private Button submit;
    @FXML 
    private Button submit1;
    

   
    public boolean verification(){
        boolean test=true;
        if(nomT.getText().isEmpty()){
            test=false;return test;}
        else if(prenomT.getText().isEmpty()){
            test=false;return test;}
        else if(dateNaisT.getValue() == null){
            test=false;return test;}
         else if(adressT.getText().isEmpty()){
            test=false;return test;}
           else if(cinT.getText().isEmpty()){
            test=false;return test;}
        return test;
    }
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    public void changerPasswd() throws IOException {
       
    }

     @FXML
    public void modifierProfile(ActionEvent event) throws IOException{
    
        String nom;
        String prenom;
        String adress;
        int id;
        int cin;
        String categ;
        Date date;
        LocalDate localDate;
         if(verification()){
        localDate = dateNaisT.getValue();
        
        Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.MONTH, localDate.getMonthValue()-1);
        cal.set(Calendar.DATE, localDate.getDayOfMonth());
        cal.set(Calendar.YEAR, localDate.getYear());
        
        date = cal.getTime();
      
       id = AllUsers.modifiedUser.getId();
       System.out.println(id+"");
        nom = nomT.getText();
        prenom = prenomT.getText();
        adress = adressT.getText();
        cin =Integer.parseInt(cinT.getText());
        
        
        Arbitre m = new Arbitre(id, nom, prenom, date, cin, adress,"Amateur");
        System.out.println(m.toString());
        ArbitreDAO p = new ArbitreDAO();
        p.update(m);
         alert.setTitle("Modification de Profile");
        alert.setContentText("Profile modifié avec succés !");
        alert.showAndWait();
        nomT.clear(); prenomT.clear(); adressT.clear(); cinT.clear(); 
         }
        else {alert.setTitle("Echéc ");
        alert.setContentText("Il y'a un champs vide ");
        alert.showAndWait();}
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
