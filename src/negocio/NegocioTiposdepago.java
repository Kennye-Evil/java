/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import encapsulamiento.EncapsulamientoTiposdepago;
import java.util.List;
import modelo.ModeloTiposdepago;

/**
 *
 * @author Joakim
 */
public class NegocioTiposdepago {
    
    public String crearNivel(EncapsulamientoTiposdepago n1)
    {
    String respuesta = "";
    ModeloTiposdepago m1 = new ModeloTiposdepago();
    respuesta = m1.crearNivel(n1);
    return respuesta;
}
    public List<EncapsulamientoTiposdepago>mostrarPagos()
    {
        ModeloTiposdepago m1 = new ModeloTiposdepago();
        List<EncapsulamientoTiposdepago> niveles = m1.mostrarNiveles();
        return niveles;
    }
    
    public EncapsulamientoTiposdepago mostrarPago(int id)
    {
    EncapsulamientoTiposdepago n1 = null;
    ModeloTiposdepago n2 = new ModeloTiposdepago();
    n1 = n2.mostrarNivel(id);
    
    return n1;
    
    }
    
    public boolean editarPagos(EncapsulamientoTiposdepago n1)
    {
        ModeloTiposdepago m1 = new ModeloTiposdepago();
        boolean res = m1.editarNivel(n1);
        
        return res;
    }
    public boolean eliminarNivel(int id){
        ModeloTiposdepago m1 =new ModeloTiposdepago();
        
        boolean res = m1.eliminarNivel(id);
        
        return res;
    }
}
