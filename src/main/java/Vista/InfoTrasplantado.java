package Vista;

import DAO.DetalleSalidaDAO;
import DAO.SalidasDAO;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public final class InfoTrasplantado extends javax.swing.JFrame {

    private static InfoTrasplantado instance = new InfoTrasplantado();
    private SalidasDAO sDao = new SalidasDAO();
    private DetalleSalidaDAO dDao = new DetalleSalidaDAO();

    private InfoTrasplantado() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);
        
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                buscarSalida();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                reiniciar();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                reiniciar();
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                buscarSalida();
            }

            @Override
            public void windowActivated(WindowEvent e) {
                buscarSalida();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txfEspecie = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        txfBolsaRangoOrigen = new javax.swing.JTextField();
        txfCodigoSalida = new javax.swing.JTextField();
        jLabel115 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JTextField();
        txfBolsaRangoDestino = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txfEspecie.setEditable(false);
        txfEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspecie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel116.setText("Bolsa y rango destino:");

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel114.setText("Especie:");

        txfBolsaRangoOrigen.setEditable(false);
        txfBolsaRangoOrigen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBolsaRangoOrigen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBolsaRangoOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBolsaRangoOrigenActionPerformed(evt);
            }
        });
        txfBolsaRangoOrigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBolsaRangoOrigenKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBolsaRangoOrigenKeyTyped(evt);
            }
        });

        txfCodigoSalida.setEditable(false);
        txfCodigoSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoSalidaKeyTyped(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel115.setText("Bolsa y rango origen:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("N°");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Información del trasplantado:");

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel138.setText("Cantidad trasplantadas:");

        txfCantidad.setEditable(false);
        txfCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txfCantidadMouseEntered(evt);
            }
        });
        txfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadActionPerformed(evt);
            }
        });
        txfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadKeyTyped(evt);
            }
        });

        txfBolsaRangoDestino.setEditable(false);
        txfBolsaRangoDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBolsaRangoDestino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBolsaRangoDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBolsaRangoDestinoActionPerformed(evt);
            }
        });
        txfBolsaRangoDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBolsaRangoDestinoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBolsaRangoDestinoKeyTyped(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intercambio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfBolsaRangoOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(jLabel114)
                            .addComponent(jLabel115)
                            .addComponent(txfEspecie))
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel116)
                            .addComponent(jLabel138)
                            .addComponent(txfBolsaRangoDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txfCantidad))))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfBolsaRangoDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel114)
                                        .addGap(5, 5, 5)
                                        .addComponent(txfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel138)
                                        .addGap(5, 5, 5)
                                        .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(jLabel1)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel115)
                        .addGap(5, 5, 5)
                        .addComponent(txfBolsaRangoOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfCodigoSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalidaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {
            evt.consume();
        }

        if (txfCodigoSalida.getText().length() >= 4) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoSalidaKeyTyped

    private void txfEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEspecieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieActionPerformed

    private void txfEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieKeyReleased

    private void txfEspecieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieKeyTyped

    private void txfCantidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCantidadMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadMouseEntered

    private void txfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadActionPerformed

    private void txfCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadKeyReleased

    private void txfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadKeyTyped

    private void txfBolsaRangoOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBolsaRangoOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaRangoOrigenActionPerformed

    private void txfBolsaRangoOrigenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBolsaRangoOrigenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaRangoOrigenKeyReleased

    private void txfBolsaRangoOrigenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBolsaRangoOrigenKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaRangoOrigenKeyTyped

    private void txfBolsaRangoDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBolsaRangoDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaRangoDestinoActionPerformed

    private void txfBolsaRangoDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBolsaRangoDestinoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaRangoDestinoKeyReleased

    private void txfBolsaRangoDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBolsaRangoDestinoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBolsaRangoDestinoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txfBolsaRangoDestino;
    private javax.swing.JTextField txfBolsaRangoOrigen;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextField txfCodigoSalida;
    private javax.swing.JTextField txfEspecie;
    // End of variables declaration//GEN-END:variables

     public void buscarSalida() {
        try {
            String codigo = VistaSGI.identificador;
            ResultSet rs = dDao.buscarDetalleTrasplantado(codigo);

            if (rs.next()) {
                txfCodigoSalida.setText(rs.getString("numero_orden"));
                txfEspecie.setText(rs.getString("nombre_vulgar"));
                txfCantidad.setText(rs.getString("cantidad"));
                txfBolsaRangoOrigen.setText(rs.getString("tamaño_bolsa") + ", " + rs.getString("rango"));
                txfBolsaRangoDestino.setText(rs.getString("tamaño_destino"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    public void reiniciar() {
        txfCodigoSalida.setText(null);
        txfEspecie.setText(null);
        txfCantidad.setText(null);
        txfBolsaRangoOrigen.setText(null);
        txfBolsaRangoDestino.setText(null);
    }

    public static InfoTrasplantado ObtenerInstancia() {
        if (instance == null) {
            instance = new InfoTrasplantado();
        }
        return instance;
    }
}
