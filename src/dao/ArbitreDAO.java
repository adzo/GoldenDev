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
public class ArbitreDAO implements InterfaceArbitreDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ArbitreDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    public boolean addAll(Arbitre a){
    
        try {
            String req = "INSERT INTO `arbitre` VALUES (?,?,?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setInt(1, a.getIdArbitre());
            pst.setString(2, a.getNom());
            pst.setString(3, a.getPrenom());
            pst.setObject(4, a.getDateNaissance());
            pst.setInt(5, a.getCin());
            pst.setString(6, a.getAdresse());
            pst.setString(7, a.getCategorie());

            pst.executeUpdate();//Exécution de la requête
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
    public boolean update(Arbitre Arbitre) {
        try{
    String requete="UPDATE `arbitre` SET `idArbitre`=? ,`nom`=?,"
            + "`prenom`=?,`dateNaissance`=?,`cin`=?,`adresse`=?,"
            + "`categArbitre`=? WHERE `idArbitre`=? ";
    PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setObject(1,Arbitre.getIdArbitre());

    preparedStatement.setObject(2,Arbitre.getNom());
    preparedStatement.setObject(3,Arbitre.getPrenom());


    preparedStatement.setObject(4,Arbitre.getDateNaissance());
    preparedStatement.setObject(5,Arbitre.getCin());
    preparedStatement.setObject(6,Arbitre.getAdresse());

    preparedStatement.setObject(7,Arbitre.getCategorie());
            preparedStatement.setObject(8,Arbitre.getIdArbitre());


    preparedStatement.executeUpdate(); 
        System.out.println("Mise à jour effectue");}
     catch(SQLException ex){
         Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
     }     
        return true;
    }

    public String nomPrenomArbitre(int i){
        String nom =null;
        String prenom=null;
        String res;
        
        String req ="SELECT  `nom`, `prenom` FROM `arbitre` WHERE `idArbitre` = ?";
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
      public ArrayList<Arbitre> afficherTout() {
        ArrayList<Arbitre> liste = new ArrayList<>();
        Arbitre a;
        try {

            String req = "SELECT * FROM `arbitre` ";
            pst = connection.prepareStatement(req);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                a = new Arbitre(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6),rs.getString(7));
                liste.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }
       public Arbitre getArbitre(int idArbitre) {
        Arbitre a = new Arbitre();
        try {
            String req = "SELECT * FROM `medecin` WHERE `idArbitre` = ?";
            pst = connection.prepareStatement(req);
            pst.setInt(1, idArbitre);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
            a = new Arbitre(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getDate(4) ,rs.getInt(5),rs.getString(6),rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    @Override
    public void modifGRAD(Arbitre Arbitre) {
           try{
    String requete="UPDATE `arbitre` SET `categArbitre`=?  WHERE `idArbitre`=? ";
        PreparedStatement preparedStatement;
    preparedStatement = connection.prepareStatement(requete);
       preparedStatement.setObject(1,Arbitre.getCategorie());
            preparedStatement.setObject(2,Arbitre.getIdArbitre());


    preparedStatement.executeUpdate(); 
        System.out.println("Mise à jour effectue");}
     catch(SQLException ex){
         Logger.getLogger(ArbitreDAO.class.getName()).log(Level.SEVERE, null, ex);
     }    
    }
}
