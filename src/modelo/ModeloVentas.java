/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Conexion.Conexion1;
import encapsulamiento.EncapsulamientoVentas;
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
public class ModeloVentas {
           public String crearVenta(EncapsulamientoVentas u1)
     {
        String respuesta = ""; 

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "INSERT INTO ventas (vendedor_id,cliente_id,auto_id,tipopago,fecha) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setInt(1, u1.getVendedor_id());
            ps.setInt(2, u1.getCliente_id());
            ps.setInt(3, u1.getAuto_id());  
             ps.setString(4, u1.getTipopago());
               ps.setString(5, u1.getFecha());
            ps.executeUpdate();
            conexion.close();

            respuesta = "Venta creada Correctamente";
        }
        catch(SQLException ex)
        {
            respuesta = "Error: "+ ex.getMessage();

        }
        return respuesta;
    }
public List<EncapsulamientoVentas>mostrarVentas()
        {
        List<EncapsulamientoVentas> Ventas = new ArrayList<>(); 
        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT v.id,ve.nombre AS vendedor,c.nombre as cliente ,a.modelo,v.tipopago,v.fecha,a.precio FROM ( ( ( ventas v INNER JOIN vendedores ve ON v.vendedor_id = ve.id) INNER JOIN clientes c ON v.cliente_id = c.id) INNER JOIN autos a on v.auto_id = a.id);";
            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                EncapsulamientoVentas n1 = new EncapsulamientoVentas();
                n1.setId(resultSet.getInt("id"));
                n1.setVendenom(resultSet.getString("vendedor"));
                n1.setClientenom(resultSet.getString("cliente"));
                n1.setAutomod(resultSet.getString("modelo"));
                n1.setTipopago(resultSet.getString("tipopago"));
                n1.setFecha(resultSet.getString("fecha"));
                n1.setPrecio(resultSet.getInt("precio"));

                Ventas.add(n1);
            }

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return Ventas;
        }




          public EncapsulamientoVentas mostrarVenta(int id)

          {
           EncapsulamientoVentas n1 = null;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM ventas WHERE id = ? ";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                n1 = new EncapsulamientoVentas();
                n1.setId(resultSet.getInt("id"));
                n1.setVendedor_id(resultSet.getInt("vendedor_id"));
                n1.setCliente_id(resultSet.getInt("cliente_id"));
                n1.setAuto_id(resultSet.getInt("auto_id"));
                n1.setTipopago(resultSet.getString("tipopago"));
                n1.setFecha(resultSet.getString("fecha"));
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



          public boolean editarVenta(EncapsulamientoVentas n1)
          {
               boolean resultado  = false;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "UPDATE  ventas SET vendedor_id = ?,cliente_id = ?,auto_id = ?,tipopago = ?,fecha = ? WHERE id = ? ";
            //"INSERT INTO ventas (vendedor_id,cliente_id,auto_id,tipopago,fecha) VALUES (?,?,?,?,?)";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setInt(1, n1.getVendedor_id());
            System.out.println(n1.getVendedor_id());
            st.setInt(2, n1.getCliente_id());
            System.out.println(n1.getCliente_id());
            st.setInt(3, n1.getAuto_id());
            System.out.println(n1.getAuto_id());
            st.setString(4, n1.getTipopago());
            System.out.println(n1.getTipopago());
            st.setString(5, n1.getFecha());
            System.out.println(n1.getFecha());
            st.setInt(6, n1.getId());
            System.out.println(n1.getId());
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


          public boolean eliminarVenta(int id)
          {
              boolean resultado  = false;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "DELETE from ventas WHERE id = ? ";

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

    
    
    
    
    

