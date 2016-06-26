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
 * @author mohamedaziz
*/

public class PieChartJoueurs extends Application {

 

    //PIE CHART DATA

    private ObservableList data;

 

    //MAIN EXECUTOR

    public static void main(String[] args) {

        Application.launch(PieChartJoueurs.class, args);

    }

 

    //CONNECTION DATABASE SAVING DATA

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

      public void start(Stage stage) throws Exception {

        //PIE CHART

        PieChart pieChart = new PieChart();

        buildData();

        pieChart.getData().addAll(data);

 

        //Main Scene

        Scene scene = new Scene(pieChart);       

 

        stage.setScene(scene);
        stage.setTitle("Statistique");
        stage.show();

      }

}
