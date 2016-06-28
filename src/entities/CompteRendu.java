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

  
   private String result;
   private int idJoueur;
   private boolean resultatTest;
   private String observation;
   private Date date;
    public CompteRendu() {
    }
      public CompteRendu(int idCompterendu, int idMedecin, int idJoueur, boolean resultatTest, String observation, Date date) {
        this.idCompterendu = idCompterendu;
        this.idMedecin = idMedecin;
        this.idJoueur = idJoueur;
        this.resultatTest = resultatTest;
        this.observation = observation;
        this.date = date;
        if (resultatTest){
            result = "positif";
        }else{
            result = "négatif";
        }
    }

    @Override
    public String toString() {
        return "CompteRendu{" + "idCompterendu=" + idCompterendu + ", idMedecin=" + idMedecin + ", result=" + result + ", idJoueur=" + idJoueur + ", resultatTest=" + resultatTest + ", observation=" + observation + ", date=" + date + '}';
    }

    public CompteRendu(int idCompterendu, int idMedecin,  int idJoureur, boolean resultatTest, String observation) {
        this.idCompterendu = idCompterendu;
        this.idMedecin = idMedecin;
        
        this.idJoueur = idJoureur;
        this.resultatTest = resultatTest;
        this.observation = observation;
        if (resultatTest){
            result = "positif";
        }else{
            result = "négatif";
        }
    }
     public CompteRendu( int idMedecin,  int idJoureur, boolean resultatTest, String observation, Date date) {
        
        this.idMedecin = idMedecin;
        
        this.idJoueur = idJoureur;
        this.resultatTest = resultatTest;
        this.observation = observation;
        this.date = date;
         if (resultatTest){
            result = "positif";
        }else{
            result = "négatif";
        }
    }

    public Date getDate() {
        return date;
    }

    public String getResult() {
        return result;
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

   

    public int getIdJoueur() {
        return idJoueur;
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

    

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public void setResultatTest(boolean resultatTest) {
        this.resultatTest = resultatTest;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
   
}
