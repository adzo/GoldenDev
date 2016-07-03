/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiResponsable;

import dao.ResponsableAdDAO;
import entities.AllUsers;
import entities.ResponsableAd;
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
    private TextField telephone;
    @FXML
    private TextArea adress;
    @FXML
    private DatePicker date;
    @FXML
    private Label msg;
    
    ResponsableAdDAO rdao = new ResponsableAdDAO();
    ResponsableAd r = new ResponsableAd();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        msg.setText("");
        r = rdao.search(AllUsers.connected.getId());

        // <editor-fold> Remplissage des champs
        if (r.getNom() != null) {
            nom.setText(r.getNom());
        }
        if (r.getPrenom() != null) {
            prenom.setText(r.getPrenom());
        }

        cin.setText(String.valueOf(r.getCin()));
        telephone.setText(String.valueOf(r.getTelephone()));


        if (r.getAdresse() != null) {
            adress.setText(r.getAdresse());
        }

        if (r.getDateNaissance() != null) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(r.getDateNaissance());
            LocalDate date2 = LocalDate.of(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH));
            date.setValue(date2);

        }
        // </editor-fold>

    }
         public void valider(){
        r = getUserInfo();
        System.out.println(r);
        updateInfo(r);
    }
    
    public ResponsableAd getUserInfo(){
        ResponsableAd rs = new ResponsableAd();
        rs.setNom(nom.getText());
        rs.setPrenom(prenom.getText());
        //to try and catch
        rs.setCin(Integer.parseInt(cin.getText()));
        rs.setTelephone(Integer.parseInt(telephone.getText()));
        rs.setAdresse(adress.getText());
        rs.setDateNaissance(DateGoldenDev.localDateToString(date.getValue()));
        
        
        return rs;
    }
    
    public void updateInfo(ResponsableAd r){
        if(rdao.update(r)){
            msg.setText("Modification avec succés");
        }else{
            msg.setText("Problème inconnu");
        }
    }
    }    
    

