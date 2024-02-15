/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Claud
 */
public class EntregaEpi {
    private int idEntrega;
    private int idEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String puesto;
    private int idEpi;
    private String descripcion;
    private String fecha;
    private int und;

    public int getUnd() {
        return und;
    }

    public void setUnd(int und) {
        this.und = und;
    }

    public EntregaEpi() {
    }

    public EntregaEpi(int idEmpleado, String nombre, String apellido1, String apellido2, String puesto, int idEpi, String descripcion, String fecha) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.puesto = puesto;
        this.idEpi = idEpi;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

   
    public int getIdEntrega() {
        return idEntrega;
    }

    @Override
    public String toString() {
        return "EntregaEpi{" + "idEntrega=" + idEntrega + ", idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", puesto=" + puesto + ", idEpi=" + idEpi + ", descripcion=" + descripcion + ", fecha=" + fecha + ", und=" + und + '}';
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   
}
