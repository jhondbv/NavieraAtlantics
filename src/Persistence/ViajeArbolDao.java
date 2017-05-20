/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.Viaje;
import Class.Viajes;
import Persistence.Interface.IViajeDao;
import java.util.List;

/**
 *
 * @author jhon
 */
public class ViajeArbolDao implements IViajeDao{

     private static ArbolAvl lstItems = new ArbolAvl();
     
     public ViajeArbolDao()
     {
        lstItems = Archivos.Repositories.viajes;
     
     }
    @Override
    public Viajes Consultar() {
        Viajes list = new Viajes();
        list.List=(List<Viaje>) (Object) lstItems.generarLista();
        return  list;
    }
    private Viaje ConsultarReferencia(int id) {

        for (Viaje obj : Consultar().List) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public Viaje Consultar(int id) {
        Viaje referencia = (Viaje) lstItems.getObject(id);
        Viaje newItem = new Viaje();
        if (referencia != null) {
            newItem = new Viaje(referencia);
        }

        return newItem;
    }

    @Override
    public void Guardar(Viaje item) {
        NodoDobleAvl lastNode = lstItems.getLastNode(lstItems.raiz);
        int id=1;
        if(lastNode != null)
        {
            Viaje obj = (Viaje) lastNode.retornaDato();
            id = obj.getId() + 1;
        }
        
        item.setId(id);
        lstItems.insertarDatoEnAvl(item, id);
    }

    @Override
    public void Actualizar(Viaje item) {
        Viaje objViaje = ConsultarReferencia(item.getId());
        objViaje.setIdBarco(item.getIdBarco());
        objViaje.setIdPuertoDestino(item.getIdPuertoDestino());
        objViaje.setIdPuertoOrigen(item.getIdPuertoOrigen());
        objViaje.setTripulacion(item.getTripulacion());
        objViaje.setNumEncomiendas(item.getNumEncomiendas());
        objViaje.setPuertosAtraco(item.getPuertosAtraco());
        objViaje.setEnCurso(item.isEnCurso());
        objViaje.setFinalizado(item.isFinalizado());
    }

    @Override
    public void Eliminar(int id) {
       lstItems.removeNodo(id);
    }
    
}
