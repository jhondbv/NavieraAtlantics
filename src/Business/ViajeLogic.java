/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Viaje;
import Class.Viajes;
import Persistence.Interface.IViajeDao;
import Persistence.ViajeDao;

/**
 *
 * @author jhon_Ballesteros
 */
public  class ViajeLogic {
    
    private IViajeDao DAO =null; 

  
    
    public  ViajeLogic()
    {
        DAO=new ViajeDao();
    }
    
    public void Guardar(Viaje viaje)
    {
        DAO.Guardar(viaje);
    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Viaje viaje )
    {
        DAO.Actualizar(viaje);
       
    }
    
    public Viaje Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Viajes Consultar()
    {
        return DAO.Consultar();
    }

}
