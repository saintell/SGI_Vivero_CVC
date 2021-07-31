package Vista;

import DAO.DetalleIngresoDAO;
import DAO.DetalleSalidaDAO;
import DAO.EspeciesDAO;
import DAO.SalidasDAO;
import Modelo.DetalleSalida_;
import static Vista.VistaSGI.txfStockSalidas;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public final class InfoSalida extends javax.swing.JFrame {

    private static InfoSalida instance = new InfoSalida();
    private SeleccionarEspecie ventanaEspeciesSalidas = SeleccionarEspecie.ObtenerInstancia();
    private SalidasDAO sDao = new SalidasDAO();
    private DetalleSalidaDAO dsDao = new DetalleSalidaDAO();
    private DetalleIngresoDAO dDao = new DetalleIngresoDAO();
    private EspeciesDAO eDao = new EspeciesDAO();
    private ResultSet rs;
    private String nombre_comun = "";
    private String nombre_cientifico = "";
    private String tamano = "";
    private String rango = "";
    private int cantidadDuplicada = 0;
    private int pedidasDuplicada = 0;
    public static String codigo_salida = ""; 

    private InfoSalida() {
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

        txaObservaciones.setLineWrap(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txfCodigoSalida = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        txfDestino = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        txfCorregimiento = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txfPredio = new javax.swing.JTextField();
        lblConvenio = new javax.swing.JLabel();
        txfConvenio = new javax.swing.JTextField();
        txfSoporte = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        txfConductor = new javax.swing.JTextField();
        txfCedulaConductor = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jScrollBar = new javax.swing.JScrollBar();
        jLabel115 = new javax.swing.JLabel();
        txfCelularConductor = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        txfPlaca = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        txfCliente = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        txfIdentificacion = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        txfCelularCliente = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        txfCodigoEspcSalidas = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txfCantidadSalidas = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        txfEspecieSalidas = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        txfStockSalidas = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();
        comboCarguista = new javax.swing.JComboBox<>();
        jLabel120 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        txfPedido = new javax.swing.JTextField();
        jLabel143 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txfParcial = new javax.swing.JTextField();
        btnSeleccionarEspecieInfoSalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzul.png"))); // NOI18N
        btnEditar.setBorderPainted(false);
        btnEditar.setContentAreaFilled(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFocusable(false);
        btnEditar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setEnabled(false);
        btnGuardar.setFocusable(false);
        btnGuardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Información de la salida:");

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

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel112.setText("Soporte:");

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel110.setText("Municipio/Vereda:");

        txfDestino.setEditable(false);
        txfDestino.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfDestino.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDestinoActionPerformed(evt);
            }
        });
        txfDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfDestinoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfDestinoKeyTyped(evt);
            }
        });

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel137.setText("Corregimiento:");

        txfCorregimiento.setEditable(false);
        txfCorregimiento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCorregimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCorregimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txfCorregimientoMouseEntered(evt);
            }
        });
        txfCorregimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCorregimientoActionPerformed(evt);
            }
        });
        txfCorregimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCorregimientoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCorregimientoKeyTyped(evt);
            }
        });

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel113.setText("Predio:");

        txfPredio.setEditable(false);
        txfPredio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfPredio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPredio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPredioActionPerformed(evt);
            }
        });
        txfPredio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPredioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPredioKeyTyped(evt);
            }
        });

        lblConvenio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblConvenio.setText("Convenio:");

        txfConvenio.setEditable(false);
        txfConvenio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfConvenio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfConvenioActionPerformed(evt);
            }
        });
        txfConvenio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfConvenioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfConvenioKeyTyped(evt);
            }
        });

        txfSoporte.setEditable(false);
        txfSoporte.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfSoporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfSoporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfSoporteActionPerformed(evt);
            }
        });
        txfSoporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfSoporteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfSoporteKeyTyped(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel114.setText("Conductor:");

        txfConductor.setEditable(false);
        txfConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfConductorActionPerformed(evt);
            }
        });
        txfConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfConductorKeyTyped(evt);
            }
        });

        txfCedulaConductor.setEditable(false);
        txfCedulaConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCedulaConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCedulaConductor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txfCedulaConductorMouseEntered(evt);
            }
        });
        txfCedulaConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCedulaConductorActionPerformed(evt);
            }
        });
        txfCedulaConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCedulaConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCedulaConductorKeyTyped(evt);
            }
        });

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel138.setText("C.C:");

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel115.setText("Celular:");

        txfCelularConductor.setEditable(false);
        txfCelularConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelularConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelularConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCelularConductorActionPerformed(evt);
            }
        });
        txfCelularConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCelularConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCelularConductorKeyTyped(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel116.setText("Placa:");

        txfPlaca.setEditable(false);
        txfPlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPlacaActionPerformed(evt);
            }
        });
        txfPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPlacaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPlacaKeyTyped(evt);
            }
        });

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel117.setText("Cliente:");

        txfCliente.setEditable(false);
        txfCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfClienteActionPerformed(evt);
            }
        });
        txfCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfClienteKeyTyped(evt);
            }
        });

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel139.setText("Identificación:");

        txfIdentificacion.setEditable(false);
        txfIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIdentificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfIdentificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txfIdentificacionMouseEntered(evt);
            }
        });
        txfIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdentificacionActionPerformed(evt);
            }
        });
        txfIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfIdentificacionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIdentificacionKeyTyped(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel140.setText("Celular:");

        txfCelularCliente.setEditable(false);
        txfCelularCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelularCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelularCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txfCelularClienteMouseEntered(evt);
            }
        });
        txfCelularCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCelularClienteActionPerformed(evt);
            }
        });
        txfCelularCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCelularClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCelularClienteKeyTyped(evt);
            }
        });

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel119.setText("Observaciones:");

        txaObservaciones.setEditable(false);
        txaObservaciones.setColumns(20);
        txaObservaciones.setRows(5);
        txaObservaciones.setWrapStyleWord(true);
        txaObservaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaObservacionesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txaObservaciones);

        txfCodigoEspcSalidas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfCodigoEspcSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoEspcSalidas.setNextFocusableComponent(txfPedido);
        txfCodigoEspcSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoEspcSalidasActionPerformed(evt);
            }
        });
        txfCodigoEspcSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoEspcSalidasKeyTyped(evt);
            }
        });

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel142.setText("Código:");

        btnQuitar.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnQuitar.setBorderPainted(false);
        btnQuitar.setContentAreaFilled(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.setFocusable(false);
        btnQuitar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar1.png"))); // NOI18N
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFocusable(false);
        btnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txfCantidadSalidas.setEditable(false);
        txfCantidadSalidas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfCantidadSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidadSalidas.setNextFocusableComponent(txfCodigoEspcSalidas);
        txfCantidadSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadSalidasActionPerformed(evt);
            }
        });
        txfCantidadSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadSalidasKeyTyped(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel123.setText("Cantidad:");

        txfEspecieSalidas.setEditable(false);
        txfEspecieSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspecieSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspecieSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspecieSalidasKeyReleased(evt);
            }
        });

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel122.setText("Especie:");

        jLabel141.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel141.setText("Stock:");

        txfStockSalidas.setEditable(false);
        txfStockSalidas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfStockSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfStockSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfStockSalidasKeyTyped(evt);
            }
        });

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Código", "Nombre Común", "Nombre Científico", "Tamaño", "Rango", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        comboCarguista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCarguista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Contratistas", "Personal de nómina", "Cliente" }));
        comboCarguista.setEnabled(false);
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

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel120.setText("Carguista:");

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiar - copia.png"))); // NOI18N
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setFocusable(false);
        btnLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarOscuro - copia.png"))); // NOI18N
        btnLimpiar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarOscuro - copia.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txfPedido.setEditable(false);
        txfPedido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPedido.setNextFocusableComponent(txfCantidadSalidas);
        txfPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPedidoKeyTyped(evt);
            }
        });

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel143.setText("Pedido:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setText("Parcial");

        txfParcial.setEditable(false);
        txfParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfParcial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfParcialKeyTyped(evt);
            }
        });

        btnSeleccionarEspecieInfoSalida.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieInfoSalida.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieInfoSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        btnSeleccionarEspecieInfoSalida.setBorderPainted(false);
        btnSeleccionarEspecieInfoSalida.setFocusPainted(false);
        btnSeleccionarEspecieInfoSalida.setFocusable(false);
        btnSeleccionarEspecieInfoSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieInfoSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel142)
                                    .addComponent(txfCodigoEspcSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel122)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnSeleccionarEspecieInfoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txfEspecieSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel143)
                                    .addComponent(txfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel141)
                                    .addComponent(txfStockSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel123)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txfCantidadSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel112)
                                    .addGap(99, 99, 99)
                                    .addComponent(jLabel110)
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel137)
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txfPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel113))
                                            .addGap(30, 30, 30)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblConvenio)
                                                .addComponent(txfConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txfCelularConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel115))
                                            .addGap(32, 32, 32)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel116)))
                                        .addComponent(txfCelularCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel140, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addGap(10, 10, 10)
                                            .addComponent(txfParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(10, 10, 10)
                                    .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel1))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(txfSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(30, 30, 30)
                                            .addComponent(txfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel114)
                                        .addComponent(txfConductor)
                                        .addComponent(jLabel117)
                                        .addComponent(txfCliente)
                                        .addComponent(jLabel119)
                                        .addComponent(jLabel120)
                                        .addComponent(comboCarguista, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txfCedulaConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel138)
                                        .addComponent(txfCorregimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txfIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel139)))))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel138)
                        .addGap(5, 5, 5)
                        .addComponent(txfCedulaConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(txfParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel18))))
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel112)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel110))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel137)
                                .addComponent(jLabel113)
                                .addComponent(lblConvenio)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfCorregimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel114)
                                .addGap(5, 5, 5)
                                .addComponent(txfConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel115)
                                .addGap(5, 5, 5)
                                .addComponent(txfCelularConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel116)
                                .addGap(5, 5, 5)
                                .addComponent(txfPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel117)
                        .addGap(5, 5, 5)
                        .addComponent(txfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel140)
                        .addGap(5, 5, 5)
                        .addComponent(txfCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel139)
                        .addGap(5, 5, 5)
                        .addComponent(txfIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel120)
                .addGap(10, 10, 10)
                .addComponent(comboCarguista, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel119)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel123)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCantidadSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel141)
                                    .addGap(6, 6, 6)
                                    .addComponent(txfStockSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel142)
                                    .addGap(6, 6, 6)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txfCodigoEspcSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txfEspecieSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel143)
                                .addGap(6, 6, 6)
                                .addComponent(txfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSeleccionarEspecieInfoSalida)
                            .addComponent(jLabel122))))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar la salida? Se eliminará completamente.", "Confirmación", JOptionPane.YES_NO_OPTION);
        String codigo_salida = VistaSGI.identificador;
        String numero_orden = txfCodigoSalida.getText();

        if (resultado == 0) {

            for (int i = 0; i < tablaSalidas.getRowCount(); i++) {

                String codigo = tablaSalidas.getValueAt(i, 1).toString();
                int cantidad = Integer.parseInt(tablaSalidas.getValueAt(i, 7).toString());

                if (sDao.cancelarSalida(codigo, cantidad)) {

                } else {

                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
                }

            }

            if (dsDao.eliminarDetalle(codigo_salida)) {

                if (sDao.eliminarSalida(codigo_salida, numero_orden)) {
                    JOptionPane.showMessageDialog(null, "Salida eliminada correctamente.");
                    reiniciar();
                    limpiarTablaConsultarSalidas();
                    limpiarTablaInventario();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido eliminar la salida, ha ocurrido un error.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido eliminar la salida, ha ocurrido un error.");

            }

        } else {

        }

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txfCodigoSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalidaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {
            evt.consume();
        }

        if (txfCodigoSalida.getText().length() >= 4) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoSalidaKeyTyped

    private void txfDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDestinoActionPerformed

    }//GEN-LAST:event_txfDestinoActionPerformed

    private void txfDestinoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDestinoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDestinoKeyReleased

    private void txfDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDestinoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        if (Character.isDigit(c)) {
            evt.consume();
        }

        if (txfDestino.getText().length() > 20) {

            evt.consume();

        }

    }//GEN-LAST:event_txfDestinoKeyTyped

    private void txfCorregimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCorregimientoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCorregimientoMouseEntered

    private void txfCorregimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCorregimientoActionPerformed

    }//GEN-LAST:event_txfCorregimientoActionPerformed

    private void txfCorregimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCorregimientoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCorregimientoKeyReleased

    private void txfCorregimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCorregimientoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        if (Character.isDigit(c)) {
            evt.consume();
        }

        if (txfCorregimiento.getText().length() > 12) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCorregimientoKeyTyped

    private void txfPredioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPredioActionPerformed

    }//GEN-LAST:event_txfPredioActionPerformed

    private void txfPredioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPredioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPredioKeyReleased

    private void txfPredioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPredioKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        if (Character.isDigit(c)) {
            evt.consume();
        }

        if (txfPredio.getText().length() > 20) {

            evt.consume();

        }
    }//GEN-LAST:event_txfPredioKeyTyped

    private void txfConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfConvenioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConvenioActionPerformed

    private void txfConvenioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfConvenioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConvenioKeyReleased

    private void txfConvenioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfConvenioKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }
        if (Character.isDigit(c)) {
            evt.consume();
        }

        if (txfCorregimiento.getText().length() > 49) {

            evt.consume();

        }
    }//GEN-LAST:event_txfConvenioKeyTyped

    private void txfSoporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfSoporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSoporteActionPerformed

    private void txfSoporteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSoporteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSoporteKeyReleased

    private void txfSoporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfSoporteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfSoporteKeyTyped

    private void txfConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConductorActionPerformed

    private void txfConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConductorKeyReleased

    private void txfConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfConductorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConductorKeyTyped

    private void txfCedulaConductorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCedulaConductorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaConductorMouseEntered

    private void txfCedulaConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCedulaConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaConductorActionPerformed

    private void txfCedulaConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaConductorKeyReleased

    private void txfCedulaConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaConductorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaConductorKeyTyped

    private void txfCelularConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularConductorActionPerformed

    private void txfCelularConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularConductorKeyReleased

    private void txfCelularConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularConductorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularConductorKeyTyped

    private void txfPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPlacaActionPerformed

    private void txfPlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPlacaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPlacaKeyReleased

    private void txfPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPlacaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (txfPlaca.getText().length() > 6) {

            evt.consume();

        }
    }//GEN-LAST:event_txfPlacaKeyTyped

    private void txfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfClienteActionPerformed

    private void txfClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfClienteKeyReleased

    private void txfClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfClienteKeyTyped

    private void txfIdentificacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfIdentificacionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionMouseEntered

    private void txfIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionActionPerformed

    private void txfIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionKeyReleased

    private void txfIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionKeyTyped

    private void txfCelularClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCelularClienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularClienteMouseEntered

    private void txfCelularClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularClienteActionPerformed

    private void txfCelularClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularClienteKeyReleased

    private void txfCelularClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularClienteKeyTyped

    private void tablaSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseClicked

    }//GEN-LAST:event_tablaSalidasMouseClicked

    private void tablaSalidasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidasMouseReleased

    private void tablaSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidasKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        txfDestino.setEditable(true);
        txfCorregimiento.setEditable(true);
        txfPredio.setEditable(true);
        comboCarguista.setEnabled(true);
        txfPlaca.setEditable(true);
        txaObservaciones.setEditable(true);
        txfConvenio.setEditable(true);

        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String codigo_salida = VistaSGI.identificador;
        String numero_orden = txfCodigoSalida.getText();
        String destino = txfDestino.getText().trim();
        String corregimiento = txfCorregimiento.getText().trim();
        String predio = txfPredio.getText().trim();
        String convenio = txfConvenio.getText().trim();
        String carga = "";
        if (comboCarguista.getSelectedIndex() != -1 && comboCarguista.getSelectedIndex() != 0) {
            carga = comboCarguista.getSelectedItem().toString();
        }
        String observacion = txaObservaciones.getText().trim();
        String placa = txfPlaca.getText().trim();

        if (sDao.actualizar(codigo_salida, numero_orden, destino, corregimiento, predio, convenio, carga, observacion, placa)) {

            JOptionPane.showMessageDialog(null, "Salida actualizada correctamente.");
            btnGuardar.setEnabled(false);
            btnEditar.setEnabled(true);
            txfDestino.setEditable(false);
            txfCorregimiento.setEditable(false);
            txfPredio.setEditable(false);
            comboCarguista.setEnabled(false);
            txaObservaciones.setEditable(false);
            txfConvenio.setEditable(false);
            txfPlaca.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar, verifique su información.");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txfStockSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfStockSalidasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfStockSalidasKeyTyped

    private void txfEspecieSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieSalidasKeyReleased

    private void txfCantidadSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadSalidasActionPerformed

        agregarEspecie();
    }//GEN-LAST:event_txfCantidadSalidasActionPerformed

    private void txfCantidadSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCantidadSalidas.getText().length() > 6) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCantidadSalidasKeyTyped

    private void txfCodigoEspcSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoEspcSalidasActionPerformed

        buscarEspeciesSalidas();
    }//GEN-LAST:event_txfCodigoEspcSalidasActionPerformed

    private void txfCodigoEspcSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoEspcSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();
        }

        if (Character.isSpaceChar(c)) {

            evt.consume();
        }

        if (txfCodigoEspcSalidas.getText().length() >= 6) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoEspcSalidasKeyTyped

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        agregarEspecie();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed

        if (tablaSalidas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una especie primero.");
        } else if (tablaSalidas.getRowCount() == 1) {
            JOptionPane.showMessageDialog(null, "La salida no puede quedar sin material vegetal, registre algo más para borrar la fila seleccionada");
        } else {
            quitarEspecie();
        }


    }//GEN-LAST:event_btnQuitarActionPerformed

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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        limpiarSeleccionarEspecies();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txfPedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPedidoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();
        }

        if (Character.isSpaceChar(c)) {

            evt.consume();
        }

        if (txfPedido.getText().length() >= 7) {

            evt.consume();

        }

    }//GEN-LAST:event_txfPedidoKeyTyped

    private void txfParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfParcialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfParcialKeyTyped

    private void btnSeleccionarEspecieInfoSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieInfoSalidaActionPerformed
       
        reiniciarSeleccionarEspecie();
        ventanaEspeciesSalidas.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarEspecieInfoSalidaActionPerformed
    

    public void reiniciarSeleccionarEspecie() {

        ventanaEspeciesSalidas.txfBuscarEsp.setText(null);
        limpiarTablaSeleccionarEspecie();
        limpiarTablaInventario();

    }

    public void limpiarTablaSeleccionarEspecie() {
        DefaultTableModel modelo = (DefaultTableModel) ventanaEspeciesSalidas.tablaEspecies.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSeleccionarEspecieInfoSalida;
    public static javax.swing.JComboBox<String> comboCarguista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblConvenio;
    private javax.swing.JLabel lblFecha;
    public static javax.swing.JTable tablaSalidas;
    private javax.swing.JTextArea txaObservaciones;
    public static javax.swing.JTextField txfCantidadSalidas;
    private javax.swing.JTextField txfCedulaConductor;
    private javax.swing.JTextField txfCelularCliente;
    private javax.swing.JTextField txfCelularConductor;
    private javax.swing.JTextField txfCliente;
    public static javax.swing.JTextField txfCodigoEspcSalidas;
    public static javax.swing.JTextField txfCodigoSalida;
    private javax.swing.JTextField txfConductor;
    private javax.swing.JTextField txfConvenio;
    private javax.swing.JTextField txfCorregimiento;
    private javax.swing.JTextField txfDestino;
    public static javax.swing.JTextField txfEspecieSalidas;
    private javax.swing.JTextField txfIdentificacion;
    private javax.swing.JTextField txfParcial;
    public static javax.swing.JTextField txfPedido;
    private javax.swing.JTextField txfPlaca;
    private javax.swing.JTextField txfPredio;
    private javax.swing.JTextField txfSoporte;
    public static javax.swing.JTextField txfStockSalidas;
    // End of variables declaration//GEN-END:variables

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaConsultarSalidas() {
        DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaConsultarSalidas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaInventario() {
        DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaInventario.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void buscarSalida() {
        try {
             codigo_salida = VistaSGI.identificador;
            String numero_orden = VistaSGI.numero_orden;
            rs = sDao.buscarSalidaPorCodigo(numero_orden, codigo_salida);

            if (rs.next()) {
                txfCodigoSalida.setText(rs.getString("numero_orden"));
                txfParcial.setText(rs.getString("parcial"));
                txfSoporte.setText(rs.getString("motivo"));
                txfDestino.setText(rs.getString("destino"));
                txfCorregimiento.setText(rs.getString("corregimiento"));
                txfPredio.setText(rs.getString("predio"));
                txfConvenio.setText(rs.getString("convenio"));
                if (rs.getInt("id_conductor") == 0) {

                    txfConductor.setText(rs.getString("nombre_conductor_temp") + " " + rs.getString("apellido_conductor_temp"));
                    txfCedulaConductor.setText(rs.getString("id_conductor_temp"));
                    txfCelularConductor.setText(rs.getString("celular_conductor_temp"));
                } else {

                    txfConductor.setText(rs.getString("nombreco") + " " + rs.getString("apellidoco"));
                    txfCedulaConductor.setText(rs.getString("id_conductor"));

                    if (rs.getLong("celularco") == 0) {

                    } else {
                        txfCelularConductor.setText(rs.getString("celularco"));
                    }
                }
                txfPlaca.setText(rs.getString("placa"));
                txfCliente.setText(rs.getString("nombre"));
                txfIdentificacion.setText(rs.getString("id_cliente"));
                txfCelularCliente.setText(rs.getString("celular"));
                txaObservaciones.setText(rs.getString("observacion"));
                lblFecha.setText(rs.getString("fecha"));

                String carga = rs.getString("carga");

                switch (carga) {
                    case "Contratistas":
                        comboCarguista.setSelectedIndex(1);
                        break;
                    case "Personal de nómina":
                        comboCarguista.setSelectedIndex(2);
                        break;
                    case "Cliente":
                        comboCarguista.setSelectedIndex(3);
                        break;
                    default:
                        comboCarguista.setSelectedIndex(0);
                        break;
                }

            }

            mostrarProductos(numero_orden, codigo_salida);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrarProductos(String numero_orden, String codigo_salida) {

        try {

            DefaultTableModel modelo;
            modelo = dsDao.buscarDetalleSalidaConIngreso(numero_orden, codigo_salida);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaSalidas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            TableColumnModel column = tablaSalidas.getColumnModel();
        } catch (Exception e) {

        }

    }

    public void quitarEspecie() {

        if (tablaSalidas.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Seleccione una especie de la tabla, por favor.");
        } else {

            String codigo_salida = tablaSalidas.getValueAt(tablaSalidas.getSelectedRow(), 0).toString();
            String codigo_ingreso = tablaSalidas.getValueAt(tablaSalidas.getSelectedRow(), 1).toString();
            int cantidad = Integer.parseInt(tablaSalidas.getValueAt(tablaSalidas.getSelectedRow(), 7).toString());
            DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
            modelo.removeRow(tablaSalidas.getSelectedRow());

            if (dDao.eliminar(codigo_ingreso, codigo_salida, cantidad)) {
                if (dDao.sumar(codigo_ingreso, cantidad)) {

                    limpiarSeleccionarEspecies();
                    limpiarTablaInventario();

                    if (txfCodigoEspcSalidas.getText().trim().length() != 0 && !txfCodigoEspcSalidas.isEditable()) {

                        buscarEspeciesSalidas();
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error.");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error.");

            }

            buscarSalida();

        }

    }

    public void buscarEspeciesSalidas() {

        try {
            String codigo = txfCodigoEspcSalidas.getText().trim();

            rs = eDao.buscarIngreso(codigo);

            if (rs.next()) {
                txfCodigoEspcSalidas.setEditable(false);
                txfEspecieSalidas.setText(rs.getString("nombre_vulgar") + ", " + rs.getString("tamaño_bolsa") + ", " + rs.getString("rango"));
                txfStockSalidas.setText(rs.getString("stock"));
                nombre_comun = rs.getString("nombre_vulgar");
                nombre_cientifico = rs.getString("nombre_cientifico");
                tamano = rs.getString("tamaño_bolsa");
                rango = rs.getString("rango");
                txfCantidadSalidas.setEditable(true);
                txfPedido.setEditable(true);
                txfPedido.requestFocus(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la especie, verifique su información por favor o registre la especie.");
            }
        } catch (SQLException ex) {
        }
    }

    public void agregarEspecie() {
        try {
            if (txfCodigoEspcSalidas.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Busque o seleccione una especie primero, por favor.");
            } else if (txfCantidadSalidas.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese una cantidad, por favor.");
            } else if (Integer.parseInt(txfCantidadSalidas.getText()) < 1) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
            } else if (Integer.parseInt(txfCantidadSalidas.getText()) > Integer.parseInt(txfStockSalidas.getText())) {
                JOptionPane.showMessageDialog(null, "La cantidad no debe superar al stock.");
            } else if (txfPedido.getText().trim().length() == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad solicitada por el cliente (Pedidas).");
            } else {
                int codigo_salida = Integer.parseInt(VistaSGI.identificador);
                String codigo_ingreso = txfCodigoEspcSalidas.getText().trim();
                String cantidad = txfCantidadSalidas.getText().trim();
                String pedido = txfPedido.getText().trim();
                DetalleSalida_ detalle;

                if (buscarEnLaTabla(codigo_ingreso)) {

                    detalle = new DetalleSalida_(codigo_salida, codigo_ingreso, "", Integer.parseInt(cantidad) + cantidadDuplicada, Integer.parseInt(pedido) + pedidasDuplicada);

                } else {

                    detalle = new DetalleSalida_(codigo_salida, codigo_ingreso, "", Integer.parseInt(cantidad), Integer.parseInt(pedido));
                }

                if (dsDao.CrearDetalleSalida(detalle)) {
                    seleccionarEspecieSalidas(Integer.toString(codigo_salida), codigo_ingreso, nombre_comun, nombre_cientifico, tamano, rango, pedido, cantidad);
                    restar(codigo_ingreso, Integer.parseInt(cantidad));
                    limpiarTablaInventario();
                    txfCodigoEspcSalidas.requestFocus(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error.");
                }

            }
            buscarSalida();
        } catch (NumberFormatException numberF) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese la cantidad pedida");
        }
    }

    public void seleccionarEspecieSalidas(String codigo_salida, String codigo_ingreso, String nombre_vulgar, String nombre_cientifico, String tamaño, String rango, String pedido, String cantidad_) {

        try {
            String datos[] = {codigo_salida, codigo_ingreso, nombre_vulgar, nombre_cientifico, tamaño, rango, pedido, cantidad_};
            DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
            modelo.addRow(datos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void restar(String codigo, int cantidad) {

        if (dDao.restar(codigo, cantidad)) {

            limpiarSeleccionarEspecies();

        } else {

            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, inténtelo de nuevo.");
        }

    }

    public boolean buscarEnLaTabla(String codigo) {

        int filas = tablaSalidas.getRowCount();

        for (int i = 0; i < filas; i++) {

            if (tablaSalidas.getValueAt(i, 1).toString().equalsIgnoreCase(codigo)) {

                cantidadDuplicada = Integer.parseInt(tablaSalidas.getValueAt(i, 7).toString());
                pedidasDuplicada = Integer.parseInt(tablaSalidas.getValueAt(i, 6).toString());

                if (dDao.eliminar(tablaSalidas.getValueAt(i, 1).toString(), tablaSalidas.getValueAt(i, 0).toString(), cantidadDuplicada)) {
                    if (dDao.sumar(tablaSalidas.getValueAt(i, 1).toString(), cantidadDuplicada)) {

                        limpiarSeleccionarEspecies();
                        limpiarTablaInventario();

                        if (txfCodigoEspcSalidas.getText().trim().length() != 0 && !txfCodigoEspcSalidas.isEditable()) {

                            buscarEspeciesSalidas();
                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "Hubo un error.");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error.");

                }

                return true;
            }
        }
        buscarSalida();
        return false;
    }

    public void limpiarSeleccionarEspecies() {

        txfCodigoEspcSalidas.setText(null);
        txfCodigoEspcSalidas.setEditable(true);
        txfEspecieSalidas.setText(null);
        txfStockSalidas.setText(null);
        txfCantidadSalidas.setText(null);
        txfPedido.setText(null);
        txfCantidadSalidas.setEditable(false);
        txfPedido.setEditable(false);
        txfCodigoEspcSalidas.requestFocus(true);
    }

    public void reiniciar() {

        txfCodigoSalida.setText(null);
        txfSoporte.setText(null);
        txfDestino.setText(null);
        txfCorregimiento.setText(null);
        txfPredio.setText(null);
        txfConvenio.setText(null);
        txfConductor.setText(null);
        txfCedulaConductor.setText(null);
        txfCelularConductor.setText(null);
        txfPlaca.setText(null);
        txfCliente.setText(null);
        txfIdentificacion.setText(null);
        txfCelularCliente.setText(null);
        comboCarguista.setSelectedIndex(-1);
        txaObservaciones.setText(null);
        limpiarSeleccionarEspecies();
        limpiarTabla();
        txfDestino.setEditable(false);
        txfCorregimiento.setEditable(false);
        txfPredio.setEditable(false);
        txfConvenio.setEditable(false);
        comboCarguista.setEnabled(false);
        txaObservaciones.setEditable(false);
        btnGuardar.setEnabled(false);
        btnEditar.setEnabled(true);
    }

    public static InfoSalida ObtenerInstancia() {
        if (instance == null) {
            instance = new InfoSalida();
        }
        return instance;
    }
}
