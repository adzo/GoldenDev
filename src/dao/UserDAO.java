/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDao.InterfaceUserDAO;
import com.mysql.jdbc.Connection;
import entities.AllUsers;
import entities.User;
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
public class UserDAO implements InterfaceUserDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public UserDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    @Override
    public boolean add(User u) {
        try {
            String req = "INSERT INTO `user`(`idUser`, `nom`, `prenom`, `cin`, "
                    + "`dateNaissance`, `adresse`, `tel`, `mail`) VALUES "
                    + "(?,?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, u.getIdUser());
            pst.setString(2, u.getNom());
            pst.setString(3, u.getPrenom());
            pst.setInt(4, u.getCin());
            pst.setObject(5, u.getDateNaissance());
            pst.setString(6, u.getAdresse());
            pst.setInt(7, u.getTel());
            pst.setString(8, u.getMail());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete() {
        try {
            String req = "DELETE FROM `user` WHERE `idUser` = ?";
            AllUsersDAO p = new AllUsersDAO();
            pst = connection.prepareStatement(req);
            pst.setInt(1, AllUsers.modifiedUser.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(User u) {
        try {
            String req = "UPDATE `user` SET `nom`=?,"
                    + "`prenom`=?,`cin`=?,`dateNaissance`=?,"
                    + "`adresse`=?,`tel`=?,`mail`=? "
                    + "WHERE `idUser` = ?";
            pst = connection.prepareStatement(req);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setInt(3, u.getCin());
            pst.setObject(4, u.getDateNaissance());
            pst.setString(5, u.getAdresse());
            pst.setInt(6, u.getTel());
            pst.setString(7, u.getMail());
            pst.setInt(8, AllUsers.modifiedUser.getId());
            pst.executeQuery();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User search(User u) {
        
        return u;
    }

    @Override
    public ArrayList<User> afficherTout() {
        ArrayList<User> listeUsers = new ArrayList<>();
        try {
            int i = 0;
            User u;
            String req = "SELECT * FROM `user`";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getInt(7) , rs.getString(8));
                listeUsers.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUsers;
    }
    
    public String nomPrenomUser(int i){
        String nom =null;
        String prenom=null;
        String res;
        
        String req ="SELECT  `nom`, `prenom` FROM `user` WHERE `idUser` = ?";
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
    
}
