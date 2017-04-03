/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.Barcos;
import Class.Puertos;
import Class.Viajes;
import java.io.File;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author jhon
 */
public class Archivos {

    public static class Repositories {

        private final String Archivo_Viaje = "DataBaseFiles/viajes.xml";
        private final String Archivo_Puertos = "DataBaseFiles/puertos.xml";
        private final String Archivo_Barcos = "DataBaseFiles/barcos.xml";
        public static Viajes viajes;
        public static Puertos puertos;
        public static Barcos barcos;

        public Repositories(boolean cargaInicial) {
            if (cargaInicial) {

                LoadViajes();
                LoadPuertos();
                LoadBarcos();
            }
        }

        private void LoadViajes() {
            File file = new File(Archivo_Viaje);
            Serializer serializer = new Persister();
            try {
                viajes = serializer.read(Viajes.class, file);
            } catch (Exception ex) {

            }
        }

        private void LoadPuertos() {
            File file = new File(Archivo_Puertos);
            Serializer serializer = new Persister();
            try {
                puertos = serializer.read(Puertos.class, file);
            } catch (Exception ex) {

            }
        }

        private void LoadBarcos() {
            File file = new File(Archivo_Barcos);
            Serializer serializer = new Persister();
            try {
                barcos = serializer.read(Barcos.class, file);
            } catch (Exception ex) {

            }
        }

        private void GuardarViajes() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Viaje);
            try {
                serializer.write(viajes, file);

            } catch (Exception ex) {
            }
        }

        private void GuardarPuertos() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Puertos);
            try {
                serializer.write(puertos, file);

            } catch (Exception ex) {
            }
        }

        private void GuardarBarcos() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Barcos);
            try {
                serializer.write(barcos, file);

            } catch (Exception ex) {
            }
        }

        public void GuardarCambios() {
            GuardarViajes();
            GuardarPuertos();
            GuardarBarcos();
        }
    }

}
