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
    
    Viajes Consultar();
    Viaje Consultar(int id);
    void Guardar(Viaje viaje);
    void Actualizar(Viaje viaje);
    void Eliminar(int id);
    
}
