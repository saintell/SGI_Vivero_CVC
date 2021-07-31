package Vista;

import DAO.ReservasDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class CodigosReservas extends javax.swing.JFrame {

    private static CodigosReservas instance = new CodigosReservas();
    private ReservasDAO rDao = new ReservasDAO();

    private CodigosReservas() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCodigosReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaCodigosReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Reserva", "NIT", "Fecha Apertura"
            }
        ));
        tablaCodigosReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCodigosReservasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCodigosReservas);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("SELECCIONE UN CÓDIGO DE RESERVA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

        dispose();

    }//GEN-LAST:event_formWindowLostFocus

    private void tablaCodigosReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCodigosReservasMouseClicked

        try {

            if (evt.getClickCount() == 1) {

                String codigo = tablaCodigosReservas.getValueAt(tablaCodigosReservas.getSelectedRow(), 0).toString();
                ResultSet rs;
                rs = rDao.buscarReserva(codigo);

                if (rs.next()) {

                    VistaSGI.txfCodigoReserva.setText(rs.getString(1));
                    VistaSGI.txfIdentificacionConsultarReservas.setText(rs.getString(2));
                    VistaSGI.txfNombreConsultarReservas.setText(rs.getString(3));
                    VistaSGI.txfTelefonoConsultarReservas.setText(rs.getString(4));
                    mostrarEspeciesReservadas();
                    dispose();

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_tablaCodigosReservasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaCodigosReservas;
    // End of variables declaration//GEN-END:variables

    public void mostrarEspeciesReservadas() {

        try {

            DefaultTableModel modelo;
            String codigo_reserva = tablaCodigosReservas.getValueAt(tablaCodigosReservas.getSelectedRow(), 0).toString();
            modelo = rDao.mostrarReservadas(codigo_reserva);
            TableColumnModel column = VistaSGI.tablaConsultarReservas.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            VistaSGI.tablaConsultarReservas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            column.getColumn(1).setPreferredWidth(200);

        } catch (Exception e) {

        }

    }

    public static CodigosReservas ObtenerInstancia() {
        if (instance == null) {
            instance = new CodigosReservas();
        }
        return instance;
    }

}
