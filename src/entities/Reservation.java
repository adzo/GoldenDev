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
public class Reservation {
     private int idReservation;
   /** @pdOid 0cb1841c-ecf0-4e06-ae9e-d6310c3eaf78 */
   private int idUser;
   /** @pdOid 241da7f4-255c-421e-9465-dfb18671e0d5 */
   private int idMatch;

    public Reservation() {
    }

    public Reservation(int idReservation, int idUser, int idMatch) {
        this.idReservation = idReservation;
        this.idUser = idUser;
        this.idMatch = idMatch;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", idUser=" + idUser + ", idMatch=" + idMatch + '}';
    }
}
