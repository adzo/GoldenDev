/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDao;

import entities.User;
import java.util.ArrayList;

/**
 *
 * @author AD ZO
 */
public interface InterfaceUserDAO {
    public boolean add(User u);
    public boolean delete();
    public boolean update(User u);
    public User search(int i);
    public ArrayList<User> afficherTout();
}
