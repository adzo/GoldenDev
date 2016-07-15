/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import guiStat.PieChartArbitre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javafx.application.Application;
import utils.DataSource;

/**
 *
 * @author AD ZO
 */
public class TestTFT {
    public static void main(String[] args) throws SQLException {
       Date myDate;
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.MONTH, 8);
      cal.set(Calendar.DATE, 2);
     cal.set(Calendar.YEAR, 1991);
     int cin = 65816;
     myDate = cal.getTime();
//        Medecin m = new Medecin(7, "Jaouadi", "Seif", myDate, cin, "Sijoumi");
//        MedecinDAO mdao = new MedecinDAO();
//        mdao.add(m);
//    
        /*  Arbitre a = new Arbitre(33,"Seifff","JAoaudi",myDate,5222552,"sijoumiddd","Amateur");
          ArbitreDAO adao = new ArbitreDAO();
         adao.update(a);
        int id ;
       // id= AllUsers.connected.getId();
       // System.out.print(""+id);
       
         // adao.update(a);
          System.out.println(adao.nomPrenomArbitre(53));*/
     /*Formation f = new Formation(17,"SEIF","Jaouadi",myDate,myDate);
     FormationDAO df = new FormationDAO();
     df.modifFormation(f);*/
        //String [] args1 = {"Stat","ss"};
            Application.launch(PieChartArbitre.class, "kkk");

          
          
}

}