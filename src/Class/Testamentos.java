/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


/**
 *
 * @author jhon_Ballesteros
 */
@Root
public class Testamentos {
    
    @ElementList(inline=true)
   public List<Testamento> List= new ArrayList<Testamento>();
    
    
}
