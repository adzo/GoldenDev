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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public String nomPrenomJoueur(int i){
        String nom =null;
        String prenom=null;
        String res;
        
        String req ="SELECT  `nom`, `prenom` FROM `joueur` WHERE `idJoueur` = ?";
        try {
            pst=connection.prepareStatement(req);
        
        pst.setInt(1,i);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
                nom = rs.getString(1);
                prenom = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (nom == null) nom ="not defined";
        
        if (prenom == null) prenom = "not defined";
        res = nom + ", "+prenom;
        return res;
    }
    
     public ArrayList<Joueur> afficherTout() {
        ArrayList<Joueur> liste = new ArrayList<>();
        Joueur j;
        try {

            String req = "SELECT * FROM `joueur` ";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                j = new Joueur(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
                liste.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
    
}
