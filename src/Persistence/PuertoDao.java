/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Puerto;
import Class.Puertos;
import Persistence.Interface.IPuertoDao;
import java.io.File;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author jhon_Ballesteros
 */
public class PuertoDao implements IPuertoDao {

    private static Puertos lstItems = new Puertos();

    public PuertoDao() {
        lstItems = Archivos.Repositories.puertos;
    }

    @Override
    public Puertos Consultar() {
        return lstItems;
    }

    @Override
    public Puerto Consultar(int id) {

        for (Puerto item : lstItems.List) {
            if (item.getId() == id) {
                return new Puerto(item);
            }
        }
        return null;
    }

    private Puerto ConsultarReferencia(int id) {

        for (Puerto item : lstItems.List) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void Guardar(Puerto item) {
        int maxpos = lstItems.List.size() - 1;
        Puerto lastItem;

        if (maxpos < 0) {
            maxpos = 0;
            lastItem = new Puerto();
        } else {
            lastItem = lstItems.List.get(maxpos);
        }
        if (lastItem != null) {
            item.setId(lastItem.getId() + 1);
            lstItems.List.add(item);
        }

    }

    @Override
    public void Actualizar(Puerto item) {
        Puerto objItem = ConsultarReferencia(item.getId());
        objItem.setDescripcion(item.getDescripcion());

    }

    @Override
    public void Eliminar(int id) {
        Puerto deleteItem = ConsultarReferencia(id);

        lstItems.List.remove(lstItems.List.indexOf(deleteItem));
    }

}
