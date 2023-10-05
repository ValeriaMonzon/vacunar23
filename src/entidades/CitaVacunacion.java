/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author valef
 */
public class CitaVacunacion {

  private int CodCita;
  private Ciudadano persona;
  private int dni;
  private int codRefuerzo;
  private LocalDateTime FechaHoraCita;
  private int centroVacunacion;
  private LocalDateTime fechaHoraColoca;
  private Vacuna dosis;
  private boolean citaEstado;

  public CitaVacunacion(int CodCita, Ciudadano persona, int codRefuerzo, LocalDateTime FechaHoraCita, int centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna dosis, boolean citaEstado) {
    this.CodCita = CodCita;
    this.persona = persona;
    this.codRefuerzo = codRefuerzo;
    this.FechaHoraCita = FechaHoraCita;
    this.centroVacunacion = centroVacunacion;
    this.fechaHoraColoca = fechaHoraColoca;
    this.dosis = dosis;
    this.citaEstado = citaEstado;
  }

  public CitaVacunacion(int CodCita, Ciudadano persona, int dni, int codRefuerzo, LocalDateTime FechaHoraCita, int centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna dosis, boolean citaEstado) {
    this.CodCita = CodCita;
    this.persona = persona;
    this.dni = dni;
    this.codRefuerzo = codRefuerzo;
    this.FechaHoraCita = FechaHoraCita;
    this.centroVacunacion = centroVacunacion;
    this.fechaHoraColoca = fechaHoraColoca;
    this.dosis = dosis;
    this.citaEstado = citaEstado;
  }

  public CitaVacunacion() {
  }

  public int getCodCita() {
    return CodCita;
  }

  public void setCodCita(int CodCita) {
    this.CodCita = CodCita;
  }

  public Ciudadano getPersona() {
    return persona;
  }

  public void setPersona(Ciudadano persona) {
    this.persona = persona;
  }

  public int getDni() {
    return dni;
  }

  public void setDni(int dni) {
    this.dni = dni;
  }

  public int getCodRefuerzo() {
    return codRefuerzo;
  }

  public void setCodRefuerzo(int codRefuerzo) {
    this.codRefuerzo = codRefuerzo;
  }

  public LocalDateTime getFechaHoraCita() {
    return FechaHoraCita;
  }

  public void setFechaHoraCita(LocalDateTime FechaHoraCita) {
    this.FechaHoraCita = FechaHoraCita;
  }

  public int getCentroVacunacion() {
    return centroVacunacion;
  }

  public void setCentroVacunacion(int centroVacunacion) {
    this.centroVacunacion = centroVacunacion;
  }

  public LocalDateTime getFechaHoraColoca() {
    return fechaHoraColoca;
  }

  public void setFechaHoraColoca(LocalDateTime fechaHoraColoca) {
    this.fechaHoraColoca = fechaHoraColoca;
  }

  public Vacuna getDosis() {
    return dosis;
  }

  public void setDosis(Vacuna dosis) {
    this.dosis = dosis;
  }

  public boolean isCitaEstado() {
    return citaEstado;
  }

  public void setCitaEstado(boolean citaEstado) {
    this.citaEstado = citaEstado;
  }

}
