/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Esposa;
import Class.Esposas;
import Class.Hijo;
import Class.Marinero;
import Class.Marineros;
import Persistence.EsposaArbolDao;
import Persistence.EsposaDao;
import Persistence.HijoArbolDao;
import Persistence.HijoDao;
import Persistence.Interface.IEsposaDao;
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
public class MarineroLogic {
      private IMarineroDao DAO =null; 
      private IEsposaDao esposaDao = null;
      private IHijoDao hijoDao=null;
   private  HashMap<Integer,Hijo> hashHijos =null;
    private  HashMap<Integer,Esposa> hashEsposas =null;
    
    public  MarineroLogic()
    {
        DAO=new MarineroArbolDao();
        esposaDao= new EsposaArbolDao();
        hijoDao = new HijoArbolDao();
        
         hashHijos = new HashMap<>();
        List<Hijo> items = hijoDao.Consultar().List;
        for (Hijo item : items) {
            hashHijos.put(item.getId(), item);
        }
        
          hashEsposas = new HashMap<>();
        List<Esposa> eitems = esposaDao.Consultar().List;
        for (Esposa item : eitems) {
            hashEsposas.put(item.getId(), item);
        }
    }
    
    public void Guardar(Marinero item) throws Exception
    {
        DAO.Guardar(item);
        if(item.isIsCapitan())
        {
            if(item.getIdEsposa()==0)
                throw new Exception("Para ser capitan se debe tener esposa ");
        }
        if (item.getIdEsposa() > 0) {
            Esposa esposa = hashEsposas.get(item.getIdEsposa());
            esposa.setIdEsposo(item.getId());
            esposaDao.Actualizar(esposa);
        }
        if(item.getHijos().size()>0)
        {
            for (int i = 0; i < item.getHijos().size(); i++) {
                Hijo hijo = hijoDao.Consultar(item.getHijos().get(i).id);
                hijo.setIdPapa(item.getId());
                hijoDao.Actualizar(hijo);
            }
        }

    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Marinero item ) throws Exception
    {
        DAO.Actualizar(item);
        if(item.isIsCapitan())
        {
            if(item.getIdEsposa()==0)
                throw new Exception("Para ser capitan se debe tener esposa ");
        }
        if (item.getIdEsposa() > 0) {
            Esposa esposa = hashEsposas.get(item.getIdEsposa());
            esposa.setIdEsposo(item.getId());
            esposaDao.Actualizar(esposa);
        }
        if(item.getHijos().size()>0)
        {
            for (int i = 0; i < item.getHijos().size(); i++) {
                Hijo hijo = hijoDao.Consultar(item.getHijos().get(i).id);
                hijo.setIdPapa(item.getId());
                hijoDao.Actualizar(hijo);
            }
        }
    }
    
    public Marinero Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Marineros Consultar()
    {
        return DAO.Consultar();
    }
    
     public Marineros ConsultarConRelaciones()
    {
        Marineros items =  DAO.Consultar();
        if(items!=null)
        {
            for (Marinero item  : items.List) {
                item.esposa =  hashEsposas.get(item.getIdEsposa());
            }
            
        }
        return items;
    }
}
