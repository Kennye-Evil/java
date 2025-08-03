        /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package modelo;

     import  Conexion.Conexion1;
    import encapsulamiento.EncapsulamientoClientes;
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
    public class ModeloClientes {

        public String crearCliente(EncapsulamientoClientes n1)
     {
        String respuesta = ""; 

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "INSERT INTO clientes (nombre,correo,telefono,direccion,empresa,cargo,sueldo)   VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, n1.getNombre());
            ps.setString(2, n1.getCorreo());
            ps.setInt(3, n1.getTelefono());
            ps.setString(4, n1.getDireccion());
            ps.setString(5, n1.getEmpresa());
            ps.setString(6, n1.getCargo());
            ps.setInt(7, n1.getSueldo());

            ps.executeUpdate();
            conexion.close();

            respuesta = "Cliente creado correctamente";
        }
        catch(SQLException ex)
        {
            respuesta = "Error: "+ ex.getMessage();

        }
        return respuesta;
    }
        public List<EncapsulamientoClientes>mostrarCliente()
        {
        List<EncapsulamientoClientes> niveles = new ArrayList<>(); 
        
        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM clientes";
            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                EncapsulamientoClientes n1 = new EncapsulamientoClientes();
                n1.setId(resultSet.getInt("id"));
                n1.setNombres((resultSet.getString("nombre")));
                n1.setCorreo((resultSet.getString("correo")));
                n1.setTelefono((resultSet.getInt("telefono")));
                n1.setDireccion((resultSet.getString("direccion")));
                n1.setEmpresa((resultSet.getString("empresa")));
                n1.setCargo((resultSet.getString("cargo")));
                n1.setSueldo((resultSet.getInt("sueldo")));


                niveles.add(n1);
            }
///            (nombre,correo,telefono,direccion,empresa,cargo,sueldo)   VALUES (?,?,?,?,?,?,?)";

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return niveles;
        }




          public EncapsulamientoClientes mostrarCliente(int id)

          {
           EncapsulamientoClientes n1 = null;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM clientes WHERE id = ? ";
///      (nombre,correo,telefono,direccion,empresa,cargo,sueldo)   VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st  .setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            //modificar
            while(resultSet.next())
            {
                n1 = new EncapsulamientoClientes();
                n1.setId(resultSet.getInt("id"));
                n1.setNombres((resultSet.getString("nombre")));
                n1.setCorreo((resultSet.getString("correo")));
                n1.setTelefono((resultSet.getInt("telefono")));
                n1.setDireccion((resultSet.getString("direccion")));
                n1.setEmpresa((resultSet.getString("empresa")));
                n1.setCargo((resultSet.getString("cargo")));
                n1.setSueldo((resultSet.getInt("sueldo")));

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



          public boolean editarNivel(EncapsulamientoClientes n1)
          {
               boolean resultado  = false;

       Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "UPDATE  clientes SET nombre = ?,correo = ?,telefono = ?,direccion = ?,empresa = ?,cargo = ?,sueldo= ? WHERE id = ? ";
/////      (nombre,correo,telefono,direccion,empresa,cargo,sueldo)   VALUES (?,?,?,?,?,?,?)";

             PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, n1.getNombre());
            st.setString(2, n1.getCorreo());
            st.setInt(3, n1.getTelefono());
            st.setString(4, n1.getDireccion());
            st.setString(5, n1.getEmpresa());
            st.setString(6, n1.getCargo());
            st.setInt(7, n1.getSueldo());
            st.setInt(8, n1.getId());
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
            String consulta = "DELETE from clientes WHERE id = ? ";

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
