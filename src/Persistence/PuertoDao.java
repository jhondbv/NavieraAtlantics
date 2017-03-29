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

    private final String Nombre_Archivo = "DataBaseFiles/puertos.xml";
    private static Puertos puertos = new Puertos();

    @Override
    public Puertos Consultar() {
         File file = new File(Nombre_Archivo);
        Serializer serializer = new Persister();
        try {
            puertos = serializer.read(Puertos.class, file);
        } catch (Exception ex) {

        }
    return puertos;
    }

    @Override
    public Puerto Consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Guardar(Puerto viaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Actualizar(Puerto viaje) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void GuardarCambios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
