/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistaControlador;

import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Horarios extends javax.swing.JFrame {

    private JTable tablaClases;
    private int xx, xy;

    public Horarios() {
 super("Academia de Yoga");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre de la Clase");
        modeloTabla.addColumn("Instructor");
        modeloTabla.addColumn("Horario");

        // Ejemplo de datos para la tabla (puedes reemplazar estos datos con tu lógica)
        Object[] datos1 = {"Yoga Matutino", "Instructor 1", "Lunes y Miércoles 8:00 AM - 9:30 AM"};
        Object[] datos2 = {"Yoga Vespertino", "Instructor 2", "Martes y Jueves 6:00 PM - 7:30 PM"};

        // Agregar filas con datos a la tabla
        modeloTabla.addRow(datos1);
        modeloTabla.addRow(datos2);

        tablaClases = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaClases);
        add(scrollPane, BorderLayout.CENTER);

        // Agregar MouseListener para detectar clics en la tabla
        tablaClases.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tablaClases.getSelectedRow();
                int columnaSeleccionada = tablaClases.getSelectedColumn();

                if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
                    String info = tablaClases.getValueAt(filaSeleccionada, columnaSeleccionada).toString();
                    JOptionPane.showMessageDialog(null, "Seleccionaste: " + info);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cabecera = new javax.swing.JPanel();
        JL_Xsalir = new javax.swing.JLabel();
        JL_minimizar = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Cabecera.setBackground(new java.awt.Color(204, 0, 204));
        Cabecera.setForeground(new java.awt.Color(255, 153, 0));
        Cabecera.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                CabeceraMouseDragged(evt);
            }
        });
        Cabecera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CabeceraMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CabeceraMousePressed(evt);
            }
        });
        Cabecera.setLayout(null);

        JL_Xsalir.setBackground(new java.awt.Color(255, 255, 255));
        JL_Xsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salirX.png"))); // NOI18N
        JL_Xsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_XsalirMouseClicked(evt);
            }
        });
        Cabecera.add(JL_Xsalir);
        JL_Xsalir.setBounds(520, 10, 20, 30);

        JL_minimizar.setBackground(new java.awt.Color(164, 189, 152));
        JL_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/minimizar.jpg"))); // NOI18N
        JL_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JL_minimizarMouseClicked(evt);
            }
        });
        Cabecera.add(JL_minimizar);
        JL_minimizar.setBounds(490, 10, 20, 30);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JL_XsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_XsalirMouseClicked
        System.exit(0);// Cierra la aplicacion
    }//GEN-LAST:event_JL_XsalirMouseClicked

    private void JL_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JL_minimizarMouseClicked
        setExtendedState(Login.ICONIFIED);
    }//GEN-LAST:event_JL_minimizarMouseClicked

    private void CabeceraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CabeceraMouseDragged

        setLocation((int) MouseInfo.getPointerInfo().getLocation().getX() - xx, (int) MouseInfo.getPointerInfo().getLocation().getY() - xy);
    }//GEN-LAST:event_CabeceraMouseDragged

    private void CabeceraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CabeceraMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CabeceraMouseClicked

    private void CabeceraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CabeceraMousePressed
        xx = ((int) MouseInfo.getPointerInfo().getLocation().getX() - getX());
        xy = ((int) MouseInfo.getPointerInfo().getLocation().getY() - getY());
    }//GEN-LAST:event_CabeceraMousePressed

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
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Horarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Horarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cabecera;
    private javax.swing.JLabel JL_Xsalir;
    private javax.swing.JLabel JL_minimizar;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
