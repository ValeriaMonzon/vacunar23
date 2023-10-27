/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunar23;

import accesoDeDatos.CitaVacunacionData;
import accesoDeDatos.Conexion;
import accesoDeDatos.VacunaData;
import entidades.CitaVacunacion;
import entidades.Vacuna;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author valef
 */
public class Vacunar23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VacunaData vacudata = new VacunaData();
        ArrayList<Vacuna> array = vacudata.buscarVacunas_aplicadas();
        ArrayList<Integer> nros_serie = new ArrayList();
        
        for (Vacuna vacuna : array) {
            nros_serie.add(vacuna.getNroSerieDosis());
        }
        
        System.out.println(nros_serie);
    }

}
