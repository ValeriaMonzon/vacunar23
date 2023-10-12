package accesoDeDatos;

import entidades.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LaboratorioData {

  private Connection conexion = null;

  public LaboratorioData() {
    conexion = Conexion.getConnection();
  }

  public Laboratorio obtenerLaboratorio(String cuit) {
    String sql = "select l.cuit, l.nomLaboratorio, l.pais, l.domComercial "
            + "from laboratorio l "
            + "where l.cuit like ?;";

    try {
      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setString(1, cuit);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setCuit(cuit);
        laboratorio.setNomLaboratorio(rs.getString("nomLaboratorio"));
        laboratorio.setPais(rs.getString("pais"));
        laboratorio.setDomComercial(rs.getString("domComercial"));
        return laboratorio;
      }
    } catch (SQLException ex) {
      throw new RuntimeException("Error al acceder a la tabla 'laboratorio'");
    }
    return null;
  }

  public void guardarLaboratorio(Laboratorio laboratorio) {
    String sql = "INSERT INTO `laboratorio`(`cuit`, `nomLaboratorio`, `pais`, `domComercial`) VALUES (?,?,?,?);";

    try {
      PreparedStatement ps = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      ps.setString(1, laboratorio.getCuit());
      ps.setString(2, laboratorio.getNomLaboratorio());
      ps.setString(3, laboratorio.getPais());
      ps.setString(4, laboratorio.getDomComercial());
      ps.executeUpdate();

      ResultSet rs = ps.getGeneratedKeys();

      if (rs.next()) {
        JOptionPane.showMessageDialog(null, "Laboratorio agregado correctamente!");
      }
      ps.close();

    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'laboratorio'");
    }
  }

  public void eliminarLaboratorio(String cuit) {
    String sql = "DELETE FROM `laboratorio` WHERE cuit like ?";
    try {
      PreparedStatement ps = conexion.prepareStatement(sql);
      ps.setString(1, cuit);
      int exito = ps.executeUpdate();
      if (exito == 1) {
        JOptionPane.showMessageDialog(null, "Se elimino el laboratorio con exito!");
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al eliminar la inscripcion!");
    }
  }

}
