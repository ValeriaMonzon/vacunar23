
package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Vacuna {
    private int nroSerieDosis;
    private Laboratorio laboratorio;
    private double medida;
    private LocalDate fechaCaduca;
    private boolean colocada;
    private int stock;

    public Vacuna() {
    }

    public Vacuna(int nroSerieDosis, Laboratorio laboratorio, double medida, LocalDate fechaCaduca, boolean colocada, int stock) {
        this.nroSerieDosis = nroSerieDosis;
        this.laboratorio = laboratorio;
        this.medida = medida;
        this.fechaCaduca = fechaCaduca;
        this.colocada = colocada;
        this.stock = stock;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getNroSerieDosis() {
        return nroSerieDosis;
    }

    public void setNroSerieDosis(int nroSerieDosis) {
        this.nroSerieDosis = nroSerieDosis;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public LocalDate getFechaCaduca() {
        return fechaCaduca;
    }

    public void setFechaCaduca(LocalDate fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    public boolean getColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nroSerieDosis + " " + laboratorio.getCuit() + " " + laboratorio.getNomLaboratorio() + " " + medida + " " + fechaCaduca + " " + colocada + " " + stock;
    }
    
    

}
