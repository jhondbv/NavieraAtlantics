/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.Esposa;
import Class.Esposas;
import Persistence.Interface.IEsposaDao;
import java.util.List;

/**
 *
 * @author jhon
 */
public class EsposaArbolDao implements IEsposaDao{

     private static ArbolAvl lstItems = new ArbolAvl();
     
     public EsposaArbolDao()
     {
        lstItems = Archivos.Repositories.esposas;
     
     }
    @Override
    public Esposas Consultar() {
        Esposas list = new Esposas();
        list.List=(List<Esposa>) (Object) lstItems.generarLista();
        return  list;
    }
    private Esposa ConsultarReferencia(int id) {

        for (Esposa obj : Consultar().List) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public Esposa Consultar(int id) {
        Esposa referencia = (Esposa) lstItems.getObject(id);
        Esposa newItem = new Esposa();
        if (referencia != null) {
            newItem = new Esposa(referencia);
        }

        return newItem;
    }

    @Override
    public void Guardar(Esposa item) {
        NodoDobleAvl lastNode = lstItems.getLastNode(lstItems.raiz);
        int id=1;
        if(lastNode != null)
        {
            Esposa obj = (Esposa) lastNode.retornaDato();
            id = obj.getId() + 1;
        }
        
        item.setId(id);
        lstItems.insertarDatoEnAvl(item, id);
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
       lstItems.removeNodo(id);
    }
    
}
