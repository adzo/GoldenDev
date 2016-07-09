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
public interface IParticipationDAO {
    void participer(int idFormation , int idArbitre);
    void AnnulerParticipation (int idFormation, int idArbitre);
    boolean verifierParticipation (int idFormation , int idArbitre);
    
}
