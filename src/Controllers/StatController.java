
package Controllers;

import BDcon.BDconnexion;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;
import models.testliste;

public class StatController implements Initializable {
    private BDconnexion cnx;
    @FXML
    private Pane paneView;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
       try {
         
         cnx = new BDconnexion();
         ResultSet rs = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT COUNT(*) FROM test WHERE upper(resultat) ='NEGATIF'");
        int  val =  ((Number) rs.getObject(1)).intValue();
        ResultSet rs1 = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT COUNT(*) FROM test WHERE upper(resultat) ='POSITIF'");
        int  val1 =  ((Number) rs.getObject(1)).intValue();
           
        } catch (SQLException ex) {
            Logger.getLogger(Interface_LaboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        loadData();
    }
       
    
    
        private void loadData(){
            int x=60;
            int y=40;
            paneView.getChildren().clear();
            ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
             list.add(new PieChart.Data("Negatif",y));
            list.add(new PieChart.Data("Positif",x));
            PieChart statics=new PieChart(list);
            statics.setTitle("Statistiques des cas covid ");
            paneView.getChildren().add(statics);
            
        }
           
    
    
}
