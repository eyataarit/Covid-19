
package gestion_covid19;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Gestion_Covid19 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();
        
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
