package Vista;

import DAO.DetalleSalidaDAO;
import DAO.SalidasDAO;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class InfoPerdida extends javax.swing.JFrame {

    private static InfoPerdida instance = new InfoPerdida();
    private SalidasDAO sDao = new SalidasDAO();
    private DetalleSalidaDAO dDao = new DetalleSalidaDAO();

    private InfoPerdida() {
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
            }

            @Override
            public void windowClosed(WindowEvent e) {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarE = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txfCodigoSalida = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Información de la pérdida:");

        btnEliminarE.setContentAreaFilled(false);
        btnEliminarE.setFocusPainted(false);
        btnEliminarE.setFocusable(false);
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("N°");

        txfCodigoSalida.setEditable(false);
        txfCodigoSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoSalidaKeyTyped(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel119.setText("Observaciones:");

        txaObservaciones.setEditable(false);
        txaObservaciones.setColumns(20);
        txaObservaciones.setRows(5);
        jScrollPane1.setViewportView(txaObservaciones);

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Común", "Nombre Científico", "Tamaño", "Rango", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSalidasMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaSalidasMouseReleased(evt);
            }
        });
        tablaSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaSalidasKeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(tablaSalidas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(810, 810, 810)
                        .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel119))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnEliminarE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addGap(28, 28, 28)
                .addComponent(jLabel119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed

    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void txfCodigoSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalidaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {
            evt.consume();
        }

        if (txfCodigoSalida.getText().length() >= 4) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoSalidaKeyTyped

    private void tablaSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseClicked

    }//GEN-LAST:event_tablaSalidasMouseClicked

    private void tablaSalidasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidasMouseReleased

    private void tablaSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidasKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTable tablaSalidas;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txfCodigoSalida;
    // End of variables declaration//GEN-END:variables

    public void buscarSalida() {
        try {
            String numero_orden = VistaSGI.numero_orden;
            String codigo_salida = VistaSGI.identificador;
            ResultSet rs = sDao.buscarSalidaPerdida(numero_orden, codigo_salida);

            if (rs.next()) {
                txfCodigoSalida.setText(rs.getString("numero_orden"));
                txaObservaciones.setText(rs.getString("observacion"));
            }

            mostrarProductos(codigo_salida);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrarProductos(String codigo) {

        try {

            DefaultTableModel modelo;
            modelo = dDao.buscarDetalleSalida(codigo);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaSalidas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            TableColumnModel column = tablaSalidas.getColumnModel();
//            column.getColumn(1).setPreferredWidth(150);
        } catch (Exception e) {

        }

    }

    public static InfoPerdida ObtenerInstancia() {
        if (instance == null) {
            instance = new InfoPerdida();
        }
        return instance;
    }
}
