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
import java.util.Collections;
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
    private ArrayList<CitaVacunacion> lista_citasVencidas = new ArrayList();
    private ArrayList<CitaVacunacion> lista_citasCanceladas = new ArrayList();

    
    private CitaVacunacionData citadata = new CitaVacunacionData();
    private CiudadanoData ciudadata = new CiudadanoData();
    private VacunaData vacudata = new VacunaData();
    private CitaVacunacion cita_seleccionada = null;
    
    private int indice;
   
    
    public ControlInterno_Sedes() {
        initComponents();
        cargarItems();
        setLocationRelativeTo(null);
        
        int anio_actual = Calendar.getInstance().get(Calendar.YEAR);
        anio_elegir.setEndYear(anio_actual);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        sede_comoBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        fecha_comboBox = new javax.swing.JComboBox<>();
        anio_elegir = new com.toedter.calendar.JYearChooser();
        mes_elegir = new com.toedter.calendar.JMonthChooser();
        texto_sede = new javax.swing.JLabel();
        texto_periodo = new javax.swing.JLabel();
        JTXTdosis_Xsede = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();
        JTXTdosis_total = new javax.swing.JLabel();
        tipoCitas_comoBox = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Dia");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Control Interno - Sedes");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel4.setText("Sede");

        sede_comoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sede_comoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sede_comoBoxItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
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

        texto_sede.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        texto_sede.setText("Dosis aplicadas en la sede:");

        texto_periodo.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        texto_periodo.setText("Dosis aplicadas en el período:");

        JTXTdosis_Xsede.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        JTXTdosis_Xsede.setText("numero");

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

        JTXTdosis_total.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        JTXTdosis_total.setText("numero");

        tipoCitas_comoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tipoCitas_comoBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoCitas_comoBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(sede_comoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(texto_sede)
                                .addGap(6, 6, 6)
                                .addComponent(JTXTdosis_Xsede))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(texto_periodo)
                                .addGap(6, 6, 6)
                                .addComponent(JTXTdosis_total))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(fecha_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(anio_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(mes_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(tipoCitas_comoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(sede_comoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_sede)
                            .addComponent(JTXTdosis_Xsede))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto_periodo)
                            .addComponent(JTXTdosis_total))))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(fecha_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(anio_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes_elegir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(tipoCitas_comoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            switch(indice){
                case 0: //aplicadas
                    mes_aplicadas();
                    break;
                case 1: //canceladas
                    mes_canceladas();
                    break;
                case 2: //vencidas
                    cargarArray(mes_vencidas_sede());
                    llenarTabla();
                    setLabels();
                    break;
            }
        }else{
            switch(indice){
                case 0: //aplicadas
                    año_aplicadas();
                    break;
                case 1: //canceladas
                    año_canceladas();
                    break;
                case 2: //vencidas
                    cargarArray(año_vencidas_sede());
                    llenarTabla();
                    setLabels();
                    break;
            }
        }
    }//GEN-LAST:event_mes_elegirPropertyChange

    private void fecha_comboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fecha_comboBoxPropertyChange
        
    }//GEN-LAST:event_fecha_comboBoxPropertyChange

    private void anio_elegirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_anio_elegirPropertyChange
       if(mes_elegir.isEnabled()){
            switch(indice){
                case 0: //aplicadas
                    mes_aplicadas();
                    break;
                case 1: //canceladas
                    mes_canceladas();
                    break;
                case 2: //vencidas
                    cargarArray(mes_vencidas_sede());
                    llenarTabla();
                    setLabels();
                    break;
            }
        }else{
            switch(indice){
                case 0: //aplicadas
                    año_aplicadas();
                    break;
                case 1: //canceladas
                    año_canceladas();
                    break;
                case 2: //vencidas
                    cargarArray(año_vencidas_sede());
                    llenarTabla();
                    setLabels();
                    break;
            }
        }
    }//GEN-LAST:event_anio_elegirPropertyChange

    private void tipoCitas_comoBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoCitas_comoBoxItemStateChanged
        indice = tipoCitas_comoBox.getSelectedIndex();
        cargarArray();
        setLabels();
        llenarTabla();
    }//GEN-LAST:event_tipoCitas_comoBoxItemStateChanged

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JMonthChooser mes_elegir;
    private javax.swing.JComboBox<String> sede_comoBox;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JLabel texto_periodo;
    private javax.swing.JLabel texto_sede;
    private javax.swing.JComboBox<String> tipoCitas_comoBox;
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
        
        tipoCitas_comoBox.removeAllItems();
        tipoCitas_comoBox.addItem("Aplicadas");
        tipoCitas_comoBox.addItem("Canceladas");
        tipoCitas_comoBox.addItem("Vencidas");        
        
        modelo.addColumn("Cod. de cita");
        modelo.addColumn("Nro. de serie");
        modelo.addColumn("Laboratorio");
        modelo.addColumn("Dosis");
        modelo.addColumn("DNI");
        modelo.addColumn("Fecha");
                
        tablaCitas.setModel(modelo);
        
        cargarArray();
        llenarTabla();
    }
    
    
    public void cargarArray(){
        lista_citasAplicadas.clear();
        lista_citasCanceladas.clear();
        lista_citasVencidas.clear();
        
        Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        
        switch(indice){
                case 0: //aplicadas
                    ArrayList<CitaVacunacion> array1 = citadata.buscarCitas_aplicadasPorSede(sede_comoBox.getSelectedIndex()+1);
                    for (CitaVacunacion citaVacunacion : array1) {
                            lista_citasAplicadas.add(citaVacunacion);
                    }
                    ordenarArray(lista_citasAplicadas);
                    break;
                case 1: //canceladas
                    ArrayList<CitaVacunacion> array2 = citadata.buscarCitas_canceladasPorSede(sede_comoBox.getSelectedIndex()+1);
                    for (CitaVacunacion citaVacunacion : array2) {
                            lista_citasCanceladas.add(citaVacunacion);
                     }
                    ordenarArray(lista_citasCanceladas);
                    break;
                case 2: //vencidas
                    ArrayList<CitaVacunacion> array3 = vencidas_sede();
                    for (CitaVacunacion citaVacunacion : array3) {
                             lista_citasVencidas.add(citaVacunacion);
                     }
                     ordenarArray(lista_citasVencidas);
                    break;
            }
    }
    
    public void cargarArray(ArrayList<CitaVacunacion> array){
        lista_citasAplicadas.clear();
        lista_citasCanceladas.clear();
        lista_citasVencidas.clear();
        
        switch(indice){
                case 0: //aplicadas
                    for (CitaVacunacion citaVacunacion : array) {
                            lista_citasAplicadas.add(citaVacunacion);
                    }
                    ordenarArray(lista_citasAplicadas);
                    break;
                case 1: //canceladas
                    for (CitaVacunacion citaVacunacion : array) {
                            lista_citasCanceladas.add(citaVacunacion);
                     }
                    ordenarArray(lista_citasCanceladas);
                    break;
                case 2: //vencidas
                    for (CitaVacunacion citaVacunacion : array) {
                             lista_citasVencidas.add(citaVacunacion);
                     }
                     ordenarArray(lista_citasVencidas);
                    break;
            }
    }
    
    private void limpiarTabla(){
        modelo.setRowCount(0);
    } 
    
    private void llenarTabla() {
    try{
        limpiarTabla();
    
        switch(indice){
                case 0: //aplicadas
                    for (CitaVacunacion aux : lista_citasAplicadas) {
            modelo.addRow(new Object[]{aux.getCodCita(), aux.getDosis().getNroSerieDosis(), aux.getDosis().getLaboratorio().getNomLaboratorio(), aux.getDosis().getMedida(), aux.getDni(), aux.getFechaHoraCita()});
        }
                    break;
                case 1: //canceladas
                    for (CitaVacunacion aux : lista_citasCanceladas) {
            modelo.addRow(new Object[]{aux.getCodCita(), aux.getDosis().getNroSerieDosis(), aux.getDosis().getLaboratorio().getNomLaboratorio(), aux.getDosis().getMedida(), aux.getDni(), aux.getFechaHoraCita()});
        }
                    break;
                case 2: //vencidas
                    for (CitaVacunacion aux : lista_citasVencidas) {
            modelo.addRow(new Object[]{aux.getCodCita(), aux.getDosis().getNroSerieDosis(), aux.getDosis().getLaboratorio().getNomLaboratorio(), aux.getDosis().getMedida(), aux.getDni(), aux.getFechaHoraCita()});
        }
                    break;
            }
    tablaCitas.setModel(modelo);
    }catch(Exception ex){}
  }
    
    private void setLabels(){
        indice = tipoCitas_comoBox.getSelectedIndex();
        int anio = anio_elegir.getYear();
        int mes = mes_elegir.getMonth()+1;
        int sede = sede_comoBox.getSelectedIndex()+1;
        
        Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        
        if(mes_elegir.isEnabled()){
            switch(indice){
                case 0: //aplicadas
                    JTXTdosis_total.setText(String.valueOf(citadata.buscarCitas_porMesAplicadas(mes).size()));
                    JTXTdosis_Xsede.setText(String.valueOf(citadata.buscarCitas_porMesAplicadas(mes, sede).size()));
                    texto_sede.setText("Dosis aplicadas en la sede:");
                    texto_periodo.setText("Dosis aplicadas en el período:");
                    break;
                case 1: //canceladas
                    JTXTdosis_total.setText(String.valueOf(citadata.buscarCitas_porMesCanceladas(mes).size()));
                    JTXTdosis_Xsede.setText(String.valueOf(citadata.buscarCitas_porMesCanceladas(mes, sede).size()));
                    texto_sede.setText("Citas canceladas en la sede:");
                    texto_periodo.setText("Citas canceladas en el período:");
                    break;
                case 2: //vencidas
                    JTXTdosis_total.setText(String.valueOf(mes_vencidas_total().size()));
                    JTXTdosis_Xsede.setText(String.valueOf(mes_vencidas_sede().size()));
                    texto_sede.setText("Citas vencidas en la sede:");
                    texto_periodo.setText("Citas vencidas en el período:");
                    break;
            }
        }else{
            switch(indice){
                case 0: //aplicadas
                    JTXTdosis_total.setText(String.valueOf(citadata.buscarCitas_porAnioAplicadas(anio).size()));
                    JTXTdosis_Xsede.setText(String.valueOf(citadata.buscarCitas_porAnioAplicadas(anio, sede).size()));
                    texto_sede.setText("Dosis aplicadas en la sede:");
                    texto_periodo.setText("Dosis aplicadas en el período:");
                    break;
                case 1: //canceladas
                    JTXTdosis_total.setText(String.valueOf(citadata.buscarCitas_porAnioCanceladas(anio).size()));
                    JTXTdosis_Xsede.setText(String.valueOf(citadata.buscarCitas_porAnioCanceladas(anio, sede).size()));
                    texto_sede.setText("Citas canceladas en la sede:");
                    texto_periodo.setText("Citas canceladas en el período:");
                    break;
                case 2: //vencidas
                    JTXTdosis_total.setText(String.valueOf(año_vencidas_total().size()));
                    JTXTdosis_Xsede.setText(String.valueOf(año_vencidas_sede().size()));
                    texto_sede.setText("Citas vencidas en la sede:");
                    texto_periodo.setText("Citas vencidas en el período:");
                    break;
            }
        }
    }
    
    private void ordenarArray(ArrayList<CitaVacunacion> lista_citas) {
    try{
        Collections.sort(lista_citas, new Comparator<CitaVacunacion>() {
        @Override
        public int compare(CitaVacunacion cita1, CitaVacunacion cita2) {
            return cita1.getFechaHoraCita().compareTo(cita2.getFechaHoraCita());
        }
    });}catch(Exception e){}
    }
    
    
    private ArrayList<CitaVacunacion> vencidas_sede(){
        int sede = sede_comoBox.getSelectedIndex()+1;
        ArrayList<CitaVacunacion> array = citadata.buscarCitas(sede);
        System.out.println("Citas por año: "+array);
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();
        
        for (CitaVacunacion cita : array) {
            Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        Date fechaCita = cita.getFechaHoraCita();
        
        LocalTime horario_cita = cita.getHorario();
        LocalTime horario_ahora = Usos.obtenerLocalTimeDesdeCalendar(calendario);

        int estadoCita;
        
            if(fechaCita.before(fechaHoy)){                           //antes que hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(cita.isCitaEstado()){
                        estadoCita = 0;   
                    }else{
                        estadoCita = 3;
                    }
                }
                
            } else if (fechaCita.equals(fechaHoy)){                 //igual a hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(horario_cita.isBefore(horario_ahora)){
                        if(cita.isCitaEstado()){
                            estadoCita = 0;   
                        }else{
                            estadoCita = 3;
                        }
                    } else{
                        estadoCita = 1;
                    }
                }
            } else {                                                                        //despues de hoy
                if(cita.isCitaEstado()){
                        estadoCita = 1;
                    }else{
                        estadoCita = 3;
                    }
            }
            
        if(estadoCita==0){
            array_vencidas.add(cita);
            }            
        }
        
                System.out.println("Citas por año vencidas: "+array_vencidas);
        return array_vencidas;
    }
    
    private ArrayList<CitaVacunacion> año_vencidas_total(){
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();
        for (int i = 1; i < 5; i++) {
            ArrayList<CitaVacunacion> array = año_vencidas_sede(i);
            array_vencidas.addAll(array);
        }
        return array_vencidas;
    }
    
    private ArrayList<CitaVacunacion> mes_vencidas_total(){
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();
        for (int i = 1; i < 5; i++) {
            ArrayList<CitaVacunacion> array = mes_vencidas_sede(i);
            array_vencidas.addAll(array);
        }
        return array_vencidas;
    }
    
    private ArrayList<CitaVacunacion> año_vencidas_sede(){
        int anio = anio_elegir.getYear();
        int sede = sede_comoBox.getSelectedIndex()+1;
        ArrayList<CitaVacunacion> array = citadata.buscarCitas_porAnio(anio, sede);
        System.out.println("Citas por año: "+array);
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();

        
        for (CitaVacunacion cita : array) {
            Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        Date fechaCita = cita.getFechaHoraCita();
        
        LocalTime horario_cita = cita.getHorario();
        LocalTime horario_ahora = Usos.obtenerLocalTimeDesdeCalendar(calendario);

        int estadoCita;
        
            if(fechaCita.before(fechaHoy)){                           //antes que hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(cita.isCitaEstado()){
                        estadoCita = 0;   
                    }else{
                        estadoCita = 3;
                    }
                }
                
            } else if (fechaCita.equals(fechaHoy)){                 //igual a hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(horario_cita.isBefore(horario_ahora)){
                        if(cita.isCitaEstado()){
                            estadoCita = 0;   
                        }else{
                            estadoCita = 3;
                        }
                    } else{
                        estadoCita = 1;
                    }
                }
            } else {                                                                        //despues de hoy
                if(cita.isCitaEstado()){
                        estadoCita = 1;
                    }else{
                        estadoCita = 3;
                    }
            }
            
        if(estadoCita==0){
            array_vencidas.add(cita);
            }            
        }
        
                System.out.println("Citas por año vencidas: "+array_vencidas);
        return array_vencidas;
    }
    
    private ArrayList<CitaVacunacion> año_vencidas_sede(int sede){
        int anio = anio_elegir.getYear();
        ArrayList<CitaVacunacion> array = citadata.buscarCitas_porAnio(anio, sede);
        System.out.println("Citas por año: "+array);
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();

        
        for (CitaVacunacion cita : array) {
            Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        Date fechaCita = cita.getFechaHoraCita();
        
        LocalTime horario_cita = cita.getHorario();
        LocalTime horario_ahora = Usos.obtenerLocalTimeDesdeCalendar(calendario);

        int estadoCita;
        
            if(fechaCita.before(fechaHoy)){                           //antes que hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(cita.isCitaEstado()){
                        estadoCita = 0;   
                    }else{
                        estadoCita = 3;
                    }
                }
                
            } else if (fechaCita.equals(fechaHoy)){                 //igual a hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(horario_cita.isBefore(horario_ahora)){
                        if(cita.isCitaEstado()){
                            estadoCita = 0;   
                        }else{
                            estadoCita = 3;
                        }
                    } else{
                        estadoCita = 1;
                    }
                }
            } else {                                                                        //despues de hoy
                if(cita.isCitaEstado()){
                        estadoCita = 1;
                    }else{
                        estadoCita = 3;
                    }
            }
            
        if(estadoCita==0){
            array_vencidas.add(cita);
            }            
        }
        
                System.out.println("Citas por año vencidas: "+array_vencidas);
        return array_vencidas;
    }
    
    private ArrayList<CitaVacunacion> mes_vencidas_sede(){
        int mes = mes_elegir.getMonth()+1;
        int sede = sede_comoBox.getSelectedIndex()+1;
        ArrayList<CitaVacunacion> array = citadata.buscarCitas_porMes(mes, sede);
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();

        
        for (CitaVacunacion cita : array) {
            Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        Date fechaCita = cita.getFechaHoraCita();
        
        LocalTime horario_cita = cita.getHorario();
        LocalTime horario_ahora = Usos.obtenerLocalTimeDesdeCalendar(calendario);

        int estadoCita;
        
            if(fechaCita.before(fechaHoy)){                           //antes que hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(cita.isCitaEstado()){
                        estadoCita = 0;   
                    }else{
                        estadoCita = 3;
                    }
                }
                
            } else if (fechaCita.equals(fechaHoy)){                 //igual a hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(horario_cita.isBefore(horario_ahora)){
                        if(cita.isCitaEstado()){
                            estadoCita = 0;   
                        }else{
                            estadoCita = 3;
                        }
                    } else{
                        estadoCita = 1;
                    }
                }
            } else {                                                                        //despues de hoy
                if(cita.isCitaEstado()){
                        estadoCita = 1;
                    }else{
                        estadoCita = 3;
                    }
            }
            
        if(estadoCita==0){
            array_vencidas.add(cita);
            }            
        }
        
        System.out.println(array_vencidas);
        return array_vencidas;
    }
    
    private ArrayList<CitaVacunacion> mes_vencidas_sede(int sede){
        int mes = mes_elegir.getMonth()+1;
        ArrayList<CitaVacunacion> array = citadata.buscarCitas_porMes(mes, sede);
        ArrayList<CitaVacunacion> array_vencidas = new ArrayList();

        
        for (CitaVacunacion cita : array) {
            Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        Date fechaCita = cita.getFechaHoraCita();
        
        LocalTime horario_cita = cita.getHorario();
        LocalTime horario_ahora = Usos.obtenerLocalTimeDesdeCalendar(calendario);

        int estadoCita;
        
            if(fechaCita.before(fechaHoy)){                           //antes que hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(cita.isCitaEstado()){
                        estadoCita = 0;   
                    }else{
                        estadoCita = 3;
                    }
                }
                
            } else if (fechaCita.equals(fechaHoy)){                 //igual a hoy
                if(cita.getDosis().getColocada()){
                    estadoCita = 2;
                }else{
                    if(horario_cita.isBefore(horario_ahora)){
                        if(cita.isCitaEstado()){
                            estadoCita = 0;   
                        }else{
                            estadoCita = 3;
                        }
                    } else{
                        estadoCita = 1;
                    }
                }
            } else {                                                                        //despues de hoy
                if(cita.isCitaEstado()){
                        estadoCita = 1;
                    }else{
                        estadoCita = 3;
                    }
            }
            
        if(estadoCita==0){
            array_vencidas.add(cita);
            }            
        }
        
        System.out.println(array_vencidas);
        return array_vencidas;
    }
    
    private void mes_canceladas(){
        if(mes_elegir.isEnabled()){
            int mes = mes_elegir.getMonth()+1;
            int sede = sede_comoBox.getSelectedIndex()+1;
            ArrayList<CitaVacunacion> array = citadata.buscarCitas_porMesCanceladas(mes, sede);
            
            cargarArray(array);   
            llenarTabla();
            setLabels();
        }
    }
    
    private void año_canceladas(){
         if(anio_elegir.isEnabled()){
            int anio = anio_elegir.getYear();
            int sede = sede_comoBox.getSelectedIndex()+1;
            ArrayList<CitaVacunacion> array = citadata.buscarCitas_porAnioCanceladas(anio, sede);
            
            cargarArray(array);   
            llenarTabla();
            setLabels();
        }
    }
    
    private void mes_aplicadas(){
        if(mes_elegir.isEnabled()){
            int mes = mes_elegir.getMonth()+1;
            int sede = sede_comoBox.getSelectedIndex()+1;
            ArrayList<CitaVacunacion> array = citadata.buscarCitas_porMesAplicadas(mes, sede);
            
            cargarArray(array);   
            llenarTabla();
            setLabels();
        }
    }
    
    private void año_aplicadas(){
         if(anio_elegir.isEnabled()){
            int anio = anio_elegir.getYear();
            int sede = sede_comoBox.getSelectedIndex()+1;
            ArrayList<CitaVacunacion> array = citadata.buscarCitas_porAnioAplicadas(anio, sede);
            
            cargarArray(array);   
            llenarTabla();
            setLabels();
        }

    }
}
