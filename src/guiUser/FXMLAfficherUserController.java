/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiUser;

import dao.AllUsersDAO;
import dao.UserDAO;
import entities.User;
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
 * @author AD ZO
 */
public class FXMLAfficherUserController implements Initializable {
    String[] months = {"Janvier","Fevrier","Mars","Avril","Mai","Juin",
        "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
    String[] days = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
    
    final String NEW_FORMAT = "dd/MM/yyyy";
    
    
    @FXML
    private Label birth;
    @FXML
    private Label cin;
    @FXML
    private Label adresse;
    @FXML
    private Label mail;
    @FXML
    private Label tel;
    @FXML
    private TableView<User> tableau;
    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    
    AllUsersDAO p = new AllUsersDAO();
    UserDAO udao = new UserDAO();
    ObservableList<User> data;
    User u = new User();
    
    
    public void modifierContent(User u){
        Calendar cal = Calendar.getInstance();
        if(u.getDateNaissance() != null){
        cal.setTime(u.getDateNaissance());
        }
//        final DateFormat dateFormat;
//        dateFormat = DateFormat.getDateTimeInstance(); 
//        
        String jour, month, year, dayOfTheWeek;
        jour= String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        month= months[cal.get(Calendar.MONTH)];
        year= String.valueOf(cal.get(Calendar.YEAR));
        dayOfTheWeek = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        
        
        
        
        //Setting the fields : 
        if(u.getCin() !=0){
        cin.setText(String.valueOf(u.getCin()));
        }else{
            cin.setText("Not defined");
        }
        //birth.setText(dateFormat.format(cal.getTime()) );
        if (u.getDateNaissance()!=null){
        birth.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);
        }else{
            birth.setText("Not defined");
        }
        if(u.getAdresse()!=null){
        adresse.setText(u.getAdresse());
        }else{
            adresse.setText("Not defined");
        }
        if(u.getMail()!=null){
        mail.setText(u.getMail());
        }else{
            mail.setText("Not defined");
        }
        if(u.getTel() != 0){
        tel.setText(String.valueOf(u.getTel()));
        }else{
            tel.setText("Not defined");
        }
    }
    public void selectedElement(){
        u  = tableau.getSelectionModel().getSelectedItem();
        //System.out.println(u);
        modifierContent(u);
        System.out.println(u.toString());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id.setCellValueFactory(new PropertyValueFactory<>("idUser"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        User.listes = udao.afficherTout();
        data = FXCollections.observableArrayList(User.listes);
        tableau.setItems(data);  
    }    
    
}
