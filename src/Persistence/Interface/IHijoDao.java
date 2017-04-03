/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Hijo;
import Class.Hijos;

/**
 *
 * @author jhon_Ballesteros
 */
public interface IHijoDao {

    Hijos Consultar();

    Hijo Consultar(int id);

    void Guardar(Hijo item);

    void Actualizar(Hijo item);

    void Eliminar(int id);
}
