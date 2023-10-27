/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDeDatos.CitaVacunacionData;
import accesoDeDatos.CiudadanoData;
import accesoDeDatos.VacunaData;
import entidades.CitaVacunacion;
import entidades.Ciudadano;
import entidades.Laboratorio;
import entidades.Vacuna;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.Comparator;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import usos.Usos;

/**
 *
 * @author valef
 */
public class ControlInterno_Sedes extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que todas las celdas sean no editables
                return false;
            }
        };
    
    private ArrayList<CitaVacunacion> lista_citasAplicadas = new ArrayList();
    
    private CitaVacunacionData citadata = new CitaVacunacionData();
    private CiudadanoData ciudadata = new CiudadanoData();
    private VacunaData vacudata = new VacunaData();
    private CitaVacunacion cita_seleccionada = null;
   
    
    public ControlInterno_Sedes() {
        initComponents();
        cargarItems();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        sede_comoBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        fecha_comboBox = new javax.swing.JComboBox<>();
        anio_elegir = new com.toedter.calendar.JYearChooser();
        mes_elegir = new com.toedter.calendar.JMonthChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTXTdosis_Xsede = new javax.swing.JLabel();
        JTXTdosis_total = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Dia");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("CONTROL INTERNO - SEDES");

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCitas.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tablaCitas);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Sede");

        sede_comoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sede_comoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sede_comoBoxItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Período");

        fecha_comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anual", "Mensual", "Últimos 7 días" }));
        fecha_comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fecha_comboBoxItemStateChanged(evt);
            }
        });
        fecha_comboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fecha_comboBoxPropertyChange(evt);
            }
        });

        anio_elegir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        anio_elegir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                anio_elegirPropertyChange(evt);
            }
        });

        mes_elegir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mes_elegir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                mes_elegirPropertyChange(evt);
            }
        });

        jLabel2.setText("Dosis aplicadas en la sede:");

        jLabel6.setText("Dosis aplicadas en el período:");

        JTXTdosis_Xsede.setText("numero");

        JTXTdosis_total.setText("numero");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 85, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(89, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(sede_comoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(anio_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mes_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTdosis_total))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTXTdosis_Xsede)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(sede_comoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTXTdosis_Xsede))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JTXTdosis_total))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(anio_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mes_elegir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sede_comoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sede_comoBoxItemStateChanged
        cargarArray();
        llenarTabla();
        setLabels();
    }//GEN-LAST:event_sede_comoBoxItemStateChanged

    private void fecha_comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fecha_comboBoxItemStateChanged
        switch(fecha_comboBox.getSelectedIndex()){
            case 0:
                anio_elegir.setEnabled(true);
                mes_elegir.setEnabled(false);
                break;
            case 1:
                anio_elegir.setEnabled(false);
                mes_elegir.setEnabled(true);
                break;
            case 2:
                anio_elegir.setEnabled(false);
                mes_elegir.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_fecha_comboBoxItemStateChanged

    private void mes_elegirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_mes_elegirPropertyChange
        if(mes_elegir.isEnabled()){
            int mes = mes_elegir.getMonth()+1;
            int sede = sede_comoBox.getSelectedIndex()+1;
            ArrayList<CitaVacunacion> array = citadata.buscarCitas_porMesAplicadas(mes, sede);
            System.out.println(array);
            cargarArray(array);   
            llenarTabla();
            setLabels();
        }
        
//enero = 0 y diciembre = 11
    }//GEN-LAST:event_mes_elegirPropertyChange

    private void fecha_comboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecha_comboBoxPropertyChange
        
    }//GEN-LAST:event_fecha_comboBoxPropertyChange

    private void anio_elegirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_anio_elegirPropertyChange
        if(anio_elegir.isEnabled()){
            int anio = anio_elegir.getYear();
            int sede = sede_comoBox.getSelectedIndex()+1;
            ArrayList<CitaVacunacion> array = citadata.buscarCitas_porAnioAplicadas(anio, sede);
            System.out.println(array);
            cargarArray(array);   
            llenarTabla();
            setLabels();
        }
    }//GEN-LAST:event_anio_elegirPropertyChange

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlInterno_Sedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlInterno_Sedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlInterno_Sedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlInterno_Sedes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlInterno_Sedes().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JTXTdosis_Xsede;
    private javax.swing.JLabel JTXTdosis_total;
    private com.toedter.calendar.JYearChooser anio_elegir;
    private javax.swing.JComboBox<String> fecha_comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JMonthChooser mes_elegir;
    private javax.swing.JComboBox<String> sede_comoBox;
    private javax.swing.JTable tablaCitas;
    // End of variables declaration//GEN-END:variables

    public void cargarItems(){
        sede_comoBox.removeAllItems();
        sede_comoBox.addItem("Sucursal 1");
        sede_comoBox.addItem("Sucursal 2");
        sede_comoBox.addItem("Sucursal 3");
        sede_comoBox.addItem("Sucursal 4");
        
        fecha_comboBox.removeAllItems();
        fecha_comboBox.addItem("Anual");
        fecha_comboBox.addItem("Mensual");
        
        modelo.addColumn("Nro. de serie");
        modelo.addColumn("Laboratorio");
        modelo.addColumn("Dosis");
        modelo.addColumn("DNI");
                
        tablaCitas.setModel(modelo);
        
        cargarArray();
        llenarTabla();
    }
    
    
    public void cargarArray(){
        lista_citasAplicadas.clear();
        
        ArrayList<CitaVacunacion> array = citadata.buscarCitas_aplicadasPorSede(sede_comoBox.getSelectedIndex()+1);
        
        for (CitaVacunacion citaVacunacion : array) {
            lista_citasAplicadas.add(citaVacunacion);
        }
    }
    
    public void cargarArray(ArrayList<CitaVacunacion> array){
        lista_citasAplicadas.clear();
        
        for (CitaVacunacion citaVacunacion : array) {
            lista_citasAplicadas.add(citaVacunacion);
        }
    }
    
    private void limpiarTabla(){
        modelo.setRowCount(0);
    } 
    
    private void llenarTabla() {
    limpiarTabla();
    for (CitaVacunacion aux : lista_citasAplicadas) {
            modelo.addRow(new Object[]{aux.getDosis().getNroSerieDosis(), aux.getDosis().getLaboratorio().getNomLaboratorio(), aux.getDosis().getMedida(), aux.getDni()});
        }
    tablaCitas.setModel(modelo);
  }
    
    private void setLabels(){
        int anio = anio_elegir.getYear();
        int mes = mes_elegir.getMonth()+1;
        int sede = sede_comoBox.getSelectedIndex()+1;
        
        if(mes_elegir.isEnabled()){
            JTXTdosis_total.setText(String.valueOf(citadata.buscarCitas_porMesAplicadas(mes).size()));
            JTXTdosis_Xsede.setText(String.valueOf(citadata.buscarCitas_porMesAplicadas(mes, sede).size()));
        }else{
            JTXTdosis_total.setText(String.valueOf(citadata.buscarCitas_porAnioAplicadas(anio).size()));
            JTXTdosis_Xsede.setText(String.valueOf(citadata.buscarCitas_porAnioAplicadas(anio, sede).size()));
        }
    }

}
