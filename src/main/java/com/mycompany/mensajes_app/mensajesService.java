/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author reinel
 */
public class mensajesService {
    
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("id del mensaje que quiere eliminar: ");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensaje(id_mensaje);
    }
    
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo mensaje");
        String mensaje = sc.nextLine();
  
        System.out.println("id del mensaje que quiere eliminar: ");
        int id_mensaje = sc.nextInt();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setId_mensaje(id_mensaje);
        MensajesDAO.actualizarMensaje(registro);
    }
}
