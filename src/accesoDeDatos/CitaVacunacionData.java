package accesoDeDatos;

import entidades.CitaVacunacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

public class CitaVacunacionData {

  private Connection con = null;
  
  public CitaVacunacionData() {
        con = Conexion.getConnection(); // Se obtiene una conexión a la base de datos.
    }

  //------------------------------------------------------------------------------------------------
  //                buscar cita
  public CitaVacunacion buscarCita(int dni) {
    String sql = "SELECT codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado FROM citavacunacion WHERE dni = ? AND estado = 1";

    CitaVacunacion citavacunacion = null;
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, dni);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        citavacunacion = new CitaVacunacion();

        citavacunacion.setCodCita(rs.getInt("codCita"));
        citavacunacion.setDni(rs.getInt("dni"));
        citavacunacion.setCodRefuerzo(rs.getInt("codRefuerzo"));
        citavacunacion.setFechaHoraCita(rs.getTimestamp("fechaHoraCita").toLocalDateTime());
        citavacunacion.setCentroVacunacion(rs.getInt("centroVacunacion"));
        citavacunacion.setFechaHoraColoca(rs.getTimestamp("fechaHoraColoca").toLocalDateTime());

       
            //    Elegir si traer el nro de serie o la vacuna ?
            //    Si nro de serie entonces
           //      citavacunacion.setDosis(rs.getInt("nroSerieDosis"));
            //    sino
                  VacunaData vacunaData = new VacunaData();
                  citavacunacion.setDosis(vacunaData.buscarVacuna(rs.getInt("nroSerieDosis")));
        
        citavacunacion.setCitaEstado(rs.getBoolean("citaEstado"));

      } else {
        JOptionPane.showMessageDialog(null, "No existe esa Cita");
      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla CitaVacunacion");
    }
    return citavacunacion;
  }

  //--------------------------------------------------------------------------------------------------
  //           Guardar
  public void guardarCita(CitaVacunacion citavacunacion) {

    String sql = "INSERT INTO citavacunacion(dni ,codRefuerzo ,fechaHoraCita ,centroVacunacion ,fechaHoraColocada , nroSerieDosis ,citaEstado) VALUES(?,?,?,?,?,?,?)";

    try {

      /*
            La línea en cuestión crea un objeto PreparedStatement( ps) basado en la consulta SQL definida en sql y
            configura la opción Statement.RETURN_GENERATED_KEYS para que se devuelvan las claves generadas
            automáticamente después de ejecutar la consulta, lo que es útil si tienes una columna de clave primaria.
            autoincremental en tu tabla y necesitas obtener ese valor después de la inserción.
       */
      PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

      // Se establecen los valores de los parámetros en la consulta SQL.
      // ps.setInt(1, citaVacunacion.getCodCita());
      ps.setInt(1, citavacunacion.getDni());
      ps.setInt(2, citavacunacion.getCodRefuerzo());
      ps.setTimestamp(3, Timestamp.valueOf(citavacunacion.getFechaHoraCita()));
      ps.setInt(4, citavacunacion.getCentroVacunacion());
      ps.setTimestamp(5, Timestamp.valueOf(citavacunacion.getFechaHoraColoca()));

      //Completar
     // ps.setInt(6, citavacunacion.getDosis());-----------------------------------------------------------------
      
      ps.setBoolean(7, citavacunacion.isCitaEstado());

      ps.execute(); // Se ejecuta la consulta SQL para insertar la materia en la base de datos.

      ResultSet rs = ps.getGeneratedKeys(); // Se obtienen las claves generadas automáticamente.

      if (rs.next()) {
        citavacunacion.setCodCita(rs.getInt(1)); // Se obtiene y establece la clave generada en el objeto citavacunacion.
        JOptionPane.showMessageDialog(null, "Cita guardada"); // Se muestra un mensaje de éxito.
      }

      ps.close(); // Se cierra la declaración preparada para liberar recursos.

    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al cargar la Cita"); // En caso de error, se muestra un mensaje de error.
    }
  }

  //----------------------------------------------------------------------------------------------------------------------
  //              Eliminar
  public void eliminarCita(int citaEstado) {

    String sql = "update citavacunacion SET estado =0 WHERE citaEstado=?";

    try {
      PreparedStatement ps = con.prepareStatement(sql);

      ps.setInt(1, citaEstado);
      int exito = ps.executeUpdate();

      if (exito == 1) {
        JOptionPane.showMessageDialog(null, "Cita eliminada");

      }
    } catch (SQLException ex) {

      JOptionPane.showMessageDialog(null, "No se pudo eliminar la Cita ");
    }
  }
//---------------------------------------------------------------------------------------------------
  //                     Modificar
public void modificarCita(CitaVacunacion citaVacunacion) {

     String sql = "INSERT INTO citavacunacion(dni ,codRefuerzo ,fechaHoraCita ,centroVacunacion ,fechaHoraColocada , nroSerieDosis ,citaEstado) VALUES(?,?,?,?,?,?,?)";

    try {
      PreparedStatement ps = con.prepareStatement(sql);
      
      ps.setInt(1, citaVacunacion.getDni());
      ps.setInt(2,citaVacunacion.getCodRefuerzo());
      ps.setTimestamp(3, Timestamp.valueOf(citaVacunacion.getFechaHoraCita()));
       ps.setTimestamp(3, Timestamp.valueOf(citaVacunacion.getFechaHoraCita()));
      ps.setInt(4, citaVacunacion.getCentroVacunacion());
      ps.setTimestamp(5, Timestamp.valueOf(citaVacunacion.getFechaHoraColoca()));
   // ps.setInt(6,citaVacunacion.getDosis());                         -----------------------------------------------------------
      ps.setBoolean(7, citaVacunacion.isCitaEstado());
      
      int exito = ps.executeUpdate();

      if (exito == 1) {
        JOptionPane.showMessageDialog(null, "La cita se modifico correctamente");
        System.out.println(exito);
      } else {
        JOptionPane.showMessageDialog(null, "No se han podido modificar la cita");
        System.out.println(exito);
      }
    } catch (SQLException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Citavacunacion");
    }
}
}