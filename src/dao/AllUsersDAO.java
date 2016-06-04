/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import entities.AllUsers;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
import java.util.ArrayList;

/**
 *
 * @author AD ZO
 */
public class AllUsersDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public AllUsersDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    public void ajouter(AllUsers u) {
        try {
            String req = "INSERT INTO `alluser`( `login`, `mdp`,`type`) VALUES (?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, u.getLogin());
            pst.setString(2, u.getMdp());
            pst.setString(3, u.getType());
            pst.executeUpdate();//Exécution de la requête
        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimer() {

        try {
            String req = "DELETE FROM `alluser` WHERE `id` = ?";
            pst = connection.prepareStatement(req);
            pst.setInt(1, AllUsers.modifiedUser.getId());
            pst.executeUpdate();
            System.out.println("User deleted");
        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean existe(AllUsers s) {
        try {
            AllUsers u = new AllUsers();
            int i = 0;

            String req = "SELECT * FROM `alluser` WHERE login = '" + s.getLogin() + "'";
            pst = connection.prepareStatement(req);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public AllUsers recherche(AllUsers s) {
        //AllUsers[] tab = new AllUsers[50];
        AllUsers u = new AllUsers();
        int i = 0;
        try {

            String req = "SELECT * FROM `alluser` WHERE login = '" + s.getLogin() + "'";
            pst = connection.prepareStatement(req);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                u = new AllUsers(rs.getInt(1), rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;

//        AllUsers u = new AllUsers();
//        try {
//
//            String req = "SELECT * FROM `alluser` WHERE login like 'testlog'";
//            pst = connection.prepareStatement(req);
//            //pst.setString(1, log);
//            ResultSet rs = pst.executeQuery();
//            u.setId(rs.getInt(1));
//            u.setLogin(rs.getString(2));
//            u.setMdp(rs.getString(3));
//            u.setType(rs.getString(4));
//            
//           // u = new AllUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
//        } catch (SQLException ex) {
//            System.out.println("Erreur recherche");
//            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return u;
    }

    public boolean modifierPassword(AllUsers u) {
        try {
            String req = "UPDATE `alluser` SET `mdp`=? WHERE `id` = ?;";
            pst = connection.prepareStatement(req);
            pst.setString(1, u.getMdp());
            pst.setInt(2, u.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     *
     */
    public ArrayList<AllUsers> afficherTout() {
        ArrayList<AllUsers> listeUsers = new ArrayList<AllUsers>();
        try {
            int i = 0;

            AllUsers u;

            String req = "SELECT * FROM `alluser`";
            pst = connection.prepareStatement(req);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                u = new AllUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

                listeUsers.add(u);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUsers;
    }

    public AllUsers verifier(String log, String pass) {

        try {
            String req = "SELECT * FROM `alluser` WHERE `login` like '" + log + "' and `mdp` like '" + pass + "'";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            AllUsers u;
            if (rs.next()) {
                u = new AllUsers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return u;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AllUsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
