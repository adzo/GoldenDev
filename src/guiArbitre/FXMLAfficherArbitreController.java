/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

import dao.AllUsersDAO;
import dao.ArbitreDAO;
import entities.Arbitre;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLAfficherArbitreController implements Initializable {

    /**
     * Initializes the controller class.
     */
     String[] months = {"Janvier","Fevrier","Mars","Avril","Mai","Juin",
        "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
    String[] days = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
   @FXML 
   private ComboBox catgN ;
    @FXML
    private Button btnModif ;
     @FXML
    private Button btnValid ;
    @FXML
    private Label dateN;
    @FXML
    private Label cin;
    @FXML
    private Label adr;
    @FXML
    private Label categorie;
    @FXML
    private TableView<Arbitre> tableau;
    @FXML
    private TableColumn<Arbitre, Integer> idAr;
    @FXML
    private TableColumn<Arbitre,String> nomAr;
    @FXML
    private TableColumn<Arbitre,String> prenomAr;
    ArbitreDAO adao = new ArbitreDAO();
    ObservableList<Arbitre> data;
    Arbitre a = new Arbitre();
    public void modifierContent(Arbitre a){
        Calendar cal = Calendar.getInstance();
       if(a.getDateNaissance()!= null){
        cal.setTime(a.getDateNaissance());
        String jour, month, year, dayOfTheWeek;

        jour= String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        month= months[cal.get(Calendar.MONTH)];
        year= String.valueOf(cal.get(Calendar.YEAR));
        dayOfTheWeek = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        dateN.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);
        }else{
           dateN.setText("Not defined");
        }
       if(a.getAdresse()!=null){
           adr.setText(a.getAdresse());
           
       }else adr.setText("Not defined");
       if(a.getCin()!=0){
           cin.setText(String.valueOf(a.getCin()));
       }else {cin.setText("Not defined");}
       if(a.getCategorie()!=null){
           categorie.setText(a.getCategorie());
       }else {categorie.setText("Not defined");}
    }
   public void selectedElement(){
        a = tableau.getSelectionModel().getSelectedItem();
        modifierContent(a);
        System.out.println(a.toString());
    }
    public void loadModifierArbitre()throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/guiArbitre/FXMLModifierProfile.fxml"));
        root.setVisible(true);
    }
    public void modifGrad(){
    btnModif.setVisible(false);
    btnValid.setVisible(true);
    categorie.setVisible(false);
    catgN.setVisible(true);
    }
    public void valider(){
        a.setCategorie((String) catgN.getValue());
    adao.modifGRAD(a);
        btnValid.setVisible(false);

      btnModif.setVisible(true);
          catgN.setVisible(false);

    categorie.setVisible(true);
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          idAr.setCellValueFactory(new PropertyValueFactory<>("idArbitre"));
        nomAr.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomAr.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Arbitre.listes = adao.afficherTout();
        data = FXCollections.observableArrayList(Arbitre.listes);
        tableau.setItems(data);
    }    
    
}
