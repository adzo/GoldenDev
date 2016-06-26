/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiJoueur;

import dao.JoueurDAO;
import entities.Joueur;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLRechercheJoueurController implements Initializable {

     @FXML
   private TableView<Joueur> tableau;
   @FXML
   private TableColumn<Joueur,Integer> id;
   @FXML
   private TableColumn<Joueur,String> nom;
   @FXML
   private TableColumn<Joueur,String> prenom;
    
    JoueurDAO j=new JoueurDAO();
    ObservableList<Joueur> data;
    Joueur u = new Joueur();
     
    public void selectedElement(MouseEvent event){
        if (event.getClickCount() != 2){
        Joueur.modifiedJoueur  = tableau.getSelectionModel().getSelectedItem();
        System.out.println(Joueur.modifiedJoueur.toString());
        }else{
            Joueur.modifiedJoueur  = tableau.getSelectionModel().getSelectedItem();
            Stage stage = (Stage) ((Node) (event.getSource())).getScene().getWindow();
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        }
     
    }
    
//    public void selectedElement(MouseEvent event){

//        
//   
//    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Joueur.modifiedJoueur=null;
        ArrayList<Joueur> liste = new ArrayList<>();
        id.setCellValueFactory(new PropertyValueFactory<>("idJoueur"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        liste = j.afficherTout();
        data = FXCollections.observableArrayList(liste);
        tableau.setItems(data);
    }    
    
}
