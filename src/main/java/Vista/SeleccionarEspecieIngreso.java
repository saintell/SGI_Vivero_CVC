package Vista;

import DAO.EspeciesDAO;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class SeleccionarEspecieIngreso extends javax.swing.JFrame {

    private static SeleccionarEspecieIngreso instance = new SeleccionarEspecieIngreso();
    private EspeciesDAO eDao = new EspeciesDAO();

    private SeleccionarEspecieIngreso() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarE = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        txfBuscarEsp = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEspecies = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("BUSQUE Y SELECCIONE LA ESPECIE:");

        btnEliminarE.setContentAreaFilled(false);
        btnEliminarE.setFocusPainted(false);
        btnEliminarE.setFocusable(false);
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(102, 102, 102));
        jLabel64.setText("Buscar:");

        txfBuscarEsp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txfBuscarEsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarEsp.setToolTipText("");
        txfBuscarEsp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txfBuscarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarEspActionPerformed(evt);
            }
        });
        txfBuscarEsp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarEspKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarEspKeyTyped(evt);
            }
        });

        tablaEspecies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Vulgar", "Nombre Científico", "Familia", "Msnm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEspecies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEspeciesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaEspeciesMouseReleased(evt);
            }
        });
        tablaEspecies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaEspeciesKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tablaEspecies);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(txfBuscarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 644, Short.MAX_VALUE)
                        .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(213, 213, 213))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminarE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel64)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBuscarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void txfBuscarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarEspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarEspActionPerformed

    private void txfBuscarEspKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarEspKeyReleased

        if (txfBuscarEsp.getText().length() == 0) {

            limpiarTablaEspecies();

        } else {

            buscarEspecie();
        }
    }//GEN-LAST:event_txfBuscarEspKeyReleased

    private void txfBuscarEspKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarEspKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }


    }//GEN-LAST:event_txfBuscarEspKeyTyped

    private void tablaEspeciesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspeciesMouseClicked

        if (tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1) {

                int resultado = JOptionPane.showConfirmDialog(null, "¿Seleccionar especie?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {

                    seleccionarEspecie();
                    consultarEspecie();

                } else {

                }

            }
        }
    }//GEN-LAST:event_tablaEspeciesMouseClicked

    private void tablaEspeciesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspeciesMouseReleased

        if (tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1) {

                int resultado = JOptionPane.showConfirmDialog(null, "¿Seleccionar especie?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {

                    seleccionarEspecie();
                    consultarEspecie();

                } else {

                }

            }
        }
    }//GEN-LAST:event_tablaEspeciesMouseReleased

    private void tablaEspeciesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaEspeciesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaEspeciesKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tablaEspecies;
    private javax.swing.JTextField txfBuscarEsp;
    // End of variables declaration//GEN-END:variables

    public void limpiarTablaEspecies() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEspecies.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void seleccionarEspecie() {

        String nombre_vulgar = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 1).toString();
        VistaSGI.txfEspecie.setText(nombre_vulgar);
        VistaSGI.codigo_Especie = Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString());
        dispose();

    }

    public void buscarEspecie() {

        try {

            DefaultTableModel modelo;
            TableColumnModel column = tablaEspecies.getColumnModel();
            modelo = eDao.listar(txfBuscarEsp.getText());
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaEspecies.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            tablaEspecies.getColumnModel().getColumn(1).setCellRenderer(tcr);
            column.getColumn(1).setPreferredWidth(200);
            column.getColumn(2).setPreferredWidth(200);
            column.getColumn(3).setPreferredWidth(150);

        } catch (IllegalArgumentException a) {
        }
    }

    public static SeleccionarEspecieIngreso ObtenerInstancia() {
        if (instance == null) {
            instance = new SeleccionarEspecieIngreso();
        }
        return instance;
    }

    public void consultarEspecie() {

        try {

            String tamano_bolsa = VistaSGI.tamanoCombo.getSelectedItem().toString();
            String rango = VistaSGI.rangoCombo.getSelectedItem().toString();
            int codigo = Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString());
            ResultSet rs;
            rs = eDao.buscarIngresoPlanta(codigo, tamano_bolsa, rango);

            if (!rs.next()) {

                if (VistaSGI.txfCodigoEspecie.isEnabled() == false) {
                    VistaSGI.txfCodigoEspecie.setText(null);
                    VistaSGI.txfCodigoEspecie.setEnabled(true);
                } else {
                    VistaSGI.txfCodigoEspecie.setEnabled(true);
                }

            } else {

                VistaSGI.txfCodigoEspecie.setText(rs.getString("codigo_ingreso"));
                VistaSGI.txfCodigoEspecie.setEnabled(false);

            }

        } catch (Exception e) {
        }

    }

}
