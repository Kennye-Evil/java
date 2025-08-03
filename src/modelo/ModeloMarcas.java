    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package modelo;

    import  Conexion.Conexion1;
    import encapsulamiento.EncapsulamientoMarcas;
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
    public class ModeloMarcas {

        public String crearMarca(EncapsulamientoMarcas n1)
     {
        String respuesta = ""; 

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "INSERT INTO marcas (descripcion) VALUES (?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, n1.getDescripcion());
            ps.executeUpdate();
            conexion.close();

            respuesta = "marca creada correctamente";
        }
        catch(SQLException ex)
        {
            respuesta = "Error: "+ ex.getMessage();

        }
        return respuesta;
    }
        public List<EncapsulamientoMarcas>mostrarMarcas()
        {
        List<EncapsulamientoMarcas> marcas = new ArrayList<>(); 
        
        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM marcas";
            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                EncapsulamientoMarcas n1 = new EncapsulamientoMarcas();
                n1.setId(resultSet.getInt("id"));
                n1.setDescripcion((resultSet.getString("descripcion")));

                marcas.add(n1);
            }

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return marcas;
        }




          public EncapsulamientoMarcas mostrarMarca(int id)

          {
           EncapsulamientoMarcas n1 = null;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM marcas WHERE id = ? ";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st  .setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                n1 = new EncapsulamientoMarcas();
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



          public boolean editarMarca(EncapsulamientoMarcas n1)
          {
               boolean resultado  = false;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "UPDATE  marcas SET descripcion = ? WHERE id = ? ";

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
            String consulta = "DELETE from marcas WHERE id = ? ";

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
