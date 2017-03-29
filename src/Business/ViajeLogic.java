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
        DAO.Guardar(viaje);
    }
    
    public void EliminarViaje(int id)
    {
        DAO.Eliminar(id);
        DAO.GuardarCambios();
    }
    
    public void ActualizarViaje(Viaje viaje )
    {
        DAO.Actualizar(viaje);
        DAO.GuardarCambios();
    }
    
    public Viaje ConsultarViaje(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Viajes ConsultarViajes()
    {
        return DAO.Consultar();
    }
}
