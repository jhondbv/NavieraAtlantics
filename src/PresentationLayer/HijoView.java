/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Business.HijoLogic;
import Business.MarineroLogic;
import Business.TipoBarcoLogic;
import Class.Hijo;
import Class.Hijos;
import Class.Marinero;
import Class.Marineros;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Penagos
 */
public class HijoView extends javax.swing.JFrame {

    /**
     * Creates new form HijoView
     */
    private HijoLogic hijoLogic =null;
        private MarineroLogic marineroLogic =null;

    private static int id;
    public HijoView() {
        initComponents();
        hijoLogic= new HijoLogic();
        marineroLogic=new MarineroLogic();
        LoadPadres();
    }
    public void Clear() {
        txtNombre.setText("");
         cmbPadre.setSelectedIndex(0);
        id = 0;
    }
    
    private void LoadPadres()
    {
        Marineros lst = marineroLogic.Consultar();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbPadre.getModel();
        model.removeAllElements();
        for (Marinero item : lst.List) {
            model.addElement(item);
        }
    }
    
     private void SelectPadre(int id)
    {
        int size = cmbPadre.getItemCount();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbPadre.getModel();
        for (int i = 0; i < size; i++) {
            Marinero item = (Marinero)model.getElementAt(i);
            if(item.getId()==id)
            {
                model.setSelectedItem(item);
            }
        }
    }
     
       public void GetData() {
        Hijos hijos  = hijoLogic.ConsultarConRelaciones();
        DefaultTableModel model = (DefaultTableModel) tblHijo.getModel();
        if(hijos==null)
            return;
        for (Hijo hijo : hijos.List) {
            model.addRow(new Object[]{hijo.getId(), hijo.getNombre(), hijo.getSexo(), hijo.padre.getNombre()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboSexo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHijo = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cmbPadre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Nombre");

        jLabel3.setText("Padre");

        ComboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        jLabel4.setText("HIJOS");

        jLabel5.setText("Sexo");

        tblHijo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Sexo", "Padre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHijo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHijoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHijo);
        if (tblHijo.getColumnModel().getColumnCount() > 0) {
            tblHijo.getColumnModel().getColumn(0).setResizable(false);
            tblHijo.getColumnModel().getColumn(1).setResizable(false);
            tblHijo.getColumnModel().getColumn(2).setResizable(false);
            tblHijo.getColumnModel().getColumn(3).setResizable(false);
        }

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmbPadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(205, 205, 205)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ComboSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(cmbPadre, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addComponent(btnAgregar)
                                    .addGap(17, 17, 17)
                                    .addComponent(btnActualizar)))
                            .addGap(52, 52, 52)
                            .addComponent(btnEliminar)
                            .addGap(34, 34, 34)
                            .addComponent(btnLimpiar))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPadre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Hijo hijo = new Hijo();
         DefaultComboBoxModel cmbmodel = (DefaultComboBoxModel)cmbPadre.getModel();
             Marinero h = (Marinero)cmbmodel.getSelectedItem();
            
        hijo.setNombre(txtNombre.getText());
        hijo.setSexo(ComboSexo.getSelectedItem().toString().charAt(0));
         hijo.setIdPapa(h.getId());
        new HijoLogic().Guardar(hijo);

        DefaultTableModel model = (DefaultTableModel) tblHijo.getModel();
        model.addRow(new Object[]{hijo.getId(), hijo.getNombre(), hijo.getSexo(), hijo.padre.getNombre()});
        Clear();
    }//GEN-LAST:event_btnAgregarActionPerformed
   
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (id > 0) {
            int fila = tblHijo.getSelectedRow();
             DefaultComboBoxModel cmbmodel = (DefaultComboBoxModel)cmbPadre.getModel();
             Marinero h = (Marinero)cmbmodel.getSelectedItem();
            
            Hijo hijo = hijoLogic.Consultar(id);
            hijo.setNombre(txtNombre.getText());
            hijo.setSexo(ComboSexo.getSelectedItem().toString().charAt(0));
            hijo.setIdPapa(h.getId());
            
            Clear();
            hijoLogic.Actualizar(hijo);
            DefaultTableModel model = (DefaultTableModel) tblHijo.getModel();
            model.removeRow(fila);
            model.insertRow(fila, new Object[]{hijo.getId(), hijo.getNombre(), hijo.getSexo(), hijo.padre.getNombre()});

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para editar");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         if (id > 0) {
            int fila = tblHijo.getSelectedRow();
            HijoLogic logic = new HijoLogic();
            logic.Eliminar(id);
            DefaultTableModel model = (DefaultTableModel) tblHijo.getModel();
            model.removeRow(fila);
            Clear();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para eliminar");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblHijoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHijoMouseClicked
        int fila = tblHijo.getSelectedRow();
        if (fila >= 0) {
            txtNombre.setText(tblHijo.getValueAt(fila, 1).toString());
            id = Integer.parseInt(tblHijo.getValueAt(fila, 0).toString());
            Hijo hijo = hijoLogic.Consultar(id);
            SelectPadre(hijo.getIdPapa());
        } 
    }//GEN-LAST:event_tblHijoMouseClicked

  
    
    
    
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
            java.util.logging.Logger.getLogger(HijoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HijoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HijoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HijoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HijoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboSexo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbPadre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHijo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
