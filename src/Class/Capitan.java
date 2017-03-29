/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Penagos
 */
public class Capitan extends Persona {
    
    
    boolean casado=false;
    int numHijos;
    boolean tieneTestamento=false;
    String testamento;
    
    public Capitan (){
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public boolean isTieneTestamento() {
        return tieneTestamento;
    }

    public void setTieneTestamento(boolean tieneTestamento) {
        this.tieneTestamento = tieneTestamento;
    }

    public String getTestamento() {
        return testamento;
    }

    public void setTestamento(String testamento) {
        this.testamento = testamento;
    }
    
    
}
