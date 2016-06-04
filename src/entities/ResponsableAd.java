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
public class ResponsableAd {
   private int idResponsable;
   private String nom;
   private String prenom;
   private Date dateNaissance;
   private int cin;
   private String adresse;
   private int telephone;

    public ResponsableAd() {
    }

    public ResponsableAd(int idResponsable, String nom, String prenom, Date dateNaissance, int cin, String adresse, int telephone) {
        this.idResponsable = idResponsable;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public int getIdResponsable() {
        return idResponsable;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public int getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setIdResponsable(int idResponsable) {
        this.idResponsable = idResponsable;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "ResponsableAd{" + "idResponsable=" + idResponsable + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
   
}
