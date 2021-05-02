
package Controllers;

import BDcon.BDconnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Labo_LoginController implements Initializable {

    @FXML
    private AnchorPane Anch;
    @FXML
    private Label lblCnxLabo;
    @FXML
    private TextField idLabo;
    @FXML
    private PasswordField mdpLabo;
    @FXML
    private ImageView img;
    
    private BDconnexion cnx;
    private PreparedStatement pst;
    
    @FXML
    private Button btnhompg;
    @FXML
    private ImageView imghom;
    @FXML
    private Button btLabo;

 /*  public String idlab= idLabo.getText();
   
   public String getIdLab(){
       return idlab;
   }*/
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cnx = new BDconnexion();
    }    

 
  
 @FXML
    private void LoginOnAction(ActionEvent event) throws IOException {
        String req = "SELECT * FROM respo_labo  WHERE idLabo=? AND mdpLabo=?";
        try {
            pst = cnx.DBcnx().prepareStatement(req);
            pst.setString(1, idLabo.getText());
            pst.setString(2, mdpLabo.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
             System.out.println("Connexion avec succés");
            Stage stage_labo = new Stage();
            btLabo.getScene().getWindow().hide();
            //Parent home_parent;
            //home_parent = FXMLLoader.load(getClass().getResource("/FXML/Interface_Labo.fxml"));
                 FXMLLoader x  = new FXMLLoader(getClass().getResource("/FXML/Interface_Labo.fxml"));
                Parent rootA = (Parent )x.load();
                Interface_LaboController Lab = x.getController();
                Lab.fnct(idLabo.getText());
            Scene scene = new Scene(rootA);
            stage_labo.setScene(scene);
            stage_labo.show();
            stage_labo.setResizable(false);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Veuillez vérifier votre Identifiant et votre Mot de passe !");
                alert.showAndWait();
            }
            
        } catch (SQLException ex) {
        }
        
        finally
        {
            try {
                cnx.DBcnx().close();
            } catch (SQLException ex) {
            }
        }
    
    }   
    
    
    
    
    @FXML
    private void hompg(ActionEvent event) throws IOException {
         Stage hm = new Stage();
        btnhompg.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }

   
    
}
