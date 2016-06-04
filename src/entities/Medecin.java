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
public class Medecin {
 private int idMedecin ;
 private String nom;
 private String prenom; 
 private Date dateNaissance ;
 private int cin ;
 private String adresse ;
 private int telephone ;
 private String sexeMedecin ;

    public Medecin() {
    }

    public Medecin(int idMedecin, String nom, String prenom, Date dateNaissance, int cin, String adresse) {
        this.idMedecin = idMedecin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.adresse = adresse;
    }

    
    public Medecin(int idMedecin, String nom, String prenom, Date dateNaissance, int cin, String adresse, int telephone, String sexeMedecin) {
        this.idMedecin = idMedecin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.adresse = adresse;
        this.telephone = telephone;
        this.sexeMedecin = sexeMedecin;
    }

    public int getIdMedecin() {
        return idMedecin;
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

    public String getSexeMedecin() {
        return sexeMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
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

    public void setSexeMedecin(String sexeMedecin) {
        this.sexeMedecin = sexeMedecin;
    }

    @Override
    public String toString() {
        return "Medecin{" + "idMedecin=" + idMedecin + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", adresse=" + adresse + ", telephone=" + telephone + ", sexeMedecin=" + sexeMedecin + '}';
    }
 
}
