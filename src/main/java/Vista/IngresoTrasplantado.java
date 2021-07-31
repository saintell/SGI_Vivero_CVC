package Vista;

import DAO.DetalleIngresoDAO;
import DAO.EspeciesDAO;
import DAO.IngresoDAO;
import Modelo.DetalleIngreso_;
import Modelo.Ingreso_;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class IngresoTrasplantado extends javax.swing.JFrame {

    private DetalleIngresoDAO dDao = new DetalleIngresoDAO();
    private EspeciesDAO eDao = new EspeciesDAO();
    private IngresoDAO iDao = new IngresoDAO();

    private static IngresoTrasplantado instance = new IngresoTrasplantado();

    private IngresoTrasplantado() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                obtenerInfo();
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                obtenerInfo();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                obtenerInfo();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarE = new javax.swing.JButton();
        txfEspecie = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txfBolsa = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txfRango = new javax.swing.JTextField();
        txfCodigo = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Ingresar especie");

        btnEliminarE.setContentAreaFilled(false);
        btnEliminarE.setFocusPainted(false);
        btnEliminarE.setFocusable(false);
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        txfEspecie.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfEspecie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspecie.setToolTipText("");
        txfEspecie.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txfEspecie.setEnabled(false);
        txfEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEspecieActionPerformed(evt);
            }
        });
        txfEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspecieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfEspecieKeyTyped(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Especie:");

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setText("Tamaño de bolsa:");

        txfBolsa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfBolsa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBolsa.setToolTipText("");
        txfBolsa.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txfBolsa.setEnabled(false);
        txfBolsa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBolsaActionPerformed(evt);
            }
        });
        txfBolsa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBolsaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBolsaKeyTyped(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setText("Rango:");

        txfRango.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfRango.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfRango.setToolTipText("");
        txfRango.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txfRango.setEnabled(false);
        txfRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfRangoActionPerformed(evt);
            }
        });
        txfRango.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfRangoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfRangoKeyTyped(evt);
            }
        });

        txfCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigo.setToolTipText("");
        txfCodigo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoActionPerformed(evt);
            }
        });
        txfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCodigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoKeyTyped(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setText("Código:");

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setFocusable(false);
        btnRegistrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojo.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusable(false);
        btnCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel68))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel65)
                                    .addComponent(txfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txfBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel66))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txfRango, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel67)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(92, 92, 92)
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 387, Short.MAX_VALUE)
                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnEliminarE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBolsa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(txfRango, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void txfEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEspecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieActionPerformed

    private void txfEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieKeyReleased

    }//GEN-LAST:event_txfEspecieKeyReleased

    private void txfEspecieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieKeyTyped


    }//GEN-LAST:event_txfEspecieKeyTyped

    private void txfBolsaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBolsaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaActionPerformed

    private void txfBolsaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBolsaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaKeyReleased

    private void txfBolsaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBolsaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaKeyTyped

    private void txfRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRangoActionPerformed

    private void txfRangoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRangoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRangoKeyReleased

    private void txfRangoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfRangoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRangoKeyTyped

    private void txfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoActionPerformed

        registrarPlantaTrasplantado();
    }//GEN-LAST:event_txfCodigoActionPerformed

    private void txfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoKeyReleased

    private void txfCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();
        }
        
        if (Character.isSpaceChar(c)) {
           
           evt.consume();
       }

        if (txfCodigo.getText().length() >= 6) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        registrarPlantaTrasplantado();

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        txfCodigo.setText(null);
        txfEspecie.setText(null);
        txfBolsa.setText(null);
        txfRango.setText(null);
        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txfBolsa;
    private javax.swing.JTextField txfCodigo;
    private javax.swing.JTextField txfEspecie;
    private javax.swing.JTextField txfRango;
    // End of variables declaration//GEN-END:variables

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    public void registrarPlantaTrasplantado() {

        try {

            String codigo = txfCodigo.getText().trim();
            ResultSet rs = iDao.buscar(codigo);

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "El código de ingreso ya existe, ingrese uno nuevo por favor.");
            } else {

                String bolsa = VistaSGI.tamanoComboTrasplantado.getSelectedItem().toString();
                String rango = VistaSGI.rangoComboTrasplantado.getSelectedItem().toString();
                java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

                Ingreso_ ingreso = new Ingreso_(codigo, VistaSGI.codigo_Especie, bolsa, rango, 0, 0);

                if (iDao.CrearIngreso(ingreso)) {

                    DetalleIngreso_ detalle = new DetalleIngreso_(VistaSGI.codigo_Especie, 0, sqlDate, codigo);

                    if (dDao.CrearDetalle(detalle)) {

                        JOptionPane.showMessageDialog(null, "Especie ingresada correctamente, proceda a realizar el trasplantado.");
                        txfCodigo.setText(null);
                        txfEspecie.setText(null);
                        txfBolsa.setText(null);
                        txfRango.setText(null);
                        VistaSGI.codigo_ingresoTrasplantar = txfCodigo.getText().trim();
                        limpiarIngresoEspecie();
                        dispose();
                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Se ha producido un error, verifique su información.");
                    txfCodigo.setText(null);
                    txfEspecie.setText(null);
                    txfBolsa.setText(null);
                    txfRango.setText(null);
                    dispose();
                }
            }
        } catch (NullPointerException npe) {
        } catch (SQLException ex) {
        }
    }

    public void limpiarIngresoEspecie() {

        try {
            VistaSGI.txfCodigoEspecie.setEnabled(true);
            VistaSGI.txfCodigoEspecie.setText("");
            VistaSGI.txfEspecie.setText("");
            VistaSGI.tamanoCombo.setSelectedIndex(0);
            VistaSGI.rangoCombo.setSelectedIndex(0);
            VistaSGI.txfCantidadIngresarEspecie.setText("");
            VistaSGI.txfBuscarEspecie.setText("");
            java.util.Date fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
            VistaSGI.fechaIngreso.setDate(fechaParseada);
            VistaSGI.fechaDesde.setDate(fechaParseada);
            VistaSGI.fechaHasta.setDate(fechaParseada);
            buscarIngresosFecha(fechaActual(), fechaActual());

        } catch (ParseException ex) {

        }
    }

    public void buscarIngresosFecha(String fechaInicio, String fechaFin) {

        try {

            DefaultTableModel modelo;
            modelo = dDao.listarEspeciesFecha(fechaInicio, fechaFin);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            VistaSGI.tablaAlimentarInventario.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            VistaSGI.tablaAlimentarInventario.getColumnModel().getColumn(1).setCellRenderer(tcr);

        } catch (IllegalArgumentException a) {
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage());
        }

    }

    public static IngresoTrasplantado ObtenerInstancia() {
        if (instance == null) {
            instance = new IngresoTrasplantado();
        }
        return instance;
    }

    public void obtenerInfo() {

        try {
            ResultSet rs = eDao.buscarEspecie(Integer.toString(VistaSGI.codigo_Especie));
            if (rs.next()) {
                txfEspecie.setText(rs.getString("nombre_vulgar"));
                txfBolsa.setText(VistaSGI.tamanoComboTrasplantado.getSelectedItem().toString());
                txfRango.setText(VistaSGI.rangoComboTrasplantado.getSelectedItem().toString());

            } else {
                JOptionPane.showMessageDialog(null, "Se ha producido un error.");
            }
        } catch (NullPointerException npe) {
        } catch (SQLException ex) {
        }
    }
}
