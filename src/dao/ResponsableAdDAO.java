/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import IDao.InterfaceResponsableAD;
import com.mysql.jdbc.Connection;
import entities.AllUsers;
import entities.ResponsableAd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author AD ZO
 */
public class ResponsableAdDAO implements InterfaceResponsableAD {
    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ResponsableAdDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    
    @Override
    public boolean add(ResponsableAd r){
        return true;
    }
    
    @Override
    public boolean delete(){
        try {
            String req = "DELETE FROM `responsablead` WHERE `idResponsable` = ?";
            pst = connection.prepareStatement(req);
            pst.setInt(1, AllUsers.modifiedUser.getId());
            pst.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableAdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public boolean update(ResponsableAd r){
        return true;
    }
    
    
}
