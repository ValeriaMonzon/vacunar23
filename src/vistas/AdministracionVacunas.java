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

        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jTnroSerieDosis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTColocada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBNuevo = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextCuit = new javax.swing.JTextField();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jCBoxMedida = new javax.swing.JComboBox<>();
        jDCVencimiento = new com.toedter.calendar.JDateChooser();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setText("Nro Serie :");

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Laboratorio");

        jLabel5.setText("Medida");

        jLabel6.setText("Fecha Vencimiento");

        jLabel7.setText("Aplicada");

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel1.setText("Administracion de Vacunas");

        jBNuevo.setText("Nueva");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBEliminar.setText("Baja");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jLabel4.setText("Cuit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTColocada, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTnroSerieDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextCuit, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jCBoxMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDCVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
                .addComponent(jBNuevo)
                .addGap(30, 30, 30)
                .addComponent(jButtonGuardar)
                .addGap(30, 30, 30)
                .addComponent(jBEliminar)
                .addGap(30, 30, 30)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnroSerieDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jBBuscar))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCBoxMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDCVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTColocada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jButtonGuardar)
                    .addComponent(jBEliminar)
                    .addComponent(jButtonSalir))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTColocada;
    private javax.swing.JTextField jTextCuit;
    private javax.swing.JTextField jTextField1;
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
