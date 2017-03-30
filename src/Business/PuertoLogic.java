/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Puerto;
import Class.Puertos;
import Persistence.Interface.IPuertoDao;
import Persistence.PuertoDao;

/**
 *
 * @author jhon
 */
public class PuertoLogic {
     private IPuertoDao DAO =null; 

  
    
    public  PuertoLogic()
    {
        DAO=new PuertoDao();
    }
    
    public void Guardar(Puerto item)
    {
        DAO.Guardar(item);
    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Puerto item )
    {
        DAO.Actualizar(item);
       
    }
    
    public Puerto Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Puertos Consultar()
    {
        return DAO.Consultar();
    }
}
