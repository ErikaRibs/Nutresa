/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.*;

/**
 *
 * @author PRIDE OMEGA
 */
public class Conexion {
    private Connection con = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nutresa", "newroot", "");
        } catch (Exception e) {
        }
        
        return con;
    }
    
}
