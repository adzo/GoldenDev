/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IDao;

import entities.Participation;

/**
 *
 * @author ift
 */
public interface IParticipationConcourDAO {
    void participer(int idConcour , int idArbitre);
    void AnnulerParticipation (int idConcour , int idArbitre);
    boolean verifierParticipation (int idConcour , int idArbitre);
    
}
