/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import IDao.IParticipationDAO;
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
public class ParticipationDAO implements IParticipationDAO{
PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ParticipationDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    @Override
    public void participer(int idFormation, int idArbitre){
try{
    String requete="INSERT INTO `participation`(`idParticipation`, `idArbitre`, `idFormation`) VALUES (?,?,?)";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
    preparedStatement.setObject(1,null);
    preparedStatement.setObject(2,idArbitre);
    preparedStatement.setObject(3,idFormation);
    preparedStatement.executeUpdate(); 
        System.out.println("Participation éffectué");}
     catch(SQLException ex){
         Logger.getLogger(ParticipationDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    }  

    @Override
    public void AnnulerParticipation(int idForamtion , int idArbitre) {
            try{
        String sql = "DELETE FROM `participation` WHERE idFormation=? and idArbitre=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,idForamtion);
        preparedStatement.setObject(2,idArbitre);


        preparedStatement.executeUpdate();  }
catch(SQLException ex){
         Logger.getLogger(FormationDAO.class.getName()).log(Level.SEVERE, null, ex);
          
         }
    }

    @Override
    public boolean verifierParticipation(int idFormation, int idArbitre) {
        int nb = 0;
        try{
    String requete="SELECT count(*)  AS cnt from `participation` WHERE  `idArbitre`="+idArbitre+" AND `idFormation`="+idFormation+";";
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
         Logger.getLogger(ParticipationDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    
    return false;
    }
    
}
