/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiUser;

import dao.UserDAO;
import entities.AllUsers;
import entities.User;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
 * @author Abdelaziz
 */
public class FXMLModifierMesInfosController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField telephone;
    @FXML
    private TextField mail;
    @FXML
    private TextArea adress;
    @FXML
    private DatePicker date;
    @FXML
    private Label msg;

    UserDAO udao = new UserDAO();
    User u = new User();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        msg.setText("");
        u = udao.search(AllUsers.connected.getId());

        // <editor-fold> Remplissage des champs
        if (u.getNom() != null) {
            nom.setText(u.getNom());
        }
        if (u.getPrenom() != null) {
            prenom.setText(u.getPrenom());
        }

        cin.setText(String.valueOf(u.getCin()));
        telephone.setText(String.valueOf(u.getTel()));

        if (u.getMail() != null) {
            mail.setText(u.getMail());
        }

        if (u.getAdresse() != null) {
            adress.setText(u.getAdresse());
        }

        if (u.getDateNaissance() != null) {

            Calendar cal = Calendar.getInstance();
            cal.setTime(u.getDateNaissance());
            LocalDate date2 = LocalDate.of(cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH) + 1,
                    cal.get(Calendar.DAY_OF_MONTH));
            date.setValue(date2);

        }
        // </editor-fold>

    }
    
    public void valider(){
        u = getUserInfo();
        System.out.println(u);
        updateInfo(u);
    }
    
    public User getUserInfo(){
        User rs = new User();
        rs.setNom(nom.getText());
        rs.setPrenom(prenom.getText());
        //to try and catch
        rs.setCin(Integer.parseInt(cin.getText()));
        rs.setTel(Integer.parseInt(telephone.getText()));
        rs.setMail(mail.getText());
        rs.setAdresse(adress.getText());
        rs.setDateNaissance(DateGoldenDev.localDateToString(date.getValue()));
        
        
        return rs;
    }
    
    public void updateInfo(User u){
        if(udao.update(u)){
            msg.setText("Modification avec succés");
        }else{
            msg.setText("Problème inconnu");
        }
    }

}
