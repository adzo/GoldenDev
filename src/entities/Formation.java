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
public class Formation {
    private int idFormation;
   private String nom;
   private String lieu;
   private Date dateOuverture;
   private Date dateFermeture;
    public static java.util.List<Formation> listes;

    public Formation() {
    }

    public Formation(int idFormation, String nom, String lieu, Date dateOuverture, Date dateFermeture) {
        this.idFormation = idFormation;
        this.nom = nom;
        this.lieu = lieu;
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public Date getDateFermeture() {
        return dateFermeture;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public void setDateFermeture(Date dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    @Override
    public String toString() {
        return "Formation{" + "idFormation=" + idFormation + ", nom=" + nom + ", lieu=" + lieu + ", dateOuverture=" + dateOuverture + ", dateFermeture=" + dateFermeture + '}';
    }
    
}
