/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import com.sun.istack.internal.Nullable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author valef
 */
public class CitaVacunacion {
  @Nullable
    private Date fechaHoraColoca;
  private int CodCita;
  private Ciudadano persona;
  private int dni;
  private int codRefuerzo;
  private Date FechaHoraCita;
  private int centroVacunacion;
  private Vacuna dosis;
  private boolean citaEstado;
  private LocalTime horario;

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

  public CitaVacunacion(int CodCita, Ciudadano persona, int codRefuerzo, Date FechaHoraCita, int centroVacunacion, Date fechaHoraColoca, Vacuna dosis, boolean citaEstado) {
    this.CodCita = CodCita;
    this.persona = persona;
    this.codRefuerzo = codRefuerzo;
    this.FechaHoraCita = FechaHoraCita;
    this.centroVacunacion = centroVacunacion;
    this.fechaHoraColoca = fechaHoraColoca;
    this.dosis = dosis;
    this.citaEstado = citaEstado;
  }

  public CitaVacunacion(int CodCita, Ciudadano persona, int dni, int codRefuerzo, Date FechaHoraCita, int centroVacunacion, Date fechaHoraColoca, Vacuna dosis, boolean citaEstado) {
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

    public CitaVacunacion(int CodCita, Ciudadano persona, int dni, int codRefuerzo, Date FechaHoraCita, int centroVacunacion, Vacuna dosis, boolean citaEstado) {
        this.CodCita = CodCita;
        this.persona = persona;
        this.dni = dni;
        this.codRefuerzo = codRefuerzo;
        this.FechaHoraCita = FechaHoraCita;
        this.centroVacunacion = centroVacunacion;
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

  public Date getFechaHoraCita() {
    return FechaHoraCita;
  }

  public void setFechaHoraCita(Date FechaHoraCita) {
    this.FechaHoraCita = FechaHoraCita;
  }

  public int getCentroVacunacion() {
    return centroVacunacion;
  }

  public void setCentroVacunacion(int centroVacunacion) {
    this.centroVacunacion = centroVacunacion;
  }

  public Date getFechaHoraColoca() {
    return fechaHoraColoca;
  }

  public void setFechaHoraColoca(Date fechaHoraColoca) {
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

    @Override
    public String toString() {
        return "Centro de Vacunacion N° " + centroVacunacion;
    }


}
