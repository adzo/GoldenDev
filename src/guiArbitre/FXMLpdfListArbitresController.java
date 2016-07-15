/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiArbitre;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ArbitreDAO;
import entities.Arbitre;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ift
 */
public class FXMLpdfListArbitresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField  nFile ;
    
    
    public void filePdf() throws Exception{
       ArrayList<Arbitre> lst = new ArrayList<>();
       ArbitreDAO ad = new ArbitreDAO();
      lst = ad.afficherTout();
      String rs;
      int i=0 ; 
       
    Document document=new Document();
PdfWriter.getInstance(document,new FileOutputStream(nFile.getText()+".pdf")); 
document.open();
 for (Arbitre a : lst) {
            System.out.println(a);
            rs =a.toString();
            i++;
            document.add(new Paragraph(i+":"+rs));
        }

document.close(); }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
