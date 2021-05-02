
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

public class Ministere_LoginController implements Initializable {

    @FXML
    private AnchorPane Anch;
    @FXML
    private TextField idMini;
    @FXML
    private PasswordField mdpMini;
    @FXML
    private Button btnMini;
    @FXML
    private ImageView img;
    
     private BDconnexion cnx;
    private PreparedStatement pst;
    @FXML
    private Button btnhomepag;
    @FXML
    private ImageView imghome;
    @FXML
    private Label tunicovid;
    @FXML
    private Label descri;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cnx = new BDconnexion();
    }    

    @FXML
    private void loginActionMinistere(ActionEvent event) throws IOException {
         String req = "SELECT * FROM Respo_ministere  WHERE idMini=? AND mdpMini=?";
        try {
            pst = cnx.DBcnx().prepareStatement(req);
            pst.setString(1, idMini.getText());
            pst.setString(2, mdpMini.getText());
            
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while(rs.next())
            {
                count++;
            }
            
            if (count==1)
            {
                System.out.println("Connexion avec succés");
                
                Stage loginLab = new Stage();
                btnMini.getScene().getWindow().hide();
                Parent rootA;
                rootA = FXMLLoader.load(getClass().getResource("/FXML/Interface_ministere.fxml"));
                Scene scene = new Scene(rootA);
                loginLab.setScene(scene);
                loginLab.show();
                loginLab.setResizable(false);
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
    private void homepag(ActionEvent event) throws IOException {
        Stage hm = new Stage();
        btnhomepag.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
        Scene scene = new Scene(root1);
        hm.setScene(scene);
        hm.show();
        hm.setResizable(false);
    }
        
    }
    

