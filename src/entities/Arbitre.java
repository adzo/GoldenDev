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
public class Arbitre {
    
   private int idArbitre;
   private String nom;
   private String prenom;
   private Date dateNaissance;
   private int cin;
   private String adresse;
   private String categorie;
   private String sexeArbitre;
   private String photoArbitre;

    public Arbitre() {
    }

    public Arbitre(int idArbitre, String nom, String prenom, Date dateNaissance, int cin, String adresse, String categorie, String sexeArbitre, String photoArbitre) {
        this.idArbitre = idArbitre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.adresse = adresse;
        this.categorie = categorie;
        this.sexeArbitre = sexeArbitre;
        this.photoArbitre = photoArbitre;
    }

    public int getIdArbitre() {
        return idArbitre;
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

    public String getCategorie() {
        return categorie;
    }

    public String getSexeArbitre() {
        return sexeArbitre;
    }

    public String getPhotoArbitre() {
        return photoArbitre;
    }

    public void setIdArbitre(int idArbitre) {
        this.idArbitre = idArbitre;
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

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setSexeArbitre(String sexeArbitre) {
        this.sexeArbitre = sexeArbitre;
    }

    public void setPhotoArbitre(String photoArbitre) {
        this.photoArbitre = photoArbitre;
    }

    @Override
    public String toString() {
        return "Arbitre{" + "idArbitre=" + idArbitre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", adresse=" + adresse + ", categorie=" + categorie + ", sexeArbitre=" + sexeArbitre + ", photoArbitre=" + photoArbitre + '}';
    }
   
}
