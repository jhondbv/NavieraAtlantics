/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Hijo;
import Class.Hijos;
import Persistence.HijoDao;
import Persistence.Interface.IHijoDao;

/**
 *
 * @author jhon_Ballesteros
 */
public class HijoLogic {
      private IHijoDao DAO =null; 

  
    
    public  HijoLogic()
    {
        DAO=new HijoDao();
    }
    
    public void Guardar(Hijo item)
    {
        DAO.Guardar(item);
    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Hijo item )
    {
        DAO.Actualizar(item);
       
    }
    
    public Hijo Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Hijos Consultar()
    {
        return DAO.Consultar();
    }
}
