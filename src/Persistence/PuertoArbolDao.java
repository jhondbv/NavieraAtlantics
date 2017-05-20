/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.Puerto;
import Class.Puertos;
import static Persistence.Archivos.Repositories.tipoBarcos;
import Persistence.Interface.IPuertoDao;
import java.util.List;

/**
 *
 * @author jhon
 */
public class PuertoArbolDao implements IPuertoDao  {

     private static ArbolAvl lstItems = new ArbolAvl();
     
     public PuertoArbolDao()
     {
        lstItems = Archivos.Repositories.puertos;
     
     }
    @Override
    public Puertos Consultar() {
        Puertos list = new Puertos();
        list.List=(List<Puerto>) (Object) lstItems.generarLista();
        return  list;
    }
    private Puerto ConsultarReferencia(int id) {

        for (Puerto puerto : Consultar().List) {
            if (puerto.getId() == id) {
                return puerto;
            }
        }
        return null;
    }

    @Override
    public Puerto Consultar(int id) {
        Puerto referencia = (Puerto) lstItems.getObject(id);
        Puerto barquito = new Puerto();
        if (referencia != null) {
            barquito = new Puerto(referencia);
        }

        return barquito;
    }

    @Override
    public void Guardar(Puerto item) {
        NodoDobleAvl lastNode = lstItems.getLastNode(lstItems.raiz);
        int id=1;
        if(lastNode != null)
        {
            Puerto tipobarco = (Puerto) lastNode.retornaDato();
            id = tipobarco.getId() + 1;
        }
        
        item.setId(id);
        lstItems.insertarDatoEnAvl(item, id);
    }

    @Override
    public void Actualizar(Puerto item) {
         Puerto objItem = ConsultarReferencia(item.getId());
        objItem.setDescripcion(item.getDescripcion());
    }

    @Override
    public void Eliminar(int id) {
       lstItems.removeNodo(id);
    }
    
}
