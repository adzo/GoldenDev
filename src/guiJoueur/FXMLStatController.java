/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiJoueur;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author mohamedaziz
 */
public class FXMLStatController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private PieChart pch ;
    
     Connection c ;

  private ObservableList data;
    public void buildData(){

          Connection c ;

          data = FXCollections.observableArrayList();
                try{

            c = DataSource.getInstance().getConnection();
           
            //SQL FOR SELECTING NATIONALITY OF CUSTOMER

            String SQL = "SELECT count(idJoueur) FROM `joueur` where etat=1  ";
            String SQL2 = "SELECT count(idJoueur) FROM `joueur` where etat=0  ";
              
 

            ResultSet rs = c.createStatement().executeQuery(SQL);
            ResultSet rs2 = c.createStatement().executeQuery(SQL2);
            while(rs.next() && rs2.next()){

                //adding data on piechart data

                data.add(new PieChart.Data("en bon etat",rs.getDouble(1)));
                data.add(new PieChart.Data("mauvaise etat",rs2.getDouble(1)));

            }

          }catch(Exception e){

              System.out.println("Error on DB connection");

              return;

          }

 

      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             buildData();
       pch.setData(data);
    }    
    
}
