/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiFormation;

import dao.AllUsersDAO;
import dao.FormationDAO;
import dao.ParticipationDAO;
import entities.AllUsers;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLGestionFormationsController implements Initializable {
     String[] months = {"Janvier","Fevrier","Mars","Avril","Mai","Juin",
        "Juillet","Aout","Septembre","Octobre","Novembre","Decembre"};
    String[] days = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
    
    final String NEW_FORMAT = "dd/MM/yyyy";
    @FXML
    private TableView<Formation> tableau;
    @FXML
    private TableColumn<Formation, Integer> id;
    @FXML
    private TableColumn<Formation, String> nom;
     @FXML
    private TableColumn<Formation, String> lieu;
// //<editor-fold defaultstate="collapsed" desc="Ajout formation variable">
 @FXML
 private TextField  Tnom ;
 @FXML
 private TextField Tlieu ;
 @FXML
 private DatePicker Tdebut ;
 @FXML
 private DatePicker  Tfin ;
 @FXML
 private Button btnValider;
 @FXML
 private Button btnajout;
 @FXML
 private Pane panAdd;       
 Alert alert2 = new Alert(Alert.AlertType.INFORMATION); 
     //</editor-fold>
     
   // ----------------------------------------  
 //<editor-fold defaultstate="collapsed" desc="comment">
 
 //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="comment">
 
 //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="comment">
 
 //</editor-fold>

 @FXML
 private Pane pAff ;
 @FXML
 private Pane pAdmin ;
 @FXML
 private Pane pArbitre ;
 @FXML
 private Pane pModif ;
 @FXML
 private Pane pSupp ;
 @FXML
 private Button modif ;
 @FXML
 private Button supp ;
 @FXML
 private Button valider ;
  @FXML
  private Button participer; 

  @FXML
 private Button oui ;
  @FXML
 private Button non ;
   @FXML 
   private Text tdatdeb ;
   @FXML
   private Text tdatfin;
    @FXML 
   private Text tdatdeb1 ;
   @FXML
   private Text tdatfin1;
   @FXML
   private Text nomF ;
   @FXML
   private TextField nomM ;
   @FXML
   private TextField lieuM ;
   @FXML
   private DatePicker D1M ;
    @FXML
   private DatePicker D2M ;
   
   
    FormationDAO fdao = new FormationDAO();
         ParticipationDAO pF = new ParticipationDAO();

    ObservableList<Formation> data;
    Formation f = new Formation();
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
  public boolean verificationAjout(){
        boolean test=true;
        if(Tnom.getText().isEmpty()){
            test=false;return test;}
        else if(Tlieu.getText().isEmpty()){
            test=false;return test;}
        else if(Tdebut.getValue() == null){
            test=false;return test;}
        else if(Tfin.getValue() == null){
            test=false;return test;}
        return test;
    }
  public boolean verificationModif(){
        boolean test=true;
        if(nomM.getText().isEmpty()){
            test=false;return test;}
        else if(lieuM.getText().isEmpty()){
            test=false;return test;}
        else if(D1M.getValue() == null){
            test=false;return test;}
        else if(D2M.getValue() == null){
            test=false;return test;}
        return test;
    }
 public boolean verifDateAJout(){
     if(Date.valueOf(Tdebut.getValue()).compareTo(Date.valueOf(Tfin.getValue()))>0){
         
         return false;
     }
     else{
     return true ;}
 }
 public boolean verifDateModif(){
     if(Date.valueOf(D1M.getValue()).compareTo(Date.valueOf(D2M.getValue()))>0){
         
         return false;
     }
     else{
     return true ;}
 }
      public void actualiserTAB(){
        f.listes = fdao.displayAll();
        data = FXCollections.observableArrayList(f.listes);
        tableau.setItems(data);
        final int size = tableau.getItems().size() -1;
        tableau.scrollTo(size);
      }
    public void annuler(){
        pSupp.setVisible(false);
        pAff.setVisible(true);
    }
    public void OKsupprimer(){
        fdao.delete(f.getIdFormation());
        pSupp.setVisible(false);
        pAff.setVisible(true);
        actualiserTAB();
    }
    public void validerModif(){
       if(verificationModif()&&verifDateModif()){
        Formation mf = new Formation(f.getIdFormation(),nomM.getText(),
                lieuM.getText(),Date.valueOf(D1M.getValue()),Date.valueOf(D2M.getValue()));
        fdao.modifFormation(mf);
        lieuM.clear();
        nomM.clear();
        D1M.setValue(null);
        D2M.setValue(null);
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert2.setTitle("Modification d'une formation");
        alert2.setContentText("Formation Modifier avec succés !");
        alert2.showAndWait();}
       else{
            alert2.setAlertType(Alert.AlertType.ERROR);
        alert2.setTitle("Modification Impossible");
        alert2.setContentText("Echéc de Modification  d'une formation");
        alert2.showAndWait();}
        
        pModif.setVisible(false);
        pSupp.setVisible(false);
        pAff.setVisible(true);
        actualiserTAB();

    }
    public void supprimerFormation(){
        pAff.setVisible(false);
        pModif.setVisible(false);
        pSupp.setVisible(true);

    }
    public void modfierFormation(){
        pAff.setVisible(false);
        pSupp.setVisible(false);
        pModif.setVisible(true);
    }
    
    public void modifierContent(Formation f){
        Calendar cal = Calendar.getInstance();
        if(f.getDateOuverture() != null){
        cal.setTime(f.getDateOuverture());
        String jour, month, year, dayOfTheWeek;

        jour= String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        month= months[cal.get(Calendar.MONTH)];
        year= String.valueOf(cal.get(Calendar.YEAR));
        dayOfTheWeek = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        tdatdeb.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);
        tdatdeb1.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);

        }else{
            tdatdeb.setText("Not defined");
            tdatdeb1.setText("Not defined");

        }
        if(f.getDateFermeture() != null){
        cal.setTime(f.getDateFermeture());
        String jour, month, year, dayOfTheWeek;

        jour= String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
        month= months[cal.get(Calendar.MONTH)];
        year= String.valueOf(cal.get(Calendar.YEAR));
        dayOfTheWeek = days[cal.get(Calendar.DAY_OF_WEEK)-1];
        tdatfin.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);
        tdatfin1.setText(dayOfTheWeek+" le "+jour+" "+month+" "+year);

        }else{
            tdatfin.setText("Not defined");
            tdatfin1.setText("Not defined");

        }

        nomF.setText(f.getNom());
        
        //Setting the fields : 
        
    }
     
    public void selectedElement(){
        f  = tableau.getSelectionModel().getSelectedItem();
        //System.out.println(u);
        modifierContent(f);
        System.out.println(f.toString());
             ParticipationDAO pF1 = new ParticipationDAO();
       if(!pF1.verifierParticipation(f.getIdFormation(), AllUsers.connected.getId())){
           
           participer.setText("Annuler Participation");
       }else {           participer.setText("Participer");}

    }
    
    public void participationFormation(){
 
     if(pF.verifierParticipation(f.getIdFormation(), AllUsers.connected.getId())){
         participer.setText("Annuler Participer");
         alert.setAlertType(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Participation");
                alert.setContentText(AllUsers.connected.getLogin()+" Volez vous participez à "+f.getNom()+" :)");

             alert.showAndWait();

      // if(alert.getAlertType().CONFIRMATION.equals(false)){
    pF.participer(f.getIdFormation(), AllUsers.connected.getId());
     alert.setAlertType(Alert.AlertType.INFORMATION);
     alert.setContentText(AllUsers.connected.getLogin()+" votre participation à été effectué à la Formation "+f.getNom()+" :)");
    alert.showAndWait();

   }
     else{ System.err.println("Arbitre déjà participé!!");
     alert.setAlertType(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Annuler Participation");
             alert.showAndWait();
     pF.AnnulerParticipation(f.getIdFormation(), AllUsers.connected.getId());
      participer.setText("Participer");
     }
    
    }
   
    public void ajouterFormation(){
        pAdmin.setVisible(false);
        pArbitre.setVisible(false);
        panAdd.setVisible(true);
    }
    public void valider(){
        
        if(verificationAjout()&&verifDateAJout()){
            FormationDAO fdao1 =new FormationDAO();
           int id=0;
       
         
        Formation formation=new Formation(id,Tnom.getText(), Tlieu.getText(),
       Date.valueOf(Tdebut.getValue()), Date.valueOf(Tfin.getValue()));
        
        fdao1.ajoutFormation(formation);
        
        alert2.setAlertType(Alert.AlertType.INFORMATION);
        alert2.setTitle("Ajout d'une formation");
        alert2.setContentText("Formation ajoutée avec succés !");
        alert2.showAndWait();
        Tnom.clear();
        Tlieu.clear();
        Tdebut.setValue(null);
        Tfin.setValue(null);
      }else{
            alert2.setAlertType(Alert.AlertType.ERROR);
        alert2.setTitle("Ajout Impossible");
        alert2.setContentText("Echéc d'ajout  d'une formation");
        alert2.showAndWait();}
                actualiserTAB();

        
        panAdd.setVisible(false);
        pAdmin.setVisible(true);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if(pF.verifierParticipation(f.getIdFormation(), AllUsers.connected.getId())){
             
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
           pArbitre.setVisible(true);

             pAdmin.setVisible(false);}
        id.setCellValueFactory(new PropertyValueFactory<>("idFormation"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        lieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));

        Formation.listes = fdao.displayAll();
        data = FXCollections.observableArrayList(Formation.listes);
        tableau.setItems(data);  
    }

}
