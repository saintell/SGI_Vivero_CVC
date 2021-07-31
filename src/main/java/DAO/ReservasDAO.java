package DAO;

import Modelo.Reserva_;
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
public class ReservasDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    String sSql2 = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearReserva(Reserva_ r) {

        sSql = "INSERT INTO reserva(codigo_reserva, id_cliente, codigo_ingreso, tamaño_bolsa, rango, cantidad, costo_reserva, fecha_apertura, fecha_cierre)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setInt(1, r.getCodigo_reserva());
            pst.setString(2, r.getId_cliente());
            pst.setInt(3, r.getCodigo_planta());
            pst.setString(4, r.getTamaño_bolsa());
            pst.setString(5, r.getRango());
            pst.setInt(6, r.getCantidad());
            pst.setInt(7, 0);
            pst.setDate(8, r.getFechaApertura());
            pst.setDate(9, r.getFechaCierre());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "Reserva ya creada.");

            } else {
                System.out.println(e.getMessage());
            }

            return false;
        }
    }

    public ResultSet MAXreserva() throws SQLException {
        try {
            sSql = "SELECT MAX(codigo_reserva) FROM reserva ";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

    public boolean reservar(int codigo_ingreso, int cantidad, String tamaño_bolsa, String rango) {

        try {
        sSql = "UPDATE ingreso_planta SET reservadas = reservadas + '" + cantidad + "', disponibles = disponibles - '" + cantidad + "', stock = (disponibles - '" + cantidad + "') + (reservadas + '" + cantidad + "')  WHERE "
                + " tamaño_bolsa = '" + tamaño_bolsa + "' AND rango = '" + rango + "' AND codigo_ingreso = '" + codigo_ingreso + "'";


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

    public boolean cerrarReserva(String fecha_cierre, String codigo_reserva) {

        sSql = "UPDATE reserva SET  fecha_cierre = '" + fecha_cierre + "'  WHERE "
                + "codigo_reserva = '" + codigo_reserva + "'";

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

    public boolean deshacerReserva(int codigo_ingreso, int cantidad, String tamaño_bolsa, String rango) {

        sSql = "UPDATE ingreso_planta SET reservadas = reservadas - '" + cantidad + " ', disponibles = disponibles + '" + cantidad + "',stock = (disponibles + '" + cantidad + "') + (reservadas - '" + cantidad + "')  WHERE "
                + " tamaño_bolsa = '" + tamaño_bolsa + "' AND rango = '" + rango + "' AND codigo_ingreso = '" + codigo_ingreso + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean eliminarReserva(int codigo_reserva, int codigo_ingreso, int cantidad, String tamaño_bolsa, String rango) {

        sSql = "DELETE FROM reserva WHERE codigo_reserva = '" + codigo_reserva + "' AND codigo_ingreso = '" + codigo_ingreso + "' AND tamaño_bolsa = '" + tamaño_bolsa + "'"
                + " AND rango = '" + rango + "' AND cantidad = '" + cantidad + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return false;
        }
    }

    public ResultSet buscarReserva(String codigo) throws SQLException {
        sSql = "SELECT r.codigo_reserva, r.id_cliente, c.nombre, c.celular FROM reserva r, cliente c WHERE"
                + " r.codigo_reserva != 0 AND r.codigo_reserva = '" + codigo + "' AND r.id_cliente = c.id_cliente";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel mostrarReservadas(String codigo) {
        DefaultTableModel modelo;

        String[] titulos = {"Código", "Nombre Común", "Nombre Científico", "Rango", "Tamaño de Bolsa", "Cantidad"};

        String[] registro = new String[6];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT * FROM reserva r, ingreso_planta i, planta p WHERE r.codigo_reserva != 0 AND r.codigo_reserva = ' " + codigo + "' AND"
                + " r.codigo_ingreso = i.codigo_ingreso AND i.codigo_planta = p.codigo_planta ORDER BY i.codigo_ingreso";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_ingreso");
                registro[1] = rs.getString("nombre_vulgar");
                registro[2] = rs.getString("nombre_cientifico");
                registro[3] = rs.getString("rango");
                registro[4] = rs.getString("tamaño_bolsa");
                registro[5] = rs.getString("cantidad");
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public DefaultTableModel mostrarCodigosReservas(String busca) {
        DefaultTableModel modelo;

        String[] titulos = {"Código de Reserva", "Cédula", "Cliente", "Fecha Reserva"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        if (busca.contains("-")) {

            sSql = "SELECT r.codigo_reserva, to_char(r.fecha_apertura, 'DD/MM/YYYY') AS fecha, c.nombre, r.id_cliente FROM reserva r, cliente c WHERE r.id_cliente = '" + busca + "' AND r.id_cliente = c.id_cliente AND r.fecha_cierre is null"
                    + " GROUP BY r.codigo_reserva, r.fecha_apertura, c.nombre, r.id_cliente ORDER BY r.codigo_reserva ASC";
        } else {

            sSql = "SELECT r.codigo_reserva, to_char(r.fecha_apertura, 'DD/MM/YYYY') AS fecha, c.nombre, r.id_cliente FROM reserva r, cliente c WHERE r.id_cliente = '" + busca + "' AND r.id_cliente = c.id_cliente AND r.fecha_cierre is null"
                    + " OR r.codigo_reserva != 0 AND r.codigo_reserva = '" + busca + "' AND r.id_cliente = c.id_cliente AND r.fecha_cierre is null GROUP BY r.codigo_reserva, r.fecha_apertura, c.nombre, r.id_cliente ORDER BY r.codigo_reserva ASC";
        }

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_reserva");
                registro[1] = rs.getString("id_cliente");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("fecha");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public DefaultTableModel mostrarCodigosReservasNIT(String busca) {
        DefaultTableModel modelo;

        String[] titulos = {"Código de Reserva", "Cédula", "Cliente", "Fecha Reserva"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT r.codigo_reserva, to_char(r.fecha_apertura, 'DD/MM/YYYY') AS fecha, c.nombre, r.id_cliente FROM reserva r, cliente c WHERE r.id_cliente = '" + busca + "' AND r.id_cliente = c.id_cliente AND r.fecha_cierre is null"
                + " GROUP BY r.codigo_reserva, r.fecha_apertura, c.nombre, r.id_cliente ORDER BY r.codigo_reserva ASC ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_reserva");
                registro[1] = rs.getString("id_cliente");
                registro[2] = rs.getString("nombre");
                registro[3] = rs.getString("fecha");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            return null;
        }
    }

    public ResultSet contarReservas() throws SQLException {
        sSql = "SELECT COUNT(distinct codigo_reserva) FROM reserva WHERE codigo_reserva != 0 AND fecha_cierre IS NULL";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

}
