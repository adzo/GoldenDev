/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import entities.AllUsers;
import entities.CompteRendu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author mohamedaziz
 */
public class CompteRenduDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public CompteRenduDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    public boolean ajout(CompteRendu cr) {
        try {
            String req = "INSERT INTO `compterendu`(`idMedecin`, `idJoueur`, `resultatTest`, `observation`,`Date`) VALUES (?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, cr.getIdMedecin());
            pst.setInt(2, cr.getIdJoueur());

            if (cr.isResultatTest()) {
                pst.setString(3, "positif");
            } else {
                pst.setString(3, "negatif");
            }

            pst.setString(4, cr.getObservation());
            pst.setObject(5, cr.getDate());
            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompteRenduDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<CompteRendu> getCompteRendu() {
        ArrayList<CompteRendu> liste = new ArrayList<>();
        CompteRendu cr;
        String req;
        if (AllUsers.connected.getType().equals("medecin")){
            req = "SELECT * FROM `compterendu` WHERE `idMedecin` = "+AllUsers.connected.getId();
        }else{
            req = "SELECT * FROM `compterendu`";
        }
        
        try {
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                boolean state;
                if (rs.getString(4).equals("positif")) {
                    state = true;
                } else {
                    state = false;
                }
                cr = new CompteRendu(rs.getInt(1), rs.getInt(2), rs.getInt(3), state, rs.getString(5),rs.getDate(6));
                liste.add(cr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteRenduDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
}
