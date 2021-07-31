package DAO;

import Modelo.Salida_;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalidasDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearSalida(Salida_ s) {

        sSql = "INSERT INTO salida(codigo_salida, numero_orden, motivo, fecha, parcial, observacion, destino, convenio, corregimiento, carga, predio, id_cliente, id_conductor, placa, id_conductor_temp, nombre_conductor_temp, apellido_conductor_temp, celular_conductor_temp)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setInt(1, s.getCodigo_salida());
            pst.setString(2, s.getNumero_orden());
            pst.setString(3, s.getMotivo());
            pst.setDate(4, s.getFecha());
            pst.setInt(5, s.getParcial());
            pst.setString(6, s.getObservacion());
            pst.setString(7, s.getDestino());
            pst.setString(8, s.getConvenio());
            pst.setString(9, s.getCorregimiento());
            pst.setString(10, s.getCarguista());
            pst.setString(11, s.getPredio());
            pst.setString(12, s.getId_cliente());
            pst.setInt(13, s.getId_conductor());
            pst.setString(14, s.getPlaca());
            pst.setString(15, s.getId_conductor_temp());
            pst.setString(16, s.getNombre_conductor_temp());
            pst.setString(17, s.getApellido_conductor_temp());
            pst.setString(18, s.getCelular_conductor_temp());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "La salida ya existe, digite otro código por favor..");

            } else {
                System.out.println(e.getMessage());
            }

            return false;
        }
    }

    public ResultSet MAXSalida() throws SQLException {
        try {
            sSql = "SELECT MAX(codigo_salida + 1) AS codigo_salida FROM salida";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

    public ResultSet Convenio(int maxsalida) throws SQLException {
        try {
            sSql = "SELECT convenio FROM salida WHERE codigo_salida = '" + maxsalida + "'";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

    public ResultSet MAXSalidaParcial(String codigo) throws SQLException {
        try {
            sSql = "SELECT MAX(s.parcial) AS MAXParcial, s.motivo, s.destino, s.convenio, s.corregimiento, s.predio, c.id_cliente, c.nombre, c.celular"
                    + " FROM salida s, cliente c WHERE s.numero_orden = '" + codigo + "'AND s.id_cliente = c.id_cliente GROUP BY s.motivo, s.destino, s.convenio, s.corregimiento, s.predio, c.id_cliente";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

    public ResultSet MAXPerdida() throws SQLException {
        try {
            sSql = "SELECT MAX(numero_orden) FROM salida WHERE numero_orden LIKE '%P%'";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

    public ResultSet MAXTrasplantado() throws SQLException {
        try {
            sSql = "SELECT MAX(numero_orden) FROM salida WHERE numero_orden LIKE '%T%'";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

    public boolean actualizarParcial(String codigo) {

        sSql = "UPDATE salida SET parcial = 1 WHERE numero_orden = '" + codigo + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean trasplantar(String codigo_ingreso, int cantidad) {

        sSql = "UPDATE ingreso_planta SET stock = stock + '" + cantidad + "' WHERE "
                + " codigo_ingreso = '" + codigo_ingreso + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean cancelarSalida(String codigo_ingreso, int cantidad) {

        sSql = "UPDATE ingreso_planta SET stock = stock +  '" + cantidad + "' WHERE codigo_ingreso = '" + codigo_ingreso + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            return false;
        }
    }

    public DefaultTableModel buscarSalidaSinMotivo(String desde, String hasta) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Número de Orden", "Fecha", "Entrega Parcial", "Soporte", "Cédula"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT s.codigo_salida, s.numero_orden, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.parcial, s.motivo, s.id_cliente FROM salida s "
                + " WHERE fecha BETWEEN '" + desde + "' AND '" + hasta + "' ORDER BY codigo_salida DESC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("numero_orden");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("parcial");
                registro[4] = rs.getString("motivo");
                registro[5] = rs.getString("id_cliente");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public DefaultTableModel buscarSalidaSinMotivoDetallado(String desde, String hasta, String numero) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Número de Orden", "Fecha", "Entrega Parcial", "Soporte", "Cédula"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT s.codigo_salida, s.numero_orden, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.parcial, s.motivo, s.id_cliente FROM salida s "
                + " WHERE fecha BETWEEN '" + desde + "' AND '" + hasta + "' AND s.numero_orden = '" + numero + "' ORDER BY codigo_salida DESC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("numero_orden");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("parcial");
                registro[4] = rs.getString("motivo");
                registro[5] = rs.getString("id_cliente");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public DefaultTableModel buscarSalida(String motivo, String desde, String hasta) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Número de Orden", "Fecha", "Entrega Parcial", "Soporte", "Cédula"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT s.codigo_salida, s.numero_orden, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.parcial, s.motivo, s.id_cliente, s.destino FROM salida s "
                + " WHERE motivo = '" + motivo + "' AND fecha BETWEEN '" + desde + "' AND '" + hasta + "' ORDER BY codigo_salida DESC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("numero_orden");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("parcial");
                registro[4] = rs.getString("motivo");
                registro[5] = rs.getString("id_cliente");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public DefaultTableModel buscarSalidaPerdida(String motivo, String desde, String hasta) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Número de Orden", "Fecha", "Soporte", "Total de pérdidas"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT d.cantidad, s.codigo_salida, s.numero_orden, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.motivo FROM salida s, detalle_salida d "
                + " WHERE s.codigo_salida = d.codigo_salida AND s.motivo = '" + motivo + "' AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' GROUP BY d.cantidad, s.numero_orden, s.codigo_salida ORDER BY codigo_salida DESC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("numero_orden");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("motivo");
                registro[4] = rs.getString("cantidad");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public DefaultTableModel buscarSalidaTrasplantado(String motivo, String desde, String hasta) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Número de Orden", "Fecha", "Soporte", "Total trasplantadas"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT d.cantidad, s.numero_orden, s.codigo_salida, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.motivo FROM salida s, detalle_salida d "
                + " WHERE motivo = '" + motivo + "' AND fecha BETWEEN '" + desde + "' AND '" + hasta + "' AND s.codigo_salida = d.codigo_salida"
                + " GROUP BY d.cantidad, s.numero_orden, s.codigo_salida ORDER BY codigo_salida DESC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("numero_orden");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("motivo");
                registro[4] = rs.getString("cantidad");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public DefaultTableModel buscarSalidaDetalle(String motivo, String desde, String hasta, String codigo) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Número de Orden", "Fecha", "Entrega Parcial", "Soporte", "Cédula", "Cliente"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT s.codigo_salida, s.numero_orden, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.parcial, s.motivo, s.id_cliente, s.destino, c.nombre FROM salida s, cliente c "
                + " WHERE motivo = '" + motivo + "' AND fecha BETWEEN '" + desde + "' AND '" + hasta + "' AND s.numero_orden = '" + codigo + "' AND c.id_cliente = s.id_cliente"
                + " ORDER BY codigo_salida DESC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("numero_orden");
                registro[2] = rs.getString("fecha");
                registro[3] = rs.getString("parcial");
                registro[4] = rs.getString("motivo");
                registro[5] = rs.getString("id_cliente");
                registro[6] = rs.getString("nombre");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public ResultSet contarSalidas(String mes, String año) throws SQLException {
        sSql = "SELECT COUNT(distinct codigo_salida) FROM salida WHERE date_part('month', fecha) = '" + mes + "' AND date_part('year', fecha) = '" + año + "' AND codigo_salida != 0";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet contarVentas(String mes, String año) throws SQLException {
        sSql = "SELECT COUNT(distinct codigo_salida) FROM salida WHERE date_part('month', fecha) = '" + mes + "' AND date_part('year', fecha) = '" + año + "' AND motivo = 'Venta' AND codigo_salida != 0";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarSalidaPorCliente(String cedula) throws SQLException {

        sSql = "SELECT id_cliente FROM salida WHERE id_cliente =  '" + cedula + "' ";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarExcelSalidaTyP(String desde, String hasta) throws SQLException {

        sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.numero_orden, s.motivo, d.cantidad, i.codigo_ingreso, d.codigo_salida, i.tamaño_bolsa, d.tamaño_destino, i.rango, p.codigo_planta, p.nombre_vulgar, p.nombre_cientifico, p.familia, p.msnm FROM salida s, detalle_salida d, planta p, ingreso_planta i "
                + " WHERE s.codigo_salida != 0 AND s.codigo_salida = d.codigo_salida AND d.codigo_ingreso = i.codigo_ingreso AND i.codigo_planta = p.codigo_planta AND s.motivo = 'Pérdida' AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' OR s.codigo_salida != 0 AND s.codigo_salida = d.codigo_salida AND d.codigo_ingreso = i.codigo_ingreso AND i.codigo_planta = p.codigo_planta AND s.motivo = 'Trasplantado' AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' ";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarExcelSalida(String motivo, String desde, String hasta) throws SQLException {

        if (!motivo.equals("")) {
            sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.numero_orden, s.motivo, s.corregimiento, s.destino, s.predio, s.convenio, SUM(d.cantidad) AS ctotal, s.carga, s.id_cliente, c.nombre, c.celular, s.id_conductor, CONCAT(co.nombre, ' ', co.apellido) AS nombreco, co.celular AS celularco, i.codigo_ingreso, s.parcial, s.carga, d.codigo_salida, d.cantidad, d.pedidas, i.tamaño_bolsa, i.rango, p.codigo_planta, p.nombre_vulgar, p.nombre_cientifico, p.familia, p.msnm, s.id_conductor_temp, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp FROM salida s, detalle_salida d, cliente c, conductor co, planta p, ingreso_planta i "
                    + "WHERE s.codigo_salida != 0 AND s.codigo_salida = d.codigo_salida AND d.codigo_ingreso = i.codigo_ingreso AND i.codigo_planta = p.codigo_planta AND s.id_cliente = c.id_cliente AND s.id_conductor = co.id_conductor AND s.motivo = '" + motivo + "' AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' GROUP BY i.codigo_ingreso, s.id_conductor_temp, i.tamaño_bolsa, i.rango, s.parcial, s.carga, p.nombre_vulgar, p.nombre_cientifico, p.familia, p.msnm, p.codigo_planta, d.cantidad, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp, d.pedidas, d.codigo_salida, s.fecha, s.codigo_salida, s.numero_orden, s.motivo, s.convenio, s.id_cliente, s.id_conductor, s.carga, s.predio, s.corregimiento, s.destino, c.nombre, c.celular, co.nombre, co.apellido, co.celular, d.codigo_ingreso ORDER BY s.codigo_salida DESC";
        } else {

            sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.numero_orden, s.motivo, s.corregimiento, s.destino, s.predio, s.convenio, SUM(d.cantidad) AS ctotal, s.parcial, s.carga, s.id_cliente, c.nombre, c.celular, s.id_conductor, CONCAT(co.nombre, ' ', co.apellido) AS nombreco, co.celular AS celularco, i.codigo_ingreso, s.carga, d.codigo_salida, d.cantidad, d.pedidas, i.tamaño_bolsa, i.rango, p.codigo_planta, p.nombre_vulgar, p.nombre_cientifico, p.familia, p.msnm, s.id_conductor_temp, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp FROM salida s, detalle_salida d, cliente c, conductor co, planta p, ingreso_planta i "
                    + "WHERE s.codigo_salida != 0 AND s.codigo_salida = d.codigo_salida AND d.codigo_ingreso = i.codigo_ingreso AND i.codigo_planta = p.codigo_planta AND s.id_cliente = c.id_cliente AND s.id_conductor = co.id_conductor AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' GROUP BY i.codigo_ingreso, i.tamaño_bolsa, i.rango, s.parcial, s.carga, p.nombre_vulgar, s.id_conductor_temp, p.nombre_cientifico, s.id_conductor_temp, p.familia, p.msnm, p.codigo_planta, d.cantidad, d.pedidas, d.codigo_salida, s.fecha, s.codigo_salida, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp, s.numero_orden, s.motivo, s.convenio, s.id_cliente, s.id_conductor, s.carga, s.predio, s.corregimiento, s.destino, c.nombre, c.celular, co.nombre, co.apellido, co.celular, d.codigo_ingreso ORDER BY s.codigo_salida DESC";
        }

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarExcelSalidaDetallado(String motivo, String desde, String hasta, String codigo) throws SQLException {

        if (!motivo.equals("")) {
            sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.numero_orden, s.motivo, s.destino, s.corregimiento, s.predio, s.convenio, SUM(d.cantidad) AS ctotal, s.carga, s.id_cliente, c.nombre, c.celular, s.id_conductor, CONCAT(co.nombre, ' ', co.apellido) AS nombreco, co.celular AS celularco, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp, s.id_conductor_temp FROM salida s, detalle_salida d, cliente c, conductor co "
                    + "WHERE s.numero_orden = '" + codigo + "' AND s.id_cliente = c.id_cliente AND s.id_conductor = co.id_conductor AND s.codigo_salida != 0 AND s.codigo_salida = d.codigo_salida AND s.codigo_salida = d.codigo_salida AND s.motivo = '" + motivo + "' AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' GROUP BY s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp, s.id_conductor_temp, s.codigo_salida, s.fecha, s.numero_orden, c.nombre, c.celular, co.nombre, co.apellido, co.celular, s.id_cliente, s.id_conductor, s.predio, s.carga, s.observacion, s.motivo, s.destino, s.corregimiento, s.convenio ORDER BY s.codigo_salida DESC";
        } else {

            sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.numero_orden, s.motivo, s.destino, s.corregimiento, s.predio, s.convenio, SUM(d.cantidad) AS ctotal, s.carga, s.id_cliente, c.nombre, c.celular, s.id_conductor, CONCAT(co.nombre, ' ', co.apellido) AS nombreco, co.celular AS celularco, s.id_conductor_temp, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp FROM salida s, detalle_salida d, cliente c, conductor co "
                    + "WHERE s.numero_orden = '" + codigo + "' AND s.id_cliente = c.id_cliente AND s.id_conductor = co.id_conductor AND s.codigo_salida != 0 AND s.codigo_salida = d.codigo_salida AND s.fecha BETWEEN '" + desde + "' AND '" + hasta + "' GROUP BY s.codigo_salida, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp, s.fecha, s.id_conductor_temp, s.numero_orden, c.nombre, c.celular, co.nombre, co.apellido, co.celular, s.id_cliente, s.id_conductor, s.predio, s.carga, s.observacion, s.motivo, s.destino, s.corregimiento, s.convenio ORDER BY s.codigo_salida DESC";
        }

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarExcelSalidaEspecifico(String codigo) throws SQLException {

        sSql = "SELECT * FROM salida s, detalle_salida d, planta p, ingreso_planta i WHERE s.numero_orden = '" + codigo + "' "
                + "AND d.codigo_salida = s.codigo_salida AND i.codigo_ingreso = d.codigo_ingreso AND i.codigo_planta = p.codigo_planta ORDER BY s.parcial ASC";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarExcelInfoSalida(String codigo) throws SQLException {

        sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.numero_orden, s.motivo, s.corregimiento, s.destino, s.predio, s.convenio, SUM(d.cantidad) AS ctotal, s.carga, s.id_cliente, c.nombre, c.celular, s.id_conductor, CONCAT(co.nombre, ' ', co.apellido) AS nombreco, co.celular AS celularco, d.codigo_ingreso,d.codigo_salida, d.cantidad, d.pedidas, p.codigo_planta, p.nombre_vulgar, p.nombre_cientifico, p.familia, p.msnm, s.id_conductor_temp, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp FROM salida s, detalle_salida d, cliente c, conductor co, planta p, ingreso_planta i "
                + "WHERE s.id_cliente = c.id_cliente AND s.id_conductor = co.id_conductor AND s.numero_orden = '" + codigo + "' AND s.codigo_salida = d.codigo_salida AND i.codigo_ingreso = d.codigo_ingreso AND i.codigo_planta = p.codigo_planta GROUP BY s.id_conductor_temp, s.nombre_conductor_temp, s.apellido_conductor_temp, celular_conductor_temp, p.nombre_vulgar, p.nombre_cientifico, p.familia, p.msnm, p.codigo_planta, d.cantidad, d.pedidas, d.codigo_salida, s.fecha, s.codigo_salida, s.numero_orden, s.motivo, s.convenio, s.id_cliente, s.id_conductor, s.carga, s.predio, s.corregimiento, s.destino, c.nombre, c.celular, co.nombre, co.apellido, co.celular, d.codigo_ingreso ORDER BY s.codigo_salida DESC";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarCodigoSalida(String codigo) throws SQLException {

        sSql = sSql = "SELECT numero_orden FROM salida WHERE numero_orden = '" + codigo + "'";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarSalidaPorCodigo(String numero_orden, String codigo_salida) throws SQLException {

        sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.parcial, s.numero_orden, s.motivo, s.destino, s.corregimiento, s.predio, s.convenio, c.nombre AS nombreco, c.apellido AS apellidoco, "
                + " c.id_conductor, c.celular AS celularco, s.placa, ci.nombre, ci. id_cliente, ci.celular, s.carga, s.observacion, s.id_conductor_temp, s.nombre_conductor_temp, s.apellido_conductor_temp, s.celular_conductor_temp "
                + " FROM salida s, conductor c, cliente ci  WHERE s.codigo_salida = '" + codigo_salida + "' AND s.numero_orden = '" + numero_orden + "'"
                + " AND s.id_cliente = ci.id_cliente AND s.id_conductor = c.id_conductor ";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarSalidaPerdida(String numero_orden, String codigo_salida) throws SQLException {

        sSql = "SELECT to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.codigo_salida, s.numero_orden, s.motivo, s.observacion FROM salida s"
                + " WHERE s.codigo_salida = '" + codigo_salida + "' AND s.numero_orden = '" + numero_orden + "'";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public boolean actualizar(String codigo_salida, String numero_orden, String destino, String corregimiento, String predio, String convenio, String carga, String observacion, String placa) {

        sSql = "UPDATE salida SET destino = '" + destino + "', corregimiento = '" + corregimiento + "', predio = '" + predio + "'"
                + " , convenio = '" + convenio + "', carga = '" + carga + "', placa = '" + placa + "', observacion = '" + observacion + "' WHERE codigo_salida = '" + codigo_salida + "' AND numero_orden = '" + numero_orden + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean eliminarSalida(String codigo_salida, String numero_orden) {

        sSql = "DELETE FROM salida WHERE codigo_salida = '" + codigo_salida + "' AND numero_orden = '" + numero_orden + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
