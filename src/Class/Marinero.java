/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
/**
 *
 * @author Penagos
 */
@Root
public class Marinero extends Persona {
    
    @Element
    int idEsposa;
     @Element
    String hijos;
      @Element
    int idTestamento;

    public int getIdEsposa() {
        return idEsposa;
    }

    public String getHijos() {
        return hijos;
    }

    public int getIdTestamento() {
        return idTestamento;
    }

    public void setIdEsposa(int idEsposa) {
        this.idEsposa = idEsposa;
    }

    public void setHijos(String hijos) {
        this.hijos = hijos;
    }

    public void setIdTestamento(int idTestamento) {
        this.idTestamento = idTestamento;
    }
    
    
    
    public Marinero(){
    }
    
}
