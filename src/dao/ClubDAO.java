package dao;

import com.mysql.jdbc.Connection;
import entities.Club;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

public class ClubDAO {

    PreparedStatement pst; //l'entité qui gère la requête
    Connection connection;

    public ClubDAO() {
        DataSource ds = DataSource.getInstance();
        connection = ds.getConnection();
    }
    
    public boolean ajouter(Club c){
        try {
            String req = "INSERT INTO `club`( `nomClub`, `adresseClub`, `dateFondation`, "
                    + "`telephoneClub`, `presidentClub`) VALUES (?,?,?,?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, c.getNomClub());
            pst.setString(2, c.getAdresseClub());
            pst.setObject(3, c.getDateFondation());
            pst.setInt(4, c.getTelephoneClub());
            pst.setString(5,c.getPresidentClub());
            pst.executeUpdate();//Exécution de la requête
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Club getClub(int id){
        ResultSet rs = null;
        Club c = new Club();
        try {
            
            String req ="SELECT * FROM `club` WHERE `idClub` = ?";
            pst = connection.prepareStatement(req);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            while(rs.next()){
                c = new Club(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return c;
    }
    
    public ArrayList<Club> getAll(){
      Club c = new Club();
      ArrayList<Club> liste = new ArrayList<>();
        try {
            String req ="SELECT * FROM `club` WHERE 1";
            pst = connection.prepareStatement(req);
           
           ResultSet rs = pst.executeQuery();
            while(rs.next()){
                c = new Club(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getInt(5), rs.getString(6));
                liste.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return liste;
    }
}
