/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Date;

/**
 *
 * @author ift
 */
public class CompteRendu {
   private int idCompterendu;
   private int idMedecin;
   
   private int idJoureur;
   private boolean resultatTest;
   private String observation;
   private Date date;
    public CompteRendu() {
    }

    public CompteRendu(int idCompterendu, int idMedecin,  int idJoureur, boolean resultatTest, String observation) {
        this.idCompterendu = idCompterendu;
        this.idMedecin = idMedecin;
        
        this.idJoureur = idJoureur;
        this.resultatTest = resultatTest;
        this.observation = observation;
    }
     public CompteRendu( int idMedecin,  int idJoureur, boolean resultatTest, String observation, Date date) {
        
        this.idMedecin = idMedecin;
        
        this.idJoureur = idJoureur;
        this.resultatTest = resultatTest;
        this.observation = observation;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
     
    public int getIdCompterendu() {
        return idCompterendu;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

   

    public int getIdJoureur() {
        return idJoureur;
    }

    public boolean isResultatTest() {
        return resultatTest;
    }

    public String getObservation() {
        return observation;
    }

    public void setIdCompterendu(int idCompterendu) {
        this.idCompterendu = idCompterendu;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    

    public void setIdJoureur(int idJoureur) {
        this.idJoureur = idJoureur;
    }

    public void setResultatTest(boolean resultatTest) {
        this.resultatTest = resultatTest;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
   
}
