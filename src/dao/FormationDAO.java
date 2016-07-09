/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import IDao.IFormationDAO;
import com.mysql.jdbc.Connection;
import entities.Formation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import static javax.management.Query.value;
import static javax.management.Query.value;
import utils.DataSource;

/**
 *
 * @author ift
 */
public class FormationDAO implements IFormationDAO<Formation> {
 PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public FormationDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    @Override
    public void ajoutFormation(Formation Formation) {
try{
    String requete="INSERT INTO `formation`(`idFormation`,`nom`, `lieu`, `dateOuverture`, `dateFermeture`) VALUES (?,?,?,?,?)";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setObject(1,null);
    preparedStatement.setObject(2,Formation.getNom());
    preparedStatement.setObject(3,Formation.getLieu());
    preparedStatement.setObject(4,Formation.getDateOuverture());
    preparedStatement.setObject(5,Formation.getDateFermeture());
    preparedStatement.executeUpdate(); 
        System.out.println("Insertion effectue");}
     catch(SQLException ex){
         Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    }  

    @Override
    public void modifFormation(Formation Formation) {
        try{
    String requete="UPDATE `formation` SET `nom`=?,`lieu`=?,`dateOuverture`=?,`dateFermeture`=? WHERE `idFormation`=?";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setObject(5,Formation.getIdFormation());
    preparedStatement.setObject(1,Formation.getNom());
    preparedStatement.setObject(2,Formation.getLieu());
    preparedStatement.setObject(3,Formation.getDateOuverture());
    preparedStatement.setObject(4,Formation.getDateFermeture());
    
    preparedStatement.executeUpdate(); 
        System.out.println("Mise à jour effectue");}
     catch(SQLException ex){
         Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    } 
    

    @Override
    public void delete(int id) {
        try{
        String sql = "DELETE FROM `formation` WHERE idFormation=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,id);

        preparedStatement.executeUpdate();  }
catch(SQLException ex){
         Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
          
         }
    }

    @Override
    public List<Formation> displayAll() {
        ArrayList<Formation> listeUsers = new ArrayList<>();
        try {
            int i = 0;
            Formation f;
            String req = "SELECT * FROM `formation`";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                f = new Formation(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getDate(5));
                listeUsers.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeUsers;
    }

    @Override
    public List<Formation> chercherParIN(String information,String value) {
       List<Formation> formations = new ArrayList<>();

       try{
        String sql = "SELECT * FROM `formation` WHERE "+ information+ " like '"+value+"%'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Formation formation=new Formation(
                    resultSet.getInt("idFormation"),
                    resultSet.getString("nom"),
                    resultSet.getString("lieu"),
                    resultSet.getDate("dateOuverture"),
                    resultSet.getDate("dateFermeture")
                );
            formations.add(formation);
                                  }
             }   
         catch(SQLException ex){
         Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
     
         }return formations;
    }
    
}

