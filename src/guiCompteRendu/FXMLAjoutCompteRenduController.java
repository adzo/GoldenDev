/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCompteRendu;

import entities.Joueur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
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
    private TextField idJoueur ;
    @FXML
    private TextArea observation ;
    @FXML
    private RadioButton positif;
    @FXML
    private RadioButton negatif;
    @FXML 
    private Button valider;
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
    
    Joueur j = new Joueur();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void openRechercheJoueur(){
        Stage search = new Stage();
        search.setOnCloseRequest(new EventHandler<WindowEvent>() {
             public void handle(WindowEvent we) {
                System.err.println("passage de l'id joueur");
                if (Joueur.modifiedJoueur != null){
                String search ="";
                search = String.valueOf(Joueur.modifiedJoueur.getIdJoueur() + " - "+Joueur.modifiedJoueur.getNom()+" "+Joueur.modifiedJoueur.getPrenom());
                idJoueur.setText(search);
                //set des info a partir de Joueur.modified
                if (Joueur.modifiedJoueur.getDateNaissance()!=null){
                 datenaiss.setText(DateGoldenDev.sqlToDateString(Joueur.modifiedJoueur.getDateNaissance()));
                }else{
                     datenaiss.setText("Not defined");
                     }
                //Affichage du CIN
                if(Joueur.modifiedJoueur.getTelephoneJoueur() !=0){
                telephone.setText(String.valueOf(Joueur.modifiedJoueur.getTelephoneJoueur()));
                }else{
                    cin.setText("Not defined");
                }
                //Affichage de l'adress
                if(Joueur.modifiedJoueur.getAdresseJoueur() !=null){
                adresse.setText(Joueur.modifiedJoueur.getAdresseJoueur());
                }else{
                    adresse.setText("Not defined");
                }
                
                //affichage du poid
                if(Joueur.modifiedJoueur.getPoidJoeur() != 0){
                    poids.setText(String.valueOf(Joueur.modifiedJoueur.getPoidJoeur()));
                }else{
                    poids.setText("Not defined");
                }
                //affichage du Niveau
                if(Joueur.modifiedJoueur.getNiveauJoueur() != null){
                    niveau.setText(Joueur.modifiedJoueur.getNiveauJoueur());
                }else{
                    niveau.setText("Not defined");
                }
                //affichage du sexe
                if(Joueur.modifiedJoueur.getSexeJoueur()!= null){
                    sexe.setText(Joueur.modifiedJoueur.getSexeJoueur());
                }else{
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
    
    
    
}
