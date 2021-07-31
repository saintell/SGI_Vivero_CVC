package Vista;

import DAO.ClientesDAO;
import DAO.ConductoresDAO;
import DAO.DetalleIngresoDAO;
import DAO.DetalleSalidaDAO;
import DAO.EspeciesDAO;
import DAO.IngresoDAO;
import DAO.ReservasDAO;
import DAO.SalidasDAO;
import DAO.UsuariosDAO;
import Modelo.Cargo_;
import Modelo.Cliente_;
import Modelo.Conductor_;
import Modelo.DetalleIngreso_;
import Modelo.DetalleSalida_;
import Modelo.Especie_;
import Modelo.Estado_;
import Modelo.Ingreso_;
import Modelo.Reserva_;
import Modelo.Salida_;
import Modelo.Usuario_;
import Reportes.GenerarReporte;
import Reportes.GenerarExcel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.scene.input.KeyCode;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;

/**
 *
 * Autores: Santiago Andrés Pineda Ramirez; Álvaro José Tobar Mayorquín
 */
public class VistaSGI extends javax.swing.JFrame {

    private Login login;
    private ConductoresDAO cDao = new ConductoresDAO();
    private SalidasDAO sDao = new SalidasDAO();
    private DetalleSalidaDAO dsDao = new DetalleSalidaDAO();
    private UsuariosDAO uDao = new UsuariosDAO();
    private EspeciesDAO eDao = new EspeciesDAO();
    private DetalleIngresoDAO dDao = new DetalleIngresoDAO();
    private IngresoDAO iDao = new IngresoDAO();
    private ReservasDAO rDao = new ReservasDAO();
    private ClientesDAO clDao = new ClientesDAO();
    private GenerarExcel gexcel = new GenerarExcel();
    private SeleccionarEspecieIngreso ventanaEspecies = SeleccionarEspecieIngreso.ObtenerInstancia();
    private SeleccionarEspecie ventanaEspeciesSalidas = SeleccionarEspecie.ObtenerInstancia();
    private CodigosReservas ventanaCodigos = CodigosReservas.ObtenerInstancia();
    private GuardarExcel ventanaExcel = GuardarExcel.ObtenerInstancia();
    private IngresoTrasplantado ventanaTrasplantado = IngresoTrasplantado.ObtenerInstancia();
    private InfoGeneral ventanaInfoGeneral = InfoGeneral.ObtenerInstancia();
    private InfoSalida ventanaInfoSalida = InfoSalida.ObtenerInstancia();
    private InfoPerdida ventanaInfoPerdida = InfoPerdida.ObtenerInstancia();
    private InfoTrasplantado ventanaInfoTrasplantado = InfoTrasplantado.ObtenerInstancia();
    private int elementos = 0;
    public static int cargo;
    public static String identificador;
    public static String nombre_comun;
    public static String nombre_cientifico;
    public static String tamano;
    public static String rango;
    public static String carguista = " ";
    public static String observacion = " ";
    ResultSet rs;
    public static String codigo_ingresoTrasplantar = "";
    public static String codigo_Ingreso = "";
    public static int codigo_Especie = 0;
    public static String tamañoTrasplantado = "";
    public static String rangoTrasplantado = "";
    public static String numero_orden = null;
    public static String bandera_saleccionar_especies = "";
    private int max_salida = 0;
    private boolean conductor = true;
    private boolean estado = true;
    private Calendar fecha = Calendar.getInstance();
    private final ImageIcon iconoMostrar = new ImageIcon("src/main/resources/btnMostrar.png");
    private final ImageIcon iconoOcultar = new ImageIcon("src/main/resources/btnOcultar.png");
    private int cantidadDuplicada = 0;
    private int pedidasDuplicada = 0;

