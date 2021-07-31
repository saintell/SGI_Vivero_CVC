package Vista;

import DAO.DetalleIngresoDAO;
import DAO.DetalleSalidaDAO;
import DAO.EspeciesDAO;
import DAO.ReservasDAO;
import DAO.SalidasDAO;
import Modelo.DetalleSalida_;
import Modelo.Reserva_;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class SeleccionarEspecie extends javax.swing.JFrame implements FocusListener, WindowListener {

    private static SeleccionarEspecie instance = new SeleccionarEspecie();
    private SalidasDAO sDao = new SalidasDAO();
    private DetalleSalidaDAO dsDao = new DetalleSalidaDAO();
    private DetalleIngresoDAO dDao = new DetalleIngresoDAO();
    private EspeciesDAO eDao = new EspeciesDAO();
    private int cantidad = 0;
    private int pedido = 0;
    private String codigoIngreso = "";
    private ReservasDAO rDao = new ReservasDAO();
    private int cantidadDuplicada = 0;
    private int pedidasDuplicada = 0;
    private String identificador_salida = "";

    private SeleccionarEspecie() {
        initComponents();
        setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);
        addFocusListener(this);
        addWindowListener(this);
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
        setResizable(false);

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

            }
        ));
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
                .addGap(664, 664, 664)
                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel64))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txfBuscarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnEliminarE)
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel64)
                .addGap(4, 4, 4)
                .addComponent(txfBuscarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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


    }//GEN-LAST:event_tablaEspeciesMouseClicked

    private void tablaEspeciesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspeciesMouseReleased

        if (!tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {
            try {

                if (evt.getClickCount() == 1) {

                    pedido = 0;
                    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad:"));

                    //Agregue a la condicion !VistaSGI.PerdidaPanel.isShowing()
                    if (!VistaSGI.TrasplantadoPanel.isShowing() && !VistaSGI.Reservas.isShowing() && !VistaSGI.PerdidaPanel.isShowing()) {
                        pedido = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de especies solicitadas por el cliente:"));
                    }
                    codigoIngreso = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString();
                    String nombre_vulgar = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 1).toString();
                    String nombre_cientifico = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 2).toString();
                    String tamaño = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 3).toString();
                    String rango = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 4).toString();
                    identificador_salida = InfoSalida.codigo_salida;

                    if (cantidad < 1) {

                        JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");

                    } else if (InfoSalida.jPanel2.isShowing()) {

                        if (cantidad > Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 6).toString())) {
                            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al número de disponibles.");
                        } else {
                            agregarEspecieInfoSalida(identificador_salida, codigoIngreso, nombre_vulgar, nombre_cientifico, tamaño, rango, Integer.toString(pedido));

                        }

                    } else if (VistaSGI.Reservas.isShowing() && VistaSGI.Reservar.isShowing()) {

                        seleccionarEspecieReservas();

                    } else if (VistaSGI.Reservas.isShowing() && VistaSGI.ConsultarReserva.isShowing()) {

                        seleccionarEspecieConsultarReservas();

                    } else if (VistaSGI.Salidas.isShowing() && VistaSGI.EspeciesPanel.isShowing()) {

                        if (cantidad > Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 6).toString())) {

                            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al número de disponibles.");
                        }

                        if (pedido < 1) {
                            JOptionPane.showMessageDialog(null, "El número de especies pedidas debe ser mayor a cero.");
                        } else {
                            seleccionarEspecieSalidas(codigoIngreso, nombre_vulgar, nombre_cientifico, tamaño, rango, Integer.toString(cantidad), Integer.toString(pedido));
                            restar(codigoIngreso, cantidad);
                        }
                    } else if (VistaSGI.Salidas.isShowing() && VistaSGI.PerdidaPanel.isShowing()) {

                        if (cantidad > Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 6).toString())) {
                            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al número de disponibles.");
                        } else {
                            seleccionarEspeciePerdida(codigoIngreso, nombre_vulgar, nombre_cientifico, rango, tamaño, Integer.toString(cantidad));
                            restar(codigoIngreso, cantidad);
                        }
                    } else if (VistaSGI.Salidas.isShowing() && VistaSGI.TrasplantadoPanel.isShowing()) {

                        if (cantidad > Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 6).toString())) {
                            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al número de disponibles.");
                        } else {
                            seleccionarEspecieTrasplantado();
                        }
                    } else {

                        dispose();
                    }

                }
            } catch (NumberFormatException nfe) {
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
    public static javax.swing.JTable tablaEspecies;
    public static javax.swing.JTextField txfBuscarEsp;
    // End of variables declaration//GEN-END:variables

    public void limpiarTablaEspecies() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEspecies.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }

    public static String fechaActual() {
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }

    public void restar(String codigo, int cantidad) {

        if (dDao.restar(codigo, cantidad)) {

            buscarEspecie();

        } else {

            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, inténtelo de nuevo.");
        }

    }

    public void seleccionarEspecieReservas() {

        try {
            int codigo_reserva = Integer.parseInt(VistaSGI.lblNumeroReserva.getText());
            String id_cliente = VistaSGI.txfIdentificacionReservas.getText();
            int codigo_ingreso = Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString());
            String tamaño_bolsa = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 3).toString();
            String rango = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 4).toString();
            String fechaString = fechaActual();
            java.sql.Date fechaApertura = null;
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            fechaApertura = new java.sql.Date(sdf.parse(fechaString).getTime());
            Reserva_ r = new Reserva_(codigo_reserva, id_cliente, codigo_ingreso, tamaño_bolsa, rango, cantidad, fechaApertura, null);

            if (rDao.CrearReserva(r)) {

                if (rDao.reservar(codigo_ingreso, cantidad, tamaño_bolsa, rango)) {
                    mostrarEspeciesReservadas();
                    buscarEspecie();
                    limpiarEspecieReservas();
                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error. Verifique la información del cliente y que este esté registrado.");

                }
            } else {

                JOptionPane.showMessageDialog(null, "Hubo un error. Verifique la información del cliente y que este esté registrado.");

            }
        } catch (Exception ex) {
            Logger.getLogger(SeleccionarEspecie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seleccionarEspecieConsultarReservas() {

        try {
            int codigo_reserva = Integer.parseInt(VistaSGI.txfCodigoReserva.getText());
            String id_cliente = VistaSGI.txfIdentificacionConsultarReservas.getText();
            int codigo_ingreso = Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString());
            String tamaño_bolsa = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 3).toString();
            String rango = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 4).toString();
            String fechaString = fechaActual();
            java.sql.Date fechaApertura = null;
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            fechaApertura = new java.sql.Date(sdf.parse(fechaString).getTime());
            Reserva_ r = new Reserva_(codigo_reserva, id_cliente, codigo_ingreso, tamaño_bolsa, rango, cantidad, fechaApertura, null);

            if (rDao.CrearReserva(r)) {

                if (rDao.reservar(codigo_ingreso, cantidad, tamaño_bolsa, rango)) {
                    mostrarEspeciesConsultarReservadas();
                    buscarEspecie();
                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error. Verifique la información del cliente y que este esté registrado.");

                }
            } else {

                JOptionPane.showMessageDialog(null, "Hubo un error. Verifique la información del cliente y que este esté registrado.");

            }
        } catch (HeadlessException | NumberFormatException | ParseException ex) {
            Logger.getLogger(SeleccionarEspecie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seleccionarEspecieSalidas(String codigo, String nombre_vulgar, String nombre_cientifico, String tamaño, String rango, String cantidad_, String pedido) {

        try {
            String datos[] = {codigo, nombre_vulgar, nombre_cientifico, tamaño, rango, pedido, cantidad_};
            DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaSalidas.getModel();
            modelo.addRow(datos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void seleccionarEspecieInfoSalidas(String identificador, String codigo, String nombre_vulgar, String nombre_cientifico, String tamaño, String rango, String cantidad_, String pedido) {

        try {
            String datos[] = {identificador, codigo, nombre_vulgar, nombre_cientifico, tamaño, rango, pedido, cantidad_};
            DefaultTableModel modelo = (DefaultTableModel) InfoSalida.tablaSalidas.getModel();
            modelo.addRow(datos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void agregarEspecieInfoSalida(String identificador, String codigo_ingreso, String nombre_comun, String nombre_cientifico, String tamano, String rango, String pedido) {
        try {

            int identificador_salida = Integer.parseInt(identificador);
            DetalleSalida_ detalle;

//            if (buscarEnLaTabla(codigo_ingreso)) {
//
//                detalle = new DetalleSalida_(identificador_salida, codigo_ingreso, "", cantidad + cantidadDuplicada, Integer.parseInt(pedido) + pedidasDuplicada);
//
//            } else {

                detalle = new DetalleSalida_(identificador_salida, codigo_ingreso, "", cantidad, Integer.parseInt(pedido));
//            }

            if (dsDao.CrearDetalleSalida(detalle)) {
                seleccionarEspecieInfoSalidas(identificador, codigo_ingreso, nombre_comun, nombre_cientifico, tamano, rango, pedido, Integer.toString(cantidad));
                restar(codigo_ingreso, cantidad);
                System.out.println(cantidad);
                limpiarTablaInventario();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error.");
            }

        } catch (NumberFormatException numberF) {
//            JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad pedida");
            System.out.println(numberF.getMessage());
        }

    }

    public void limpiarTablaInventario() {
        DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaInventario.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public boolean buscarEnLaTabla(String codigo) {

        JTable tablaSalidas = InfoSalida.tablaSalidas;

        int filas = tablaSalidas.getRowCount();

        for (int i = 0; i < filas; i++) {

            if (tablaSalidas.getValueAt(i, 1).toString().equalsIgnoreCase(codigo)) {

                cantidadDuplicada = Integer.parseInt(tablaSalidas.getValueAt(i, 7).toString());
                pedidasDuplicada = Integer.parseInt(tablaSalidas.getValueAt(i, 6).toString());

                if (dDao.eliminar(tablaSalidas.getValueAt(i, 1).toString(), tablaSalidas.getValueAt(i, 0).toString(), cantidadDuplicada)) {
                    if (dDao.sumar(tablaSalidas.getValueAt(i, 1).toString(), cantidadDuplicada)) {

                        reiniciar();
                        limpiarTablaInventario();
                    } else {

                        JOptionPane.showMessageDialog(null, "Hubo un error.");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error. No, aqui!!");

                }

                return true;
            }
        }
        return false;
    }

    public void seleccionarEspeciePerdida(String codigo, String nombre_vulgar, String nombre_cientifico, String rango, String tamaño, String cantidad_) {

        String datos[] = {codigo, nombre_vulgar, nombre_cientifico, rango, tamaño, "-", cantidad_};
        DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaSalidas.getModel();
        modelo.addRow(datos);
    }

    public void seleccionarEspecieTrasplantado() {

        if (VistaSGI.txfCantidadTrasplantado.getText().length() == 0) {

            String especie = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 1).toString();
            String tamaño = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 3).toString();
            String rango = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 4).toString();
            VistaSGI.txfEspecieTrasplantado.setText(especie + ", " + tamaño + ", " + "(" + rango + ")");
            VistaSGI.txfEspecieTrasplantado.setEditable(false);

            VistaSGI.txfCantidadTrasplantado.setText(Integer.toString(cantidad));
            VistaSGI.txfCantidadTrasplantado.setEditable(false);
            VistaSGI.codigo_Ingreso = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString();
            VistaSGI.codigo_Especie = Integer.parseInt(tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 6).toString());
            VistaSGI.tamañoTrasplantado = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 3).toString();
            VistaSGI.rangoTrasplantado = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 4).toString();

            restar(codigoIngreso, cantidad);
            dispose();

        } else {

            JOptionPane.showMessageDialog(null, "Registre o cancele el trasplantado anterior, antes de realizar otro por favor.");
            dispose();
        }

    }

    public void buscarEspecie() {

        try {

            DefaultTableModel modelo;
            TableColumnModel column = tablaEspecies.getColumnModel();
            String busca = txfBuscarEsp.getText();
            modelo = eDao.listarEspRes(busca);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaEspecies.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            tablaEspecies.getColumnModel().getColumn(1).setCellRenderer(tcr);
            column.getColumn(0).setPreferredWidth(150);
            column.getColumn(1).setPreferredWidth(200);
            column.getColumn(2).setPreferredWidth(200);
            column.getColumn(3).setPreferredWidth(100);
            column.getColumn(7).setPreferredWidth(100);

        } catch (IllegalArgumentException a) {
        }
    }

    public void limpiarEspecieReservas() {

        VistaSGI.txfCodigoPlantaReservas.setText(null);
        VistaSGI.txfEspecieReservas.setText(null);
        VistaSGI.txfCantidadReservas.setText(null);
        VistaSGI.lblDisponibles.setText(null);

    }

    public void mostrarEspeciesReservadas() {

        try {

            DefaultTableModel modelo;
            String codigo_reserva = VistaSGI.lblNumeroReserva.getText();
            modelo = rDao.mostrarReservadas(codigo_reserva);
            TableColumnModel column = VistaSGI.tablaReservas.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            VistaSGI.tablaReservas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            column.getColumn(1).setPreferredWidth(200);

        } catch (Exception e) {

        }

    }

    public void mostrarEspeciesConsultarReservadas() {

        try {

            DefaultTableModel modelo;
            String codigo_reserva = VistaSGI.txfCodigoReserva.getText();
            modelo = rDao.mostrarReservadas(codigo_reserva);
            TableColumnModel column = VistaSGI.tablaConsultarReservas.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            VistaSGI.tablaConsultarReservas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            column.getColumn(1).setPreferredWidth(200);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void reiniciar() {

        txfBuscarEsp.setText(null);
        limpiarTablaEspecies();

    }

    public static SeleccionarEspecie ObtenerInstancia() {
        if (instance == null) {
            instance = new SeleccionarEspecie();
        }
        return instance;
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {

        dispose();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
        dispose();
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        dispose();
    }

}
