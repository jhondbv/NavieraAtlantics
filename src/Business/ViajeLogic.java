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
public class ViajeLogic {
    
    private IViajeDao DAO =null; 

  
    
    public  ViajeLogic()
    {
        DAO=new ViajeDao();
    }
    
    public void GuardarViaje(Viaje viaje)
    {
        DAO.GuardarViaje(viaje);
    }
    
    public void EliminarViaje(int id)
    {
        DAO.EliminarViaje(id);
        DAO.GuardarCambios();
    }
    
    public void ActualizarViaje(Viaje viaje )
    {
        DAO.ActualizarViaje(viaje);
    }
    
    public Viaje ConsultarViaje(int id)
    {
        return DAO.ConsultarViaje(id);
    }
    
    public Viajes ConsultarViajes()
    {
        return DAO.ConsultarViajes();
    }
}