    public VistaSGI() {
        initComponents();
        this.setLocationRelativeTo(null);
        Image icon = new ImageIcon(getClass().getResource("/Miniatura2.png")).getImage();
        super.setIconImage(icon);

        if (cargo == 1) {

            btn_2.setVisible(false);
            btn_10.setVisible(false);

        }

        lblNumUsuarios.setText(numUsuarios());

        lblNumSalidas.setText(numSalidas(mesActual(), añoActual()));
        lblNumVentas.setText(numVentas(mesActual(), añoActual()));
        mostrarProductosAgotados();
        setColor(btn_1);
        ind_1.setOpaque(true);
        txfCrearContraseña.setEchoChar('•');
        txfCodigoSalida2.setText(Integer.toString(fecha.get(Calendar.YEAR)));
        lblStock1.setVisible(false);
        labelStock.setVisible(false);
        MensajeIndicador.setVisible(false);
        java.util.Date fechaParseada;
        try {
            fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
            fechaDesdeSalida.setDate(fechaParseada);
            fechaHastaSalida.setDate(fechaParseada);
        } catch (ParseException ex) {
        }
        parent.removeAll();
        parent.add(PerfilGerente);
        parent.repaint();
        parent.revalidate();
        jLabel69.setVisible(false);
        txfEditarContraseñaUsuario.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        side_pane = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        btn_1 = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btn_2 = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_5 = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        btn_6 = new javax.swing.JPanel();
        ind_6 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        btn_7 = new javax.swing.JPanel();
        ind_7 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        btn_10 = new javax.swing.JPanel();
        ind_10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        btn_11 = new javax.swing.JPanel();
        ind_11 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        btn_12 = new javax.swing.JPanel();
        ind_12 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        btn_13 = new javax.swing.JPanel();
        ind_13 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCerrar1 = new javax.swing.JLabel();
        parent = new javax.swing.JPanel();
        Salidas = new javax.swing.JPanel();
        MenuSalida = new javax.swing.JTabbedPane();
        GenerarSalida = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        btnCancelarSalida = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        slidePanel = new diu.swe.habib.JPanelSlider.JPanelSlider();
        InfoSalidaPanel = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        motivoCombo = new javax.swing.JComboBox<>();
        jLabel110 = new javax.swing.JLabel();
        txfDestino = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        txfPredio = new javax.swing.JTextField();
        btnSiguienteInfoSalida = new javax.swing.JButton();
        txfCorregimiento = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        lblConvenio = new javax.swing.JLabel();
        txfConvenio = new javax.swing.JTextField();
        ConductorPanel = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        txfCedulaConductorSalidas = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txfNombreConductorSalidas = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txfApellidoConductorSalidas = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        txfCelularConductorSalidas = new javax.swing.JTextField();
        btnSiguienteConductor = new javax.swing.JButton();
        btnAnteriorConductor = new javax.swing.JButton();
        btnAnteriorConductor1 = new javax.swing.JButton();
        txfPlacaSalidas = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        btnLimpiarConductorSalidas = new javax.swing.JButton();
        btnNuevoConductor = new javax.swing.JButton();
        ClientePanel = new javax.swing.JPanel();
        btnSiguienteCliente = new javax.swing.JButton();
        btnAnteriorCliente = new javax.swing.JButton();
        IdentificacionComboSalidas = new javax.swing.JComboBox<>();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        txfIdentificacionClienteSalidas = new javax.swing.JTextField();
        jLabel128 = new javax.swing.JLabel();
        txfNombreClienteSalidas = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        txfTelefonoClienteSalidas = new javax.swing.JTextField();
        btnNuevoCliente1 = new javax.swing.JButton();
        btnAnteriorConductor2 = new javax.swing.JButton();
        btnAnteriorConductor8 = new javax.swing.JButton();
        EspeciesPanel = new javax.swing.JPanel();
        btnAnteriorCliente1 = new javax.swing.JButton();
        jLabel122 = new javax.swing.JLabel();
        txfEspecieSalidas = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        txfCantidadSalidas = new javax.swing.JTextField();
        btnAnteriorConductor3 = new javax.swing.JButton();
        jLabel138 = new javax.swing.JLabel();
        txfCodigoEspcSalidas = new javax.swing.JTextField();
        btnSeleccionarEspecieS = new javax.swing.JButton();
        txfStockSalidas = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        btnLimpiarInfoEsp = new javax.swing.JButton();
        jLabel142 = new javax.swing.JLabel();
        txfPedido = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tablaSalidas1 = new javax.swing.JTable();
        btnAgregar1 = new javax.swing.JButton();
        btnQuitar2 = new javax.swing.JButton();
        PerdidaPanel = new javax.swing.JPanel();
        btnAnteriorCliente2 = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        btnSeleccionarEspecieReservas2 = new javax.swing.JButton();
        txfEspeciePerdida = new javax.swing.JTextField();
        jLabel125 = new javax.swing.JLabel();
        txfCantidadPerdida = new javax.swing.JTextField();
        btnAnteriorConductor4 = new javax.swing.JButton();
        jLabel140 = new javax.swing.JLabel();
        txfStockPerdida = new javax.swing.JTextField();
        txfCodigoPerdida = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        btnAnteriorConductor7 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        TrasplantadoPanel = new javax.swing.JPanel();
        btnAnteriorCliente3 = new javax.swing.JButton();
        jLabel130 = new javax.swing.JLabel();
        btnSeleccionarEspecieReservas3 = new javax.swing.JButton();
        txfEspecieTrasplantado = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        tamanoComboTrasplantado = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        rangoComboTrasplantado = new javax.swing.JComboBox<>();
        btnAnteriorConductor5 = new javax.swing.JButton();
        btnTrasplantar = new javax.swing.JButton();
        lblStock1 = new javax.swing.JLabel();
        labelStock = new javax.swing.JLabel();
        btnAnteriorConductor6 = new javax.swing.JButton();
        btnRegistrarSalida = new javax.swing.JButton();
        txfCodigoSalida = new javax.swing.JTextField();
        lblguion = new javax.swing.JLabel();
        txfCodigoSalida2 = new javax.swing.JTextField();
        cbEntregaParcial = new javax.swing.JCheckBox();
        txfParcial = new javax.swing.JTextField();
        btnSiguienteInfoSalida1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnSiguienteInfoSalida2 = new javax.swing.JButton();
        btnSiguienteInfoSalida3 = new javax.swing.JButton();
        btnSiguienteInfoSalida4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        ConsultarSalida = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        txfBuscarConsultarSalida = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaConsultarSalidas = new javax.swing.JTable();
        btnBuscarSalida = new javax.swing.JButton();
        motivoComboConsultarSalida = new javax.swing.JComboBox<>();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        fechaDesdeSalida = new com.toedter.calendar.JDateChooser();
        jLabel120 = new javax.swing.JLabel();
        fechaHastaSalida = new com.toedter.calendar.JDateChooser();
        btnLimpiarConsulSalidas = new javax.swing.JButton();
        btnGenerarReporte = new javax.swing.JButton();
        btnGenerarReporte1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        AlimentarInventario = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        txfEspecie = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        btnLimpiarAlimentarInventario = new javax.swing.JButton();
        btnIngresarEspecie = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        btnSeleccionarEspecie = new javax.swing.JButton();
        btnLimpiarProveedor2 = new javax.swing.JButton();
        tamanoCombo = new javax.swing.JComboBox<>();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        rangoCombo = new javax.swing.JComboBox<>();
        txfCodigoEspecie = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        btnEditAlimentarInventario = new javax.swing.JButton();
        btnGuardarAlimentarInventario = new javax.swing.JButton();
        btnEliminarAlimentarInventario = new javax.swing.JButton();
        Inventario = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();
        jLabel99 = new javax.swing.JLabel();
        txfBuscarInventario = new javax.swing.JTextField();
        btnDescargar = new javax.swing.JButton();
        PerfilGerente = new javax.swing.JPanel();
        SignOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCambiar = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaAgotados = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblNumUsuarios = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblNumSalidas = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lblNumVentas = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        GestionarUsuarios = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CrearUsuario = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txfUsuario = new javax.swing.JTextField();
        txfNombre = new javax.swing.JTextField();
        txfCelular = new javax.swing.JTextField();
        txfApellido = new javax.swing.JTextField();
        txfDireccion = new javax.swing.JTextField();
        btnCrearUsuario = new javax.swing.JButton();
        passInput1 = new javax.swing.JTextField();
        btnLimpiarProveedor3 = new javax.swing.JButton();
        txfCrearContraseña = new javax.swing.JPasswordField();
        btnMostrarContraseñaU = new javax.swing.JButton();
        ListarUsuario = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnEditarCU = new javax.swing.JButton();
        txfUsuario1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        txfNombre1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txfApellido1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txfCelular1 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txfDireccion1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txfBuscarUsuarios = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardarCU = new javax.swing.JButton();
        estadoComboCU = new javax.swing.JComboBox<>();
        jLabel66 = new javax.swing.JLabel();
        btnDesactivar = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        txfEditarContraseñaUsuario = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        MensajeIndicador = new javax.swing.JLabel();
        GestionarClientes = new javax.swing.JPanel();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jLabel143 = new javax.swing.JLabel();
        txfNombreClientes = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        txfCelularClientes = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        txfIdClientes = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        txfBuscarCliente = new javax.swing.JTextField();
        btnLimpiarClientes = new javax.swing.JButton();
        btnGuardarCliente = new javax.swing.JButton();
        btnRegistrarCliente = new javax.swing.JButton();
        TipoComboClientes = new javax.swing.JComboBox<>();
        jLabel153 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        GestionarConductores = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        btnEditarConductor = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablaConductores = new javax.swing.JTable();
        jLabel148 = new javax.swing.JLabel();
        txfNombreConductor = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        txfApellidoConductor = new javax.swing.JTextField();
        jLabel150 = new javax.swing.JLabel();
        txfCelularConductor = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        txfCedulaConductor = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        txfBuscarConductor = new javax.swing.JTextField();
        btnLimpiarConductor = new javax.swing.JButton();
        btnGuardarConductor = new javax.swing.JButton();
        btnRegistrarConductor = new javax.swing.JButton();
        btnEliminarConductor = new javax.swing.JButton();
        GestionarEspecies = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        btnEditarEsp = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaEspecies = new javax.swing.JTable();
        jLabel119 = new javax.swing.JLabel();
        txfNombreComun = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        txfFamilia = new javax.swing.JTextField();
        jLabel133 = new javax.swing.JLabel();
        txfMsnm = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        txfNombreCien = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        txfBuscarEsp = new javax.swing.JTextField();
        btnLimpiarEsp = new javax.swing.JButton();
        btnGuardarEsp = new javax.swing.JButton();
        btnRegistrarEsp = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        lblNumeroEspecie = new javax.swing.JLabel();
        btnEliminarEspecie = new javax.swing.JButton();
        Reservas = new javax.swing.JPanel();
        MenuReserva = new javax.swing.JTabbedPane();
        Reservar = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        jLabel95 = new javax.swing.JLabel();
        txfIdentificacionReservas = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        txfNombreReservas = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        txfTelefonoReservas = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        btnLimpiarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        btnSeleccionarEspecieReservas = new javax.swing.JButton();
        jLabel102 = new javax.swing.JLabel();
        txfEspecieReservas = new javax.swing.JTextField();
        btnQuitar1 = new javax.swing.JButton();
        IdentificacionCombo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lblNumeroReserva = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnNuevoCliente = new javax.swing.JButton();
        txfCantidadReservas = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        txfCodigoPlantaReservas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblDisponibles = new javax.swing.JLabel();
        ConsultarReserva = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        txfBuscarConsultarReservas = new javax.swing.JTextField();
        txfCodigoReserva = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        txfNombreConsultarReservas = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaConsultarReservas = new javax.swing.JTable();
        jLabel106 = new javax.swing.JLabel();
        lblTotalConsultarReservas = new javax.swing.JLabel();
        txfTelefonoConsultarReservas = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        txfIdentificacionConsultarReservas = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        btnLimpiarConsultarReservas = new javax.swing.JButton();
        btnCancelarConsultarReservas = new javax.swing.JButton();
        btnQuitarConsultarReservas = new javax.swing.JButton();
        btnAgregarConsultarReservas = new javax.swing.JButton();
        btnSeleccionarEspecieReservas4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        side_pane.setBackground(new java.awt.Color(0, 0, 0));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LogoCVC.png"))); // NOI18N

        btn_1.setBackground(new java.awt.Color(0, 0, 0));
        btn_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_1MousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Perfil");

        javax.swing.GroupLayout btn_1Layout = new javax.swing.GroupLayout(btn_1);
        btn_1.setLayout(btn_1Layout);
        btn_1Layout.setHorizontalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(0, 156, Short.MAX_VALUE))
        );
        btn_1Layout.setVerticalGroup(
            btn_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_1Layout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_2.setBackground(new java.awt.Color(0, 0, 0));
        btn_2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_2MousePressed(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Gestionar Usuarios");

        javax.swing.GroupLayout btn_2Layout = new javax.swing.GroupLayout(btn_2);
        btn_2.setLayout(btn_2Layout);
        btn_2Layout.setHorizontalGroup(
            btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_2Layout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        btn_2Layout.setVerticalGroup(
            btn_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_2Layout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_5.setBackground(new java.awt.Color(0, 0, 0));
        btn_5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_5consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_5MousePressed(evt);
            }
        });

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Alimentar Inventario");

        javax.swing.GroupLayout btn_5Layout = new javax.swing.GroupLayout(btn_5);
        btn_5.setLayout(btn_5Layout);
        btn_5Layout.setHorizontalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        btn_5Layout.setVerticalGroup(
            btn_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_5Layout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        btn_6.setBackground(new java.awt.Color(0, 0, 0));
        btn_6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_6consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_6MousePressed(evt);
            }
        });

        ind_6.setOpaque(false);
        ind_6.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_6Layout = new javax.swing.GroupLayout(ind_6);
        ind_6.setLayout(ind_6Layout);
        ind_6Layout.setHorizontalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_6Layout.setVerticalGroup(
            ind_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Inventario");

        javax.swing.GroupLayout btn_6Layout = new javax.swing.GroupLayout(btn_6);
        btn_6.setLayout(btn_6Layout);
        btn_6Layout.setHorizontalGroup(
            btn_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_6Layout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        btn_6Layout.setVerticalGroup(
            btn_6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_6Layout.createSequentialGroup()
                .addComponent(ind_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        btn_7.setBackground(new java.awt.Color(0, 0, 0));
        btn_7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_7consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_7MouseReleased(evt);
            }
        });

        ind_7.setOpaque(false);
        ind_7.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_7Layout = new javax.swing.GroupLayout(ind_7);
        ind_7.setLayout(ind_7Layout);
        ind_7Layout.setHorizontalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_7Layout.setVerticalGroup(
            ind_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Salidas");

        javax.swing.GroupLayout btn_7Layout = new javax.swing.GroupLayout(btn_7);
        btn_7.setLayout(btn_7Layout);
        btn_7Layout.setHorizontalGroup(
            btn_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_7Layout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        btn_7Layout.setVerticalGroup(
            btn_7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_7Layout.createSequentialGroup()
                .addComponent(ind_7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        btn_10.setBackground(new java.awt.Color(0, 0, 0));
        btn_10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_10consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_10MousePressed(evt);
            }
        });

        ind_10.setOpaque(false);
        ind_10.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_10Layout = new javax.swing.GroupLayout(ind_10);
        ind_10.setLayout(ind_10Layout);
        ind_10Layout.setHorizontalGroup(
            ind_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_10Layout.setVerticalGroup(
            ind_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Gestionar Especies");

        javax.swing.GroupLayout btn_10Layout = new javax.swing.GroupLayout(btn_10);
        btn_10.setLayout(btn_10Layout);
        btn_10Layout.setHorizontalGroup(
            btn_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_10Layout.createSequentialGroup()
                .addComponent(ind_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_10Layout.setVerticalGroup(
            btn_10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_10Layout.createSequentialGroup()
                .addComponent(ind_10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_11.setBackground(new java.awt.Color(0, 0, 0));
        btn_11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_11consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_11MousePressed(evt);
            }
        });

        ind_11.setOpaque(false);
        ind_11.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_11Layout = new javax.swing.GroupLayout(ind_11);
        ind_11.setLayout(ind_11Layout);
        ind_11Layout.setHorizontalGroup(
            ind_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_11Layout.setVerticalGroup(
            ind_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Gestionar Conductores");

        javax.swing.GroupLayout btn_11Layout = new javax.swing.GroupLayout(btn_11);
        btn_11.setLayout(btn_11Layout);
        btn_11Layout.setHorizontalGroup(
            btn_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_11Layout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_11Layout.setVerticalGroup(
            btn_11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_11Layout.createSequentialGroup()
                .addComponent(ind_11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_12.setBackground(new java.awt.Color(0, 0, 0));
        btn_12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_12consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_12MousePressed(evt);
            }
        });

        ind_12.setOpaque(false);
        ind_12.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_12Layout = new javax.swing.GroupLayout(ind_12);
        ind_12.setLayout(ind_12Layout);
        ind_12Layout.setHorizontalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_12Layout.setVerticalGroup(
            ind_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Gestionar Clientes");

        javax.swing.GroupLayout btn_12Layout = new javax.swing.GroupLayout(btn_12);
        btn_12.setLayout(btn_12Layout);
        btn_12Layout.setHorizontalGroup(
            btn_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_12Layout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_12Layout.setVerticalGroup(
            btn_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_12Layout.createSequentialGroup()
                .addComponent(ind_12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_13.setBackground(new java.awt.Color(0, 0, 0));
        btn_13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_13consultarEmpleados(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_13MousePressed(evt);
            }
        });

        ind_13.setOpaque(false);
        ind_13.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_13Layout = new javax.swing.GroupLayout(ind_13);
        ind_13.setLayout(ind_13Layout);
        ind_13Layout.setHorizontalGroup(
            ind_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_13Layout.setVerticalGroup(
            ind_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Reservas");

        javax.swing.GroupLayout btn_13Layout = new javax.swing.GroupLayout(btn_13);
        btn_13.setLayout(btn_13Layout);
        btn_13Layout.setHorizontalGroup(
            btn_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_13Layout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
        );
        btn_13Layout.setVerticalGroup(
            btn_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_13Layout.createSequentialGroup()
                .addComponent(ind_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btn_13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout side_paneLayout = new javax.swing.GroupLayout(side_pane);
        side_pane.setLayout(side_paneLayout);
        side_paneLayout.setHorizontalGroup(
            side_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_paneLayout.createSequentialGroup()
                .addGroup(side_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(side_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(side_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(side_paneLayout.createSequentialGroup()
                .addGroup(side_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, side_paneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(Logo))
                    .addComponent(btn_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        side_paneLayout.setVerticalGroup(
            side_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(side_paneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 66));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Expand_Arrow_32px.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        btnCerrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Multiply_32px.png"))); // NOI18N
        btnCerrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(780, 780, 780)
                .addComponent(btnCerrar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        parent.setBackground(new java.awt.Color(255, 255, 255));
        parent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        parent.setPreferredSize(new java.awt.Dimension(1214, 420));
        parent.setLayout(new java.awt.CardLayout());

        Salidas.setBackground(new java.awt.Color(255, 255, 255));
        Salidas.setPreferredSize(new java.awt.Dimension(1214, 460));
        Salidas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SalidasFocusLost(evt);
            }
        });
        Salidas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                SalidasComponentHidden(evt);
            }
        });
        Salidas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuSalida.setBackground(new java.awt.Color(255, 255, 255));
        MenuSalida.setFocusable(false);
        MenuSalida.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MenuSalidaStateChanged(evt);
            }
        });

        GenerarSalida.setBackground(new java.awt.Color(255, 255, 255));
        GenerarSalida.setPreferredSize(new java.awt.Dimension(1214, 633));

        jLabel46.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel46.setText("SALIDAS");

        btnCancelarSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarSalida.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCancelarSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojo.png"))); // NOI18N
        btnCancelarSalida.setBorderPainted(false);
        btnCancelarSalida.setContentAreaFilled(false);
        btnCancelarSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelarSalida.setFocusable(false);
        btnCancelarSalida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelarSalida.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSalidaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("N°");

        slidePanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                slidePanelKeyTyped(evt);
            }
        });

        InfoSalidaPanel.setBackground(new java.awt.Color(255, 255, 255));
        InfoSalidaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la Salida"));
        InfoSalidaPanel.setPreferredSize(new java.awt.Dimension(892, 169));
        InfoSalidaPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InfoSalidaPanelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InfoSalidaPanelKeyReleased(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel112.setText("Soporte:");

        motivoCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        motivoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proyecto", "Promoción", "Pérdida", "Trasplantado", "Venta" }));
        motivoCombo.setNextFocusableComponent(txfDestino);
        motivoCombo.setRequestFocusEnabled(true);
        motivoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                motivoComboItemStateChanged(evt);
            }
        });
        motivoCombo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                motivoComboFocusGained(evt);
            }
        });
        motivoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivoComboActionPerformed(evt);
            }
        });
        motivoCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                motivoComboKeyReleased(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel110.setText("Municipio/Vereda:");

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

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel113.setText("Predio:");

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

        btnSiguienteInfoSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteInfoSalida.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteInfoSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siguiente-boton.png"))); // NOI18N
        btnSiguienteInfoSalida.setBorderPainted(false);
        btnSiguienteInfoSalida.setContentAreaFilled(false);
        btnSiguienteInfoSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteInfoSalida.setFocusable(false);
        btnSiguienteInfoSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteInfoSalidaActionPerformed(evt);
            }
        });

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

        jLabel137.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel137.setText("Corregimiento:");

        lblConvenio.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblConvenio.setText("Convenio:");

        txfConvenio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfConvenio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfConvenio.setNextFocusableComponent(txfPredio);
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

        javax.swing.GroupLayout InfoSalidaPanelLayout = new javax.swing.GroupLayout(InfoSalidaPanel);
        InfoSalidaPanel.setLayout(InfoSalidaPanelLayout);
        InfoSalidaPanelLayout.setHorizontalGroup(
            InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoSalidaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InfoSalidaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSiguienteInfoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InfoSalidaPanelLayout.createSequentialGroup()
                        .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(InfoSalidaPanelLayout.createSequentialGroup()
                                .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel112)
                                    .addComponent(motivoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel110)
                                    .addComponent(txfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblConvenio)
                            .addComponent(txfConvenio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel137)
                            .addComponent(jLabel113)
                            .addComponent(txfPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfCorregimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        InfoSalidaPanelLayout.setVerticalGroup(
            InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoSalidaPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoSalidaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel137)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCorregimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel110)
                    .addGroup(InfoSalidaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel112)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(motivoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConvenio)
                    .addComponent(jLabel113))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InfoSalidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPredio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnSiguienteInfoSalida)
                .addGap(26, 26, 26))
        );

        slidePanel.add(InfoSalidaPanel, "card2");

        ConductorPanel.setBackground(new java.awt.Color(255, 255, 255));
        ConductorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Conductor"));

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel109.setText("Cedula:");

        txfCedulaConductorSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCedulaConductorSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCedulaConductorSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCedulaConductorSalidasActionPerformed(evt);
            }
        });
        txfCedulaConductorSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCedulaConductorSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCedulaConductorSalidasKeyTyped(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel72.setText("Nombre:");

        txfNombreConductorSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreConductorSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreConductorSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreConductorSalidasActionPerformed(evt);
            }
        });
        txfNombreConductorSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreConductorSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreConductorSalidasKeyTyped(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel73.setText("Apellido:");

        txfApellidoConductorSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfApellidoConductorSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfApellidoConductorSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfApellidoConductorSalidasActionPerformed(evt);
            }
        });
        txfApellidoConductorSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfApellidoConductorSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfApellidoConductorSalidasKeyTyped(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel114.setText("Celular:");

        txfCelularConductorSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelularConductorSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelularConductorSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCelularConductorSalidasActionPerformed(evt);
            }
        });
        txfCelularConductorSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCelularConductorSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCelularConductorSalidasKeyTyped(evt);
            }
        });

        btnSiguienteConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siguiente-boton.png"))); // NOI18N
        btnSiguienteConductor.setBorderPainted(false);
        btnSiguienteConductor.setContentAreaFilled(false);
        btnSiguienteConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteConductor.setFocusable(false);
        btnSiguienteConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteConductorActionPerformed(evt);
            }
        });

        btnAnteriorConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anterior-boton.png"))); // NOI18N
        btnAnteriorConductor.setBorderPainted(false);
        btnAnteriorConductor.setContentAreaFilled(false);
        btnAnteriorConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor.setFocusable(false);
        btnAnteriorConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductorActionPerformed(evt);
            }
        });

        btnAnteriorConductor1.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-boton.png"))); // NOI18N
        btnAnteriorConductor1.setBorderPainted(false);
        btnAnteriorConductor1.setContentAreaFilled(false);
        btnAnteriorConductor1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor1.setFocusable(false);
        btnAnteriorConductor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor1ActionPerformed(evt);
            }
        });

        txfPlacaSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfPlacaSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPlacaSalidas.setNextFocusableComponent(txfCedulaConductorSalidas);
        txfPlacaSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPlacaSalidasActionPerformed(evt);
            }
        });
        txfPlacaSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPlacaSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPlacaSalidasKeyTyped(evt);
            }
        });

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel132.setText("Placa:");

        btnLimpiarConductorSalidas.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarConductorSalidas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarConductorSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escoba.png"))); // NOI18N
        btnLimpiarConductorSalidas.setBorderPainted(false);
        btnLimpiarConductorSalidas.setContentAreaFilled(false);
        btnLimpiarConductorSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarConductorSalidas.setFocusable(false);
        btnLimpiarConductorSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConductorSalidasActionPerformed(evt);
            }
        });

        btnNuevoConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnNuevoConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoConductor.setBorderPainted(false);
        btnNuevoConductor.setContentAreaFilled(false);
        btnNuevoConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoConductor.setFocusable(false);
        btnNuevoConductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoConductor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConductorPanelLayout = new javax.swing.GroupLayout(ConductorPanel);
        ConductorPanel.setLayout(ConductorPanelLayout);
        ConductorPanelLayout.setHorizontalGroup(
            ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConductorPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel109)
                    .addComponent(jLabel114)
                    .addComponent(txfCelularConductorSalidas, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(btnAnteriorConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCedulaConductorSalidas))
                .addGap(50, 50, 50)
                .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConductorPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnAnteriorConductor1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(btnLimpiarConductorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguienteConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel132)
                    .addGroup(ConductorPanelLayout.createSequentialGroup()
                        .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConductorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txfPlacaSalidas, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(txfNombreConductorSalidas))
                        .addGap(50, 50, 50)
                        .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel73)
                            .addComponent(txfApellidoConductorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConductorPanelLayout.setVerticalGroup(
            ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConductorPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ConductorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel109)
                        .addGap(6, 6, 6)
                        .addComponent(txfCedulaConductorSalidas))
                    .addGroup(ConductorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel72)
                        .addGap(6, 6, 6)
                        .addComponent(txfNombreConductorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConductorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel73)
                        .addGap(6, 6, 6)
                        .addComponent(txfApellidoConductorSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConductorPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(ConductorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel114)
                                .addGap(6, 6, 6)
                                .addComponent(txfCelularConductorSalidas))
                            .addGroup(ConductorPanelLayout.createSequentialGroup()
                                .addComponent(jLabel132)
                                .addGap(6, 6, 6)
                                .addComponent(txfPlacaSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNuevoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAnteriorConductor)
                            .addGroup(ConductorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAnteriorConductor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiarConductorSalidas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ConductorPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguienteConductor)))
                .addGap(26, 26, 26))
        );

        slidePanel.add(ConductorPanel, "card3");

        ClientePanel.setBackground(new java.awt.Color(255, 255, 255));
        ClientePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Cliente"));

        btnSiguienteCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/siguiente-boton.png"))); // NOI18N
        btnSiguienteCliente.setBorderPainted(false);
        btnSiguienteCliente.setContentAreaFilled(false);
        btnSiguienteCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteCliente.setFocusable(false);
        btnSiguienteCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteClienteActionPerformed(evt);
            }
        });

        btnAnteriorCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anterior-boton.png"))); // NOI18N
        btnAnteriorCliente.setBorderPainted(false);
        btnAnteriorCliente.setContentAreaFilled(false);
        btnAnteriorCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorCliente.setFocusable(false);
        btnAnteriorCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha izquierda.png"))); // NOI18N
        btnAnteriorCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha izquierda.png"))); // NOI18N
        btnAnteriorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorClienteActionPerformed(evt);
            }
        });

        IdentificacionComboSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IdentificacionComboSalidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula de Ciudadanía", "NIT" }));
        IdentificacionComboSalidas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IdentificacionComboSalidasItemStateChanged(evt);
            }
        });

        jLabel126.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel126.setText("Tipo de Identificación:");

        jLabel127.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel127.setText("Nit/Cédula:");

        txfIdentificacionClienteSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIdentificacionClienteSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfIdentificacionClienteSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdentificacionClienteSalidasActionPerformed(evt);
            }
        });
        txfIdentificacionClienteSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfIdentificacionClienteSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIdentificacionClienteSalidasKeyTyped(evt);
            }
        });

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel128.setText("Nombre Completo:");

        txfNombreClienteSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreClienteSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreClienteSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreClienteSalidasActionPerformed(evt);
            }
        });
        txfNombreClienteSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreClienteSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreClienteSalidasKeyTyped(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel129.setText("Teléfono:");

        txfTelefonoClienteSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfTelefonoClienteSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfTelefonoClienteSalidas.setNextFocusableComponent(IdentificacionComboSalidas);
        txfTelefonoClienteSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefonoClienteSalidasActionPerformed(evt);
            }
        });
        txfTelefonoClienteSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTelefonoClienteSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefonoClienteSalidasKeyTyped(evt);
            }
        });

        btnNuevoCliente1.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoCliente1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnNuevoCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoCliente1.setBorderPainted(false);
        btnNuevoCliente1.setContentAreaFilled(false);
        btnNuevoCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoCliente1.setFocusable(false);
        btnNuevoCliente1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoCliente1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliente1ActionPerformed(evt);
            }
        });

        btnAnteriorConductor2.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-boton.png"))); // NOI18N
        btnAnteriorConductor2.setBorderPainted(false);
        btnAnteriorConductor2.setContentAreaFilled(false);
        btnAnteriorConductor2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor2.setFocusable(false);
        btnAnteriorConductor2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/casa.png"))); // NOI18N
        btnAnteriorConductor2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/casa.png"))); // NOI18N
        btnAnteriorConductor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor2ActionPerformed(evt);
            }
        });

        btnAnteriorConductor8.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escoba.png"))); // NOI18N
        btnAnteriorConductor8.setBorderPainted(false);
        btnAnteriorConductor8.setContentAreaFilled(false);
        btnAnteriorConductor8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor8.setFocusable(false);
        btnAnteriorConductor8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarOscuro - copia.png"))); // NOI18N
        btnAnteriorConductor8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarOscuro - copia.png"))); // NOI18N
        btnAnteriorConductor8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClientePanelLayout = new javax.swing.GroupLayout(ClientePanel);
        ClientePanel.setLayout(ClientePanelLayout);
        ClientePanelLayout.setHorizontalGroup(
            ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientePanelLayout.createSequentialGroup()
                        .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel126)
                            .addComponent(IdentificacionComboSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnteriorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel127)
                            .addComponent(txfIdentificacionClienteSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnteriorConductor2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ClientePanelLayout.createSequentialGroup()
                                .addComponent(btnAnteriorConductor8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(245, 245, 245)
                                .addComponent(btnSiguienteCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel128)
                                .addComponent(txfNombreClienteSalidas))))
                    .addComponent(jLabel129)
                    .addComponent(txfTelefonoClienteSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        ClientePanelLayout.setVerticalGroup(
            ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientePanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel128)
                    .addComponent(jLabel126)
                    .addComponent(jLabel127))
                .addGap(6, 6, 6)
                .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IdentificacionComboSalidas, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(txfIdentificacionClienteSalidas)
                    .addComponent(txfNombreClienteSalidas))
                .addGap(44, 44, 44)
                .addComponent(jLabel129)
                .addGap(6, 6, 6)
                .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(txfTelefonoClienteSalidas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(ClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAnteriorCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnteriorConductor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnteriorConductor8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSiguienteCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        slidePanel.add(ClientePanel, "card3");

        EspeciesPanel.setBackground(new java.awt.Color(255, 255, 255));
        EspeciesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de las especies"));
        EspeciesPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EspeciesPanelKeyTyped(evt);
            }
        });

        btnAnteriorCliente1.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorCliente1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anterior-boton.png"))); // NOI18N
        btnAnteriorCliente1.setBorderPainted(false);
        btnAnteriorCliente1.setContentAreaFilled(false);
        btnAnteriorCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorCliente1.setFocusable(false);
        btnAnteriorCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorCliente1ActionPerformed(evt);
            }
        });

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel122.setText("Especie:");

        txfEspecieSalidas.setEditable(false);
        txfEspecieSalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspecieSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspecieSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspecieSalidasKeyReleased(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel123.setText("Entregadas:");

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

        btnAnteriorConductor3.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-boton.png"))); // NOI18N
        btnAnteriorConductor3.setBorderPainted(false);
        btnAnteriorConductor3.setContentAreaFilled(false);
        btnAnteriorConductor3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor3.setFocusable(false);
        btnAnteriorConductor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor3ActionPerformed(evt);
            }
        });

        jLabel138.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel138.setText("Código:");

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

        btnSeleccionarEspecieS.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieS.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        btnSeleccionarEspecieS.setBorderPainted(false);
        btnSeleccionarEspecieS.setFocusPainted(false);
        btnSeleccionarEspecieS.setFocusable(false);
        btnSeleccionarEspecieS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieSActionPerformed(evt);
            }
        });

        txfStockSalidas.setEditable(false);
        txfStockSalidas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfStockSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfStockSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfStockSalidasKeyTyped(evt);
            }
        });

        jLabel139.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel139.setText("Stock:");

        btnLimpiarInfoEsp.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarInfoEsp.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarInfoEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escoba.png"))); // NOI18N
        btnLimpiarInfoEsp.setBorderPainted(false);
        btnLimpiarInfoEsp.setContentAreaFilled(false);
        btnLimpiarInfoEsp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarInfoEsp.setFocusable(false);
        btnLimpiarInfoEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarInfoEspActionPerformed(evt);
            }
        });

        jLabel142.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel142.setText("Pedidas:");

        txfPedido.setEditable(false);
        txfPedido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPedido.setNextFocusableComponent(txfCantidadSalidas);
        txfPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfPedidoKeyTyped(evt);
            }
        });

        tablaSalidas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Común", "Nombre Científico", "Tamaño", "Rango", "Pedido", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSalidas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSalidas1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaSalidas1MouseReleased(evt);
            }
        });
        tablaSalidas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaSalidas1KeyReleased(evt);
            }
        });
        jScrollPane14.setViewportView(tablaSalidas1);

        btnAgregar1.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar1.png"))); // NOI18N
        btnAgregar1.setBorderPainted(false);
        btnAgregar1.setContentAreaFilled(false);
        btnAgregar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar1.setFocusable(false);
        btnAgregar1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnQuitar2.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitar2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnQuitar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnQuitar2.setBorderPainted(false);
        btnQuitar2.setContentAreaFilled(false);
        btnQuitar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuitar2.setFocusable(false);
        btnQuitar2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EspeciesPanelLayout = new javax.swing.GroupLayout(EspeciesPanel);
        EspeciesPanel.setLayout(EspeciesPanelLayout);
        EspeciesPanelLayout.setHorizontalGroup(
            EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EspeciesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(EspeciesPanelLayout.createSequentialGroup()
                        .addComponent(btnAnteriorCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(353, 353, 353)
                        .addComponent(btnAnteriorConductor3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(353, 353, 353)
                        .addComponent(btnLimpiarInfoEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(EspeciesPanelLayout.createSequentialGroup()
                            .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel138)
                                .addComponent(txfCodigoEspcSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EspeciesPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel122)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSeleccionarEspecieS, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txfEspecieSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel142)
                                .addComponent(txfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel139)
                                .addComponent(txfStockSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)
                            .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel123)
                                .addComponent(txfCantidadSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EspeciesPanelLayout.createSequentialGroup()
                            .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnQuitar2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        EspeciesPanelLayout.setVerticalGroup(
            EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EspeciesPanelLayout.createSequentialGroup()
                .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EspeciesPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel138)
                        .addGap(6, 6, 6)
                        .addComponent(txfCodigoEspcSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EspeciesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EspeciesPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel123)
                                    .addGap(6, 6, 6)
                                    .addComponent(txfCantidadSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(EspeciesPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel139)
                                    .addGap(6, 6, 6)
                                    .addComponent(txfStockSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(EspeciesPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel142)
                                    .addGap(6, 6, 6)
                                    .addComponent(txfPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EspeciesPanelLayout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(txfEspecieSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel122)
                                    .addComponent(btnSeleccionarEspecieS))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQuitar2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAgregar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAnteriorCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnteriorConductor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarInfoEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        slidePanel.add(EspeciesPanel, "card3");

        PerdidaPanel.setBackground(new java.awt.Color(255, 255, 255));
        PerdidaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la pérdida"));

        btnAnteriorCliente2.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorCliente2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorCliente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anterior-boton.png"))); // NOI18N
        btnAnteriorCliente2.setBorderPainted(false);
        btnAnteriorCliente2.setContentAreaFilled(false);
        btnAnteriorCliente2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorCliente2.setFocusable(false);
        btnAnteriorCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorCliente2ActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel124.setText("Especie:");

        btnSeleccionarEspecieReservas2.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas2.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        btnSeleccionarEspecieReservas2.setBorderPainted(false);
        btnSeleccionarEspecieReservas2.setFocusPainted(false);
        btnSeleccionarEspecieReservas2.setFocusable(false);
        btnSeleccionarEspecieReservas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieReservas2ActionPerformed(evt);
            }
        });

        txfEspeciePerdida.setEditable(false);
        txfEspeciePerdida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspeciePerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspeciePerdida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEspeciePerdidaActionPerformed(evt);
            }
        });
        txfEspeciePerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspeciePerdidaKeyReleased(evt);
            }
        });

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel125.setText("Stock:");

        txfCantidadPerdida.setEditable(false);
        txfCantidadPerdida.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfCantidadPerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidadPerdida.setNextFocusableComponent(txfCodigoPerdida);
        txfCantidadPerdida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadPerdidaActionPerformed(evt);
            }
        });
        txfCantidadPerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadPerdidaKeyTyped(evt);
            }
        });

        btnAnteriorConductor4.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-boton.png"))); // NOI18N
        btnAnteriorConductor4.setBorderPainted(false);
        btnAnteriorConductor4.setContentAreaFilled(false);
        btnAnteriorConductor4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor4.setFocusable(false);
        btnAnteriorConductor4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor4ActionPerformed(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel140.setText("Cantidad perdida:");

        txfStockPerdida.setEditable(false);
        txfStockPerdida.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfStockPerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfStockPerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfStockPerdidaKeyTyped(evt);
            }
        });

        txfCodigoPerdida.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfCodigoPerdida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoPerdida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoPerdidaActionPerformed(evt);
            }
        });
        txfCodigoPerdida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoPerdidaKeyTyped(evt);
            }
        });

        jLabel141.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel141.setText("Código:");

        btnAnteriorConductor7.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escoba.png"))); // NOI18N
        btnAnteriorConductor7.setBorderPainted(false);
        btnAnteriorConductor7.setContentAreaFilled(false);
        btnAnteriorConductor7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor7.setFocusable(false);
        btnAnteriorConductor7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor7ActionPerformed(evt);
            }
        });

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Común", "Nombre Científico", "Tamaño", "Rango", "Pedido", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
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

        btnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar1.png"))); // NOI18N
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregar.setFocusable(false);
        btnAgregar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnQuitar.setBorderPainted(false);
        btnQuitar.setContentAreaFilled(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuitar.setFocusable(false);
        btnQuitar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PerdidaPanelLayout = new javax.swing.GroupLayout(PerdidaPanel);
        PerdidaPanel.setLayout(PerdidaPanelLayout);
        PerdidaPanelLayout.setHorizontalGroup(
            PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PerdidaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9)
                    .addGroup(PerdidaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PerdidaPanelLayout.createSequentialGroup()
                                .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PerdidaPanelLayout.createSequentialGroup()
                                    .addComponent(btnAnteriorCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAnteriorConductor4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(351, 351, 351)
                                    .addComponent(btnAnteriorConductor7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PerdidaPanelLayout.createSequentialGroup()
                                    .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel141)
                                        .addComponent(txfCodigoPerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PerdidaPanelLayout.createSequentialGroup()
                                            .addComponent(jLabel124)
                                            .addGap(10, 10, 10)
                                            .addComponent(btnSeleccionarEspecieReservas2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txfEspeciePerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(31, 31, 31)
                                    .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel125)
                                        .addComponent(txfStockPerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(38, 38, 38)
                                    .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txfCantidadPerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel140)))))))
                .addGap(19, 19, 19))
        );
        PerdidaPanelLayout.setVerticalGroup(
            PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerdidaPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PerdidaPanelLayout.createSequentialGroup()
                            .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PerdidaPanelLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel124))
                                .addComponent(btnSeleccionarEspecieReservas2))
                            .addGap(6, 6, 6)
                            .addComponent(txfEspeciePerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PerdidaPanelLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel125)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfStockPerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PerdidaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel140)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCantidadPerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PerdidaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel141)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCodigoPerdida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PerdidaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAnteriorCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnteriorConductor7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnteriorConductor4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(25, 25, 25))
        );

        slidePanel.add(PerdidaPanel, "card3");

        TrasplantadoPanel.setBackground(new java.awt.Color(255, 255, 255));
        TrasplantadoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Trasplantar"));

        btnAnteriorCliente3.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorCliente3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorCliente3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anterior-boton.png"))); // NOI18N
        btnAnteriorCliente3.setBorderPainted(false);
        btnAnteriorCliente3.setContentAreaFilled(false);
        btnAnteriorCliente3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorCliente3.setFocusable(false);
        btnAnteriorCliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorCliente3ActionPerformed(evt);
            }
        });

        jLabel130.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel130.setText("Especie:");

        btnSeleccionarEspecieReservas3.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas3.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        btnSeleccionarEspecieReservas3.setBorderPainted(false);
        btnSeleccionarEspecieReservas3.setFocusPainted(false);
        btnSeleccionarEspecieReservas3.setFocusable(false);
        btnSeleccionarEspecieReservas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieReservas3ActionPerformed(evt);
            }
        });

        txfEspecieTrasplantado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspecieTrasplantado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspecieTrasplantado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfEspecieTrasplantadoActionPerformed(evt);
            }
        });
        txfEspecieTrasplantado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspecieTrasplantadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfEspecieTrasplantadoKeyTyped(evt);
            }
        });

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel131.setText("Cantidad:");

        txfCantidadTrasplantado.setEditable(false);
        txfCantidadTrasplantado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfCantidadTrasplantado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidadTrasplantado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadTrasplantadoActionPerformed(evt);
            }
        });
        txfCantidadTrasplantado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadTrasplantadoKeyTyped(evt);
            }
        });

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel67.setText("Tamaño de Bolsa:");

        tamanoComboTrasplantado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tamanoComboTrasplantado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10x20", "18x34" }));
        tamanoComboTrasplantado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tamanoComboTrasplantadoItemStateChanged(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel68.setText("Rango:");

        rangoComboTrasplantado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rangoComboTrasplantado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<20 cm", "20-40 cm", ">60 cm" }));
        rangoComboTrasplantado.setNextFocusableComponent(txfEspecieTrasplantado);
        rangoComboTrasplantado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rangoComboTrasplantadoItemStateChanged(evt);
            }
        });

        btnAnteriorConductor5.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-boton.png"))); // NOI18N
        btnAnteriorConductor5.setBorderPainted(false);
        btnAnteriorConductor5.setContentAreaFilled(false);
        btnAnteriorConductor5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor5.setFocusable(false);
        btnAnteriorConductor5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor5ActionPerformed(evt);
            }
        });

        btnTrasplantar.setBackground(new java.awt.Color(255, 255, 255));
        btnTrasplantar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnTrasplantar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intercambio.png"))); // NOI18N
        btnTrasplantar.setBorderPainted(false);
        btnTrasplantar.setContentAreaFilled(false);
        btnTrasplantar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTrasplantar.setFocusable(false);
        btnTrasplantar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/intercambioOscuro.png"))); // NOI18N
        btnTrasplantar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/intercambioOscuro.png"))); // NOI18N
        btnTrasplantar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrasplantarActionPerformed(evt);
            }
        });

        lblStock1.setText("Disponibles:");

        btnAnteriorConductor6.setBackground(new java.awt.Color(255, 255, 255));
        btnAnteriorConductor6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAnteriorConductor6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/escoba.png"))); // NOI18N
        btnAnteriorConductor6.setBorderPainted(false);
        btnAnteriorConductor6.setContentAreaFilled(false);
        btnAnteriorConductor6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAnteriorConductor6.setFocusable(false);
        btnAnteriorConductor6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorConductor6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TrasplantadoPanelLayout = new javax.swing.GroupLayout(TrasplantadoPanel);
        TrasplantadoPanel.setLayout(TrasplantadoPanelLayout);
        TrasplantadoPanelLayout.setHorizontalGroup(
            TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                        .addComponent(btnAnteriorCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(715, 715, 715)
                        .addComponent(btnAnteriorConductor6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrasplantadoPanelLayout.createSequentialGroup()
                        .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                                        .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel130)
                                                .addGap(10, 10, 10)
                                                .addComponent(btnSeleccionarEspecieReservas3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txfEspecieTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                                                .addComponent(lblStock1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(52, 52, 52))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TrasplantadoPanelLayout.createSequentialGroup()
                                        .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel67)
                                            .addComponent(tamanoComboTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)))
                                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel131, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel68)
                                    .addComponent(txfCantidadTrasplantado)
                                    .addComponent(rangoComboTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAnteriorConductor5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTrasplantar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(117, 117, 117))))
        );
        TrasplantadoPanelLayout.setVerticalGroup(
            TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                        .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel130))
                            .addComponent(btnSeleccionarEspecieReservas3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEspecieTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel131)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCantidadTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnTrasplantar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TrasplantadoPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStock1)
                            .addComponent(labelStock, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamanoComboTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rangoComboTrasplantado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(TrasplantadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAnteriorConductor6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnteriorConductor5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnteriorCliente3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        slidePanel.add(TrasplantadoPanel, "card3");

        btnRegistrarSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarSalida.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnRegistrarSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnRegistrarSalida.setBorderPainted(false);
        btnRegistrarSalida.setContentAreaFilled(false);
        btnRegistrarSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarSalida.setFocusable(false);
        btnRegistrarSalida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarSalida.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSalidaActionPerformed(evt);
            }
        });

        txfCodigoSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCodigoSalidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoSalidaKeyTyped(evt);
            }
        });

        lblguion.setText("-");

        txfCodigoSalida2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoSalida2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoSalida2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCodigoSalida2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoSalida2KeyTyped(evt);
            }
        });

        fechaSalida.setDateFormatString("dd-MM-yyyy");
        fechaSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cbEntregaParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbEntregaParcial.setText("Entrega parcial");
        cbEntregaParcial.setContentAreaFilled(false);
        cbEntregaParcial.setFocusable(false);
        cbEntregaParcial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEntregaParcialItemStateChanged(evt);
            }
        });
        cbEntregaParcial.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbEntregaParcialStateChanged(evt);
            }
        });
        cbEntregaParcial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntregaParcialActionPerformed(evt);
            }
        });

        txfParcial.setEditable(false);
        txfParcial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfParcial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfParcial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfParcialKeyTyped(evt);
            }
        });

        btnSiguienteInfoSalida1.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteInfoSalida1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteInfoSalida1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero1-activo.png"))); // NOI18N
        btnSiguienteInfoSalida1.setBorderPainted(false);
        btnSiguienteInfoSalida1.setContentAreaFilled(false);
        btnSiguienteInfoSalida1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteInfoSalida1.setFocusable(false);
        btnSiguienteInfoSalida1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteInfoSalida1ActionPerformed(evt);
            }
        });

        btnSiguienteInfoSalida2.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteInfoSalida2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteInfoSalida2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero2-desactivado.png"))); // NOI18N
        btnSiguienteInfoSalida2.setBorderPainted(false);
        btnSiguienteInfoSalida2.setContentAreaFilled(false);
        btnSiguienteInfoSalida2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteInfoSalida2.setFocusable(false);
        btnSiguienteInfoSalida2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteInfoSalida2ActionPerformed(evt);
            }
        });

        btnSiguienteInfoSalida3.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteInfoSalida3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteInfoSalida3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero3-desactivado.png"))); // NOI18N
        btnSiguienteInfoSalida3.setBorderPainted(false);
        btnSiguienteInfoSalida3.setContentAreaFilled(false);
        btnSiguienteInfoSalida3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteInfoSalida3.setFocusable(false);
        btnSiguienteInfoSalida3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteInfoSalida3ActionPerformed(evt);
            }
        });

        btnSiguienteInfoSalida4.setBackground(new java.awt.Color(255, 255, 255));
        btnSiguienteInfoSalida4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSiguienteInfoSalida4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/numero4-desactivado.png"))); // NOI18N
        btnSiguienteInfoSalida4.setBorderPainted(false);
        btnSiguienteInfoSalida4.setContentAreaFilled(false);
        btnSiguienteInfoSalida4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSiguienteInfoSalida4.setFocusable(false);
        btnSiguienteInfoSalida4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha derecha.png"))); // NOI18N
        btnSiguienteInfoSalida4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteInfoSalida4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GenerarSalidaLayout = new javax.swing.GroupLayout(GenerarSalida);
        GenerarSalida.setLayout(GenerarSalidaLayout);
        GenerarSalidaLayout.setHorizontalGroup(
            GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenerarSalidaLayout.createSequentialGroup()
                .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GenerarSalidaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GenerarSalidaLayout.createSequentialGroup()
                            .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(GenerarSalidaLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(btnSiguienteInfoSalida1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jSeparator1)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnSiguienteInfoSalida2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnSiguienteInfoSalida3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GenerarSalidaLayout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(jLabel18)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblguion, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfCodigoSalida2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(fechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(63, 63, 63)
                                    .addComponent(jLabel46)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbEntregaParcial)))
                            .addGap(0, 0, 0)
                            .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txfParcial, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSiguienteInfoSalida4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(GenerarSalidaLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(btnRegistrarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCancelarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        GenerarSalidaLayout.setVerticalGroup(
            GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenerarSalidaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GenerarSalidaLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(lblguion)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(cbEntregaParcial)
                            .addComponent(txfParcial, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addComponent(txfCodigoSalida2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(fechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txfCodigoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GenerarSalidaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSiguienteInfoSalida4)
                            .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSiguienteInfoSalida2)
                                    .addComponent(btnSiguienteInfoSalida1)
                                    .addComponent(btnSiguienteInfoSalida3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GenerarSalidaLayout.createSequentialGroup()
                                    .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(11, 11, 11))))
                        .addGap(18, 18, 18)
                        .addComponent(slidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GenerarSalidaLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(GenerarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarSalida)
                    .addComponent(btnCancelarSalida))
                .addContainerGap())
        );

        MenuSalida.addTab("Salidas", GenerarSalida);

        ConsultarSalida.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarSalida.setPreferredSize(new java.awt.Dimension(1214, 633));

        jLabel47.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel47.setText("CONSULTAR SALIDAS");

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel116.setText("Buscar por N° de Orden:");

        txfBuscarConsultarSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarConsultarSalida.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarConsultarSalida.setToolTipText("Busque por NIT, Cédula del cliente.");
        txfBuscarConsultarSalida.setNextFocusableComponent(motivoComboConsultarSalida);
        txfBuscarConsultarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarConsultarSalidaActionPerformed(evt);
            }
        });
        txfBuscarConsultarSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarConsultarSalidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarConsultarSalidaKeyTyped(evt);
            }
        });

        tablaConsultarSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaConsultarSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConsultarSalidasMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaConsultarSalidasMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaConsultarSalidasMouseReleased(evt);
            }
        });
        tablaConsultarSalidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaConsultarSalidasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaConsultarSalidasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaConsultarSalidasKeyTyped(evt);
            }
        });
        jScrollPane10.setViewportView(tablaConsultarSalidas);

        btnBuscarSalida.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarSalida.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnBuscarSalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar1.png"))); // NOI18N
        btnBuscarSalida.setBorderPainted(false);
        btnBuscarSalida.setContentAreaFilled(false);
        btnBuscarSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarSalida.setFocusable(false);
        btnBuscarSalida.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar2.png"))); // NOI18N
        btnBuscarSalida.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar2.png"))); // NOI18N
        btnBuscarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSalidaActionPerformed(evt);
            }
        });

        motivoComboConsultarSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        motivoComboConsultarSalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin motivo", "Proyecto", "Promoción", "Pérdida", "Trasplantado", "Venta" }));
        motivoComboConsultarSalida.setSelectedIndex(1);
        motivoComboConsultarSalida.setToolTipText("");
        motivoComboConsultarSalida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                motivoComboConsultarSalidaItemStateChanged(evt);
            }
        });
        motivoComboConsultarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivoComboConsultarSalidaActionPerformed(evt);
            }
        });

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel117.setText("Motivo de la salida:");

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel118.setText("Desde:");

        fechaDesdeSalida.setDateFormatString("dd-MM-yyyy");
        fechaDesdeSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel120.setText("Hasta:");

        fechaHastaSalida.setDateFormatString("dd-MM-yyyy");
        fechaHastaSalida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnLimpiarConsulSalidas.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarConsulSalidas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarConsulSalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarConsulSalidas.setBorderPainted(false);
        btnLimpiarConsulSalidas.setContentAreaFilled(false);
        btnLimpiarConsulSalidas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarConsulSalidas.setFocusable(false);
        btnLimpiarConsulSalidas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarConsulSalidas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarConsulSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConsulSalidasActionPerformed(evt);
            }
        });

        btnGenerarReporte.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remisionAzul.png"))); // NOI18N
        btnGenerarReporte.setBorderPainted(false);
        btnGenerarReporte.setContentAreaFilled(false);
        btnGenerarReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporte.setFocusable(false);
        btnGenerarReporte.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/remisionAzulOscuro.png"))); // NOI18N
        btnGenerarReporte.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/remisionAzulOscuro.png"))); // NOI18N
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        btnGenerarReporte1.setBackground(new java.awt.Color(255, 255, 255));
        btnGenerarReporte1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGenerarReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excel.png"))); // NOI18N
        btnGenerarReporte1.setBorderPainted(false);
        btnGenerarReporte1.setContentAreaFilled(false);
        btnGenerarReporte1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGenerarReporte1.setFocusable(false);
        btnGenerarReporte1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/excelOscuro.png"))); // NOI18N
        btnGenerarReporte1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/excelOscuro.png"))); // NOI18N
        btnGenerarReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporte1ActionPerformed(evt);
            }
        });

        jLabel26.setText("Doble click en un item de la tabla para ver o editar su información");

        javax.swing.GroupLayout ConsultarSalidaLayout = new javax.swing.GroupLayout(ConsultarSalida);
        ConsultarSalida.setLayout(ConsultarSalidaLayout);
        ConsultarSalidaLayout.setHorizontalGroup(
            ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane10)
                            .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel117)
                                    .addComponent(motivoComboConsultarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaDesdeSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel118))
                                .addGap(30, 30, 30)
                                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel120)
                                    .addComponent(fechaHastaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel116)
                                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                                        .addComponent(txfBuscarConsultarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47))
                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(btnLimpiarConsulSalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnGenerarReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76))
        );
        ConsultarSalidaLayout.setVerticalGroup(
            ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                        .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel118)
                            .addComponent(jLabel120))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaDesdeSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(fechaHastaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                        .addComponent(jLabel117)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(motivoComboConsultarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConsultarSalidaLayout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBuscarConsultarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConsultarSalidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpiarConsulSalidas)
                    .addComponent(btnGenerarReporte)
                    .addComponent(btnGenerarReporte1))
                .addContainerGap())
        );

        MenuSalida.addTab("Consultar", ConsultarSalida);

        Salidas.add(MenuSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        parent.add(Salidas, "card4");

        AlimentarInventario.setBackground(new java.awt.Color(255, 255, 255));
        AlimentarInventario.setPreferredSize(new java.awt.Dimension(1214, 460));

        jLabel41.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel41.setText("ALIMENTAR INVENTARIO");

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel83.setText("Especie:");

        txfEspecie.setEditable(false);
        txfEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspecie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspecieKeyReleased(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel84.setText("Fecha Ingreso:");

        btnLimpiarAlimentarInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarAlimentarInventario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarAlimentarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarAlimentarInventario.setBorderPainted(false);
        btnLimpiarAlimentarInventario.setContentAreaFilled(false);
        btnLimpiarAlimentarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarAlimentarInventario.setFocusable(false);
        btnLimpiarAlimentarInventario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarAlimentarInventario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarAlimentarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarAlimentarInventarioMouseClicked(evt);
            }
        });
        btnLimpiarAlimentarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarAlimentarInventarioActionPerformed(evt);
            }
        });

        btnIngresarEspecie.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresarEspecie.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnIngresarEspecie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnIngresarEspecie.setBorderPainted(false);
        btnIngresarEspecie.setContentAreaFilled(false);
        btnIngresarEspecie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresarEspecie.setFocusable(false);
        btnIngresarEspecie.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnIngresarEspecie.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnIngresarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarEspecieActionPerformed(evt);
            }
        });

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel87.setText("Desde:");

        txfBuscarEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarEspecie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarEspecieActionPerformed(evt);
            }
        });
        txfBuscarEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarEspecieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarEspecieKeyTyped(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel88.setText("Buscar:");

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel89.setText("Hasta");

        btnSeleccionarEspecie.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecie.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        btnSeleccionarEspecie.setBorderPainted(false);
        btnSeleccionarEspecie.setFocusPainted(false);
        btnSeleccionarEspecie.setFocusable(false);
        btnSeleccionarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieActionPerformed(evt);
            }
        });

        btnLimpiarProveedor2.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarProveedor2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarProveedor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar1.png"))); // NOI18N
        btnLimpiarProveedor2.setBorderPainted(false);
        btnLimpiarProveedor2.setContentAreaFilled(false);
        btnLimpiarProveedor2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarProveedor2.setFocusable(false);
        btnLimpiarProveedor2.setPreferredSize(new java.awt.Dimension(65, 49));
        btnLimpiarProveedor2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar2.png"))); // NOI18N
        btnLimpiarProveedor2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar2.png"))); // NOI18N
        btnLimpiarProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProveedor2ActionPerformed(evt);
            }
        });

        fechaDesde.setDateFormatString("dd-MM-yyyy");
        fechaDesde.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        fechaIngreso.setDateFormatString("dd-MM-yyyy");
        fechaIngreso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fechaIngreso.setNextFocusableComponent(txfCantidadIngresarEspecie);
        fechaIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaIngresoKeyTyped(evt);
            }
        });

        tamanoCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tamanoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10x20", "18x34" }));
        tamanoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tamanoComboItemStateChanged(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel91.setText("Bolsa:");

        fechaHasta.setDateFormatString("dd-MM-yyyy");
        fechaHasta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel92.setText("Cantidad:");

        txfCantidadIngresarEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCantidadIngresarEspecie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidadIngresarEspecie.setNextFocusableComponent(txfCodigoEspecie);
        txfCantidadIngresarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadIngresarEspecieActionPerformed(evt);
            }
        });
        txfCantidadIngresarEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCantidadIngresarEspecieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadIngresarEspecieKeyTyped(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel93.setText("Rango:");

        rangoCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rangoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<20 cm", "20-40 cm", ">60 cm" }));
        rangoCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rangoComboItemStateChanged(evt);
            }
        });
        rangoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangoComboActionPerformed(evt);
            }
        });

        txfCodigoEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoEspecie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoEspecieActionPerformed(evt);
            }
        });
        txfCodigoEspecie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCodigoEspecieKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoEspecieKeyTyped(evt);
            }
        });

        jLabel136.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel136.setText("Código:");

        tablaAlimentarInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Común", "Bolsa", "Rango", "Cantidad", "Fecha"
            }
        ));
        tablaAlimentarInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlimentarInventarioMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaAlimentarInventarioMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tablaAlimentarInventario);

        btnEditAlimentarInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnEditAlimentarInventario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEditAlimentarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzul.png"))); // NOI18N
        btnEditAlimentarInventario.setBorderPainted(false);
        btnEditAlimentarInventario.setContentAreaFilled(false);
        btnEditAlimentarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditAlimentarInventario.setFocusable(false);
        btnEditAlimentarInventario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditAlimentarInventario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditAlimentarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAlimentarInventarioActionPerformed(evt);
            }
        });

        btnGuardarAlimentarInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarAlimentarInventario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardarAlimentarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardarAlimentarInventario.setBorderPainted(false);
        btnGuardarAlimentarInventario.setContentAreaFilled(false);
        btnGuardarAlimentarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarAlimentarInventario.setEnabled(false);
        btnGuardarAlimentarInventario.setFocusable(false);
        btnGuardarAlimentarInventario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarAlimentarInventario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarAlimentarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAlimentarInventarioActionPerformed(evt);
            }
        });

        btnEliminarAlimentarInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarAlimentarInventario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEliminarAlimentarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnEliminarAlimentarInventario.setToolTipText("Eliminar Especie");
        btnEliminarAlimentarInventario.setBorderPainted(false);
        btnEliminarAlimentarInventario.setContentAreaFilled(false);
        btnEliminarAlimentarInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarAlimentarInventario.setFocusable(false);
        btnEliminarAlimentarInventario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarAlimentarInventario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarAlimentarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlimentarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AlimentarInventarioLayout = new javax.swing.GroupLayout(AlimentarInventario);
        AlimentarInventario.setLayout(AlimentarInventarioLayout);
        AlimentarInventarioLayout.setHorizontalGroup(
            AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(322, 322, 322)
                                .addComponent(jLabel41))
                            .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                        .addComponent(jLabel136)
                                        .addGap(108, 108, 108))
                                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                        .addComponent(txfCodigoEspecie)
                                        .addGap(35, 35, 35)))
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                        .addComponent(jLabel83)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSeleccionarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tamanoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel91))
                                .addGap(20, 20, 20)
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rangoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel93))
                                .addGap(18, 18, 18)
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel84)
                                    .addComponent(fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCantidadIngresarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel88)
                                    .addComponent(txfBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel87))
                                .addGap(35, 35, 35)
                                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLimpiarProveedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEliminarAlimentarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel89)))))
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnLimpiarAlimentarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditAlimentarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarAlimentarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AlimentarInventarioLayout.setVerticalGroup(
            AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AlimentarInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSeleccionarEspecie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel91)
                                .addComponent(jLabel93)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tamanoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rangoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addComponent(jLabel136)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCodigoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addComponent(jLabel84)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCantidadIngresarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                        .addComponent(jLabel88)
                        .addGap(38, 38, 38))
                    .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                            .addComponent(jLabel87)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AlimentarInventarioLayout.createSequentialGroup()
                            .addComponent(jLabel89)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLimpiarProveedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminarAlimentarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txfBuscarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AlimentarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnLimpiarAlimentarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIngresarEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarAlimentarInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEditAlimentarInventario))
                .addGap(34, 34, 34))
        );

        parent.add(AlimentarInventario, "card4");

        Inventario.setBackground(new java.awt.Color(255, 255, 255));
        Inventario.setPreferredSize(new java.awt.Dimension(1214, 460));

        jLabel48.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel48.setText("INVENTARIO SAN EMIGDIO");

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInventarioMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaInventarioMouseReleased(evt);
            }
        });
        tablaInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaInventarioKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tablaInventario);

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel99.setText("Buscar:");

        txfBuscarInventario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarInventario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarInventarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarInventarioKeyTyped(evt);
            }
        });

        btnDescargar.setBackground(new java.awt.Color(255, 255, 255));
        btnDescargar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnDescargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/down-arrow (2).png"))); // NOI18N
        btnDescargar.setBorderPainted(false);
        btnDescargar.setContentAreaFilled(false);
        btnDescargar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDescargar.setFocusable(false);
        btnDescargar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/down-arrowOscuro.png"))); // NOI18N
        btnDescargar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/down-arrowOscuro.png"))); // NOI18N
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InventarioLayout = new javax.swing.GroupLayout(Inventario);
        Inventario.setLayout(InventarioLayout);
        InventarioLayout.setHorizontalGroup(
            InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
            .addGroup(InventarioLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel99)
                    .addComponent(txfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(btnDescargar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 311, Short.MAX_VALUE))
        );
        InventarioLayout.setVerticalGroup(
            InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(7, 7, 7)
                .addGroup(InventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDescargar)
                    .addGroup(InventarioLayout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfBuscarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.add(Inventario, "card4");

        PerfilGerente.setBackground(new java.awt.Color(255, 255, 255));
        PerfilGerente.setForeground(new java.awt.Color(255, 255, 255));
        PerfilGerente.setPreferredSize(new java.awt.Dimension(1214, 460));

        SignOut.setBackground(new java.awt.Color(255, 255, 255));
        SignOut.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        SignOut.setForeground(new java.awt.Color(255, 255, 255));
        SignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida.png"))); // NOI18N
        SignOut.setBorderPainted(false);
        SignOut.setContentAreaFilled(false);
        SignOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SignOut.setFocusable(false);
        SignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignOutActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(245, 245, 245));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitulo.setText("PRODUCTOS AGOTADOS");

        btnCambiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menuIco.PNG"))); // NOI18N
        btnCambiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnCambiarMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        tablaAgotados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tablaAgotados);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuarioIcon.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 204, 204));
        jLabel32.setText("Usuarios");

        lblNumUsuarios.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNumUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumUsuarios.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblNumUsuarios)))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addGap(20, 20, 20))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reservasIcon.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(204, 204, 204));
        jLabel34.setText("Salidas este mes");

        lblNumSalidas.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNumSalidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumSalidas.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNumSalidas)
                        .addGap(63, 63, 63))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumSalidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addGap(21, 21, 21))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventasIcon.PNG"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(204, 204, 204));
        jLabel38.setText("Ventas este Mes");

        lblNumVentas.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNumVentas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumVentas.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel38))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lblNumVentas)))
                .addGap(18, 18, 18))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNumVentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(21, 21, 21))
        );

        jLabel27.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel27.setText("INFORMACION ADICIONAL");

        javax.swing.GroupLayout PerfilGerenteLayout = new javax.swing.GroupLayout(PerfilGerente);
        PerfilGerente.setLayout(PerfilGerenteLayout);
        PerfilGerenteLayout.setHorizontalGroup(
            PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerfilGerenteLayout.createSequentialGroup()
                .addGroup(PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PerfilGerenteLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(SignOut))
                    .addGroup(PerfilGerenteLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PerfilGerenteLayout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(jLabel27))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PerfilGerenteLayout.setVerticalGroup(
            PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerfilGerenteLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel27)
                .addGap(31, 31, 31)
                .addGroup(PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PerfilGerenteLayout.createSequentialGroup()
                        .addGroup(PerfilGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(SignOut))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        parent.add(PerfilGerente, "card6");

        GestionarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        GestionarUsuarios.setForeground(new java.awt.Color(255, 153, 51));
        GestionarUsuarios.setPreferredSize(new java.awt.Dimension(1214, 460));

        CrearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        CrearUsuario.setForeground(new java.awt.Color(255, 153, 51));
        CrearUsuario.setPreferredSize(new java.awt.Dimension(993, 565));

        jLabel15.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel15.setText("CREAR USUARIO");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Nombre: ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Apellido:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Usuario:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Celular:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Dirección:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Posición de trabajo:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Contraseña:");

        txfUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfUsuarioActionPerformed(evt);
            }
        });
        txfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfUsuarioKeyTyped(evt);
            }
        });

        txfNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreKeyTyped(evt);
            }
        });

        txfCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCelularKeyTyped(evt);
            }
        });

        txfApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfApellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfApellidoKeyTyped(evt);
            }
        });

        txfDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfDireccionKeyTyped(evt);
            }
        });

        btnCrearUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnCrearUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnCrearUsuario.setBorderPainted(false);
        btnCrearUsuario.setContentAreaFilled(false);
        btnCrearUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCrearUsuario.setFocusable(false);
        btnCrearUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnCrearUsuario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUsuarioActionPerformed(evt);
            }
        });

        passInput1.setEditable(false);
        passInput1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passInput1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passInput1.setText("Encargado de Vivero");

        btnLimpiarProveedor3.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarProveedor3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarProveedor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarProveedor3.setBorderPainted(false);
        btnLimpiarProveedor3.setContentAreaFilled(false);
        btnLimpiarProveedor3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarProveedor3.setFocusable(false);
        btnLimpiarProveedor3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarProveedor3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarProveedor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProveedor3ActionPerformed(evt);
            }
        });

        txfCrearContraseña.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCrearContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCrearContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCrearContraseñaKeyTyped(evt);
            }
        });

        btnMostrarContraseñaU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnMostrar - copia.png"))); // NOI18N
        btnMostrarContraseñaU.setBorderPainted(false);
        btnMostrarContraseñaU.setContentAreaFilled(false);
        btnMostrarContraseñaU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMostrarContraseñaU.setFocusable(false);
        btnMostrarContraseñaU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarContraseñaUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearUsuarioLayout = new javax.swing.GroupLayout(CrearUsuario);
        CrearUsuario.setLayout(CrearUsuarioLayout);
        CrearUsuarioLayout.setHorizontalGroup(
            CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuarioLayout.createSequentialGroup()
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearUsuarioLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passInput1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                            .addComponent(txfDireccion)
                            .addComponent(txfCelular)
                            .addComponent(txfApellido)
                            .addComponent(txfNombre)
                            .addComponent(txfUsuario)
                            .addGroup(CrearUsuarioLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel15))
                            .addComponent(txfCrearContraseña))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostrarContraseñaU, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CrearUsuarioLayout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(btnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnLimpiarProveedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        CrearUsuarioLayout.setVerticalGroup(
            CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuarioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel15)
                .addGap(38, 38, 38)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(passInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(btnMostrarContraseñaU, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCrearContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(btnLimpiarProveedor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Crear Usuario", CrearUsuario);

        ListarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        ListarUsuario.setPreferredSize(new java.awt.Dimension(880, 565));

        jLabel13.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel13.setText("LISTA DE USUARIOS");

        btnEditarCU.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarCU.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEditarCU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzul.png"))); // NOI18N
        btnEditarCU.setBorderPainted(false);
        btnEditarCU.setContentAreaFilled(false);
        btnEditarCU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarCU.setFocusable(false);
        btnEditarCU.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarCU.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarCU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCUActionPerformed(evt);
            }
        });

        txfUsuario1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfUsuario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfUsuario1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfUsuario1KeyTyped(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel60.setText("Usuario:");

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nombre", "Apellido", "Celular", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel61.setText("Nombre:");

        txfNombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombre1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombre1KeyTyped(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel62.setText("Apellidos:");

        txfApellido1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfApellido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfApellido1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfApellido1KeyTyped(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel63.setText("Celular:");

        txfCelular1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelular1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelular1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCelular1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCelular1KeyTyped(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel64.setText("Dirección:");

        txfDireccion1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfDireccion1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfDireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfDireccion1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfDireccion1KeyTyped(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel65.setText("Buscar:");

        txfBuscarUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarUsuarios.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarUsuariosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarUsuariosKeyTyped(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiar.setFocusable(false);
        btnLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardarCU.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarCU.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardarCU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardarCU.setBorderPainted(false);
        btnGuardarCU.setContentAreaFilled(false);
        btnGuardarCU.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCU.setEnabled(false);
        btnGuardarCU.setFocusable(false);
        btnGuardarCU.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarCU.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarCU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCUActionPerformed(evt);
            }
        });

        estadoComboCU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estadoComboCU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVOS", "INACTIVOS" }));
        estadoComboCU.setFocusable(false);
        estadoComboCU.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                estadoComboCUItemStateChanged(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel66.setText("Ver:");

        btnDesactivar.setBackground(new java.awt.Color(255, 255, 255));
        btnDesactivar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desactivarRojo.png"))); // NOI18N
        btnDesactivar.setBorderPainted(false);
        btnDesactivar.setContentAreaFilled(false);
        btnDesactivar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesactivar.setFocusable(false);
        btnDesactivar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/desactivarRojoOscuro.png"))); // NOI18N
        btnDesactivar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/desactivarRojoOscuro.png"))); // NOI18N
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnEliminarUsuario.setToolTipText("Eliminar Especie");
        btnEliminarUsuario.setBorderPainted(false);
        btnEliminarUsuario.setContentAreaFilled(false);
        btnEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarUsuario.setFocusable(false);
        btnEliminarUsuario.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarUsuario.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        txfEditarContraseñaUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEditarContraseñaUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEditarContraseñaUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEditarContraseñaUsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfEditarContraseñaUsuarioKeyTyped(evt);
            }
        });

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel69.setText("Contraseña:");

        MensajeIndicador.setText("Doble Click para activar un usuario");

        javax.swing.GroupLayout ListarUsuarioLayout = new javax.swing.GroupLayout(ListarUsuario);
        ListarUsuario.setLayout(ListarUsuarioLayout);
        ListarUsuarioLayout.setHorizontalGroup(
            ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditarCU, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnGuardarCU, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnDesactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListarUsuarioLayout.createSequentialGroup()
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel60)
                                    .addComponent(txfUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txfBuscarUsuarios))
                                .addGap(30, 30, 30))
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addGap(114, 114, 114)))
                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel61)
                                        .addComponent(txfNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                        .addComponent(estadoComboCU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel66))
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel62)
                                            .addComponent(txfApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30, 30, 30)
                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addComponent(txfEditarContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MensajeIndicador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel63)
                                    .addComponent(txfCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel69))
                                .addGap(27, 27, 27)
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ListarUsuarioLayout.setVerticalGroup(
            ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(25, 25, 25)
                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txfCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel65)
                                            .addComponent(jLabel66))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(estadoComboCU)
                                            .addComponent(txfBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ListarUsuarioLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(MensajeIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ListarUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfEditarContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(ListarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarCU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarCU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDesactivar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Lista de Usuarios", ListarUsuario);

        javax.swing.GroupLayout GestionarUsuariosLayout = new javax.swing.GroupLayout(GestionarUsuarios);
        GestionarUsuarios.setLayout(GestionarUsuariosLayout);
        GestionarUsuariosLayout.setHorizontalGroup(
            GestionarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1214, Short.MAX_VALUE)
        );
        GestionarUsuariosLayout.setVerticalGroup(
            GestionarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarUsuariosLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        parent.add(GestionarUsuarios, "card5");

        GestionarClientes.setBackground(new java.awt.Color(255, 255, 255));
        GestionarClientes.setPreferredSize(new java.awt.Dimension(1214, 460));

        btnEditarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzul.png"))); // NOI18N
        btnEditarCliente.setBorderPainted(false);
        btnEditarCliente.setContentAreaFilled(false);
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarCliente.setFocusable(false);
        btnEditarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnEliminarCliente.setToolTipText("Eliminar Especie");
        btnEliminarCliente.setBorderPainted(false);
        btnEliminarCliente.setContentAreaFilled(false);
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarCliente.setFocusable(false);
        btnEliminarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel44.setText("GESTIONAR CLIENTES");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaClientesMouseReleased(evt);
            }
        });
        tablaClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaClientesKeyReleased(evt);
            }
        });
        jScrollPane12.setViewportView(tablaClientes);

        jLabel143.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel143.setText("Nombre Completo:");

        txfNombreClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreClientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreClientesActionPerformed(evt);
            }
        });
        txfNombreClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreClientesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreClientesKeyTyped(evt);
            }
        });

        jLabel144.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel144.setText("Celular:");

        txfCelularClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelularClientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelularClientes.setNextFocusableComponent(TipoComboClientes);
        txfCelularClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCelularClientesActionPerformed(evt);
            }
        });
        txfCelularClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCelularClientesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCelularClientesKeyTyped(evt);
            }
        });

        jLabel146.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel146.setText("ID Cliente:");

        txfIdClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIdClientes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfIdClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdClientesActionPerformed(evt);
            }
        });
        txfIdClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfIdClientesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIdClientesKeyTyped(evt);
            }
        });

        jLabel147.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel147.setText("Buscar:");

        txfBuscarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarClienteKeyTyped(evt);
            }
        });

        btnLimpiarClientes.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarClientes.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarClientes.setBorderPainted(false);
        btnLimpiarClientes.setContentAreaFilled(false);
        btnLimpiarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarClientes.setFocusable(false);
        btnLimpiarClientes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarClientes.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarClientesActionPerformed(evt);
            }
        });

        btnGuardarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardarCliente.setBorderPainted(false);
        btnGuardarCliente.setContentAreaFilled(false);
        btnGuardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarCliente.setEnabled(false);
        btnGuardarCliente.setFocusable(false);
        btnGuardarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnRegistrarCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnRegistrarCliente.setBorderPainted(false);
        btnRegistrarCliente.setContentAreaFilled(false);
        btnRegistrarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarCliente.setFocusable(false);
        btnRegistrarCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        TipoComboClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TipoComboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula de Ciudadanía", "NIT" }));

        jLabel153.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel153.setText("Tipo de Identificación:");

        jLabel9.setText("Recuerde que el Nit lleva guion - ");

        javax.swing.GroupLayout GestionarClientesLayout = new javax.swing.GroupLayout(GestionarClientes);
        GestionarClientes.setLayout(GestionarClientesLayout);
        GestionarClientesLayout.setHorizontalGroup(
            GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarClientesLayout.createSequentialGroup()
                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnLimpiarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GestionarClientesLayout.createSequentialGroup()
                                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TipoComboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel153))
                                .addGap(30, 30, 30)
                                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                                        .addComponent(txfIdClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30))
                                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                                        .addComponent(jLabel146)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel143)
                                    .addComponent(txfNombreClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel144)
                                    .addComponent(txfCelularClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GestionarClientesLayout.createSequentialGroup()
                                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel147)
                                    .addComponent(txfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel44))
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GestionarClientesLayout.setVerticalGroup(
            GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarClientesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addComponent(jLabel144)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCelularClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel146)
                            .addComponent(jLabel153))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TipoComboClientes)
                            .addComponent(txfIdClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                    .addGroup(GestionarClientesLayout.createSequentialGroup()
                        .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel143)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNombreClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel147)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnGuardarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEditarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.add(GestionarClientes, "card4");

        GestionarConductores.setBackground(new java.awt.Color(255, 255, 255));
        GestionarConductores.setPreferredSize(new java.awt.Dimension(1214, 460));

        jLabel45.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel45.setText("GESTIONAR CONDUCTORES");

        btnEditarConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEditarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzul.png"))); // NOI18N
        btnEditarConductor.setBorderPainted(false);
        btnEditarConductor.setContentAreaFilled(false);
        btnEditarConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarConductor.setFocusable(false);
        btnEditarConductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarConductor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarConductorActionPerformed(evt);
            }
        });

        tablaConductores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaConductores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConductoresMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaConductoresMouseReleased(evt);
            }
        });
        tablaConductores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaConductoresKeyReleased(evt);
            }
        });
        jScrollPane13.setViewportView(tablaConductores);

        jLabel148.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel148.setText("Nombre:");

        txfNombreConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreConductorActionPerformed(evt);
            }
        });
        txfNombreConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreConductorKeyTyped(evt);
            }
        });

        jLabel149.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel149.setText("Apellido:");

        txfApellidoConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfApellidoConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfApellidoConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfApellidoConductorActionPerformed(evt);
            }
        });
        txfApellidoConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfApellidoConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfApellidoConductorKeyTyped(evt);
            }
        });

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel150.setText("Celular:");

        txfCelularConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCelularConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCelularConductor.setNextFocusableComponent(txfCedulaConductor);
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

        jLabel151.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel151.setText("ID Conductor:");

        txfCedulaConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCedulaConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel152.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel152.setText("Buscar:");

        txfBuscarConductor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarConductor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarConductorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarConductorKeyTyped(evt);
            }
        });

        btnLimpiarConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarConductor.setBorderPainted(false);
        btnLimpiarConductor.setContentAreaFilled(false);
        btnLimpiarConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarConductor.setFocusable(false);
        btnLimpiarConductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarConductor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConductorActionPerformed(evt);
            }
        });

        btnGuardarConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardarConductor.setBorderPainted(false);
        btnGuardarConductor.setContentAreaFilled(false);
        btnGuardarConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarConductor.setEnabled(false);
        btnGuardarConductor.setFocusable(false);
        btnGuardarConductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarConductor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarConductorActionPerformed(evt);
            }
        });

        btnRegistrarConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnRegistrarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnRegistrarConductor.setBorderPainted(false);
        btnRegistrarConductor.setContentAreaFilled(false);
        btnRegistrarConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarConductor.setFocusable(false);
        btnRegistrarConductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarConductor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarConductorActionPerformed(evt);
            }
        });

        btnEliminarConductor.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarConductor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEliminarConductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnEliminarConductor.setToolTipText("Eliminar Especie");
        btnEliminarConductor.setBorderPainted(false);
        btnEliminarConductor.setContentAreaFilled(false);
        btnEliminarConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarConductor.setFocusable(false);
        btnEliminarConductor.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarConductor.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarConductorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GestionarConductoresLayout = new javax.swing.GroupLayout(GestionarConductores);
        GestionarConductores.setLayout(GestionarConductoresLayout);
        GestionarConductoresLayout.setHorizontalGroup(
            GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarConductoresLayout.createSequentialGroup()
                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarConductoresLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnLimpiarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnGuardarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnRegistrarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GestionarConductoresLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GestionarConductoresLayout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(jLabel45))
                            .addGroup(GestionarConductoresLayout.createSequentialGroup()
                                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GestionarConductoresLayout.createSequentialGroup()
                                        .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel151)
                                            .addComponent(txfCedulaConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel148)
                                            .addComponent(txfNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GestionarConductoresLayout.createSequentialGroup()
                                        .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel152)
                                            .addComponent(txfBuscarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel149)
                                    .addComponent(txfApellidoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel150)
                                    .addComponent(txfCelularConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(GestionarConductoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        GestionarConductoresLayout.setVerticalGroup(
            GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarConductoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GestionarConductoresLayout.createSequentialGroup()
                            .addComponent(jLabel150)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfCelularConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GestionarConductoresLayout.createSequentialGroup()
                            .addComponent(jLabel149)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfApellidoConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GestionarConductoresLayout.createSequentialGroup()
                            .addComponent(jLabel151)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfCedulaConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GestionarConductoresLayout.createSequentialGroup()
                        .addComponent(jLabel148)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNombreConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel152)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfBuscarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarConductor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(GestionarConductoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarConductor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarConductor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.add(GestionarConductores, "card4");

        GestionarEspecies.setBackground(new java.awt.Color(255, 255, 255));
        GestionarEspecies.setPreferredSize(new java.awt.Dimension(1214, 460));

        jLabel36.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel36.setText("GESTIONAR ESPECIES");

        btnEditarEsp.setBackground(new java.awt.Color(255, 255, 255));
        btnEditarEsp.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEditarEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzul.png"))); // NOI18N
        btnEditarEsp.setBorderPainted(false);
        btnEditarEsp.setContentAreaFilled(false);
        btnEditarEsp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditarEsp.setFocusable(false);
        btnEditarEsp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarEsp.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/editarAzulOscuro.png"))); // NOI18N
        btnEditarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEspActionPerformed(evt);
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
        jScrollPane11.setViewportView(tablaEspecies);

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel119.setText("Nombre Común:");

        txfNombreComun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreComun.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreComun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreComunActionPerformed(evt);
            }
        });
        txfNombreComun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreComunKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreComunKeyTyped(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel121.setText("Familia:");

        txfFamilia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfFamilia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfFamiliaActionPerformed(evt);
            }
        });
        txfFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfFamiliaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfFamiliaKeyTyped(evt);
            }
        });

        jLabel133.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel133.setText("Msnm:");

        txfMsnm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfMsnm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfMsnm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMsnmActionPerformed(evt);
            }
        });
        txfMsnm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfMsnmKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfMsnmKeyTyped(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel134.setText("Nombre de Científico:");

        txfNombreCien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreCien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreCien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreCienActionPerformed(evt);
            }
        });
        txfNombreCien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreCienKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreCienKeyTyped(evt);
            }
        });

        jLabel135.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel135.setText("Buscar:");

        txfBuscarEsp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarEsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarEsp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarEspKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarEspKeyTyped(evt);
            }
        });

        btnLimpiarEsp.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarEsp.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarEsp.setBorderPainted(false);
        btnLimpiarEsp.setContentAreaFilled(false);
        btnLimpiarEsp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarEsp.setFocusable(false);
        btnLimpiarEsp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarEsp.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarEspActionPerformed(evt);
            }
        });

        btnGuardarEsp.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarEsp.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnGuardarEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzul.png"))); // NOI18N
        btnGuardarEsp.setBorderPainted(false);
        btnGuardarEsp.setContentAreaFilled(false);
        btnGuardarEsp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardarEsp.setEnabled(false);
        btnGuardarEsp.setFocusable(false);
        btnGuardarEsp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarEsp.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/guardarAzulOscuro.png"))); // NOI18N
        btnGuardarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEspActionPerformed(evt);
            }
        });

        btnRegistrarEsp.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarEsp.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnRegistrarEsp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzul.png"))); // NOI18N
        btnRegistrarEsp.setBorderPainted(false);
        btnRegistrarEsp.setContentAreaFilled(false);
        btnRegistrarEsp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarEsp.setFocusable(false);
        btnRegistrarEsp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarEsp.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/registrarAzulOscuro.png"))); // NOI18N
        btnRegistrarEsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEspActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("N°");

        lblNumeroEspecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnEliminarEspecie.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarEspecie.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnEliminarEspecie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnEliminarEspecie.setToolTipText("Eliminar Especie");
        btnEliminarEspecie.setBorderPainted(false);
        btnEliminarEspecie.setContentAreaFilled(false);
        btnEliminarEspecie.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarEspecie.setFocusable(false);
        btnEliminarEspecie.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarEspecie.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnEliminarEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEspecieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GestionarEspeciesLayout = new javax.swing.GroupLayout(GestionarEspecies);
        GestionarEspecies.setLayout(GestionarEspeciesLayout);
        GestionarEspeciesLayout.setHorizontalGroup(
            GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(btnLimpiarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEditarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnGuardarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnRegistrarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(6, 6, 6)
                                .addComponent(lblNumeroEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(243, 243, 243)
                                .addComponent(jLabel36))
                            .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                                        .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfNombreCien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel134))
                                        .addGap(30, 30, 30)
                                        .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel119)
                                            .addComponent(txfNombreComun, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel135)
                                    .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                                        .addComponent(txfBuscarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel121)
                                    .addComponent(txfFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel133)
                                    .addComponent(txfMsnm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        GestionarEspeciesLayout.setVerticalGroup(
            GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel36)
                    .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel19))
                        .addComponent(lblNumeroEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GestionarEspeciesLayout.createSequentialGroup()
                            .addComponent(jLabel133)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfMsnm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                            .addComponent(jLabel121)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                            .addComponent(jLabel134)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfNombreCien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GestionarEspeciesLayout.createSequentialGroup()
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfNombreComun, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel135)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfBuscarEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(GestionarEspeciesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpiarEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarEsp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parent.add(GestionarEspecies, "card4");

        Reservas.setBackground(new java.awt.Color(255, 255, 255));
        Reservas.setPreferredSize(new java.awt.Dimension(1214, 460));
        Reservas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ReservasFocusLost(evt);
            }
        });
        Reservas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                ReservasComponentHidden(evt);
            }
        });
        Reservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuReserva.setFocusable(false);
        MenuReserva.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MenuReservaStateChanged(evt);
            }
        });

        Reservar.setBackground(new java.awt.Color(255, 255, 255));
        Reservar.setPreferredSize(new java.awt.Dimension(1214, 633));

        jLabel51.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel51.setText("RESERVAS");

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaReservasMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaReservasMouseReleased(evt);
            }
        });
        tablaReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaReservasKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tablaReservas);

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel95.setText("Nit/Cédula:");

        txfIdentificacionReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIdentificacionReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfIdentificacionReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIdentificacionReservasActionPerformed(evt);
            }
        });
        txfIdentificacionReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfIdentificacionReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIdentificacionReservasKeyTyped(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel96.setText("Nombre Completo:");

        txfNombreReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreReservasKeyTyped(evt);
            }
        });

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel97.setText("Teléfono:");

        txfTelefonoReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfTelefonoReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfTelefonoReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTelefonoReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefonoReservasKeyTyped(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel98.setText("Tipo de Identificación:");

        btnLimpiarReserva.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarReserva.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarReserva.setBorderPainted(false);
        btnLimpiarReserva.setContentAreaFilled(false);
        btnLimpiarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarReserva.setFocusable(false);
        btnLimpiarReserva.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarReserva.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarReservaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarReserva.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCancelarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojo.png"))); // NOI18N
        btnCancelarReserva.setBorderPainted(false);
        btnCancelarReserva.setContentAreaFilled(false);
        btnCancelarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelarReserva.setFocusable(false);
        btnCancelarReserva.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelarReserva.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        btnSeleccionarEspecieReservas.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        btnSeleccionarEspecieReservas.setBorderPainted(false);
        btnSeleccionarEspecieReservas.setEnabled(false);
        btnSeleccionarEspecieReservas.setFocusPainted(false);
        btnSeleccionarEspecieReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieReservasActionPerformed(evt);
            }
        });

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel102.setText("Especie:");

        txfEspecieReservas.setEditable(false);
        txfEspecieReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfEspecieReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfEspecieReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfEspecieReservasKeyReleased(evt);
            }
        });

        btnQuitar1.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitar1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnQuitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnQuitar1.setBorderPainted(false);
        btnQuitar1.setContentAreaFilled(false);
        btnQuitar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuitar1.setFocusable(false);
        btnQuitar1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitar1ActionPerformed(evt);
            }
        });

        IdentificacionCombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        IdentificacionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cédula de Ciudadanía", "NIT" }));
        IdentificacionCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IdentificacionComboItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("N°");

        lblNumeroReserva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnNuevoCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoCliente.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoCliente.setBorderPainted(false);
        btnNuevoCliente.setContentAreaFilled(false);
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevoCliente.setFocusable(false);
        btnNuevoCliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoCliente.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/add-group.png"))); // NOI18N
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        txfCantidadReservas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txfCantidadReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCantidadReservas.setEnabled(false);
        txfCantidadReservas.setNextFocusableComponent(txfCodigoPlantaReservas);
        txfCantidadReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadReservasActionPerformed(evt);
            }
        });
        txfCantidadReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCantidadReservasKeyTyped(evt);
            }
        });

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel103.setText("Cantidad:");

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel100.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTotal.setText("0");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        btnReservar.setBackground(new java.awt.Color(255, 255, 255));
        btnReservar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnReservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReservarAzul.png"))); // NOI18N
        btnReservar.setBorderPainted(false);
        btnReservar.setContentAreaFilled(false);
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReservar.setFocusable(false);
        btnReservar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReservarAzulOscuro.png"))); // NOI18N
        btnReservar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnReservarAzulOscuro.png"))); // NOI18N
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel111.setText("Código planta:");

        txfCodigoPlantaReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoPlantaReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoPlantaReservas.setEnabled(false);
        txfCodigoPlantaReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoPlantaReservasActionPerformed(evt);
            }
        });
        txfCodigoPlantaReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCodigoPlantaReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoPlantaReservasKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("disponibles: ");

        javax.swing.GroupLayout ReservarLayout = new javax.swing.GroupLayout(Reservar);
        Reservar.setLayout(ReservarLayout);
        ReservarLayout.setHorizontalGroup(
            ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservarLayout.createSequentialGroup()
                .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ReservarLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jLabel11)
                            .addGap(6, 6, 6)
                            .addComponent(lblNumeroReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(116, 116, 116)
                            .addComponent(jLabel51))
                        .addGroup(ReservarLayout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel98)
                                .addComponent(IdentificacionCombo, 0, 210, Short.MAX_VALUE)
                                .addComponent(jLabel111)
                                .addComponent(txfCodigoPlantaReservas))
                            .addGap(30, 30, 30)
                            .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ReservarLayout.createSequentialGroup()
                                    .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel95)
                                        .addComponent(txfIdentificacionReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29)
                                    .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txfNombreReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel96))
                                    .addGap(30, 30, 30)
                                    .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel97)
                                        .addGroup(ReservarLayout.createSequentialGroup()
                                            .addComponent(txfTelefonoReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(ReservarLayout.createSequentialGroup()
                                    .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ReservarLayout.createSequentialGroup()
                                            .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(ReservarLayout.createSequentialGroup()
                                                    .addComponent(jLabel102)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(btnSeleccionarEspecieReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(ReservarLayout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lblDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(ReservarLayout.createSequentialGroup()
                                            .addComponent(txfEspecieReservas)
                                            .addGap(31, 31, 31)))
                                    .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel103)
                                        .addGroup(ReservarLayout.createSequentialGroup()
                                            .addComponent(txfCantidadReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(btnQuitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(ReservarLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jLabel100)
                            .addGap(6, 6, 6)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(btnReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btnLimpiarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(348, 348, 348))
        );
        ReservarLayout.setVerticalGroup(
            ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ReservarLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11))
                    .addComponent(lblNumeroReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ReservarLayout.createSequentialGroup()
                        .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jLabel98)
                            .addComponent(jLabel95)
                            .addComponent(jLabel97))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoCliente)
                            .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txfTelefonoReservas, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(IdentificacionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfIdentificacionReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfNombreReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ReservarLayout.createSequentialGroup()
                                .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ReservarLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel102))
                                    .addComponent(btnSeleccionarEspecieReservas))
                                .addGap(6, 6, 6)
                                .addComponent(txfEspecieReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReservarLayout.createSequentialGroup()
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txfCodigoPlantaReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ReservarLayout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addGap(6, 6, 6)
                        .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCantidadReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReservarLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel100)
                            .addComponent(lblTotal)))
                    .addGroup(ReservarLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(ReservarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiarReserva)
                            .addComponent(btnCancelarReserva)
                            .addComponent(btnReservar))))
                .addGap(359, 359, 359))
        );

        MenuReserva.addTab("Reservar", Reservar);

        ConsultarReserva.setBackground(new java.awt.Color(255, 255, 255));
        ConsultarReserva.setPreferredSize(new java.awt.Dimension(1214, 633));

        jLabel52.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jLabel52.setText("CONSULTAR RESERVAS");

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel101.setText("Buscar por NIT o código de reserva:");

        txfBuscarConsultarReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfBuscarConsultarReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfBuscarConsultarReservas.setToolTipText("Busque por NIT, Cédula o Código de reserva, y presione ENTER.");
        txfBuscarConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfBuscarConsultarReservasActionPerformed(evt);
            }
        });
        txfBuscarConsultarReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfBuscarConsultarReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfBuscarConsultarReservasKeyTyped(evt);
            }
        });

        txfCodigoReserva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCodigoReserva.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfCodigoReserva.setEnabled(false);
        txfCodigoReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoReservaActionPerformed(evt);
            }
        });
        txfCodigoReserva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfCodigoReservaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfCodigoReservaKeyTyped(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel104.setText("Código Reserva:");

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel105.setText("Nombre Cliente:");

        txfNombreConsultarReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfNombreConsultarReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfNombreConsultarReservas.setEnabled(false);
        txfNombreConsultarReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfNombreConsultarReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNombreConsultarReservasKeyTyped(evt);
            }
        });

        tablaConsultarReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre Vulgar", "Nombre Científico", "Rango", "Tamaño de Bolsa", "Cantidad", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaConsultarReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaConsultarReservasMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaConsultarReservasMouseReleased(evt);
            }
        });
        tablaConsultarReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaConsultarReservasKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tablaConsultarReservas);

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel106.setText("Total:");

        lblTotalConsultarReservas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTotalConsultarReservas.setText("0");
        lblTotalConsultarReservas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txfTelefonoConsultarReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfTelefonoConsultarReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfTelefonoConsultarReservas.setEnabled(false);
        txfTelefonoConsultarReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfTelefonoConsultarReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefonoConsultarReservasKeyTyped(evt);
            }
        });

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel107.setText("Teléfono:");

        txfIdentificacionConsultarReservas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfIdentificacionConsultarReservas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfIdentificacionConsultarReservas.setEnabled(false);
        txfIdentificacionConsultarReservas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfIdentificacionConsultarReservasKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfIdentificacionConsultarReservasKeyTyped(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel108.setText("NIT/Cédula:");

        btnLimpiarConsultarReservas.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiarConsultarReservas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnLimpiarConsultarReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzul.png"))); // NOI18N
        btnLimpiarConsultarReservas.setBorderPainted(false);
        btnLimpiarConsultarReservas.setContentAreaFilled(false);
        btnLimpiarConsultarReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLimpiarConsultarReservas.setFocusable(false);
        btnLimpiarConsultarReservas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarConsultarReservas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/limpiarAzulOscuro.png"))); // NOI18N
        btnLimpiarConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarConsultarReservasActionPerformed(evt);
            }
        });

        btnCancelarConsultarReservas.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelarConsultarReservas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCancelarConsultarReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojo.png"))); // NOI18N
        btnCancelarConsultarReservas.setBorderPainted(false);
        btnCancelarConsultarReservas.setContentAreaFilled(false);
        btnCancelarConsultarReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelarConsultarReservas.setFocusable(false);
        btnCancelarConsultarReservas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelarConsultarReservas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btnCancelarRojoOscuro.png"))); // NOI18N
        btnCancelarConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarConsultarReservasActionPerformed(evt);
            }
        });

        btnQuitarConsultarReservas.setBackground(new java.awt.Color(255, 255, 255));
        btnQuitarConsultarReservas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnQuitarConsultarReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar.png"))); // NOI18N
        btnQuitarConsultarReservas.setBorderPainted(false);
        btnQuitarConsultarReservas.setContentAreaFilled(false);
        btnQuitarConsultarReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuitarConsultarReservas.setFocusable(false);
        btnQuitarConsultarReservas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitarConsultarReservas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Quitar2.0.png"))); // NOI18N
        btnQuitarConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarConsultarReservasActionPerformed(evt);
            }
        });

        btnAgregarConsultarReservas.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarConsultarReservas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnAgregarConsultarReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar1.png"))); // NOI18N
        btnAgregarConsultarReservas.setBorderPainted(false);
        btnAgregarConsultarReservas.setContentAreaFilled(false);
        btnAgregarConsultarReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarConsultarReservas.setFocusable(false);
        btnAgregarConsultarReservas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregarConsultarReservas.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Agregar2.png"))); // NOI18N
        btnAgregarConsultarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarConsultarReservasActionPerformed(evt);
            }
        });

        btnSeleccionarEspecieReservas4.setBackground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas4.setForeground(new java.awt.Color(77, 123, 179));
        btnSeleccionarEspecieReservas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar1.png"))); // NOI18N
        btnSeleccionarEspecieReservas4.setBorderPainted(false);
        btnSeleccionarEspecieReservas4.setContentAreaFilled(false);
        btnSeleccionarEspecieReservas4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSeleccionarEspecieReservas4.setFocusable(false);
        btnSeleccionarEspecieReservas4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar2.png"))); // NOI18N
        btnSeleccionarEspecieReservas4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/buscar2.png"))); // NOI18N
        btnSeleccionarEspecieReservas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarEspecieReservas4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultarReservaLayout = new javax.swing.GroupLayout(ConsultarReserva);
        ConsultarReserva.setLayout(ConsultarReservaLayout);
        ConsultarReservaLayout.setHorizontalGroup(
            ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarReservaLayout.createSequentialGroup()
                .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel52))
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel104)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel108)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel105)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel107))
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(txfCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txfIdentificacionConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txfNombreConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txfTelefonoConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel106)
                        .addGap(6, 6, 6)
                        .addComponent(lblTotalConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(btnLimpiarConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnCancelarConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsultarReservaLayout.createSequentialGroup()
                .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel101)
                            .addGroup(ConsultarReservaLayout.createSequentialGroup()
                                .addComponent(txfBuscarConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionarEspecieReservas4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnQuitarConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(365, 365, 365))
        );
        ConsultarReservaLayout.setVerticalGroup(
            ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarReservaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel104)
                    .addComponent(jLabel108)
                    .addComponent(jLabel105)
                    .addComponent(jLabel107))
                .addGap(11, 11, 11)
                .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfCodigoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfIdentificacionConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombreConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefonoConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addGap(6, 6, 6)
                        .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSeleccionarEspecieReservas4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfBuscarConsultarReservas)))
                    .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregarConsultarReservas)
                        .addComponent(btnQuitarConsultarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106)
                    .addComponent(lblTotalConsultarReservas)
                    .addGroup(ConsultarReservaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(ConsultarReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpiarConsultarReservas)
                            .addComponent(btnCancelarConsultarReservas)))))
        );

        MenuReserva.addTab("Consultar", ConsultarReserva);

        Reservas.add(MenuReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        parent.add(Reservas, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(side_pane, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(parent, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(side_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(parent, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MousePressed
        // TODO add your handling code here:
        if (verificarSalida()) {
            setColor(btn_1);
            ind_1.setOpaque(true);
            resetColor(new JPanel[]{btn_2, btn_5, btn_6, btn_7, btn_10, btn_11, btn_12, btn_13}, new JPanel[]{ind_2, ind_5, ind_6, ind_7, ind_10, ind_11, ind_12, ind_13});
            parent.removeAll();
            parent.add(PerfilGerente);
            parent.repaint();
            parent.revalidate();
            lblNumUsuarios.setText(numUsuarios());

            lblNumSalidas.setText(numSalidas(mesActual(), añoActual()));
            lblNumVentas.setText(numVentas(mesActual(), añoActual()));
            mostrarProductosAgotados();
        } else {

        }
    }//GEN-LAST:event_btn_1MousePressed

    private void btn_2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MousePressed
        // TODO add your handling code here:
        if (verificarSalida()) {
            setColor(btn_2);
            ind_2.setOpaque(true);
            resetColor(new JPanel[]{btn_1, btn_5, btn_6, btn_7, btn_10, btn_11, btn_12, btn_13}, new JPanel[]{ind_1, ind_5, ind_6, ind_7, ind_10, ind_11, ind_12, ind_13});
            parent.removeAll();
            parent.add(GestionarUsuarios);
            parent.repaint();
            parent.revalidate();
            desactivarCamposCUsuario();
        } else {

        }
    }//GEN-LAST:event_btn_2MousePressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged

    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        //drag this pane

    }//GEN-LAST:event_jPanel2MousePressed

    private void SignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignOutActionPerformed
        login = new Login();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_SignOutActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed

        Usuario_ u;

        if (txfUsuario.getText().trim().length() == 0 || txfNombre.getText().trim().length() == 0
                || txfApellido.getText().trim().length() == 0 || txfDireccion.getText().trim().length() == 0 || txfCrearContraseña.getText().trim().length() == 0) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

        } else {

            if (txfCelular.getText().trim().length() != 10) {

                JOptionPane.showMessageDialog(null, "Ingrese un número de celular válido.");

            } else {

                try {

                    String usuario = txfUsuario.getText().trim();
                    rs = uDao.buscar(usuario);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario con este nombre de usuario, registre uno nuevo por favor.");
                    } else {
                        String nombre = txfNombre.getText().trim();
                        String apellido = txfApellido.getText().trim();
                        String celular = txfCelular.getText().trim();
                        String direccion = txfDireccion.getText().trim();
                        String contraseña = txfCrearContraseña.getText();
                        u = new Usuario_(usuario, contraseña, Cargo_.ENCARGADO, nombre, apellido, celular, direccion, Estado_.ACTIVO);

                        if (uDao.CrearUsuario(u)) {

                            JOptionPane.showMessageDialog(null, "Usuario creado correctamente.");

                            limpiarRUsuario();
                        } else {

                            JOptionPane.showMessageDialog(null, "No se ha creado el usuario, verifique que la información esté completa.");

                        }
                    }
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Error, verifique e inténtelo nuevamente.");
                }

            }
        }
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnEditarCUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCUActionPerformed

        if (txfUsuario1.getText().length() == 0) {

        } else {
            activarCamposCUsuario();
            this.txfUsuario1.setEditable(false);
            this.btnEditarCU.setEnabled(false);
            this.btnGuardarCU.setEnabled(true);
            this.txfEditarContraseñaUsuario.setVisible(true);
            this.jLabel69.setVisible(true);
        }

        if (tablaUsuarios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(tablaUsuarios, "Seleccione un usuario primero ");
        } else {
            if (tablaUsuarios.getValueAt(0, 0).equals("Sin resultados...")) {
                JOptionPane.showMessageDialog(tablaUsuarios, "Seleccione un usuario valido ");
            }
        }


    }//GEN-LAST:event_btnEditarCUActionPerformed

    private void txfUsuario1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuario1KeyReleased


    }//GEN-LAST:event_txfUsuario1KeyReleased

    private void setColor(JPanel pane) {
        pane.setBackground(new Color(41, 57, 80));
    }

    private void resetColor(JPanel[] pane, JPanel[] indicators) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(0, 0, 0));

        }
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }

    }

    private void resetColor1(JPanel panel) {

        panel.setBackground(new Color(0, 0, 0));

    }


    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked

        this.setExtendedState(ICONIFIED);

    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnCerrar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrar1MouseClicked

        if (Salidas.isShowing() && tablaSalidas.getRowCount() != 0) {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea descartar la salida?" + "\n" + "Recuerde que debe dar click en el botón 'Registrar' para confirmar la salida.", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {

                cancelarSalida();
                System.exit(0);

            } else {

            }

        } else if (TrasplantadoPanel.isShowing() && txfEspecieTrasplantado.getText().length() != 0) {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea descartar la salida?" + "\n" + "Recuerde que debe dar click en el botón 'Registrar' para confirmar la salida.", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {

                cancelarSalida();
                System.exit(0);

            } else {

            }

        } else {

            System.exit(0);

        }


    }//GEN-LAST:event_btnCerrar1MouseClicked

    private void txfNombre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombre1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombre1KeyReleased

    private void txfApellido1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellido1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfApellido1KeyReleased

    private void txfCelular1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelular1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelular1KeyReleased

    private void txfDireccion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDireccion1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDireccion1KeyReleased

    private void txfBuscarUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarUsuariosKeyReleased

        if (txfBuscarUsuarios.getText().length() == 0) {

            limpiarTablaUsuarios();

        } else {

            listarUsuarios();
        }
    }//GEN-LAST:event_txfBuscarUsuariosKeyReleased

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked

        if (tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1 && estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("ACTIVOS")) {

                seleccionarUsuario();

            } else if (evt.getClickCount() == 1 && estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("INACTIVOS")) {

                seleccionarUsuario();
                this.btnEditarCU.setEnabled(false);

            } else if (evt.getClickCount() == 2 && estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("INACTIVOS")) {

                activarUsuario();

            }
        }

    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarUsuario();
        limpiarTablaUsuarios();
        desactivarCamposCUsuario();
        this.btnGuardarCU.setEnabled(false);
        this.btnEditarCU.setEnabled(true);

    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarCUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCUActionPerformed

        if (txfUsuario1.getText().trim().length() == 0 || txfNombre1.getText().trim().length() == 0 || txfApellido1.getText().trim().length() == 0
                || txfDireccion1.getText().trim().length() == 0 || txfEditarContraseñaUsuario.getText().trim().length() == 0) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

        } else {

            if (txfCelular1.getText().trim().length() != 10) {

                JOptionPane.showMessageDialog(null, "Ingrese un número de celular válido.");

            } else {

                try {

                    String usuario = txfUsuario1.getText().trim();
                    String nombre = txfNombre1.getText().trim();
                    String apellido = txfApellido1.getText().trim();
                    long celular = Long.parseLong(txfCelular1.getText());
                    String direccion = txfDireccion1.getText().trim();
                    String contraseña = txfEditarContraseñaUsuario.getText().trim();

                    if (uDao.actualizar(usuario, contraseña, nombre, apellido, celular, direccion)) {
                        JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
                        this.btnEditarCU.setEnabled(true);
                        this.btnGuardarCU.setEnabled(false);
                        buscarUsuario(usuario);
                        limpiarUsuario();
                        limpiarTablaUsuarios();
                        desactivarCamposCUsuario();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo actualizar, inténtelo nuevamente.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }

    }//GEN-LAST:event_btnGuardarCUActionPerformed

    private void tablaUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseReleased

        if (tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1 && estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("ACTIVOS")) {

                seleccionarUsuario();

            } else if (evt.getClickCount() == 1 && estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("INACTIVOS")) {

                seleccionarUsuario();
                this.btnEditarCU.setEnabled(false);

            } else if (evt.getClickCount() == 2 && estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("INACTIVOS")) {

                activarUsuario();

            }
        }
    }//GEN-LAST:event_tablaUsuariosMouseReleased

    private void txfBuscarUsuariosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarUsuariosKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

    }//GEN-LAST:event_txfBuscarUsuariosKeyTyped

    private void estadoComboCUItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_estadoComboCUItemStateChanged

        if (estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("ACTIVOS")) {

            desactivarCamposCUsuario();
            this.btnDesactivar.setEnabled(true);
            this.btnEditarCU.setEnabled(true);
            this.btnGuardarCU.setEnabled(false);
            this.btnLimpiar.setEnabled(true);
            this.txfBuscarUsuarios.setEnabled(true);
            MensajeIndicador.setVisible(false);
            limpiarTablaUsuarios();
            limpiarUsuario();
            tablaUsuarios.setForeground(Color.black);

        } else {

            if (estadoComboCU.getItemAt(estadoComboCU.getSelectedIndex()).equalsIgnoreCase("INACTIVOS")) {

                mostrarUsuariosInactivos();
                desactivarCamposCUsuario();
                this.btnDesactivar.setEnabled(false);
                this.btnEditarCU.setEnabled(false);
                this.btnGuardarCU.setEnabled(false);
                this.btnLimpiar.setEnabled(false);
                this.txfBuscarUsuarios.setEnabled(false);
                MensajeIndicador.setVisible(true);
                limpiarUsuario();
            }

        }

    }//GEN-LAST:event_estadoComboCUItemStateChanged

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed

        desactivarUsuario();
        desactivarCamposCUsuario();

    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void btn_5consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5consultarEmpleados

        try {

            if (verificarSalida()) {
                setColor(btn_5);
                ind_5.setOpaque(true);
                resetColor(new JPanel[]{btn_1, btn_2, btn_6, btn_7, btn_10, btn_11, btn_12, btn_13}, new JPanel[]{ind_1, ind_2, ind_6, ind_7, ind_10, ind_11, ind_12, ind_13});
                parent.removeAll();
                parent.add(AlimentarInventario);
                parent.repaint();
                parent.revalidate();
                java.util.Date fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
                fechaIngreso.setDate(fechaParseada);
                fechaDesde.setDate(fechaParseada);
                fechaHasta.setDate(fechaParseada);
                buscarIngresosFecha(fechaActual(), fechaActual());
                limpiarIngresarEspecie();
                activarCamposAlimentarInventario();
                btnSeleccionarEspecie.setEnabled(true);
                btnGuardarAlimentarInventario.setEnabled(false);
                tamanoCombo.setEnabled(true);
                rangoCombo.setEnabled(true);

            } else {

            }
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_btn_5consultarEmpleados

    private void btn_5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_5MousePressed

    private void btn_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_2MouseClicked

    private void btn_6consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6consultarEmpleados

        reiniciarInventario();

        if (verificarSalida()) {
            setColor(btn_6);
            ind_6.setOpaque(true);
            resetColor(new JPanel[]{btn_1, btn_2, btn_5, btn_7, btn_10, btn_11, btn_12, btn_13}, new JPanel[]{ind_1, ind_2, ind_5, ind_7, ind_10, ind_11, ind_12, ind_13});
            parent.removeAll();
            parent.add(Inventario);
            parent.repaint();
            parent.revalidate();
            txfBuscarInventario.requestFocus();
        } else {

        }
    }//GEN-LAST:event_btn_6consultarEmpleados

    private void btn_6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_6MousePressed

    private void txfEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieKeyReleased

    private void btnLimpiarAlimentarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarAlimentarInventarioActionPerformed

        activarCamposAlimentarInventario();
        btnSeleccionarEspecie.setEnabled(true);
        btnGuardarAlimentarInventario.setEnabled(false);
        tamanoCombo.setEnabled(true);
        rangoCombo.setEnabled(true);
        limpiarIngresarEspecie();

    }//GEN-LAST:event_btnLimpiarAlimentarInventarioActionPerformed

    private void btnIngresarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarEspecieActionPerformed

        ingresarEspecie();

    }//GEN-LAST:event_btnIngresarEspecieActionPerformed

    private void txfBuscarEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarEspecieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarEspecieKeyReleased

    private void btnLimpiarProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProveedor2ActionPerformed

        buscarIngreso();

    }//GEN-LAST:event_btnLimpiarProveedor2ActionPerformed

    private void txfUsuario1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuario1KeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isSpaceChar(c)) {

            evt.consume();

        }

        if (txfUsuario1.getText().length() > 14) {

            evt.consume();

        }

    }//GEN-LAST:event_txfUsuario1KeyTyped

    private void txfNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombre1KeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (txfNombre1.getText().length() > 14) {

            evt.consume();
        }

    }//GEN-LAST:event_txfNombre1KeyTyped

    private void txfApellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellido1KeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (txfApellido1.getText().length() > 19) {

            evt.consume();
        }


    }//GEN-LAST:event_txfApellido1KeyTyped

    private void txfCelular1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelular1KeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCelular1.getText().length() > 9) {

            evt.consume();

        }

    }//GEN-LAST:event_txfCelular1KeyTyped

    private void txfDireccion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDireccion1KeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (txfDireccion1.getText().length() > 29) {

            evt.consume();

        }


    }//GEN-LAST:event_txfDireccion1KeyTyped

    private void txfUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfUsuarioKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isSpaceChar(c)) {

            evt.consume();

        }

        if (txfUsuario.getText().length() > 14) {

            evt.consume();

        }

    }//GEN-LAST:event_txfUsuarioKeyTyped

    private void txfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

        if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombre.getText().length() > 14) {

            evt.consume();

        }

    }//GEN-LAST:event_txfNombreKeyTyped

    private void txfApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

        if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfApellido.getText().length() > 19) {

            evt.consume();

        }

    }//GEN-LAST:event_txfApellidoKeyTyped

    private void txfCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCelular.getText()
                .length() > 9) {

            evt.consume();

        }

    }//GEN-LAST:event_txfCelularKeyTyped

    private void txfDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfDireccionKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

        if (txfDireccion.getText().length() > 29) {

            evt.consume();

        }

    }//GEN-LAST:event_txfDireccionKeyTyped

    private void txfBuscarEspecieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarEspecieKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

        if (txfBuscarEspecie.getText().length() >= 29) {
            evt.consume();
        }
    }//GEN-LAST:event_txfBuscarEspecieKeyTyped

    private void btnSeleccionarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieActionPerformed

        reiniciarSeleccionarEspecie();
        ventanaEspecies.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarEspecieActionPerformed

    private void txfCantidadIngresarEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadIngresarEspecieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadIngresarEspecieKeyReleased

    private void txfCantidadIngresarEspecieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadIngresarEspecieKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {

            evt.consume();

        }
        if (txfCantidadIngresarEspecie.getText().length() >= 6) {
            evt.consume();
        }


    }//GEN-LAST:event_txfCantidadIngresarEspecieKeyTyped

    private void tamanoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tamanoComboItemStateChanged

        switch (tamanoCombo.getSelectedIndex()) {
            case 0:
                rangoCombo.removeAllItems();
                rangoCombo.addItem("<20 cm");
                rangoCombo.addItem("40-60 cm");
                rangoCombo.addItem(">60 cm");
                break;
            case 1:
                rangoCombo.removeAllItems();
                rangoCombo.addItem("<60 cm");
                rangoCombo.addItem("60-100 cm");
                rangoCombo.addItem("100-150 cm");
                break;
            default:
                break;
        }

        consultarEspecie();


    }//GEN-LAST:event_tamanoComboItemStateChanged

    private void tablaInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventarioMouseClicked


    }//GEN-LAST:event_tablaInventarioMouseClicked

    private void tablaInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInventarioMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaInventarioMouseReleased

    private void tablaInventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaInventarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaInventarioKeyReleased

    private void txfBuscarInventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarInventarioKeyReleased

        if (txfBuscarInventario.getText().length() == 0) {

            limpiarTablaInventario();

        } else {

            buscarEspecieInventario();
        }


    }//GEN-LAST:event_txfBuscarInventarioKeyReleased

    private void txfBuscarInventarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarInventarioKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

    }//GEN-LAST:event_txfBuscarInventarioKeyTyped

    private void rangoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rangoComboItemStateChanged

        consultarEspecie();

    }//GEN-LAST:event_rangoComboItemStateChanged

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed

        ventanaExcel.setVisible(true);

    }//GEN-LAST:event_btnDescargarActionPerformed

    private void btn_7consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7consultarEmpleados

        if (verificarSalida()) {
            try {
                setColor(btn_7);
                ind_7.setOpaque(true);
                resetColor(new JPanel[]{btn_1, btn_2, btn_5, btn_6, btn_10, btn_11, btn_12, btn_13}, new JPanel[]{ind_1, ind_2, ind_5, ind_6, ind_10, ind_11, ind_12, ind_13});
                parent.removeAll();
                parent.add(Salidas);
                parent.repaint();
                parent.revalidate();
                txfCodigoSalida.requestFocus();
                txfCodigoSalida.repaint();
                java.util.Date fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
                fechaSalida.setDate(fechaParseada);
                max_salida = MAXSalida();
                txfConvenio.setText(convenio());
            } catch (ParseException ex) {
            }
        } else {

        }


    }//GEN-LAST:event_btn_7consultarEmpleados

    private void btn_7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MousePressed
        motivoCombo.requestFocus();
    }//GEN-LAST:event_btn_7MousePressed

    private void tablaSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseClicked


    }//GEN-LAST:event_tablaSalidasMouseClicked

    private void tablaSalidasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidasMouseReleased

    private void tablaSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidasKeyReleased

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

    private void btnCancelarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSalidaActionPerformed

        if (TrasplantadoPanel.isShowing()) {
            cancelarTrasplantado();
        } else {
            cancelarSalida();
        }

    }//GEN-LAST:event_btnCancelarSalidaActionPerformed

    private void motivoComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_motivoComboItemStateChanged

        switch (motivoCombo.getSelectedIndex()) {
            case 0:
                txfConvenio.setEditable(true);
                txfDestino.setEditable(true);
                txfPredio.setEditable(true);
                txfCorregimiento.setEditable(true);
                txfConvenio.setEditable(true);
                cbEntregaParcial.setEnabled(true);
                txfConvenio.setText(convenio());
                break;
            case 4:
                txfConvenio.setEditable(true);
                txfDestino.setEditable(true);
                txfPredio.setEditable(true);
                txfCorregimiento.setEditable(true);
                txfConvenio.setEditable(false);
                cbEntregaParcial.setEnabled(true);
                break;
            case 1:
                txfConvenio.setEditable(true);
                txfDestino.setEditable(true);
                txfPredio.setEditable(true);
                txfCorregimiento.setEditable(true);
                cbEntregaParcial.setEnabled(true);
                break;
            case 2:
            case 3:
                txfConvenio.setEditable(false);
                txfDestino.setEditable(false);
                txfCorregimiento.setEditable(false);
                txfPredio.setEditable(false);
                cbEntregaParcial.setSelected(false);
                cbEntregaParcial.setEnabled(false);
                txfParcial.setText(null);
                break;
            default:
                break;
        }

        switch (motivoCombo.getSelectedIndex()) {
            case 0:
                if (txfCodigoSalida.getText().contains("T") || txfCodigoSalida.getText().contains("P")) {
                    txfCodigoSalida.setText(null);
                    txfCodigoSalida2.setText(Integer.toString(fecha.get(Calendar.YEAR)));
                }
                limpiarTrasplantado();
                limpiarPerdida();
                if (txfPredio.getText().equalsIgnoreCase("N/A")) {

                    txfPredio.setText(null);
                    txfDestino.setText(null);
                    txfCorregimiento.setText(null);
                } else if (txfConvenio.getText().trim().equalsIgnoreCase("N/A")) {
                    txfConvenio.setText(null);
                }
                motivoCombo.requestFocus();
                txfCodigoSalida.setEditable(true);
                txfCodigoSalida2.setEditable(true);
                btnAgregar.setEnabled(true);
                btnQuitar.setEnabled(true);
                btnRegistrarSalida.setEnabled(true);
                break;
            case 4:
                if (txfCodigoSalida.getText().contains("T") || txfCodigoSalida.getText().contains("P")) {
                    txfCodigoSalida.setText(null);
                    txfCodigoSalida2.setText(Integer.toString(fecha.get(Calendar.YEAR)));
                }
                limpiarTrasplantado();
                limpiarPerdida();
                if (txfPredio.getText().equalsIgnoreCase("N/A")) {

                    txfPredio.setText(null);
                    txfDestino.setText(null);
                    txfCorregimiento.setText(null);
                }
                txfConvenio.setText("N/A");
                motivoCombo.requestFocus();
                txfCodigoSalida.setEditable(true);
                txfCodigoSalida2.setEditable(true);
                btnAgregar.setEnabled(true);
                btnQuitar.setEnabled(true);
                btnRegistrarSalida.setEnabled(true);
                break;
            case 1:
                if (txfCodigoSalida.getText().contains("T") || txfCodigoSalida.getText().contains("P")) {
                    txfCodigoSalida.setText(null);
                    txfCodigoSalida2.setText(Integer.toString(fecha.get(Calendar.YEAR)));
                }
                limpiarTrasplantado();
                limpiarPerdida();
                if (txfPredio.getText().equalsIgnoreCase("N/A")) {

                    txfPredio.setText(null);
                    txfDestino.setText(null);
                    txfCorregimiento.setText(null);
                }

                motivoCombo.requestFocus();
                txfCodigoSalida.setEditable(true);
                txfCodigoSalida2.setEditable(true);
                btnAgregar.setEnabled(true);
                btnQuitar.setEnabled(true);
                btnRegistrarSalida.setEnabled(true);
                txfConvenio.setText(convenio());
                break;
            case 2:
                MAXcodigoPerdida();
                limpiarTrasplantado();
                limpiarConductorSalida();
                txfDestino.setText("N/A");
                txfPredio.setText("N/A");
                txfCorregimiento.setText("N/A");
                txfConvenio.setText("N/A");
                motivoCombo.requestFocus();
                btnAgregar.setEnabled(true);
                btnQuitar.setEnabled(true);
                btnRegistrarSalida.setEnabled(true);
                break;
            case 3:
                MAXcodigoTrasplantado();
                limpiarConductorSalida();
                limpiarPerdida();
                txfDestino.setText("N/A");
                txfPredio.setText("N/A");
                txfCorregimiento.setText("N/A");
                txfConvenio.setText("N/A");
                motivoCombo.requestFocus();
                btnAgregar.setEnabled(false);
                btnQuitar.setEnabled(false);
                btnRegistrarSalida.setEnabled(false);
                break;
            default:
                break;
        }

    }//GEN-LAST:event_motivoComboItemStateChanged

    private void txfBuscarConsultarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarConsultarSalidaActionPerformed

        buscarSalidas();

    }//GEN-LAST:event_txfBuscarConsultarSalidaActionPerformed

    private void txfBuscarConsultarSalidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarConsultarSalidaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarConsultarSalidaKeyReleased

    private void txfBuscarConsultarSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarConsultarSalidaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }

        if (Character.isSpaceChar(c)) {

            evt.consume();
        }

        if (txfBuscarConsultarSalida.getText().length() >= 12) {

            evt.consume();

        }
    }//GEN-LAST:event_txfBuscarConsultarSalidaKeyTyped

    private void tablaConsultarSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarSalidasMouseClicked

        try {
            String motivo = null;

            if (motivoComboConsultarSalida.getSelectedIndex() != 3 && motivoComboConsultarSalida.getSelectedIndex() != 4) {

                motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 4).toString();

            } else {

                motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 3).toString();

            }

            switch (motivo) {
                case "Pérdida":
                case "Trasplantado":
                    btnGenerarReporte.setEnabled(false);
                    btnGenerarReporte1.setEnabled(false);
                    break;
                default:
                    btnGenerarReporte.setEnabled(true);
                    btnGenerarReporte1.setEnabled(true);
                    break;
            }

            if (evt.getButton() == 3) {
                tablaConsultarSalidas.clearSelection();
            } else if (evt.getButton() == 1 && evt.getClickCount() == 2) {
                identificador = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 0).toString();
                numero_orden = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 1).toString();
                if (motivo.equalsIgnoreCase("Pérdida")) {
                    ventanaInfoPerdida.setVisible(true);
                } else if (motivo.equalsIgnoreCase("Trasplantado")) {
                    ventanaInfoTrasplantado.setVisible(true);
                } else {
                    ventanaInfoSalida.setVisible(true);
                }
            }
        } catch (NullPointerException npe) {

        } catch (ArrayIndexOutOfBoundsException a) {

        }
    }//GEN-LAST:event_tablaConsultarSalidasMouseClicked

    private void tablaConsultarSalidasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarSalidasMouseReleased


    }//GEN-LAST:event_tablaConsultarSalidasMouseReleased

    private void tablaConsultarSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaConsultarSalidasKeyReleased

        try {

            String motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 4).toString();

            switch (motivo) {
                case "Pérdida":
                case "Trasplantado":
                    btnGenerarReporte.setEnabled(false);
                    btnGenerarReporte1.setEnabled(false);
                    break;
                default:
                    btnGenerarReporte.setEnabled(true);
                    btnGenerarReporte1.setEnabled(true);
                    break;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tablaConsultarSalidasKeyReleased

    private void btnBuscarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSalidaActionPerformed

        buscarSalidas();

    }//GEN-LAST:event_btnBuscarSalidaActionPerformed

    private void MenuSalidaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MenuSalidaStateChanged

        if (MenuSalida.getSelectedIndex() == 1) {

            if (tablaSalidas.getRowCount() != 0) {

                MenuSalida.setSelectedIndex(0);

                int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea descartar la salida?" + "\n" + "Recuerde que debe dar click en el botón 'Registrar' para confirmar la salida.", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {

                    cancelarSalida();
                    MenuSalida.setSelectedIndex(1);

                }

            }
        }


    }//GEN-LAST:event_MenuSalidaStateChanged

    private void SalidasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SalidasFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_SalidasFocusLost

    private void SalidasComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SalidasComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_SalidasComponentHidden

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

    private void txfCedulaConductorSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaConductorSalidasKeyReleased

        String cedula = txfCedulaConductorSalidas.getText();

        if (cedula.equalsIgnoreCase("")) {

        } else {

            try {
                rs = cDao.buscar(cedula);

                if (rs.next()) {

                    txfNombreConductorSalidas.setText(rs.getString(2));
                    txfApellidoConductorSalidas.setText(rs.getString(3));
                    long celular = rs.getLong(4);
                    if (celular == 0) {
                        txfCelularConductorSalidas.setText(null);
                    } else {
                        txfCelularConductorSalidas.setText(rs.getString(4));
                    }
                    txfNombreConductorSalidas.setEditable(false);
                    txfApellidoConductorSalidas.setEditable(false);
                    txfCelularConductorSalidas.setEditable(false);
                    txfPlacaSalidas.requestFocus(true);

                } else {

                    txfNombreConductorSalidas.setText(null);
                    txfApellidoConductorSalidas.setText(null);
                    txfCelularConductorSalidas.setText(null);
                    txfNombreConductorSalidas.setEditable(true);
                    txfApellidoConductorSalidas.setEditable(true);
                    txfCelularConductorSalidas.setEditable(true);

                }
            } catch (SQLException ex) {
                Logger.getLogger(VistaSGI.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_txfCedulaConductorSalidasKeyReleased

    private void txfCedulaConductorSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaConductorSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCedulaConductorSalidas.getText().length() > 9) {

            evt.consume();

        }


    }//GEN-LAST:event_txfCedulaConductorSalidasKeyTyped

    private void txfNombreConductorSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreConductorSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreConductorSalidasKeyReleased

    private void txfNombreConductorSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreConductorSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombreConductorSalidas.getText().length() > 39) {

            evt.consume();

        }


    }//GEN-LAST:event_txfNombreConductorSalidasKeyTyped

    private void txfApellidoConductorSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoConductorSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfApellidoConductorSalidasKeyReleased

    private void txfApellidoConductorSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoConductorSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfApellidoConductorSalidas.getText().length() > 29) {

            evt.consume();

        }

    }//GEN-LAST:event_txfApellidoConductorSalidasKeyTyped

    private void txfCelularConductorSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularConductorSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularConductorSalidasKeyReleased

    private void txfCelularConductorSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularConductorSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCelularConductorSalidas.getText().length() > 9) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCelularConductorSalidasKeyTyped

    private void btnSiguienteInfoSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteInfoSalidaActionPerformed

        verificarParcial();

    }//GEN-LAST:event_btnSiguienteInfoSalidaActionPerformed

    private void btnSiguienteConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteConductorActionPerformed

        siguienteConductorSalidas();

    }//GEN-LAST:event_btnSiguienteConductorActionPerformed

    private void btnAnteriorConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductorActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorConductorActionPerformed

    private void btnSiguienteClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteClienteActionPerformed

        siguienteClienteSalidas();


    }//GEN-LAST:event_btnSiguienteClienteActionPerformed

    private void btnAnteriorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorClienteActionPerformed

        switch (motivoCombo.getSelectedIndex()) {
            case 0:
            case 1:
            case 4:
                this.slidePanel.nextPanel(20, ConductorPanel, slidePanel.right);
                break;
            case 2:
            case 3:
                this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);
                break;
            default:
                break;
        }


    }//GEN-LAST:event_btnAnteriorClienteActionPerformed

    private void IdentificacionComboSalidasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IdentificacionComboSalidasItemStateChanged

        this.txfIdentificacionClienteSalidas.setEditable(true);
        this.txfNombreClienteSalidas.setEditable(true);
        this.txfTelefonoClienteSalidas.setEditable(true);
        this.txfNombreClienteSalidas.setText(null);
        this.txfTelefonoClienteSalidas.setText(null);


    }//GEN-LAST:event_IdentificacionComboSalidasItemStateChanged

    private void txfIdentificacionClienteSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdentificacionClienteSalidasActionPerformed

        try {

            if (txfNombreClienteSalidas.isEditable()) {
                String cedula = txfIdentificacionClienteSalidas.getText();

                if (cedula.equalsIgnoreCase("")) {

                    JOptionPane.showMessageDialog(null, "Digite una cédula o NIT por favor.");

                } else if (IdentificacionComboSalidas.getSelectedIndex() == 1 && !cedula.contains("-")) {

                    JOptionPane.showMessageDialog(null, "Ingrese un Nit válido, por favor.");

                } else if (IdentificacionComboSalidas.getSelectedIndex() == 0 && cedula.contains("-")) {

                    JOptionPane.showMessageDialog(null, "Ingrese una cédula válida.");

                } else {
                    ResultSet rs = clDao.buscar(cedula);

                    if (rs.next()) {

                        txfNombreClienteSalidas.setText(rs.getString(2));
                        txfTelefonoClienteSalidas.setText(rs.getString(3));
                        txfNombreClienteSalidas.setEditable(false);
                        txfTelefonoClienteSalidas.setEditable(false);

                    } else {

                        JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente, proceda a registrarlo.");
                        txfNombreClienteSalidas.setText(null);
                        txfTelefonoClienteSalidas.setText(null);
                        txfNombreClienteSalidas.setEditable(true);
                        txfTelefonoClienteSalidas.setEditable(true);

                    }
                }
            } else {
                siguienteClienteSalidas();
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_txfIdentificacionClienteSalidasActionPerformed

    private void txfIdentificacionClienteSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionClienteSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionClienteSalidasKeyReleased

    private void txfIdentificacionClienteSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionClienteSalidasKeyTyped
        char c = evt.getKeyChar();

        if (IdentificacionComboSalidas.getSelectedIndex() == 0) {

            if (Character.isDigit(c)) {

            } else {
                evt.consume();
            }

            if (txfIdentificacionClienteSalidas.getText().length() > 9) {
                evt.consume();
            }
        } else if (IdentificacionComboSalidas.getSelectedIndex() == 1) {

            if (Character.isDigit(c) || Character.toString(c).equals("-")) {

            } else {

                evt.consume();
            }

            if (txfIdentificacionClienteSalidas.getText().length() > 11) {
                evt.consume();
            }
        }

    }//GEN-LAST:event_txfIdentificacionClienteSalidasKeyTyped

    private void txfNombreClienteSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreClienteSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreClienteSalidasKeyReleased

    private void txfNombreClienteSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreClienteSalidasKeyTyped
        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombreClienteSalidas.getText().length() > 29) {

            evt.consume();

        }


    }//GEN-LAST:event_txfNombreClienteSalidasKeyTyped

    private void txfTelefonoClienteSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoClienteSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefonoClienteSalidasKeyReleased

    private void txfTelefonoClienteSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoClienteSalidasKeyTyped
        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();

        }

        if (txfTelefonoClienteSalidas.getText().length() > 9) {

            evt.consume();

        }


    }//GEN-LAST:event_txfTelefonoClienteSalidasKeyTyped

    private void btnNuevoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliente1ActionPerformed

        try {

            String cedula = txfIdentificacionClienteSalidas.getText();

            if (IdentificacionComboSalidas.getSelectedIndex() == 1 && !cedula.contains("-")) {

                JOptionPane.showMessageDialog(null, "Ingrese un Nit válido, por favor.");

            } else if (IdentificacionComboSalidas.getSelectedIndex() == 0 && cedula.contains("-")) {

                JOptionPane.showMessageDialog(null, "Ingrese una cédula válida.");

            } else if (IdentificacionComboSalidas.getSelectedIndex() == 2 && !cedula.contains("-")) {

                JOptionPane.showMessageDialog(null, "Digite el guión en el NIT." + "\n" + "Por ejemplo: 1234567890-1");

            } else if (cedula.length() < 7 || cedula.length() > 14) {

                JOptionPane.showMessageDialog(null, "Digíte un NIT válido, por favor.");

            } else {
                registrarClienteSalida();
                txfNombreClienteSalidas.setEditable(false);
                txfTelefonoClienteSalidas.setEditable(false);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Verifique que la información esté completa, por favor.");

        }


    }//GEN-LAST:event_btnNuevoCliente1ActionPerformed

    private void btnAnteriorCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorCliente1ActionPerformed

        this.slidePanel.nextPanel(20, ClientePanel, slidePanel.right);

    }//GEN-LAST:event_btnAnteriorCliente1ActionPerformed

    private void txfEspecieSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieSalidasKeyReleased

    private void txfCantidadSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCantidadSalidas.getText().length() > 9) {

            evt.consume();

        }

    }//GEN-LAST:event_txfCantidadSalidasKeyTyped

    private void btnAnteriorCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorCliente2ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorCliente2ActionPerformed

    private void btnSeleccionarEspecieReservas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieReservas2ActionPerformed

        limpiarPerdida();
        reiniciarSeleccionarEspecie();
        ventanaEspeciesSalidas.setVisible(true);

    }//GEN-LAST:event_btnSeleccionarEspecieReservas2ActionPerformed

    private void txfEspeciePerdidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspeciePerdidaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspeciePerdidaKeyReleased

    private void txfCantidadPerdidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadPerdidaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCantidadPerdida.getText().length() > 9) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCantidadPerdidaKeyTyped

    private void btnAnteriorCliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorCliente3ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorCliente3ActionPerformed

    private void btnSeleccionarEspecieReservas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieReservas3ActionPerformed

        reiniciarSeleccionarEspecie();
        ventanaEspeciesSalidas.setVisible(true);

    }//GEN-LAST:event_btnSeleccionarEspecieReservas3ActionPerformed

    private void txfEspecieTrasplantadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieTrasplantadoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieTrasplantadoKeyReleased

    private void txfCantidadTrasplantadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadTrasplantadoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfCantidadTrasplantado.getText().length() > 9) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCantidadTrasplantadoKeyTyped

    private void tamanoComboTrasplantadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tamanoComboTrasplantadoItemStateChanged

        switch (tamanoComboTrasplantado.getSelectedIndex()) {
            case 0:
                rangoComboTrasplantado.removeAllItems();
                rangoComboTrasplantado.addItem("<20 cm");
                rangoComboTrasplantado.addItem("40-60 cm");
                rangoComboTrasplantado.addItem(">60 cm");
                break;
            case 1:
                rangoComboTrasplantado.removeAllItems();
                rangoComboTrasplantado.addItem("<60 cm");
                rangoComboTrasplantado.addItem("60-100 cm");
                rangoComboTrasplantado.addItem("100-150 cm");
                break;
            default:
                break;
        }

    }//GEN-LAST:event_tamanoComboTrasplantadoItemStateChanged

    private void rangoComboTrasplantadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rangoComboTrasplantadoItemStateChanged


    }//GEN-LAST:event_rangoComboTrasplantadoItemStateChanged

    private void motivoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivoComboActionPerformed

    }//GEN-LAST:event_motivoComboActionPerformed

    private void fechaIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaIngresoKeyTyped

        evt.consume();

    }//GEN-LAST:event_fechaIngresoKeyTyped

    private void btnLimpiarProveedor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProveedor3ActionPerformed

        limpiarRUsuario();

    }//GEN-LAST:event_btnLimpiarProveedor3ActionPerformed

    private void rangoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rangoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rangoComboActionPerformed

    private void btnAnteriorConductor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor1ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorConductor1ActionPerformed

    private void btnAnteriorConductor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor2ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorConductor2ActionPerformed

    private void btnAnteriorConductor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor3ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorConductor3ActionPerformed

    private void btnAnteriorConductor4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor4ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);


    }//GEN-LAST:event_btnAnteriorConductor4ActionPerformed

    private void btnAnteriorConductor5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor5ActionPerformed

        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);

    }//GEN-LAST:event_btnAnteriorConductor5ActionPerformed

    private void btnRegistrarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalidaActionPerformed

        if (motivoCombo.getSelectedIndex() != 2 && txfCodigoSalida.getText().length() == 0 || motivoCombo.getSelectedIndex() != 2 && txfCodigoSalida2.getText().length() == 0) {

            JOptionPane.showMessageDialog(null, "Ingrese el número de orden completo, por favor.");

        }
        //Si el motivo es perdida o trasplantado que no pregunte por el carguista ni observaciones
        if (motivoCombo.getSelectedIndex() == 2 || motivoCombo.getSelectedIndex() == 3) {
            registrarSalida();
        } else if (observacion.trim().length() == 0 && carguista.trim().length() == 0) {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Desea ingresar la información del carguista y las observaciones generales?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {
                if (motivoCombo.getSelectedIndex() == 2) {
                    ventanaInfoGeneral.comboCarguista.setEnabled(false);
                } else {
                    ventanaInfoGeneral.comboCarguista.setEnabled(true);
                }
                ventanaInfoGeneral.setVisible(true);
            } else {

                registrarSalida();
            }
        } else {

            registrarSalida();
        }
    }//GEN-LAST:event_btnRegistrarSalidaActionPerformed

    private void txfCedulaConductorSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCedulaConductorSalidasActionPerformed

        String cedula = txfCedulaConductorSalidas.getText();

        if (cedula.equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(null, "Digite una cédula por favor.");

        } else {

            try {
                rs = cDao.buscar(cedula);

                if (rs.next()) {

                    txfNombreConductorSalidas.setText(rs.getString(2));
                    txfApellidoConductorSalidas.setText(rs.getString(3));
                    long celular = rs.getLong(4);
                    if (celular == 0) {
                        txfCelularConductorSalidas.setText(null);
                    } else {
                        txfCelularConductorSalidas.setText(rs.getString(4));
                    }
                    txfPlacaSalidas.requestFocus(true);
                    txfNombreConductorSalidas.setEditable(false);
                    txfApellidoConductorSalidas.setEditable(false);
                    txfCelularConductorSalidas.setEditable(false);
                    txfPlacaSalidas.requestFocus(true);

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha encontrado el conductor, proceda a registrarlo.");

                }
            } catch (SQLException ex) {
                Logger.getLogger(VistaSGI.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_txfCedulaConductorSalidasActionPerformed

    private void txfPlacaSalidasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPlacaSalidasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPlacaSalidasKeyReleased

    private void txfPlacaSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPlacaSalidasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isSpaceChar(c)) {
            evt.consume();
        }

        if (txfPlacaSalidas.getText().length() > 6) {

            evt.consume();

        }


    }//GEN-LAST:event_txfPlacaSalidasKeyTyped

    private void motivoComboConsultarSalidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_motivoComboConsultarSalidaItemStateChanged

        int index = motivoComboConsultarSalida.getSelectedIndex();
        switch (index) {
            case 0:
            case 1:
            case 2:
            case 5:
                btnGenerarReporte.setEnabled(true);
                btnGenerarReporte1.setEnabled(true);
                break;
            case 3:
            case 4:
                btnGenerarReporte.setEnabled(false);
                btnGenerarReporte1.setEnabled(false);
                break;
            default:
                break;
        }

        limpiarTablaConsultarSalidas();
    }//GEN-LAST:event_motivoComboConsultarSalidaItemStateChanged

    private void motivoComboConsultarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivoComboConsultarSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motivoComboConsultarSalidaActionPerformed

    private void btnLimpiarConsulSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConsulSalidasActionPerformed

        txfBuscarConsultarSalida.setText(null);
        java.util.Date fechaParseada;
        try {
            fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
            fechaDesdeSalida.setDate(fechaParseada);
            fechaHastaSalida.setDate(fechaParseada);
        } catch (ParseException ex) {
        }
        motivoComboConsultarSalida.setSelectedIndex(1);
        limpiarTablaConsultarSalidas();

    }//GEN-LAST:event_btnLimpiarConsulSalidasActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed

        generarReporteConsultar();

    }//GEN-LAST:event_btnGenerarReporteActionPerformed

    private void btnCambiarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarMouseReleased

