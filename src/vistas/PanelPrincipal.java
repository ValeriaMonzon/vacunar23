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
    citaVacunacionData= new CitaVacunacionData();
    laboratorioData = new LaboratorioData();
    vacunaData =new VacunaData();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        administracion = new javax.swing.JMenu();
        jMenuItemciudadano = new javax.swing.JMenuItem();
        jMenuItemTurnos = new javax.swing.JMenuItem();
        jMenuItemVacunas = new javax.swing.JMenuItem();
        jMenuItemLaboratorio = new javax.swing.JMenuItem();
        jMenuItemSedes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        administracion.setText("Administracion");

        jMenuItemciudadano.setText("Ciudadano");
        jMenuItemciudadano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemciudadanoActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemciudadano);

        jMenuItemTurnos.setText("Turnos");
        jMenuItemTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTurnosActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemTurnos);

        jMenuItemVacunas.setText("Vacunas");
        jMenuItemVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVacunasActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemVacunas);

        jMenuItemLaboratorio.setText("Laboratorio");
        jMenuItemLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLaboratorioActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemLaboratorio);

        jMenuItemSedes.setText("Sedes");
        jMenuItemSedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSedesActionPerformed(evt);
            }
        });
        administracion.add(jMenuItemSedes);

        jMenuBar.add(administracion);

        jMenu3.setText("Edit");
        jMenuBar.add(jMenu3);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemciudadanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemciudadanoActionPerformed
    AdministracionCiudadano form = new AdministracionCiudadano();
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

    private void jMenuItemSedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSedesActionPerformed
    AdministracionSedes form = new AdministracionSedes();
    form.setVisible(true); 
    }//GEN-LAST:event_jMenuItemSedesActionPerformed

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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemLaboratorio;
    private javax.swing.JMenuItem jMenuItemSedes;
    private javax.swing.JMenuItem jMenuItemTurnos;
    private javax.swing.JMenuItem jMenuItemVacunas;
    private javax.swing.JMenuItem jMenuItemciudadano;
    // End of variables declaration//GEN-END:variables
}
