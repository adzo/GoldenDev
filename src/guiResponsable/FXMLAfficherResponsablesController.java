/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiResponsable;

import dao.AllUsersDAO;
import dao.ResponsableAdDAO;
import entities.Medecin;
import entities.ResponsableAd;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.DateGoldenDev;

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLAfficherResponsablesController implements Initializable {
     String[] months = {"Janvier","Fevrier","Mars","Avril","Mai","Juin",
        "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
    String[] days = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
    
    final String NEW_FORMAT = "dd/MM/yyyy";
    @FXML
    private Label dateN;
    @FXML
    private Label cin;
    @FXML
    private Label adr;
    @FXML
    private Label tel;
    @FXML
    private TableView<ResponsableAd> tableau;
    @FXML
    private TableColumn<ResponsableAd, Integer> idR;
    @FXML
    private TableColumn<ResponsableAd,String> nomR;
    @FXML
    private TableColumn<ResponsableAd,String> prenomR;
     
    AllUsersDAO p = new AllUsersDAO();
    ResponsableAdDAO rdao = new ResponsableAdDAO();
    ObservableList<ResponsableAd> data;
    ResponsableAd u = new ResponsableAd();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            idR.setCellValueFactory(new PropertyValueFactory<>("idResponsable"));
        nomR.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomR.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        ResponsableAd.listes = rdao.afficherTout();
        data = FXCollections.observableArrayList(ResponsableAd.listes);
        tableau.setItems(data);
    }    
    
    
    public void selection(){
        u = tableau.getSelectionModel().getSelectedItem();
        updateContent(u);
    }
    
    public void updateContent(ResponsableAd r){
        // Formatting the Date field
        
        //Testing for the other fields and setting them ;)
        
        //affichage de la date de naissance
        if (u.getDateNaissance()!=null){
        dateN.setText(DateGoldenDev.sqlToDateString(u.getDateNaissance()));
        }else{
            dateN.setText("Not defined");
        }
        //Affichage du CIN
        if(u.getCin() !=0){
        cin.setText(String.valueOf(u.getCin()));
        }else{
            cin.setText("Not defined");
        }
        //Affichage de l'adress
        if(u.getAdresse()!=null){
        adr.setText(u.getAdresse());
        }else{
            adr.setText("Not defined");
        }
        //Affichage du numéro de téléphone
        if(u.getTelephone() != 0){
        tel.setText(String.valueOf(u.getTelephone()));
        }else{
            tel.setText("Not defined");
        }
    }
}
