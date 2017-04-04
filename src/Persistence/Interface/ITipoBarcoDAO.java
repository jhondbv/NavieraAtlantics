/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence.Interface;

import Class.TipoBarco;
import Class.TipoBarcos;

/**
 *
 * @author Penagos
 */
public interface ITipoBarcoDAO {
    
    
    TipoBarcos Consultar();
    TipoBarco Consultar(int id);
    void guardar (TipoBarco item);
    void actualizar (TipoBarco item);
    void eliminar (int id);
    
    
    
}
