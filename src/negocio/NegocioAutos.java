/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import encapsulamiento.EncapsulamientoAutos;
import java.util.List;
import modelo.ModeloAutos;


/**
 *
 * @author Joakim
 */
public class NegocioAutos {
    
    
    
    public String crearAuto(EncapsulamientoAutos n1)
    {
    String respuesta = "";
    ModeloAutos m1 = new ModeloAutos();
    respuesta = m1.crearAuto(n1);
    return respuesta;
}
    public List<EncapsulamientoAutos>mostrarAutos()
    {
        ModeloAutos m1 = new ModeloAutos();
        List<EncapsulamientoAutos> autos = m1.mostrarAuto();
        return autos;
    }
    
    public EncapsulamientoAutos mostrarAutos(int id)
    {
    EncapsulamientoAutos n1 = null;
    ModeloAutos n2 = new ModeloAutos();
    n1 = n2.mostrarAutos(id);
    
    return n1;
    
    }
    
    public boolean editarAutos(EncapsulamientoAutos n1)
    {
        ModeloAutos m1 = new ModeloAutos();
        boolean res = m1.editarAutos(n1);
        
        return res;
    }
    public boolean eliminarClientes(int id){
        ModeloAutos m1 =new ModeloAutos();
        
        boolean res = m1.eliminarCliente(id);
        
        return res;
    }
}

   
