/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author reinel
 */
public class Conexion {
    
        
    private final String url = "jdbc:postgresql://localhost/mensaje";
    private final String user = "postgres";
    private final String password = "postgres";
    

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTED TO DATABASE");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ERROR CONNECTING TO DATABASE");
        }
        return conn;
    }

}