//        if (lblTitulo.getText().equalsIgnoreCase("PRODUCTOS AGOTADOS")) {
//
//            lblTitulo.setText("PRODUCTOS MÁS VENDIDOS");
//
//        } else {
//
//            lblTitulo.setText("PRODUCTOS AGOTADOS");
//
//        }

    }//GEN-LAST:event_btnCambiarMouseReleased

    private void txfDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDestinoActionPerformed

        verificarParcial();
    }//GEN-LAST:event_txfDestinoActionPerformed

    private void txfPredioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPredioActionPerformed

        verificarParcial();

    }//GEN-LAST:event_txfPredioActionPerformed

    private void txfPlacaSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPlacaSalidasActionPerformed

        siguienteConductorSalidas();
    }//GEN-LAST:event_txfPlacaSalidasActionPerformed

    private void txfNombreClienteSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreClienteSalidasActionPerformed

        siguienteClienteSalidas();
    }//GEN-LAST:event_txfNombreClienteSalidasActionPerformed

    private void txfTelefonoClienteSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefonoClienteSalidasActionPerformed

        siguienteClienteSalidas();
    }//GEN-LAST:event_txfTelefonoClienteSalidasActionPerformed

    private void EspeciesPanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EspeciesPanelKeyTyped


    }//GEN-LAST:event_EspeciesPanelKeyTyped

    private void btn_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_1MouseClicked

    private void btn_10consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10consultarEmpleados

        if (verificarSalida()) {
            setColor(btn_10);
            ind_10.setOpaque(true);
            resetColor(new JPanel[]{btn_1, btn_2, btn_5, btn_6, btn_7, btn_11, btn_12, btn_13}, new JPanel[]{ind_1, ind_2, ind_5, ind_6, ind_7, ind_11, ind_12, ind_13});
            parent.removeAll();
            parent.add(GestionarEspecies);
            parent.repaint();
            parent.revalidate();
            obtenerMAXEspecie();
        } else {

        }

    }//GEN-LAST:event_btn_10consultarEmpleados

    private void btn_10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_10MousePressed

    private void btnEditarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEspActionPerformed

        if (txfNombreCien.getText().length() == 0) {

        } else {

            activarCamposEspecies();
            this.btnEditarEsp.setEnabled(false);
            this.btnGuardarEsp.setEnabled(true);
        }
        if (tablaEspecies.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una especie primero.");
        } else {
            if (tablaEspecies.getValueAt(0, 0).equals("Sin resultados...")) {
                JOptionPane.showMessageDialog(null, "Seleccione una especie válida. ");
            }
        }

    }//GEN-LAST:event_btnEditarEspActionPerformed

    private void tablaEspeciesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspeciesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaEspeciesMouseClicked

    private void tablaEspeciesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEspeciesMouseReleased

        if (tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1) {

                seleccionarEspecie();

            }
        }

    }//GEN-LAST:event_tablaEspeciesMouseReleased

    private void tablaEspeciesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaEspeciesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaEspeciesKeyReleased

    private void txfNombreComunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreComunKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreComunKeyReleased

    private void txfNombreComunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreComunKeyTyped
        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombreComun.getText().length() > 19) {

            evt.consume();
        }

    }//GEN-LAST:event_txfNombreComunKeyTyped

    private void txfFamiliaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfFamiliaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfFamiliaKeyReleased

    private void txfFamiliaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfFamiliaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfFamilia.getText().length() > 14) {

            evt.consume();
        }

    }//GEN-LAST:event_txfFamiliaKeyTyped

    private void txfMsnmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMsnmKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMsnmKeyReleased

    private void txfMsnmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfMsnmKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (txfMsnm.getText().length() > 11) {

            evt.consume();
        }

    }//GEN-LAST:event_txfMsnmKeyTyped

    private void txfNombreCienKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreCienKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreCienKeyReleased

    private void txfNombreCienKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreCienKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombreCien.getText().length() > 29) {

            evt.consume();
        }

    }//GEN-LAST:event_txfNombreCienKeyTyped

    private void txfBuscarEspKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarEspKeyReleased

        try {

            if (txfBuscarEsp.getText().length() == 0) {

                DefaultTableModel modelo = (DefaultTableModel) tablaEspecies.getModel();

                limpiarTablaEspecies();

                tablaEspecies.setModel(modelo);

            } else {

                DefaultTableModel modelo;
                TableColumnModel column = tablaEspecies.getColumnModel();
                modelo = eDao.listar(txfBuscarEsp.getText());
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tablaEspecies.setModel(modelo);
                tcr.setHorizontalAlignment(SwingConstants.LEFT);
                tablaEspecies.getColumnModel().getColumn(1).setCellRenderer(tcr);
                column.getColumn(0).setPreferredWidth(150);
                column.getColumn(1).setPreferredWidth(150);

            }

        } catch (Exception e) {

        }

    }//GEN-LAST:event_txfBuscarEspKeyReleased

    private void txfBuscarEspKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarEspKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }


    }//GEN-LAST:event_txfBuscarEspKeyTyped

    private void btnLimpiarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarEspActionPerformed

        limpiarEspecies();

    }//GEN-LAST:event_btnLimpiarEspActionPerformed

    private void btnGuardarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEspActionPerformed

        try {

            if (txfNombreCien.getText().length() == 0 || txfNombreComun.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

            } else {

                String codigo = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString();
                String nombre_cien = txfNombreCien.getText().trim();
                String nombre_comun = txfNombreComun.getText().trim();
                String familia = txfFamilia.getText().trim();
                String msnm = txfMsnm.getText().trim();

                if (eDao.actualizar(codigo, nombre_comun, nombre_cien, familia, msnm)) {
                    JOptionPane.showMessageDialog(null, "Especie actualizada correctamente.");
                    this.btnEditarEsp.setEnabled(true);
                    this.btnGuardarEsp.setEnabled(false);
                    this.btnRegistrarEsp.setEnabled(true);
                    String busca = lblNumeroEspecie.getText();
                    buscarEspecies(busca);
                    limpiarEspecies();
                    activarCamposEspecies();

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar, inténtelo nuevamente.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }//GEN-LAST:event_btnGuardarEspActionPerformed

    private void btnRegistrarEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEspActionPerformed
        registrarEspecie();
    }//GEN-LAST:event_btnRegistrarEspActionPerformed

    private void txfNombreCienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreCienActionPerformed
    }//GEN-LAST:event_txfNombreCienActionPerformed

    private void txfNombreComunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreComunActionPerformed

    }//GEN-LAST:event_txfNombreComunActionPerformed

    private void txfFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfFamiliaActionPerformed


    }//GEN-LAST:event_txfFamiliaActionPerformed

    private void txfMsnmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMsnmActionPerformed

    }//GEN-LAST:event_txfMsnmActionPerformed

    private void txfEspeciePerdidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEspeciePerdidaActionPerformed

        if (txfEspecieSalidas.getText().trim().equalsIgnoreCase("") || txfCantidadSalidas.getText().trim().equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(null, "Seleccione una especie primero.");
        } else {

            quitarEspecie();
        }

    }//GEN-LAST:event_txfEspeciePerdidaActionPerformed

    private void btnEliminarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEspecieActionPerformed

        if (tablaEspecies.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Elija una especie primero.");

        } else {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro que desea eliminar la especie?" + "\n" + "Una vez eliminada no se podrá recuperar.", "Confirmación", JOptionPane.YES_NO_OPTION);
            String codigo = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString();

            if (resultado == 0) {

                if (eDao.eliminarEspecie(codigo)) {

                    JOptionPane.showMessageDialog(null, "Especie eliminada correctamente.");
                    limpiarEspecies();
                    obtenerMAXEspecie();

                } else {

                    JOptionPane.showMessageDialog(null, "No se pudo eliminar la especie debido a que esta especie está presente en algunas salidas.");
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnEliminarEspecieActionPerformed

    private void slidePanelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_slidePanelKeyTyped

//         if (c == evt.getKeyChar()) {
//             
//           siguienteInfoSalida();
//             
//         } 
    }//GEN-LAST:event_slidePanelKeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

        char c = evt.getKeyChar();

        System.out.println(c);
    }//GEN-LAST:event_formKeyTyped

    private void btn_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseEntered

        setColor(btn_1);
        ind_1.setOpaque(true);
    }//GEN-LAST:event_btn_1MouseEntered

    private void btn_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_1MouseExited

        if (!PerfilGerente.isShowing()) {
            resetColor1(btn_1);
            ind_1.setOpaque(false);
        }
    }//GEN-LAST:event_btn_1MouseExited

    private void btn_6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseEntered

        setColor(btn_6);
        ind_6.setOpaque(true);
    }//GEN-LAST:event_btn_6MouseEntered

    private void btn_6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_6MouseExited
        if (!Inventario.isShowing()) {
            resetColor1(btn_6);
            ind_6.setOpaque(false);
        }
    }//GEN-LAST:event_btn_6MouseExited

    private void btn_7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseEntered

        setColor(btn_7);
        ind_7.setOpaque(true);
    }//GEN-LAST:event_btn_7MouseEntered

    private void btn_7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseExited
        if (!Salidas.isShowing()) {
            resetColor1(btn_7);
            ind_7.setOpaque(false);
        }
    }//GEN-LAST:event_btn_7MouseExited

    private void btn_5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseEntered
        setColor(btn_5);
        ind_5.setOpaque(true);
    }//GEN-LAST:event_btn_5MouseEntered

    private void btn_5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_5MouseExited
        if (!AlimentarInventario.isShowing()) {
            resetColor1(btn_5);
            ind_5.setOpaque(false);
        }
    }//GEN-LAST:event_btn_5MouseExited

    private void btn_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseEntered
        setColor(btn_2);
        ind_2.setOpaque(true);
    }//GEN-LAST:event_btn_2MouseEntered

    private void btn_2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_2MouseExited
        if (!GestionarUsuarios.isShowing()) {
            resetColor1(btn_2);
            ind_2.setOpaque(false);
        }
    }//GEN-LAST:event_btn_2MouseExited

    private void btn_10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseEntered
        setColor(btn_10);
        ind_10.setOpaque(true);
    }//GEN-LAST:event_btn_10MouseEntered

    private void btn_10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_10MouseExited
        if (!GestionarEspecies.isShowing()) {
            resetColor1(btn_10);
            ind_10.setOpaque(false);
        }
    }//GEN-LAST:event_btn_10MouseExited

    private void tablaConsultarSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaConsultarSalidasKeyTyped
        try {
            String motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 4).toString();

            switch (motivo) {
                case "Pérdida":
                case "Trasplantado":
                    btnGenerarReporte.setEnabled(false);
                    btnGenerarReporte1.setEnabled(false);
                    break;
                default:
                    btnGenerarReporte.setEnabled(true);
                    btnGenerarReporte1.setEnabled(true);
                    break;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tablaConsultarSalidasKeyTyped

    private void btnGenerarReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporte1ActionPerformed

        if (tablaConsultarSalidas.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "Busque alguna salida primero, por favor.");
        } else {
            ventanaExcel.TipoCombo.setEnabled(false);
            ventanaExcel.setVisible(true);
        }
    }//GEN-LAST:event_btnGenerarReporte1ActionPerformed

    private void txfCodigoEspecieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoEspecieKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoEspecieKeyReleased

    private void txfCodigoEspecieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoEspecieKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isSpaceChar(c)) {
            evt.consume();
        }

        if (Character.isAlphabetic(c)) {
            evt.consume();
        }

        if (txfCodigoEspecie.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txfCodigoEspecieKeyTyped

    private void txfCodigoEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoEspecieActionPerformed

        try {

            String codigoPersonalizado = txfCodigoEspecie.getText();

            if (codigoPersonalizado.equalsIgnoreCase("")) {

                JOptionPane.showMessageDialog(null, "Digite un codigo de planta valido.");

            } else {
                ResultSet rs = iDao.buscarporCodigo(codigoPersonalizado);

                if (rs.next()) {

                    txfEspecie.setText(rs.getString("nombre_vulgar"));
                    tamanoCombo.setSelectedItem(rs.getString("tamaño_bolsa"));
                    rangoCombo.setSelectedItem(rs.getString("rango"));
                    txfCodigoEspecie.setEnabled(false);
                    codigo_Especie = rs.getInt("codigo_planta");
                } else {

                    JOptionPane.showMessageDialog(null, "No se ha encontrado la plantula , proceda a ingresarla.");
                    txfEspecie.setText(rs.getString(null));
                    tamanoCombo.setSelectedIndex(-1);
                    rangoCombo.setSelectedIndex(-1);
                }
            }
        } catch (Exception e) {

        }


    }//GEN-LAST:event_txfCodigoEspecieActionPerformed

    private void txfBuscarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarEspecieActionPerformed
        buscarIngreso();
    }//GEN-LAST:event_txfBuscarEspecieActionPerformed

    private void txfCantidadIngresarEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadIngresarEspecieActionPerformed

        ingresarEspecie();
    }//GEN-LAST:event_txfCantidadIngresarEspecieActionPerformed

    private void btnMostrarContraseñaUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarContraseñaUActionPerformed

        if (estado) {
            txfCrearContraseña.setEchoChar((char) 0);
            btnMostrarContraseñaU.setIcon(iconoOcultar);
        } else {
            txfCrearContraseña.setEchoChar('•');
            btnMostrarContraseñaU.setIcon(iconoMostrar);
        }

        estado = !estado;
    }//GEN-LAST:event_btnMostrarContraseñaUActionPerformed

    private void InfoSalidaPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InfoSalidaPanelKeyPressed


    }//GEN-LAST:event_InfoSalidaPanelKeyPressed

    private void txfCorregimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCorregimientoActionPerformed
        verificarParcial();
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

    private void motivoComboFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_motivoComboFocusGained

