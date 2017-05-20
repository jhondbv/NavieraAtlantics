/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Esposa;
import Class.Esposas;
import Persistence.Interface.IEsposaDao;

/**
 *
 * @author jhon_Ballesteros
 */
public class EsposaDao implements IEsposaDao {

        private static Esposas lstItems = new Esposas();

    
      public EsposaDao() {
        //lstItems = Archivos.Repositories.esposas;
    }

    @Override
    public Esposas Consultar() {
        return lstItems;
    }

    @Override
    public Esposa Consultar(int id) {

        for (Esposa item : lstItems.List) {
            if (item.getId() == id) {
                return new Esposa(item);
            }
        }
        return null;
    }

    private Esposa ConsultarReferencia(int id) {

        for (Esposa item : lstItems.List) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void Guardar(Esposa item) {
        int maxpos = lstItems.List.size() - 1;
        Esposa lastEsposa;
         if(maxpos<0){
           maxpos=0;
           lastEsposa =new Esposa();
        }else{
         lastEsposa=lstItems.List.get(maxpos);
         }
        if (lastEsposa != null) {
            item.setId(lastEsposa.getId() + 1);
            lstItems.List.add(item);
        }

    }

    @Override
    public void Actualizar(Esposa item) {
        Esposa objItem = ConsultarReferencia(item.getId());
        objItem.setIdEsposo(item.getIdEsposo());
          objItem.setNombre(item.getNombre());
        objItem.setSexo(item.getSexo());
    }

    @Override
    public void Eliminar(int id) {
        Esposa deleteItem = ConsultarReferencia(id);

        lstItems.List.remove(lstItems.List.indexOf(deleteItem));
    }
    
}
