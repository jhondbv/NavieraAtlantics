/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Esposa;
import Class.Esposas;

/**
 *
 * @author jhon_Ballesteros
 */
public interface IEsposaDao {

    Esposas Consultar();

    Esposa Consultar(int id);

    void Guardar(Esposa item);

    void Actualizar(Esposa item);

    void Eliminar(int id);
}