//        motivoCombo.showPopup();
    }//GEN-LAST:event_motivoComboFocusGained

    private void motivoComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_motivoComboKeyReleased

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_1:
                motivoCombo.setSelectedIndex(0);
                break;
            case KeyEvent.VK_2:
                motivoCombo.setSelectedIndex(1);
                break;
            case KeyEvent.VK_3:
                motivoCombo.setSelectedIndex(2);
                break;
            case KeyEvent.VK_4:
                motivoCombo.setSelectedIndex(3);
                break;
            case KeyEvent.VK_5:
                motivoCombo.setSelectedIndex(4);
        }
    }//GEN-LAST:event_motivoComboKeyReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained

    }//GEN-LAST:event_formFocusGained

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased


    }//GEN-LAST:event_formKeyReleased

    private void InfoSalidaPanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InfoSalidaPanelKeyReleased


    }//GEN-LAST:event_InfoSalidaPanelKeyReleased

    private void btn_7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_7MouseReleased
        motivoCombo.requestFocus();
    }//GEN-LAST:event_btn_7MouseReleased

    private void txfConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfConvenioActionPerformed

        verificarParcial();
    }//GEN-LAST:event_txfConvenioActionPerformed

    private void txfConvenioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfConvenioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfConvenioKeyReleased

    private void txfConvenioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfConvenioKeyTyped

        char c = evt.getKeyChar();

