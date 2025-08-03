/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encapsulamiento;

/**
 *
 * @author Joakim
 */
public class EncapsulamientoVentas {

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getVendenom() {
        return vendenom;
    }

    public void setVendenom(String vendenom) {
        this.vendenom = vendenom;
    }

    public String getClientenom() {
        return clientenom;
    }

    public void setClientenom(String clientenom) {
        this.clientenom = clientenom;
    }

    public String getAutomod() {
        return automod;
    }

    public void setAutomod(String automod) {
        this.automod = automod;
    }
        private int id,vendedor_id,cliente_id,auto_id,precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVendedor_id() {
        return vendedor_id;
    }

    public void setVendedor_id(int vendedor_id) {
        this.vendedor_id = vendedor_id;
    }

   

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(int auto_id) {
        this.auto_id = auto_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

   
        private String fecha,tipopago,vendenom,clientenom,automod;


}
