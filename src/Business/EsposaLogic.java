/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Esposa;
import Class.Esposas;
import Persistence.EsposaDao;
import Persistence.Interface.IEsposaDao;

/**
 *
 * @author jhon_Ballesteros
 */
public class EsposaLogic {
      private IEsposaDao DAO =null; 

  
    
    public  EsposaLogic()
    {
        DAO=new EsposaDao();
    }
    
    public void Guardar(Esposa item)
    {
        DAO.Guardar(item);
    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Esposa item )
    {
        DAO.Actualizar(item);
       
    }
    
    public Esposa Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Esposas Consultar()
    {
        return DAO.Consultar();
    }
}
