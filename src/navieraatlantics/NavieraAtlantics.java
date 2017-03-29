/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navieraatlantics;

import Class.Viaje;
import java.io.File;
import javax.swing.JOptionPane;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author jhon
 */
public class NavieraAtlantics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Serializer serializer = new Persister();
        Viaje viaje = new Viaje();
        viaje.setId(0);
        viaje.setIdBarco(1);
        viaje.setIdPuertoDestino(3);
        viaje.setIdPuertoOrigen(2);
        viaje.setNumEncomiendas(3);
        viaje.setPuertosAtraco("1,2,3,4");
        viaje.setTripulacion("1,4,5");
        File result = new File("DataBaseFiles/example.xml");
        try {
            serializer.write(viaje, result);
        } catch (Exception ex) {
        }

    }

}
