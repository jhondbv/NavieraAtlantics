/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Class.Barco;
import Class.Barcos;
import Class.Esposa;
import Class.Hijo;
import Class.ID;
import Class.Marinero;
import Class.Puerto;
import Class.TipoBarco;
import Class.Viaje;
import Class.Viajes;
import Persistence.BarcoArbolDao;
import Persistence.BarcoDao;
import Persistence.EsposaArbolDao;
import Persistence.EsposaDao;
import Persistence.HijoArbolDao;
import Persistence.HijoDao;
import Persistence.Interface.IBarcoDao;
import Persistence.Interface.IEsposaDao;
import Persistence.Interface.IHijoDao;
import Persistence.Interface.IMarineroDao;
import Persistence.Interface.IPuertoDao;
import Persistence.Interface.ITipoBarcoDAO;
import Persistence.Interface.IViajeDao;
import Persistence.MarineroArbolDao;
import Persistence.MarineroDao;
import Persistence.PuertoArbolDao;
import Persistence.PuertoDao;
import Persistence.TipoBarcoArbolDao;
import Persistence.TipoBarcoDAO;
import Persistence.ViajeArbolDao;
import Persistence.ViajeDao;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jhon_Ballesteros
 */
public  class ViajeLogic {
    
    private IViajeDao DAO =null;
    private IPuertoDao PuertoDAO=null;
    private IBarcoDao BarcoDAO=null;
    private IEsposaDao EsposaDAO = null;
    private IHijoDao HijoDAO = null;
    private IMarineroDao MarineroDAO=null;
    private ITipoBarcoDAO TipoBarcoDAO=null;
    private  HashMap<Integer,Barco> hashBarcos =null;
    private  HashMap<Integer,Puerto> hashPuertos =null;
    private  HashMap<Integer,Marinero> hashMarineros =null;
    private HashMap<Integer,TipoBarco> hashTipoBarco = null ;
  
    
    public  ViajeLogic()
    {
        DAO=new ViajeArbolDao();
        PuertoDAO= new PuertoArbolDao();
        BarcoDAO= new BarcoArbolDao();
        EsposaDAO=new EsposaArbolDao();
        HijoDAO=new HijoArbolDao();
        MarineroDAO = new MarineroArbolDao();
        TipoBarcoDAO= new TipoBarcoArbolDao();
        
        hashBarcos = new HashMap<>();
        List<Barco> items = BarcoDAO.Consultar().List;
        for (Barco item : items) {
            hashBarcos.put(item.getId(), item);
        }
        
        hashPuertos = new HashMap<>();
        List<Puerto> itemsp  = PuertoDAO.Consultar().List;
        for (Puerto item : itemsp) {
            hashPuertos.put(item.getId(), item);
        }
          hashMarineros = new HashMap<>();
        List<Marinero> itemsMarineros  = MarineroDAO.Consultar().List;
        for (Marinero item : itemsMarineros) {
            hashMarineros.put(item.getId(), item);
        }
        
            hashTipoBarco = new HashMap<>();
        List<TipoBarco> itemsTipoBarco  = TipoBarcoDAO.Consultar().List;
        for (TipoBarco item : itemsTipoBarco) {
            hashTipoBarco.put(item.getId(), item);
        }
    }
    
    public void Guardar(Viaje viaje) throws Exception
    {
        Barco barco = hashBarcos.get(viaje.getIdBarco());
        TipoBarco tipo = hashTipoBarco.get(barco.getIdTipoBarco());
        int bCapitan = 0;
        if(viaje.getTripulacion().size()>tipo.getCapacidadPersonas())
        {
            throw new Exception("No puede exceder la capacidad de tripulacion del barco");
        }
        if(viaje.getNumEncomiendas()>tipo.getCapacidadCarga())
        {
          throw new Exception("No puede exceder la capacidad de carga del barco");
        }
        
        for (ID item : viaje.getTripulacion()) {
            
                Marinero marinero = hashMarineros.get(item.id);
                if(marinero.isIsCapitan())
                {
                    bCapitan++;
                }
        }
        
         for (ID item : viaje.getPuertosAtraco()) {
            
                Puerto puerto = hashPuertos.get(item.id);
                if(puerto.getId()==viaje.getIdPuertoDestino() || puerto.getId()==viaje.getIdPuertoOrigen())
                {
                    throw new Exception("Los puertos de atraco no pueden ser igual a los puertos de origen y destino");
                }
        }
        
        if(bCapitan!=1)
        {
            throw new Exception("Debe escoger solo 1 capitan para este viaje");
        }
        
        if(BarcoEnCurso(viaje.getIdBarco()))
        {
            throw new Exception("El barco seleccionado para este viaje , ya tiene otro viaje en curso ");
        }
        
        DAO.Guardar(viaje);
    }
    
    public boolean BarcoEnCurso(int idBarco)
    {
        Viajes viajes = Consultar();
        
        for(Viaje item : viajes.List)
        {
            if(item.getIdBarco()==idBarco && item.isEnCurso() && !item.isFinalizado())
            {
                return true;
            }
        }
        return false;
    }
    
    public void Eliminar(int id) throws Exception
    {
        Viaje viaje = Consultar(id);
        if(viaje.isEnCurso())
        {
             throw new Exception("El viaje se encuentra en curso , debe finalizarlo para poderlo eliminar");
             
        }
        DAO.Eliminar(id);
       
    }
    
    public void Actualizar(Viaje viaje ) throws Exception
    {
        Barco barco = hashBarcos.get(viaje.getIdBarco());
        TipoBarco tipo = hashTipoBarco.get(barco.getIdTipoBarco());
        int bCapitan = 0;
        if(viaje.getTripulacion().size()>tipo.getCapacidadPersonas())
        {
            throw new Exception("No puede exceder la capacidad de tripulacion del barco");
        }
        if(viaje.getNumEncomiendas()>tipo.getCapacidadCarga())
        {
          throw new Exception("No puede exceder la capacidad de carga del barco");
        }
        
        for (ID item : viaje.getTripulacion()) {
            
                Marinero marinero = hashMarineros.get(item.id);
                if(marinero.isIsCapitan())
                {
                    bCapitan++;
                }
        }
        
         for (ID item : viaje.getPuertosAtraco()) {
            
                Puerto puerto = hashPuertos.get(item.id);
                if(puerto.getId()==viaje.getIdPuertoDestino() || puerto.getId()==viaje.getIdPuertoOrigen())
                {
                    throw new Exception("Los puertos de atraco no pueden ser igual a los puertos de origen y destino");
                }
        }
        
        if(bCapitan!=1)
        {
            throw new Exception("Debe escoger solo 1 capitan para este viaje");
        }
        
        if(BarcoEnCurso(viaje.getIdBarco()))
        {
            throw new Exception("El barco seleccionado para este viaje , ya tiene otro viaje en curso ");
        }
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
    
     public Viajes ConsultarConRelaciones()
    {
        Viajes viajes =  DAO.Consultar();
        if(viajes!=null)
        {
            for (Viaje viaje  : viajes.List) {
                viaje.barco =  hashBarcos.get(viaje.getIdBarco());
                viaje.puertoDestino=hashPuertos.get(viaje.getIdPuertoDestino());
                viaje.puertoOrigen=hashPuertos.get(viaje.getIdPuertoOrigen());
            }
            
        }
        
        return viajes;
    }

}
