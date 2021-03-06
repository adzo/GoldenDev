/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDao.InterfaceMedecinDAO;
import com.mysql.jdbc.Connection;
import entities.AllUsers;
import entities.Medecin;
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
public class MedecinDAO implements InterfaceMedecinDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public MedecinDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    @Override
    public boolean add(Medecin m) {
        try {
            String req = "INSERT INTO `medecin` (`idMedecin`, `nom`, `prenom`, `dateNaissance`, `cin`, `adresse`)  VALUES (?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, m.getIdMedecin());
            pst.setString(2, m.getNom());
            pst.setString(3, m.getPrenom());
            pst.setObject(4, m.getDateNaissance());
            pst.setInt(5, m.getCin());
            pst.setString(6, m.getAdresse());

            pst.executeUpdate();//Exécution de la requête
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete() {
        try {
            String req = "DELETE FROM `medecin` WHERE `idMedecin` =  ? ";
            pst = connection.prepareStatement(req);
            pst.setInt(1, AllUsers.modifiedUser.getId());
            pst.executeUpdate(); //execution de la requête...

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Medecin m) {
try {
            String req = "UPDATE `medecin` SET `nom`=?,"
                    + "`prenom`=?,`dateNaissance`=?,`cin`=?,"
                    + "`adresse`=?"
                    + "WHERE `idMedecin` = ?";
            pst = connection.prepareStatement(req);
            pst.setString(1, m.getNom());
            pst.setString(2, m.getPrenom());
             pst.setObject(3, m.getDateNaissance());
            pst.setInt(4, m.getCin());
            pst.setString(5, m.getAdresse());
            pst.setInt(6, AllUsers.modifiedUser.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String nomPrenomMedecin(int i) {
        String nom = null;
        String prenom = null;
        String res;

        String req = "SELECT `nom`, `prenom` FROM `medecin` WHERE `idMedecin` = ?";
        try {
            pst = connection.prepareStatement(req);

            pst.setInt(1, i);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nom = rs.getString(1);
                prenom = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nom == null) {
            nom = "not defined";
        }

        if (prenom == null) {
            prenom = "not defined";
        }
        res = nom + ", " + prenom;
        return res;
    }

    public ArrayList<Medecin> afficherTout() {
        ArrayList<Medecin> liste = new ArrayList<>();
        Medecin m;
        try {

            String req = "SELECT * FROM `medecin` ";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                m = new Medecin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6));
                liste.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }

    public Medecin getMedecin(int idMedecin) {
        Medecin m = new Medecin();
        try {
            String req = "SELECT * FROM `medecin` WHERE `idMedecin` = ?";
            pst = connection.prepareStatement(req);
            pst.setInt(1, idMedecin);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
            m = new Medecin(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4) ,rs.getInt(5),rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
 
}
