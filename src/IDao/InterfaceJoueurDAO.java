/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDao;

import entities.Joueur;

/**
 *
 * @author AD ZO
 */
public interface InterfaceJoueurDAO {
    public boolean add(Joueur j);
    public boolean delete();
    public boolean update(Joueur j);
}
