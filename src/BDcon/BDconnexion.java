
package BDcon;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDconnexion {
    public Connection DBcnx()
    {
        try 
        {
            String url="jdbc:mysql://localhost/gestion_covid19";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Connexion avec Succès !");
            return (Connection) conn;
        } 
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connexion échouée !");
            Logger.getLogger(BDconnexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
 
    
}
    
