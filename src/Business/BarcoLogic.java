/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Class.Barco;
import Class.Barcos;
import Class.TipoBarco;
import Class.TipoBarcos;
import Persistence.BarcoArbolDao;
import Persistence.BarcoDao;
import Persistence.Interface.IBarcoDao;
import Persistence.Interface.ITipoBarcoDAO;
import Persistence.TipoBarcoArbolDao;
import Persistence.TipoBarcoDAO;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jhon
 */
public class BarcoLogic {
    private IBarcoDao DAO = null;
    private ITipoBarcoDAO TipoBarcoDAO=null;
    
    private  HashMap<Integer,TipoBarco> hashtipos =null;
    
    public BarcoLogic(){
        DAO = new BarcoArbolDao();
        TipoBarcoDAO=new TipoBarcoArbolDao();
        
       hashtipos = new HashMap<>();
       List<TipoBarco>tipos = TipoBarcoDAO.Consultar().List;
        for (TipoBarco tipo : tipos) {
            hashtipos.put(tipo.getId(), tipo);
        }
    }
    
    
    public void Guardar(Barco barco)
    {
        DAO.Guardar(barco);
    }
    
    public void Eliminar(int id)
    {
        DAO.Eliminar(id);
        
    }
    
    public void Actualizar(Barco barco)
    {
        barco.tipoBarco=hashtipos.get(barco.getIdTipoBarco());
        DAO.Actualizar(barco);
        
       
    }
    
    public Barco Consultar(int id)
    {
        return DAO.Consultar(id);
    }
    
    public Barcos Consultar()
    {
        return DAO.Consultar();
    }
    
      public Barcos ConsultarConRelaciones()
    {
        Barcos barcos =  DAO.Consultar();
        if(barcos!=null)
        {
            for (Barco barco : barcos.List) {
                barco.tipoBarco=hashtipos.get(barco.getIdTipoBarco());
            }
            
        }
        
        return barcos;
    }
    
}
