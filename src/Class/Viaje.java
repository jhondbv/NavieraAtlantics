/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 *
 * @author jhon_Ballesteros
 */
@Root
public class Viaje {

    @Attribute
    private int id;
    @Attribute
    private int idBarco;
    @Attribute
    private int idPuertoOrigen;
    @Attribute
    private int idPuertoDestino;
    @Element
    private String puertosAtraco;
    @Element
    private String tripulacion;
    @Element
    private int numEncomiendas;

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBarco(int idBarco) {
        this.idBarco = idBarco;
    }

    public void setIdPuertoOrigen(int idPuertoOrigen) {
        this.idPuertoOrigen = idPuertoOrigen;
    }

    public void setIdPuertoDestino(int idPuertoDestino) {
        this.idPuertoDestino = idPuertoDestino;
    }

    public void setPuertosAtraco(String puertosAtraco) {
        this.puertosAtraco = puertosAtraco;
    }

    public void setTripulacion(String tripulacion) {
        this.tripulacion = tripulacion;
    }

    public void setNumEncomiendas(int numEncomiendas) {
        this.numEncomiendas = numEncomiendas;
    }

    public int getId() {
        return id;
    }

    public int getIdBarco() {
        return idBarco;
    }

    public int getIdPuertoOrigen() {
        return idPuertoOrigen;
    }

    public int getIdPuertoDestino() {
        return idPuertoDestino;
    }

    public String getPuertosAtraco() {
        return puertosAtraco;
    }

    public String getTripulacion() {
        return tripulacion;
    }

    public int getNumEncomiendas() {
        return numEncomiendas;
    }

}
