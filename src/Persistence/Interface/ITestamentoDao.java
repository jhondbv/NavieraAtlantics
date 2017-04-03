/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.Testamento;
import Class.Testamentos;

/**
 *
 * @author jhon_Ballesteros
 */
public interface ITestamentoDao {

    Testamentos Consultar();

    Testamento Consultar(int id);

    void Guardar(Testamento item);

    void Actualizar(Testamento item);

    void Eliminar(int id);
}
