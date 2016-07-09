/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDao;

import entities.Arbitre;

/**
 *
 * @author AD ZO
 */
public interface InterfaceArbitreDAO {
    public boolean add(Arbitre a);
    public boolean delete();
    public boolean update(Arbitre a);
    public void modifGRAD(Arbitre a);
}
