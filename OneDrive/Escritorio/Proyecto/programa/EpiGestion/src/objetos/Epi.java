
package objetos;
/**
 * @author Claud
 */
public class Epi {
    
    private int idEpi;
    private String descripcion;
    private String talla;
    private int unidades;

    public Epi() {
    }

    public Epi( String descripcion, String talla, int unidades) {
        this.descripcion = descripcion;
        this.talla = talla;
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Epi{" + "idEpi=" + idEpi + ", descripcion=" + descripcion + ", talla=" + talla + ", unidades=" + unidades + '}';
    }

    public int getIdEpi() {
        return idEpi;
    }

    public void setIdEpi(int idEpi) {
        this.idEpi = idEpi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    
}
