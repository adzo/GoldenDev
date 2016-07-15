/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

import dao.ArbitreDAO;
import entities.AllUsers;
import entities.Arbitre;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLAjoutArbitreController implements Initializable {
    @FXML
    private Text targetText;
    @FXML
    private TextField cinT;
    @FXML
    private TextField nomT;
    @FXML
    private TextField prenomT;
    
    @FXML
    private TextField adressT;
     
    @FXML
    private TextField categT;
    
    @FXML
    private DatePicker dateNaisT;
    @FXML
    private Button submit;


  @FXML
   public void ajoutArbitre(ActionEvent event) throws IOException {
       targetText.setText("");
        int idArbitre;
   String nom;
   String prenom;
   Date dateNaissance;
   int cin;
   String adresse;
   String categorie;
      LocalDate localDate ;
      localDate = dateNaisT.getValue();
   Calendar cal = Calendar.getInstance();
        
        cal.set(Calendar.MONTH, localDate.getMonthValue()-1);
        cal.set(Calendar.DATE, localDate.getDayOfMonth());
        cal.set(Calendar.YEAR, localDate.getYear());
        
        dateNaissance = cal.getTime();
        idArbitre=AllUsers.modifiedUser.getId();
        nom=nomT.getText();
        prenom=prenomT.getText();
        cin=Integer.parseInt(cinT.getText());
        adresse = adressT.getText();
        categorie = categT.getText();
        Arbitre a = new Arbitre(idArbitre, nom, prenom, dateNaissance, cin, adresse, categorie);
       System.out.println( a.toString());
        ArbitreDAO AJ;
     AJ = new ArbitreDAO();
     boolean add = AJ.add(a);
        targetText.setText("Arbitre Ajouté");
   }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
