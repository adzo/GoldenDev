/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDao.InterfaceJoueurDAO;
import entities.AllUsers;
import entities.Joueur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author AD ZO
 */
public class JoueurDAO implements InterfaceJoueurDAO {
    
    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public JoueurDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    @Override
    public boolean add(Joueur j) {
        try {
            String req = "INSERT INTO `joueur`(`idJoueur`) VALUES (?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, j.getIdJoueur());
            pst.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete() {
        
        try {
            String req = "DELETE FROM `joueur` WHERE `idJoueur` = ?";
            pst = connection.prepareStatement(req);
            pst.setInt(1,AllUsers.modifiedUser.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JoueurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Joueur j) {
    return true;
    }
    
}
