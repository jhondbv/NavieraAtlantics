/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Testamento;
import Class.Testamentos;
import Persistence.Interface.ITestamentoDao;
import java.util.Set;

/**
 *
 * @author jhon_Ballesteros
 */
public class TestamentoDao implements ITestamentoDao {
        private static Testamentos lstItems = new Testamentos();

    public TestamentoDao()
    {
        lstItems=Archivos.Repositories.testamentos;
    }
    
    @Override
    public Testamentos Consultar() {
        return lstItems;
    }

    @Override
    public Testamento Consultar(int id) {
    
        for (Testamento item : lstItems.List) {
            if (item.getId() == id) {
                return new Testamento(item);
            }
        }
        return null;
    }
    
    private Testamento ConsultarReferencia(int id) {

        for (Testamento item : lstItems.List) {
            if (item.getId() == id) {
                return  item;
            }
        }
        return null;
    }
    

    @Override
    public void Guardar(Testamento item) {
         int maxpos = lstItems.List.size() - 1;
          if(maxpos<0)
           maxpos=0;
        Testamento lastItem = lstItems.List.get(maxpos);
        if (lastItem != null) {
            item.setId(lastItem.getId() + 1);
            lstItems.List.add(item);
        }
    
    }

    @Override
    public void Actualizar(Testamento item) {
        Testamento objItem = ConsultarReferencia(item.getId());
      objItem.setPorcentajeEsposa(item.getPorcentajeEsposa());
      objItem.setPorcentajeHijos(item.getPorcentajeHijos());
       
    
    }

    @Override
    public void Eliminar(int id) {
        Testamento deleteItem = Consultar(id);

        lstItems.List.remove(deleteItem);
    }

}
