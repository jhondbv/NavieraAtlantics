/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Esposa;
import Class.Esposas;
import Class.Marinero;
import Persistence.EsposaArbolDao;
import Persistence.EsposaDao;
import Persistence.Interface.IEsposaDao;
import Persistence.Interface.IMarineroDao;
import Persistence.MarineroArbolDao;
import Persistence.MarineroDao;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jhon_Ballesteros
 */
public class EsposaLogic {
      private IEsposaDao DAO =null; 
      private IMarineroDao MarineroDAO=null;
      private HashMap<Integer,Marinero>hashesposos=null;

  
    
    public  EsposaLogic()
    {
        DAO=new EsposaArbolDao();
        MarineroDAO=new MarineroArbolDao();
        
        hashesposos = new HashMap<>();
        List<Marinero>tipos = MarineroDAO.Consultar().List;
        for (Marinero tipo : tipos) {
            hashesposos.put(tipo.getId(), tipo);
        }  
    }
    
    
    
    public void Guardar(Esposa item)
    {
        item.setSexo("F");
        DAO.Guardar(item);
    }
    public void Eliminar(int id)
    {
        DAO.Eliminar(id); 
    }
    public void Actualizar(Esposa item )
    {
        item.setSexo("F");
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
    
    public Esposas ConsultarConRelaciones()
    {
        Esposas esposas =  DAO.Consultar();
        if(esposas!=null)
        {
            for (Esposa esposa : esposas.List) {
                if(esposa.getIdEsposo()>0)
                esposa.esposo=hashesposos.get(esposa.getIdEsposo());
            }
            
        }
        
        return esposas;
    }
}
