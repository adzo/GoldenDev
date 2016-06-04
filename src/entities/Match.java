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
public class Match {
     private int idMatch;
   private int typeMatch;
   private int idArbitre;
   private int idStade;
   private int idResultat;

    public Match() {
    }

    public Match(int idMatch, int typeMatch, int idArbitre, int idStade, int idResultat) {
        this.idMatch = idMatch;
        this.typeMatch = typeMatch;
        this.idArbitre = idArbitre;
        this.idStade = idStade;
        this.idResultat = idResultat;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public int getTypeMatch() {
        return typeMatch;
    }

    public int getIdArbitre() {
        return idArbitre;
    }

    public int getIdStade() {
        return idStade;
    }

    public int getIdResultat() {
        return idResultat;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public void setTypeMatch(int typeMatch) {
        this.typeMatch = typeMatch;
    }

    public void setIdArbitre(int idArbitre) {
        this.idArbitre = idArbitre;
    }

    public void setIdStade(int idStade) {
        this.idStade = idStade;
    }

    public void setIdResultat(int idResultat) {
        this.idResultat = idResultat;
    }

    @Override
    public String toString() {
        return "Match{" + "idMatch=" + idMatch + ", typeMatch=" + typeMatch + ", idArbitre=" + idArbitre + ", idStade=" + idStade + ", idResultat=" + idResultat + '}';
    }
}
