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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
}
