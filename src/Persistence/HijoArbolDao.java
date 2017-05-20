/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.Hijo;
import Class.Hijos;
import Persistence.Interface.IHijoDao;
import java.util.List;

/**
 *
 * @author jhon
 */
public class HijoArbolDao implements IHijoDao{
 private static ArbolAvl lstItems = new ArbolAvl();
     
     public HijoArbolDao()
     {
        lstItems = Archivos.Repositories.hijos;
     
     }
    @Override
    public Hijos Consultar() {
        Hijos list = new Hijos();
        list.List=(List<Hijo>) (Object) lstItems.generarLista();
        return  list;
    }
    private Hijo ConsultarReferencia(int id) {

        for (Hijo obj : Consultar().List) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public Hijo Consultar(int id) {
        Hijo referencia = (Hijo) lstItems.getObject(id);
        Hijo newItem = new Hijo();
        if (referencia != null) {
            newItem = new Hijo(referencia);
        }

        return newItem;
    }

    @Override
    public void Guardar(Hijo item) {
        NodoDobleAvl lastNode = lstItems.getLastNode(lstItems.raiz);
        int id=1;
        if(lastNode != null)
        {
            Hijo obj = (Hijo) lastNode.retornaDato();
            id = obj.getId() + 1;
        }
        
        item.setId(id);
        lstItems.insertarDatoEnAvl(item, id);
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
       lstItems.removeNodo(id);
    }
    
    
}
