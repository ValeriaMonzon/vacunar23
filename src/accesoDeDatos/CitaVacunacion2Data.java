package accesoDeDatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CitaVacunacion2Data {

  private final Connection conexion;

  private final String OBTENER_CITAVACUNACION = "SELECT codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado FROM citavacunacion WHERE codCita = ?;";
  private final String GUARDAR_CITAVACUNACION = "INSERT INTO citavacunacion (codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado) VALUES (?,?,?,?,?,?,?,?);";
  private final String ACTUALIZAR_CITAVACUNACION = "UPDATE citavacunacion SET dni=?, codRefuerzo=?, fechaHoraCita=?, centroVacunacion=?, fechaHoraColoca= ?, nroSerieDosis=?, citaEstado=? WHERE codCita = ?;";
  private final String BORRAR_CITAVACUNACION = "DELETE FROM citavacunacion WHERE codCita=?";
  private final String EXISTE_CITAVACUNACION = "SELECT 1 FROM citavacunacion WHERE codCita=?";

  public CitaVacunacion2Data() {
    this.conexion = Conexion.getConnection();
  }

  public CitaVacunacion2 obtenerCitaVacunacion(String codCita) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(OBTENER_CITAVACUNACION)) {
      statement.setString(1, codCita);
      resultSet = statement.executeQuery();
    }
    if (resultSet.next()) {
      Laboratorio laboratorio = new Laboratorio();
      Vacuna vacuna = new Vacuna();
      Ciudadano ciudadano = new Ciudadano();
      CitaVacunacion2 citaVacunacion = new CitaVacunacion2();
      return citaVacunacion;
    } else {
      return null;
    }
  }

  public void guardarCitaVacunacion(CitaVacunacion2 citaVacunacion) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(GUARDAR_CITAVACUNACION)) {
//      statement.setString(1, laboratorio.getCuit());
//      statement.setString(2, laboratorio.getNomCitaVacunacion());
//      statement.setString(3, laboratorio.getPais());
//      statement.setString(4, laboratorio.getDomComercial());
      statement.executeUpdate();
    }
  }

  public void borrarCitaVacunacion(String codCita) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(BORRAR_CITAVACUNACION)) {
      statement.setString(1, codCita);
      statement.executeUpdate();
    }
  }

  public void actualizarCitaVacunacion(CitaVacunacion2 laboratorio) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_CITAVACUNACION)) {
//      statement.setString(1, laboratorio.getNomCitaVacunacion());
//      statement.setString(2, laboratorio.getPais());
//      statement.setString(3, laboratorio.getDomComercial());
//      statement.setString(4, laboratorio.getCuit());
      statement.executeUpdate();
    }
  }

  public boolean existeCitaVacunacion(String codCita) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(EXISTE_CITAVACUNACION)) {
      statement.setString(1, codCita);
      resultSet = statement.executeQuery();
    }
    return resultSet.next();
  }

}
