/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Conexion.Conexion1;
import encapsulamiento.EncapsulamientoAutos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joakim
 */
public class ModeloAutos {
    public String crearAuto(EncapsulamientoAutos n1)
     {
        String respuesta = ""; 

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "INSERT INTO autos (serie,modelo,ano,precio,color)   VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, n1.getSerie()); 
            ps.setString(2, n1.getModelo());
            ps.setInt(3, n1.getAno());
            ps.setInt(4, n1.getPrecio());
            ps.setString(5, n1.getColor()); 
                      

            ps.executeUpdate();
            conexion.close();

            respuesta = "Auto creado correctamente";
        }
        catch(SQLException ex)
        {
            respuesta = "Error: "+ ex.getMessage();

        }
        return respuesta;
}

 
        public List<EncapsulamientoAutos>mostrarAuto(){
        List<EncapsulamientoAutos> autos = new ArrayList<>(); 
        
        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM autos";
            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                EncapsulamientoAutos n1 = new EncapsulamientoAutos();
                n1.setId(resultSet.getInt("id"));
                n1.setSerie((resultSet.getString("serie")));                                 
                n1.setModelo((resultSet.getString("modelo")));
                n1.setAno((resultSet.getInt("ano")));
                n1.setPrecio((resultSet.getInt("precio")));
                n1.setColor((resultSet.getString("color")));


                autos.add(n1);
            }

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return autos;
        }
        public EncapsulamientoAutos mostrarAutos(int id)

          {
           EncapsulamientoAutos n1 = null;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM autos WHERE id = ?";
//String consulta = "INSERT INTO autos (ano,precio,serie,modelo,color)  

            PreparedStatement st = conexion.prepareStatement(consulta);
            st  .setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            //modificar
            while(resultSet.next())
            {
                n1 = new EncapsulamientoAutos();
                n1.setId(resultSet.getInt("id"));
                n1.setSerie((resultSet.getString("serie")));
                n1.setModelo((resultSet.getString("modelo")));
                n1.setAno((resultSet.getInt("ano")));
                n1.setPrecio((resultSet.getInt("precio")));
                n1.setColor((resultSet.getString("color")));

            }

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return n1;
          }
        
        
        
        
        
        
   public boolean editarAutos(EncapsulamientoAutos n1)
          {
               boolean resultado  = false;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "UPDATE  autos SET serie = ?,modelo=?,ano=?,precio=?,color=? WHERE id = ?";
//String consulta = "INSERT INTO autos (ano,precio,serie,modelo,color)   VALUES (?,?,?,?,?,?)";


             PreparedStatement st = conexion.prepareStatement(consulta);
             
            st.setString(1, n1.getSerie());
            st.setString(2, n1.getModelo());
            st.setInt(3, n1.getAno());
            st.setInt(4, n1.getPrecio());
            st.setString(5, n1.getColor());
            st.setInt(6, n1.getId());
            st.executeUpdate();

            st.close();
            conexion.close();
            resultado = true;


        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return resultado;
          }






          public boolean eliminarCliente(int id)
          {
              boolean resultado  = false;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "DELETE from autos WHERE id = ?";

            PreparedStatement st = conexion.prepareStatement(consulta);

            st.setInt(1, id);
            st.executeUpdate();
            st.close();
            conexion.close();
            resultado = true;


        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return resultado;
          }
    }