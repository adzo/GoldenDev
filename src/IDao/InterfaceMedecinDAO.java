/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDao;

import entities.Medecin;

/**
 *
 * @author AD ZO
 */
public interface InterfaceMedecinDAO {
    public boolean add(Medecin m);
    public boolean delete(Medecin m);
    public boolean update(Medecin m);
}
