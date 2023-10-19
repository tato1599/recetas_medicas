/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author danielneri
 */
public class DbConnection {

   Connection con = null;
   String url = "jdbc:mysql://localhost:3306/Recetas";

    public  DbConnection() {
        try {
            con = DriverManager.getConnection(url, "root", "");
            if (con != null) {
                System.out.println("Conexión a base de datos Recetas. listo...");
            }
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }

   
}
