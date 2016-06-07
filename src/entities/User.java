
package entities;

import java.util.ArrayList;
import java.util.Date;


public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private int cin;
    private Date dateNaissance;
    private String adresse;
    private int tel;
    private String mail;
    public static java.util.List<User> listes;
    public User(int idUser, String nom, String prenom, int cin, Date dateNaissance, String adresse, int tel, String mail) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.tel = tel;
        this.mail = mail;
        listes = new ArrayList<>();
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getCin() {
        return cin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTel() {
        return tel;
    }

    public String getMail() {
        return mail;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" + "nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", tel=" + tel + ", mail=" + mail + '}';
    }
    
    
}
