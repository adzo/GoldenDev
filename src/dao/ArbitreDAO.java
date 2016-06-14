/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDao.InterfaceArbitreDAO;
import com.mysql.jdbc.Connection;
import entities.AllUsers;
import entities.Arbitre;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author AD ZO
 */
public class ArbitreDAO implements InterfaceArbitreDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ArbitreDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    @Override
    public boolean add(Arbitre a) {
//        java.util.Date myDate = a.getDateNaissance();
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        try { 
//            myDate = (Date)formatter.parse(myDate.toString());
//        } catch (ParseException ex) {
//            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        

        try {
            String req = "INSERT INTO `arbitre` (`idArbitre`) VALUES (?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, a.getIdArbitre());
            

            pst.executeUpdate();//Exécution de la requête
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete() {
        try {
            String req = "DELETE FROM `arbitre` WHERE `idArbitre` = ? ";
            pst = connection.prepareStatement(req);
            pst.setInt(1, AllUsers.modifiedUser.getId());
            pst.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Arbitre a) {
        return true;
    }

}
