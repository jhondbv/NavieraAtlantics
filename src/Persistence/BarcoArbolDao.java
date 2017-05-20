/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.NodoDobleAvl;
import Class.Barco;
import Class.Barcos;
import Persistence.Interface.IBarcoDao;
import java.util.List;

/**
 *
 * @author jhon
 */
public class BarcoArbolDao implements IBarcoDao {

     private static ArbolAvl lstItems = new ArbolAvl();
     
     public BarcoArbolDao()
     {
        lstItems = Archivos.Repositories.barcos;
     
     }
    @Override
    public Barcos Consultar() {
        Barcos list = new Barcos();
        list.List=(List<Barco>) (Object) lstItems.generarLista();
        return  list;
    }
    private Barco ConsultarReferencia(int id) {

        for (Barco puerto : Consultar().List) {
            if (puerto.getId() == id) {
                return puerto;
            }
        }
        return null;
    }

    @Override
    public Barco Consultar(int id) {
        Barco referencia = (Barco) lstItems.getObject(id);
        Barco newItem = new Barco();
        if (referencia != null) {
            newItem = new Barco(referencia);
        }

        return newItem;
    }

    @Override
    public void Guardar(Barco item) {
        NodoDobleAvl lastNode = lstItems.getLastNode(lstItems.raiz);
        int id=1;
        if(lastNode != null)
        {
            Barco obj = (Barco) lastNode.retornaDato();
            id = obj.getId() + 1;
        }
        
        item.setId(id);
        lstItems.insertarDatoEnAvl(item, id);
    }

    @Override
    public void Actualizar(Barco item) {
         Barco objBarco = ConsultarReferencia(item.getId());
        objBarco.setId(item.getId());
        objBarco.setRegMerc(item.getRegMerc());
        objBarco.setIdTipoBarco(item.getIdTipoBarco());
        objBarco.setNombre(item.getNombre());
        objBarco.tipoBarco=item.tipoBarco;
    }

    @Override
    public void Eliminar(int id) {
       lstItems.removeNodo(id);
    }
    
}
