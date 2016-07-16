/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiAllUsers;

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

            String SQL = "SELECT count(*) FROM `alluser` where type='joueur'  ";
            String SQL2 = "SELECT count(*) FROM `alluser` where type='arbitre'  ";
            String SQL3 = "SELECT count(*) FROM `alluser` where type='responsablead'  ";
            String SQL4 = "SELECT count(*) FROM `alluser` where type='medecin' ";
            String SQL5 = "SELECT count(*) FROM `alluser` where type='user'  ";

 

            ResultSet rs = c.createStatement().executeQuery(SQL);
            ResultSet rs2 = c.createStatement().executeQuery(SQL2);
            ResultSet rs3 = c.createStatement().executeQuery(SQL3);
            ResultSet rs4 = c.createStatement().executeQuery(SQL4);
            ResultSet rs5 = c.createStatement().executeQuery(SQL5);

            while(rs.next() && rs2.next()&& rs3.next()&& rs4.next()&& rs5.next()){

                //adding data on piechart data

                data.add(new PieChart.Data("joueur",rs.getDouble(1)));
                data.add(new PieChart.Data("arbitre",rs2.getDouble(1)));
                data.add(new PieChart.Data("responsablead",rs3.getDouble(1)));
                data.add(new PieChart.Data("medecin",rs4.getDouble(1)));
                data.add(new PieChart.Data("user",rs5.getDouble(1)));


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
