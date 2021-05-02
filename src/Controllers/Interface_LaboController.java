
package Controllers;
import BDcon.BDconnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.testliste ;



public class Interface_LaboController implements Initializable {

    @FXML
    private AnchorPane a1;
    @FXML
    private AnchorPane a2;
    @FXML
    private ImageView img;
    @FXML
    private TextField tfdPrenom;
    @FXML
    private TextField tfdNom;
    @FXML
    private TextField tdfCin;
    @FXML
    private TextField tdfResultat;
    @FXML
    private TextField tdfDate;
    private PreparedStatement pst;
    ObservableList<models.testliste> oblisttest = FXCollections.observableArrayList();
    @FXML
    private TableView<models.testliste> tableTest;
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
    private Button btnAjout;
    @FXML
    private Button btnModif;
    @FXML
    private Button btnSupp;
    private BDconnexion cnx;
    @FXML
    private Button bthome;
    @FXML
    private ImageView img2;
    
    int index;
    @FXML
    private TableColumn<models.testliste, String> col_governorat;
    @FXML
    private TextField tfdLab;
    @FXML
    private TextField tfdGouver;
    @FXML
    private TableColumn<models.testliste, String> colNomLabo;
   


        public void fnct(String lab ){
         tfdLab.setText(lab);
         
         }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //String Labo;
        //Labo= tfdLab.getText();
         try {
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery  
         ("SELECT prenom, nom, cin, resultat, date, gouvernorat , nom_labo FROM test WHERE nom_labo='"+tfdLab.getText()+"' ");
            //("SELECT prenom, nom, cin, resultat, date,gouvernorat , nom_labo FROM test WHERE nom_labo="+Labo);
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
            col_governorat.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            colNomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));
            tableTest.setItems(oblisttest);
        
    }    

    @FXML
    private void Ajout(ActionEvent event) {
        
          PreparedStatement pst;
        String requete="INSERT INTO test ( prenom , nom , cin , resultat , date,gouvernorat , nom_labo)"
                + " VALUES ('"+tfdPrenom.getText()+"','"+tfdNom.getText()+"','"+tdfCin.getText()+"','"+tdfResultat.getText()+"','"+tdfDate.getText()+"','"+tfdGouver.getText()+"','"+tfdLab.getText()+"');";                              
        
        try
        {
           pst = cnx.DBcnx().prepareStatement(requete);
            pst.executeUpdate(requete);
            System.out.println(" Ajout avec succés !");
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Tuni-Covid");
                alert.setContentText("Ajout avec succés !");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout !");
        }
        
        
        tableTest.getItems().clear();
        
        try {
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery
            ("SELECT prenom, nom, cin, resultat, date ,gouvernorat , nom_labo FROM test WHERE nom_labo='"+tfdLab.getText()+"' ");
            
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
            col_governorat.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
             colNomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));

           

            tableTest.setItems(oblisttest); 
            
       tfdPrenom.setText("");
       tfdNom.setText("");
       tdfCin.setText("");
       tdfResultat.setText("");
       tdfDate.setText("");
       tfdGouver.setText("");
       

    }
   

    @FXML
    private void Modification(ActionEvent event) {
        
        PreparedStatement pst;
         String Rq =" UPDATE test SET prenom ='"+tfdPrenom.getText()+"',nom='"+tfdNom.getText()+"',cin='"+tdfCin.getText()+"',Resultat='"+tdfResultat.getText()+"',date='"+tdfDate.getText()+"',gouvernorat='"+tfdGouver.getText()+"', nom_labo='"+tfdLab.getText()+"' WHERE cin='"+tdfCin.getText()+"'";
         try
        {
            pst = cnx.DBcnx().prepareStatement(Rq);
            pst.executeUpdate(Rq);
            System.out.println("Test modifié avec succés !");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Tuni-Covid!");
                alert.setContentText("Test modifié avec succés !");
                alert.showAndWait();
        } catch (SQLException ex) {
            System.out.println("Erreur de modification !");
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Tuni-Covid!");
                alert.setContentText(" Erreur de modification!");
                alert.showAndWait();
        }
         
         
         
           tableTest.getItems().clear();
        
        try {
            cnx = new BDconnexion();
            ResultSet rs = cnx.DBcnx().createStatement().executeQuery
            ("SELECT prenom, nom, cin, resultat, date,gouvernorat ,nom_labo  FROM test WHERE nom_labo='"+tfdLab.getText()+"' " );
            
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
            col_governorat.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            colNomLabo.setCellValueFactory(new PropertyValueFactory<>("nom_labo"));
           

            tableTest.setItems(oblisttest); 
            
       tfdPrenom.setText("");
       tfdNom.setText("");
       tdfCin.setText("");
       tdfResultat.setText("");
       tdfDate.setText("");
       tfdGouver.setText("");
         

    }

    @FXML
    private void Suppression(ActionEvent event) {
                PreparedStatement pst;

                String x = tableTest.getSelectionModel().getSelectedItem().getNom();
                tableTest.getItems().removeAll(tableTest.getSelectionModel().getSelectedItem());
                String requete3="DELETE FROM test WHERE nom =?";
                     
                     
    
     try {
            pst = cnx.DBcnx().prepareStatement(requete3);
            pst.setString(1,x);
            
            pst.executeUpdate();
            
            System.out.println("Test supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
       tfdPrenom.setText("");
       tfdNom.setText("");
       tdfCin.setText("");
       tdfResultat.setText("");
       tdfDate.setText("");
        tfdGouver.setText("");
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
          Stage hm = new Stage();
        bthome.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }

    @FXML
    private void getTest(MouseEvent event) {
     
       index=  tableTest.getSelectionModel().getSelectedIndex();
        
        if(index <=-1){return ;}
        
        tfdPrenom.setText(colPrenom.getCellData(index));
         tfdNom.setText(colNom.getCellData(index));
        tdfCin.setText(colCin.getCellData(index));
        tdfResultat.setText(colResultat.getCellData(index));
        tdfDate.setText(colDate.getCellData(index));
        tfdGouver.setText(col_governorat.getCellData(index));
        


    }
    
}
