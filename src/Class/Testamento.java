/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.HashMap;
import java.util.Map;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 *
 * @author jhon_Ballesteros
 */
public class Testamento {
    
    
     @Attribute
    int id;
    @Element
    double porcentajeEsposa;
    @ElementList(inline=true)
    Map<Integer,Double> porcentajeHijos ;

    public void setId(int id) {
        this.id = id;
    }

    public void setPorcentajeEsposa(double porcentajeEsposa) {
        this.porcentajeEsposa = porcentajeEsposa;
    }

    public void setPorcentajeHijos(Map<Integer, Double> porcentajeHijos) {
        this.porcentajeHijos = porcentajeHijos;
    }

    public int getId() {
        return id;
    }

    public double getPorcentajeEsposa() {
        return porcentajeEsposa;
    }

    public Map<Integer, Double> getPorcentajeHijos() {
        return porcentajeHijos;
    }
    
    public Testamento()
    {
        porcentajeHijos= new HashMap<Integer,Double>();
    }
    
        public Testamento(Testamento testamento)
    {
        porcentajeHijos= new HashMap<Integer,Double>();
        id = testamento.id;
        porcentajeEsposa=testamento.porcentajeEsposa;
        porcentajeHijos=testamento.porcentajeHijos;
    }
}
