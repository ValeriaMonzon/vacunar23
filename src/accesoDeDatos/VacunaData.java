
package accesoDeDatos;

import entidades.Laboratorio;
import entidades.Vacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import usos.Usos;


public class VacunaData {

    private Connection con = null;

  public VacunaData() {
    //nosotros lo tenemos escrito asi el metodo getConnection(); en la clase Conexion
    con = Conexion.getConnection();

  }

  public void guardarVacuna(Vacuna vacuna) {

    String sql = "INSERT INTO vacuna (nroSerieDosis, cuit, marca, medida, fechaCaduca, colocada, stock)"
            + "VALUES (?,?,?,?,?,?,?)";

    try {
      PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
      
      ps.setInt(1, vacuna.getNroSerieDosis());
      ps.setString(2, vacuna.getLaboratorio().getCuit());
      ps.setString(3, vacuna.getLaboratorio().getNomLaboratorio());
      ps.setDouble(4, vacuna.getMedida());
      ps.setDate(5, Date.valueOf(vacuna.getFechaCaduca()));
      ps.setBoolean(6, vacuna.getColocada());
      ps.setInt(7, vacuna.getStock());
      ps.executeUpdate();

      ResultSet rs = ps.getGeneratedKeys();
        System.out.println(rs.next());
      if (rs.next()==false) {
        JOptionPane.showMessageDialog(null, "Vacuna ingresada en el sistema correctamente");
      }

      ps.close();

    } catch (SQLException ex) {
          if(buscarVacunaBooleano(vacuna.getNroSerieDosis())){
            JOptionPane.showMessageDialog(null, "La vacuna que intentas ingresar ya existe");  
          }else{
           JOptionPane.showMessageDialog(null, "No se ha podido ingresar la vacuna en el sistema");   
          }
    }
  }
  
  public Vacuna buscarVacuna(int num_serie) {
    Vacuna vacuna = null;
    LaboratorioData data = new LaboratorioData();
    String sql = "SELECT cuit, marca, medida, fechaCaduca, colocada, stock FROM vacuna WHERE nroSerieDosis = ?";
    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, num_serie);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        vacuna = new Vacuna();
        vacuna.setNroSerieDosis(num_serie);
        vacuna.setLaboratorio(data.obtenerLaboratorio(rs.getString("cuit")));
        vacuna.setMedida(rs.getDouble("medida"));
        vacuna.setFechaCaduca(rs.getDate("fechaCaduca").toLocalDate());
        vacuna.setColocada(rs.getBoolean("colocada"));
        vacuna.setStock(rs.getInt("stock"));
        
        return vacuna;
      } else {
        //JOptionPane.showMessageDialog(null, "No se encontró una vacuna con el número de serie ingresado");
      }
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
    }
        return vacuna;
}
  
  public boolean buscarVacunaBooleano(int num_serie) {
    LaboratorioData data = new LaboratorioData();
    String sql = "SELECT stock FROM vacuna WHERE nroSerieDosis = ?";
    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, num_serie);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
            ps.close();
            return true;
      } else {
            ps.close();
            return false;
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
      return false;
    }
}
  
  public void modificarStock(int serie, int stock) {
    String sql = "UPDATE vacuna SET stock=? WHERE nroSerieDosis=?";

    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, stock);
      ps.setInt(2, serie);
      int exito = ps.executeUpdate();

      if (exito == 1) {
          System.out.println("Stock modificado a "+stock);
      } else {
          System.out.println("No se ha podido modificar el stock");
      }
    } catch (SQLException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
    }
  }
  
    public void eliminarVacuna(int num_serie) {
    
    String sql = "DELETE FROM vacuna WHERE nroSerieDosis = ?";
    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement(sql);
      ps.setInt(1, num_serie);
     int exito = ps.executeUpdate();
        
      if (exito>0) {
        JOptionPane.showMessageDialog(null, "Vacuna elminada correctamente");          
      } else {
          if(buscarVacunaBooleano(num_serie)==false){
            JOptionPane.showMessageDialog(null, "La vacuna que intentas eliminar no existe");  
          }else{
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar la vacuna");   
          }
      }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
    }
}
    
    public ArrayList<Vacuna> buscarVacunas_aplicadas() {
    Vacuna vacuna = null;
    LaboratorioData data = new LaboratorioData();
    ArrayList<Vacuna> array = new ArrayList();
    String sql = "SELECT nroSerieDosis, cuit, marca, medida, fechaCaduca, stock FROM vacuna WHERE colocada = 1";
    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement(sql);
      
      ResultSet rs = ps.executeQuery();
      
      while (rs.next()) {
        vacuna = new Vacuna();
        vacuna.setNroSerieDosis(rs.getInt("nroSerieDosis"));
        vacuna.setLaboratorio(data.obtenerLaboratorio(rs.getString("cuit")));
        vacuna.setMedida(rs.getDouble("medida"));
        vacuna.setFechaCaduca(rs.getDate("fechaCaduca").toLocalDate());
        vacuna.setColocada(true);
        vacuna.setStock(rs.getInt("stock"));
        
        array.add(vacuna);
      } 
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna: "+ ex);
    }
        return array;
}
  
    public void colocarVacuna(int serie) {
    String sql = "UPDATE vacuna SET colocada=1 WHERE nroSerieDosis=?";

    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setInt(1, serie);
      int exito = ps.executeUpdate();

      if (exito == 1) {
          System.out.println("Vacuna aplicada");
      } else {
          System.out.println("No se ha podido aplicar la vacuna");
      }
    } catch (SQLException ex) {
      System.out.println(ex);
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna");
    }
  }
    
    public ArrayList<Vacuna> buscarVacunas_porLabortatorio(String marca) {
    Vacuna vacuna = null;
    LaboratorioData data = new LaboratorioData();
    ArrayList<Vacuna> array = new ArrayList();
    String sql = "SELECT nroSerieDosis, cuit, marca, medida, fechaCaduca, stock FROM vacuna WHERE marca = ?";
    
    try {
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, marca);
      
      ResultSet rs = ps.executeQuery();
      
      while (rs.next()) {
        vacuna = new Vacuna();
        vacuna.setNroSerieDosis(rs.getInt("nroSerieDosis"));
        vacuna.setLaboratorio(data.obtenerLaboratorio(rs.getString("cuit")));
        vacuna.setMedida(rs.getDouble("medida"));
        vacuna.setFechaCaduca(rs.getDate("fechaCaduca").toLocalDate());
        vacuna.setColocada(rs.getBoolean("colocada"));
        vacuna.setStock(rs.getInt("stock"));
        
        array.add(vacuna);
      } 
      ps.close();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Vacuna: "+ ex);
    }
        return array;
    }
   
}