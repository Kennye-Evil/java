/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import encapsulamiento.EncapsulamientoClientes;
import java.util.List;
import modelo.ModeloClientes;

/**
 *
 * @author Joakim
 */
public class NegocioClientes {
    
    public String crearCliente(EncapsulamientoClientes n1)
    {
    String respuesta = "";
    ModeloClientes m1 = new ModeloClientes();
    respuesta = m1.crearCliente(n1);
    return respuesta;
}
    public List<EncapsulamientoClientes>mostrarClientes()
    {
        ModeloClientes m1 = new ModeloClientes();
        List<EncapsulamientoClientes> niveles = m1.mostrarCliente();
        return niveles;
    }
    
    public EncapsulamientoClientes mostrarCliente(int id)
    {
    EncapsulamientoClientes n1 = null;
    ModeloClientes n2 = new ModeloClientes();
    n1 = n2.mostrarCliente(id);
    
    return n1;
    
    }
    
    public boolean editarClientes(EncapsulamientoClientes n1)
    {
        ModeloClientes m1 = new ModeloClientes();
        boolean res = m1.editarNivel(n1);
        
        return res;
    }
    public boolean eliminarClientes(int id){
        ModeloClientes m1 =new ModeloClientes();
        
        boolean res = m1.eliminarCliente(id);
        
        return res;
    }
}
