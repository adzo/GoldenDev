/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiJoueur;

import dao.JoueurDAO;
import entities.Club;
import entities.Joueur;
import java.net.URL;
import java.util.ArrayList;
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
 * @author Abdelaziz
 */
public class FXMLListeJoueursSuivantClubController implements Initializable {

   @FXML
   private TableView<Joueur> tableau;
   @FXML
   private TableColumn<Joueur,Integer> id;
   @FXML
   private TableColumn<Joueur,String> nom;
   @FXML
   private TableColumn<Joueur,String> prenom;
   @FXML
           private Label msg;
   JoueurDAO j=new JoueurDAO();
    ObservableList<Joueur> data;
    Joueur u = new Joueur();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        msg.setVisible(false);
        ArrayList<Joueur> liste = new ArrayList<>();
        id.setCellValueFactory(new PropertyValueFactory<>("idJoueur"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        liste = j.afficherTout(Club.id);
        if (liste != null){
        data = FXCollections.observableArrayList(liste);
        tableau.setItems(data);
        }else{
            tableau.setVisible(false);
            msg.setVisible(true);
        }
        
    }    
    
}
