/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Attribute;

/**
 *
 * @author jhon_Ballesteros
 */
@Root
public class Puerto {

    @Attribute
    private int id;
    @Attribute
    private String descripcion;

    public Puerto()
    {
    }
    
    public Puerto(Puerto puerto)
    {
        id=puerto.getId();
        descripcion=puerto.getDescripcion();
    }
        
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
