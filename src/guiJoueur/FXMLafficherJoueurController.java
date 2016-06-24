/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiJoueur;

import dao.AllUsersDAO;
import dao.JoueurDAO;
import entities.Joueur;
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

/**
 * FXML Controller class
 *
 * @author Sami
 */
public class FXMLafficherJoueurController implements Initializable {

   @FXML
   private Label datenaiss;
   @FXML
   private Label adresse;
   @FXML 
   private Label cin;
   @FXML
   private Label sexe;
   @FXML
   private Label niveau;
   @FXML 
   private Label poids;
   @FXML
   private Label telephone;
   @FXML
   private Label club;
   @FXML
   private TableView<Joueur> tableau;
   @FXML
   private TableColumn<Joueur,Integer> id;
   @FXML
   private TableColumn<Joueur,String> nom;
   @FXML
   private TableColumn<Joueur,String> prenom;
   
    AllUsersDAO p = new AllUsersDAO();
    JoueurDAO j=new JoueurDAO();
    ObservableList<Joueur> data;
    Joueur u = new Joueur();
    
    public void selectedElement(){
        u  = tableau.getSelectionModel().getSelectedItem();
        System.out.println(u.toString());
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("idJoueur"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Joueur.listes = j.afficherTout();
        data = FXCollections.observableArrayList(Joueur.listes);
        tableau.setItems(data);
    }    
    
}
