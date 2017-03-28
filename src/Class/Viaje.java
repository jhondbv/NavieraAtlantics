/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author jhon_Ballesteros
 */
public class Viaje {

    private int id;
    private int idBarco;
    private int idPuertoOrigen;
    private int idPuertoDestino;
    private String puertosAtraco;
    private String tripulacion;
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
