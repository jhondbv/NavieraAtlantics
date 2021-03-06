/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import Business.BarcoLogic;
import Business.EsposaLogic;
import Business.HijoLogic;
import Business.MarineroLogic;
import Business.PuertoLogic;
import Business.ViajeLogic;
import Class.Barco;
import Class.Barcos;
import Class.ID;
import Class.Marinero;
import Class.Marineros;
import Class.Puerto;
import Class.Puertos;
import Class.Viaje;
import Class.Viajes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Penagos
 */
public class ViajesView extends javax.swing.JFrame {
    private static int id;
    private static BarcoLogic barcoLogic;
    private static PuertoLogic puertoLogic;
    private static EsposaLogic esposaLogic;
    private static HijoLogic hijoLogic;
    private static MarineroLogic marineroLogic;
    private static ViajeLogic viajeLogic;
 


    /**
     * Creates new form ViajesView
     */
    public ViajesView() {
        initComponents();
        configClose();
        id=0;
      
        barcoLogic= new BarcoLogic();
        puertoLogic=new PuertoLogic();
        esposaLogic=new EsposaLogic();
        hijoLogic=new HijoLogic();
        marineroLogic=new MarineroLogic();
        viajeLogic=new ViajeLogic();
        GetData();
        LoadBarcos();
        LoadPuertos();
        LoadMarineros();
         lstAtracos.setModel(new DefaultListModel());
         lstTripulacion.setModel(new DefaultListModel());
    }

    public void configClose()
    {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
          
    }
    public void SetTripulacion(Viaje item) {
         DefaultListModel listaTripulacion = (DefaultListModel) lstTripulacion.getModel();
         listaTripulacion.removeAllElements();
        for (ID idMarinero : item.getTripulacion()) {
            Marinero marinero = marineroLogic.Consultar(idMarinero.id);
            if (marinero != null) {
               
                listaTripulacion.addElement(marinero);
            }

        }

    }
    public void SetAtracos(Viaje item) {
         DefaultListModel listaAtracos = (DefaultListModel) lstAtracos.getModel();
         listaAtracos.removeAllElements();
        for (ID idPuerto : item.getPuertosAtraco()) {
            Puerto puerto = puertoLogic.Consultar(idPuerto.id);
            if (puerto != null) {
               
                listaAtracos.addElement(puerto);
            }

        }

    }
    
    public void LoadPuertos()
    {
        Puertos lst = puertoLogic.Consultar();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbDestino.getModel();
        DefaultComboBoxModel modelO = (DefaultComboBoxModel)cmbOrigen.getModel();
                DefaultComboBoxModel modelA = (DefaultComboBoxModel)cmbAtraco.getModel();

        model.removeAllElements();
        modelO.removeAllElements();
                modelA.removeAllElements();

        for (Puerto item : lst.List) {
            model.addElement(item);
            modelO.addElement(item);
                        modelA.addElement(item);
        }
        
        //DefaultListModel listatracos = (DefaultListModel)lstAtracos.getModel();
        //listatracos.removeAllElements();
        lstAtracos.setListData(new String[0]);
       
    
    }
      public void LoadMarineros()
    {
        Marineros lst = marineroLogic.Consultar();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbTripulacion.getModel();
        model.removeAllElements();
        for (Marinero item : lst.List) {
            model.addElement(item);
        }
        
        // DefaultListModel listtripulacion = (DefaultListModel) lstAtracos.getModel();
       // listtripulacion.removeAllElements();
       lstTripulacion.setListData(new String[0]);
    }
    
    public void LoadBarcos()
    {
        Barcos lst = barcoLogic.Consultar();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbBarco.getModel();
        model.removeAllElements();
        for (Barco item : lst.List) {
            model.addElement(item);
        }
    }
    
     public void Clear() {
     
       
         txtEncomienda.setText("");
        DefaultListModel listatracos = (DefaultListModel) lstAtracos.getModel();
        DefaultListModel listtripulacion = (DefaultListModel) lstTripulacion.getModel();
        listatracos.removeAllElements();
        listtripulacion.removeAllElements();
         cmbBarco.setSelectedIndex(0);
         cmbDestino.setSelectedIndex(0);
         cmbOrigen.setSelectedIndex(0); 
         cmbAtraco.setSelectedIndex(0); 
         cmbTripulacion.setSelectedIndex(0); 
    }
     
