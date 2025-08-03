/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import encapsulamiento.EncapsulamientoMarcas;
import java.util.List;
import modelo.ModeloMarcas;

/**
 *
 * @author Joakim
 */
public class NegocioMarcas {
    
    public String crearMarca(EncapsulamientoMarcas n1)
    {
    String respuesta = "";
    ModeloMarcas m1 = new ModeloMarcas();
    respuesta = m1.crearMarca(n1);
    return respuesta;
}
    public List<EncapsulamientoMarcas>mostrarMarca()
    {
        ModeloMarcas m1 = new ModeloMarcas();
        List<EncapsulamientoMarcas> niveles = m1.mostrarMarcas();
        return niveles;
    }
    
    public EncapsulamientoMarcas mostrarMarca(int id)
    {
    EncapsulamientoMarcas n1 = null;
    ModeloMarcas n2 = new ModeloMarcas();
    n1 = n2.mostrarMarca(id);
    
    return n1;
    
    }
    
    public boolean editarMarca(EncapsulamientoMarcas n1)
    {
        ModeloMarcas m1 = new ModeloMarcas();
        boolean res = m1.editarMarca(n1);
        
        return res;
    }
    public boolean eliminarMarca(int id){
        ModeloMarcas m1 =new ModeloMarcas();
        
        boolean res = m1.eliminarNivel(id);
        
        return res;
    }
}
