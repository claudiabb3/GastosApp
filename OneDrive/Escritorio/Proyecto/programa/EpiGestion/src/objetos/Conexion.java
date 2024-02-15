
package objetos;
/**
 *
 * @author Claud
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    
    Connection con;
    
    public Connection conectar() throws ClassNotFoundException, SQLException{
      Class.forName("com.mysql.cj.jdbc.Driver");
             con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionepi","root","");
              
           
        return con;
   
   
    }
    
    
    
}
