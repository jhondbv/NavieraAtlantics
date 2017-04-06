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

    public int getIdEsposo() {
        return IdEsposo;
    }

    public void setIdEsposo(int IdEsposo) {
        this.IdEsposo = IdEsposo;
    }

    public Marinero esposo;
    
    public Esposa() {
    }

    public Esposa(Esposa esposa) {
        id = esposa.id;
        nombre = esposa.nombre;
        sexo = esposa.sexo;
        IdEsposo = esposa.IdEsposo;

    }

    public void setSexo(String f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
