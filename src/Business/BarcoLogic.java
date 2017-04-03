/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Class.Barco;
import Class.Barcos;
import Persistence.BarcoDao;
import Persistence.Interface.IBarcoDao;

/**
 *
 * @author jhon
 */
public class BarcoLogic {
    private IBarcoDao DAO = null;
    
    public BarcoLogic(){
        DAO = new BarcoDao();
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
    
}
