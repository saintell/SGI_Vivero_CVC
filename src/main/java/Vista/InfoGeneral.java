package Vista;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public final class InfoGeneral extends javax.swing.JFrame {

    private static InfoGeneral instance = new InfoGeneral();

    private InfoGeneral() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);
        txaObservaciones.setLineWrap(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarE = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboCarguista = new javax.swing.JComboBox<>();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Información general:");

        btnEliminarE.setContentAreaFilled(false);
        btnEliminarE.setFocusPainted(false);
        btnEliminarE.setFocusable(false);
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setText("Observaciones generales:");

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

        comboCarguista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCarguista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Contratistas", "Personal de nómina", "Cliente" }));
        comboCarguista.setRequestFocusEnabled(true);
        comboCarguista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCarguistaItemStateChanged(evt);
            }
        });
        comboCarguista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboCarguistaFocusGained(evt);
            }
        });
        comboCarguista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCarguistaActionPerformed(evt);
            }
        });
        comboCarguista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboCarguistaKeyReleased(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel112.setText("Carguista:");

        txaObservaciones.setColumns(20);
        txaObservaciones.setRows(5);
        txaObservaciones.setWrapStyleWord(true);
        txaObservaciones.setNextFocusableComponent(comboCarguista);
        txaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaObservacionesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaObservaciones);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel112)
                            .addComponent(comboCarguista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(btnEliminarE)
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jLabel112)
                .addGap(2, 2, 2)
                .addComponent(comboCarguista, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
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

    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        VistaSGI.observacion = " ";
        VistaSGI.carguista = " ";
        comboCarguista.setSelectedItem(0);
        txaObservaciones.setText(null);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        procederRegistro();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void comboCarguistaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCarguistaItemStateChanged

    }//GEN-LAST:event_comboCarguistaItemStateChanged

    private void comboCarguistaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboCarguistaFocusGained

    }//GEN-LAST:event_comboCarguistaFocusGained

    private void comboCarguistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCarguistaActionPerformed

    }//GEN-LAST:event_comboCarguistaActionPerformed

    private void comboCarguistaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboCarguistaKeyReleased

    }//GEN-LAST:event_comboCarguistaKeyReleased

    private void txaObservacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionesKeyTyped

        if (txaObservaciones.getText().trim().length() > 179) {
            evt.consume();
        }
    }//GEN-LAST:event_txaObservacionesKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnRegistrar;
    public static javax.swing.JComboBox<String> comboCarguista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaObservaciones;
    // End of variables declaration//GEN-END:variables

    public void procederRegistro() {
        try {
            if (comboCarguista.getSelectedIndex() == 0) {

                VistaSGI.carguista = " ";

            } else {

                VistaSGI.carguista = comboCarguista.getSelectedItem().toString();
            }
            VistaSGI.observacion = txaObservaciones.getText().trim();
            comboCarguista.setSelectedItem(0);
            txaObservaciones.setText(null);
            JOptionPane.showMessageDialog(null, "Proceda a realizar el registro.");
            dispose();
        } catch (NullPointerException npe) {
            VistaSGI.carguista = " ";
            VistaSGI.observacion = " ";
        }
    }

    public static InfoGeneral ObtenerInstancia() {
        if (instance == null) {
            instance = new InfoGeneral();
        }
        return instance;
    }
}
