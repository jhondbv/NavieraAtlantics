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
 * @author jhon
 */
@Root
public class Barco {
    
    @Attribute
    private int Id;
    @Element
    private boolean RegMerc;
    @Element
    private int IdTipoBarco;
    
    public Barco(Barco barco){
        Id=barco.getId();
        RegMerc=barco.getRegMerc();
        IdTipoBarco=barco.getIdTipoBarco();
    }

    public Barco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public boolean getRegMerc() {
        return RegMerc;
    }

    public void setRegMerc(boolean RegMerc) {
        this.RegMerc = RegMerc; 
    }

    public int getIdTipoBarco() {
        return IdTipoBarco;
    }

    public void setIdTipoBarco(int IdTipoBarco) {
        this.IdTipoBarco = IdTipoBarco;
    }
   
}
