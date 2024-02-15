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
public class EpiDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    //Seleccionar epi por id
    public Epi epi (int id){
    
        Epi epi = new Epi();
        
        String sql = "select * from epi where Id_epi= "+id+";";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
              epi.setIdEpi(rs.getInt(1));
              epi.setDescripcion(rs.getString(2));
              epi.setTalla(rs.getString(3));
              epi.setUnidades(rs.getInt(4));
            
            }
                    
                    } catch(Exception e){
                    System.out.println("Error en empladoDao");
                    }      
       
        return epi;
   
    }
    
    // metodo para actualizar las unidades despues de hacer una entrega
    public void actualizarUnidades ( int und, int id){
    
        try{
            con = cn.conectar();
            con.createStatement().executeUpdate("update epi set Unidades= Unidades - "+und+" where Id_epi="+id+";");
           
                    } catch(Exception e){
                    System.out.println("Error en empladoDao");
                    }  
    
    }

    //Metodo para crear una lista de la tabla epi para poder mostrarla en una tabla 
    public List tablaEpi() {
        
        List<Epi> lista = new ArrayList<>();
        
        String sql = "Select * from epi";
        try{
            con = cn.conectar();
            ps= con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
            
              Epi epi = new Epi();
                
              epi.setIdEpi(rs.getInt(1));
              epi.setDescripcion(rs.getString(2));
              epi.setTalla(rs.getString(3));
              epi.setUnidades(rs.getInt(4));
                lista.add(epi);
            
            }
                    
                    } catch(Exception e){
                    
                    }         
        return lista;
                    
    }
     
   //Metodo para añadir epi a traves de un objeto, se utilizara en la ventanaEpi
    public int add(Object[] o) {
        int a = 0;
        String sql = "insert into epi(Descripcion,Talla,Unidades) values (?,?,?)";
        
        try{
        
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
         
            
            ps.executeUpdate();
        
        }catch(Exception e){
         System.out.println("error en metodo add de epiDAO");
        }
        return a;
    }

   //Metodo para actualizar epi mediante un obejto, se utlizara en ventanaEpi
    public int actualizar(Object[] o) {
        
        int a =0;
    
        String sql = "update epi set Descripcion = ?, Talla =?, Unidades =? where Id_epi =?";
        
        try{
        
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            
            
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            
            ps.executeUpdate();
        
        }catch(Exception e){
            
            System.out.println("error metodo actualzar de epiDAO");
        }
         return a;
    
    }

   //Metodo para eliminar un epi, se utilizara en la  ventanaEpi
    public void eliminar(int id) {
        
        String sql = " delete from epi where Id_epi =?";
        
     
        try{
        
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        
        }catch(Exception e){
            
            System.out.println("error metodo eliminar de epiDAO");
        }
    }
    
}
