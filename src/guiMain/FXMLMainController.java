/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiMain;

import dao.ArbitreDAO;
import dao.JoueurDAO;
import dao.MedecinDAO;
import dao.ResponsableAdDAO;
import dao.UserDAO;
import entities.AllUsers;
import guiLogin.Login;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author AD ZO
 */
public class FXMLMainController implements Initializable {

    // Déclaration des variables
    // <editor-fold  defaultstate="collapsed"> 
    @FXML
    private Label dateAndTime;
    @FXML
    private Label status;
    @FXML
    private Label connectedNom;
    @FXML
    private Label activeWindow;
    @FXML
    private Button gestionMenu;
    @FXML
    private ImageView closeImage;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView background;
    @FXML
    private ImageView home;
    @FXML
    private Label welcome;
    @FXML
    private Pane centerPane;
    @FXML
    private Accordion adminPanel;
    @FXML
    private Accordion docPanel;
    @FXML
    private Accordion responsablePanel;
    @FXML
    private Accordion userPanel;
    @FXML
    private ImageView changeLogin;
    @FXML
    private MenuItem about;

    // </editor-fold> 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        activeWindow.setText("Bienvenue");

        /**
         * *Setting the icons
         */
        Image home32 = new Image("resources/Icons/home32.png");
        home.setImage(home32);
        
        Image back = new Image("resources/Backgrounds/top-background.png");
        background.setImage(back);
        Image ico = new Image("resources/Icons/Disconnect2.png");
        closeImage.setImage(ico);
        Image ico2 = new Image("resources/Icons/Main_TFT.png");
        logo.setImage(ico2);
        Image ico3 = new Image("resources/Icons/changeLogin.png");
        changeLogin.setImage(ico3);
        Tooltip changeLog = new Tooltip("Log Out!!");
        Tooltip.install(changeLogin, changeLog);
        Tooltip quit = new Tooltip("Close!!");
        Image image = new Image("resources/Icons/closeTooltip.png", 25, 25, true, true);
        quit.setGraphic(new ImageView(image));
        Tooltip.install(closeImage, quit);
        Tooltip tft = new Tooltip("Fédération Tunisienne de Tennis");
        Tooltip.install(logo, tft);
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
        
        if (nomPrenomConnectedUser()!=null){
        connectedNom.setText(nomPrenomConnectedUser());
        }else{
            connectedNom.setText("Not Defined");
            try {
                modifierMesInfos();
            } catch (IOException ex) {
                Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Initialisation of access
         */
        // <editor-fold  defaultstate="collapsed">
        switch (AllUsers.connected.getType()) {
            case "arbitre":

                adminPanel.setVisible(false);
                userPanel.setVisible(false);
                docPanel.setVisible(false);
                responsablePanel.setVisible(false);
                break;
            case "joueur":
                responsablePanel.setVisible(false);
                adminPanel.setVisible(false);
                userPanel.setVisible(false);
                docPanel.setVisible(false);
                break;
            case "responsablead":
                responsablePanel.setVisible(true);
                adminPanel.setVisible(false);
                userPanel.setVisible(false);
                docPanel.setVisible(false);
                break;
            case "user":
                responsablePanel.setVisible(false);
                adminPanel.setVisible(false);
                userPanel.setVisible(true);
                docPanel.setVisible(false);
                break;
            case "medecin":
                responsablePanel.setVisible(false);
                adminPanel.setVisible(false);
                userPanel.setVisible(false);
                docPanel.setVisible(true);

                break;
            case "admin":
                responsablePanel.setVisible(false);
                adminPanel.setVisible(true);
                userPanel.setVisible(false);
                docPanel.setVisible(false);
                break;
            default:
                break;
        }
        // </editor-fold>
    }

    @FXML
    public void closePlatform() {
        Platform.exit();
    }

//chargement des fenetre
    //Set Home Page
    public void home(){
        centerPane.getChildren().clear();
        centerPane.getChildren().add(background);
        Image back = new Image("resources/Backgrounds/top-background.png");
        background.setImage(back);
        activeWindow.setText("Bienvenue");
    }
    // Contrôle partie Admin
    // <editor-fold  defaultstate="collapsed">  
    public void loadAllUsers() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiAllUsers/FXMLGuiAllUsers.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Gestion All Users");
    }

