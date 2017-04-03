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
public class Hijo extends Persona {
  @Element  
  int idPapa;

    public int getIdPapa() {
        return idPapa;
    }

    public void setIdPapa(int idPapa) {
        this.idPapa = idPapa;
    }
  
  
    
}
