package dao;

import com.mysql.jdbc.Connection;
import entities.Club;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void ajouter(Club c){
        try {
            String req = "INSERT INTO `club`( `nom`, `adress`) VALUES (?,?)";
            pst = connection.prepareStatement(req);
            pst.setString(1, c.getNomClub());
            pst.setString(2, c.getAdresseClub());
            pst.executeUpdate();//Exécution de la requête
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
}
