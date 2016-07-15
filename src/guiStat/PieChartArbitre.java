/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiStat;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.DataSource;

/**
 *
 * @author ift
 */
public class PieChartArbitre extends Application {
    
 

    //PIE CHART DATA

    private ObservableList data;

 

    //MAIN EXECUTOR

    /*public static void main(String[] args) {

        Application.launch(PieChartArbitre.class, args);

    }*/

 

    //CONNECTION DATABASE SAVING DATA

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
      public void start(Stage stage) throws Exception {

        //PIE CHART

        PieChart pieChart = new PieChart();

        buildData();

        pieChart.getData().addAll(data);

 

        //Main Scene

        Scene scene = new Scene(pieChart);       

 

        stage.setScene(scene);
        stage.setTitle("Statistique Arbitres Grades");
        stage.setResizable(true);
        
        
        stage.show();

      }

}
