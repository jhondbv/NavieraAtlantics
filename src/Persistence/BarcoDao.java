/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Barco;
import Class.Barcos;
import Persistence.Interface.IBarcoDao;
import java.io.File;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author jhon
 */
public class BarcoDao implements IBarcoDao {

    private static Barcos barcos = new Barcos();

    public BarcoDao() {
        barcos = Archivos.Repositories.barcos;
    }

    @Override
    public Barcos Consultar() {
        return barcos;
    }

    @Override
    public Barco Consultar(int id) {
        for (Barco barco : barcos.List) {
            if (barco.getId() == id) {
                return new Barco(barco);
            }
        }
        return null;
    }

    private Barco ConsultarReferencia(int id) {

        for (Barco barco : barcos.List) {
            if (barco.getId() == id) {
                return barco;
            }
        }
        return null;
    }

    @Override
    public void Guardar(Barco barco) {
        int maxpos = barcos.List.size() - 1;
        Barco lastBarco;
         if(maxpos<0){
           maxpos=0;
           lastBarco =new Barco();
        }else{
          lastBarco = barcos.List.get(maxpos);
         }
        
        if (lastBarco != null) {
            barco.setId(lastBarco.getId() + 1);
            barcos.List.add(barco);
        }
    }

    @Override
    public void Actualizar(Barco barco) {
        Barco objBarco = ConsultarReferencia(barco.getId());
        objBarco.setId(barco.getId());
        objBarco.setRegMerc(barco.getRegMerc());
        objBarco.setIdTipoBarco(barco.getIdTipoBarco());
    }

    @Override
    public void Eliminar(int id) {
        Barco deleteItem = ConsultarReferencia(id);
        barcos.List.remove(barcos.List.indexOf(deleteItem));
    }

}
