package accesoDeDatos;

import entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
  public void GuardarCidadano(Ciudadano ciudadano) throws SQLException{
  
  String sql = "INSERT INTO ciudadano (dni,nombreCompleto,email,celular,patologia,ambitoTrabajo,dosis)"
            + "VALUES (?,?,?,?,?,?,?)";

      try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1,ciudadano.getDni());
            ps.setString(2,ciudadano.getNomCompleto());
            ps.setString(3,ciudadano.getEmail());
            ps.setString(4,ciudadano.getCelular());
            ps.setString(5,ciudadano.getPatologia());
            ps.setString(6,ciudadano.getAmbitoTrabajo());
            ps.setInt(7,ciudadano.getDosis());
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
        
      
    

      } else {

        JOptionPane.showMessageDialog(null, "No se encontró al ciudadano ");

      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ciudadano ");
    }

    return ciudadano;
  }

   
   }
   
   
   
   
   
   
   
   
