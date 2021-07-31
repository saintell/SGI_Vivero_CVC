package Vista;

public class DescargarMenu extends javax.swing.JFrame {

    public DescargarMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEditarProveedor1 = new javax.swing.JButton();
        btnEditarProveedor2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("DESCARGAR ARCHIVO COMO:");

        btnEditarProveedor1.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnEditarProveedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/btnExcel1.png"))); // NOI18N
        btnEditarProveedor1.setText("Excel");
        btnEditarProveedor1.setBorderPainted(false);
        btnEditarProveedor1.setContentAreaFilled(false);
        btnEditarProveedor1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProveedor1.setFocusable(false);
        btnEditarProveedor1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarProveedor1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editarAzulOscuro.png"))); // NOI18N
        btnEditarProveedor1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editarAzulOscuro.png"))); // NOI18N
        btnEditarProveedor1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditarProveedor1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedor1ActionPerformed(evt);
            }
        });

        btnEditarProveedor2.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarProveedor2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnEditarProveedor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/btnPDF.png"))); // NOI18N
        btnEditarProveedor2.setText("PDF");
        btnEditarProveedor2.setBorderPainted(false);
        btnEditarProveedor2.setContentAreaFilled(false);
        btnEditarProveedor2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProveedor2.setFocusable(false);
        btnEditarProveedor2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditarProveedor2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editarAzulOscuro.png"))); // NOI18N
        btnEditarProveedor2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editarAzulOscuro.png"))); // NOI18N
        btnEditarProveedor2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditarProveedor2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditarProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedor2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEditarProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnEditarProveedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarProveedor1)
                    .addComponent(btnEditarProveedor2))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProveedor1ActionPerformed

    private void btnEditarProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarProveedor2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProveedor1;
    private javax.swing.JButton btnEditarProveedor2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
