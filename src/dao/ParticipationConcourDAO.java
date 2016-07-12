/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import IDao.IParticipationConcourDAO;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author ift
 */
public class ParticipationConcourDAO implements IParticipationConcourDAO{
PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ParticipationConcourDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    @Override
    public void participer(int idConcour, int idArbitre){
try{
    String requete="INSERT INTO `participationConcour`(`idParticipationConcour`, `idArbitre`, `idConcour`) VALUES (?,?,?)";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setObject(1,null);
    preparedStatement.setObject(2,idArbitre);
    preparedStatement.setObject(3,idConcour);
    preparedStatement.executeUpdate(); 
        System.out.println("Participation éffectué");}
     catch(SQLException ex){
         Logger.getLogger(ParticipationConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    }  

    @Override
   public void AnnulerParticipation(int idConcour , int idArbitre) {
            try{
        String sql = "DELETE FROM `participationConcour` WHERE idConcour=? and idArbitre=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,idConcour);
        preparedStatement.setObject(2,idArbitre);


        preparedStatement.executeUpdate();  }
catch(SQLException ex){
         Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
          
         }
    }


    @Override
    public boolean verifierParticipation(int idConcour, int idArbitre) {
        int nb = 0;
        try{
    String requete="SELECT count(*)  AS cnt from `participationConcour` WHERE  `idArbitre`="+idArbitre+" AND `idConcour`="+idConcour+";";
    Statement statement;
    statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(requete);
        resultSet.next();
       nb=resultSet.getInt("cnt");
       if(nb<1){
        System.out.println("Participation éffectué");
        return true;
       }
        
        
        }
     catch(SQLException ex){
         Logger.getLogger(ParticipationConcourDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    
    return false;
    }
    
}
