package DAO;

import Modelo.DetalleSalida_;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class DetalleSalidaDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearDetalleSalida(DetalleSalida_ d) {

        sSql = "INSERT INTO detalle_salida(codigo_salida, codigo_ingreso, cantidad, pedidas, tamaño_destino, costo, total)"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setInt(1, d.getCodigo_salida());
            pst.setString(2, d.getCodigo_planta());
            pst.setInt(3, d.getCantidad());
            pst.setInt(4, d.getPedidas());
            pst.setString(5, d.getTamaño_destino());
            pst.setInt(6, 0);
            pst.setInt(7, 0);

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "El código de salida ya existe, ingrese otro por favor..");

            } else {
                System.out.println(e.getMessage());
            }

            return false;
        }
    }

    public DefaultTableModel buscarSalidaSinMotivoDetallado(String desde, String hasta, String numero) {
        DefaultTableModel modelo;

        String[] titulos = {"Código Salida", "Fecha", "Soporte", "Cédula", "Cliente"};

        String[] registro = new String[7];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT s.codigo_salida, to_char(s.fecha, 'DD/MM/YYYY') AS fecha, s.motivo, s.id_cliente, c.nombre FROM salida s, cliente c "
                + " WHERE fecha BETWEEN '" + desde + "' AND '" + hasta + "' AND s.id_cliente = '" + numero + "' AND c.id_cliente = s.id_cliente"
                + " ORDER BY codigo_salida ASC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("fecha");
                registro[2] = rs.getString("motivo");
                registro[3] = rs.getString("id_cliente");
                registro[4] = rs.getString("nombre");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public DefaultTableModel buscarDetalleSalida(String codigo) {
        DefaultTableModel modelo;

        String[] titulos = {"Código Salida", "Nombre Común", "Nombre Científico", "Tamaño", "Rango", "Cantidad"};

        String[] registro = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT * FROM detalle_salida d, ingreso_planta i, planta p WHERE d.codigo_salida = '" + codigo + "'"
                + " AND i.codigo_ingreso = d.codigo_ingreso AND p.codigo_planta = i.codigo_planta";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("nombre_vulgar");
                registro[2] = rs.getString("nombre_cientifico");
                registro[3] = rs.getString("tamaño_bolsa");
                registro[4] = rs.getString("rango");
                registro[5] = rs.getString("cantidad");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public DefaultTableModel buscarDetalleSalidaConIngreso(String numero_orden, String codigo_salida) {
        DefaultTableModel modelo;

        String[] titulos = {"Identificador", "Código de Planta", "Nombre Común", "Nombre Científico", "Tamaño", "Rango", "Pedido", "Cantidad"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT * FROM detalle_salida d, ingreso_planta i, planta p, salida s WHERE s.codigo_salida = '" + codigo_salida + "' AND s.numero_orden = '" + numero_orden + "'"
                + " AND s.codigo_salida = d.codigo_salida AND i.codigo_ingreso = d.codigo_ingreso AND p.codigo_planta = i.codigo_planta";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_salida");
                registro[1] = rs.getString("codigo_ingreso");
                registro[2] = rs.getString("nombre_vulgar");
                registro[3] = rs.getString("nombre_cientifico");
                registro[4] = rs.getString("tamaño_bolsa");
                registro[5] = rs.getString("rango");
                registro[6] = rs.getString("pedidas");
                registro[7] = rs.getString("cantidad");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean eliminarDetalle(String codigo_salida) {

        sSql = "DELETE FROM detalle_salida WHERE codigo_salida = '" + codigo_salida + "'";

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

    public ResultSet buscarDetalleTrasplantado(String codigo) throws SQLException {

        sSql = sSql = "SELECT s.numero_orden, d.codigo_salida, d.codigo_ingreso, d.tamaño_destino, d.cantidad, p.nombre_vulgar, i.tamaño_bolsa, i.rango FROM detalle_salida d, ingreso_planta i, planta p, salida s "
                + " WHERE d.codigo_salida = '" + codigo + "' AND d.codigo_salida = s.codigo_salida AND d.codigo_ingreso = i.codigo_ingreso AND i.codigo_planta = p.codigo_planta";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }
}
