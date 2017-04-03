/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Marinero;
import Class.Marineros;


/**
 *
 * @author jhon_Ballesteros
 */
public interface IMarineroDao {
    Marineros Consultar();
    Marinero Consultar(int id);
    void Guardar(Marinero item);
    void Actualizar(Marinero item);
    void Eliminar(int id);
}
