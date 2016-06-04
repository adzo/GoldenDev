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
public class Stade {
   private int idStade;
   private String nomStade;
   private int adresseStade;

    public Stade() {
    }

    public Stade(int idStade, String nomStade, int adresseStade) {
        this.idStade = idStade;
        this.nomStade = nomStade;
        this.adresseStade = adresseStade;
    }

    public int getIdStade() {
        return idStade;
    }

    public String getNomStade() {
        return nomStade;
    }

    public int getAdresseStade() {
        return adresseStade;
    }

    public void setIdStade(int idStade) {
        this.idStade = idStade;
    }

    public void setNomStade(String nomStade) {
        this.nomStade = nomStade;
    }

    public void setAdresseStade(int adresseStade) {
        this.adresseStade = adresseStade;
    }

    @Override
    public String toString() {
        return "Stade{" + "idStade=" + idStade + ", nomStade=" + nomStade + ", adresseStade=" + adresseStade + '}';
    }
   
    
}
