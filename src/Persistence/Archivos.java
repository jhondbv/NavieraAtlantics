/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Class.ArbolAvl.ArbolAvl;
import Class.ArbolAvl.DatoNodo;
import Class.Barco;
import Class.TipoBarcos;
import Class.Barcos;
import Class.Esposa;
import Class.Esposas;
import Class.Hijo;
import Class.Hijos;
import Class.Marinero;
import Class.Marineros;
import Class.Puertos;
import Class.Puerto;
import Class.Testamentos;
import Class.TipoBarco;
import Class.Viaje;
import Class.Viajes;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 *
 * @author jhon
 */
public class Archivos {

    public static class Repositories {

        private final String Archivo_TipoBarcos = "DataBaseFiles/TipoBarcos.xml";
        private final String Archivo_Viaje = "DataBaseFiles/viajes.xml";
        private final String Archivo_Puertos = "DataBaseFiles/puertos.xml";
        private final String Archivo_Barcos = "DataBaseFiles/barcos.xml";
        private final String Archivo_Hijos = "DataBaseFiles/hijos.xml";
        private final String Archivo_Marineros = "DataBaseFiles/marineros.xml";
        private final String Archivo_Esposas = "DataBaseFiles/esposas.xml";
        private final String Archivo_Testamentos = "DataBaseFiles/testamentos.xml";

        public static ArbolAvl tipoBarcos;
        public static ArbolAvl viajes;
        public static ArbolAvl puertos;
        public static ArbolAvl barcos;
        public static ArbolAvl marineros;
        public static ArbolAvl hijos;
        public static ArbolAvl esposas;
        public static Testamentos testamentos;

        public Repositories(boolean cargaInicial) {
            if (cargaInicial) {

                LoadTipoBarcos();
                LoadViajes();
                LoadPuertos();
                LoadBarcos();
                LoadEsposas();
                LoadHijos();
                LoadMarineros();
                LoadTestamentos();

            }
        }

