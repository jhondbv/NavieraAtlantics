/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author Penagos
 */
@Root
public class Personas {
    
    @ElementList(inline = true)
    public List<Viaje> List= new ArrayList<Viaje>();
    
}
