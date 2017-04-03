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
 * @author jhon_Ballesteros
 */
@Root
public class Marineros {
    
    @ElementList(inline = true)
    public List<Marinero> List= new ArrayList<Marinero>();
}
