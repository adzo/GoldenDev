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
public class Competition {
   private int idCompetition;
   private String nomCompetition;
   private String niveauCompetition;
   private Date dateDebut;
   private Date dateFin;

    public Competition() {
    }

    public Competition(int idCompetition, String nomCompetition, String niveauCompetition, Date dateDebut, Date dateFin) {
        this.idCompetition = idCompetition;
        this.nomCompetition = nomCompetition;
        this.niveauCompetition = niveauCompetition;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getIdCompetition() {
        return idCompetition;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public String getNiveauCompetition() {
        return niveauCompetition;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

    public void setNiveauCompetition(String niveauCompetition) {
        this.niveauCompetition = niveauCompetition;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Competition{" + "idCompetition=" + idCompetition + ", nomCompetition=" + nomCompetition + ", niveauCompetition=" + niveauCompetition + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }
   
}
