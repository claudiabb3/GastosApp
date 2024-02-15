
package objetos;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Claud
 */
public class EntregaEpiDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    //Metodo de consulta de la base de datos
    //Sirve para objtener todos los datos de la tabla Entrega_pi en una lista
    public List entregaEpi(){
    
     List<EntregaEpi> lista = new ArrayList<>();
        
        String sql = "Select * from entrega_epi ;";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));
                
                
                lista.add(r);
            
            }
                    
                    } catch(Exception e){
                    
                    }         
        return lista;
    
    }
    
    
    //Metodo para actualizar la tabla entrega_epi, tras realizar una entrega en la ventana entregas
    public void InsertarEntregasEpi ( String nombre, String ap1, String ap2, String puesto, String des, int idEm, int idEpi, int und){
    
        try{
            con = cn.conectar();
            con.createStatement().executeUpdate("insert into ENTREGA_EPI (Nombre_emp, Apellido1_emp,Apellido2_emp, "
                    + "Puesto_emp,Descripcion_epi,id_empleado_fk,id_epi_fk,und)  values ("+ "'"+nombre +"'," + "'"+ap1 +"',"+ "'"+ap2 +"',"
            + "'"+puesto +"',"+ "'"+des +"',"+idEm +","+idEpi+","+und+");"
            );
           
                    } catch(Exception e){
                    System.out.println("Error en empladoDao");
                    }  
    
    }
    
    
    //Metodo para seleccionar por idEmpleado
    
    public List filtrarIdEmp(int idEmp){
    
     List<EntregaEpi> lista = new ArrayList<>();
        
        String sql = "select * from entrega_epi where id_empleado_fk= "+idEmp+";";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));
                
                
                lista.add(r);
            
            }
                    
                    } catch(Exception e){
                    
                    }         
        return lista;
    
    }
    
    //Metodo para seleccionar por idEpi
    
    public List filtrarIdEpi(int idEpi){
    
     List<EntregaEpi> lista = new ArrayList<>();
        
        String sql = "select * from entrega_epi where id_epi_fk= "+idEpi+";";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));
                
                
                lista.add(r);
            
            }
                    
                    } catch(Exception e){
                    
                    }         
        return lista;
    
    }
    
    //Metodo para seleccionar los empleados que segun el idEmp y el idEpi
    public List filtrarIdes(int idEmp, int idEpi){
    List<EntregaEpi> lista = new ArrayList<>();
        
        String sql = "select * from entrega_epi where id_empleado_fk = "+idEmp+" and id_epi_fk= "+idEpi+";";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                EntregaEpi r = new EntregaEpi();
                
                r.setIdEntrega(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setApellido1(rs.getString(3));
                r.setApellido2(rs.getString(4));
                r.setPuesto(rs.getString(5));
                r.setDescripcion(rs.getString(6));
                r.setFecha(rs.getString(7));
                r.setIdEmpleado(rs.getInt(8));
                r.setIdEpi(rs.getInt(9));
                r.setUnd(rs.getInt(10));
                
                
                lista.add(r);
            
            }
                    
                    } catch(Exception e){
                    
                    }         
        return lista;
    
    
    
    }
}
