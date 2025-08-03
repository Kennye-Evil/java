/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import encapsulamiento.EncapsulamientoVentas;
import java.util.List;
import modelo.ModeloVentas;

/**
 *
 * @author Joakim
 */
public class NegocioVentas {
     public String crearVenta(encapsulamiento.EncapsulamientoVentas u1)
    {
    String respuesta = "";
        ModeloVentas m1 = new ModeloVentas();
    respuesta = m1.crearVenta(u1);
    return respuesta;
}
         public List<EncapsulamientoVentas>mostrarVentas()
    {
        ModeloVentas m1 = new ModeloVentas();
        List<EncapsulamientoVentas> ventas = m1.mostrarVentas();
        return ventas;
    }
    
    public EncapsulamientoVentas mostrarVenta(int id)
    {
    EncapsulamientoVentas n1 = null;
    ModeloVentas n2 = new ModeloVentas();
    n1 = n2.mostrarVenta(id);
    
    return n1;
    
    }
    
    public boolean editarVenta(EncapsulamientoVentas n1)
    {
        ModeloVentas m1 = new ModeloVentas();
        boolean res = m1.editarVenta(n1);
        
        return res;
    }
    public boolean eliminarVenta(int id){
        ModeloVentas m1 =new ModeloVentas();
        
        boolean res = m1.eliminarVenta(id);
        
        return res;
    }
}
