/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Joakim
 */
public class conexion2 {
  
    public static String server ="jdbc:mysql://localhost:3306/poo";
    public static String user = "root";
    public static String password = "";
    
    public Connection Conectar()
    {
     Connection connection = null;
     
     try 
     {
           connection = DriverManager.getConnection(server, user, password);
           JOptionPane.showMessageDialog(null,"Conexion exitosa" );
     
     }
     
     catch (SQLException ex)
     {
     
            JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());
     
     }
     
     return connection;
        
        
    }
}
