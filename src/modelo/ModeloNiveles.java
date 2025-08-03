    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package modelo;

import Conexion.Conexion1;
    import encapsulamiento.EncapsulamientoNiveles;
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
    public class ModeloNiveles {

        public String crearNivel(EncapsulamientoNiveles n1)
     {
        String respuesta = ""; 

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "INSERT INTO niveles (descripcion) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, n1.getDescripcion());
            ps.executeUpdate();
            conexion.close();

            respuesta = "Nivel creado correctamente";
        }
        catch(SQLException ex)
        {
            respuesta = "Error: "+ ex.getMessage();

        }
        return respuesta;
    }
        public List<EncapsulamientoNiveles>mostrarNiveles()
        {
        List<EncapsulamientoNiveles> niveles = new ArrayList<>(); 
        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM niveles";
            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                EncapsulamientoNiveles n1 = new EncapsulamientoNiveles();
                n1.setId(resultSet.getInt("id"));
                n1.setDescripcion((resultSet.getString("descripcion")));

                niveles.add(n1);
            }

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return niveles;
        }




          public EncapsulamientoNiveles mostrarNivel(int id)

          {
           EncapsulamientoNiveles n1 = null;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM niveles WHERE id = ? ";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st  .setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                n1 = new EncapsulamientoNiveles();
                n1.setId(resultSet.getInt("id"));
                n1.setDescripcion((resultSet.getString("descripcion")));


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



          public boolean editarNivel(EncapsulamientoNiveles n1)
          {
               boolean resultado  = false;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "UPDATE  niveles SET descripcion = ? WHERE id = ? ";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st  .setString(1, n1.getDescripcion());
            st.setInt(2, n1.getId());
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






          public boolean eliminarNivel(int id)
          {
              boolean resultado  = false;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "DELETE from niveles WHERE id = ? ";

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
