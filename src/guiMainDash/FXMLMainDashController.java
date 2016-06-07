/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMainDash;


import entities.AllUsers;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import trash.FXMLAdminMainDashboardController;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLMainDashController implements Initializable {

    public static boolean viewB = true;
    @FXML
    public AnchorPane menu, lock;
    @FXML
    private TabPane tabPane;
    @FXML
    private Label labelTime;
    
    
    @FXML
    private Button showUsers;
    
    public void changeView() {
        //menu.setVisible(viewB);
        viewB = !viewB;
        tabPane.setDisable(viewB);
        showUsers.setDisable(viewB);
    }
           
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        tabPane.setVisible(true);
//        menu.setVisible(true);
//       
        showUsers.setDisable(true);
       // connectedId.setText("Login: "+ AllUsers.connected.getLogin()+"   |   Privilège : "+AllUsers.connected.getType());

        //Time bar
//        final DateFormat dateFormat;
//        dateFormat = DateFormat.getDateTimeInstance(); 
//        Timeline timeline;  
//
//        timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), (ActionEvent event) -> {
//            final Calendar cal = Calendar.getInstance();
//            
//            labelTime.setText("  ||   Date :   " +dateFormat.format(cal.getTime()));
//               
//        }));
//               timeline.setCycleCount(Animation.INDEFINITE);  
//               timeline.play(); 

        //Setting the window draggble
//         scene.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                 xOffset = event.getSceneX();
//                 yOffset = event.getSceneY();
//            }
//        });
//        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                mainStage.setX(event.getScreenX() - xOffset);
//                mainStage.setY(event.getScreenY() - yOffset);
//            }
//        });
        
    }
    @FXML
    private Label connectedId;

    public void clicked() {
        System.out.println("Clicked");
    }

    public void afficherUsers() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/guiAllUsers/FXMLAfficherAllUsers.fxml"));
            tab.setContent(root);
            tab.setText("Liste des users");
            tabPane.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(FXMLAdminMainDashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public Tab tab;
}





        
