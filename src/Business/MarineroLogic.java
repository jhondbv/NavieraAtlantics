/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Marinero;
import Class.Marineros;
import Persistence.Interface.IMarineroDao;
import Persistence.MarineroDao;

/**
 *
 * @author jhon_Ballesteros
 */
public class MarineroLogic {
      private IMarineroDao DAO =null; 

  
    
    public  MarineroLogic()
    {
        DAO=new MarineroDao();
    }
    
    public void Guardar(Marinero item)
    {
        DAO.Guardar(item);
    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Marinero item )
    {
        DAO.Actualizar(item);
       
    }
    
    public Marinero Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Marineros Consultar()
    {
        return DAO.Consultar();
    }
}
