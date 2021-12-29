/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author reinel
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.connect()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO public.mensajes(mensaje, autor_mensaje) VALUES (?,?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    public static void leerMensajesDB(){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.connect()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                String query = "SELECT id_mensaje, mensaje, autor_mensaje, fecha_mensaje FROM public.mensajes";
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.println("ID : " + rs.getInt("id_mensaje"));
                    System.out.println("MENSAJE : " + rs.getString("mensaje"));
                    System.out.println("AUTOR : " + rs.getString("autor_mensaje"));
                    System.out.println("FECHA MENSAJE : " + rs.getString("fecha_mensaje"));
                }

            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    public static void borrarMensaje(int id_mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.connect()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM public.mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje con id: " + id_mensaje + " fue eliminado.");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    
    public static void actualizarMensaje(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.connect()){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE public.mensajes SET mensaje=? WHERE id_mensaje=?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje con id: " + mensaje.getId_mensaje() + " fue actualizado.");
            }catch(SQLException ex){
                System.out.println(ex);
            }
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
}
