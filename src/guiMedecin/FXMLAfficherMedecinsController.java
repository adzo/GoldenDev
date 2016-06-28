/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMedecin;

import dao.AllUsersDAO;
import dao.MedecinDAO;
import entities.Medecin;
import entities.User;
import java.net.URL;
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
public class FXMLAfficherMedecinsController implements Initializable {
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
    private TableView<Medecin> tableau;
    @FXML
    private TableColumn<Medecin, Integer> idM;
    @FXML
    private TableColumn<Medecin,String> nomM;
    @FXML
    private TableColumn<Medecin,String> prenomM;
    
    
    AllUsersDAO p = new AllUsersDAO();
    MedecinDAO mdao = new MedecinDAO();
    ObservableList<Medecin> data;
    Medecin u = new Medecin();
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idM.setCellValueFactory(new PropertyValueFactory<>("idMedecin"));
        nomM.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomM.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Medecin.listes = mdao.afficherTout();
        data = FXCollections.observableArrayList(Medecin.listes);
        tableau.setItems(data);
    }
      public void selection(){
        u = tableau.getSelectionModel().getSelectedItem();
        updateContent(u);
          System.out.println("click");
    }
    
    public void updateContent(Medecin m){
        // Formatting the Date field
        
        //Testing for the other fields and setting them ;)
        
        //affichage de la date de naissance
        if (u.getDateNaissance()!=null){
        dateN.setText(DateGoldenDev.dateToStringLong(u.getDateNaissance()));
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
       
    }
    
}
