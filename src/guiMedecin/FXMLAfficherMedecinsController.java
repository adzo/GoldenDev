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

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLAfficherMedecinsController implements Initializable {

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
    
}
