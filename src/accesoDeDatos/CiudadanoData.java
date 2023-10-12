/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDeDatos;


    
    
    
import entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valef
 */
public class CiudadanoData {
  private Connection con = null;

    public CiudadanoData() {
        con = Conexion.getConnection();
    }
    //insertamos al ciudadano en la base de datos 
  public void GuardarCiudadano(Ciudadano ciudadano) throws SQLException{
  
  String sql = "INSERT INTO ciudadano (dni,nomCompleto,email,celular,patologia,ambitoTrabajo,dosis,estado)"
            + "VALUES (?,?,?,?,?,?,?,?)";

      try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,ciudadano.getDni());
            ps.setString(2,ciudadano.getNomCompleto());
            ps.setString(3,ciudadano.getEmail());
            ps.setString(4,ciudadano.getCelular());
            ps.setString(5,ciudadano.getPatologia());
            ps.setString(6,ciudadano.getAmbitoTrabajo());
            ps.setInt(7,ciudadano.getDosis());
            ps.setBoolean(8, true);
            ps.executeUpdate();
       
           ResultSet rs = ps.getGeneratedKeys();
     if (rs.next()) {

       ciudadano.setDni(1);
        JOptionPane.showMessageDialog(null, "ciudadano agregado correctamente");
      }

      ps.close();

    } catch (SQLException ex) {

      JOptionPane.showMessageDialog(null, "Ya existe un ciudadano con el DNI ingresado");
      }
  
   }
  //aqui modificamos a un ciudadano que viene por parametro lo buscamos por nsu clave primaria que es dni
   public void modificarCiudadano(Ciudadano ciudadano) {

    String sql = "UPDATE ciudadano SET nombreCompleto=?, email=?, celular=?,patologia=?,ambitoTrabajo=?,dosis=? WHERE dni=?";

    try {
      PreparedStatement ps = con.prepareStatement(sql);
      
      ps.setString(1, ciudadano.getNomCompleto());
      ps.setString(2,ciudadano.getEmail());
      ps.setString(3, ciudadano.getCelular());
      ps.setString(4,ciudadano.getPatologia());
      ps.setString(5, ciudadano.getAmbitoTrabajo());
      ps.setInt(6, ciudadano.getDosis());
      ps.setInt(7,ciudadano.getDni());
      ps.setBoolean(8, true);
      int exito = ps.executeUpdate();

      if (exito == 1) {
        JOptionPane.showMessageDialog(null, "los datos se modificaron correctamente");
        System.out.println(exito);
      } else {
        JOptionPane.showMessageDialog(null, "No se han podido modificar los datos");
        System.out.println(exito);
      }
    } catch (SQLException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ciudadano");
    }
   }
   //busca al cidadano por el por la clave Primaria dni
   public Ciudadano buscarCiudadano( int dni){
   
   
    String sql = "SELECT nombreCompleto,email,celular,patologia,ambitoTrabajo,dosis FROM ciudadano WHERE dni = ?";
    
    Ciudadano ciudadano= null;

    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, dni);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
          
        ciudadano = new Ciudadano();
        ciudadano.setDni(dni);
        ciudadano.setNomCompleto(rs.getString("nombreCompleto"));
        ciudadano.setEmail(rs.getString("email"));
        ciudadano.setCelular(rs.getNString("celular"));
        ciudadano.setPatologia(rs.getString("patologia"));
        ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
        ciudadano.setDosis(rs.getInt("dosis"));
        ciudadano.setEstado(true);
         } else {

        JOptionPane.showMessageDialog(null, "No se encontró al ciudadano ");

      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudadano ");
    }

    return ciudadano;
  }

   public void eliminarCiudadano(int dni) {
    try {
      String sql = "UPDATE ciudadano SET estado=0 WHERE dni=? ";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, dni);
      int exito = ps.executeUpdate();
      if (exito == 1) {
        JOptionPane.showMessageDialog(null, "ciudadano eliminado");
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudadano");
    }
}
   
   //listamos a todos los Ciudadanos de la tabla que se encuentren con estado true
    public List<Ciudadano> listarCiudadanos() {

    List<Ciudadano>  listciudadanos = new ArrayList<>();
    try {
      String sql = "SELECT * FROM ciudadano WHERE estado = 1 ";
      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Ciudadano ciudadano = new Ciudadano();

        ciudadano.setDni(rs.getInt("dni"));
        ciudadano.setNomCompleto(rs.getString("nombreCompleto"));
        ciudadano.setEmail(rs.getString("email"));
        ciudadano.setCelular(rs.getNString("celular"));
        ciudadano.setPatologia(rs.getString("patologia"));
        ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
        ciudadano.setDosis(rs.getInt("dosis"));
        ciudadano.setEstado(true);
        listciudadanos.add(ciudadano);
      }
      ps.close();

    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, " Error al acceder a la tabla ciudadano ");
    }
    return listciudadanos;
   
   
}
    }
