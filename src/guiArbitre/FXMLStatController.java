/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

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
 * @author ift
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
            
            String SQL = "SELECT count(idArbitre) FROM arbitre where categArbitre='Amateur'";
            String SQL2 = "SELECT count(idArbitre) FROM arbitre where categArbitre='International'";
            String SQL3 = "SELECT count(idArbitre) FROM arbitre where categArbitre='National'"  ;
           
               
            ResultSet rs = c.createStatement().executeQuery(SQL);
            ResultSet rs2 = c.createStatement().executeQuery(SQL2);
            ResultSet rs3 = c.createStatement().executeQuery(SQL3);
          
            while(rs.next() && rs2.next() && rs3.next()){

                //adding data on piechart data

                data.add(new PieChart.Data("Arbitre Amateur",rs.getDouble(1)));
                data.add(new PieChart.Data("Arbitre International",rs2.getDouble(1)));
                data.add(new PieChart.Data("Arbitre National",rs3.getDouble(1)));

            }

          }catch(Exception e){

              System.out.println("Error on DB connection");

              return;

          }

 

      }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        buildData();
       pch.setData(data);

    }    
    
}
