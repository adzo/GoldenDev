package dao;

import com.mysql.jdbc.Connection;
import entities.Club;
import java.sql.PreparedStatement;
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
    
}
