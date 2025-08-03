/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import encapsulamiento.EncapsulamientoNiveles;
import java.util.List;
import modelo.ModeloNiveles;

/**
 *
 * @author Joakim
 */
public class NegocioNiveles {
    
    public String crearNivel(EncapsulamientoNiveles n1)
    {
    String respuesta = "";
    ModeloNiveles m1 = new ModeloNiveles();
    respuesta = m1.crearNivel(n1);
    return respuesta;
}
    public List<EncapsulamientoNiveles>mostrarNiveles()
    {
        ModeloNiveles m1 = new ModeloNiveles();
        List<EncapsulamientoNiveles> niveles = m1.mostrarNiveles();
        return niveles;
    }
    
    public EncapsulamientoNiveles mostrarNIvel(int id)
    {
    EncapsulamientoNiveles n1 = null;
    ModeloNiveles n2 = new ModeloNiveles();
    n1 = n2.mostrarNivel(id);
    
    return n1;
    
    }
    
    public boolean editarNiveles(EncapsulamientoNiveles n1)
    {
        ModeloNiveles m1 = new ModeloNiveles();
        boolean res = m1.editarNivel(n1);
        
        return res;
    }
    public boolean eliminarNivel(int id){
        ModeloNiveles m1 =new ModeloNiveles();
        
        boolean res = m1.eliminarNivel(id);
        
        return res;
    }
}
