package accesoDeDatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LaboratorioData {

  private final Connection conexion;

  private final String OBTENER_LABORATORIO = "SELECT cuit, nomLaboratorio, pais, domComercial FROM laboratorio WHERE cuit = ?;";
  private final String GUARDAR_LABORATORIO = "INSERT INTO laboratorio (cuit, nomLaboratorio, pais, domComercial) VALUES (?,?,?,?);";
  private final String ACTUALIZAR_LABORATORIO = "UPDATE laboratorio SET nomLaboratorio=?,pais=?,domComercial=? WHERE cuit=?;";
  private final String BORRAR_LABORATORIO = "DELETE FROM laboratorio WHERE cuit=?";
  private final String EXISTE_LABORATORIO = "SELECT 1 FROM laboratorio WHERE cuit=?";

  public LaboratorioData() {
    conexion = Conexion.getConnection();
  }

  public Laboratorio obtenerLaboratorio(String cuit) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(OBTENER_LABORATORIO)) {
      statement.setString(1, cuit);
      resultSet = statement.executeQuery();
    }
    if (resultSet.next()) {
      Laboratorio laboratorio = new Laboratorio();
      laboratorio.setCuit(cuit);
      laboratorio.setNomLaboratorio(resultSet.getString("nomLaboratorio"));
      laboratorio.setPais(resultSet.getString("pais"));
      laboratorio.setDomComercial(resultSet.getString("domComercial"));
      return laboratorio;
    } else {
      return null;
    }
  }

  public void guardarLaboratorio(Laboratorio laboratorio) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(GUARDAR_LABORATORIO)) {
      statement.setString(1, laboratorio.getCuit());
      statement.setString(2, laboratorio.getNomLaboratorio());
      statement.setString(3, laboratorio.getPais());
      statement.setString(4, laboratorio.getDomComercial());
      statement.executeUpdate();
    }
  }

  public void borrarLaboratorio(String cuit) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(BORRAR_LABORATORIO)) {
      statement.setString(1, cuit);
      statement.executeUpdate();
    }
  }

  public void actualizarLaboratorio(Laboratorio laboratorio) throws SQLException {
    try (PreparedStatement statement = conexion.prepareStatement(ACTUALIZAR_LABORATORIO)) {
      statement.setString(1, laboratorio.getNomLaboratorio());
      statement.setString(2, laboratorio.getPais());
      statement.setString(3, laboratorio.getDomComercial());
      statement.setString(4, laboratorio.getCuit());
      statement.executeUpdate();
    }
  }

  public boolean existeLaboratorio(String cuit) throws SQLException {
    ResultSet resultSet;
    try (PreparedStatement statement = conexion.prepareStatement(EXISTE_LABORATORIO)) {
      statement.setString(1, cuit);
      resultSet = statement.executeQuery();
    }
    return resultSet.next();
  }

}
