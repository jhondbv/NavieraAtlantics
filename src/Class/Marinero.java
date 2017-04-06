/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
/**
 *
 * @author Penagos
 */
@Root
public class Marinero extends Persona {
    
    @Element
    int idEsposa;
     @ElementList
        List<ID> hijos=new ArrayList<ID>();
      @Element
    int idTestamento;
      @Element
      boolean isCapitan;
      
      public Esposa esposa;
      

    public void setIsCapitan(boolean isCapitan) {
        this.isCapitan = isCapitan;
    }

    public boolean isIsCapitan() {
        return isCapitan;
    }

    public int getIdEsposa() {
        return idEsposa;
    }

    public List<ID> getHijos() {
        return hijos;
    }

    public int getIdTestamento() {
        return idTestamento;
    }

    public void setIdEsposa(int idEsposa) {
        this.idEsposa = idEsposa;
    }

    public void setHijos(List<ID> hijos) {
        this.hijos = hijos;
    }

    public void setIdTestamento(int idTestamento) {
        this.idTestamento = idTestamento;
    }
    
    @Override
    public String toString()
    {
        return getNombre();
    }
    
    public Marinero(){
        hijos=new ArrayList<ID>();
    }
    
     public Marinero(Marinero marinero){
         
         id=marinero.id;
        isCapitan=marinero.isCapitan;
         nombre=marinero.nombre;
         sexo=marinero.sexo;
         idEsposa=marinero.idEsposa;
          hijos=marinero.hijos;
         idTestamento=marinero.idTestamento;
         
    }
    
}
