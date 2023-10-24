package accesoDeDatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class CitaVacunacion2Data {

  private final Connection conexion;
  private final LaboratorioData laboratorioData;

  private final String OBTENER_CITAVACUNACION = "SELECT codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado FROM citavacunacion WHERE codCita = ?;";
  private final String GUARDAR_CITAVACUNACION = "INSERT INTO citavacunacion ( dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis) VALUES (?,?,?,?,?,?,?);";
  private final String ACTUALIZAR_CITAVACUNACION = "UPDATE citavacunacion SET dni=?, codRefuerzo=?, fechaHoraCita=?, centroVacunacion=?, fechaHoraColoca=?, nroSerieDosis=? WHERE codCita =?;";
  private final String BORRAR_CITAVACUNACION = "DELETE FROM citavacunacion WHERE codCita=?";
  private final String EXISTE_CITAVACUNACION = "SELECT 1 FROM citavacunacion WHERE codCita=?";

  private final String OBTENER_CIUDADANO = "SELECT dni, nombreCompleto, email, celular, patologia, ambitoTrabajo, dosis, estado FROM ciudadano WHERE dni=?;";
  private final String OBTENER_VACUNA = "SELECT nroSerieDosis, cuit, marca, medida, fechaCaduca, colocada, stock FROM vacuna WHERE nroSerieDosis=?;";

  public CitaVacunacion2Data() {
    this.conexion = Conexion.getConnection();
    this.laboratorioData = new LaboratorioData();
  }

  public CitaVacunacion2 obtenerCitaVacunacion(int codCita) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(OBTENER_CITAVACUNACION)) {
      statement.setInt(1, codCita);
      resultSet = statement.executeQuery();
    }
    if (resultSet.next()) {
      CitaVacunacion2 citaVacunacion = new CitaVacunacion2();
      citaVacunacion.setCodCita(codCita);
      citaVacunacion.setPersona(obtenerPersona(resultSet.getInt("dni")));
      citaVacunacion.setCodRefuerzo(resultSet.getInt("codRefuerzo"));
      citaVacunacion.setFechaHoraCita(resultSet.getTimestamp("fechaHoraCita").toLocalDateTime());
      citaVacunacion.setCentroVacunacion(resultSet.getInt("centroVacunacion"));
      citaVacunacion.setFechaHoraColoca(resultSet.getTimestamp("fechaHoraColoca").toLocalDateTime());
      citaVacunacion.setDosis(obtenerVacuna(resultSet.getInt("nroSerieDosis")));
      return citaVacunacion;
    } else {
      return null;
    }
  }

  public void guardarCitaVacunacion(CitaVacunacion2 citaVacunacion) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(GUARDAR_CITAVACUNACION)) {
      statement.setInt(1, citaVacunacion.getPersona().getDni());
      statement.setInt(2, citaVacunacion.getCodRefuerzo());
      statement.setTimestamp(3, Timestamp.valueOf(citaVacunacion.getFechaHoraCita()));
      statement.setInt(4, citaVacunacion.getCentroVacunacion());
      statement.setTimestamp(5, Timestamp.valueOf(citaVacunacion.getFechaHoraColoca()));
      statement.setInt(6, citaVacunacion.getDosis().getNroSerieDosis());
      statement.executeUpdate();
    }
  }

  public void borrarCitaVacunacion(int codCita) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(BORRAR_CITAVACUNACION)) {
      statement.setInt(1, codCita);
      statement.executeUpdate();
    }
  }

  public void actualizarCitaVacunacion(CitaVacunacion2 citaVacunacion) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_CITAVACUNACION)) {
      statement.setInt(1, citaVacunacion.getPersona().getDni());
      statement.setInt(2, citaVacunacion.getCodRefuerzo());
      statement.setTimestamp(3, Timestamp.valueOf(citaVacunacion.getFechaHoraCita()));
      statement.setInt(4, citaVacunacion.getCentroVacunacion());
      statement.setTimestamp(5, Timestamp.valueOf(citaVacunacion.getFechaHoraColoca()));
      statement.setInt(6, citaVacunacion.getDosis().getNroSerieDosis());
      statement.setInt(7, citaVacunacion.getCodCita());
      statement.executeUpdate();
    }
  }

  public boolean existeCitaVacunacion(int codCita) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(EXISTE_CITAVACUNACION)) {
      statement.setInt(1, codCita);
      resultSet = statement.executeQuery();
    }
    return resultSet.next();
  }

  private Ciudadano obtenerPersona(int dni) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(OBTENER_CIUDADANO)) {
      statement.setInt(1, dni);
      resultSet = statement.executeQuery();
    }
    if (resultSet.next()) {
      Ciudadano ciudadano = new Ciudadano();
      ciudadano.setDni(dni);
      ciudadano.setNomCompleto(resultSet.getString("nombreCompleto"));
      ciudadano.setEmail(resultSet.getString("email"));
      ciudadano.setCelular(resultSet.getString("celular"));
      ciudadano.setPatologia(resultSet.getString("patologia"));
      ciudadano.setAmbitoTrabajo(resultSet.getString("ambitoTrabajo"));
      ciudadano.setDosis(resultSet.getInt("dosis"));
      return ciudadano;
    } else {
      return null;
    }
  }

  private Vacuna obtenerVacuna(int nroSerieDosis) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(OBTENER_VACUNA)) {
      statement.setInt(1, nroSerieDosis);
      resultSet = statement.executeQuery();
    }
    if (resultSet.next()) {
      Vacuna vacuna = new Vacuna();
      vacuna.setNroSerieDosis(nroSerieDosis);
      vacuna.setLaboratorio(obtenerLaboratorio(resultSet.getString("cuit")));
      vacuna.setColocada(resultSet.getBoolean("colocada"));
      vacuna.setMedida(resultSet.getDouble("medida"));
      vacuna.setFechaCaduca(resultSet.getDate("fechaCaduca").toLocalDate());
      return vacuna;
    } else {
      return null;
    }
  }

  private Laboratorio obtenerLaboratorio(String string) throws SQLException {
    return laboratorioData.obtenerLaboratorio(string);
  }

}
