/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiFormation;

import dao.FormationDAO;
import entities.Formation;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLAjouterFormationController implements Initializable {
    
 @FXML
 private TextField  Tnom ;
 @FXML
 private TextField Tlieu ;
 @FXML
 private DatePicker Tdebut ;
 @FXML
 private DatePicker  Tfin ;
 @FXML
 private Button btnValider;
 
 Alert alert = new Alert(Alert.AlertType.INFORMATION);
    /**
     * Initializes the controller class.
     */
 public static Formation f = null; 
public boolean verification(){
        boolean test=true;
        if(Tnom.getText().isEmpty()){
            test=false;return test;}
        else if(Tlieu.getText().isEmpty()){
            test=false;return test;}
        else if(Tdebut.getValue() == null){
            test=false;return test;}
        else if(Tfin.getValue() == null){
            test=false;return test;}
        return test;
    }
 public boolean verifDate(){
     if(Date.valueOf(Tdebut.getValue()).compareTo(Date.valueOf(Tfin.getValue()))>0){
         
         return false;
     }
     else{
     return true ;}
 }
 public void valider(){
        if(verification()&&verifDate()){
            FormationDAO fdao =new FormationDAO();
           int id=0;
       
         
        Formation formation=new Formation(id,Tnom.getText(), Tlieu.getText(),
       Date.valueOf(Tdebut.getValue()), Date.valueOf(Tfin.getValue()));
        
        fdao.ajoutFormation(formation);
        alert.setTitle("Ajout d'une formation");
        alert.setContentText("Formation ajoutée avec succés !");
        alert.showAndWait();
      }else{
        alert.setTitle("Echéc d'ajout  d'une formation");
        alert.setContentText("Echéc d'ajout  d'une formation");
        alert.showAndWait();}
 }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
