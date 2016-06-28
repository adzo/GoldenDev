/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCompteRendu;

import dao.CompteRenduDAO;
import entities.AllUsers;
import entities.CompteRendu;
import entities.Joueur;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import utils.DateGoldenDev;

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLAjoutCompteRenduController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField idJoueur;
    @FXML
    private TextArea observation;
    @FXML
    private RadioButton positif;
    @FXML
    private RadioButton negatif;
    @FXML
    private Button valider;
    @FXML
    private Label msg;
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
            private DatePicker date;
    boolean state = false;
    Joueur j = new Joueur();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        negatif.arm();
    }

    @FXML
    public void openRechercheJoueur() {
        Stage search = new Stage();
        search.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {

                System.err.println("passage de l'id joueur");
                if (Joueur.modifiedJoueur != null) {
                    String search = "";
                    search = String.valueOf(Joueur.modifiedJoueur.getIdJoueur() + " - " + Joueur.modifiedJoueur.getNom() + " " + Joueur.modifiedJoueur.getPrenom());
                    idJoueur.setText(search);
                    //set des info a partir de Joueur.modified
                    if (Joueur.modifiedJoueur.getDateNaissance() != null) {
                        datenaiss.setText(DateGoldenDev.dateToStringLong(Joueur.modifiedJoueur.getDateNaissance()));
                    } else {
                        datenaiss.setText("Not defined");
                    }
                    //Affichage du CIN
                    if (Joueur.modifiedJoueur.getTelephoneJoueur() != 0) {
                        telephone.setText(String.valueOf(Joueur.modifiedJoueur.getTelephoneJoueur()));
                    } else {
                        telephone.setText("Not defined");
                    }
                    //Affichage de l'adress
                    if (Joueur.modifiedJoueur.getAdresseJoueur() != null) {
                        adresse.setText(Joueur.modifiedJoueur.getAdresseJoueur());
                    } else {
                        adresse.setText("Not defined");
                    }

                    //affichage du poid
                    if (Joueur.modifiedJoueur.getPoidJoeur() != 0) {
                        poids.setText(String.valueOf(Joueur.modifiedJoueur.getPoidJoeur()));
                    } else {
                        poids.setText("Not defined");
                    }
                    //affichage du Niveau
                    if (Joueur.modifiedJoueur.getNiveauJoueur() != null) {
                        niveau.setText(Joueur.modifiedJoueur.getNiveauJoueur());
                    } else {
                        niveau.setText("Not defined");
                    }
                    //affichage du sexe
                    if (Joueur.modifiedJoueur.getSexeJoueur() != null) {
                        sexe.setText(Joueur.modifiedJoueur.getSexeJoueur());
                    } else {
                        sexe.setText("Not defined");
                    }
                }
            }
        });
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/guiJoueur/FXMLRechercheJoueur.fxml"));
            Scene scene = new Scene(root);
            search.setTitle("Rechercher votre joueur");
            search.setScene(scene);
            search.initModality(Modality.APPLICATION_MODAL);
            search.setResizable(false);
            search.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLAjoutCompteRenduController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Erreur chargement fenetre recherche");
        }

    }

    @FXML
    public void valider() {
        if (!idJoueur.getText().equals("") && date.getValue() != null ) {
            String obs;
            int idM = AllUsers.connected.getId();
            int idJ = Joueur.modifiedJoueur.getIdJoueur();
            obs = observation.getText();
            Date dateDuTest;
            
            dateDuTest = DateGoldenDev.localDateToString(date.getValue());
            CompteRendu cr = new CompteRendu(idM, idJ, state, obs,dateDuTest);
            CompteRenduDAO crdao = new CompteRenduDAO();
            if (crdao.ajout(cr)) {
                msg.setText("Ajout effectué avec succés");
                Timeline timeline = new Timeline(new KeyFrame(
                        Duration.millis(2000),
                        ae -> clean()));
                timeline.play();
            }
        } else {
            msg.setText("Champs vides");
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(2000),
                    ae -> msg.setText("")));
            timeline.play();

        }

    }

    public void testPositif() {
        state = true;
    }

    public void clean() {
        msg.setText("");
        observation.setText("");
        idJoueur.setText("");
        Joueur.modifiedJoueur = null;
        date.setValue(null);
        date.getEditor().clear();
    }

    public void testNegatif() {
        state = false;
    }

//     if (positif.isArmed()){
//           state = true; 
//        }else if (negatif.isArmed()){
//            state = false;
//        }else {
//        }
}
