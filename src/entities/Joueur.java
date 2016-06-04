/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author ift
 */
public class Joueur {
   private int idJoueur;
   private String nom;
   private String prenom;
   private String dateNaissance;
   private int cin;
   private String adresseJoueur;
   private String sexeJoueur;
   private String niveauJoueur;
   private String poidJoeur;
   private int telephoneJoueur;
   private int photoJoueur;
   private int idClub;

    public Joueur() {
    }
    
    
    
    public Joueur(int idJoueur, String nom, String prenom, String dateNaissance, int cin, String adresseJoueur, String sexeJoueur, String niveauJoueur, String poidJoeur, int telephoneJoueur, int photoJoueur, int idClub) {
        this.idJoueur = idJoueur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.cin = cin;
        this.adresseJoueur = adresseJoueur;
        this.sexeJoueur = sexeJoueur;
        this.niveauJoueur = niveauJoueur;
        this.poidJoeur = poidJoeur;
        this.telephoneJoueur = telephoneJoueur;
        this.photoJoueur = photoJoueur;
        this.idClub = idClub;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public int getCin() {
        return cin;
    }

    public String getAdresseJoueur() {
        return adresseJoueur;
    }

    public String getSexeJoueur() {
        return sexeJoueur;
    }

    public String getNiveauJoueur() {
        return niveauJoueur;
    }

    public String getPoidJoeur() {
        return poidJoeur;
    }

    public int getTelephoneJoueur() {
        return telephoneJoueur;
    }

    public int getPhotoJoueur() {
        return photoJoueur;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setAdresseJoueur(String adresseJoueur) {
        this.adresseJoueur = adresseJoueur;
    }

    public void setSexeJoueur(String sexeJoueur) {
        this.sexeJoueur = sexeJoueur;
    }

    public void setNiveauJoueur(String niveauJoueur) {
        this.niveauJoueur = niveauJoueur;
    }

    public void setPoidJoeur(String poidJoeur) {
        this.poidJoeur = poidJoeur;
    }

    public void setTelephoneJoueur(int telephoneJoueur) {
        this.telephoneJoueur = telephoneJoueur;
    }

    public void setPhotoJoueur(int photoJoueur) {
        this.photoJoueur = photoJoueur;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    @Override
    public String toString() {
        return "Joueur{" + "idJoueur=" + idJoueur + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", adresseJoueur=" + adresseJoueur + ", sexeJoueur=" + sexeJoueur + ", niveauJoueur=" + niveauJoueur + ", poidJoeur=" + poidJoeur + ", telephoneJoueur=" + telephoneJoueur + ", photoJoueur=" + photoJoueur + ", idClub=" + idClub + '}';
    }
}
