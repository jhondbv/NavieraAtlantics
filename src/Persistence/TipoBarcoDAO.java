/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Barco;
import Class.TipoBarco;
import Class.TipoBarcos;
import Class.Viaje;
import Persistence.Interface.ITipoBarcoDAO;

/**
 *
 * @author Penagos
 */
public class TipoBarcoDAO implements ITipoBarcoDAO {

    private TipoBarcos tipoBarcos = new TipoBarcos();

    public TipoBarcoDAO() {
        tipoBarcos = Archivos.Repositories.tipoBarcos;
    }

    @Override
    public TipoBarcos Consultar() {
        return tipoBarcos;
    }

    @Override
    public TipoBarco Consultar(int id) {
        for (TipoBarco barquito : tipoBarcos.List) {
            if (barquito.getId() == id) {
                return new TipoBarco(barquito);
            }
        }
        return null;
    }

    private TipoBarco ConsultarReferencia(int id) {

        for (TipoBarco tipobarco : tipoBarcos.List) {
            if (tipobarco.getId() == id) {
                return tipobarco;
            }
        }
        return null;
    }

    @Override
    public void guardar(TipoBarco item) {
        int maxpos = tipoBarcos.List.size() - 1;
        TipoBarco lastBarco;
        if (maxpos < 0) {
            maxpos = 0;
            lastBarco = new TipoBarco();
        } else {
            lastBarco = tipoBarcos.List.get(maxpos);

        }

        if (lastBarco != null) {
            item.setId(lastBarco.getId() + 1);
            tipoBarcos.List.add(item);
        }
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
        TipoBarco deleteBarco = ConsultarReferencia(id);
        tipoBarcos.List.remove(tipoBarcos.List.indexOf(deleteBarco) );
    }

}
