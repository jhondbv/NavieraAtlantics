/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Class.TipoBarco;
import Class.TipoBarcos;
import Persistence.Interface.ITipoBarcoDAO;
import Persistence.TipoBarcoDAO;

/**
 *
 * @author Penagos
 */
public class TipoBarcoLogic {
    
    private ITipoBarcoDAO DAO =null;
    
   
    public TipoBarcoLogic(){
        DAO=new TipoBarcoDAO();
    }
    
    public void Guardar (TipoBarco barco){
        DAO.guardar(barco);
    }
    public void Eliminar(int id){
        DAO.eliminar(id);
    }
    public void Actualizar(TipoBarco barco){
        DAO.actualizar(barco);
    }
    public TipoBarco Consultar(int id){
        return DAO.Consultar(id);
    }

}
