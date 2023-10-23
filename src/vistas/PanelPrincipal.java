/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoDeDatos.*;
import java.sql.Connection;

/**
 *
 * @author valef
 */
public class PanelPrincipal extends javax.swing.JFrame {

  private final CiudadanoData ciudadanoData;
  private final CitaVacunacionData citaVacunacionData;
  private final LaboratorioData laboratorioData;
  private final VacunaData vacunaData;

  public PanelPrincipal() {
    Connection con = Conexion.getConnection();
    if (con != null) {
      initComponents();
      setLocationRelativeTo(null);
    } else {
      System.exit(0);
    }
    ciudadanoData = new CiudadanoData();
    citaVacunacionData = new CitaVacunacionData();
    laboratorioData = new LaboratorioData();
    vacunaData = new VacunaData();
  }

  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        administracion = new javax.swing.JMenu();
        jMenuItemciudadano = new javax.swing.JMenuItem();
        jMenuItemTurnos = new javax.swing.JMenuItem();
        jMenuItemVacunas = new javax.swing.JMenuItem();
        jMenuItemLaboratorio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMSede = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-vacuna-portada - copia.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenuBar.setForeground(new java.awt.Color(102, 204, 255));

        administracion.setText("Administracion");
        administracion.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N

        jMenuItemciudadano.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenuItemciudadano.setText("Ciudadano");
        jMenuItemciudadano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemciudadanoActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemciudadano);

        jMenuItemTurnos.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenuItemTurnos.setText("Turnos");
        jMenuItemTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTurnosActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemTurnos);

        jMenuItemVacunas.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenuItemVacunas.setText("Vacunas");
        jMenuItemVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVacunasActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemVacunas);

        jMenuItemLaboratorio.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenuItemLaboratorio.setText("Laboratorio");
        jMenuItemLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLaboratorioActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemLaboratorio);

        jMenuBar.add(administracion);

        jMenu3.setText("Consultas");
        jMenu3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenuItem1.setText("Citas por mes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMSede.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMSede.setText("Aplicaciones por sede");
        jMSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMSedeActionPerformed(evt);
            }
        });
        jMenu3.add(jMSede);

        jMenuBar.add(jMenu3);

        jMenu1.setText("Aplicar vacunas");
        jMenu1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jMenuItem3.setText("Citas por dia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemciudadanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemciudadanoActionPerformed
    AdministracionCiudadano form = new AdministracionCiudadano(ciudadanoData);
    form.setVisible(true);
    }//GEN-LAST:event_jMenuItemciudadanoActionPerformed

    private void jMenuItemTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTurnosActionPerformed
    AdministracionTurnos form = new AdministracionTurnos();
    form.setVisible(true);
    }//GEN-LAST:event_jMenuItemTurnosActionPerformed

    private void jMenuItemVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVacunasActionPerformed
    AdministracionVacunas form = new AdministracionVacunas();
    form.setVisible(true);
    }//GEN-LAST:event_jMenuItemVacunasActionPerformed

    private void jMenuItemLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLaboratorioActionPerformed
    AdministracionLaboratorios form = new AdministracionLaboratorios();
    form.setVisible(true);
    }//GEN-LAST:event_jMenuItemLaboratorioActionPerformed

  private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    ConsultaCitasPorMes form = new ConsultaCitasPorMes();
    form.setVisible(true);
  }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CitasXDia form = new CitasXDia();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMSedeActionPerformed
        ConsultasAplicacionesPorSede form = new ConsultasAplicacionesPorSede();
        form.setVisible(true);
    }//GEN-LAST:event_jMSedeActionPerformed

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
      java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(PanelPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PanelPrincipal().setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu administracion;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMSede;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemLaboratorio;
    private javax.swing.JMenuItem jMenuItemTurnos;
    private javax.swing.JMenuItem jMenuItemVacunas;
    private javax.swing.JMenuItem jMenuItemciudadano;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
