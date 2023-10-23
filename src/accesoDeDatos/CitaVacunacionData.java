package accesoDeDatos;

import entidades.CitaVacunacion;
import entidades.Vacuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import usos.Usos;

public class CitaVacunacionData {

    private Connection con = null;

    public CitaVacunacionData() {
        con = Conexion.getConnection(); // Se obtiene una conexión a la base de datos.
    }

    //------------------------------------------------------------------------------------------------
    //                buscar cita
    public CitaVacunacion buscarCita_DNI(int dni) {
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
                citavacunacion.setFechaHoraCita(new Date(rs.getTimestamp("fechaHoraCita").getTime()));

                citavacunacion.setCentroVacunacion(rs.getInt("centroVacunacion"));
                citavacunacion.setFechaHoraColoca(new Date(rs.getTimestamp("fechaHoraColoca").getTime()));

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
    
    public CitaVacunacion buscarCita_CodCita(int cod) {
        String sql = "SELECT codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado FROM citavacunacion WHERE codCita = ? AND estado = 1";

        CitaVacunacion citavacunacion = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                citavacunacion = new CitaVacunacion();

                citavacunacion.setCodCita(rs.getInt("codCita"));
                citavacunacion.setDni(rs.getInt("dni"));
                citavacunacion.setCodRefuerzo(rs.getInt("codRefuerzo"));
                citavacunacion.setFechaHoraCita(new Date(rs.getTimestamp("fechaHoraCita").getTime()));

                citavacunacion.setCentroVacunacion(rs.getInt("centroVacunacion"));
                citavacunacion.setFechaHoraColoca(new Date(rs.getTimestamp("fechaHoraColoca").getTime()));

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

        String sql = "INSERT INTO citavacunacion(dni ,codRefuerzo ,fechaHoraCita ,centroVacunacion ,fechaHoraColoca , nroSerieDosis ,citaEstado) VALUES(?,?,?,?,?,?,?)";

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
            ps.setTimestamp(3, new Timestamp(citavacunacion.getFechaHoraCita().getTime()));
            ps.setInt(4, citavacunacion.getCentroVacunacion());
           if (citavacunacion.getFechaHoraColoca() != null) {
    ps.setTimestamp(5, new Timestamp(citavacunacion.getFechaHoraColoca().getTime()));
} else {
    ps.setNull(5, Types.TIMESTAMP); // Campo en blanco
}

            // Accede a la entidad Vacuna y obtén la dosis
            int nroSerieDosis = citavacunacion.getDosis().getNroSerieDosis();
            ps.setInt(6, nroSerieDosis); // Establece la dosis como nroSerieDosis

            //Completar
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

    public void modificarCita(CitaVacunacion citavacunacion) {

        String sql = "INSERT INTO citavacunacion(dni ,codRefuerzo ,fechaHoraCita ,centroVacunacion ,fechaHoraColoca , nroSerieDosis ,citaEstado) VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, citavacunacion.getDni());
            ps.setInt(2, citavacunacion.getCodRefuerzo());
            ps.setTimestamp(3, new Timestamp(citavacunacion.getFechaHoraCita().getTime()));
            ps.setInt(4, citavacunacion.getCentroVacunacion());
            ps.setTimestamp(5, new Timestamp(citavacunacion.getFechaHoraColoca().getTime()));

             int nroSerieDosis = citavacunacion.getDosis().getNroSerieDosis();
            ps.setInt(6, nroSerieDosis);       
             ps.setBoolean(7, citavacunacion.isCitaEstado());

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
    
    public ArrayList<CitaVacunacion> buscarCitas_porFecha(LocalDate fecha, int sede) {
        ArrayList<CitaVacunacion> lista_citas = new ArrayList();
        String sql = "SELECT codCita, dni, codRefuerzo, fechaHoraCita, centroVacunacion, fechaHoraColoca, nroSerieDosis, citaEstado FROM citavacunacion WHERE DAY(fechaHoraColoca) = ? and MONTH(fechaHoraColoca) = ? and YEAR(fechaHoraColoca) = ? AND citaEstado = 1 AND centroVacunacion = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, fecha.getDayOfMonth());
            ps.setInt(2, fecha.getMonthValue());
            ps.setInt(3, fecha.getYear());
            ps.setInt(4, sede);            
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                CitaVacunacion citavacunacion = new CitaVacunacion();
                
                citavacunacion.setCodCita(rs.getInt("codCita"));
                citavacunacion.setDni(rs.getInt("dni"));
                citavacunacion.setCodRefuerzo(rs.getInt("codRefuerzo"));
                citavacunacion.setFechaHoraCita(new Date(rs.getTimestamp("fechaHoraCita").getTime()));

                citavacunacion.setCentroVacunacion(rs.getInt("centroVacunacion"));
                citavacunacion.setFechaHoraColoca(new Date(rs.getTimestamp("fechaHoraColoca").getTime()));
                
                LocalTime hora = rs.getTimestamp("fechaHoraColoca").toLocalDateTime().toLocalTime();
                citavacunacion.setHorario(hora);
                

//                    Elegir si traer el nro de serie o la vacuna ?
//                    Si nro de serie entonces
//                    citavacunacion.setDosis(rs.getInt("nroSerieDosis"));
//                    sino
                VacunaData vacunaData = new VacunaData();
                citavacunacion.setDosis(vacunaData.buscarVacuna(rs.getInt("nroSerieDosis")));

                citavacunacion.setCitaEstado(rs.getBoolean("citaEstado"));
            
                lista_citas.add(citavacunacion);

            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla CitaVacunacion");
        }
        return lista_citas;
    }
    public List<CitaVacunacion> listarCita(){
    
    List<CitaVacunacion> datos =new ArrayList<>();
    
        try {
            String sql ="SELECT c.dni,c.nroSerieDosis, c.centroVacunacion  FROM citavacunacion c";
                   
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
        while (rs.next()){
            
           CitaVacunacion dato = new CitaVacunacion();
           
           dato.setDni(rs.getInt("dni"));
           dato.setCentroVacunacion(rs.getInt("centroVacunacion"));
           //aca tuve que crear una vacuna para poder traer el dato nroSerieDosis 
           //por que esta en la misma tabla pero en diferente clase.
           Vacuna vacuna =new Vacuna();
           vacuna.setNroSerieDosis(rs.getInt("nroSerieDosis"));
           dato.setDosis(vacuna);
           datos.add(dato);
           }ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla " + ex.getMessage());
        }
          return datos;  
    
    }
}
