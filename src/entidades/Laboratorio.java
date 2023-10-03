/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author valef
 */
public class Laboratorio {
    private String cuit;
    private String NomLaboratorio;
    private String pais;
    private String domComercial;

    public Laboratorio() {
    }

    public Laboratorio(String cuit, String NomLaboratorio, String pais, String domComercial) {
        this.cuit = cuit;
        this.NomLaboratorio = NomLaboratorio;
        this.pais = pais;
        this.domComercial = domComercial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNomLaboratorio() {
        return NomLaboratorio;
    }

    public void setNomLaboratorio(String NomLaboratorio) {
        this.NomLaboratorio = NomLaboratorio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDomComercial() {
        return domComercial;
    }

    public void setDomComercial(String domComercial) {
        this.domComercial = domComercial;
    }
    
    
    
}
