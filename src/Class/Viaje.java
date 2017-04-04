/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author jhon_Ballesteros
 */
@Root
public class Viaje {

    @Attribute
    private int id;
    @Element
    private int idBarco;
    @Element
    private int idPuertoOrigen;
    @Element
    private int idPuertoDestino;
    @Element
    private String puertosAtraco;
    @ElementList(inline=true)
    private List<Tripulacion> tripulacion;
    @Element
    private int numEncomiendas;

    
    public Viaje()
    {
        tripulacion= new ArrayList<Tripulacion>();
    }
    
     public Viaje(Viaje viaje)
    {
        id=viaje.getId();
        idBarco=viaje.getIdBarco();
        idPuertoOrigen=viaje.getIdPuertoOrigen();
        idPuertoDestino=viaje.getIdPuertoDestino();
        tripulacion=viaje.getTripulacion();
        puertosAtraco=viaje.getPuertosAtraco();
        numEncomiendas=viaje.getNumEncomiendas();
    }
    
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

    public void setTripulacion(List<Tripulacion> tripulacion) {
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

    public List<Tripulacion>  getTripulacion() {
        return tripulacion;
    }

    public int getNumEncomiendas() {
        return numEncomiendas;
    }

}



