/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.sql.*;
import java.util.*;

/**
 *
 * @author Claud
 */
public class EmpleadoDAO {
    
    //Instancias de los objetos necesarios
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    //Metodo para seleccionar datos para la ventana de entrega de epi
    public Empleado idEmpleado (int id){
    
        Empleado emp= new Empleado();
        
        String sql = "select * from empleado where Id_empleado= "+id+";";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
               
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido1(rs.getString(3));
                emp.setApellido2(rs.getString(4));
                emp.setPuesto(rs.getString(5));
            
                
            }
                    
                    } catch(Exception e){
                    System.out.println("Error en empladoDao");
                    }      
       
        return emp;
   
    }
    
    //Metodo para mostrar la tabla empleado en la tabla visual
    public List listaTablaEmpleado(){
     List<Empleado> lista = new ArrayList<>();
        
        String sql = "Select * from empleado";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Empleado emp= new Empleado();
                
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido1(rs.getString(3));
                emp.setApellido2(rs.getString(4));
                emp.setPuesto(rs.getString(5));
                
                lista.add(emp);
            }
             } catch(Exception e){
                    System.out.println("Error en empladoDao");
                }                    
        return lista;
   }
    
   // Metodo para filtrar empleado por id para la tabla
   public List filtrarId(int id){
     List<Empleado> lista = new ArrayList<>();
        
        String sql = "select * from empleado where Id_empleado= "+id+";";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
                Empleado emp= new Empleado();
                
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido1(rs.getString(3));
                emp.setApellido2(rs.getString(4));
                emp.setPuesto(rs.getString(5));
                
                lista.add(emp);
            }
             } catch(Exception e){
                    System.out.println("Error en empladoDao");
                }                    
        return lista;
   } 
    
    

}
