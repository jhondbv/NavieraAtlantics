/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Hijo;
import Class.Hijos;
import Persistence.Interface.IHijoDao;

/**
 *
 * @author jhon_Ballesteros
 */
public class HijoDao implements IHijoDao {

    private static Hijos lstItems = new Hijos();

    public HijoDao() {
        lstItems = Archivos.Repositories.hijos;
    }

    @Override
    public Hijos Consultar() {
        return lstItems;
    }

    @Override
    public Hijo Consultar(int id) {

        for (Hijo item : lstItems.List) {
            if (item.getId() == id) {
                return new Hijo(item);
            }
        }
        return null;
    }

    private Hijo ConsultarReferencia(int id) {

        for (Hijo item : lstItems.List) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void Guardar(Hijo item) {
        int maxpos = lstItems.List.size() - 1;
         if(maxpos<0)
           maxpos=0;
        Hijo lastItem = lstItems.List.get(maxpos);
        if (lastItem != null) {
            item.setId(lastItem.getId() + 1);
            lstItems.List.add(item);
        }

    }

    @Override
    public void Actualizar(Hijo item) {
        Hijo objItem = ConsultarReferencia(item.getId());
        objItem.setIdPapa(item.getIdPapa());
        objItem.setNombre(item.getNombre());
        objItem.setSexo(item.getSexo());
    }

    @Override
    public void Eliminar(int id) {
        Hijo deleteItem = Consultar(id);

        lstItems.List.remove(deleteItem);
    }

}
