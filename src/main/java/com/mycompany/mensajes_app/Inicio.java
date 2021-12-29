/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;



/**
 *
 * @author reinel
 */
public class Inicio {

    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int opcion=0;

        do{
            System.out.println("-----------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println(" 1. crear mensaje");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. eliminar mensaje");
            System.out.println(" 4. editar mensaje");
            System.out.println(" 5. salir");
            //leemos la opcion del usuario
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1:
                    mensajesService.crearMensaje();
                    break;
                case 2:
                    mensajesService.listarMensajes();
                    break;
                case 3:
                    mensajesService.borrarMensaje();
                    break;
                case 4:
                    mensajesService.editarMensaje();
                    break;
                default:
                    break;
            }
           
        }while(opcion != 5);
        
        
        Conexion conn = new Conexion();
        try(Connection cnx = conn.connect()){
            
        }catch(Exception ex){
            
        }
    }  
}
