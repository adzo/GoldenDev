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
import java.sql.ResultSet;
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
        try {
            String req = "INSERT INTO `responsablead`(`idResponsable`) VALUES (?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, r.getIdResponsable());
            pst.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableAdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
    
    public String nomPrenomResponsableAD(int i){
        String nom =null;
        String prenom=null;
        String res;
        
        String req ="SELECT `nom`, `prenom` FROM `responsablead` WHERE `idResponsable` = ?";
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
