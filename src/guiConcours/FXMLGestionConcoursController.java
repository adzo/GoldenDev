/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiConcours;

import dao.ConcourDAO;
import dao.ParticipationConcourDAO;
import entities.AllUsers;
import entities.Concour;
import entities.Formation;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLGestionConcoursController implements Initializable {

    /**
     * Initializes the controller class.
     */
      String[] months = {"Janvier","Fevrier","Mars","Avril","Mai","Juin",
        "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
    String[] days = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
    
    final String NEW_FORMAT = "dd/MM/yyyy";
    @FXML
    private TableView<Concour> tableauC;
    @FXML
    private TableColumn<Concour, Integer> idCT;
    @FXML
    private TableColumn<Concour, String> lieuCT;
  

 @FXML
 private Pane pAdmin ;
 @FXML
 private Pane pArbitre ;
 @FXML
 private Pane pModif ;
 @FXML
 private Pane pMod ;
 @FXML
 private Pane pSupp ;
 @FXML
 private Button modif ;
 @FXML
 private Button supp ;
 @FXML
 private Button valider ;
 @FXML
 private Button ajouter ;
 @FXML
 private Button valAjout ;
  @FXML
  private Button participer ;
  @FXML
 private Button oui ;
  @FXML
 private Button non ;
 @FXML 
   private Text tdatC ;
 @FXML 
   private Text tdatC1 ;
@FXML
private Pane pAdd ;
  @FXML 
   private Text tid ;
   @FXML
   private TextField lieuM ;
   @FXML
   private DatePicker D1M ;
   @FXML
   private TextField lieuA ;
   @FXML
   private DatePicker D1A;
   
 ConcourDAO fdao = new ConcourDAO();
    ObservableList<Concour> data;
    Concour c = new Concour();
            ParticipationConcourDAO pF = new ParticipationConcourDAO();

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    
  public void actualiserTAB(){
        c.listes = fdao.displayAll();
        data = FXCollections.observableArrayList(c.listes);
        tableauC.setItems(data);
        final int size = tableauC.getItems().size() -1;
        tableauC.scrollTo(size);
      }
   public void annuler(){
        pSupp.setVisible(false);
        pMod.setVisible(true);
    }
    public void ajouterConcour(){
        pAdmin.setVisible(false);
        pArbitre.setVisible(false);
        pAdd.setVisible(true);
    }
    public void OKsupprimer(){
        fdao.delete(c.getIdConcour());
        pSupp.setVisible(false);
        pMod.setVisible(true);
        actualiserTAB();
    }
   public void validerModif(){
        Concour mc = new Concour(c.getIdConcour(),
                Date.valueOf(D1M.getValue()),lieuM.getText());
        fdao.modifConcour(mc);
        pModif.setVisible(false);
        pSupp.setVisible(false);
        pMod.setVisible(true);
        actualiserTAB();

    }
   public void validerAjout(){
       Concour mc = new Concour(c.getIdConcour(), Date.valueOf(D1M.getValue()),lieuM.getText());
      fdao.ajoutConcour(mc);
      pAdd.setVisible(false);
      pAdmin.setVisible(true);
      
   }
    public void supprimerConcour(){
        pMod.setVisible(false);
        pModif.setVisible(false);
        pSupp.setVisible(true);

    }
    public void modfierConcour(){
        pMod.setVisible(false);
        pSupp.setVisible(false);
        pModif.setVisible(true);
    }
    
    public void modifierContent(Concour c){
        Calendar cal = Calendar.getInstance();
        if(c.getDate() != null){
        cal.setTime(c.getDate());
        String jour, month, year, dayOfTheWeek;

        jour= String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        month= months[cal.get(Calendar.MONTH)];
        year= String.valueOf(cal.get(Calendar.YEAR));
        dayOfTheWeek = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        tdatC.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);
                tdatC1.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);

        }else{
            tdatC.setText("Not defined");
            tdatC1.setText("Not defined");

        }
       
        tid.setText(""+c.getIdConcour());
        
        //Setting the fields : 
        
    }
     
    public void selectedElement(){
        c  = tableauC.getSelectionModel().getSelectedItem();
        System.out.println(c);
        modifierContent(c);
    }
    
    public void participationConcour(){ 
 
     if(pF.verifierParticipation(c.getIdConcour(), AllUsers.connected.getId())){
         participer.setText("Annuler Participer");
         alert.setAlertType(Alert.AlertType.CONFIRMATION);
              alert.setContentText(AllUsers.connected.getLogin()+" voulez vous participez ");

           alert.setTitle("Participation");
             alert.showAndWait();

      // if(alert.getAlertType().CONFIRMATION.equals(false)){
    pF.participer(c.getIdConcour(), AllUsers.connected.getId());
     alert.setAlertType(Alert.AlertType.INFORMATION);
     alert.setContentText(AllUsers.connected.getLogin()+" votre participation à été effectué  :)");
    alert.showAndWait();

   }
     else{ System.err.println("Arbitre déjà participé!!");
     alert.setAlertType(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Annuler Participation");
             alert.showAndWait();
     pF.AnnulerParticipation(c.getIdConcour(), AllUsers.connected.getId());
      participer.setText("Participer");
     }
    
    
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
             if(pF.verifierParticipation(c.getIdConcour(), AllUsers.connected.getId())){
             
               alert.setTitle("Annuler Participation");
             
             }
             else {           
                      participer.setText("Participer");

             }

       if("admin".equals(AllUsers.connected.getType())){
           pAdmin.setVisible(true);
           pArbitre.setVisible(false);
       }
          else{ 
             pAdmin.setVisible(false);
            pArbitre.setVisible(true);}
        idCT.setCellValueFactory(new PropertyValueFactory<>("idConcour"));
        lieuCT.setCellValueFactory(new PropertyValueFactory<>("lieu"));

        Concour.listes = fdao.displayAll();
        data = FXCollections.observableArrayList(Concour.listes);
        tableauC.setItems(data);  
    }

}