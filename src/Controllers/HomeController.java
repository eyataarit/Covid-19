
package Controllers;

import BDcon.BDconnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class HomeController implements Initializable {

    private Button hop;
    @FXML
    private Button labo;
    @FXML
    private Button mini;
    @FXML
    private Label bienvenue;
    @FXML
    private ImageView home;
    @FXML
    private Label binomes;
    
    
    private BDconnexion cnx;
    private PreparedStatement pst;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      cnx= new BDconnexion();
    }    

   

    @FXML
    private void loginlabo(ActionEvent event) throws IOException {
        Stage stage_labo = new Stage();
        labo.getScene().getWindow().hide();
        Parent home_parent;
        home_parent = FXMLLoader.load(getClass().getResource("/FXML/Labo_Login.fxml"));
        Scene scene = new Scene(home_parent);
        stage_labo.setScene(scene);
        stage_labo.show();
        stage_labo.setResizable(false);
       
        
    }

    @FXML
    private void loginmini(ActionEvent event) throws IOException {
        
        Stage stage_mini = new Stage();
        mini.getScene().getWindow().hide();
        Parent home_parent;
        home_parent = FXMLLoader.load(getClass().getResource("/FXML/Ministere_Login.fxml"));
        Scene scene = new Scene(home_parent);
        stage_mini.setScene(scene);
        stage_mini.show();
        stage_mini.setResizable(false);
    }
    
}
