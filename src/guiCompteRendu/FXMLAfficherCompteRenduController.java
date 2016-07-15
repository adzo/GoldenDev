/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCompteRendu;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.CompteRenduDAO;
import dao.JoueurDAO;
import dao.MedecinDAO;
import entities.AllUsers;
import entities.CompteRendu;
import entities.Joueur;
import entities.Medecin;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLAfficherCompteRenduController implements Initializable {

    @FXML
    private ComboBox chngEtat ;
    @FXML
    private Label observation;
    @FXML
    private TableView<CompteRendu> tableau;
    @FXML
    private TableColumn<CompteRendu, Integer> idCr;
    @FXML
    private TableColumn<CompteRendu, Integer> idM;
    @FXML
    private TableColumn<CompteRendu, Integer> idJ;
    @FXML
    private TableColumn<CompteRendu, String> result;
    @FXML
    private Rectangle medShape;
    @FXML
    private Rectangle medShape2;
    @FXML
    private Pane medPane;
    @FXML
    private Label medText;
    @FXML
    private Label nomMed;
    @FXML
    private Label prenomMed;
    @FXML
    private Label telMed;
    @FXML
    private Label InfoNomMed;
    @FXML
    private Label InfoPrenomMed;
    @FXML
    private Label InfoTelMed;
    @FXML
    private Label nomJoueur;
    @FXML
    private Label prenomJoueur;
    @FXML
    private Label telJoueur;
    @FXML
            private Label date;

    CompteRenduDAO crdao = new CompteRenduDAO();
    CompteRendu cr = new CompteRendu();
    Joueur j = new Joueur();
    Medecin m = new Medecin();
    JoueurDAO jdao = new JoueurDAO();
    MedecinDAO mdao = new MedecinDAO();
    ObservableList<CompteRendu> data;

    String[] months = {"Janvier","Fevrier","Mars","Avril","Mai","Juin",
        "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
    String[] days = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
     @FXML
    private TextField  nFile ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<CompteRendu> liste = new ArrayList<>();
        idCr.setCellValueFactory(new PropertyValueFactory<>("idCompterendu"));
        idM.setCellValueFactory(new PropertyValueFactory<>("idMedecin"));
        idJ.setCellValueFactory(new PropertyValueFactory<>("idJoueur"));
        result.setCellValueFactory(new PropertyValueFactory<>("result"));
        liste = crdao.getCompteRendu();
        data = FXCollections.observableArrayList(liste);
        tableau.setItems(data);

        if (AllUsers.connected.getType().equals("medecin")) {
            medPane.setVisible(false);
        } else {
            medPane.setVisible(true);
        }

    }
    
    public void filePdf() throws Exception{
     
       String obs , nmJ , nmMed  ; 
       obs = observation.getText();
       nmJ = nomJoueur.getText();
       nmMed = nomMed.getText();
    Document document=new Document();
    //création & nom du fichier pdf
PdfWriter.getInstance(document,new FileOutputStream(nFile.getText()+".pdf")); 
document.open();
 
    document.add(new Paragraph("Compte Rendu :"+obs+" \n de Joueur : "+nmJ+"fait par le Medecin"+nmMed));
       

document.close(); }

    public void changeEtatJoueur(){
       
       int id = cr.getIdJoueur();
       JoueurDAO jdao = new JoueurDAO();
       jdao.changetat(id,(String) chngEtat.getValue() );
       
    }

    public void selection() {
        cr = tableau.getSelectionModel().getSelectedItem();
        updateObservation(cr);
        //Get Joueur
        j = jdao.getJoueur(cr.getIdJoueur());
        updateJoueurInfo(j);
        //Get Medecin
        m = mdao.getMedecin(cr.getIdMedecin());
        if (m != null) {
            updateMedecinInfo(m);
        } else {
            System.err.println("Objet medecin null");
        }
    }

    private void updateMedecinInfo(Medecin m) {
        if (m.getNom() == null) {
            nomMed.setText("Not Defined");
        } else {
            nomMed.setText(m.getNom());
        }
        if (m.getPrenom() == null) {
            prenomMed.setText("Not Defined");
        } else {
            prenomMed.setText(m.getPrenom());
        }
        if (m.getTelephone() == 0) {
            telMed.setText("Not Defined");
        } else {
            telMed.setText(String.valueOf(m.getTelephone()));
        }
    }

    private void updateJoueurInfo(Joueur j) {
        if (j.getNom() == null) {
            nomJoueur.setText("Not Defined");
        } else {
            nomJoueur.setText(j.getNom());
        }
        if (j.getPrenom() == null) {
            prenomJoueur.setText("Not Defined");
        } else {
            prenomJoueur.setText(j.getPrenom());
        }
        if (j.getTelephoneJoueur() == 0) {
            telJoueur.setText("Not Defined");
        } else {
            telJoueur.setText(String.valueOf(j.getTelephoneJoueur()));
        }
    }

    //Affichage de l'observation du compte rendu
    private void updateObservation(CompteRendu cr) {
        System.out.println(cr);
        if (cr.getObservation().equals("")) {
            observation.setText("Not Defined");
        }
        observation.setText(cr.getObservation());
        
        Calendar cal = Calendar.getInstance();
        if(cr.getDate()!= null){
        cal.setTime(cr.getDate());
        String  month, year;
        int jr;
        jr= cal.get(Calendar.DAY_OF_MONTH);
        month= months[cal.get(Calendar.MONTH)];
        year= String.valueOf(cal.get(Calendar.YEAR));
        
        String jour;
        if (jr < 10){
            jour = " "+String.valueOf(jr);
        }else{
            jour = String.valueOf(jr);
        }
        date.setText("Date : "+jour+" "+month+" "+year);
        }else{
            date.setText("Not defined");
        }
    }

}
