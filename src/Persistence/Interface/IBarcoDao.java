/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Barco;
import Class.Barcos;

/**
 *
 * @author Andres
 */
public interface IBarcoDao {
    Barcos Consultar();
    Barco Consultar(int id);
    void Guardar(Barco barco);
    void Actualizar(Barco barco);
    void Eliminar(int id);
    
}
