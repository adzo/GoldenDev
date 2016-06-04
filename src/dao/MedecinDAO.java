/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDao.InterfaceMedecinDAO;
import com.mysql.jdbc.Connection;
import entities.Medecin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author AD ZO
 */
public class MedecinDAO implements InterfaceMedecinDAO{

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public MedecinDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    
    @Override
    public boolean add(Medecin m) {
        try {
            String req = "INSERT INTO `medecin` VALUES (?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1,m.getIdMedecin() );
            pst.setString(2,m.getNom() );
            pst.setString(3, m.getPrenom() );
            pst.setObject(4, m.getDateNaissance() );
            pst.setInt(5, m.getCin() );
            pst.setString(6, m.getAdresse());
            pst.executeUpdate();//Exécution de la requête
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Medecin m) {
    return true;
    }

    @Override
    public boolean update(Medecin m) {
    
        return true;
    }
    
}
