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
 * @author Penagos
 */
@Root
public class TipoBarco {
    
    @Attribute
    int id;
    @Element
    String descripcion;
    @Element
    int capacidadCarga;
    @Element
    int capacidadPersonas;

    public TipoBarco() {
    }
    
    public TipoBarco(TipoBarco tipoBarco) {
        id=tipoBarco.getId();
        descripcion=tipoBarco.getDescripcion();
        capacidadCarga=tipoBarco.getCapacidadCarga();
        capacidadPersonas=tipoBarco.getCapacidadPersonas();
    }

    public TipoBarco(Barco barquito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }
    
    
    
    
    
    
    
}
