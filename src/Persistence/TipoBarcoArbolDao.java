/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.TipoBarco;
import Class.TipoBarcos;
import Persistence.Interface.ITipoBarcoDAO;
import java.util.List;

/**
 *
 * @author jhon
 */
public class TipoBarcoArbolDao implements ITipoBarcoDAO {

    private ArbolAvl tipoBarcos = new ArbolAvl();

    public TipoBarcoArbolDao() {
        tipoBarcos = Archivos.Repositories.tipoBarcos;
    }

    @Override
    public TipoBarcos Consultar() {
        TipoBarcos list = new TipoBarcos();
        list.List=(List<TipoBarco>) (Object) tipoBarcos.generarLista();
        return  list;
    }

    @Override
    public TipoBarco Consultar(int id) {
        TipoBarco referencia = (TipoBarco) tipoBarcos.getObject(id);
        TipoBarco barquito = new TipoBarco();
        if (referencia != null) {
            barquito = new TipoBarco(referencia);
        }

        return barquito;
    }

    @Override
    public void guardar(TipoBarco item) {
        NodoDobleAvl lastNode = tipoBarcos.getLastNode(tipoBarcos.raiz);
        int id=1;
        if(lastNode != null)
        {
            TipoBarco tipobarco = (TipoBarco) lastNode.retornaDato();
            id = tipobarco.getId() + 1;
        }
        
        item.setId(id);
        tipoBarcos.insertarDatoEnAvl(item, id);
    }

    private TipoBarco ConsultarReferencia(int id) {

        for (TipoBarco tipobarco : Consultar().List) {
            if (tipobarco.getId() == id) {
                return tipobarco;
            }
        }
        return null;
    }

    @Override
    public void actualizar(TipoBarco item) {
        TipoBarco objBarco = ConsultarReferencia(item.getId());
        objBarco.setId(item.getId());
        objBarco.setDescripcion(item.getDescripcion());
        objBarco.setCapacidadCarga(item.getCapacidadCarga());
        objBarco.setCapacidadPersonas(item.getCapacidadPersonas());
    }

    @Override
    public void eliminar(int id) {
       tipoBarcos.removeNodo(id);
    }

}
