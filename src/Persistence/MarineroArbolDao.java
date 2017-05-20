/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.Marinero;
import Class.Marineros;
import Persistence.Interface.IMarineroDao;
import java.util.List;

/**
 *
 * @author jhon
 */
public class MarineroArbolDao implements IMarineroDao {

  private static ArbolAvl lstItems = new ArbolAvl();
     
     public MarineroArbolDao()
     {
        lstItems = Archivos.Repositories.marineros;
     
     }
    @Override
    public Marineros Consultar() {
        Marineros list = new Marineros();
        list.List=(List<Marinero>) (Object) lstItems.generarLista();
        return  list;
    }
    private Marinero ConsultarReferencia(int id) {

        for (Marinero obj : Consultar().List) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public Marinero Consultar(int id) {
        Marinero referencia = (Marinero) lstItems.getObject(id);
        Marinero newItem = new Marinero();
        if (referencia != null) {
            newItem = new Marinero(referencia);
        }

        return newItem;
    }

    @Override
    public void Guardar(Marinero item) {
        NodoDobleAvl lastNode = lstItems.getLastNode(lstItems.raiz);
        int id=1;
        if(lastNode != null)
        {
            Marinero obj = (Marinero) lastNode.retornaDato();
            id = obj.getId() + 1;
        }
        
        item.setId(id);
        lstItems.insertarDatoEnAvl(item, id);
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
       lstItems.removeNodo(id);
    }
    
}
