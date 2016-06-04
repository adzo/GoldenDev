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
public class Concour {
   private int idConcour;
   private String date;
   private String lieu;

    public Concour() {
    }

    public Concour(int idConcour, String date, String lieu) {
        this.idConcour = idConcour;
        this.date = date;
        this.lieu = lieu;
    }

    public int getIdConcour() {
        return idConcour;
    }

    public String getDate() {
        return date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setIdConcour(int idConcour) {
        this.idConcour = idConcour;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        return "Concour{" + "idConcour=" + idConcour + ", date=" + date + ", lieu=" + lieu + '}';
    }
   
}
