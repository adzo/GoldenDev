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
import java.util.ArrayList;
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
      
         try {
            String req = "UPDATE `responsablead` SET `nom`=?,"
                    + "`prenom`=?,`dateNaissance`=?,`cin`=?,"
                    + "`adresse`=?,`telephone`=? "
                    + "WHERE `idResponsable` = ?";
            pst = connection.prepareStatement(req);
            pst.setString(1, r.getNom());
            pst.setString(2, r.getPrenom());
             pst.setObject(3,r.getDateNaissance());
            pst.setInt(4, r.getCin());
            pst.setString(5, r.getAdresse());
            pst.setInt(6, r.getTelephone());
            pst.setInt(7, AllUsers.modifiedUser.getId());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
      public ArrayList<ResponsableAd> afficherTout() {
        ArrayList<ResponsableAd> liste = new ArrayList<>();
        ResponsableAd r;
        try {

            String req = "SELECT * FROM `responsablead`";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                r = new ResponsableAd(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6),rs.getInt(7));
                liste.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResponsableAdDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
          public ResponsableAd search(int idResponsable) {
        ResponsableAd r = new ResponsableAd();
        try {
            String req = "SELECT * FROM `responsablead` WHERE `idResponsable` = ? ";
            pst = connection.prepareStatement(req);
            pst.setInt(1,idResponsable);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                r = new ResponsableAd(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
}
