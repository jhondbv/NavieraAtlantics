/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Persona;
import Class.Personas;
import Class.Viaje;
import Class.Viajes;

/**
 *
 * @author Penagos
 */
public interface IPersonas {
    
    Personas Consultar();
    Persona Consultar(int id);
    void Guardar(Persona persona);
    void Actualizar(Persona persona);
    void Eliminar(int id);
    void GuardarCambios();
    
    
}
