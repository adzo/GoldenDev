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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /**
         *
         * * Setting the TimeBar
         *
         */
        final DateFormat dateFormat;
        dateFormat = DateFormat.getDateTimeInstance();
        Timeline timeline;

        timeline = new Timeline(new KeyFrame(javafx.util.Duration.seconds(1), (ActionEvent event) -> {
            final Calendar cal = Calendar.getInstance();

            dateAndTime.setText("  ||   Date :   " + dateFormat.format(cal.getTime()));

            switch (AllUsers.connected.getType()) {
                case ("admin"):
                    break;
                default: {
                    gestionMenu.setVisible(false);
                }
            }

        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        /**
         *
         * Setting the InfoBar
         *
         */
        status.setText(AllUsers.connected.getType());
        connectedNom.setText(AllUsers.connected.getLogin());
        connectedPrenom.setText(AllUsers.connected.getMdp());
        /**
         *
         * Initialisation des accés
         *
         */

    }

    @FXML
    public void closePlatform() {
        Platform.exit();
    }

    @FXML
    public void reduirePlatform() {

    }
}
