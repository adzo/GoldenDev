/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.MedecinDAO;
import entities.Medecin;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author AD ZO
 */
public class TestTFT {
    public static void main(String[] args) {
        Date myDate;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.DATE, 2);
        cal.set(Calendar.YEAR, 1991);
        int cin = 65816;
        myDate = cal.getTime();
        Medecin m = new Medecin(7, "Jaouadi", "Seif", myDate, cin, "Sijoumi");
        MedecinDAO mdao = new MedecinDAO();
        mdao.add(m);
    
}

}