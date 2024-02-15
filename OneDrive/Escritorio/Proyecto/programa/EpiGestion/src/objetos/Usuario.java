
package objetos;

/**
 *
 * @author Claud
 */
public class Usuario {
    
    private int idUsuario;
    private String nombre;
    private String pass;
    private String departamento;

    public Usuario() {
    }

    public Usuario(String nombre, String pass, String departamento) {
        this.nombre = nombre;
        this.pass = pass;
        this.departamento = departamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", pass=" + pass + ", departamento=" + departamento + '}';
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
}
