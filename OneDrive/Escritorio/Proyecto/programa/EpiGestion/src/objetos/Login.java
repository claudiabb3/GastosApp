
package objetos;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Claud
 */
public class Login {
    
    // instanciamos las clases necesarias para la consulta
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Connection acceso;
    
    
    // Metodo que mediante una consulta en la base de datos, comprobara
    // que el urusario y la contraseña existen.
    public Usuario varlidarUsuario(String nombre, String password){
        
        Usuario user = new Usuario();
        String sql = "select * from usuario where Nombre= '"+nombre+"' and Contraseña='"+password+"';";
    
        try{
            acceso = con.conectar();
            Statement st = acceso.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
            user.setIdUsuario(rs.getInt(1));
            user.setNombre(rs.getString(2));
            user.setPass(rs.getString(3));
            user.setDepartamento(rs.getString(4));
        
         }
        
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        return user;
    
    }
}
