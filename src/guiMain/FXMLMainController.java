/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import entities.AllUsers;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLMainController implements Initializable {

    @FXML
    private Label dateAndTime;
    @FXML
    private Label status;
    @FXML
    private Label connectedNom;
    @FXML
    private Label connectedPrenom;
    @FXML
    private Button gestionMenu;
    @FXML
    private ImageView closeImage;
    @FXML
    private ImageView logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image ico = new Image("resources/Icons/Disconnect2.png");
        closeImage.setImage(ico);
        Image ico2 = new Image("resources/Icons/Main_TFT.png");
        logo.setImage(ico2);
        /**
         * * Setting the TimeBar
         */
        final DateFormat dateFormat;
        dateFormat = DateFormat.getDateTimeInstance();
        Timeline timeline;
        timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), (ActionEvent event) -> {
            final Calendar cal = Calendar.getInstance();
            dateAndTime.setText("  ||   Date :   " + dateFormat.format(cal.getTime()));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        /**
         * *Setting the InfoBar
         */
        status.setText(AllUsers.connected.getType() + " |  ID = '" + AllUsers.connected.getId() + "'");
        /**
         * Initialisation of access
         */
    }

    @FXML
    public void closePlatform() {
        Platform.exit();
    }
}
