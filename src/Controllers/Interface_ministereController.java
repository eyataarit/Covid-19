package Controllers;
import BDcon.BDconnexion;
import Controllers. Labo_LoginController;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.testliste;

public class Interface_ministereController implements Initializable {
     
    
    
    private BDconnexion cnx;
    ObservableList<models.testliste> oblisttest = FXCollections.observableArrayList();
  
    @FXML
    private TableColumn<models.testliste, String> col_nomLabo;
    @FXML
    private TableColumn<models.testliste, String> colPrenom;
    @FXML
    private TableColumn<models.testliste, String> colNom;
    @FXML
    private TableColumn<models.testliste, String> colCin;
    @FXML
    private TableColumn<models.testliste, String> colResultat;
    @FXML
    private TableColumn<models.testliste, String> colDate;
    
    
    
    
    @FXML
    private Label lblmini;
    @FXML
    private AnchorPane aa;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private Label lb;    
    @FXML
    private Button btretour;
    @FXML
    private Button btPositif;
    @FXML
    private Button btNegatif;
    @FXML
    private Button btnStat;
    @FXML
    private TableView<models.testliste> table;
    @FXML
    private TableColumn<?, ?> colGouv;
    @FXML
    private ImageView map;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list= FXCollections.observableArrayList("Ariana","Beja","Ben Arous", "Bizerte","Gabes","Gafsa","Jendouba","Kairouan","Kasserine","Kebili","Kef",
                "Mahdia","Manouba", "Mednine","Monastir","Nabeul","Sfax","Sidi BouZid","Siliana","Sousse","Tataouine","Tozeur","Tunis","Zaghouan"); 
        combo.setItems(list);
        
        
        try {
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT prenom, nom, cin, resultat, date, gouvernorat , nom_labo FROM test ");
            while(rs.next())
            {
                oblisttest.add(new testliste( rs.getString("prenom"), rs.getString("nom"), rs.getString("cin"), 
                                        rs.getString("resultat"), rs.getString("date"),rs.getString("gouvernorat"),rs.getString("nom_labo")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Interface_LaboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            colResultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_nomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));
           colGouv.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            table.setItems(oblisttest);
  
    }    
    

    @FXML
    private void Select(ActionEvent event) {
        String s=combo.getSelectionModel().getSelectedItem().toString();
        lb.setText(s);
         table.getItems().clear();
     try {
         
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT prenom, nom, cin, resultat, date, gouvernorat , nom_labo FROM test WHERE gouvernorat= '"+combo.getSelectionModel().getSelectedItem()+"' " );
            while(rs.next())
            {
                oblisttest.add(new testliste( rs.getString("prenom"), rs.getString("nom"), rs.getString("cin"), 
                                        rs.getString("resultat"), rs.getString("date"),rs.getString("gouvernorat"),rs.getString("nom_labo")));
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(Interface_LaboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            colResultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_nomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));
            colGouv.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            table.setItems(oblisttest);     
        
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Stage hm = new Stage();
        btretour.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/Ministere_Login.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }

    @FXML
    private void Positif(ActionEvent event) {       
 
     table.getItems().clear();
     try {
         
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT prenom, nom, cin, resultat, date, gouvernorat , nom_labo FROM test WHERE upper(resultat) ='POSITIF'");
            while(rs.next())
            {
                oblisttest.add(new testliste( rs.getString("prenom"), rs.getString("nom"), rs.getString("cin"), 
                                        rs.getString("resultat"), rs.getString("date"),rs.getString("gouvernorat"),rs.getString("nom_labo")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Interface_LaboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            colResultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_nomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));
            colGouv.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            table.setItems(oblisttest);     
        
    }
    @FXML
    private void Stat(ActionEvent event) throws IOException {
              Stage hm = new Stage();
        btnStat.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/stat.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
        
    }

    @FXML
    private void Negatif(ActionEvent event) {
        table.getItems().clear();
     try {
         
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT prenom, nom, cin, resultat, date, gouvernorat , nom_labo FROM test WHERE upper(resultat) ='NEGATIF'");
            while(rs.next())
            {
                oblisttest.add(new testliste( rs.getString("prenom"), rs.getString("nom"), rs.getString("cin"), 
                                        rs.getString("resultat"), rs.getString("date"),rs.getString("gouvernorat"),rs.getString("nom_labo")));
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Interface_LaboController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            colCin.setCellValueFactory(new PropertyValueFactory<>("cin"));
            colResultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            col_nomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));
            colGouv.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            table.setItems(oblisttest);     
    }
    
    
}
