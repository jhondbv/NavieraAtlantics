/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Marinero;
import Class.Marineros;
import Persistence.Interface.IMarineroDao;
import java.util.Set;

/**
 *
 * @author jhon_Ballesteros
 */
public class MarineroDao implements IMarineroDao {

    private static Marineros lstItems = new Marineros();

    public MarineroDao() {
        lstItems = Archivos.Repositories.marineros;
    }

    @Override
    public Marineros Consultar() {
        return lstItems;
    }

    @Override
    public Marinero Consultar(int id) {

        for (Marinero item : lstItems.List) {
            if (item.getId() == id) {
                return new Marinero(item);
            }
        }
        return null;
    }

    private Marinero ConsultarReferencia(int id) {

        for (Marinero item : lstItems.List) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void Guardar(Marinero item) {
        int maxpos = lstItems.List.size() - 1;
        Marinero lastMarinero;
         if(maxpos<0){
           maxpos=0;
           lastMarinero=new Marinero();
         }else{
             lastMarinero=lstItems.List.get(maxpos);
         }
        if (lastMarinero != null) {
            item.setId(lastMarinero.getId() + 1);
            lstItems.List.add(item);
        }
    }

    @Override
    public void Actualizar(Marinero item) {
        Marinero objItem = ConsultarReferencia(item.getId());
        objItem.setIdEsposa(item.getIdEsposa());
        objItem.setHijos(item.getHijos());
        objItem.setIdTestamento(item.getIdTestamento());
        objItem.setNombre(item.getNombre());
        objItem.setSexo(item.getSexo());

    }

    @Override
    public void Eliminar(int id) {
        Marinero deleteItem = Consultar(id);
        lstItems.List.remove(deleteItem);
    }

}
