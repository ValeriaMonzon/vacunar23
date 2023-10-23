/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDeDatos.CiudadanoData;
import accesoDeDatos.Conexion;
import accesoDeDatos.LaboratorioData;
import entidades.Ciudadano;
import entidades.Laboratorio;
import entidades.Vacuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdministracionTurnos extends javax.swing.JFrame {

    private Connection con = null; 
       
    
    
    private List<Laboratorio> list;

    public AdministracionTurnos() {
       con = Conexion.getConnection();
      
        initComponents();
  // Llama a la función para actualizar el JComboBox "jComboBoxLaboratorio"
    llenarComboBoxLaboratorio(jComboBoxLaboratorio, jComboBoxDosis);
    
    // Llama a la función para llenar el JComboBox "jComboDosis" con las medidas correspondientes
    llenarComboBoxDosis(jComboBoxLaboratorio, jComboBoxDosis, jTSerieDosis);
    
      // Llama a la función para llenar el JComboBox "jComboBoxHoraCita" con horarios
    llenarComboBoxHorarios(jComboBoxHoraCita);
    
     // Obtén la fecha actual
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();

        // Calcula la fecha máxima seleccionable (día actual + 20 días)
        calendar.add(Calendar.DATE, 20);
        Date maxDate = calendar.getTime();

        // Configura el JDateChooser
        jDateChFecha.setMinSelectableDate(currentDate);
        jDateChFecha.setMaxSelectableDate(maxDate);
         setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jBEliminar = new javax.swing.JButton();
        jBSolicitar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextApellido = new javax.swing.JTextField();
        jTDni = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextDosisColocada = new javax.swing.JTextField();
        jComboBoxDosis = new javax.swing.JComboBox<>();
        jComboBoxHoraCita = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxSucursal = new javax.swing.JComboBox();
        jTSerieDosis = new javax.swing.JTextField();
        jDateChFecha = new com.toedter.calendar.JDateChooser();
        jComboBoxLaboratorio = new javax.swing.JComboBox<>();
        jBConsulta = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jBEliminar.setText("Eliminar");

        jBSolicitar.setText("Solicitar");
        jBSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSolicitarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Turnos");

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Dni");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dosis");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Hora");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Laboratorio");

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Dosis");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Sucursal");

        jComboBoxSucursal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        jComboBoxSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentLayout.createSequentialGroup()
                            .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBBuscar))
                        .addGroup(contentLayout.createSequentialGroup()
                            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48))
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addComponent(jComboBoxHoraCita, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(95, 95, 95)))
                            .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(45, 45, 45)
                                    .addComponent(jTextDosisColocada, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBoxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentLayout.createSequentialGroup()
                            .addComponent(jComboBoxDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(jTSerieDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentLayout.createSequentialGroup()
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTextDosisColocada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTSerieDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(jDateChFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(contentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(55, 55, 55))))
        );

        jBConsulta.setText("Consulta");
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(342, 342, 342))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBSolicitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBSolicitar)
                        .addGap(41, 41, 41)
                        .addComponent(jBConsulta)
                        .addGap(41, 41, 41)
                        .addComponent(jBEliminar)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonSalir)
                        .addGap(41, 41, 41))
                    .addComponent(content, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jBSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSolicitarActionPerformed


    }//GEN-LAST:event_jBSolicitarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
 // Obtén el DNI desde el campo de texto jTDni
    int dni = Integer.parseInt(jTDni.getText());

    // Llama al método buscarCiudadano para obtener la información del ciudadano
    CiudadanoData  ciudadanoData = new  CiudadanoData();
    Ciudadano ciudadano = ciudadanoData.buscarCiudadano(dni);
    if (ciudadano != null) {
        // Si se encontró al ciudadano, muestra su apellido en el campo jTextApellido
        jTextApellido.setText(ciudadano.getNomCompleto()); // Reemplaza "getApellido()" con el método correcto para obtener el apellido
        jTextDosisColocada.setText(String.valueOf(ciudadano.getDosis()));
        
    } else {
        // Si no se encontró al ciudadano, muestra un mensaje de error
        JOptionPane.showMessageDialog(null, "No se encontró al ciudadano.");
    }
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jComboBoxSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSucursalActionPerformed

     
    }//GEN-LAST:event_jComboBoxSucursalActionPerformed

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
            java.util.logging.Logger.getLogger(AdministracionTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministracionTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministracionTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministracionTurnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministracionTurnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBConsulta;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBSolicitar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxDosis;
    private javax.swing.JComboBox<String> jComboBoxHoraCita;
    private javax.swing.JComboBox<String> jComboBoxLaboratorio;
    private javax.swing.JComboBox jComboBoxSucursal;
    private com.toedter.calendar.JDateChooser jDateChFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JTextField jTDni;
    private javax.swing.JTextField jTSerieDosis;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextDosisColocada;
    // End of variables declaration//GEN-END:variables
 
public void llenarComboBoxLaboratorio(JComboBox<String> jComboBoxLaboratorio, JComboBox<String> jComboDosis) {
    try {
        String sql = "SELECT DISTINCT marca FROM vacuna WHERE stock >= 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Limpia el JComboBox antes de agregar nuevos elementos
        jComboBoxLaboratorio.removeAllItems();

        while (rs.next()) {
            String marca = rs.getString("marca");
            jComboBoxLaboratorio.addItem(marca);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla vacuna");
    }
}

public void llenarComboBoxDosis(JComboBox<String> jComboBoxLaboratorio, JComboBox<String> jComboDosis, JTextField jTSerieDosis) {
    try {
        String marcaSeleccionada = (String) jComboBoxLaboratorio.getSelectedItem();

        if (marcaSeleccionada != null) {
            String sql = "SELECT medida, nroSerieDosis FROM vacuna WHERE stock >= 1 AND marca = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, marcaSeleccionada);
            ResultSet rs = ps.executeQuery();

            // Utilizamos un HashMap para almacenar las medidas y sus números de serie
            Map<String, Integer> medidasYnroSerie = new HashMap<>();

            while (rs.next()) {
                String medida = rs.getString("medida");
                int nroSerie = rs.getInt("nroSerieDosis");

                // Agregamos la medida al JComboBox solo si no existe en el HashMap
                if (!medidasYnroSerie.containsKey(medida)) {
                    jComboDosis.addItem(medida);
                    medidasYnroSerie.put(medida, nroSerie);
                }
            }

            ps.close();

            // Asignamos el número de serie correspondiente al JTextField jTSerieDosis
            String medidaSeleccionada = (String) jComboDosis.getSelectedItem();
            int nroSerieSeleccionado = medidasYnroSerie.get(medidaSeleccionada);
            jTSerieDosis.setText(Integer.toString(nroSerieSeleccionado));
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla vacuna");
    }
}
private void llenarComboBoxHorarios(JComboBox<String> jComboBoxHoraCita) {
    // Define las horas de inicio y fin
    int horaInicio = 8;
    int horaFin = 18;

    // Define los minutos del intervalo
    int intervaloMinutos = 15;

    // Crea un SimpleDateFormat para formatear la hora
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    // Limpia el JComboBox antes de agregar nuevos elementos
    jComboBoxHoraCita.removeAllItems();

    // Bucle para generar los horarios en intervalos de 15 minutos
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, horaInicio);
    calendar.set(Calendar.MINUTE, 0);

    while (calendar.get(Calendar.HOUR_OF_DAY) < horaFin) {
        String horaFormateada = sdf.format(calendar.getTime());
        jComboBoxHoraCita.addItem(horaFormateada);

        // Agrega 15 minutos al tiempo actual
        calendar.add(Calendar.MINUTE, intervaloMinutos);
    }
}
 private ArrayList<String> generateTimeStrings() {

        ArrayList<String> timeList = new ArrayList<>();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Calendar calendario = Calendar.getInstance();

        // Establece la hora inicial a las 8:00 AM
        calendario.set(Calendar.HOUR_OF_DAY, 8);
        calendario.set(Calendar.MINUTE, 0);

        // Clona el calendario para mantener una instancia separada
        Calendar calendarioClone = (Calendar) calendario.clone();

        // Agrega todas las horas en intervalos de 15 minutos hasta las 18:00
        while (calendarioClone.get(Calendar.HOUR_OF_DAY) <= 17) {
            timeList.add(formatoHora.format(calendarioClone.getTime()));
            calendarioClone.add(Calendar.MINUTE, 15);
        }

        return timeList;
    }
}