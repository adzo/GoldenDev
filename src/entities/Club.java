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
public class Club {
   private int idClub;
   private String nomClub;
   private String adresseClub;
   private Date dateFondation;
   private int telephoneClub;
   private String presidentClub;
   private String photoClub;

    public Club() {
    }

    public Club(int idClub, String nomClub, String adresseClub, Date dateFondation, int telephoneClub, String presidentClub) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.adresseClub = adresseClub;
        this.dateFondation = dateFondation;
        this.telephoneClub = telephoneClub;
        this.presidentClub = presidentClub;
    }

    public Club(String nomClub, String adresseClub) {
        this.nomClub = nomClub;
        this.adresseClub = adresseClub;
    }

    public Club(int idClub, String nomClub, String adresseClub, Date dateFondation, int telephoneClub, String presidentClub, String photoClub) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.adresseClub = adresseClub;
        this.dateFondation = dateFondation;
        this.telephoneClub = telephoneClub;
        this.presidentClub = presidentClub;
        this.photoClub = photoClub;
    }

    public int getIdClub() {
        return idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public String getAdresseClub() {
        return adresseClub;
    }

    public Date getDateFondation() {
        return dateFondation;
    }

    public int getTelephoneClub() {
        return telephoneClub;
    }

    public String getPresidentClub() {
        return presidentClub;
    }

    public String getPhotoClub() {
        return photoClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public void setAdresseClub(String adresseClub) {
        this.adresseClub = adresseClub;
    }

    public void setDateFondation(Date dateFondation) {
        this.dateFondation = dateFondation;
    }

    public void setTelephoneClub(int telephoneClub) {
        this.telephoneClub = telephoneClub;
    }

    public void setPresidentClub(String presidentClub) {
        this.presidentClub = presidentClub;
    }

    public void setPhotoClub(String photoClub) {
        this.photoClub = photoClub;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", nomClub=" + nomClub + ", adresseClub=" + adresseClub + ", dateFondation=" + dateFondation + ", telephoneClub=" + telephoneClub + ", presidentClub=" + presidentClub + ", photoClub=" + photoClub + '}';
    }
   
}
