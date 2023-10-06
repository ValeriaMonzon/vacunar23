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
public class Ciudadano {
    private int dni;
    private String NomCompleto;
    private String email;
    private String celular;
    private String patologia;
    private String ambitoTrabajo;
    private int dosis;
    private boolean estado;

    public Ciudadano() {
    }

    public Ciudadano(int dni, String NomCompleto, String email, String celular, String patologia, String ambitoTrabajo, int dosis, boolean estado) {
        this.dni = dni;
        this.NomCompleto = NomCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = patologia;
        this.ambitoTrabajo = ambitoTrabajo;
        this.dosis = dosis;
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNomCompleto() {
        return NomCompleto;
    }

    public void setNomCompleto(String NomCompleto) {
        this.NomCompleto = NomCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAmbitoTrabajo() {
        return ambitoTrabajo;
    }

    public void setAmbitoTrabajo(String ambitoTrabajo) {
        this.ambitoTrabajo = ambitoTrabajo;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    } 
      @Override
    public String toString() {
        return  dni + " " + NomCompleto + " " + email + " " + celular + " " + patologia + " " + ambitoTrabajo + " " + dosis ;
   }     
 }
