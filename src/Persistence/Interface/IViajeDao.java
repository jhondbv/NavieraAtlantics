/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Viaje;
import Class.Viajes;

/**
 *
 * @author jhon_Ballesteros
 */
public interface IViajeDao {
    
    Viajes ConsultarViajes();
    Viaje ConsultarViaje(int id);
    void GuardarViaje(Viaje viaje);
    void ActualizarViaje(Viaje viaje);
    void EliminarViaje(int id);
    void GuardarCambios();
    
}
