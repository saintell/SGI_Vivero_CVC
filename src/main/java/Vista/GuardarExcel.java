package Vista;

import Reportes.GenerarExcel;
import static Vista.VistaSGI.parent;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class GuardarExcel extends javax.swing.JFrame {

    private static GuardarExcel instance = new GuardarExcel();
    private GenerarExcel generar = new GenerarExcel();

    private GuardarExcel() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);

        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                if (VistaSGI.Inventario.isShowing()) {
                    TipoCombo.setEnabled(true);
                } else {
                    TipoCombo.setEnabled(false);
                }
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarE = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        txfRuta = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        TipoCombo = new javax.swing.JComboBox<>();
        btnExaminar = new javax.swing.JButton();
        btnGuardarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SELECCIONE LA RUTA PARA GUARDAR EL EXCEL:");

        btnEliminarE.setContentAreaFilled(false);
        btnEliminarE.setFocusPainted(false);
        btnEliminarE.setFocusable(false);
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setText("Tipo de reporte:");

        txfRuta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfRuta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfRuta.setToolTipText("");
        txfRuta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txfRuta.setEnabled(false);
        txfRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfRutaActionPerformed(evt);
            }
        });
        txfRuta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfRutaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfRutaKeyTyped(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Ruta:");

        TipoCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TipoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción...", "Plantas disponibles", "Todas las plantas" }));
        TipoCombo.setFocusable(false);
        TipoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoComboItemStateChanged(evt);
            }
        });
        TipoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoComboActionPerformed(evt);
            }
        });

        btnExaminar.setText("Examinar");
        btnExaminar.setFocusable(false);
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });

        btnGuardarExcel.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarExcel.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardarExcel.setBorderPainted(false);
        btnGuardarExcel.setContentAreaFilled(false);
        btnGuardarExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarExcel.setFocusable(false);
        btnGuardarExcel.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarExcel.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel64)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TipoCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 274, Short.MAX_VALUE)
                                    .addComponent(txfRuta, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExaminar)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btnGuardarExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel64)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel65)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExaminar))
                .addGap(18, 18, 18)
                .addComponent(btnGuardarExcel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void txfRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfRutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRutaActionPerformed

    private void txfRutaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRutaKeyReleased

    }//GEN-LAST:event_txfRutaKeyReleased

    private void txfRutaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRutaKeyTyped


    }//GEN-LAST:event_txfRutaKeyTyped

    private void TipoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoComboItemStateChanged
    }//GEN-LAST:event_TipoComboItemStateChanged

    private void TipoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoComboActionPerformed

    private void btnGuardarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarExcelActionPerformed

        if (VistaSGI.Inventario.isShowing()) {
            guardarExcelInventario();
        } else {
            guardarExcelSalida();
        }

    }//GEN-LAST:event_btnGuardarExcelActionPerformed

    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed

        try {
            JFileChooser guardar = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
            guardar.setFileFilter(filtro);
            guardar.showSaveDialog(parent);
            guardar.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            String nombre = guardar.getSelectedFile().getName();

            if (!nombre.contains(".xlsx") || !nombre.contains(".xls")) {

                txfRuta.setText(guardar.getSelectedFile().getAbsolutePath() + ".xlsx");

            } else {

                txfRuta.setText(guardar.getSelectedFile().getAbsolutePath());
            }
        } catch (NullPointerException npe) {

        }
    }//GEN-LAST:event_btnExaminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> TipoCombo;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardarExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txfRuta;
    // End of variables declaration//GEN-END:variables

    public void guardarExcelInventario() {

        try {

            if (txfRuta.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Elija una ruta primero. Presione el botón 'Examinar'");
            } else {

                String tipo = TipoCombo.getSelectedItem().toString();

                switch (tipo) {
                    case "Seleccione una opción...":
                        JOptionPane.showMessageDialog(null, "Seleccione un tipo de reporte, por favor.");
                        break;
                    case "Plantas disponibles":
                        generar.crearExcelDisponibles(txfRuta.getText());
                        JOptionPane.showMessageDialog(null, "El archivo se ha guardado y se abrirá en breve...");
                        txfRuta.setText(null);
                        TipoCombo.setSelectedIndex(0);
                        dispose();
                        break;
                    case "Todas las plantas":
                        generar.crearExcelTodas(txfRuta.getText());
                        JOptionPane.showMessageDialog(null, "El archivo se ha guardado y se abrirá en breve...");
                        txfRuta.setText(null);
                        TipoCombo.setSelectedIndex(0);
                        dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Seleccione un tipo de reporte, por favor.");
                        break;
                }

            }
        } catch (SQLException ex) {
        }
    }

    public void guardarExcelSalida() {

        try {

            if (txfRuta.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Seleccione una ruta dando click en el botón 'Examinar'.");
            } else {

                Calendar fecha1 = VistaSGI.fechaDesdeSalida.getCalendar();
                Calendar fecha2 = VistaSGI.fechaHastaSalida.getCalendar();
                String fechaInicio = Integer.toString(fecha1.get(Calendar.YEAR)) + "-" + Integer.toString(fecha1.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha1.get(Calendar.DAY_OF_MONTH));
                String fechaFin = Integer.toString(fecha2.get(Calendar.YEAR)) + "-" + Integer.toString(fecha2.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha2.get(Calendar.DAY_OF_MONTH));
                generar.fechaInicio = Integer.toString(fecha1.get(Calendar.DAY_OF_MONTH)) + "-" + Integer.toString(fecha1.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha1.get(Calendar.YEAR));
                generar.fechaFin = Integer.toString(fecha2.get(Calendar.DAY_OF_MONTH)) + "-" + Integer.toString(fecha2.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha2.get(Calendar.YEAR));
                String motivo = VistaSGI.motivoComboConsultarSalida.getSelectedItem().toString();
                String numero_orden = null;

                if (motivo.equalsIgnoreCase("Sin motivo")) {

                    motivo = "";
                }

                if (VistaSGI.tablaConsultarSalidas.getRowCount() == 0) {

                    JOptionPane.showMessageDialog(null, "No hay ninguna salida para mostrar, por favor busque alguna salida.");

                } else if (VistaSGI.tablaConsultarSalidas.getSelectedRow() == -1 && VistaSGI.txfBuscarConsultarSalida.getText().length() == 0) {

                    generar.crearExcelSalidas(txfRuta.getText(), motivo, fechaInicio, fechaFin);
                    JOptionPane.showMessageDialog(null, "El archivo se ha guardado y se abrirá en breve...");
                    txfRuta.setText(null);
                    dispose();

                } else if (VistaSGI.tablaConsultarSalidas.getSelectedRow() == -1 && VistaSGI.txfBuscarConsultarSalida.getText().length() != 0) {
                    numero_orden = VistaSGI.tablaConsultarSalidas.getValueAt(0, 1).toString();
                    generar.crearExcelSalidasDetallado(txfRuta.getText(), motivo, fechaInicio, fechaFin, numero_orden);
                    JOptionPane.showMessageDialog(null, "El archivo se ha guardado y se abrirá en breve...");
                    txfRuta.setText(null);
                    dispose();

                } else if (VistaSGI.tablaConsultarSalidas.getSelectedRow() != -1) {

                    numero_orden = VistaSGI.tablaConsultarSalidas.getValueAt(VistaSGI.tablaConsultarSalidas.getSelectedRow(), 1).toString();
                    generar.crearExcelSalidasEspecifico(txfRuta.getText(), numero_orden);
                    JOptionPane.showMessageDialog(null, "El archivo se ha guardado y se abrirá en breve...");
                    txfRuta.setText(null);
                    dispose();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuardarExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static GuardarExcel ObtenerInstancia() {
        if (instance == null) {
            instance = new GuardarExcel();
        }
        return instance;
    }
}
