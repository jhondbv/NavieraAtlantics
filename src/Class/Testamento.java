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
     List<PorcentajeTestamento> porcentajeHijos ;

    
    public Testamento()
    {
      porcentajeHijos=new ArrayList<PorcentajeTestamento>();
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setPorcentajeEsposa(double porcentajeEsposa) {
        this.porcentajeEsposa = porcentajeEsposa;
    }

    public void setPorcentajeHijos(List<PorcentajeTestamento> porcentajeHijos) {
        this.porcentajeHijos = porcentajeHijos;
    }

    public int getId() {
        return id;
    }

    public double getPorcentajeEsposa() {
        return porcentajeEsposa;
    }

    public List<PorcentajeTestamento> getPorcentajeHijos() {
        return porcentajeHijos;
    }
    
 
    
        public Testamento(Testamento testamento)
    {
        porcentajeHijos= new ArrayList<PorcentajeTestamento>();
        id = testamento.id;
        porcentajeEsposa=testamento.porcentajeEsposa;
        porcentajeHijos=testamento.porcentajeHijos;
    }
}
