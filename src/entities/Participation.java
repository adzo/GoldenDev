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
public class Participation {
   private int idParticipation;
   private String idArbitre;
   private int idFormation;

    public Participation() {
    }

    public Participation(int idParticipation, String idArbitre, int idFormation) {
        this.idParticipation = idParticipation;
        this.idArbitre = idArbitre;
        this.idFormation = idFormation;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public String getIdArbitre() {
        return idArbitre;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public void setIdArbitre(String idArbitre) {
        this.idArbitre = idArbitre;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    @Override
    public String toString() {
        return "Participation{" + "idParticipation=" + idParticipation + ", idArbitre=" + idArbitre + ", idFormation=" + idFormation + '}';
    }
}
