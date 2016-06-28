/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiClub;

import dao.ClubDAO;
import entities.Club;
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
import javafx.scene.layout.Pane;
import utils.DateGoldenDev;

/**
 * FXML Controller class
 *
 * @author Abdelaziz
 */
public class FXMLListeClubController implements Initializable {

    @FXML
    private Label title;
    @FXML
    private Label president;
    @FXML
    private Label dateFondation;
    @FXML
    private Label adresse;
    @FXML
    private TableView<Club> tableau;
    @FXML
    private TableColumn <Club,Integer> idClub;
    @FXML
    private TableColumn <Club,String> nomClub;
    @FXML
    private TableColumn <Club,Integer> telephoneClub;
    @FXML
    private Pane listeJoueurs;        
     
    
    ClubDAO cdao = new ClubDAO();
    ObservableList<Club> data;
    Club c = new Club();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        title.setVisible(false);
        ArrayList<Club> liste = new ArrayList<>();
        idClub.setCellValueFactory(new PropertyValueFactory<>("idClub"));
        nomClub.setCellValueFactory(new PropertyValueFactory<>("nomClub"));
        telephoneClub.setCellValueFactory(new PropertyValueFactory<>("telephoneClub"));
        liste = cdao.getAll();
        data = FXCollections.observableArrayList(liste);
        tableau.setItems(data);
    }    
    
    @FXML
    public void select(MouseEvent event){
        if(event.getClickCount() == 2){
            
        }else{
            updateInfo();
            title.setVisible(true);
            //Load Liste joueur du club
        }
    }
    
    public void updateInfo(){
        c = tableau.getSelectionModel().getSelectedItem();
        if(c.getPresidentClub() != null){
            president.setText(c.getPresidentClub());
        }else{
            president.setText("Not Defined");
        }
        if(c.getDateFondation() != null){
            dateFondation.setText(DateGoldenDev.sqlToDateString2(c.getDateFondation()));
        }else{
            dateFondation.setText("Not Defined");
        }
        if(c.getAdresseClub() != null){
            adresse.setText(c.getAdresseClub());
        }else{
            adresse.setText("Not Defined");
        }
    }
}
