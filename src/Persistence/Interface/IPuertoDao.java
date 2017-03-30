/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Puerto;
import Class.Puertos;



/**
 *
 * @author jhon_Ballesteros
 */
public interface IPuertoDao {
    Puertos Consultar();
    Puerto Consultar(int id);
    void Guardar(Puerto viaje);
    void Actualizar(Puerto viaje);
    void Eliminar(int id);
}
