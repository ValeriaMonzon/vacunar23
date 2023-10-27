/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDeDatos.CiudadanoData;
import javax.swing.JOptionPane;
import entidades.Ciudadano;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
/**
 *
 * @author valef
 */
public class AdministracionCiudadano extends javax.swing.JFrame {
    
      private final CiudadanoData ciudadanoData;
     
              
 public AdministracionCiudadano(CiudadanoData ciudadanoData) {
     
        this.ciudadanoData = ciudadanoData;
        initComponents();
        setLocationRelativeTo(null);
        
    }

    private AdministracionCiudadano() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();
        jLabelImg2 = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jBmodCiudadano = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabNomCom = new javax.swing.JLabel();
        jLabEmail = new javax.swing.JLabel();
        jTextFDNI = new javax.swing.JTextField();
        jTextFNomCom = new javax.swing.JTextField();
        jTextFEmail = new javax.swing.JTextField();
        jTextFCelu = new javax.swing.JTextField();
        jTextFPato = new javax.swing.JTextField();
        jTextFAmbTrab = new javax.swing.JTextField();
        jTextFDosis = new javax.swing.JTextField();
        jCBoxEstado = new javax.swing.JCheckBox();
        jBBuscarDNI = new javax.swing.JButton();
        jLabCelu = new javax.swing.JLabel();
        jLabPat = new javax.swing.JLabel();
        jLabAmbTrab = new javax.swing.JLabel();
        jLabdosis = new javax.swing.JLabel();
        jLabEstado = new javax.swing.JLabel();
        jLabDNI = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Administracion de Ciudadanos ");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-unisex-96.png"))); // NOI18N
        jPanel1.add(jLabelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, -1));

        jLabelImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-unisex-96.png"))); // NOI18N
        jPanel1.add(jLabelImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 87, -1));

        jBAgregar.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jBAgregar.setText("Agrega");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jBAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jBEliminar.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        jButtonLimpiar.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, -1, -1));

        jButtonSalir.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, -1, -1));

        jBmodCiudadano.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jBmodCiudadano.setText("Modificar");
        jBmodCiudadano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmodCiudadanoActionPerformed(evt);
            }
        });
        jPanel1.add(jBmodCiudadano, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabNomCom.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabNomCom.setText("Nombre Completo : ");

        jLabEmail.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabEmail.setText("Email :");

        jCBoxEstado.setEnabled(false);

        jBBuscarDNI.setFont(new java.awt.Font("Georgia", 1, 11)); // NOI18N
        jBBuscarDNI.setText("Buscar");
        jBBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarDNIActionPerformed(evt);
            }
        });

        jLabCelu.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabCelu.setText("N° de Celular :");

        jLabPat.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabPat.setText("Patologia :");

        jLabAmbTrab.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabAmbTrab.setText("Ambito de Trabajo :");

        jLabdosis.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabdosis.setText("Cant. de dosis Aplicadas : ");

        jLabEstado.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabEstado.setText("Estado en el Sistema :");

        jLabDNI.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabDNI.setText("N° de DNI :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBoxEstado))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabNomCom)
                                    .addGap(384, 384, 384))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFNomCom, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabCelu)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFCelu))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabEmail)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabPat)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFPato, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabAmbTrab)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFAmbTrab))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabdosis)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFDosis, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabDNI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscarDNI)
                        .addGap(47, 47, 47)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarDNI)
                    .addComponent(jLabDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabNomCom)
                    .addComponent(jTextFNomCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabEmail)
                    .addComponent(jTextFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFCelu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabCelu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFPato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabPat))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFAmbTrab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabAmbTrab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFDosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabdosis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCBoxEstado)
                    .addComponent(jLabEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 560, 300));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 400, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarDNIActionPerformed
        if (chequeoDocumento()) {
      if (ciudadanoData.buscarCiudadano(Integer.parseInt(jTextFDNI.getText())) != null) {
        try {
          Integer lo = Integer.parseInt(jTextFDNI.getText());

          Ciudadano ciudadano = ciudadanoData.buscarCiudadano(Integer.parseInt(jTextFDNI.getText()));
          jTextFNomCom.setText(ciudadano.getNomCompleto());
          jTextFEmail.setText(ciudadano.getEmail());
          jTextFCelu.setText(ciudadano.getCelular());
          jTextFPato.setText(ciudadano.getPatologia());
          jTextFAmbTrab.setText(ciudadano.getAmbitoTrabajo());
          jTextFDosis.setText(String.valueOf(ciudadano.getDosis()));
          jCBoxEstado.setSelected(ciudadano.getEstado());
          
          jTextFDNI.setEditable(false);
          
          jBBuscarDNI.setEnabled(false);
          jBmodCiudadano.setEnabled(true);
          jBAgregar.setEnabled(true);
          jBEliminar.setEnabled(true);
          jButtonLimpiar.setEnabled(true);
          jButtonSalir.setEnabled(true);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(null, "El número de documento es inválido");
        }
      }
    } 
    }//GEN-LAST:event_jBBuscarDNIActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
   jTextFDNI.setText(null);
   jTextFNomCom.setText(null);
   jTextFEmail.setText(null);
   jTextFCelu.setText(null);
   jTextFPato.setText(null);
   jTextFAmbTrab.setText(null);
   jTextFDosis.setText(null);
   
   
   jTextFDNI.setEditable(true);
   jBBuscarDNI.setEnabled(true);
   jBmodCiudadano.setEnabled(false);
   jBAgregar.setEnabled(false);
   jBEliminar.setEnabled(false);
   jButtonLimpiar.setEnabled(false);
   jButtonSalir.setEnabled(true);
   jBmodCiudadano.setEnabled(false);
   jCBoxEstado.setSelected(false);
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
       try{
       Ciudadano ciudadano =new Ciudadano(Integer.parseInt(jTextFDNI.getText()),jTextFNomCom.getText(),jTextFEmail.getText(),jTextFCelu.getText(),jTextFPato.getText(),jTextFAmbTrab.getText(),Integer.parseInt(jTextFDosis.getText()),jCBoxEstado.isSelected());
       Ciudadano aux = new CiudadanoData().buscarCiudadano(Integer.parseInt(jTextFDNI.getText()));
     
       if(aux != null){
           
           ciudadanoData.modificarEstado(aux);
       } else {
        if (chequeoExcepciones()) {
            int boole = JOptionPane.showConfirmDialog(null, "¿Desea agregar este Ciudadano?");
            if (boole == 0) {
            new CiudadanoData().GuardarCiudadano(ciudadano);
            }
          }
        }
      } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "El número de documento no es válido");
    }     catch (SQLException ex) {
              Logger.getLogger(AdministracionCiudadano.class.getName()).log(Level.SEVERE, null, ex);
          }
   jBBuscarDNI.setEnabled(false);
   //jBModificar.setEnabled(true);
   jBAgregar.setEnabled(true);
   jBEliminar.setEnabled(true);
   jButtonLimpiar.setEnabled(true);
   jButtonSalir.setEnabled(true);  
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
         if (chequeoDocumento()) {
      if (ciudadanoData.buscarCiudadano(Integer.parseInt(jTextFDNI.getText())) != null) {
        int boole = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar este Ciudadano?");
        if (boole == 0) {
            new CiudadanoData().eliminarCiudadano(Integer.parseInt(jTextFDNI.getText())); 
        }
      }
    }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBmodCiudadanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmodCiudadanoActionPerformed
       if (chequeoExcepciones()) {
      int boole = JOptionPane.showConfirmDialog(null, "¿Estas seguro de modificar este ciudadano?");
      if (boole == 0) {
       Ciudadano ciudadano = ciudadanoData.buscarCiudadano(Integer.parseInt(jTextFDNI.getText()));
        ciudadano.setDni(Integer.parseInt(jTextFDNI.getText()));
        ciudadano.setNomCompleto(jTextFNomCom.getText());
        ciudadano.setEmail(jTextFEmail.getText());
        ciudadano.setCelular(jTextFCelu.getText());
        ciudadano.setPatologia(jTextFPato.getText());
        ciudadano.setAmbitoTrabajo(jTextFAmbTrab.getText());
        ciudadano.setDosis(Integer.parseInt(jTextFDosis.getText()));
        jCBoxEstado.setSelected(ciudadano.getEstado());
       ciudadanoData.modificarCiudadano(ciudadano);
      }
    }
    }//GEN-LAST:event_jBmodCiudadanoActionPerformed

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
            java.util.logging.Logger.getLogger(AdministracionCiudadano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministracionCiudadano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministracionCiudadano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministracionCiudadano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           new AdministracionCiudadano().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBBuscarDNI;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBmodCiudadano;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JCheckBox jCBoxEstado;
    private javax.swing.JLabel jLabAmbTrab;
    private javax.swing.JLabel jLabCelu;
    private javax.swing.JLabel jLabDNI;
    private javax.swing.JLabel jLabEmail;
    private javax.swing.JLabel jLabEstado;
    private javax.swing.JLabel jLabNomCom;
    private javax.swing.JLabel jLabPat;
    private javax.swing.JLabel jLabdosis;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelImg2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFAmbTrab;
    private javax.swing.JTextField jTextFCelu;
    private javax.swing.JTextField jTextFDNI;
    private javax.swing.JTextField jTextFDosis;
    private javax.swing.JTextField jTextFEmail;
    private javax.swing.JTextField jTextFNomCom;
    private javax.swing.JTextField jTextFPato;
    // End of variables declaration//GEN-END:variables

 private boolean chequeoDocumento() {
    try {
      Integer lo = Integer.parseInt(jTextFDNI.getText());

      return true;
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "El número de documento es inválido");
      return false;
    }
  }
private void chequeoTexto(JTextField txt) {
    if (txt.getText().equals("")) {
      int num = 10 / 0;
    }
    for (int i = 0; i < txt.getText().length(); i++) {
      char aux = txt.getText().charAt(i);
      if (aux == '0' || aux == '1' || aux == '2' || aux == '3' || aux == '4' || aux == '5' || aux == '6' || aux == '7' || aux == '8' || aux == '9' || aux == ',' || aux == '.' || aux == '-' || aux == '_' || aux == ';' || aux == ':' || aux == '!' || aux == '"' || aux == '#' || aux == '$' || aux == '%' || aux == '&' || aux == '/' || aux == '(' || aux == ')' || aux == '=' || aux == '?' || aux == '¡' || aux == '¿') {
        int num = 10 / 0;
      }
    }
  }
private boolean chequeoExcepciones() {
    try {
      Integer lo = Integer.parseInt(jTextFDNI.getText());
      chequeoTexto(jTextFNomCom);
      chequeoTexto(jTextFAmbTrab);
       return true;
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "El número de documento no es válido");
      return false;
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null, "El nombre o el apellido no son válidos");
      return false;
    }
  }

}
