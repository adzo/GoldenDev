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
public class ParticipationConcour {
    
   private int idParticipationConcour;
   private int idArbitre;
   private int idConcour;

    public ParticipationConcour() {
    }

    public ParticipationConcour(int idParticipationConcour, int idArbitre, int idConcour) {
        this.idParticipationConcour = idParticipationConcour;
        this.idArbitre = idArbitre;
        this.idConcour = idConcour;
    }

    public int getIdParticipationConcour() {
        return idParticipationConcour;
    }

    public int getIdArbitre() {
        return idArbitre;
    }

    public int getIdConcour() {
        return idConcour;
    }

    public void setIdParticipationConcour(int idParticipationConcour) {
        this.idParticipationConcour = idParticipationConcour;
    }

    public void setIdArbitre(int idArbitre) {
        this.idArbitre = idArbitre;
    }

    public void setIdConcour(int idConcour) {
        this.idConcour = idConcour;
    }

    @Override
    public String toString() {
        return "ParticipationConcour{" + "idParticipationConcour=" + idParticipationConcour + ", idArbitre=" + idArbitre + ", idConcour=" + idConcour + '}';
    }
   
}
