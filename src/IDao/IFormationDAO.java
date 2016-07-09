
package IDao;

import java.util.List;


public interface IFormationDAO<Formation> {
    void ajoutFormation(Formation Formation);
    void modifFormation(Formation Formation);
    void delete(int id);
    List<Formation> displayAll();
    List<Formation> chercherParIN(String information, String value);
    
}
