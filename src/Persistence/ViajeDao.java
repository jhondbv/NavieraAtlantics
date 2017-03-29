/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Viaje;
import Class.Viajes;
import Persistence.Interface.IViajeDao;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author jhon_Ballesteros
 */
public class ViajeDao implements IViajeDao {

    private final String Nombre_Archivo = "DataBaseFiles/viajes.xml";
    private static Viajes viajes = new Viajes();

    public ViajeDao() {
        File file = new File(Nombre_Archivo);
        Serializer serializer = new Persister();
        try {
            viajes = serializer.read(Viajes.class, file);
        } catch (Exception ex) {

        }
    }

    @Override
    public Viajes ConsultarViajes() {
        return viajes;
    }

    @Override
    public Viaje ConsultarViaje(int id) {

        for (Viaje viaje : viajes.List) {
            if (viaje.getId() == id) {
                return viaje;
            }
        }
        return null;
    }

    @Override
    public void GuardarViaje(Viaje viaje) {

        int maxId = viajes.List.size() - 1;
        Viaje lastViaje = viajes.List.get(maxId);
        if (lastViaje != null) {
            viaje.setId(lastViaje.getId() + 1);
            viajes.List.add(viaje);
        }

    }

    @Override
    public void ActualizarViaje(Viaje viaje) {

        Viaje objViaje = ConsultarViaje(viaje.getId());
        objViaje.setIdBarco(viaje.getIdBarco());
        objViaje.setIdPuertoDestino(viaje.getIdPuertoDestino());
        objViaje.setIdPuertoOrigen(viaje.getIdPuertoOrigen());
        objViaje.setTripulacion(viaje.getTripulacion());
        objViaje.setNumEncomiendas(viaje.getNumEncomiendas());
        objViaje.setPuertosAtraco(viaje.getPuertosAtraco());

        viajes.List.add(objViaje);
    }

    @Override
    public void EliminarViaje(int id) {
        Viaje deleteViaje = ConsultarViaje(id);

        viajes.List.remove(deleteViaje);
    }

    @Override
    public void GuardarCambios() {
        Serializer serializer = new Persister();
        File file = new File(Nombre_Archivo);
        try {
            serializer.write(viajes, file);

        } catch (Exception ex) {
        }

    }

}