     public void GetData()
     {
     
       Viajes viajes  = viajeLogic.ConsultarConRelaciones();
        DefaultTableModel model = (DefaultTableModel) tblViajes.getModel();
        if(viajes==null)
            return;
        for (Viaje viaje : viajes.List) {
            model.addRow(new Object[]{viaje.getId(),viaje.barco.getNombre(), viaje.puertoOrigen.getDescripcion(),viaje.puertoDestino.getDescripcion()});
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViajes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbOrigen = new javax.swing.JComboBox<>();
        cmbDestino = new javax.swing.JComboBox<>();
        cmbBarco = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtEncomienda = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdbEnCurso = new javax.swing.JRadioButton();
        rdbFinalizado = new javax.swing.JRadioButton();
        cmbAtraco = new javax.swing.JComboBox<>();
        cmbTripulacion = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAtracos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTripulacion = new javax.swing.JList<>();
        btnAgregarAtraco = new javax.swing.JButton();
        btnAgregarTripulacion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("VIAJES");

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

        tblViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Barco", "Origen", "Destino"
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
        tblViajes.getTableHeader().setReorderingAllowed(false);
        tblViajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViajesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViajes);
        if (tblViajes.getColumnModel().getColumnCount() > 0) {
            tblViajes.getColumnModel().getColumn(0).setResizable(false);
            tblViajes.getColumnModel().getColumn(1).setResizable(false);
            tblViajes.getColumnModel().getColumn(2).setResizable(false);
            tblViajes.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setText("Origen");

        jLabel7.setText("Destino");

        jLabel8.setText("Barco");

        cmbOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbBarco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Atracos");

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel2.setText("No. Paquetes encomienda");

        jLabel9.setText("Tripulacion");

        rdbEnCurso.setText("En Curso");
        rdbEnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEnCursoActionPerformed(evt);
            }
        });

        rdbFinalizado.setText("Finalizado");
        rdbFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFinalizadoActionPerformed(evt);
            }
        });

        cmbAtraco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTripulacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lstAtracos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstAtracos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAtracosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstAtracos);

        lstTripulacion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstTripulacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTripulacionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstTripulacion);

        btnAgregarAtraco.setText("Agregar");
        btnAgregarAtraco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAtracoActionPerformed(evt);
            }
        });

        btnAgregarTripulacion.setText("Agregar");
        btnAgregarTripulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTripulacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbBarco, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(299, 299, 299)
                                    .addComponent(btnEliminar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(btnAgregar)
                                    .addGap(49, 49, 49)
                                    .addComponent(btnActualizar)
                                    .addGap(147, 147, 147)
                                    .addComponent(btnLimpiar))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(btnAgregarAtraco)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnAgregarTripulacion)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbAtraco, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtEncomienda, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rdbEnCurso)
                                                        .addGap(54, 54, 54)
                                                        .addComponent(rdbFinalizado)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(cmbTripulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtEncomienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbEnCurso)
                    .addComponent(rdbFinalizado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbAtraco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarAtraco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAgregar)
                                    .addComponent(btnActualizar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnLimpiar))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbTripulacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarTripulacion)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            Viaje viaje = new Viaje();
            if(!tryParseInt(txtEncomienda.getText()))
            {
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido para las encomiendas");
                return;
            }
             DefaultListModel listaTripulacion = (DefaultListModel) lstTripulacion.getModel();
                          DefaultListModel listaAtracos = (DefaultListModel) lstAtracos.getModel();

            if(listaTripulacion.getSize()==0)
            {
                JOptionPane.showMessageDialog(this, "Debe Seleccionar una tripulacion");
                return;
            }
            DefaultComboBoxModel modelBarco = (DefaultComboBoxModel)cmbBarco.getModel();
            DefaultComboBoxModel modelDestino = (DefaultComboBoxModel)cmbDestino.getModel();
            DefaultComboBoxModel modelOrigen = (DefaultComboBoxModel)cmbOrigen.getModel();
            
            Barco barco = (Barco)modelBarco.getSelectedItem();
            Puerto origen = (Puerto)modelOrigen.getSelectedItem();
            Puerto destino = (Puerto)modelDestino.getSelectedItem();
            viaje.barco=barco;
            viaje.puertoDestino=destino;
            viaje.puertoOrigen=origen;
                   
            viaje.setIdBarco(barco.getId());
            viaje.setIdPuertoDestino(destino.getId());
            viaje.setIdPuertoOrigen(origen.getId());
           List<ID> tripulacion = new ArrayList<ID>();
            for (int i = 0; i < listaTripulacion.getSize(); i++) {
                 ID t = new ID();
                t.id=((Marinero) listaTripulacion.getElementAt(i)).getId();
                tripulacion.add(t);
              
            }
            List<ID> atracos = new ArrayList<ID>();
            for (int i = 0; i < listaAtracos.getSize(); i++) {
                ID t = new ID();
                t.id=((Puerto) listaAtracos.getElementAt(i)).getId();
                atracos.add(t);
            }
            viaje.setTripulacion(tripulacion);
            viaje.setPuertosAtraco(atracos);
             viaje.setFinalizado(rdbFinalizado.isSelected());
            viaje.setEnCurso(rdbEnCurso.isSelected());
            viaje.setNumEncomiendas(Integer.parseInt(txtEncomienda.getText()));
            
            viajeLogic.Guardar(viaje);
            
            DefaultTableModel model=(DefaultTableModel) tblViajes.getModel();
            model.addRow(new Object[]{viaje.getId(),viaje.barco.getNombre(), viaje.puertoOrigen.getDescripcion(),viaje.puertoDestino.getDescripcion()});
            Clear();

        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
             if (id > 0) {
            int fila = tblViajes.getSelectedRow();
            Viaje viaje = viajeLogic.Consultar(id);
           if(!tryParseInt(txtEncomienda.getText()))
            {
                JOptionPane.showMessageDialog(this, "Debe ingresar un numero valido para las encomiendas");
                return;
            }
            DefaultListModel listaTripulacion = (DefaultListModel) lstTripulacion.getModel();
            DefaultListModel listaAtracos = (DefaultListModel) lstAtracos.getModel();
            if(listaTripulacion.getSize()==0)
            {
                JOptionPane.showMessageDialog(this, "Debe Seleccionar una tripulacion");
                return;
            }
            
            
            DefaultComboBoxModel modelBarco = (DefaultComboBoxModel)cmbBarco.getModel();
            DefaultComboBoxModel modelDestino = (DefaultComboBoxModel)cmbDestino.getModel();
            DefaultComboBoxModel modelOrigen = (DefaultComboBoxModel)cmbOrigen.getModel();
            
            Barco barco = (Barco)modelBarco.getSelectedItem();
            Puerto origen = (Puerto)modelOrigen.getSelectedItem();
            Puerto destino = (Puerto)modelDestino.getSelectedItem();
             viaje.barco=barco;
            viaje.puertoDestino=destino;
            viaje.puertoOrigen=origen;
            viaje.setIdBarco(barco.getId());
            viaje.setIdPuertoDestino(destino.getId());
            viaje.setIdPuertoOrigen(origen.getId());
           List<ID> tripulacion = new ArrayList<ID>();
            for (int i = 0; i < listaTripulacion.getSize(); i++) {
                 ID t = new ID();
                t.id=((Marinero) listaTripulacion.getElementAt(i)).getId();
                tripulacion.add(t);
              
            }
            List<ID> atracos = new ArrayList<ID>();
            for (int i = 0; i < listaAtracos.getSize(); i++) {
                ID t = new ID();
                t.id=((Puerto) listaAtracos.getElementAt(i)).getId();
                atracos.add(t);
            }
            viaje.setTripulacion(tripulacion);
            viaje.setPuertosAtraco(atracos);
            viaje.setFinalizado(rdbFinalizado.isSelected());
            viaje.setEnCurso(rdbEnCurso.isSelected());
            viaje.setNumEncomiendas(Integer.parseInt(txtEncomienda.getText()));
            viajeLogic.Actualizar(viaje);
            
            DefaultTableModel model = (DefaultTableModel) tblViajes.getModel();
            model.removeRow(fila);
             model.addRow(new Object[]{viaje.getId(),viaje.barco.getNombre(), viaje.puertoOrigen.getDescripcion(),viaje.puertoDestino.getDescripcion()});
            Clear();

        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para editar");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         
        try {
              if (id > 0) {
            int fila = tblViajes.getSelectedRow();
            viajeLogic.Eliminar(id);
            DefaultTableModel model = (DefaultTableModel) tblViajes.getModel();
            model.removeRow(fila);
            Clear();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro para eliminar");
        }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, e.getMessage());
        }
      
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
       Clear();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
       dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void tblViajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViajesMouseClicked
        int fila = tblViajes.getSelectedRow();
        if (fila >= 0) {
            id = Integer.parseInt(tblViajes.getValueAt(fila, 0).toString());
            Viaje viaje = viajeLogic.Consultar(id);
            txtEncomienda.setText(String.valueOf(viaje.getNumEncomiendas()) );
            SelectBarco(viaje.getIdBarco());
            SelectDestino(viaje.getIdPuertoDestino());
            SelectOrigen(viaje.getIdPuertoOrigen());
            rdbEnCurso.setSelected(viaje.isEnCurso());
            rdbFinalizado.setSelected(viaje.isFinalizado());
            SetTripulacion(viaje);
            SetAtracos(viaje);
            
        } 
    }//GEN-LAST:event_tblViajesMouseClicked

    private void rdbFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFinalizadoActionPerformed
       rdbEnCurso.setSelected(false);
    }//GEN-LAST:event_rdbFinalizadoActionPerformed

    private void rdbEnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEnCursoActionPerformed
       rdbFinalizado.setSelected(false);
    }//GEN-LAST:event_rdbEnCursoActionPerformed

    private void btnAgregarTripulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTripulacionActionPerformed
        DefaultComboBoxModel modelMarinero = (DefaultComboBoxModel)cmbTripulacion.getModel();
        DefaultListModel listtripulacion = (DefaultListModel) lstTripulacion.getModel();
        Marinero marinero = (Marinero)modelMarinero.getSelectedItem();
        boolean bandCapitan = marinero.isIsCapitan();
        int size = listtripulacion.getSize();
        for (int i = 0; i < size; i++) {
            Marinero item = (Marinero)listtripulacion.getElementAt(i);
            if(bandCapitan)
            {
                if(item.isIsCapitan())
                {
                    JOptionPane.showMessageDialog(this, "Ya existe un capitan en la lista ");
                    return;
                }
            }
            if(item.getId()==marinero.getId())
            {
                JOptionPane.showMessageDialog(this, "Este elemento ya esta en la lista");
                return;
            }
        }
        listtripulacion.addElement(marinero);
        
    }//GEN-LAST:event_btnAgregarTripulacionActionPerformed

    private void btnAgregarAtracoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAtracoActionPerformed
        DefaultListModel listatracos = (DefaultListModel) lstAtracos.getModel();
        DefaultComboBoxModel modelPuertos = (DefaultComboBoxModel)cmbAtraco.getModel();
        Puerto puerto = (Puerto)modelPuertos.getSelectedItem();
        
        int size = listatracos.getSize();
        for (int i = 0; i < size; i++) {
            Puerto item = (Puerto)listatracos.getElementAt(i);
            
            if(item.getId()==puerto.getId())
            {
                JOptionPane.showMessageDialog(this, "Este elemento ya esta en la lista");
                return;
            }
        }
        listatracos.addElement(puerto);
        
    }//GEN-LAST:event_btnAgregarAtracoActionPerformed

    private void lstAtracosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAtracosMouseClicked
        int fila = lstAtracos.getSelectedIndex();
        if (fila >= 0) {
             DefaultListModel listatracos = (DefaultListModel) lstAtracos.getModel();
           listatracos.remove(fila);
        } 
    }//GEN-LAST:event_lstAtracosMouseClicked

    private void lstTripulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTripulacionMouseClicked
         int fila = lstTripulacion.getSelectedIndex();
        if (fila >= 0) {
             DefaultListModel lista = (DefaultListModel) lstTripulacion.getModel();
           lista.remove(fila);
        } 
    }//GEN-LAST:event_lstTripulacionMouseClicked

       private void SelectBarco(int id)
    {
        int size = cmbBarco.getItemCount();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbBarco.getModel();
        for (int i = 0; i < size; i++) {
            Barco item = (Barco)model.getElementAt(i);
            if(item.getId()==id)
            {
                model.setSelectedItem(item);
            }
        }
    }
       private void SelectOrigen(int id)
    {
        int size = cmbOrigen.getItemCount();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbOrigen.getModel();
        for (int i = 0; i < size; i++) {
            Puerto item = (Puerto)model.getElementAt(i);
            if(item.getId()==id)
            {
                model.setSelectedItem(item);
            }
        }
    }
       
          private void SelectDestino(int id)
    {
        int size = cmbDestino.getItemCount();
        DefaultComboBoxModel model = (DefaultComboBoxModel)cmbDestino.getModel();
        for (int i = 0; i < size; i++) {
            Puerto item = (Puerto)model.getElementAt(i);
            if(item.getId()==id)
            {
                model.setSelectedItem(item);
            }
        }
    }
       
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
            java.util.logging.Logger.getLogger(ViajesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViajesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViajesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViajesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViajesView().setVisible(true);
            }
        });
    }
    
    boolean tryParseInt(String value) {  
     try {  
         Integer.parseInt(value);  
         return true;  
      } catch (NumberFormatException e) {  
         return false;  
      }  
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarAtraco;
    private javax.swing.JButton btnAgregarTripulacion;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbAtraco;
    private javax.swing.JComboBox<String> cmbBarco;
    private javax.swing.JComboBox<String> cmbDestino;
    private javax.swing.JComboBox<String> cmbOrigen;
    private javax.swing.JComboBox<String> cmbTripulacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> lstAtracos;
    private javax.swing.JList<String> lstTripulacion;
    private javax.swing.JRadioButton rdbEnCurso;
    private javax.swing.JRadioButton rdbFinalizado;
    private javax.swing.JTable tblViajes;
    private javax.swing.JTextField txtEncomienda;
    // End of variables declaration//GEN-END:variables
}
