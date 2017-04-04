/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navieraatlantics;

import Class.*;
import Business.*;
import Persistence.Archivos;
import Persistence.Archivos.Repositories;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author jhon
 */
public class NavieraAtlantics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new Archivos.Repositories(true);
        InitializeFile();
       ViajeLogic logic = new ViajeLogic();
       Viaje viaje = logic.Consultar(356);
       viaje.setPuertosAtraco("0,1,0,1");
       logic.Actualizar(viaje);
       new Archivos.Repositories(false).GuardarCambios();
       //logic.EliminarViaje(400);
      
    }

    public static void InitializeFile() {
        
        Random randomGenerator = new Random();
        Viajes viajes = new Viajes();

        for (int i = 0; i < 500; i++) {
            int randomInt = randomGenerator.nextInt(100);
            String puertos = String.format("%1$d,%2$d,%3$d", randomGenerator.nextInt(50), randomGenerator.nextInt(10),
                    randomGenerator.nextInt(50),
                    randomGenerator.nextInt(70));
            List<Tripulacion> tripulantes = new ArrayList<Tripulacion>();
            Tripulacion tripulante = new Tripulacion();
                        Tripulacion tripulante2 = new Tripulacion();
            Tripulacion tripulante3 = new Tripulacion();

            tripulante.setId(randomGenerator.nextInt(20));
            tripulante.setTipo("Hijo");
            tripulantes.add(tripulante);
            
             tripulante2.setId(randomGenerator.nextInt(20));
            tripulante2.setTipo("Marinero");
            tripulantes.add(tripulante2);
            
             tripulante3.setId(randomGenerator.nextInt(20));
            tripulante3.setTipo("Esposa");
            tripulantes.add(tripulante3);

            Viaje viaje = new Viaje();
            viaje.setId(i);
            viaje.setIdBarco(1);
            viaje.setIdPuertoDestino(3);
            viaje.setIdPuertoOrigen(2);
            viaje.setNumEncomiendas(randomInt);
            viaje.setPuertosAtraco(puertos);
            viaje.setTripulacion(tripulantes);
            viajes.List.add(viaje);
        }
       Archivos.Repositories.viajes=viajes;
       
       Puertos puertos = new Puertos();
        for (int i = 0; i < 10; i++) {
            Puerto puerto = new Puerto();
            puerto.setId(i);
            puerto.setDescripcion("Puerto #"+i);
            puertos.List.add(puerto);
        }
        
        Archivos.Repositories.puertos=puertos;
               
        new Archivos.Repositories(false).GuardarCambios();
    }

   

}
