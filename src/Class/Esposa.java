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
public class Esposa extends Persona {
    @Element
    int IdEsposo;
    
    public Esposa(){
    }

    public int getIdEsposo() {
        return IdEsposo;
    }

    public void setIdEsposo(int IdEsposo) {
        this.IdEsposo = IdEsposo;
    }

   
    
}
