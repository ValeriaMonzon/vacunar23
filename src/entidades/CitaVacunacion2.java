package entidades;

import java.time.LocalDateTime;

public class CitaVacunacion2 {

  private int codCita;
  private Ciudadano persona;
  private int codRefuerzo;
  private LocalDateTime fechaHoraCita;
  private int centroVacunacion;
  private LocalDateTime fechaHoraColoca;
  private Vacuna dosis;

  public CitaVacunacion2() {
  }

  public CitaVacunacion2(int codCita, Ciudadano persona, int codRefuerzo, LocalDateTime fechaHoraCita, int centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna dosis) {
    this.codCita = codCita;
    this.persona = persona;
    this.codRefuerzo = codRefuerzo;
    this.fechaHoraCita = fechaHoraCita;
    this.centroVacunacion = centroVacunacion;
    this.fechaHoraColoca = fechaHoraColoca;
    this.dosis = dosis;
  }

  public int getCodCita() {
    return codCita;
  }

  public void setCodCita(int codCita) {
    this.codCita = codCita;
  }

  public Ciudadano getPersona() {
    return persona;
  }

  public void setPersona(Ciudadano persona) {
    this.persona = persona;
  }

  public int getCodRefuerzo() {
    return codRefuerzo;
  }

  public void setCodRefuerzo(int codRefuerzo) {
    this.codRefuerzo = codRefuerzo;
  }

  public LocalDateTime getFechaHoraCita() {
    return fechaHoraCita;
  }

  public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
    this.fechaHoraCita = fechaHoraCita;
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

}
