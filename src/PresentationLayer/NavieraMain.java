/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.awt.Dimension;

/**
 *
 * @author jhon_Ballesteros
 */
public class NavieraMain extends javax.swing.JFrame {

    /**
     * Creates new form NavieraMain
     */
    public NavieraMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBarcos = new javax.swing.JButton();
        btnMarineros = new javax.swing.JButton();
        btnEsposas = new javax.swing.JButton();
        btnHijos = new javax.swing.JButton();
        btnViajes4 = new javax.swing.JButton();
        btnPuertos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnBarcos.setText("Barcos");
        getContentPane().add(btnBarcos);
        btnBarcos.setBounds(153, 140, 112, 56);

        btnMarineros.setText("Marineros");
        getContentPane().add(btnMarineros);
        btnMarineros.setBounds(153, 223, 112, 56);

        btnEsposas.setText("Esposas");
        getContentPane().add(btnEsposas);
        btnEsposas.setBounds(283, 223, 112, 56);

        btnHijos.setText("Hijos");
        btnHijos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHijosActionPerformed(evt);
            }
        });
        getContentPane().add(btnHijos);
        btnHijos.setBounds(420, 220, 112, 56);

        btnViajes4.setText("Viajes");
        getContentPane().add(btnViajes4);
        btnViajes4.setBounds(413, 140, 112, 56);

        btnPuertos.setText("Puertos");
        getContentPane().add(btnPuertos);
        btnPuertos.setBounds(283, 140, 112, 57);

        jLabel1.setText("NAVIERA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(55, 62, 44, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHijosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHijosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHijosActionPerformed

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
            java.util.logging.Logger.getLogger(NavieraMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NavieraMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NavieraMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NavieraMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NavieraMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarcos;
    private javax.swing.JButton btnEsposas;
    private javax.swing.JButton btnHijos;
    private javax.swing.JButton btnMarineros;
    private javax.swing.JButton btnPuertos;
    private javax.swing.JButton btnViajes4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
