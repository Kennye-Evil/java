    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package modelo;

    import  Conexion.Conexion1;
    import encapsulamiento.EncapsulamientoVendedores;
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
    public class ModeloVendedores {

        public String crearVendedor(EncapsulamientoVendedores n1)
     {
        String respuesta = ""; 

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "INSERT INTO vendedores (nombre,correo,telefono,rfc,nivel_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(consulta);
            ps.setString(1, n1.getNombre());
            ps.setString(2, n1.getCorreo());
            ps.setInt(3, n1.getTelefono());
            ps.setString(4, n1.getRfc());
            ps.setInt(5, n1.getNivel_id());


            ps.executeUpdate();
            conexion.close();

            respuesta = "Vendedor creado correctamente";
        }
        catch(SQLException ex)
        {
            respuesta = "Error: "+ ex.getMessage();

        }
        return respuesta;
    }
        public List<EncapsulamientoVendedores>mostrarVendedores()
        {
        List<EncapsulamientoVendedores> niveles = new ArrayList<>(); 
        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT u.id, u.nombre, u.correo, u.telefono,u.rfc, u.nivel_id,n.descripcion FROM vendedores u INNER JOIN niveles n ON u.nivel_id = n.id;";
            PreparedStatement st = conexion.prepareStatement(consulta);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                EncapsulamientoVendedores n1 = new EncapsulamientoVendedores();
                n1.setId(resultSet.getInt("id"));
                n1.setNombre(resultSet.getString("nombre"));
                n1.setCorreo(resultSet.getString("correo"));
                n1.setTelefono(resultSet.getInt("telefono"));
                n1.setRfc(resultSet.getString("rfc"));
                n1.setDescripcion(resultSet.getString("descripcion"));
              // n1.setDescripcion(resultSet.getString("descripcion"));
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




          public EncapsulamientoVendedores mostrarVendedor(int id)

          {
           EncapsulamientoVendedores n1 = null;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM vendedores WHERE id = ? ";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                n1 = new EncapsulamientoVendedores();
                n1.setId(resultSet.getInt("id"));
                 n1.setNombre((resultSet.getString("nombre")));
                n1.setCorreo((resultSet.getString("correo")));
                n1.setTelefono((resultSet.getInt("telefono")));  
                n1.setRfc((resultSet.getString("rfc")));
                n1.setNivel_id(resultSet.getInt("nivel_id"));
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



         public boolean editarVendedor(EncapsulamientoVendedores n1)
          {
               boolean resultado  = false;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "UPDATE  vendedores SET nombre = ?,correo = ?,telefono = ?,rfc = ?,nivel_id=? WHERE id = ? ";
            //String consulta = "INSERT INTO vendedores (nombre,correo,telefono,rfc) VALUES (?,?,?,?)";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, n1.getNombre());
            st.setString(2, n1.getCorreo());
            st.setInt(3, n1.getTelefono());
            st.setString(4, n1.getRfc());
            st.setInt(5,n1.getNivel_id());
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


          public boolean eliminarVendedor(int id)
          {
              boolean resultado  = false;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "DELETE from vendedores WHERE id = ? ";

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
          
          
          public EncapsulamientoVendedores Login(String correo,int telefono)

          {
           EncapsulamientoVendedores u1 = null;

        Conexion1 c1 = new Conexion1();
        Connection conexion = c1.Conectar();
        try
        {
            String consulta = "SELECT * FROM  vendedores WHERE correo = ? and telefono=?";

            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, correo);
            st.setInt(2, telefono);
            ResultSet resultSet = st.executeQuery();

            while(resultSet.next())
            {
                u1 = new EncapsulamientoVendedores();
                u1.setId(resultSet.getInt("id"));
                u1.setNombre(resultSet.getString("nombre"));
                u1.setCorreo(resultSet.getString("correo"));
                u1.setTelefono(resultSet.getInt("telefono"));
                u1.setRfc(resultSet.getString("rfc"));
                u1.setNivel_id(resultSet.getInt("nivel_id"));
                
            }

            st.close();
            conexion.close();
        }
        catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, "Error"+ ex.getMessage());
               }
        return u1;
          }
    }