    public void loadUsers() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiUser/FXMLAfficherUser.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Gestion des Fans");
    }

    public void loadClubs() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiClub/FXMLClubsMain.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(background);
        Image back = new Image("resources/Backgrounds/top-background.png");
        background.setImage(back);
        centerPane.getChildren().add(root);

        activeWindow.setText("Gestion des Clubs");

    }

    public void loadMedecins() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiMedecin/FXMLAfficherMedecins.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Gestion Medecins");

    }

    public void loadResponsable() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiResponsable/FXMLAfficherResponsables"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Gestion Responsables");
    }

    public void loadJoueur() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiJoueur/FXMLafficherJoueur.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Gestion Joueurs");
    }
    public void loadFormation() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiFormation/FXMLGestionFormations.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Gestion Formation");
    }
                                                                                                                                                                                                                                        // </editor-fold>
    // Contrôle partie Medecin
    // <editor-fold defaultstate="collapsed"> 
    public void ajouterCompteRendu() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiCompteRendu/FXMLAjoutCompteRendu.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Ajouter Un Compte Rendu");
    }

    // </editor-fold>
    // Contrôle partie RespopnsableAntiDopage
    // <editor-fold defaultstate="collapsed"> 
    public void loadCompteRendu() throws IOException {
        activeWindow.setText("Loading...");
        Parent root = FXMLLoader.load(getClass().getResource("/guiCompteRendu/FXMLAfficherCompteRendu.fxml"));
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Compte Rendus");
    }

    // </editor-fold>
    // Contrôle partie Users
    // <editor-fold defaultstate="collapsed"> 
    public void modifierMesInfos() throws IOException {
        Parent root;
        switch (AllUsers.connected.getType()) {
            case "user":
                root = FXMLLoader.load(getClass().getResource("/guiUser/FXMLModifierMesInfos.fxml"));
                break;
            case "medecin":
                root = FXMLLoader.load(getClass().getResource("/guiMedecin/FXMLModifierMesInfos.fxml"));
                break;
            case "responsablead":
                root = FXMLLoader.load(getClass().getResource("/guiResponsable/FXMLModifierMesInfos.fxml"));
                break;
            default:
                root = FXMLLoader.load(getClass().getResource("/guiUser/FXMLModifierMesInfos.fxml"));
                break;
        }
        centerPane.getChildren().clear();
        centerPane.getChildren().add(root);
        activeWindow.setText("Modifier Mes Infos");
    }
    // </editor-fold>

    @FXML
    public void login(MouseEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Stage log = new Stage();
        Login logWindow = new Login();
        logWindow.start(log);
    }

    @FXML
    public void openSplash() {
        System.out.println("About Clicked");

    }

    public String nomPrenomConnectedUser() {
        String nom = "Not defined";
        String prenom = "Not Defined";
        String result = "Not Defined";
        int i = AllUsers.connected.getId();
        String type = AllUsers.connected.getType();

        switch (type) {
            case "admin":
                result = "Administrateur TFT";
                break;
            case "arbitre":
                ArbitreDAO adao = new ArbitreDAO();
                result = adao.nomPrenomArbitre(i);
                break;
            case "joueur":
                JoueurDAO jdao = new JoueurDAO();
                result = jdao.nomPrenomJoueur(i);
                break;
            case "responsablead":
                ResponsableAdDAO rdao = new ResponsableAdDAO();
                result = rdao.nomPrenomResponsableAD(i);
                break;
            case "user":
                UserDAO udao = new UserDAO();
                nom = udao.nomUser(i);
                prenom = udao.prenomUser(i);
                if(nom!=null && prenom!= null){
                    result = nom + ", "+prenom;
                }else {
                    result = null;
                }
                
                break;
            case "medecin":
                MedecinDAO mdao = new MedecinDAO();
                result = mdao.nomPrenomMedecin(i);
                break;
            default:
                break;
        }

        return result;
    }
}
