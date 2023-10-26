package accesoDeDatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CitaVacunacion2Data {

  private final Connection conexion;
  private final LaboratorioData laboratorioData;

  private final String OBTENER_CITAVACUNACION = "SELECT codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado FROM citavacunacion WHERE codCita = ?;";
  private final String GUARDAR_CITAVACUNACION = "INSERT INTO citavacunacion ( dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis) VALUES (?,?,?,?,?,?);";
  private final String ACTUALIZAR_CITAVACUNACION = "UPDATE citavacunacion SET dni=?, codRefuerzo=?, fechaHoraCita=?, centroVacunacion=?, fechaHoraColoca=?, nroSerieDosis=? WHERE codCita =?;";
  private final String BORRAR_CITAVACUNACION = "DELETE FROM citavacunacion WHERE codCita=?";
  private final String EXISTE_CITAVACUNACION = "SELECT 1 FROM citavacunacion WHERE codCita=?";

  private final String OBTENER_CIUDADANO = "SELECT dni, nombreCompleto, email, celular, patologia, ambitoTrabajo, dosis, estado FROM ciudadano WHERE dni=?;";
  private final String LISTAR_CIUDADANO = "SELECT dni, nombreCompleto, email, celular, patologia, ambitoTrabajo, dosis, estado FROM ciudadano;";
  private final String OBTENER_VACUNA = "SELECT nroSerieDosis, cuit, marca, medida, fechaCaduca, colocada, stock FROM vacuna WHERE nroSerieDosis=?;";
  private final String LISTAR_VACUNA = "SELECT nroSerieDosis, cuit, marca, medida, fechaCaduca, colocada, stock FROM vacuna;";

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
      if (resultSet.getTimestamp("fechaHoraColoca") != null) {
        citaVacunacion.setFechaHoraColoca(resultSet.getTimestamp("fechaHoraColoca").toLocalDateTime());
      }
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
      statement.setObject(5, null, Types.TIMESTAMP);
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

  public Ciudadano obtenerPersona(int dni) throws SQLException {
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

  public List<Ciudadano> listarPersonas() throws SQLException {
    List<Ciudadano> ciudadanos = new ArrayList<>();
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(LISTAR_CIUDADANO)) {
      resultSet = statement.executeQuery();
    }
    while (resultSet.next()) {
      Ciudadano ciudadano = new Ciudadano() {
        @Override
        public String toString() {
          return "DNI: " + getDni() + ", Nombre: " + getNomCompleto();
        }
      };
      ciudadano.setDni(resultSet.getInt("dni"));
      ciudadano.setNomCompleto(resultSet.getString("nombreCompleto"));
      ciudadano.setEmail(resultSet.getString("email"));
      ciudadano.setCelular(resultSet.getString("celular"));
      ciudadano.setPatologia(resultSet.getString("patologia"));
      ciudadano.setAmbitoTrabajo(resultSet.getString("ambitoTrabajo"));
      ciudadano.setDosis(resultSet.getInt("dosis"));
      ciudadanos.add(ciudadano);
    }
    return ciudadanos;
  }

  public Vacuna obtenerVacuna(int nroSerieDosis) throws SQLException {
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

  public List<Vacuna> listarVacunas() throws SQLException {
    List<Vacuna> vacunas = new ArrayList<>();
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(LISTAR_VACUNA)) {
      resultSet = statement.executeQuery();
    }
    while (resultSet.next()) {
      Vacuna vacuna = new Vacuna() {
        @Override
        public String toString() {
          return "Nro Serie: " + getNroSerieDosis() + ", Medida: " + getMedida() + ", Laboratorio: " + getLaboratorio().getNomLaboratorio();
        }
      };
      vacuna.setNroSerieDosis(resultSet.getInt("nroSerieDosis"));
      vacuna.setLaboratorio(obtenerLaboratorio(resultSet.getString("cuit")));
      vacuna.setColocada(resultSet.getBoolean("colocada"));
      vacuna.setMedida(resultSet.getDouble("medida"));
      vacuna.setFechaCaduca(resultSet.getDate("fechaCaduca").toLocalDate());
      vacunas.add(vacuna);
    }
    return vacunas;
  }

  public Laboratorio obtenerLaboratorio(String string) throws SQLException {
    return laboratorioData.obtenerLaboratorio(string);
  }

}
