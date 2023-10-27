/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDeDatos.Conexion;
import accesoDeDatos.VacunaData;
import entidades.Laboratorio;
import entidades.Vacuna;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AdministracionVacunas extends javax.swing.JFrame {

    private final VacunaData vacunaData; 
    private Connection con;

    public AdministracionVacunas() {

        initComponents();
        setLocationRelativeTo(null);
        vacunaData = new VacunaData();
        jButtonGuardar.setEnabled(false);
    }

       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jBNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jTnroSerieDosis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextCuit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jCBoxMedida = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jDCVencimiento = new com.toedter.calendar.JDateChooser();
        jTColocada = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBNuevo.setText("Limpiar");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(jBNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jBEliminar.setText("Baja");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 66, -1));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Administración de Vacunas");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 350, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 360, 10));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setText("Nro Serie :");

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel4.setText("Cuit:");

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setText("Laboratorio:");

        jLabel5.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel5.setText("Medida:");

        jLabel6.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel6.setText("Fecha Vencimiento:");

        jLabel7.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel7.setText("Aplicada:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(14, 14, 14)
                            .addComponent(jCBoxMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDCVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(11, 11, 11)
                            .addComponent(jTColocada, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)
                                .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)
                                .addComponent(jTnroSerieDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBBuscar)))))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTnroSerieDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBBuscar))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4))
                    .addComponent(jTextCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(jCBoxMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDCVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(jTColocada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed

        if (chequeoNumeroSerie()) {
         
            int numSerieDosis = Integer.parseInt(jTnroSerieDosis.getText());

             Vacuna vacuna = vacunaData.buscarVacuna(numSerieDosis);

            if (vacuna != null) {

                jComboBoxMarca.removeAllItems();
                jCBoxMedida.removeAllItems();
                jComboBoxMarca.addItem(vacuna.getLaboratorio().getNomLaboratorio());
                jCBoxMedida.addItem(String.valueOf(vacuna.getMedida()));
                jTextCuit.setText(vacuna.getLaboratorio().getCuit());

                if (vacuna != null && vacuna.getFechaCaduca() != null) {
                    LocalDate fechaLocal = vacuna.getFechaCaduca();
                    java.util.Date fecha = java.sql.Date.valueOf(fechaLocal);
                    jDCVencimiento.setDate(fecha);
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha de caducidad no está disponible.");
                }

                jTColocada.setText(vacuna.getColocada() ? "no" : "si");

                soloLectura();
            } else {
                limpiar();
            }
        } else {
            limpiar();
        }

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        jButtonGuardar.setEnabled(true);
        jBEliminar.setEnabled(false);
        jBBuscar.setEnabled(false);

        limpiar();
        soloescritura();
        llenarCombos();

        boolean jtColocada = true;
        String texto = jtColocada ? "no" : "si";
        jTColocada.setText(texto);

    }//GEN-LAST:event_jBNuevoActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        try {
            VacunaData vacunaData = new VacunaData();
            int numSerieDosis = Integer.parseInt(jTnroSerieDosis.getText());

            vacunaData.eliminarVacuna(numSerieDosis);
            limpiar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un numero válido.");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        if (chequeoNumeroSerie()) {
            try {
                Connection connection = Conexion.getConnection(); 
                VacunaData vacunaData = new VacunaData();
                Laboratorio laboratorio = new Laboratorio();

                String nroSerieDosis = jTnroSerieDosis.getText();
                String marca = (String) jComboBoxMarca.getSelectedItem();
                String cuit = jTextCuit.getText();
                String medida = (String) jCBoxMedida.getSelectedItem();

                String vencimiento = new SimpleDateFormat("dd/MM/yyyy").format(jDCVencimiento.getDate());
                String jTColocada = "si"; 
                boolean colocada = jTColocada.equalsIgnoreCase("si") ? true : false;
                int stock = 1;

                Vacuna miVacuna = new Vacuna();

                miVacuna.setNroSerieDosis(Integer.parseInt(nroSerieDosis));
                miVacuna.setLaboratorio(laboratorio);
                laboratorio.setCuit(cuit);
                laboratorio.setNomLaboratorio(marca);
                miVacuna.setMedida(Double.parseDouble(medida));
                miVacuna.setFechaCaduca(LocalDate.parse(vencimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                miVacuna.setColocada(colocada);
                miVacuna.setStock(1);

                vacunaData.guardarVacuna(miVacuna);
                limpiar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Complete todos los campos");
            }
        } else {
           jTnroSerieDosis.setText("");
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(AdministracionVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministracionVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministracionVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministracionVacunas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministracionVacunas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jCBoxMedida;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private com.toedter.calendar.JDateChooser jDCVencimiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTColocada;
    private javax.swing.JTextField jTextCuit;
    private javax.swing.JTextField jTnroSerieDosis;
    // End of variables declaration//GEN-END:variables

    private boolean chequeoNumeroSerie() {
        try {
            Integer lo = Integer.parseInt(jTnroSerieDosis.getText());

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Numero de Serie inválido");
            return false;
        }
    }

    private void limpiar() {
        jTnroSerieDosis.setText("");
        jComboBoxMarca.removeAllItems();
        jTextCuit.setText("");
        jCBoxMedida.removeAllItems();
        jDCVencimiento.setDate(null);
        jTColocada.setText("");

    }

    private void soloLectura() {
        jDCVencimiento.setEnabled(false);
        jTextCuit.setEditable(false);
        jTColocada.setEditable(false);

    }

    private void soloescritura() {
       
        jTextCuit.setEditable(true);
        jDCVencimiento.setEnabled(true);
        jTColocada.setEditable(true);

    }

    private void actualizarCuitDesdeComboBox() {
      
        int selectedIndex = jComboBoxMarca.getSelectedIndex();
       
        if (selectedIndex != -1) {
           
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxMarca.getModel();
            String nomLaboratorio = (String) model.getElementAt(selectedIndex);

          try {
                Connection conexion = Conexion.getConnection();
                String sql = "SELECT cuit FROM laboratorio WHERE nomLaboratorio = ?";
                PreparedStatement statement = conexion.prepareStatement(sql);
                statement.setString(1, nomLaboratorio);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    jTextCuit.setText(resultSet.getString("cuit"));
                } else {
                    jTextCuit.setText("Cuit no encontrado");
                }

               // Cierra la conexión y la declaración.
                resultSet.close();
                statement.close();
            } catch (SQLException ex) {
               
                 JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta"); 
            }
        } else {
           
            jTextCuit.setText(""); 
        }
    }

    private void llenarCombos() {
        limpiar();
        soloescritura();
        jTextCuit.setEditable(false);
        jComboBoxMarca.removeAllItems();

        jComboBoxMarca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCuitDesdeComboBox();
            }
        });
       
        jCBoxMedida.removeAllItems();
        jCBoxMedida.addItem("0.3");
        jCBoxMedida.addItem("0.5");
        jCBoxMedida.addItem("0.9");
        try {
          
            Connection conexion = Conexion.getConnection();

          
            String sql = "SELECT nomLaboratorio, cuit FROM laboratorio";
          PreparedStatement statement = conexion.prepareStatement(sql);
           ResultSet resultSet = statement.executeQuery();

           
            while (resultSet.next()) {
                jComboBoxMarca.addItem(resultSet.getString("nomLaboratorio"));
            }

            resultSet.close();
            statement.close();
          
        } catch (SQLException ex) {
          
           JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta"); 
        }
    }

}