//        if (Character.isLowerCase(c)) {
//
//            String cad = ("" + c).toUpperCase();
//            c = cad.charAt(0);
//            evt.setKeyChar(c);
//
//        }
        if (txfConvenio.getText().length() > 25) {

            evt.consume();

        }
    }//GEN-LAST:event_txfConvenioKeyTyped

    private void txfCorregimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txfCorregimientoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCorregimientoMouseEntered

    private void txfCodigoSalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalidaKeyTyped

        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }

        if (txfCodigoSalida.getText().length() >= 4) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoSalidaKeyTyped

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

    private void txfCodigoSalida2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalida2KeyTyped

        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }

        if (txfCodigoSalida2.getText().length() >= 4) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoSalida2KeyTyped

    private void txfCodigoEspcSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoEspcSalidasActionPerformed

        buscarEspeciesSalidas();

    }//GEN-LAST:event_txfCodigoEspcSalidasActionPerformed

    private void btnSeleccionarEspecieSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieSActionPerformed

        limpiarEspecieSalidas();
        reiniciarSeleccionarEspecie();
        ventanaEspeciesSalidas.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarEspecieSActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed

        if (PerdidaPanel.isShowing()) {
            agregarEspeciePerdida();
        } else {
            agregarEspecie();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txfStockSalidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfStockSalidasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfStockSalidasKeyTyped

    private void btnLimpiarInfoEspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarInfoEspActionPerformed

        limpiarSeleccionarEspecies();

    }//GEN-LAST:event_btnLimpiarInfoEspActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed

        if (tablaSalidas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una especie primero.");
        } else {
            quitarEspecie();
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txfCantidadSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadSalidasActionPerformed
        if (txfPedido.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el número de especies solicitadas por el cliente.");
        } else {
            agregarEspecie();
        }
    }//GEN-LAST:event_txfCantidadSalidasActionPerformed

    private void btnTrasplantarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrasplantarActionPerformed

        if (txfEspecieTrasplantado.getText().length() == 0 || txfCantidadTrasplantado.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Información incompleta.");
        } else if (txfCantidadTrasplantado.isEditable()) {

            agregarEspecieTrasplantado();

        } else {

            registrarSalidaTrasplantado();
        }
    }//GEN-LAST:event_btnTrasplantarActionPerformed

    private void txfEspecieTrasplantadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfEspecieTrasplantadoActionPerformed

        buscarEspeciesTrasplantado();

    }//GEN-LAST:event_txfEspecieTrasplantadoActionPerformed

    private void txfEspecieTrasplantadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieTrasplantadoKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();
        }

        if (Character.isSpaceChar(c)) {

            evt.consume();
        }

        if (txfEspecieTrasplantado.getText().length() >= 6) {

            evt.consume();

        }
    }//GEN-LAST:event_txfEspecieTrasplantadoKeyTyped

    private void txfCantidadTrasplantadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadTrasplantadoActionPerformed

        if (txfCantidadTrasplantado.isEditable()) {

            agregarEspecieTrasplantado();

        } else {

            registrarSalidaTrasplantado();
        }
    }//GEN-LAST:event_txfCantidadTrasplantadoActionPerformed

    private void txfStockPerdidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfStockPerdidaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfStockPerdidaKeyTyped

    private void txfCodigoPerdidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoPerdidaKeyTyped

        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();
        }

        if (Character.isSpaceChar(c)) {

            evt.consume();
        }

        if (txfCodigoPerdida.getText().length() >= 6) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCodigoPerdidaKeyTyped

    private void txfCodigoPerdidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoPerdidaActionPerformed

        buscarEspeciesPerdida();
    }//GEN-LAST:event_txfCodigoPerdidaActionPerformed

    private void btnAnteriorConductor6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor6ActionPerformed

        limpiarTrasplantado();
    }//GEN-LAST:event_btnAnteriorConductor6ActionPerformed

    private void btnAnteriorConductor7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor7ActionPerformed

        limpiarPerdida();
    }//GEN-LAST:event_btnAnteriorConductor7ActionPerformed

    private void txfCantidadPerdidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadPerdidaActionPerformed

        agregarEspeciePerdida();
    }//GEN-LAST:event_txfCantidadPerdidaActionPerformed

    private void txfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfUsuarioActionPerformed

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

    private void btnLimpiarConductorSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConductorSalidasActionPerformed

        txfCedulaConductorSalidas.setText(null);
        txfNombreConductorSalidas.setText(null);
        txfApellidoConductorSalidas.setText(null);
        txfCelularConductorSalidas.setText(null);
        txfPlacaSalidas.setText(null);
        txfNombreConductorSalidas.setEditable(true);
        txfApellidoConductorSalidas.setEditable(true);
        txfCelularConductorSalidas.setEditable(true);
        txfCedulaConductorSalidas.requestFocus(true);

    }//GEN-LAST:event_btnLimpiarConductorSalidasActionPerformed

    private void btnNuevoConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoConductorActionPerformed

        registrarConductorSalidas();
    }//GEN-LAST:event_btnNuevoConductorActionPerformed

    private void btnAnteriorConductor8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorConductor8ActionPerformed

        IdentificacionComboSalidas.setSelectedIndex(0);
        txfIdentificacionClienteSalidas.setText(null);
        txfNombreClienteSalidas.setText(null);
        txfTelefonoClienteSalidas.setText(null);
        txfNombreClienteSalidas.setEditable(true);
        txfTelefonoClienteSalidas.setEditable(true);
        IdentificacionComboSalidas.requestFocus(true);

    }//GEN-LAST:event_btnAnteriorConductor8ActionPerformed

    private void txfNombreConductorSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreConductorSalidasActionPerformed

        siguienteConductorSalidas();

    }//GEN-LAST:event_txfNombreConductorSalidasActionPerformed

    private void txfApellidoConductorSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfApellidoConductorSalidasActionPerformed
        siguienteConductorSalidas();
    }//GEN-LAST:event_txfApellidoConductorSalidasActionPerformed

    private void txfCelularConductorSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularConductorSalidasActionPerformed

        siguienteConductorSalidas();
    }//GEN-LAST:event_txfCelularConductorSalidasActionPerformed

    private void txfParcialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfParcialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfParcialKeyTyped

    private void cbEntregaParcialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntregaParcialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEntregaParcialActionPerformed

    private void cbEntregaParcialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEntregaParcialItemStateChanged
        if (cbEntregaParcial.isSelected()) {
            if (txfCodigoSalida.getText().trim().isEmpty() || txfCodigoSalida2.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un número de orden completo, por favor.");
                cbEntregaParcial.setSelected(false);
            } else {
                MAXParcial();
            }
        } else {
            txfParcial.setText(null);
        }
    }//GEN-LAST:event_cbEntregaParcialItemStateChanged

    private void cbEntregaParcialStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbEntregaParcialStateChanged


    }//GEN-LAST:event_cbEntregaParcialStateChanged

    private void txfCodigoSalidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalidaKeyReleased

        if (txfCodigoSalida.getText().trim().length() == 0) {
            cbEntregaParcial.setSelected(false);
        } else if (cbEntregaParcial.isSelected() && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE && !txfIdentificacionClienteSalidas.isEditable()) {
            limpiarSalidas();
        } else if (cbEntregaParcial.isSelected()) {
            MAXParcial();
        } else {

        }
    }//GEN-LAST:event_txfCodigoSalidaKeyReleased

    private void txfCodigoSalida2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoSalida2KeyReleased

        if (txfCodigoSalida2.getText().trim().length() == 0) {
            cbEntregaParcial.setSelected(false);
        } else if (cbEntregaParcial.isSelected() && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE && !txfIdentificacionClienteSalidas.isEditable()) {
            limpiarSalidas();
        } else if (cbEntregaParcial.isSelected()) {
            MAXParcial();
        } else {

        }
    }//GEN-LAST:event_txfCodigoSalida2KeyReleased

    private void tablaConsultarSalidasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaConsultarSalidasKeyPressed
        try {
            String motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 4).toString();

            switch (motivo) {
                case "Pérdida":
                case "Trasplantado":
                    btnGenerarReporte.setEnabled(false);
                    btnGenerarReporte1.setEnabled(false);
                    break;
                default:
                    btnGenerarReporte.setEnabled(true);
                    btnGenerarReporte1.setEnabled(true);
                    break;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tablaConsultarSalidasKeyPressed

    private void tablaConsultarSalidasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarSalidasMousePressed

        try {
            String motivo = null;

            if (motivoComboConsultarSalida.getSelectedIndex() != 3 && motivoComboConsultarSalida.getSelectedIndex() != 4) {

                motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 4).toString();

            } else {

                motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 3).toString();

            }

            switch (motivo) {
                case "Pérdida":
                case "Trasplantado":
                    btnGenerarReporte.setEnabled(false);
                    btnGenerarReporte1.setEnabled(false);
                    break;
                default:
                    btnGenerarReporte.setEnabled(true);
                    btnGenerarReporte1.setEnabled(true);
                    break;
            }

            if (evt.getButton() == 3) {
                tablaConsultarSalidas.clearSelection();
            } else if (evt.getButton() == 1 && evt.getClickCount() == 2) {
                identificador = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 0).toString();
                numero_orden = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 1).toString();
                if (motivo.equalsIgnoreCase("Pérdida")) {
                    ventanaInfoPerdida.setVisible(true);
                } else if (motivo.equalsIgnoreCase("Trasplantado")) {
                    ventanaInfoTrasplantado.setVisible(true);
                } else {
                    ventanaInfoSalida.setVisible(true);
                }
            }
        } catch (NullPointerException npe) {

        } catch (ArrayIndexOutOfBoundsException a) {

        }
    }//GEN-LAST:event_tablaConsultarSalidasMousePressed

    private void btn_11consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11consultarEmpleados
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_11consultarEmpleados

    private void btn_11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseEntered

        setColor(btn_11);
        ind_11.setOpaque(true);
    }//GEN-LAST:event_btn_11MouseEntered

    private void btn_11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MouseExited

        if (!GestionarConductores.isShowing()) {
            resetColor1(btn_11);
            ind_11.setOpaque(false);
        }

    }//GEN-LAST:event_btn_11MouseExited

    private void btn_11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_11MousePressed

        if (verificarSalida()) {
            setColor(btn_11);
            ind_11.setOpaque(true);
            resetColor(new JPanel[]{btn_1, btn_2, btn_5, btn_6, btn_7, btn_10, btn_12, btn_13}, new JPanel[]{ind_1, ind_2, ind_5, ind_6, ind_7, ind_10, ind_12, ind_13});
            parent.removeAll();
            parent.add(GestionarConductores);
            parent.repaint();
            parent.revalidate();

        } else {

        }
    }//GEN-LAST:event_btn_11MousePressed

    private void tablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClientesMouseClicked

    private void tablaClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientesMouseReleased
        if (tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1) {

                seleccionarCliente();

            }
        }

    }//GEN-LAST:event_tablaClientesMouseReleased

    private void tablaClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClientesKeyReleased

    private void txfNombreClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreClientesActionPerformed

    private void txfNombreClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreClientesKeyReleased

    private void txfNombreClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreClientesKeyTyped
        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombreClientes.getText().length() > 29) {

            evt.consume();

        }

    }//GEN-LAST:event_txfNombreClientesKeyTyped

    private void txfCelularClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularClientesActionPerformed

    private void txfCelularClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularClientesKeyReleased

    private void txfCelularClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularClientesKeyTyped
        char c = evt.getKeyChar();

        if (Character.isAlphabetic(c)) {

            evt.consume();

        }

        if (txfCelularClientes.getText().length() > 9) {

            evt.consume();

        }

    }//GEN-LAST:event_txfCelularClientesKeyTyped

    private void txfIdClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdClientesActionPerformed

    private void txfIdClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdClientesKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdClientesKeyReleased

    private void txfIdClientesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdClientesKeyTyped
        char c = evt.getKeyChar();

        if (TipoComboClientes.getSelectedIndex() == 0) {

            if (Character.isDigit(c)) {

            } else {
                evt.consume();
            }

            if (txfIdClientes.getText().length() > 9) {
                evt.consume();
            }
        } else if (TipoComboClientes.getSelectedIndex() == 1) {

            if (Character.isDigit(c) || Character.toString(c).equals("-")) {

            } else {

                evt.consume();
            }

            if (txfIdClientes.getText().length() > 11) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txfIdClientesKeyTyped

    private void txfBuscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarClienteKeyReleased
        try {

            if (txfBuscarCliente.getText().length() == 0) {

                DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();

                limpiarTablaClientes();

                tablaClientes.setModel(modelo);

            } else {

                DefaultTableModel modelo;
                TableColumnModel column = tablaClientes.getColumnModel();
                modelo = clDao.listarClientes(txfBuscarCliente.getText());
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tablaClientes.setModel(modelo);
                tcr.setHorizontalAlignment(SwingConstants.LEFT);
                tablaClientes.getColumnModel().getColumn(1).setCellRenderer(tcr);
                column.getColumn(0).setPreferredWidth(150);
                column.getColumn(1).setPreferredWidth(150);

            }

        } catch (Exception e) {
            System.out.println(txfBuscarCliente.getText());
            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_txfBuscarClienteKeyReleased

    private void txfBuscarClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarClienteKeyTyped
        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }

        if (txfBuscarCliente.getText().length() > 29) {

            evt.consume();

        }
    }//GEN-LAST:event_txfBuscarClienteKeyTyped

    private void btnLimpiarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarClientesActionPerformed
        txfIdClientes.setRequestFocusEnabled(true);
        limpiarClientes();
        limpiarTablaClientes();
    }//GEN-LAST:event_btnLimpiarClientesActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        actualizarCliente();
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        try {

            String cedula = txfIdClientes.getText();

            if (TipoComboClientes.getSelectedIndex() == 1 && !cedula.contains("-")) {

                JOptionPane.showMessageDialog(null, "Ingrese un Nit válido, por favor.");

            } else if (TipoComboClientes.getSelectedIndex() == 0 && cedula.contains("-")) {

                JOptionPane.showMessageDialog(null, "Ingrese una cédula válida.");

            } else if (TipoComboClientes.getSelectedIndex() == 2 && !cedula.contains("-")) {

                JOptionPane.showMessageDialog(null, "Digite el guión en el NIT." + "\n" + "Por ejemplo: 1234567890-1");

            } else if (cedula.length() < 7 || cedula.length() > 14) {

                JOptionPane.showMessageDialog(null, "Digíte un NIT/Cedula válido, por favor.");

            } else if (txfCelularClientes.getText().length() < 7 || txfCelularClientes.getText().length() > 10) {

                JOptionPane.showMessageDialog(null, "Digíte un Celular valido.");

            } else if (txfNombreClientes.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Digíte el nombre por favor");
            } else {
                registrarCliente();
                limpiarClientes();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Verifique que la información esté completa, por favor.");

        }

    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnEditarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarConductorActionPerformed

        if (!txfCelularConductor.isEditable()) {
            activarCamposConductores();
            txfCedulaConductor.setEditable(false);
            txfNombreConductor.requestFocus();
            btnGuardarConductor.setEnabled(true);
            btnEditarConductor.setEnabled(false);
            btnRegistrarConductor.setEnabled(false);
        }
        if (tablaConductores.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(tablaConductores, "Seleccione un Conductor primero ");
        } else {
            if (tablaConductores.getValueAt(0, 0).equals("Sin resultados...")) {
                JOptionPane.showMessageDialog(tablaConductores, "Seleccione un conductor valido ");
            }
        }

    }//GEN-LAST:event_btnEditarConductorActionPerformed

    private void tablaConductoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConductoresMouseClicked


    }//GEN-LAST:event_tablaConductoresMouseClicked

    private void tablaConductoresMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConductoresMouseReleased

        if (tablaConductores.getValueAt(tablaConductores.getSelectedRow(), 0).toString().equalsIgnoreCase("Sin resultados...")) {

        } else {

            if (evt.getClickCount() == 1) {

                seleccionarConductor();

            }
        }
    }//GEN-LAST:event_tablaConductoresMouseReleased

    private void tablaConductoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaConductoresKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaConductoresKeyReleased

    private void txfNombreConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreConductorActionPerformed
        registrarConductor();
    }//GEN-LAST:event_txfNombreConductorActionPerformed

    private void txfNombreConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreConductorKeyReleased

    private void txfNombreConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreConductorKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }

        if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
            evt.consume();
        }

        if (txfNombreConductor.getText().length() > 39) {

            evt.consume();

        }


    }//GEN-LAST:event_txfNombreConductorKeyTyped

    private void txfApellidoConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfApellidoConductorActionPerformed
        registrarConductor();
    }//GEN-LAST:event_txfApellidoConductorActionPerformed

    private void txfApellidoConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfApellidoConductorKeyReleased

    private void txfApellidoConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfApellidoConductorKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }
        if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
            evt.consume();
        }

        if (txfApellido.getText().length() > 29) {

            evt.consume();
        }
    }//GEN-LAST:event_txfApellidoConductorKeyTyped

    private void txfCelularConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCelularConductorActionPerformed
        registrarConductor();
    }//GEN-LAST:event_txfCelularConductorActionPerformed

    private void txfCelularConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCelularConductorKeyReleased

    private void txfCelularConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCelularConductorKeyTyped

        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }

        if (txfCelularConductor.getText().length() >= 10) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCelularConductorKeyTyped

    private void txfCedulaConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCedulaConductorActionPerformed
        registrarConductor();
    }//GEN-LAST:event_txfCedulaConductorActionPerformed

    private void txfCedulaConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaConductorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCedulaConductorKeyReleased

    private void txfCedulaConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCedulaConductorKeyTyped

        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }

        if (txfCedulaConductor.getText().trim().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txfCedulaConductorKeyTyped

    private void txfBuscarConductorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarConductorKeyReleased

        try {

            if (txfBuscarConductor.getText().length() == 0) {

                DefaultTableModel modelo = (DefaultTableModel) tablaConductores.getModel();

                limpiarTablaConductores();

                tablaConductores.setModel(modelo);

            } else {

                DefaultTableModel modelo;
                TableColumnModel column = tablaConductores.getColumnModel();
                modelo = cDao.listarActivos(txfBuscarConductor.getText());
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                tablaConductores.setModel(modelo);
                tcr.setHorizontalAlignment(SwingConstants.LEFT);
                tablaConductores.getColumnModel().getColumn(1).setCellRenderer(tcr);
                column.getColumn(0).setPreferredWidth(150);
                column.getColumn(1).setPreferredWidth(150);

            }

        } catch (Exception e) {

        }
    }//GEN-LAST:event_txfBuscarConductorKeyReleased

    private void txfBuscarConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarConductorKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {
            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);
        }

        if (txfBuscarConductor.getText().length() > 29) {

            evt.consume();

        }
    }//GEN-LAST:event_txfBuscarConductorKeyTyped

    private void btnLimpiarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConductorActionPerformed

        txfCedulaConductor.setRequestFocusEnabled(true);
        limpiarConductor();
        limpiarTablaConductores();
        this.btnGuardarConductor.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarConductorActionPerformed

    private void btnGuardarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarConductorActionPerformed

        actualizarConductor();
    }//GEN-LAST:event_btnGuardarConductorActionPerformed

    private void btnRegistrarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarConductorActionPerformed
        registrarConductor();
    }//GEN-LAST:event_btnRegistrarConductorActionPerformed

    private void btn_12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MousePressed

        if (verificarSalida()) {

            setColor(btn_12);
            ind_12.setOpaque(true);
            resetColor(new JPanel[]{btn_1, btn_2, btn_5, btn_6, btn_7, btn_10, btn_11, btn_13}, new JPanel[]{ind_1, ind_2, ind_5, ind_6, ind_7, ind_10, ind_11, ind_13});
            parent.removeAll();
            parent.add(GestionarClientes);
            parent.repaint();
            parent.revalidate();

            TipoComboClientes.setRequestFocusEnabled(true);
        } else {

        }
    }//GEN-LAST:event_btn_12MousePressed

    private void btn_12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MouseExited

        if (!GestionarClientes.isShowing()) {
            resetColor1(btn_12);
            ind_12.setOpaque(false);
        }
    }//GEN-LAST:event_btn_12MouseExited

    private void btn_12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12MouseEntered

        setColor(btn_12);
        ind_12.setOpaque(true);
    }//GEN-LAST:event_btn_12MouseEntered

    private void btn_12consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_12consultarEmpleados
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_12consultarEmpleados

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        if (!txfCelularClientes.isEditable()) {
            activarCamposClientes();
            txfIdClientes.setEditable(false);
            txfNombreClientes.requestFocus();
            btnGuardarCliente.setEnabled(true);
            btnEditarCliente.setEnabled(false);
            btnRegistrarCliente.setEnabled(false);
            this.TipoComboClientes.setEnabled(false);
        }
        if (tablaClientes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(tablaClientes, "Seleccione un cliente primero ");
        } else {
            if (tablaClientes.getValueAt(0, 0).equals("Sin resultados...")) {
                JOptionPane.showMessageDialog(tablaClientes, "Seleccione un cliente valido ");
            }
        }


    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnEliminarConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarConductorActionPerformed

        if (tablaConductores.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Elija un conductor primero.");

        } else {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro que desea eliminar este conductor?" + "\n" + "Una vez eliminado no se podrá recuperar.", "Confirmación", JOptionPane.YES_NO_OPTION);
            String codigo = tablaConductores.getValueAt(tablaConductores.getSelectedRow(), 0).toString();

            if (resultado == 0) {

                if (cDao.eliminarConductor(codigo)) {

                    JOptionPane.showMessageDialog(null, "Conductor eliminado correctamente.");
                    limpiarConductor();
                    limpiarTablaConductores();

                } else {

                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el conductor debido a que este se encuentra presente en alguna salida.");
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnEliminarConductorActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        try {
            if (tablaClientes.getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Elija un cliente primero.");

            } else {

                int resultado = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro que desea eliminar este cliente?" + "\n" + "Una vez eliminado no se podrá recuperar.", "Confirmación", JOptionPane.YES_NO_OPTION);
                String codigo = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();

                if (resultado == 0) {

                    ResultSet rs = sDao.buscarSalidaPorCliente(codigo);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente debido a que este se encuentra presente en alguna salida.");
                    } else {
                        if (clDao.eliminarCliente(codigo)) {

                            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                            limpiarClientes();
                            limpiarTablaClientes();

                        } else {

                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente debido a que este se encuentra presente en alguna salida.");
                        }
                    }

                } else {

                }

            }
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        if (tablaUsuarios.getSelectedRow() == -1) {

            JOptionPane.showMessageDialog(null, "Elija un usuario primero.");

        } else {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Está completamente seguro que desea eliminar este usuario?" + "\n" + "Una vez eliminado no se podrá recuperar.", "Confirmación", JOptionPane.YES_NO_OPTION);
            String codigo = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString();

            if (resultado == 0) {

                if (uDao.eliminarUsuario(codigo)) {

                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                    limpiarUsuario();
                    limpiarTablaUsuarios();

                } else {

                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario.");
                }
            } else {

            }
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void txfEditarContraseñaUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEditarContraseñaUsuarioKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEditarContraseñaUsuarioKeyReleased

    private void txfEditarContraseñaUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEditarContraseñaUsuarioKeyTyped
        if (txfEditarContraseñaUsuario.getText().length() > 19) {

            evt.consume();

        }

    }//GEN-LAST:event_txfEditarContraseñaUsuarioKeyTyped

    private void txfCrearContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCrearContraseñaKeyTyped

        if (txfCrearContraseña.getText().length() > 19) {

            evt.consume();

        }

    }//GEN-LAST:event_txfCrearContraseñaKeyTyped

    private void btnEditAlimentarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAlimentarInventarioActionPerformed

        if (!txfCantidadIngresarEspecie.isEditable()) {

            activarCamposAlimentarInventario();
            txfCodigoEspecie.setEditable(false);
            txfCantidadIngresarEspecie.requestFocus();
            btnGuardarAlimentarInventario.setEnabled(true);
            btnEditAlimentarInventario.setEnabled(false);
            btnIngresarEspecie.setEnabled(false);
        }

        if (tablaAlimentarInventario.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(tablaAlimentarInventario, "Seleccione un Item primero ");
        } else {
            if (tablaAlimentarInventario.getValueAt(0, 0).equals("Sin resultados...")) {
                JOptionPane.showMessageDialog(tablaAlimentarInventario, "Seleccione un Item valido ");
            }
        }


    }//GEN-LAST:event_btnEditAlimentarInventarioActionPerformed

    private void btnGuardarAlimentarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAlimentarInventarioActionPerformed

        actualizarAlimentarInventario();

    }//GEN-LAST:event_btnGuardarAlimentarInventarioActionPerformed

    private void tablaAlimentarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlimentarInventarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaAlimentarInventarioMouseClicked

    private void tablaAlimentarInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlimentarInventarioMouseReleased

        try {
            String identificador = tablaAlimentarInventario.getValueAt(tablaAlimentarInventario.getSelectedRow(), 0).toString();

            ResultSet rs;

            rs = iDao.buscarAlimentarInventario(identificador);
            if (rs.next()) {
                desactivarCamposAlimentarInventario();
                txfCodigoEspecie.setText(rs.getString("codigo_ingreso"));
                txfEspecie.setText(rs.getString("nombre_vulgar"));
                txfCantidadIngresarEspecie.setText(rs.getString("cantidad"));
                tamanoCombo.setSelectedItem(rs.getString("tamaño_bolsa"));
                rangoCombo.setSelectedItem(rs.getString("rango"));
                fechaIngreso.setDate(rs.getDate("fecha"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_tablaAlimentarInventarioMouseReleased

    private void btnEliminarAlimentarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlimentarInventarioActionPerformed

        try {
            if (tablaAlimentarInventario.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(tablaAlimentarInventario, "Seleccione un Item primero ");
            } else {
                if (tablaAlimentarInventario.getValueAt(0, 0).equals("Sin resultados...")) {
                    JOptionPane.showMessageDialog(tablaAlimentarInventario, "Seleccione un Item valido ");
                } else {

                    int mensaje = JOptionPane.showConfirmDialog(null, "¡ADVERTENCIA! \n Se recomienda hacer uso de este boton "
                            + "solo si se va a eliminar un registro inmediatamente despues de su creación y si se ha cometido algún error,"
                            + " verifique que el stock sea correcto al realizar la eliminación \n ¿Esta seguro que desea eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                    if (mensaje == 0) {

                        String codigo = tablaAlimentarInventario.getValueAt(tablaAlimentarInventario.getSelectedRow(), 1).toString();
                        String identificador = tablaAlimentarInventario.getValueAt(tablaAlimentarInventario.getSelectedRow(), 0).toString();
                        System.out.println(codigo);
                        ResultSet numero_registros = iDao.contarRegistros(codigo);

                        if (numero_registros.next()) {
                            System.out.println("Entré al if" + " " + numero_registros.getInt("numero_registros"));

                            if (numero_registros.getInt("numero_registros") <= 1) {

                                eliminarDetalleIngreso(codigo, identificador);

                                if (iDao.eliminarIngresoPlanta(codigo)) {

                                } else {
                                    JOptionPane.showMessageDialog(null, "Error, no se eliminó el ingreso de la planta, contacte a los desarrolladores.");
                                }

                            } else {

                                eliminarDetalleIngreso(codigo, identificador);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaSGI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnEliminarAlimentarInventarioActionPerformed

    private void btnLimpiarAlimentarInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarAlimentarInventarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarAlimentarInventarioMouseClicked

    private void btn_13consultarEmpleados(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13consultarEmpleados
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_13consultarEmpleados

    private void btn_13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13MouseEntered
        setColor(btn_13);
        ind_13.setOpaque(true);
    }//GEN-LAST:event_btn_13MouseEntered

    private void btn_13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13MouseExited
        if (!Reservas.isShowing()) {
            resetColor1(btn_13);
            ind_13.setOpaque(false);
        }
    }//GEN-LAST:event_btn_13MouseExited

    private void btn_13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_13MousePressed

        if (verificarSalida()) {

            setColor(btn_13);
            ind_13.setOpaque(true);
            resetColor(new JPanel[]{btn_1, btn_2, btn_5, btn_6, btn_7, btn_10, btn_11, btn_12}, new JPanel[]{ind_1, ind_2, ind_5, ind_6, ind_7, ind_10, ind_11, ind_12});
            parent.removeAll();
            parent.add(Reservas);
            parent.repaint();
            parent.revalidate();
            obtenerMAXreserva();
            IdentificacionCombo.setRequestFocusEnabled(true);
        } else {

        }

    }//GEN-LAST:event_btn_13MousePressed

    private void tablaReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservasMouseClicked

        String codigo = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 0).toString();
        String especie = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 1).toString();
        String rango = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 3).toString();
        String tamaño = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 4).toString();
        String cantidad = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 5).toString();
        txfEspecieReservas.setText(codigo + ". " + especie + ", " + tamaño + ", " + rango);
        txfCantidadReservas.setText(cantidad);

    }//GEN-LAST:event_tablaReservasMouseClicked

    private void tablaReservasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaReservasMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaReservasMouseReleased

    private void tablaReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaReservasKeyReleased

    private void txfIdentificacionReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIdentificacionReservasActionPerformed

        try {
            ResultSet rs;
            String cedula = txfIdentificacionReservas.getText().trim();
            rs = clDao.buscar(cedula);

            if (rs.next()) {

                txfNombreReservas.setText(rs.getString(2));
                txfTelefonoReservas.setText(rs.getString(3));
                btnSeleccionarEspecieReservas.setEnabled(true);
                desactivarCamposReserva();
                txfCodigoPlantaReservas.requestFocus(true);
                txfCodigoPlantaReservas.setEnabled(true);
                btnSeleccionarEspecieReservas.setEnabled(true);

            } else {

                JOptionPane.showMessageDialog(null, "No existe el cliente, llene toda la información y registre el cliente.");
                txfNombreReservas.setText(null);
                txfTelefonoReservas.setText(null);
                txfNombreReservas.requestFocus(true);

            }
        } catch (SQLException ex) {
            Logger.getLogger(VistaSGI.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txfIdentificacionReservasActionPerformed

    private void txfIdentificacionReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionReservasKeyReleased

    private void txfIdentificacionReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionReservasKeyTyped

        char c = evt.getKeyChar();

        if (IdentificacionCombo.getSelectedItem().toString().equalsIgnoreCase("Cédula de Ciudadanía")) {

            if (Character.isDigit(c)) {

            } else {
                evt.consume();
            }

            if (txfIdentificacionReservas.getText().length() > 9) {
                evt.consume();
            }
        } else if (IdentificacionCombo.getSelectedItem().toString().equalsIgnoreCase("NIT")) {

            if (Character.isDigit(c) || Character.toString(c).equals("-")) {

            } else {

                evt.consume();
            }

            if (txfIdentificacionReservas.getText().length() > 11) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txfIdentificacionReservasKeyTyped

    private void txfNombreReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreReservasKeyReleased

    private void txfNombreReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreReservasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        } else {

        }

        if (Character.isDigit(c)) {

            evt.consume();

        }

        if (txfNombreReservas.getText().length() > 29) {
            evt.consume();
        }

    }//GEN-LAST:event_txfNombreReservasKeyTyped

    private void txfTelefonoReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefonoReservasKeyReleased

    private void txfTelefonoReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoReservasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }
        if (txfTelefonoReservas.getText().length() > 9) {
            evt.consume();
        }

    }//GEN-LAST:event_txfTelefonoReservasKeyTyped

    private void btnLimpiarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarReservaActionPerformed

        if (tablaReservas.getRowCount() == 0) {
            limpiarReservas();
            limpiarTablaReservas();
        } else {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la reserva?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {

                cancelarReserva();

            } else {

            }
        }
    }//GEN-LAST:event_btnLimpiarReservaActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed

        if (tablaReservas.getRowCount() != 0) {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la reserva?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {

                cancelarReserva();

            } else {

            }

        }

    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void btnSeleccionarEspecieReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieReservasActionPerformed

        if (txfIdentificacionReservas.getText().trim().length() != 0) {

            reiniciarSeleccionarEspecie();
            ventanaEspeciesSalidas.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(null, "Ingrese una identificación válida primero.");
        }
    }//GEN-LAST:event_btnSeleccionarEspecieReservasActionPerformed

    private void txfEspecieReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfEspecieReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfEspecieReservasKeyReleased

    private void btnQuitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar1ActionPerformed

        try {

            if (tablaReservas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(tablaReservas, "Seleccione un item de la tabla para eliminar ");
            } else {
                int codigo_reserva = Integer.parseInt(lblNumeroReserva.getText());
                int codigo_ingreso = Integer.parseInt(tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 0).toString());
                int cantidad = Integer.parseInt(tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 5).toString());
                String rango = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 3).toString();
                String tamaño = tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 4).toString();

                if (rDao.deshacerReserva(codigo_ingreso, cantidad, tamaño, rango)) {

                    if (rDao.eliminarReserva(codigo_reserva, codigo_ingreso, cantidad, tamaño, rango)) {

                        mostrarEspeciesReservadas();
                        reiniciarSeleccionarEspecie();
                        limpiarEspecieReservas();
                        txfCodigoPlantaReservas.requestFocus(true);

                    } else {
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error.");

                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnQuitar1ActionPerformed

    private void IdentificacionComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IdentificacionComboItemStateChanged

        try {

            if (IdentificacionCombo.getSelectedIndex() == 0 || IdentificacionCombo.getSelectedIndex() == 1) {

                txfIdentificacionReservas.setEnabled(true);
                txfNombreReservas.setEnabled(true);
                txfTelefonoReservas.setEnabled(true);
                txfIdentificacionReservas.setEditable(true);
                txfNombreReservas.setEditable(true);
                txfTelefonoReservas.setEditable(true);
                btnNuevoCliente.setEnabled(true);
                txfIdentificacionReservas.setText(null);
                txfNombreReservas.setText(null);
                txfTelefonoReservas.setText(null);
            }
        } catch (StackOverflowError stk) {

            System.out.println(stk.getMessage());

        }
    }//GEN-LAST:event_IdentificacionComboItemStateChanged

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed

//        try {
//
//            if (IdentificacionCombo.getSelectedItem().toString().equalsIgnoreCase("Cédula de Ciudadanía")) {
//
//                verificarCedula();
//
//            } else if (IdentificacionCombo.getSelectedItem().toString().equalsIgnoreCase("NIT")) {
//
//                verificarNIT();
//
//            } else {
//
//            }
//
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null, "Verifique que la información esté completa, por favor.");
//
//        }

    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void txfCantidadReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCantidadReservasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {

            evt.consume();

        }
    }//GEN-LAST:event_txfCantidadReservasKeyTyped

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        if (tablaReservas.getRowCount() != 0) {

            JOptionPane.showMessageDialog(null, "Reserva creada correctamente.");
            limpiarReservas();
            limpiarTablaReservas();
            obtenerMAXreserva();

        } else {

            JOptionPane.showMessageDialog(null, "Agregue especies para realizar una reserva.");

        }

    }//GEN-LAST:event_btnReservarActionPerformed

    private void txfBuscarConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfBuscarConsultarReservasActionPerformed

        buscarReservas();
    }//GEN-LAST:event_txfBuscarConsultarReservasActionPerformed

    private void txfBuscarConsultarReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarConsultarReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfBuscarConsultarReservasKeyReleased

    private void txfBuscarConsultarReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfBuscarConsultarReservasKeyTyped

        if (txfBuscarConsultarReservas.getText().length() > 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txfBuscarConsultarReservasKeyTyped

    private void txfCodigoReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoReservaActionPerformed

    private void txfCodigoReservaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoReservaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoReservaKeyReleased

    private void txfCodigoReservaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoReservaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoReservaKeyTyped

    private void txfNombreConsultarReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreConsultarReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreConsultarReservasKeyReleased

    private void txfNombreConsultarReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNombreConsultarReservasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreConsultarReservasKeyTyped

    private void tablaConsultarReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarReservasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaConsultarReservasMouseClicked

    private void tablaConsultarReservasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaConsultarReservasMouseReleased


    }//GEN-LAST:event_tablaConsultarReservasMouseReleased

    private void tablaConsultarReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaConsultarReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaConsultarReservasKeyReleased

    private void txfTelefonoConsultarReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoConsultarReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefonoConsultarReservasKeyReleased

    private void txfTelefonoConsultarReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefonoConsultarReservasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {

        } else {
            evt.consume();
        }

        if (txfTelefonoConsultarReservas.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txfTelefonoConsultarReservasKeyTyped

    private void txfIdentificacionConsultarReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionConsultarReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIdentificacionConsultarReservasKeyReleased

    private void txfIdentificacionConsultarReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfIdentificacionConsultarReservasKeyTyped

    }//GEN-LAST:event_txfIdentificacionConsultarReservasKeyTyped

    private void btnLimpiarConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarConsultarReservasActionPerformed

        limpiarConsultarReservas();

    }//GEN-LAST:event_btnLimpiarConsultarReservasActionPerformed

    private void btnCancelarConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarConsultarReservasActionPerformed

        if (tablaConsultarReservas.getRowCount() != 0) {

            int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la reserva?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {

                cancelarConsultarReserva();
                obtenerMAXreserva();
                limpiarConsultarReservas();

            } else {

            }

        }

    }//GEN-LAST:event_btnCancelarConsultarReservasActionPerformed

    private void btnQuitarConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarConsultarReservasActionPerformed

        try {
            if (tablaConsultarReservas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(tablaConsultarReservas, "Seleccione un item de la tabla para eliminar ");
            } else {

                int codigo_reserva = Integer.parseInt(txfCodigoReserva.getText());
                int codigo_ingreso = Integer.parseInt(tablaConsultarReservas.getValueAt(tablaConsultarReservas.getSelectedRow(), 0).toString());
                int cantidad = Integer.parseInt(tablaConsultarReservas.getValueAt(tablaConsultarReservas.getSelectedRow(), 5).toString());
                String rango = tablaConsultarReservas.getValueAt(tablaConsultarReservas.getSelectedRow(), 3).toString();
                String tamaño = tablaConsultarReservas.getValueAt(tablaConsultarReservas.getSelectedRow(), 4).toString();

                if (rDao.deshacerReserva(codigo_ingreso, cantidad, tamaño, rango)) {

                    if (rDao.eliminarReserva(codigo_reserva, codigo_ingreso, cantidad, tamaño, rango)) {

                        mostrarEspeciesConsultarReservas();
                        reiniciarSeleccionarEspecie();

                    } else {
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error.");

                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnQuitarConsultarReservasActionPerformed

    private void btnAgregarConsultarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarConsultarReservasActionPerformed

        if (txfIdentificacionConsultarReservas.getText().trim().length() != 0) {
            ventanaEspeciesSalidas.setVisible(true);
        } else {

            JOptionPane.showMessageDialog(null, "Busque y seleccione una reserva primero.");
        }
    }//GEN-LAST:event_btnAgregarConsultarReservasActionPerformed

    private void btnSeleccionarEspecieReservas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarEspecieReservas4ActionPerformed

        buscarReservas();
    }//GEN-LAST:event_btnSeleccionarEspecieReservas4ActionPerformed

    private void MenuReservaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MenuReservaStateChanged

        if (MenuReserva.getSelectedIndex() == 1) {

            if (tablaReservas.getRowCount() != 0) {

                MenuReserva.setSelectedIndex(0);

                int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea descartar la reserva?" + "\n" + "Recuerde que debe dar click en el botón 'Reservar' para confirmar la reserva.", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {

                    cancelarReserva();
                    MenuReserva.setSelectedIndex(1);
                    txfBuscarConsultarReservas.requestFocus(true);

                }

            } else {
                txfBuscarConsultarReservas.requestFocus(true);

            }
        } else {

            IdentificacionCombo.requestFocus(true);
        }

    }//GEN-LAST:event_MenuReservaStateChanged

    private void ReservasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ReservasFocusLost

    }//GEN-LAST:event_ReservasFocusLost

    private void ReservasComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ReservasComponentHidden

    }//GEN-LAST:event_ReservasComponentHidden

    private void txfCodigoPlantaReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoPlantaReservasActionPerformed
        buscarEspeciesReservas();
    }//GEN-LAST:event_txfCodigoPlantaReservasActionPerformed

    private void txfCodigoPlantaReservasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoPlantaReservasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoPlantaReservasKeyReleased

    private void txfCodigoPlantaReservasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCodigoPlantaReservasKeyTyped

        char c = evt.getKeyChar();

        if (Character.isLowerCase(c)) {

            String cad = ("" + c).toUpperCase();
            c = cad.charAt(0);
            evt.setKeyChar(c);

        }

        if (Character.isSpaceChar(c)) {
            evt.consume();
        }

        if (Character.isAlphabetic(c)) {
            evt.consume();
        }

        if (txfCodigoPlantaReservas.getText().length() >= 6) {
            evt.consume();
        }


    }//GEN-LAST:event_txfCodigoPlantaReservasKeyTyped

    private void txfCantidadReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadReservasActionPerformed

        try {

            if (!txfCodigoPlantaReservas.getText().equals("")) {

                int codigo_ingreso = Integer.parseInt(txfCodigoPlantaReservas.getText());
                int codigo_reserva = Integer.parseInt(lblNumeroReserva.getText());
                String id_cliente = txfIdentificacionReservas.getText();
                int cantidad = Integer.parseInt(txfCantidadReservas.getText());
                String fechaString = fechaActualReservas();
                java.sql.Date fechaApertura = null;
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                fechaApertura = new java.sql.Date(sdf.parse(fechaString).getTime());
                Reserva_ r = new Reserva_(codigo_reserva, id_cliente, codigo_ingreso, tamano, rango, cantidad, fechaApertura, null);

                if (rDao.CrearReserva(r)) {

                    if (rDao.reservar(codigo_ingreso, cantidad, tamano, rango)) {
                        mostrarEspeciesReservadas();
                        limpiarEspecieReservas();
                        txfCodigoPlantaReservas.requestFocus(true);

                    } else {

                        JOptionPane.showMessageDialog(null, "Hubo un error. Verifique la información del cliente y que este esté registrado.");

                    }
                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error. Verifique la información del cliente y que este esté registrado.");

                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un código de planta válido, por favor.");
                limpiarEspecieReservas();

            }
        } catch (Exception ex) {
            Logger.getLogger(SeleccionarEspecie.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txfCantidadReservasActionPerformed

    private void btnSiguienteInfoSalida1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteInfoSalida1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteInfoSalida1ActionPerformed

    private void btnSiguienteInfoSalida2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteInfoSalida2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteInfoSalida2ActionPerformed

    private void btnSiguienteInfoSalida3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteInfoSalida3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteInfoSalida3ActionPerformed

    private void btnSiguienteInfoSalida4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteInfoSalida4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteInfoSalida4ActionPerformed

    private void tablaSalidas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidas1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidas1MouseClicked

    private void tablaSalidas1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidas1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidas1MouseReleased

    private void tablaSalidas1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaSalidas1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSalidas1KeyReleased

    private void btnQuitar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuitar2ActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    public void MAXParcial() {

        try {

            String codigo = txfCodigoSalida.getText().trim() + "-" + txfCodigoSalida2.getText().trim();

            rs = sDao.MAXSalidaParcial(codigo);
            if (rs.next()) {
                if (rs.getString("MAXParcial") == null) {
                    txfParcial.setText("1");
                } else if (rs.getString("MAXParcial").equalsIgnoreCase("0")) {
                    if (sDao.actualizarParcial(codigo)) {
                        txfParcial.setText("2");

                        switch (rs.getString("motivo")) {
                            case "Proyecto":
                                motivoCombo.setSelectedIndex(0);
                                motivoCombo.setEnabled(false);
                                break;
                            case "Promoción":
                                motivoCombo.setSelectedIndex(1);
                                motivoCombo.setEnabled(false);
                                break;
                            case "Venta":
                                motivoCombo.setSelectedIndex(4);
                                motivoCombo.setEnabled(false);
                                break;
                            default:
                                motivoCombo.setSelectedIndex(0);
                                motivoCombo.setEnabled(true);
                                break;

                        }

                        txfDestino.setText(rs.getString("destino"));
                        txfCorregimiento.setText(rs.getString("corregimiento"));
                        txfPredio.setText(rs.getString("predio"));
                        txfConvenio.setText(rs.getString("convenio"));
                        txfIdentificacionClienteSalidas.setText(rs.getString("id_cliente"));
                        txfNombreClienteSalidas.setText(rs.getString("nombre"));
                        txfTelefonoClienteSalidas.setText(rs.getString("celular"));
                        txfIdentificacionClienteSalidas.setEditable(false);
                        txfNombreClienteSalidas.setEditable(false);
                        txfTelefonoClienteSalidas.setEditable(false);

                        if (rs.getString("celular").contains("-")) {
                            IdentificacionComboSalidas.setSelectedIndex(1);
                            IdentificacionComboSalidas.setEnabled(false);
                        } else {
                            IdentificacionComboSalidas.setSelectedIndex(0);
                            IdentificacionComboSalidas.setEnabled(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error, contacte a los desarrolladores.");
                        txfParcial.setText(null);
                        cbEntregaParcial.setSelected(false);
                        motivoCombo.setSelectedIndex(0);
                        motivoCombo.setEnabled(true);
                    }

                } else {
                    txfParcial.setText(Integer.toString(rs.getInt("MAXParcial") + 1));

                    switch (rs.getString("motivo")) {
                        case "Proyecto":
                            motivoCombo.setSelectedIndex(0);
                            motivoCombo.setEnabled(false);
                            break;
                        case "Promoción":
                            motivoCombo.setSelectedIndex(1);
                            motivoCombo.setEnabled(false);
                            break;
                        case "Venta":
                            motivoCombo.setSelectedIndex(4);
                            motivoCombo.setEnabled(false);
                            break;
                        default:
                            motivoCombo.setSelectedIndex(0);
                            motivoCombo.setEnabled(true);
                            break;

                    }

                    txfDestino.setText(rs.getString("destino"));
                    txfCorregimiento.setText(rs.getString("corregimiento"));
                    txfPredio.setText(rs.getString("predio"));
                    txfConvenio.setText(rs.getString("convenio"));
                    txfIdentificacionClienteSalidas.setText(rs.getString("id_cliente"));
                    txfNombreClienteSalidas.setText(rs.getString("nombre"));
                    txfTelefonoClienteSalidas.setText(rs.getString("celular"));
                    txfIdentificacionClienteSalidas.setEditable(false);
                    txfNombreClienteSalidas.setEditable(false);
                    txfTelefonoClienteSalidas.setEditable(false);
                    if (rs.getString("celular").contains("-")) {
                        IdentificacionComboSalidas.setSelectedIndex(1);
                        IdentificacionComboSalidas.setEnabled(false);
                    } else {
                        IdentificacionComboSalidas.setSelectedIndex(0);
                        IdentificacionComboSalidas.setEnabled(false);
                    }
                }

            } else {
                txfParcial.setText("1");
                motivoCombo.setSelectedIndex(0);
                motivoCombo.setEnabled(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VistaSGI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel AlimentarInventario;
    private javax.swing.JPanel ClientePanel;
    private javax.swing.JPanel ConductorPanel;
    public static javax.swing.JPanel ConsultarReserva;
    public static javax.swing.JPanel ConsultarSalida;
    public static javax.swing.JPanel CrearUsuario;
    public static javax.swing.JPanel EspeciesPanel;
    public static javax.swing.JPanel GenerarSalida;
    public static javax.swing.JPanel GestionarClientes;
    public static javax.swing.JPanel GestionarConductores;
    public static javax.swing.JPanel GestionarEspecies;
    public static javax.swing.JPanel GestionarUsuarios;
    public static javax.swing.JComboBox<String> IdentificacionCombo;
    public static javax.swing.JComboBox<String> IdentificacionComboSalidas;
    public static javax.swing.JPanel InfoSalidaPanel;
    public static javax.swing.JPanel Inventario;
    public static javax.swing.JPanel ListarUsuario;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel MensajeIndicador;
    private javax.swing.JTabbedPane MenuReserva;
    private javax.swing.JTabbedPane MenuSalida;
    public static javax.swing.JPanel PerdidaPanel;
    public static javax.swing.JPanel PerfilGerente;
    public static javax.swing.JPanel Reservar;
    public static javax.swing.JPanel Reservas;
    public static javax.swing.JPanel Salidas;
    private javax.swing.JButton SignOut;
    private javax.swing.JComboBox<String> TipoComboClientes;
    public static javax.swing.JPanel TrasplantadoPanel;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregarConsultarReservas;
    private javax.swing.JButton btnAnteriorCliente;
    private javax.swing.JButton btnAnteriorCliente1;
    private javax.swing.JButton btnAnteriorCliente2;
    private javax.swing.JButton btnAnteriorCliente3;
    private javax.swing.JButton btnAnteriorConductor;
    private javax.swing.JButton btnAnteriorConductor1;
    private javax.swing.JButton btnAnteriorConductor2;
    private javax.swing.JButton btnAnteriorConductor3;
    private javax.swing.JButton btnAnteriorConductor4;
    private javax.swing.JButton btnAnteriorConductor5;
    private javax.swing.JButton btnAnteriorConductor6;
    private javax.swing.JButton btnAnteriorConductor7;
    private javax.swing.JButton btnAnteriorConductor8;
    private javax.swing.JButton btnBuscarSalida;
    private javax.swing.JLabel btnCambiar;
    private javax.swing.JButton btnCancelarConsultarReservas;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnCancelarSalida;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnCerrar1;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnEditAlimentarInventario;
    private javax.swing.JButton btnEditarCU;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarConductor;
    private javax.swing.JButton btnEditarEsp;
    private javax.swing.JButton btnEliminarAlimentarInventario;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarConductor;
    private javax.swing.JButton btnEliminarEspecie;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JButton btnGenerarReporte1;
    private javax.swing.JButton btnGuardarAlimentarInventario;
    private javax.swing.JButton btnGuardarCU;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarConductor;
    private javax.swing.JButton btnGuardarEsp;
    private javax.swing.JButton btnIngresarEspecie;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarAlimentarInventario;
    private javax.swing.JButton btnLimpiarClientes;
    private javax.swing.JButton btnLimpiarConductor;
    private javax.swing.JButton btnLimpiarConductorSalidas;
    private javax.swing.JButton btnLimpiarConsulSalidas;
    private javax.swing.JButton btnLimpiarConsultarReservas;
    private javax.swing.JButton btnLimpiarEsp;
    private javax.swing.JButton btnLimpiarInfoEsp;
    private javax.swing.JButton btnLimpiarProveedor2;
    private javax.swing.JButton btnLimpiarProveedor3;
    private javax.swing.JButton btnLimpiarReserva;
    private javax.swing.JButton btnMostrarContraseñaU;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoCliente1;
    private javax.swing.JButton btnNuevoConductor;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitar1;
    private javax.swing.JButton btnQuitar2;
    private javax.swing.JButton btnQuitarConsultarReservas;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnRegistrarConductor;
    private javax.swing.JButton btnRegistrarEsp;
    private javax.swing.JButton btnRegistrarSalida;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSeleccionarEspecie;
    private javax.swing.JButton btnSeleccionarEspecieReservas;
    private javax.swing.JButton btnSeleccionarEspecieReservas2;
    private javax.swing.JButton btnSeleccionarEspecieReservas3;
    private javax.swing.JButton btnSeleccionarEspecieReservas4;
    private javax.swing.JButton btnSeleccionarEspecieS;
    private javax.swing.JButton btnSiguienteCliente;
    private javax.swing.JButton btnSiguienteConductor;
    private javax.swing.JButton btnSiguienteInfoSalida;
    private javax.swing.JButton btnSiguienteInfoSalida1;
    private javax.swing.JButton btnSiguienteInfoSalida2;
    private javax.swing.JButton btnSiguienteInfoSalida3;
    private javax.swing.JButton btnSiguienteInfoSalida4;
    private javax.swing.JButton btnTrasplantar;
    public static javax.swing.JPanel btn_1;
    public static javax.swing.JPanel btn_10;
    public static javax.swing.JPanel btn_11;
    public static javax.swing.JPanel btn_12;
    public static javax.swing.JPanel btn_13;
    public static javax.swing.JPanel btn_2;
    public static javax.swing.JPanel btn_5;
    public static javax.swing.JPanel btn_6;
    public static javax.swing.JPanel btn_7;
    private javax.swing.JCheckBox cbEntregaParcial;
    private javax.swing.JComboBox<String> estadoComboCU;
    public static final com.toedter.calendar.JDateChooser fechaDesde = new com.toedter.calendar.JDateChooser();
    public static com.toedter.calendar.JDateChooser fechaDesdeSalida;
    public static final com.toedter.calendar.JDateChooser fechaHasta = new com.toedter.calendar.JDateChooser();
    public static com.toedter.calendar.JDateChooser fechaHastaSalida;
    public static final com.toedter.calendar.JDateChooser fechaIngreso = new com.toedter.calendar.JDateChooser();
    public static final com.toedter.calendar.JDateChooser fechaSalida = new com.toedter.calendar.JDateChooser();
    public static javax.swing.JPanel ind_1;
    public static javax.swing.JPanel ind_10;
    public static javax.swing.JPanel ind_11;
    public static javax.swing.JPanel ind_12;
    public static javax.swing.JPanel ind_13;
    public static javax.swing.JPanel ind_2;
    public static javax.swing.JPanel ind_5;
    public static javax.swing.JPanel ind_6;
    public static javax.swing.JPanel ind_7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelStock;
    public static javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblConvenio;
    public static javax.swing.JLabel lblDisponibles;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNumSalidas;
    private javax.swing.JLabel lblNumUsuarios;
    private javax.swing.JLabel lblNumVentas;
    public static javax.swing.JLabel lblNumeroEspecie;
    public static javax.swing.JLabel lblNumeroReserva;
    private javax.swing.JLabel lblStock1;
    private javax.swing.JLabel lblTitulo;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JLabel lblTotalConsultarReservas;
    private javax.swing.JLabel lblguion;
    public static javax.swing.JComboBox<String> motivoCombo;
    public static javax.swing.JComboBox<String> motivoComboConsultarSalida;
    public static javax.swing.JPanel parent;
    private javax.swing.JTextField passInput1;
    public static javax.swing.JComboBox<String> rangoCombo;
    public static javax.swing.JComboBox<String> rangoComboTrasplantado;
    private javax.swing.JPanel side_pane;
    public static diu.swe.habib.JPanelSlider.JPanelSlider slidePanel;
    private javax.swing.JTable tablaAgotados;
    public static final javax.swing.JTable tablaAlimentarInventario = new javax.swing.JTable();
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaConductores;
    public static javax.swing.JTable tablaConsultarReservas;
    public static javax.swing.JTable tablaConsultarSalidas;
    private javax.swing.JTable tablaEspecies;
    public static javax.swing.JTable tablaInventario;
    public static javax.swing.JTable tablaReservas;
    public static javax.swing.JTable tablaSalidas;
    public static javax.swing.JTable tablaSalidas1;
    private javax.swing.JTable tablaUsuarios;
    public static javax.swing.JComboBox<String> tamanoCombo;
    public static javax.swing.JComboBox<String> tamanoComboTrasplantado;
    private javax.swing.JTextField txfApellido;
    private javax.swing.JTextField txfApellido1;
    private javax.swing.JTextField txfApellidoConductor;
    private javax.swing.JTextField txfApellidoConductorSalidas;
    private javax.swing.JTextField txfBuscarCliente;
    private javax.swing.JTextField txfBuscarConductor;
    private javax.swing.JTextField txfBuscarConsultarReservas;
    public static javax.swing.JTextField txfBuscarConsultarSalida;
    private javax.swing.JTextField txfBuscarEsp;
    public static final javax.swing.JTextField txfBuscarEspecie = new javax.swing.JTextField();
    private javax.swing.JTextField txfBuscarInventario;
    private javax.swing.JTextField txfBuscarUsuarios;
    public static final javax.swing.JTextField txfCantidadIngresarEspecie = new javax.swing.JTextField();
    public static javax.swing.JTextField txfCantidadPerdida;
    public static javax.swing.JTextField txfCantidadReservas;
    public static javax.swing.JTextField txfCantidadSalidas;
    public static final javax.swing.JTextField txfCantidadTrasplantado = new javax.swing.JTextField();
    private javax.swing.JTextField txfCedulaConductor;
    private javax.swing.JTextField txfCedulaConductorSalidas;
    private javax.swing.JTextField txfCelular;
    private javax.swing.JTextField txfCelular1;
    private javax.swing.JTextField txfCelularClientes;
    private javax.swing.JTextField txfCelularConductor;
    private javax.swing.JTextField txfCelularConductorSalidas;
    public static javax.swing.JTextField txfCodigoEspcSalidas;
    public static javax.swing.JTextField txfCodigoEspecie;
    public static javax.swing.JTextField txfCodigoPerdida;
    public static javax.swing.JTextField txfCodigoPlantaReservas;
    public static javax.swing.JTextField txfCodigoReserva;
    private javax.swing.JTextField txfCodigoSalida;
    private javax.swing.JTextField txfCodigoSalida2;
    private javax.swing.JTextField txfConvenio;
    private javax.swing.JTextField txfCorregimiento;
    private javax.swing.JPasswordField txfCrearContraseña;
    private javax.swing.JTextField txfDestino;
    private javax.swing.JTextField txfDireccion;
    private javax.swing.JTextField txfDireccion1;
    private javax.swing.JTextField txfEditarContraseñaUsuario;
    public static javax.swing.JTextField txfEspecie;
    public static javax.swing.JTextField txfEspeciePerdida;
    public static javax.swing.JTextField txfEspecieReservas;
    public static javax.swing.JTextField txfEspecieSalidas;
    public static javax.swing.JTextField txfEspecieTrasplantado;
    private javax.swing.JTextField txfFamilia;
    private javax.swing.JTextField txfIdClientes;
    public static javax.swing.JTextField txfIdentificacionClienteSalidas;
    public static javax.swing.JTextField txfIdentificacionConsultarReservas;
    public static javax.swing.JTextField txfIdentificacionReservas;
    private javax.swing.JTextField txfMsnm;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfNombre1;
    private javax.swing.JTextField txfNombreCien;
    public static javax.swing.JTextField txfNombreClienteSalidas;
    private javax.swing.JTextField txfNombreClientes;
    private javax.swing.JTextField txfNombreComun;
    private javax.swing.JTextField txfNombreConductor;
    private javax.swing.JTextField txfNombreConductorSalidas;
    public static javax.swing.JTextField txfNombreConsultarReservas;
    private javax.swing.JTextField txfNombreReservas;
    private javax.swing.JTextField txfParcial;
    public static javax.swing.JTextField txfPedido;
    private javax.swing.JTextField txfPlacaSalidas;
    private javax.swing.JTextField txfPredio;
    public static javax.swing.JTextField txfStockPerdida;
    public static javax.swing.JTextField txfStockSalidas;
    public static javax.swing.JTextField txfTelefonoClienteSalidas;
    public static javax.swing.JTextField txfTelefonoConsultarReservas;
    private javax.swing.JTextField txfTelefonoReservas;
    private javax.swing.JTextField txfUsuario;
    private javax.swing.JTextField txfUsuario1;
    // End of variables declaration//GEN-END:variables

    public static String fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);
    }

    public static String fechaActualReservas() {
        java.util.Date fecha = new java.util.Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }

    public static String mesActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MM");
        return formatoFecha.format(fecha);
    }

    public static String añoActual() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY");
        return formatoFecha.format(fecha);
    }

    public static String fechaSalida() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY-MM-dd");
        return formatoFecha.format(fecha);
    }

    public void desactivarCamposReserva() {

        IdentificacionCombo.setEnabled(false);
        txfIdentificacionReservas.setEnabled(false);
        txfNombreReservas.setEnabled(false);
        txfTelefonoReservas.setEnabled(false);

    }

    public void eliminarDetalleIngreso(String codigo, String identificador) {
        if (iDao.eliminarItemAlimentarInventario(identificador)) {

            int cantidad = Integer.parseInt(tablaAlimentarInventario.getValueAt(tablaAlimentarInventario.getSelectedRow(), 5).toString());

            if (iDao.restarCantidadInventario(cantidad, codigo)) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente.");
                limpiarIngresarEspecie();
                activarCamposAlimentarInventario();
                btnSeleccionarEspecie.setEnabled(true);
                btnGuardarAlimentarInventario.setEnabled(false);
                tamanoCombo.setEnabled(true);
                rangoCombo.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "¡Advertencia! no se resto la cantidad al stock.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El registro no se eliminó correctamente");
        }
    }

    public void verificarParcial() {

        try {
            String codigo_salida = txfCodigoSalida.getText().trim() + "-" + txfCodigoSalida2.getText().trim();
            rs = sDao.buscarCodigoSalida(codigo_salida);
            int resultado;
            if (rs.next()) {

                if (cbEntregaParcial.isSelected() == false) {
                    resultado = JOptionPane.showConfirmDialog(null, "La salida ya existe ¿Desea registrar esta salida con entregas parciales?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (resultado == 0) {
                        cbEntregaParcial.setSelected(true);
                        siguienteInfoSalida();
                    }
                } else {
                    siguienteInfoSalida();
                }
            } else {
                siguienteInfoSalida();
            }
        } catch (SQLException ex) {
        }
    }

    public void obtenerMAXEspecie() {

        try {
            rs = eDao.MAXEspecie();

            if (rs.next()) {

                int numero = rs.getInt(1) + 1;
                lblNumeroEspecie.setText(Integer.toString(numero));

            } else {

            }

        } catch (SQLException ex) {
        }
    }

    public void cancelarSalida() {

        int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cancelar la salida?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (resultado == 0) {

            for (int i = 0; i < tablaSalidas.getRowCount(); i++) {

                String codigo = tablaSalidas.getValueAt(i, 0).toString();
                int cantidad = Integer.parseInt(tablaSalidas.getValueAt(i, 6).toString());
                String tamano = tablaSalidas.getValueAt(i, 3).toString();
                String rango = tablaSalidas.getValueAt(i, 4).toString();

                if (sDao.cancelarSalida(codigo, cantidad)) {

                } else {

                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
                }

            }

            JOptionPane.showMessageDialog(null, "Salida cancelada correctamente.");
            motivoCombo.setSelectedIndex(0);
            txfConvenio.setText(convenio());
            IdentificacionComboSalidas.setSelectedIndex(0);
            limpiarSalidas();
            limpiarTablaSalidas();
            reiniciarSeleccionarEspecie();

        } else {

        }
    }

    public void limpiarCUsuario() {

        txfUsuario1.setText(null);
        txfNombre1.setText(null);
        txfApellido1.setText(null);
        txfCelular1.setText(null);
        txfDireccion1.setText(null);
        jLabel69.setVisible(false);

    }

    public void cancelarTrasplantado() {

        btnRegistrarSalida.setEnabled(true);
        JOptionPane.showMessageDialog(null, "Salida cancelada correctamente.");
        motivoCombo.setSelectedIndex(0);
        IdentificacionComboSalidas.setSelectedIndex(0);
        limpiarSalidas();
    }

    public void limpiarConsultarReservas() {

        txfCodigoReserva.setText(null);
        txfIdentificacionConsultarReservas.setText(null);
        txfNombreConsultarReservas.setText(null);
        txfTelefonoConsultarReservas.setText(null);
        txfBuscarConsultarReservas.setText(null);
        txfConvenio.setText(convenio());
        limpiarTablaConsultarReservas();
    }

    public void limpiarTablaConsultarReservas() {
        DefaultTableModel modelo = (DefaultTableModel) tablaConsultarReservas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaSalidas() {
        DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }

    public void limpiarTablaConsultarSalidas() {
        DefaultTableModel modelo = (DefaultTableModel) tablaConsultarSalidas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaReservas() {
        DefaultTableModel modelo = (DefaultTableModel) tablaReservas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarSalidas() {

        try {
            limpiarInfoSalida();
            limpiarConductorSalida();
            limpiarClienteSalidas();
            limpiarEspecieSalidas();
            limpiarTrasplantado();
            limpiarPerdida();
            IdentificacionComboSalidas.setEnabled(true);
            IdentificacionComboSalidas.setSelectedIndex(0);
            java.util.Date fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
            fechaSalida.setDate(fechaParseada);
            txfParcial.setText(null);
            cbEntregaParcial.setSelected(false);

            this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);
        } catch (ParseException ex) {
        }

    }

    public void limpiarConductor() {

        this.txfCedulaConductor.setText(null);
        this.txfCelularConductor.setText(null);
        this.txfNombreConductor.setText(null);
        this.txfApellidoConductor.setText(null);
        this.txfBuscarConductor.setText(null);
        this.txfCedulaConductor.setEditable(true);
        this.txfCelularConductor.setEditable(true);
        this.txfNombreConductor.setEditable(true);
        this.txfApellidoConductor.setEditable(true);
        this.txfCedulaConductor.requestFocus();
        activarCamposConductores();
    }

    public void limpiarClientes() {

        this.txfIdClientes.setText(null);
        this.txfCelularClientes.setText(null);
        this.txfNombreClientes.setText(null);
        this.txfBuscarCliente.setText(null);
        this.txfIdClientes.setEditable(true);
        this.txfCelularClientes.setEditable(true);
        this.txfNombreClientes.setEditable(true);
        this.btnGuardarCliente.setEnabled(false);
        this.txfIdClientes.requestFocus();
        this.TipoComboClientes.setSelectedIndex(0);
        activarCamposClientes();
    }

    public void limpiarReservas() {
        limpiarEspecieReservas();
        IdentificacionCombo.setSelectedIndex(0);
        txfIdentificacionReservas.setText(null);
        txfNombreReservas.setText(null);
        txfTelefonoReservas.setText(null);
        activarCamposClienteReservas();
        desactivarCamposEspecieReserva();
        txfIdentificacionReservas.requestFocus(true);
    }

    public void activarCamposClienteReservas() {

        IdentificacionCombo.setEnabled(true);
        txfIdentificacionReservas.setEnabled(true);
        txfNombreReservas.setEnabled(true);
        txfTelefonoReservas.setEnabled(true);
        btnNuevoCliente.setEnabled(true);

    }

    public void desactivarCamposEspecieReserva() {
        txfCodigoPlantaReservas.setEnabled(false);
        btnSeleccionarEspecieReservas.setEnabled(false);
        txfCantidadReservas.setEnabled(false);
    }

    public void cancelarReserva() {

        DefaultTableModel modelo = (DefaultTableModel) tablaReservas.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {

            int codigo_reserva = Integer.parseInt(lblNumeroReserva.getText());
            int codigo_ingreso = Integer.parseInt(tablaReservas.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tablaReservas.getValueAt(i, 5).toString());
            String rango = tablaReservas.getValueAt(i, 3).toString();
            String tamaño = tablaReservas.getValueAt(i, 4).toString();

            if (rDao.deshacerReserva(codigo_ingreso, cantidad, tamaño, rango)) {

                if (rDao.eliminarReserva(codigo_reserva, codigo_ingreso, cantidad, tamaño, rango)) {

                    JOptionPane.showMessageDialog(null, "Reserva cancelada correctamente.");

                } else {
                }

            } else {

                JOptionPane.showMessageDialog(null, "Hubo un error.");

            }
        }

        limpiarTablaReservas();
        limpiarReservas();

    }

    public void limpiarConductorSalida() {

        this.txfCedulaConductorSalidas.setText(null);
        this.txfCelularConductorSalidas.setText(null);
        this.txfNombreConductorSalidas.setText(null);
        this.txfApellidoConductorSalidas.setText(null);
        this.txfPlacaSalidas.setText(null);
        this.txfCedulaConductorSalidas.setEditable(true);
        this.txfCelularConductorSalidas.setEditable(true);
        this.txfNombreConductorSalidas.setEditable(true);
        this.txfApellidoConductorSalidas.setEditable(true);

    }

    public void obtenerMAXreserva() {

        try {
            rs = rDao.MAXreserva();

            if (rs.next()) {

                int numero = rs.getInt(1) + 1;
                lblNumeroReserva.setText(Integer.toString(numero));

            } else {

            }

        } catch (SQLException ex) {
        }
    }

    public void mostrarEspeciesConsultarReservas() {

        try {

            DefaultTableModel modelo;
            String codigo_reserva = txfCodigoReserva.getText();
            modelo = rDao.mostrarReservadas(codigo_reserva);
            TableColumnModel column = tablaConsultarReservas.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaConsultarReservas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            column.getColumn(1).setPreferredWidth(200);

        } catch (Exception e) {

        }

    }

    public void cancelarConsultarReserva() {

        DefaultTableModel modelo = (DefaultTableModel) tablaConsultarReservas.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {

            int codigo_reserva = Integer.parseInt(txfCodigoReserva.getText());
            int codigo_ingreso = Integer.parseInt(tablaConsultarReservas.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tablaConsultarReservas.getValueAt(i, 5).toString());
            String rango = tablaConsultarReservas.getValueAt(i, 3).toString();
            String tamaño = tablaConsultarReservas.getValueAt(i, 4).toString();

            if (rDao.deshacerReserva(codigo_ingreso, cantidad, tamaño, rango)) {

                if (rDao.eliminarReserva(codigo_reserva, codigo_ingreso, cantidad, tamaño, rango)) {

                } else {
                }

            } else {

                JOptionPane.showMessageDialog(null, "Hubo un error al deshacer la reserva.");

            }
        }

        limpiarTablaConsultarReservas();

    }

    public void actualizarCliente() {

        try {

            if (txfNombreClientes.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Llene los campos obligatorios, por favor.");

            } else {

                String codigo = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
                String nombre = txfNombreClientes.getText().trim();
                long celular = 0;

                if (txfCelularClientes.getText().trim().length() != 0) {

                    celular = Long.parseLong(txfCelularClientes.getText().trim());
                }

                if (clDao.actualizarCliente(codigo, nombre, celular)) {
                    JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
                    this.btnEditarCliente.setEnabled(true);
                    this.btnGuardarCliente.setEnabled(false);
                    this.btnRegistrarCliente.setEnabled(true);
                    limpiarClientes();
                    limpiarTablaClientes();

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar, inténtelo nuevamente.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void actualizarAlimentarInventario() {

        try {

            if (txfCantidadIngresarEspecie.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Llene los campos obligatorios, por favor.");

            } else {

                String identificador = tablaAlimentarInventario.getValueAt(tablaAlimentarInventario.getSelectedRow(), 0).toString();
                String cantidad = txfCantidadIngresarEspecie.getText();
                String fecha = fechaIngreso.getDate().toString();
                String codigo = tablaAlimentarInventario.getValueAt(tablaAlimentarInventario.getSelectedRow(), 1).toString();
                int cantidadInicial = 0;
                int cantidadFinal = 0;

                System.out.println("Id: " + identificador + " cant: " + cantidad + " Date: " + fecha + " cod: " + codigo);

                ResultSet rs = iDao.obtenerRegistroYstock(identificador, codigo);

                if (rs.next()) {
                    cantidadInicial = rs.getInt("cantidad");
                    if (cantidadInicial <= rs.getInt("stock")) {
                        cantidadFinal = Integer.parseInt(txfCantidadIngresarEspecie.getText());
                        if (iDao.actualizarAlimentarInventario(cantidad, fecha, codigo, identificador)) {

                            if (iDao.restarCantidadInventario(cantidadInicial, codigo)) {
                                if (iDao.sumarCantidadInventario(cantidadFinal, codigo)) {
                                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente.");
                                    activarCamposAlimentarInventario();
                                    btnSeleccionarEspecie.setEnabled(true);
                                    btnGuardarAlimentarInventario.setEnabled(false);
                                    tamanoCombo.setEnabled(true);
                                    rangoCombo.setEnabled(true);
                                    limpiarIngresarEspecie();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha actualizado el stock correctamente.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar, inténtelo nuevamente.");
                        }
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void actualizarConductor() {

        try {

            if (txfNombreConductor.getText().length() == 0 || txfApellidoConductor.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Llene los campos obligatorios, por favor.");

            } else {

                String codigo = tablaConductores.getValueAt(tablaConductores.getSelectedRow(), 0).toString();
                String nombre = txfNombreConductor.getText().trim();
                String apellido = txfApellidoConductor.getText().trim();
                long celular = 0;

                if (txfCelularConductor.getText().trim().length() != 0) {

                    celular = Long.parseLong(txfCelularConductor.getText().trim());
                }

                if (cDao.actualizar(codigo, nombre, apellido, celular)) {
                    JOptionPane.showMessageDialog(null, "Conductor actualizado correctamente.");
                    this.btnEditarConductor.setEnabled(true);
                    this.btnGuardarConductor.setEnabled(false);
                    this.btnRegistrarConductor.setEnabled(true);
                    limpiarConductor();
                    limpiarTablaConductores();

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar, inténtelo nuevamente.");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void seleccionarUsuario() {

        try {

            ResultSet rs;

            String cod = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString();

            this.txfUsuario1.setText(cod);

            rs = uDao.buscar(cod);

            if (rs.next()) {

                this.txfNombre1.setText(rs.getString("nombre_usuario"));
                this.txfApellido1.setText(rs.getString("apellido"));
                this.txfCelular1.setText(rs.getString("celular"));
                this.txfDireccion1.setText(rs.getString("direccion"));
                this.txfEditarContraseñaUsuario.setText(rs.getString("contraseña"));

                desactivarCamposCUsuario();
                this.btnGuardarCU.setEnabled(false);
                this.btnEditarCU.setEnabled(true);

            } else {

                JOptionPane.showMessageDialog(null, "No se encontró el usuario.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Seleccione un usuario primero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se encontró el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void buscarEspecies(String busca) {

        DefaultTableModel modelo;
        TableColumnModel column = tablaEspecies.getColumnModel();
        modelo = eDao.buscarPlanta(busca);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tablaEspecies.setModel(modelo);
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tablaEspecies.getColumnModel().getColumn(1).setCellRenderer(tcr);
        column.getColumn(0).setPreferredWidth(150);
        column.getColumn(1).setPreferredWidth(150);

    }

    public void buscarUsuario(String busca) {
        DefaultTableModel modelo;
        TableColumnModel column = tablaUsuarios.getColumnModel();
        modelo = uDao.buscarUsuario(busca);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tablaUsuarios.setModel(modelo);
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tablaUsuarios.getColumnModel().getColumn(1).setCellRenderer(tcr);
        column.getColumn(1).setPreferredWidth(200);

    }

    public void buscarReservas() {

        try {

            if (txfBuscarConsultarReservas.getText().trim().length() == 0) {

                JOptionPane.showMessageDialog(null, "Ingrese una cédula o un código de reserva, por favor.");

            } else {

                reiniciarListaReservas();
                ventanaCodigos.setVisible(true);

                DefaultTableModel modelo;
                modelo = rDao.mostrarCodigosReservas(txfBuscarConsultarReservas.getText().trim());
                TableColumnModel column = CodigosReservas.tablaCodigosReservas.getColumnModel();
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
                CodigosReservas.tablaCodigosReservas.setModel(modelo);
                tcr.setHorizontalAlignment(SwingConstants.LEFT);
                column.getColumn(1).setPreferredWidth(200);
            }

        } catch (Exception e) {

        }

    }

    public void reiniciarListaReservas() {

        DefaultTableModel modelo = (DefaultTableModel) ventanaCodigos.tablaCodigosReservas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void seleccionarEspecie() {

        try {

            ResultSet rs;

            String codigo = tablaEspecies.getValueAt(tablaEspecies.getSelectedRow(), 0).toString();
            rs = eDao.buscarEspecie(codigo);

            if (rs.next()) {

                this.txfNombreCien.setText(rs.getString("nombre_cientifico"));
                this.txfNombreComun.setText(rs.getString("nombre_vulgar"));
                this.txfFamilia.setText(rs.getString("familia"));
                this.txfMsnm.setText(rs.getString("msnm"));

                desactivarCamposEspecies();
                this.btnGuardarEsp.setEnabled(false);
                this.btnEditarEsp.setEnabled(true);
                this.btnRegistrarEsp.setEnabled(false);

            } else {

                JOptionPane.showMessageDialog(null, "No se encontró la especie.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Seleccione una especie primero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se encontró la especie.", "Error", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void seleccionarCliente() {

        try {

            ResultSet rs;

            String codigo = tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 0).toString();
            rs = clDao.buscar(codigo);

            if (rs.next()) {
                if (codigo.contains("-")) {
                    TipoComboClientes.setSelectedIndex(1);
                } else {
                    TipoComboClientes.setSelectedIndex(0);
                }
                this.txfIdClientes.setText(codigo);
                this.txfNombreClientes.setText(rs.getString("nombre"));
                this.txfCelularClientes.setText(rs.getString("celular"));

                desactivarCamposClientes();
                this.btnGuardarCliente.setEnabled(false);
                this.btnEditarCliente.setEnabled(true);
                this.btnRegistrarCliente.setEnabled(false);

            } else {

                JOptionPane.showMessageDialog(null, "No se encontró el cliente.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente primero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se encontró el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void seleccionarConductor() {

        try {

            ResultSet rs;

            String codigo = tablaConductores.getValueAt(tablaConductores.getSelectedRow(), 0).toString();
            rs = cDao.buscar(codigo);

            if (rs.next()) {

                this.txfCedulaConductor.setText(codigo);
                this.txfNombreConductor.setText(rs.getString("nombre"));
                this.txfApellidoConductor.setText(rs.getString("apellido"));
                this.txfCelularConductor.setText(rs.getString("celular"));

                desactivarCamposConductores();
                this.btnGuardarConductor.setEnabled(false);
                this.btnEditarConductor.setEnabled(true);
                this.btnRegistrarConductor.setEnabled(false);

            } else {

                JOptionPane.showMessageDialog(null, "No se encontró el conductor.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Seleccione un conductor primero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se encontró el conductor.", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void mostrarProductosAgotados() {

        try {

            DefaultTableModel modelo;
            modelo = iDao.mostrarAgotados();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaAgotados.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            TableColumnModel column = tablaAgotados.getColumnModel();
            column.getColumn(1).setPreferredWidth(150);
            tablaAgotados.setForeground(Color.red);

        } catch (Exception e) {

        }

    }

    public void mostrarUsuariosInactivos() {

        DefaultTableModel modelo;
        modelo = uDao.mostrarINACTIVOS();
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        this.tablaUsuarios.setModel(modelo);
        tablaUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12));
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tablaUsuarios.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tablaUsuarios.getColumnModel().getColumn(1).setCellRenderer(tcr);
        TableColumnModel column = tablaUsuarios.getColumnModel();
        column.getColumn(1).setPreferredWidth(200);
        tablaUsuarios.setForeground(Color.red);

    }

    public void limpiarSeleccionarEspecies() {

        txfCodigoEspcSalidas.setText(null);
        txfCodigoEspcSalidas.setEditable(true);
        txfEspecieSalidas.setText(null);
        txfStockSalidas.setText(null);
        txfCantidadSalidas.setText(null);
        txfCantidadSalidas.setEditable(false);
        txfPedido.setText(null);
        txfPedido.setEditable(false);
        txfCodigoEspcSalidas.requestFocus(true);
    }

    public void limpiarRUsuario() {

        txfUsuario.setText(null);
        txfNombre.setText(null);
        txfApellido.setText(null);
        txfCelular.setText(null);
        txfDireccion.setText(null);
        txfCrearContraseña.setText(null);
    }

    public void limpiarInfoSalida() {

        txfCodigoSalida.setText(null);
        txfCodigoSalida2.setText(Integer.toString(fecha.get(Calendar.YEAR)));
        txfConvenio.setText(null);
        txfDestino.setText(null);
        txfPredio.setText(null);
        txfCorregimiento.setText(null);
        txfCodigoSalida.setText(null);
        txfConvenio.setEditable(true);
        motivoCombo.setEnabled(true);
        
        
    }

    public void limpiarUsuario() {

        txfUsuario1.setText(null);
        txfNombre1.setText(null);
        txfApellido1.setText(null);
        txfCelular1.setText(null);
        txfDireccion1.setText(null);
        txfBuscarUsuarios.setText(null);
        txfEditarContraseñaUsuario.setText(null);
        this.txfEditarContraseñaUsuario.setVisible(false);
        this.jLabel69.setVisible(false);

    }

    public void limpiarClienteSalidas() {

        this.txfIdentificacionClienteSalidas.setText(null);
        this.txfNombreClienteSalidas.setText(null);
        this.txfTelefonoClienteSalidas.setText(null);
        this.txfNombreClienteSalidas.setEditable(true);
        this.txfTelefonoClienteSalidas.setEditable(true);
        this.txfIdentificacionClienteSalidas.setEditable(true);

    }

    public void limpiarEspecieSalidas() {

        txfStockSalidas.setText(null);
        this.txfEspecieSalidas.setText(null);
        this.txfCantidadSalidas.setText(null);
        this.txfCantidadSalidas.setEditable(false);
        this.txfCodigoEspcSalidas.setText(null);
        this.txfCodigoEspcSalidas.setEditable(true);

    }

    public void limpiarTrasplantado() {

        this.txfEspecieTrasplantado.setText(null);
        this.txfCantidadTrasplantado.setText(null);
        txfEspecieTrasplantado.setEditable(true);
        txfCantidadTrasplantado.setEditable(false);
        lblStock1.setVisible(false);
        labelStock.setVisible(false);
        labelStock.setText(null);
        tamanoComboTrasplantado.setSelectedIndex(0);
        rangoComboTrasplantado.setSelectedIndex(0);
        btnSeleccionarEspecieReservas3.setEnabled(true);
    }

    public void limpiarPerdida() {

        this.txfCodigoPerdida.setText(null);
        this.txfCodigoPerdida.setEditable(true);
        this.txfEspeciePerdida.setText(null);
        this.txfStockPerdida.setText(null);
        this.txfCantidadPerdida.setText(null);
        this.txfCantidadPerdida.setEditable(false);
    }

    public void limpiarEspecies() {

        this.txfNombreCien.setText(null);
        this.txfNombreComun.setText(null);
        this.txfFamilia.setText(null);
        this.txfMsnm.setText(null);
        this.txfBuscarEsp.setText(null);
        this.btnRegistrarEsp.setEnabled(true);
        this.btnGuardarEsp.setEnabled(false);
        limpiarTablaEspecies();
        activarCamposEspecies();
    }

    public void limpiarIngresarEspecie() {

        try {
            txfCodigoEspecie.setEnabled(true);
            txfCodigoEspecie.setText("");
            txfEspecie.setText("");
            tamanoCombo.setSelectedIndex(0);
            rangoCombo.setSelectedIndex(0);
            txfCantidadIngresarEspecie.setText("");
            txfBuscarEspecie.setText("");
            java.util.Date fechaParseada = new SimpleDateFormat("dd/MM/yyyy").parse(fechaActual());
            fechaIngreso.setDate(fechaParseada);
            fechaDesde.setDate(fechaParseada);
            fechaHasta.setDate(fechaParseada);
            buscarIngresosFecha(fechaActual(), fechaActual());
            txfCodigoEspecie.requestFocus(true);

        } catch (ParseException ex) {

        }

    }

    public void limpiarEspecieReservas() {

        txfCodigoPlantaReservas.setText(null);
        txfEspecieReservas.setText(null);
        txfCantidadReservas.setText(null);
        lblDisponibles.setText(null);

    }

    public void activarCamposConductores() {

        this.txfCedulaConductor.setEditable(true);
        this.txfNombreConductor.setEditable(true);
        this.txfApellidoConductor.setEditable(true);
        this.txfCelularConductor.setEditable(true);
        this.btnRegistrarConductor.setEnabled(true);
        this.btnEditarConductor.setEnabled(true);

    }

    public void activarCamposClientes() {

        this.txfIdClientes.setEditable(true);
        this.txfNombreClientes.setEditable(true);
        this.txfCelularClientes.setEditable(true);
        this.TipoComboClientes.setEnabled(true);
        this.btnRegistrarCliente.setEnabled(true);
        this.btnEditarCliente.setEnabled(true);

    }

    public void activarCamposAlimentarInventario() {

        this.btnSeleccionarEspecie.setEnabled(false);
        this.btnEditAlimentarInventario.setEnabled(true);
        this.btnIngresarEspecie.setEnabled(true);

        this.txfCodigoEspecie.setEditable(true);
        this.fechaIngreso.setEnabled(true);
        this.txfCantidadIngresarEspecie.setEditable(true);

    }

    public void activarCamposCUsuario() {

        this.txfUsuario1.setEditable(true);
        this.txfNombre1.setEditable(true);
        this.txfApellido1.setEditable(true);
        this.txfCelular1.setEditable(true);
        this.txfDireccion1.setEditable(true);
        this.txfEditarContraseñaUsuario.setEditable(true);
    }

    public void activarCamposEspecies() {

        this.txfNombreCien.setEditable(true);
        this.txfNombreComun.setEditable(true);
        this.txfFamilia.setEditable(true);
        this.txfMsnm.setEditable(true);
    }

    public void desactivarCamposAlimentarInventario() {
        this.txfCodigoEspecie.setEditable(false);
        this.tamanoCombo.setEnabled(false);
        this.rangoCombo.setEnabled(false);
        this.btnSeleccionarEspecie.setEnabled(false);
        this.fechaIngreso.setEnabled(false);
        txfCantidadIngresarEspecie.setEditable(false);
        this.btnGuardarAlimentarInventario.setEnabled(false);

    }

    public void desactivarCamposEspecies() {

        this.txfNombreCien.setEditable(false);
        this.txfNombreComun.setEditable(false);
        this.txfFamilia.setEditable(false);
        this.txfMsnm.setEditable(false);
    }

    public void desactivarCamposConductores() {

        this.txfCedulaConductor.setEditable(false);
        this.txfNombreConductor.setEditable(false);
        this.txfApellidoConductor.setEditable(false);
        this.txfCelularConductor.setEditable(false);
    }

    public void desactivarCamposClientes() {

        this.txfIdClientes.setEditable(false);
        this.txfNombreClientes.setEditable(false);
        this.txfCelularClientes.setEditable(false);
        this.TipoComboClientes.setEnabled(false);
    }

    public void desactivarCamposCUsuario() {

        this.txfUsuario1.setEditable(false);
        this.txfNombre1.setEditable(false);
        this.txfApellido1.setEditable(false);
        this.txfCelular1.setEditable(false);
        this.txfDireccion1.setEditable(false);
        this.txfEditarContraseñaUsuario.setEditable(false);
    }

    public void mostrarEspeciesReservadas() {

        try {

            DefaultTableModel modelo;
            String codigo_reserva = lblNumeroReserva.getText();
            modelo = rDao.mostrarReservadas(codigo_reserva);
            TableColumnModel column = tablaReservas.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            VistaSGI.tablaReservas.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            column.getColumn(1).setPreferredWidth(200);

        } catch (Exception e) {

        }

    }

    public void activarUsuario() {

        try {

            String usuario = txfUsuario1.getText();
            int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere activar el usuario nuevamente?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (resultado == 0) {

                if (uDao.activar(usuario)) {

                    JOptionPane.showMessageDialog(null, "Usuario activado correctamente.");
                    limpiarUsuario();
                    mostrarUsuariosInactivos();

                } else {

                    JOptionPane.showMessageDialog(null, "Error, no se pudo activar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);

                }

            } else {

            }
        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Seleccione un usuario primero.");

        }

    }

    public void desactivarUsuario() {

        try {

            String usuario = txfUsuario1.getText();

            if (usuario.length() == 0) {

                JOptionPane.showMessageDialog(null, "Seleccione un usuario primero.");

            } else {
                int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere desactivar el usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {

                    if (uDao.desactivar(usuario)) {

                        JOptionPane.showMessageDialog(null, "Usuario desactivado correctamente.");
                        listarUsuarios();
                        limpiarUsuario();
                        activarCamposCUsuario();

                    } else {

                        JOptionPane.showMessageDialog(null, "Error, no se pudo desactivar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                } else {

                }
            }
        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Seleccione un usuario primero.");

        }

    }

    public void listarUsuarios() {

        DefaultTableModel modelo;
        TableColumnModel column = tablaUsuarios.getColumnModel();
        modelo = uDao.listar(txfBuscarUsuarios.getText());
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tablaUsuarios.setModel(modelo);
        tcr.setHorizontalAlignment(SwingConstants.LEFT);
        tablaUsuarios.getColumnModel().getColumn(1).setCellRenderer(tcr);
        column.getColumn(1).setPreferredWidth(200);

    }

    public void consultarEspecie() {

        try {

            String tamano_bolsa = tamanoCombo.getSelectedItem().toString();
            String rango = rangoCombo.getSelectedItem().toString();
            System.out.println(codigo_Especie + " " + tamano_bolsa + " " + rango);
            rs = eDao.buscarIngresoPlanta(codigo_Especie, tamano_bolsa, rango);
            if (txfEspecie.getText().trim().length() == 0) {

            } else {
                if (!rs.next()) {

                    if (txfCodigoEspecie.isEnabled() == false) {
                        txfCodigoEspecie.setText(null);
                        txfCodigoEspecie.setEnabled(true);
                    } else {
                        txfCodigoEspecie.setEnabled(true);
                    }

                } else {

                    txfCodigoEspecie.setText(rs.getString("codigo_ingreso"));
                    txfCodigoEspecie.setEnabled(false);

                }
            }
        } catch (Exception e) {
        }

    }

    public void buscarIngresos(String busca, String fechaInicio, String fechaFin) {

        try {

            DefaultTableModel modelo;
            TableColumnModel column = tablaAlimentarInventario.getColumnModel();
            modelo = dDao.listarEspecies(busca, fechaInicio, fechaFin);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaAlimentarInventario.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            tablaAlimentarInventario.getColumnModel().getColumn(1).setCellRenderer(tcr);
//            column.getColumn(2).setPreferredWidth(200);
//            column.getColumn(1).setPreferredWidth(200);

        } catch (IllegalArgumentException a) {
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage());
        }

    }

    public void buscarIngresosFecha(String fechaInicio, String fechaFin) {

        try {

            DefaultTableModel modelo;
            modelo = dDao.listarEspeciesFecha(fechaInicio, fechaFin);
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaAlimentarInventario.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            tablaAlimentarInventario.getColumnModel().getColumn(1).setCellRenderer(tcr);

        } catch (IllegalArgumentException a) {
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage());
        }

    }

    public void buscarEspecieInventario() {

        try {

            DefaultTableModel modelo;
            TableColumnModel column = tablaInventario.getColumnModel();
            modelo = iDao.listar(txfBuscarInventario.getText());
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tablaInventario.setModel(modelo);
            tcr.setHorizontalAlignment(SwingConstants.LEFT);
            tablaInventario.getColumnModel().getColumn(1).setCellRenderer(tcr);
            column.getColumn(2).setPreferredWidth(200);
            column.getColumn(1).setPreferredWidth(200);

        } catch (IllegalArgumentException a) {
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, npe.getMessage());
        }
    }

    public void limpiarTablaSeleccionarEspecie() {
        DefaultTableModel modelo = (DefaultTableModel) ventanaEspeciesSalidas.tablaEspecies.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaInventario() {
        DefaultTableModel modelo = (DefaultTableModel) tablaInventario.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaEspecies() {
        DefaultTableModel modelo = (DefaultTableModel) tablaEspecies.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }

    public void limpiarTablaConductores() {
        DefaultTableModel modelo = (DefaultTableModel) tablaConductores.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }

    public void limpiarTablaClientes() {
        DefaultTableModel modelo = (DefaultTableModel) tablaClientes.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

    }

    public void registrarClienteSalida() {

        String cedula = txfIdentificacionClienteSalidas.getText().trim();
        String nombre = txfNombreClienteSalidas.getText().trim();
        long celular = Long.parseLong(txfTelefonoClienteSalidas.getText().trim());

        Cliente_ cliente = new Cliente_(cedula, nombre, celular);

        if (clDao.CrearCliente(cliente)) {

            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente, inténtelo nuevamente.");
        }

    }

    public void registrarCliente() {

        String cedula = txfIdClientes.getText().trim();
        String nombre = txfNombreClientes.getText().trim();
        long celular = Long.parseLong(txfCelularClientes.getText().trim());

        Cliente_ cliente = new Cliente_(cedula, nombre, celular);

        if (clDao.CrearCliente(cliente)) {

            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");

        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente, inténtelo nuevamente.");
        }

    }

    public boolean verificarSalida() {

        if (Salidas.isShowing()) {

            if (tablaSalidas.getRowCount() != 0 || txfEspeciePerdida.getText().length() != 0 || txfEspecieTrasplantado.getText().length() != 0) {

                int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea descartar la salida?" + "\n" + "Recuerde que debe dar click en el botón 'Registrar' para confirmar la salida.", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {

                    if (TrasplantadoPanel.isShowing()) {
                        cancelarTrasplantado();
                        return true;
                    } else {
                        cancelarSalida();
                        return true;
                    }
                } else {
                    return false;
                }

            }
        }

        return true;
    }

    public void reiniciarSeleccionarEspecie() {

        ventanaEspeciesSalidas.txfBuscarEsp.setText(null);
        limpiarTablaSeleccionarEspecie();
        limpiarTablaInventario();

    }

    public void buscarSalidas() {

        try {
            Calendar fecha1 = fechaDesdeSalida.getCalendar();
            Calendar fecha2 = fechaHastaSalida.getCalendar();
            String fechaInicio = Integer.toString(fecha1.get(Calendar.YEAR)) + "-" + Integer.toString(fecha1.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha1.get(Calendar.DAY_OF_MONTH));
            String fechaFin = Integer.toString(fecha2.get(Calendar.YEAR)) + "-" + Integer.toString(fecha2.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha2.get(Calendar.DAY_OF_MONTH));
            DefaultTableModel modelo;
            TableColumnModel column = tablaConsultarSalidas.getColumnModel();
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();

            switch (motivoComboConsultarSalida.getSelectedIndex()) {

                case -1:
                    JOptionPane.showMessageDialog(null, "Seleccione un motivo por favor.");
                    break;
                case 0:
                    if (txfBuscarConsultarSalida.getText().trim().length() == 0) {
                        modelo = sDao.buscarSalidaSinMotivo(fechaInicio, fechaFin);
                        tablaConsultarSalidas.setModel(modelo);
                        tcr.setHorizontalAlignment(SwingConstants.LEFT);
                        column.getColumn(5).setPreferredWidth(140);
                    } else {
                        modelo = sDao.buscarSalidaSinMotivoDetallado(fechaInicio, fechaFin, txfBuscarConsultarSalida.getText().trim());
                        tablaConsultarSalidas.setModel(modelo);
                        tcr.setHorizontalAlignment(SwingConstants.LEFT);
                        column.getColumn(5).setPreferredWidth(140);
                    }
                    break;
                case 1:
                case 2:
                case 5:
                    if (txfBuscarConsultarSalida.getText().trim().length() == 0) {

                        modelo = sDao.buscarSalida(motivoComboConsultarSalida.getSelectedItem().toString(), fechaInicio, fechaFin);
                        tablaConsultarSalidas.setModel(modelo);
                        tcr.setHorizontalAlignment(SwingConstants.LEFT);
                        column.getColumn(5).setPreferredWidth(200);

                    } else {

                        modelo = sDao.buscarSalidaDetalle(motivoComboConsultarSalida.getSelectedItem().toString(), fechaInicio, fechaFin, txfBuscarConsultarSalida.getText().trim());
                        tablaConsultarSalidas.setModel(modelo);
                        tcr.setHorizontalAlignment(SwingConstants.LEFT);
                        column.getColumn(5).setPreferredWidth(200);

                    }
                    break;
                case 3:
                    modelo = sDao.buscarSalidaPerdida(motivoComboConsultarSalida.getSelectedItem().toString(), fechaInicio, fechaFin);
                    tablaConsultarSalidas.setModel(modelo);
                    tcr.setHorizontalAlignment(SwingConstants.LEFT);
                    break;
                case 4:
                    modelo = sDao.buscarSalidaTrasplantado(motivoComboConsultarSalida.getSelectedItem().toString(), fechaInicio, fechaFin);
                    tablaConsultarSalidas.setModel(modelo);
                    tcr.setHorizontalAlignment(SwingConstants.LEFT);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Elija un motivo de salida, por favor.");
                    break;

            }
        } catch (NullPointerException npe) {

            JOptionPane.showMessageDialog(null, "Ingrese el rango de tiempo de la búsqueda (Fecha desde y Fecha hasta).");
        }

    }

    public void verificarParcialRegistrar() {

        try {
            String codigo_salida = txfCodigoSalida.getText().trim() + "-" + txfCodigoSalida2.getText().trim();
            rs = sDao.buscarCodigoSalida(codigo_salida);
            int resultado;
            if (rs.next()) {

                if (cbEntregaParcial.isSelected() == false) {
                    resultado = JOptionPane.showConfirmDialog(null, "La salida ya existe ¿Desea registrar esta salida con entregas parciales?", "Confirmación", JOptionPane.YES_NO_OPTION);
                    if (resultado == 0) {
                        cbEntregaParcial.setSelected(true);
                        registrarSalidaVenta();
                    }
                } else {
                    registrarSalidaVenta();
                }
            } else {
                registrarSalidaVenta();
            }
        } catch (SQLException ex) {
        }
    }

    public void registrarSalidaVenta() {

        if (tablaSalidas.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "Seleccione las especies para la venta, por favor.");

        } else {

            try {
                Salida_ s;
                max_salida = MAXSalida();
                String numero_orden = txfCodigoSalida.getText() + "-" + txfCodigoSalida2.getText();
                String motivo = motivoCombo.getSelectedItem().toString();
                String convenio = txfConvenio.getText().trim();
                String corregimiento = txfCorregimiento.getText().trim();
                int total = 0;
                String destino = txfDestino.getText().trim();
                int id_conductor = 0;
                if (conductor == true) {
                    id_conductor = Integer.parseInt(txfCedulaConductorSalidas.getText().trim());
                }
                String placa = txfPlacaSalidas.getText().trim();
                String id_cliente = txfIdentificacionClienteSalidas.getText().trim();
                String predio = txfPredio.getText().trim();
                String nombre_temp = txfNombreConductorSalidas.getText().trim();
                String apellido_temp = txfApellidoConductorSalidas.getText().trim();
                String celular_temp = txfCelularConductorSalidas.getText().trim();

                java.sql.Date fecha = new java.sql.Date(fechaSalida.getDate().getTime());
                int parcial = 0;

                if (!txfParcial.getText().trim().isEmpty()) {
                    parcial = Integer.parseInt(txfParcial.getText().trim());
                }

                if (id_conductor == 0) {
                    s = new Salida_(max_salida, numero_orden, motivo, predio, fecha, parcial, convenio, corregimiento, destino, total, id_cliente, 0, placa, carguista, observacion, txfCedulaConductorSalidas.getText().trim(), nombre_temp, apellido_temp, celular_temp);
                } else {
                    s = new Salida_(max_salida, numero_orden, motivo, predio, fecha, parcial, convenio, corregimiento, destino, total, id_cliente, id_conductor, placa, carguista, observacion, "", "", "", "");
                }
                if (sDao.CrearSalida(s)) {

                    for (int i = 0; i < tablaSalidas.getRowCount(); i++) {

                        DetalleSalida_ d = new DetalleSalida_(max_salida, tablaSalidas.getValueAt(i, 0).toString(), "", Integer.parseInt(tablaSalidas.getValueAt(i, 6).toString()), Integer.parseInt(tablaSalidas.getValueAt(i, 5).toString()));

                        if (dsDao.CrearDetalleSalida(d)) {

                        } else {

                            JOptionPane.showMessageDialog(null, "No se ha podido registrar la salida.");
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Salida registrada correctamente.");

                    generarReporte();
                    reiniciarSlider();
                    carguista = " ";
                    observacion = " ";
                    max_salida = MAXSalida();

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido registrar la salida, revise su información.");

                }
            } catch (Exception ex) {
            }
        }

    }

    public void registrarSalidaPerdida() {

        try {

            if (tablaSalidas.getRowCount() == 0) {

                JOptionPane.showMessageDialog(null, "Seleccione las especies para la pérdida, por favor.");

            } else {

                Salida_ s;
                int codigo_salida = MAXSalida();
                String numero_orden = txfCodigoSalida.getText();
                String motivo = motivoCombo.getSelectedItem().toString();
                int total = 0;

                java.sql.Date fecha = null;
                SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                fecha = new java.sql.Date(sdf.parse(fechaSalida()).getTime());
                s = new Salida_(MAXSalida(), numero_orden, motivo, "", fecha, 0, "", "", "", total, "", 0, "", "", observacion, "", "", "", "");

                if (sDao.CrearSalida(s)) {

                    for (int i = 0; i < tablaSalidas.getRowCount(); i++) {

                        DetalleSalida_ d = new DetalleSalida_(codigo_salida, tablaSalidas.getValueAt(i, 0).toString(), "", Integer.parseInt(tablaSalidas.getValueAt(i, 6).toString()), 0);

                        if (dsDao.CrearDetalleSalida(d)) {

                        } else {

                            JOptionPane.showMessageDialog(null, "No se ha podido registrar la salida.");
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Salida registrada correctamente");
                    observacion = " ";
                    carguista = " ";
                    reiniciarSlider();
                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido registrar la salida, revise su información.");

                }
            }

            max_salida = MAXSalida();

        } catch (ParseException ex) {

        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Llene todos los campos por favor.");

        } catch (NullPointerException npe) {

            JOptionPane.showMessageDialog(null, npe.getMessage());

        }

    }

    public void registrarSalidaTrasplantado() {

        try {

            ResultSet rs;
            String tamaño_nueva = tamanoComboTrasplantado.getSelectedItem().toString();
            String rango_nueva = rangoComboTrasplantado.getSelectedItem().toString();
            if (tamañoTrasplantado.equalsIgnoreCase(tamaño_nueva)
                    && rangoTrasplantado.equalsIgnoreCase(rango_nueva)) {

                JOptionPane.showMessageDialog(null, "No puede hacer un trasplantado al mismo tamaño de bolsa y rango.");

            } else {
                rs = eDao.buscarIngresoPlanta(codigo_Especie, tamaño_nueva, rango_nueva);

                if (!rs.next()) {

                    int resultado = JOptionPane.showConfirmDialog(null, "Esta especie con este tamaño de bolsa (" + tamaño_nueva + ") y rango (" + rango_nueva + ") no se ha ingresado." + "\n" + "¿Desea registrarla?.", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (resultado == 0) {

                        ventanaTrasplantado.setVisible(true);
                    }

                } else {

                    Salida_ s;

                    int cantidad = Integer.parseInt(txfCantidadTrasplantado.getText().trim());
                    int codigo_salida = MAXSalida();
                    String numero_orden = txfCodigoSalida.getText();
                    String motivo = motivoCombo.getSelectedItem().toString();
                    int total = 0;
                    java.sql.Date fecha = null;
                    SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    fecha = new java.sql.Date(sdf.parse(fechaSalida()).getTime());
                    String tamaño_origen = tamanoComboTrasplantado.getSelectedItem().toString() + ", " + rangoComboTrasplantado.getSelectedItem().toString();
                    s = new Salida_(MAXSalida(), numero_orden, motivo, "", fecha, 0, "", "", "", total, "", 0, "", "", observacion, "", "", "", "");

                    if (sDao.CrearSalida(s)) {

                        DetalleSalida_ d = new DetalleSalida_(codigo_salida, codigo_Ingreso, tamaño_origen, cantidad, 0);

                        if (dsDao.CrearDetalleSalida(d)) {

                            codigo_ingresoTrasplantar = rs.getString("codigo_ingreso");

                            if (txfCantidadTrasplantado.isEditable()) {
                                restar(codigo_Ingreso, cantidad);
                            } else {

                            }

                            if (sDao.trasplantar(codigo_ingresoTrasplantar, cantidad)) {

                                JOptionPane.showMessageDialog(null, "Salida registrada correctamente");
                                reiniciarSlider();
                                btnRegistrarSalida.setEnabled(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha podido trasplantar, ha ocurrido un error.");
                            }

                        } else {

                            JOptionPane.showMessageDialog(null, "No se ha podido registrar la salida.");
                        }

                    } else {

                        JOptionPane.showMessageDialog(null, "No se ha podido registrar la salida, revise su información.");

                    }
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(VistaSGI.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(VistaSGI.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {

        }

    }

    public String numUsuarios() {

        String resultado = "";
        try {

            rs = uDao.contarUsuarios();

            if (rs.next()) {

                resultado = rs.getString(1);
            } else {

                resultado = "0";
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public String numSalidas(String mes, String año) {

        String resultado = "";
        try {

            rs = sDao.contarSalidas(mes, año);

            if (rs.next()) {

                resultado = rs.getString(1);
            } else {

                resultado = "0";
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public String numVentas(String mes, String año) {

        String resultado = "";
        try {

            rs = sDao.contarVentas(mes, año);

            if (rs.next()) {

                resultado = rs.getString(1);
            } else {

                resultado = "0";
            }
        } catch (SQLException ex) {
        }
        return resultado;
    }

    public void siguienteInfoSalida() {

        if (txfDestino.getText().trim().equalsIgnoreCase("")) {

            JOptionPane.showMessageDialog(null, "El campo 'Municipio/Vereda' es obligatorio, digite información en este por favor.");

        } else if (txfCodigoSalida.getText().trim().length() == 0) {

            JOptionPane.showMessageDialog(null, "Por favor digite el número de orden.");

        } else {

            String motivo = motivoCombo.getSelectedItem().toString();

            if (motivo.equalsIgnoreCase("Venta")) {

                this.slidePanel.nextPanel(20, ConductorPanel, slidePanel.left);
                txfCedulaConductorSalidas.requestFocus(true);

            } else if (motivo.equalsIgnoreCase("Trasplantado")) {

                this.slidePanel.nextPanel(20, TrasplantadoPanel, slidePanel.left);
                txfEspecieTrasplantado.requestFocus(true);

            } else if (motivo.equalsIgnoreCase("Pérdida")) {

                this.slidePanel.nextPanel(20, PerdidaPanel, slidePanel.left);
                txfCodigoPerdida.requestFocus(true);

            } else if (motivo.equalsIgnoreCase("Promoción")) {

                this.slidePanel.nextPanel(20, ConductorPanel, slidePanel.left);
                txfCedulaConductorSalidas.requestFocus(true);

            } else if (motivo.equalsIgnoreCase("Proyecto")) {

                this.slidePanel.nextPanel(20, ConductorPanel, slidePanel.left);
                txfCedulaConductorSalidas.requestFocus(true);

            }

        }

    }

    public void siguienteConductorSalidas() {

        try {

            ResultSet rs = cDao.buscar(txfCedulaConductorSalidas.getText());

            if (txfCedulaConductorSalidas.getText().length() == 0 || txfNombreConductorSalidas.getText().length() == 0 || txfApellidoConductorSalidas.getText().length() == 0) {

                JOptionPane.showMessageDialog(null, "Busque o digite la información del conductor primero.");

            } else if (txfPlacaSalidas.getText().trim().equals("") || txfPlacaSalidas.getText().trim().length() < 6) {

                JOptionPane.showMessageDialog(null, "Ingrese una placa válida.");

            } else if (txfCedulaConductorSalidas.getText().trim().length() < 8) {
                JOptionPane.showMessageDialog(null, "Ingrese una cédula válida.");
            } else if (txfCelularConductorSalidas.getText().trim().length() != 0 && txfCelularConductorSalidas.getText().trim().length() < 10) {
                JOptionPane.showMessageDialog(null, "Ingrese un celular válido o bórrelo.");
            } else if (!rs.next()) {

                int resultado = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere seguir con la salida sin registrar el conductor?", "Confirmación", JOptionPane.YES_NO_OPTION);

                if (resultado == 0) {
                    this.slidePanel.nextPanel(20, ClientePanel, slidePanel.left);
                    IdentificacionComboSalidas.requestFocus(true);
                    conductor = false;
                } else {

                }
            } else {
                this.slidePanel.nextPanel(20, ClientePanel, slidePanel.left);
                IdentificacionComboSalidas.requestFocus(true);
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos del conductor, por favor.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos del conductor, por favor.");
        }

    }

    public void siguienteClienteSalidas() {

        try {
            ResultSet rs = clDao.buscar(txfIdentificacionClienteSalidas.getText());

            if (IdentificacionComboSalidas.getSelectedIndex() == -1) {

                JOptionPane.showMessageDialog(null, "Seleccione un tipo de identificación primero..");

            } else if (txfIdentificacionClienteSalidas.getText().trim().equals("") || txfNombreClienteSalidas.getText().trim().equals("") || txfTelefonoClienteSalidas.getText().trim().equals("")) {

                JOptionPane.showMessageDialog(null, "Llene todos los campos.");

            } else if (motivoCombo.getSelectedIndex() == 7) {

            } else if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "El cliente no existe, por favor registrelo.");
            } else {
                this.slidePanel.nextPanel(20, EspeciesPanel, slidePanel.left);
                txfCodigoEspcSalidas.requestFocus(true);
            }
        } catch (SQLException ex) {
        }
    }

    public void quitarEspecie() {

        try {

            if (tablaSalidas.getSelectedRow() == -1) {

                JOptionPane.showMessageDialog(null, "Seleccione una especie de la tabla, por favor.");
            } else {

                String codigo = tablaSalidas.getValueAt(tablaSalidas.getSelectedRow(), 0).toString();
                int cantidad = Integer.parseInt(tablaSalidas.getValueAt(tablaSalidas.getSelectedRow(), 6).toString());
                DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaSalidas.getModel();
                modelo.removeRow(tablaSalidas.getSelectedRow());

                if (dDao.sumar(codigo, cantidad)) {

                    limpiarTrasplantado();

                    if (txfCodigoEspcSalidas.getText().trim().length() != 0 && !txfCodigoEspcSalidas.isEditable()) {

                        buscarEspeciesSalidas();
                    } else if (txfCodigoPerdida.getText().trim().length() != 0 && !txfCodigoPerdida.isEditable()) {

                        buscarEspeciesPerdida();
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error.");

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void reiniciarInventario() {

        limpiarTablaInventario();
        txfBuscarInventario.setText(null);

    }

    public void registrarEspecie() {

        try {

            if (txfNombreCien.getText().trim().length() == 0 || txfNombreComun.getText().trim().length() == 0) {

                JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

            } else {

                Especie_ e;
                int codigo = Integer.parseInt(lblNumeroEspecie.getText());
                String nombre_cien = txfNombreCien.getText().trim();
                String nombre_comun = txfNombreComun.getText().trim();
                String msnm = txfMsnm.getText().trim();
                String familia = txfFamilia.getText().trim();

                e = new Especie_(codigo, nombre_comun, nombre_cien, familia, msnm);

                if (eDao.CrearEspecie(e)) {

                    JOptionPane.showMessageDialog(null, "Especie creada correctamente.");
                    limpiarEspecies();
                    obtenerMAXEspecie();

                } else {

                    JOptionPane.showMessageDialog(null, "No se ha podido registrar la especie, revise su información.");
                }
            }

        } catch (Exception e) {

        }

    }

    public void generarReporte() {

        try {
            String motivo = motivoCombo.getSelectedItem().toString();
            String numero_orden = txfCodigoSalida.getText() + "-" + txfCodigoSalida2.getText();
            String cedula = txfIdentificacionClienteSalidas.getText();

            generarRemision(numero_orden, max_salida, cedula, motivo);

        } catch (NullPointerException n) {

        }
    }

    public void generarReporteConsultar() {

        try {

            if (tablaConsultarSalidas.getRowCount() <= 0) {

                JOptionPane.showMessageDialog(null, "Busque alguna salida primero, por favor.");

            } else if (tablaConsultarSalidas.getSelectedRow() == -1) {
//
                JOptionPane.showMessageDialog(null, "Seleccione un item de la tabla primero, por favor.");
//
            } else {

                int codigo_salida = Integer.parseInt(tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 0).toString());
                String numero_orden = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 1).toString();
                String motivo = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 4).toString();
                String cedula = tablaConsultarSalidas.getValueAt(tablaConsultarSalidas.getSelectedRow(), 5).toString();

                rs = sDao.buscarSalidaPorCodigo(numero_orden, Integer.toString(codigo_salida));
                if (rs.next()) {

                    if (rs.getInt("id_conductor") == 0) {
                        conductor = false;
                    } else {
                        conductor = true;
                    }
                    generarRemision(numero_orden, codigo_salida, cedula, motivo);
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error.");
                }

            }
        } catch (NumberFormatException nfe) {

            JOptionPane.showMessageDialog(null, "Digite valores numéricos donde sea requerido.");

        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, n.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void generarRemision(String numero_orden, int codigo_salida, String cedula, String motivo) {

        GenerarReporte reporte = new GenerarReporte();
        if (conductor == false) {
            reporte.remisionSalida2(cedula, codigo_salida, numero_orden, motivo);
        } else {
            reporte.remisionSalida(cedula, codigo_salida, numero_orden, motivo);
        }

    }

    public void reiniciarSlider() {

        motivoCombo.setSelectedIndex(0);
        IdentificacionComboSalidas.setSelectedIndex(0);
        btnRegistrarSalida.setEnabled(true);
        limpiarSalidas();
        limpiarTablaSalidas();
        this.slidePanel.nextPanel(20, InfoSalidaPanel, slidePanel.right);
        conductor = true;

    }

    public void ingresarEspecie() {

        try {
            if (txfCodigoEspecie.getText().trim().length() == 0 || txfEspecie.getText().trim().length() == 0
                    || txfCantidadIngresarEspecie.getText().trim().length() == 0) {

                JOptionPane.showMessageDialog(null, "Llene todos los campos por favor.");

            } else {

                String codigo = txfCodigoEspecie.getText().trim();
                java.sql.Date fechaIngresoE;

                rs = iDao.buscar(codigo);

                if (rs.next()) {

                    if (rs.getString("nombre_vulgar").equalsIgnoreCase(txfEspecie.getText())
                            && rs.getString("tamaño_bolsa").equalsIgnoreCase(tamanoCombo.getSelectedItem().toString())
                            && rs.getString("rango").equalsIgnoreCase(rangoCombo.getSelectedItem().toString())) {

                        int cantidad = Integer.parseInt(txfCantidadIngresarEspecie.getText().trim());
                        fechaIngresoE = new java.sql.Date(fechaIngreso.getDate().getTime());

                        DetalleIngreso_ detalle = new DetalleIngreso_(codigo_Especie, cantidad, fechaIngresoE, codigo);

                        if (dDao.CrearDetalle(detalle)) {

                            if (iDao.actualizarStock(cantidad + rs.getInt("stock"), codigo)) {

                                JOptionPane.showMessageDialog(null, "Especie ingresada correctamente.");
                                limpiarIngresarEspecie();
                            } else {
                                JOptionPane.showMessageDialog(null, "Ha ocurrido un error, verifique que su información esté correcta..");
                                limpiarIngresarEspecie();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El código ya pertenece a otra especie, ingrese uno nuevo, por favor.");
                    }
                } else {

                    String bolsa = tamanoCombo.getSelectedItem().toString();
                    String rango = rangoCombo.getSelectedItem().toString();
                    int cantidad = Integer.parseInt(txfCantidadIngresarEspecie.getText().trim());
                    fechaIngresoE = new java.sql.Date(fechaIngreso.getDate().getTime());

                    Ingreso_ ingreso = new Ingreso_(codigo, codigo_Especie, bolsa, rango, cantidad, cantidad);

                    if (iDao.CrearIngreso(ingreso)) {

                        DetalleIngreso_ detalle = new DetalleIngreso_(codigo_Especie, cantidad, fechaIngresoE, codigo);

                        if (dDao.CrearDetalle(detalle)) {

                            JOptionPane.showMessageDialog(null, "Especie ingresada correctamente.");
                            limpiarIngresarEspecie();
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Se ha producido un error, verifique su información.");

                    }
                }

            }
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Verifique que su información sea correcta, por favor.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void buscarIngreso() {

        try {

            Calendar fecha1 = fechaDesde.getCalendar();
            Calendar fecha2 = fechaHasta.getCalendar();
            String fechaInicio = Integer.toString(fecha1.get(Calendar.YEAR)) + "-" + Integer.toString(fecha1.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha1.get(Calendar.DAY_OF_MONTH));
            String fechaFin = Integer.toString(fecha2.get(Calendar.YEAR)) + "-" + Integer.toString(fecha2.get(Calendar.MONTH) + 1) + "-" + Integer.toString(fecha2.get(Calendar.DAY_OF_MONTH));

            if (txfBuscarEspecie.getText().length() == 0) {

                buscarIngresosFecha(fechaInicio, fechaFin);

            } else {

                String busca = txfBuscarEspecie.getText();
                buscarIngresos(busca, fechaInicio, fechaFin);

            }

        } catch (NullPointerException npe) {

            JOptionPane.showMessageDialog(null, "Digite toda la información de la búsqueda con fechas válidas.");

        }
    }

    public boolean buscarEnLaTabla(String codigo) {

        int filas = tablaSalidas.getRowCount();

        for (int i = 0; i < filas; i++) {

            if (tablaSalidas.getValueAt(i, 0).toString().equalsIgnoreCase(codigo)) {

                cantidadDuplicada = Integer.parseInt(tablaSalidas.getValueAt(i, 6).toString());
                pedidasDuplicada = Integer.parseInt(tablaSalidas.getValueAt(i, 5).toString());

                if (dDao.sumar(tablaSalidas.getValueAt(i, 0).toString(), cantidadDuplicada)) {

                    limpiarTablaInventario();
                    DefaultTableModel modelo = (DefaultTableModel) VistaSGI.tablaSalidas.getModel();
                    modelo.removeRow(i);

                    if (txfCodigoEspcSalidas.getText().trim().length() != 0 && !txfCodigoEspcSalidas.isEditable()) {

                        buscarEspeciesSalidas();
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Hubo un error.");

                }
                return true;
            }

        }
        return false;
    }

    public void seleccionarEspecieSalidas(String codigo, String nombre_vulgar, String nombre_cientifico, String tamaño, String rango, String cantidad_, String pedidas) {

        try {
            String datos[] = {codigo, nombre_vulgar, nombre_cientifico, tamaño, rango, cantidad_, pedidas};
            DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
            modelo.addRow(datos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void seleccionarEspeciePerdida(String codigo, String nombre_vulgar, String nombre_cientifico, String tamaño, String rango, String cantidad_) {

        try {
            String datos[] = {codigo, nombre_vulgar, nombre_cientifico, tamaño, rango, "-", cantidad_};
            DefaultTableModel modelo = (DefaultTableModel) tablaSalidas.getModel();
            modelo.addRow(datos);
            limpiarPerdida();
            txfCodigoPerdida.setRequestFocusEnabled(true);
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
                txfPedido.setEditable(true);
                txfPedido.requestFocus(true);
                txfCantidadSalidas.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la especie, verifique su información por favor o registre la especie.");
            }
        } catch (SQLException ex) {
        }
    }

    public void buscarEspeciesReservas() {

        try {
            String codigo = txfCodigoPlantaReservas.getText().trim();

            if (!codigo.equalsIgnoreCase("")) {

                rs = eDao.buscarIngreso(codigo);

                if (rs.next()) {
//                txfCodigoPlantaReservas.setEditable(false);
                    tamano = rs.getString("tamaño_bolsa");
                    rango = rs.getString("rango");
                    txfEspecieReservas.setText(rs.getString("nombre_vulgar") + ", " + tamano + ", " + rango);
                    lblDisponibles.setText(rs.getString("disponibles"));
                    txfCantidadReservas.setEnabled(true);
                    reiniciarSeleccionarEspecie();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la especie, verifique su información por favor o registre la especie.");
                    limpiarEspecieReservas();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el código de alguna planta o seleccione una, por favor.");
                limpiarEspecieReservas();
            }

        } catch (SQLException ex) {
        }
    }

    public void buscarEspeciesPerdida() {

        try {
            String codigo = txfCodigoPerdida.getText().trim();

            rs = eDao.buscarIngreso(codigo);

            if (rs.next()) {
                txfCodigoPerdida.setEditable(false);
                txfEspeciePerdida.setText(rs.getString("nombre_vulgar") + ", " + rs.getString("tamaño_bolsa") + ", " + rs.getString("rango"));
                txfStockPerdida.setText(rs.getString("stock"));
                nombre_comun = rs.getString("nombre_vulgar");
                nombre_cientifico = rs.getString("nombre_cientifico");
                tamano = rs.getString("tamaño_bolsa");
                rango = rs.getString("rango");
                txfCantidadPerdida.setEditable(true);
                txfCantidadPerdida.requestFocus(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la especie, verifique su información por favor o registre la especie.");
            }
        } catch (SQLException ex) {
        }
    }

    public void buscarEspeciesTrasplantado() {

        try {
            String codigo = txfEspecieTrasplantado.getText().trim();

            rs = eDao.buscarIngreso(codigo);

            if (rs.next()) {
                codigo_Ingreso = rs.getString("codigo_ingreso");
                codigo_Especie = rs.getInt("codigo_planta");
                tamañoTrasplantado = rs.getString("tamaño_bolsa");
                rangoTrasplantado = rs.getString("rango");
                txfEspecieTrasplantado.setEditable(false);
                txfEspecieTrasplantado.setText(rs.getString("nombre_vulgar") + ", " + rs.getString("tamaño_bolsa") + ", " + rs.getString("rango"));
                labelStock.setText(rs.getString("stock"));
                labelStock.setVisible(true);
                lblStock1.setVisible(true);
                txfCantidadTrasplantado.setEditable(true);
                btnSeleccionarEspecieReservas3.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la especie, verifique su información por favor o registre la especie.");
            }
        } catch (SQLException ex) {
        }
    }

    public void agregarEspecie() {

        if (txfCodigoEspcSalidas.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Busque o seleccione una especie primero, por favor.");
        } else if (txfCantidadSalidas.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad, por favor.");
        } else if (Integer.parseInt(txfCantidadSalidas.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
        } else if (Integer.parseInt(txfPedido.getText()) < Integer.parseInt(txfCantidadSalidas.getText())) {
            JOptionPane.showMessageDialog(null, "La cantidad de pedidas no puede ser menor a las entregadas. ");
        } else if (Integer.parseInt(txfCantidadSalidas.getText()) > Integer.parseInt(txfStockSalidas.getText())) {
            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al stock.");
        } else {
            String codigo = txfCodigoEspcSalidas.getText().trim();
            String cantidad = "";
            String pedidas = "";

            if (buscarEnLaTabla(codigo)) {

                cantidad = Integer.toString(Integer.parseInt(txfCantidadSalidas.getText().trim()) + cantidadDuplicada);
                pedidas = Integer.toString(Integer.parseInt(txfPedido.getText().trim()) + pedidasDuplicada);
                seleccionarEspecieSalidas(codigo, nombre_comun, nombre_cientifico, tamano, rango, pedidas, cantidad);
                restar(codigo, Integer.parseInt(cantidad));
                txfCodigoEspcSalidas.requestFocus(true);
                limpiarSeleccionarEspecies();

            } else {

                cantidad = txfCantidadSalidas.getText().trim();
                pedidas = txfPedido.getText().trim();
                seleccionarEspecieSalidas(codigo, nombre_comun, nombre_cientifico, tamano, rango, pedidas, cantidad);
                restar(codigo, Integer.parseInt(cantidad));
                txfCodigoEspcSalidas.requestFocus(true);
            }

        }
    }

    public void agregarEspeciePerdida() {

        if (txfCodigoPerdida.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Busque o seleccione una especie primero, por favor.");
        } else if (txfCantidadPerdida.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad, por favor.");
        } else if (Integer.parseInt(txfCantidadPerdida.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
        } else if (Integer.parseInt(txfCantidadPerdida.getText()) > Integer.parseInt(txfStockPerdida.getText())) {
            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al stock.");
        } else {
            String codigo = txfCodigoPerdida.getText().trim();
            String cantidad = txfCantidadPerdida.getText().trim();

            seleccionarEspeciePerdida(codigo, nombre_comun, nombre_cientifico, tamano, rango, cantidad);
            restar(codigo, Integer.parseInt(cantidad));
            txfCodigoPerdida.requestFocus(true);

        }
    }

    public void agregarEspecieTrasplantado() {

        if (txfEspecieTrasplantado.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Busque o seleccione una especie primero, por favor.");
        } else if (txfCantidadTrasplantado.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad, por favor.");
        } else if (Integer.parseInt(txfCantidadTrasplantado.getText()) < 1) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
        } else if (Integer.parseInt(txfCantidadTrasplantado.getText()) > Integer.parseInt(labelStock.getText())) {
            JOptionPane.showMessageDialog(null, "La cantidad no debe superar al stock.");
        } else {

            registrarSalidaTrasplantado();
        }
    }

    public void MAXcodigoPerdida() {

        try {
            rs = sDao.MAXPerdida();

            if (rs.next()) {

                String codigo_completo = rs.getString(1);

                if (codigo_completo == null) {

                    txfCodigoSalida.setText("P1");
                    txfCodigoSalida2.setText(null);
                    txfCodigoSalida.setEditable(false);
                    txfCodigoSalida2.setEditable(false);

                } else {

                    txfCodigoSalida2.setText(null);
                    txfCodigoSalida.setEditable(false);
                    txfCodigoSalida2.setEditable(false);
                    String[] fragmentar = codigo_completo.split("P");
                    int fragmentado = Integer.parseInt(fragmentar[1]);
                    txfCodigoSalida.setText("P" + Integer.toString(fragmentado + 1));
                }
            }

        } catch (SQLException ex) {
        }
    }

    public void MAXcodigoTrasplantado() {

        try {
            rs = sDao.MAXTrasplantado();

            if (rs.next()) {

                String codigo_completo = rs.getString(1);

                if (codigo_completo == null) {

                    txfCodigoSalida.setText("T1");
                    txfCodigoSalida2.setText(null);
                    txfCodigoSalida.setEditable(false);
                    txfCodigoSalida2.setEditable(false);

                } else {

                    txfCodigoSalida2.setText(null);
                    txfCodigoSalida.setEditable(false);
                    txfCodigoSalida2.setEditable(false);
                    String[] fragmentar = codigo_completo.split("T");
                    int fragmentado = Integer.parseInt(fragmentar[1]);
                    txfCodigoSalida.setText("T" + Integer.toString(fragmentado + 1));
                }
            }

        } catch (SQLException ex) {
        }
    }

    public void registrarSalida() {

        int motivo = motivoCombo.getSelectedIndex();

        switch (motivo) {
            case 0:
            case 1:
            case 4:
                verificarParcialRegistrar();
                break;
            case 2:
                registrarSalidaPerdida();
                break;
            default:
                break;
        }

    }

    public void registrarConductor() {

        try {

            if (txfCedulaConductor.isEditable()) {

                rs = cDao.buscar(txfCedulaConductor.getText().trim());

                if (rs.next()) {

                    JOptionPane.showMessageDialog(null, "El conductor ya existe, proceda a buscarlo.");

                } else {

                    if (txfCedulaConductor.getText().trim().length() == 0 || txfNombreConductor.getText().trim().length() == 0
                            || txfApellidoConductor.getText().trim().length() == 0) {

                        JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

                    } else {

                        if (txfCedulaConductor.getText().trim().length() < 7 || txfCedulaConductor.getText().length() > 10) {

                            JOptionPane.showMessageDialog(null, "Ingrese un número de cédula válido.");

                        } else {

                            if (txfCelularConductor.getText().trim().length() != 0 && txfCelularConductor.getText().trim().length() < 10) {

                                JOptionPane.showMessageDialog(null, "Ingrese un teléfono válido o bórrelo por favor.");
                            } else {
                                Conductor_ c;
                                int cedula = Integer.parseInt(txfCedulaConductor.getText().trim());
                                String nombre = txfNombreConductor.getText().trim();
                                String apellido = txfApellidoConductor.getText().trim();
                                String celular = "0";

                                if (txfCelularConductor.getText().trim().length() != 0) {
                                    celular = txfCelularConductor.getText().trim();
                                }

                                c = new Conductor_(nombre, apellido, cedula, celular, Estado_.ACTIVO);

                                if (cDao.CrearConductor(c)) {

                                    JOptionPane.showMessageDialog(null, "Conductor creado correctamente.");
                                    limpiarConductor();

                                } else {

                                    JOptionPane.showMessageDialog(null, "No se ha podido registrar el Conductor, revise su información.");
                                }

                            }

                        }
                    }
                }
            } else {
                actualizarConductor();
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error, verifique que su información esté correcta (La cédula debe tener 10 dígitos)");

        }
    }

    public void registrarConductorSalidas() {

        try {

            rs = cDao.buscar(txfCedulaConductorSalidas.getText().trim());

            if (rs.next()) {

                JOptionPane.showMessageDialog(null, "El conductor ya existe, proceda a buscarlo.");

            } else {

                if (txfCedulaConductorSalidas.getText().trim().length() == 0 || txfNombreConductorSalidas.getText().trim().length() == 0
                        || txfApellidoConductorSalidas.getText().trim().length() == 0) {

                    JOptionPane.showMessageDialog(null, "Llene todos los campos, por favor.");

                } else {

                    if (txfCedulaConductorSalidas.getText().trim().length() < 7 || txfCedulaConductorSalidas.getText().length() > 10) {

                        JOptionPane.showMessageDialog(null, "Ingrese un número de cédula válido.");

                    } else {

                        if (txfCelularConductorSalidas.getText().trim().length() != 0 && txfCelularConductorSalidas.getText().trim().length() < 10) {

                            JOptionPane.showMessageDialog(null, "Ingrese un teléfono válido o bórrelo por favor.");
                        } else {
                            Conductor_ c;
                            int cedula = Integer.parseInt(txfCedulaConductorSalidas.getText().trim());
                            String nombre = txfNombreConductorSalidas.getText().trim();
                            String apellido = txfApellidoConductorSalidas.getText().trim();
                            String celular = "0";

                            if (txfCelularConductorSalidas.getText().trim().length() != 0) {
                                celular = txfCelularConductorSalidas.getText().trim();
                            }

                            c = new Conductor_(nombre, apellido, cedula, celular, Estado_.ACTIVO);

                            if (cDao.CrearConductor(c)) {

                                JOptionPane.showMessageDialog(null, "Conductor creado correctamente.");
                                txfNombreConductorSalidas.setEditable(false);
                                txfApellidoConductorSalidas.setEditable(false);
                                txfCelularConductorSalidas.setEditable(false);
                                txfPlacaSalidas.requestFocus(true);

                            } else {

                                JOptionPane.showMessageDialog(null, "No se ha podido registrar el Conductor, revise su información.");
                            }

                        }

                    }
                }
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error, verifique que su información esté correcta (La cédula debe tener 10 dígitos)");

        }
    }

    public int MAXSalida() {

        try {
            int numero;
            rs = sDao.MAXSalida();

            if (rs.next()) {
                numero = rs.getInt("codigo_salida");
                return numero;
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la base de datos, comuníquese con los desarrolladores, por favor.");
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la base de datos, comuníquese con los desarrolladores, por favor.");
            return 0;
        }
    }

    public String convenio() {

        try {
            String convenio;
            rs = sDao.Convenio(MAXSalida() - 1);

            if (rs.next()) {
                convenio = rs.getString("convenio");
                return convenio;
            } else {
                return "";
            }
        } catch (SQLException ex) {
            return "";
        }
    }
}
