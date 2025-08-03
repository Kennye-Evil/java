/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import PresentacionVendedores.MostrarVendedores;
import encapsulamiento.EncapsulamientoVendedores;
import java.util.List;
import modelo.ModeloVendedores;

/**
 *
 * @author Joakim
 */
public class NegocioVendedores {
    
    public String crearVendedor(EncapsulamientoVendedores n1)
    {
    String respuesta = "";
    ModeloVendedores m1 = new ModeloVendedores();
    respuesta = m1.crearVendedor(n1);
    return respuesta;
}
    public List<EncapsulamientoVendedores>MostrarVendedores()
    {
        ModeloVendedores m1 = new ModeloVendedores();
        List<EncapsulamientoVendedores> niveles = m1.mostrarVendedores();
        return niveles;
    }
    
    public EncapsulamientoVendedores mostrarVendedor(int id)
    {
    EncapsulamientoVendedores n1 = null;
    ModeloVendedores n2 = new ModeloVendedores();
    n1 = n2.mostrarVendedor(id);
    
    return n1;
    
    }
    
    public boolean editarVendedores(EncapsulamientoVendedores n1)
    {
        ModeloVendedores m1 = new ModeloVendedores();
        boolean res = m1.editarVendedor(n1);
        
        return res;
    }
    public boolean eliminarVendedor(int id){
        ModeloVendedores m1 =new ModeloVendedores();
        
        boolean res = m1.eliminarVendedor(id);
        
        return res;
    }
      public EncapsulamientoVendedores Login(String correo, int telefono)
    {
    EncapsulamientoVendedores u1 = null;
    ModeloVendedores n2 = new ModeloVendedores();
    u1 = n2.Login(correo, telefono);
    
    return u1;
    
}
    
    
}
