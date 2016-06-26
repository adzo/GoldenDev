/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import entities.CompteRendu;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    public boolean ajout(CompteRendu cr){
        try {
            String req = "INSERT INTO `compterendu`(`idMedecin`, `idJoueur`, `resultatTest`, `observation`) VALUES (?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, cr.getIdMedecin());
            pst.setInt(2, cr.getIdJoureur());
            pst.setBoolean(3, cr.isResultatTest());
            pst.setString(4, cr.getObservation());
            pst.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CompteRenduDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