        private void LoadTipoBarcos() {
            File file = new File(Archivo_TipoBarcos);
            Serializer serializer = new Persister();
            try {
                tipoBarcos = new ArbolAvl();
                TipoBarcos tipoBarcoss = new TipoBarcos();
                tipoBarcoss = serializer.read(TipoBarcos.class, file);
                if(tipoBarcoss == null)
                {
                   
                    return ;
                }
                List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (TipoBarco tipo : tipoBarcoss.List) {

                    int id = tipo.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=tipo;
                    dt.id=tipo.getId();
                    datosNodos.add(dt);
                }
               tipoBarcos = new ArbolAvl();
               tipoBarcos.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }

        private void LoadViajes() {
            File file = new File(Archivo_Viaje);
            Serializer serializer = new Persister();
            try {
                viajes = new ArbolAvl();
                
                Viajes objViajes = new Viajes();
                objViajes = serializer.read(Viajes.class, file);
                if(objViajes == null)
                {
                   
                    return ;
                }
            List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (Viaje viaje : objViajes.List) {

                    int id = viaje.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=viaje;
                    dt.id=viaje.getId();
                    datosNodos.add(dt);
                }
               viajes = new ArbolAvl();
               viajes.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }

       

        private void LoadPuertos() {
            File file = new File(Archivo_Puertos);
            Serializer serializer = new Persister();
            try {
                puertos= new ArbolAvl();
                
                Puertos objPuertos = new Puertos();
                objPuertos= serializer.read(Puertos.class, file);
                if(objPuertos == null)
                {
                   
                    return ;
                }
                List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (Puerto puerto : objPuertos.List) {

                    int id = puerto.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=puerto;
                    dt.id=puerto.getId();
                    datosNodos.add(dt);
                }
               puertos = new ArbolAvl();
               puertos.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }
        
        
        
         

        private void LoadBarcos() {
            File file = new File(Archivo_Barcos);
            Serializer serializer = new Persister();
            try {
                barcos= new ArbolAvl();
                
                Barcos objBarcos = new Barcos();
                objBarcos= serializer.read(Barcos.class, file);
                if(objBarcos == null)
                {
                   
                    return ;
                }
                List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (Barco barco : objBarcos.List) {

                    int id = barco.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=barco;
                    dt.id=barco.getId();
                    datosNodos.add(dt);
                }
               barcos = new ArbolAvl();
               barcos.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }
        
        
        
          private void LoadMarineros() {
            File file = new File(Archivo_Marineros);
            Serializer serializer = new Persister();
           try {
                marineros= new ArbolAvl();
                
                Marineros objMarineros = new Marineros();
                objMarineros= serializer.read(Marineros.class, file);
                if(objMarineros == null)
                {
                   
                    return ;
                }
                List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (Marinero marinero : objMarineros.List) {

                    int id = marinero.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=marinero;
                    dt.id=marinero.getId();
                    datosNodos.add(dt);
                }
               marineros = new ArbolAvl();
               marineros.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }
        
          
          
        
         private void LoadHijos() {
            File file = new File(Archivo_Hijos);
            Serializer serializer = new Persister();
            try {
                hijos= new ArbolAvl();
                
                Hijos objHijos = new Hijos();
                objHijos= serializer.read(Hijos.class, file);
                if(objHijos == null)
                {
                   
                    return ;
                }
                List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (Hijo hijo : objHijos.List) {

                    int id = hijo.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=hijo;
                    dt.id=hijo.getId();
                    datosNodos.add(dt);
                }
               hijos = new ArbolAvl();
               hijos.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }
        
         private void LoadEsposas() {
            File file = new File(Archivo_Esposas);
            Serializer serializer = new Persister();
           try {
                esposas= new ArbolAvl();
                
                Esposas objEsposas = new Esposas();
                objEsposas= serializer.read(Esposas.class, file);
                if(objEsposas == null)
                {
                   
                    return ;
                }
                List<DatoNodo> datosNodos = new ArrayList<DatoNodo>();
                for (Esposa esposa : objEsposas.List) {

                    int id = esposa.getId();
                    DatoNodo dt = new DatoNodo();
                    dt.dato=esposa;
                    dt.id=esposa.getId();
                    datosNodos.add(dt);
                }
               esposas = new ArbolAvl();
               esposas.construyeAvl(datosNodos);
            } catch (Exception ex) {

            }
        }
         
         
         
        
        private void LoadTestamentos() {
            File file = new File(Archivo_Testamentos);
            Serializer serializer = new Persister();
            try {
                testamentos = new Testamentos();

                testamentos = serializer.read(Testamentos.class, file);
            } catch (Exception ex) {

            }
        }
        
      

       

       

        

        private void GuardarTipoBarcos() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_TipoBarcos);
            try {
                TipoBarcos objTipoBarcos = new TipoBarcos();
                objTipoBarcos.List=(List<TipoBarco>)(Object)tipoBarcos.generarLista();
                serializer.write(objTipoBarcos, file);

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

        private void GuardarMarineros() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Marineros);
            try {
                serializer.write(marineros, file);

            } catch (Exception ex) {
            }
        }

        private void GuardarEsposas() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Esposas);
            try {
                serializer.write(esposas, file);

            } catch (Exception ex) {
            }
        }

        private void GuardarHijos() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Hijos);
            try {
                serializer.write(hijos, file);

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

        private void GuardarTestamentos() {

            Serializer serializer = new Persister();
            File file = new File(Archivo_Testamentos);
            try {
                serializer.write(testamentos, file);

            } catch (Exception ex) {
            }
        }

        public void GuardarCambios() {
            GuardarTipoBarcos();
            GuardarViajes();
            GuardarPuertos();
            GuardarBarcos();
            GuardarEsposas();
            GuardarMarineros();
            GuardarHijos();
            GuardarTestamentos();
        }
    }

}
