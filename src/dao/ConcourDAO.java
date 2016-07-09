/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import IDao.IConcourDAO;
import com.mysql.jdbc.Connection;
import entities.Concour;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author ift
 */
public class ConcourDAO implements IConcourDAO {
PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ConcourDAO() {
         DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }

    @Override
    public void ajoutConcour(Concour Concour) {
try{
    String requete="INSERT INTO `concour`(`idconcour`,`lieu`, `dateConcour`) VALUES (?,?,?)";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setObject(1,null);
    preparedStatement.setObject(2,Concour.getDate());
    preparedStatement.setObject(3,Concour.getLieu());
    preparedStatement.executeUpdate(); 
        System.out.println("Insertion concour effectue");}
     catch(SQLException ex){
         Logger.getLogger(ConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    }  


    @Override
    public void modifConcour(Concour Concour) { try{
    String requete="UPDATE `concour` SET `lieu`=?,`dateConcour`=? WHERE `id_concour`=?";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setObject(2,Concour.getDate());
    preparedStatement.setObject(1,Concour.getLieu());
    preparedStatement.setObject(3,Concour.getIdConcour());

    
    preparedStatement.executeUpdate(); 
        System.out.println("Mise à jour effectue");}
     catch(SQLException ex){
         Logger.getLogger(ConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    } 

    @Override
    public void delete(int id) {  try{
        String sql = "DELETE FROM `concour` WHERE id_concour=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,id);

        preparedStatement.executeUpdate();  }
catch(SQLException ex){
         Logger.getLogger(ConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
          
         }
    }

    @Override
    public List<Concour> displayAll() {  
        ArrayList<Concour> listeUsers = new ArrayList<>();
        try {
            int i = 0;
            Concour c;
            String req = "SELECT * FROM `concour`";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c = new Concour(rs.getInt(1),rs.getDate(2),rs.getString(3));
                listeUsers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUsers;
    }

    @Override
    public List<Concour> chercherParID(int id) {  ArrayList<Concour> listeUsers = new ArrayList<>();
        try {
            int i = 0;
            Concour c;
            String req = "SELECT * FROM `concour` WHERE `idConcour`="+id+"";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                c = new Concour(rs.getInt(1),rs.getDate(4),rs.getString(2));
                listeUsers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUsers;
    }

}
