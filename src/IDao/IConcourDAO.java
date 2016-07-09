/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package IDao;

import entities.Concour;
import java.util.List;

/**
 *
 * @author ift
 */
public interface IConcourDAO {
      void ajoutConcour(Concour Concour);
    void modifConcour(Concour Concour );
    void delete(int id);
    List<Concour> displayAll();
    List<Concour> chercherParID(int id);
    
}
