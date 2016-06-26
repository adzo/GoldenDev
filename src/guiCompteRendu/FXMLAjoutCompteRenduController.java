/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiCompteRendu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
