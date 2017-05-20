/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Hijo;
import Class.Hijos;
import Class.Marinero;
import Persistence.HijoArbolDao;
import Persistence.HijoDao;
import Persistence.Interface.IHijoDao;
import Persistence.Interface.IMarineroDao;
import Persistence.MarineroArbolDao;
import Persistence.MarineroDao;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jhon_Ballesteros
 */
public class HijoLogic {
      private IHijoDao DAO =null; 
      private IMarineroDao marineroDAO=null;
  
     private  HashMap<Integer,Marinero> hashMarinero =null;
    public  HijoLogic()
    {
        DAO=new HijoArbolDao();
        marineroDAO=new MarineroArbolDao();
        
        hashMarinero = new HashMap<>();
        List<Marinero>marineros = marineroDAO.Consultar().List;
        for (Marinero marinero : marineros) {
            hashMarinero.put(marinero.getId(), marinero);
        }
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
    
    public Hijos ConsultarConRelaciones()
    {
        Hijos hijos =  DAO.Consultar();
        if(hijos!=null)
        {
            for (Hijo hijo : hijos.List) {
                hijo.padre =hashMarinero.get(hijo.getIdPapa());
            }
        }
        
        return hijos;
    }
}
