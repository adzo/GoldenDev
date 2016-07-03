/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMedecin;

import dao.MedecinDAO;
import entities.AllUsers;
import entities.Medecin;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.DateGoldenDev;

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLModifierMesInfosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
     private TextArea adress;
    @FXML
    private DatePicker date;
    @FXML
    private Label msg;
      MedecinDAO mdao = new MedecinDAO();
    Medecin m = new Medecin();
private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         msg.setText("");
         m = mdao.getMedecin(AllUsers.connected.getId());
          // <editor-fold> Remplissage des champs
        if (m.getNom() != null) {
            nom.setText(m.getNom());
        }
        if (m.getPrenom() != null) {
            prenom.setText(m.getPrenom());
        }

        cin.setText(String.valueOf(m.getCin()));
      

        if (m.getAdresse() != null) {
            adress.setText(m.getAdresse());
        }

        if (m.getDateNaissance() != null) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(m.getDateNaissance());
            LocalDate date2 = LocalDate.of(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH));
            date.setValue(date2);

        }
        // </editor-fold>
    }  
     public void valider(){
        m = getMedecinInfo();
        System.out.println(m);
        updateInfo(m);
    }
    
    public Medecin getMedecinInfo(){
        Medecin rs = new Medecin();
        rs.setNom(nom.getText());
        rs.setPrenom(prenom.getText());
        //to try and catch
        rs.setCin(Integer.parseInt(cin.getText()));
        rs.setAdresse(adress.getText());
        rs.setDateNaissance(DateGoldenDev.localDateToString(date.getValue()));
        
        
        return rs;
    }
    
    public void updateInfo(Medecin m){
        if(mdao.update(m)){
            msg.setText("Modification avec succés");
        }else{
            msg.setText("Problème inconnu");
        }
    }

    
}
