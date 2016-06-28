/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiJoueur;

import dao.ClubDAO;
import dao.JoueurDAO;
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
import javafx.scene.input.MouseEvent;
import utils.DateGoldenDev;

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
    private TableColumn<Joueur, Integer> id;
    @FXML
    private TableColumn<Joueur, String> nom;
    @FXML
    private TableColumn<Joueur, String> prenom;

    //AllUsersDAO p = new AllUsersDAO();
    JoueurDAO j = new JoueurDAO();
    ObservableList<Joueur> data;
    Joueur u = new Joueur();

    public void updateElements() {
        u = tableau.getSelectionModel().getSelectedItem();
        System.out.println(u.toString());
        //Setting the fields
        if(u.getDateNaissance() != null){
            datenaiss.setText(DateGoldenDev.dateToStringLong(u.getDateNaissance()));
        }else{
            datenaiss.setText("Not Defined");
        }
        
        if(u.getAdresseJoueur() != null){
            adresse.setText(u.getAdresseJoueur());
        }else{
            adresse.setText("Not Defined");
        }
        
        if(u.getCin() != 0){
            cin.setText(String.valueOf(u.getCin()));
        }else{
            cin.setText("Not Defined");
        }
        
        if(u.getSexeJoueur() != null){
            sexe.setText(u.getSexeJoueur());
        }else{
            sexe.setText("Not Defined");
        }
        
        if(u.getNiveauJoueur() != null){
            niveau.setText(u.getNiveauJoueur());
        }else{
            niveau.setText("Not Defined");
        }
        
        if(u.getPoidJoeur() != 0){
            poids.setText(String.valueOf(u.getPoidJoeur())+" Kg");
        }else{
            poids.setText("Not Defined");
        }
        
        if(u.getTelephoneJoueur() != 0){
            telephone.setText(String.valueOf(u.getTelephoneJoueur()));
        }else{
            telephone.setText("Not Defined");
        }
        
        if (u.getIdClub() != 0){
            ClubDAO cdao = new ClubDAO();
            
            club.setText(cdao.getClub(u.getIdClub()).getNomClub());
        }else{
            club.setText("N'appartient à aucun club");
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Joueur> liste = new ArrayList<>();
        id.setCellValueFactory(new PropertyValueFactory<>("idJoueur"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        liste = j.afficherTout();
        data = FXCollections.observableArrayList(liste);
        tableau.setItems(data);
    }

    public void selectedElement(MouseEvent event) {
        if (event.getClickCount() == 2) {
            System.out.println("Double Click");
        }
        updateElements();

    }

}
