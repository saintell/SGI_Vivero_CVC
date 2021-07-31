package DAO;

import Modelo.DetalleIngreso_;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Álvaro
 */
public class DetalleIngresoDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearDetalle(DetalleIngreso_ d) {

        sSql = "INSERT INTO detalle_ingreso(codigo_planta, cantidad, fecha, codigo_ingreso)"
                + " values (?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setInt(1, d.getCodigoEspecie());
            pst.setInt(2, d.getCantidad());
            pst.setDate(3, d.getFecha());
            pst.setString(4, d.getCodigo_ingreso());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {

            if (ex.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "Especie ya creada.");

            } else {
                System.out.println(ex.getMessage());
            }

            return false;
        }
    }

    public ResultSet buscarEspecie(String busca, String fechaInicio, String fechaFin) throws SQLException {
        sSql = "SELECT d.cantidad, to_char(d.fecha, 'DD/MM/YYYY') AS fecha, p.nombre_vulgar, i.tamaño_bolsa, i.rango FROM ingreso_planta i, detalle_ingreso d, planta p WHERE (i.codigo_ingreso LIKE '" + busca + "%' OR p.nombre_vulgar LIKE '" + busca + "%' OR "
                + "p.nombre_cientifico LIKE '" + busca + "%')"
                + " AND d.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' AND p.codigo_planta = d.codigo_planta AND "
                + "i.codigo_planta = d.codigo_planta AND d.codigo_ingreso = i.codigo_ingreso ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel listarEspecies(String busca, String fechaInicio, String fechaFin) {

        DefaultTableModel modelo;
        String[] titulos = {"N°","Codigo", "Nombre Común", "Bolsa", "Rango", "Cantidad", "fecha"};
        String registro[] = new String[7];
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        int contador = 0;

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";

        sql = "SELECT d.identificador, i.codigo_ingreso, d.cantidad, to_char(d.fecha, 'DD/MM/YYYY') AS fecha, p.nombre_vulgar, i.tamaño_bolsa, i.rango FROM ingreso_planta i, detalle_ingreso d, planta p WHERE (i.codigo_ingreso LIKE '" + busca + "%' OR p.nombre_vulgar LIKE '" + busca + "%' OR "
                + "p.nombre_cientifico LIKE '" + busca + "%')"
                + " AND d.fecha BETWEEN '" + fechaInicio + "' AND '" + fechaFin + "' AND p.codigo_planta = d.codigo_planta AND "
                + "i.codigo_planta = d.codigo_planta AND d.codigo_ingreso = i.codigo_ingreso ";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("identificador");
                registro[1] = rs.getString("codigo_ingreso");
                registro[2] = rs.getString("nombre_vulgar");
                registro[3] = rs.getString("tamaño_bolsa");
                registro[4] = rs.getString("rango");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("fecha");

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            return null;
        }
    }

    public ResultSet buscarEspecieFecha(String fechaInicio, String fechaFin) throws SQLException {
        sSql = "SELECT d.cantidad, to_char(d.fecha, 'DD/MM/YYYY') AS fecha, p.nombre_vulgar, i.tamaño_bolsa, i.rango FROM ingreso_planta i, detalle_ingreso d, planta p WHERE d.fecha BETWEEN '" + fechaInicio + "' AND "
                + "'" + fechaFin + "' AND p.codigo_planta = d.codigo_planta AND p.codigo_planta = i.codigo_planta AND "
                + "i.codigo_planta = d.codigo_planta AND d.codigo_ingreso = i.codigo_ingreso ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel listarEspeciesFecha(String fechaInicio, String fechaFin) {

        try {
            DefaultTableModel modelo;
            String[] titulos = {"N°","Codigo", "Nombre Común", "Bolsa", "Rango", "Cantidad", "fecha"};
            String registro[] = new String[7];
            modelo = new DefaultTableModel(null, titulos) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };

            int contador = 0;

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }
            String sql = "";

            sql = "SELECT d.identificador,i.codigo_ingreso, d.cantidad, to_char(d.fecha, 'DD/MM/YYYY') AS fecha, p.nombre_vulgar, i.tamaño_bolsa, i.rango FROM ingreso_planta i, detalle_ingreso d, planta p WHERE d.fecha BETWEEN '" + fechaInicio + "' AND "
                    + "'" + fechaFin + "' AND p.codigo_planta = d.codigo_planta AND p.codigo_planta = i.codigo_planta AND "
                    + "i.codigo_planta = d.codigo_planta AND d.codigo_ingreso = i.codigo_ingreso ORDER BY i.codigo_ingreso ASC";

            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("identificador");
                registro[1] = rs.getString("codigo_ingreso");
                registro[2] = rs.getString("nombre_vulgar");
                registro[3] = rs.getString("tamaño_bolsa");
                registro[4] = rs.getString("rango");
                registro[5] = rs.getString("cantidad");
                registro[6] = rs.getString("fecha");

                modelo.addRow(registro);

            }

            return modelo;
        } catch (SQLException ex) {
            return null;
        }

    }

    public boolean eliminar(int codigo_planta, int nit, String tamaño_bolsa, String fecha) {

        sSql = "DELETE FROM detalle_ingreso WHERE codigo_planta = '" + codigo_planta + "'"
                + "AND tamaño_bolsa = '" + tamaño_bolsa + "' AND nit = '" + nit + "' AND fecha = '" + fecha + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean restar(String codigo_ingreso, int cantidad) {

        sSql = "UPDATE ingreso_planta SET disponibles = disponibles - '" + cantidad + "', stock = (disponibles - '" + cantidad + "') + reservadas WHERE codigo_ingreso = '" + codigo_ingreso + "'";

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

    public boolean sumar(String codigo_ingreso, int cantidad) {

        sSql = "UPDATE ingreso_planta SET disponibles = disponibles + '" + cantidad + "', stock = (disponibles + '" + cantidad + "') + reservadas WHERE codigo_ingreso = '" + codigo_ingreso + "'";

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

    public boolean eliminar(String codigo_ingreso, String codigo_salida, int cantidad) {

        sSql = "DELETE FROM detalle_salida WHERE codigo_ingreso = '" + codigo_ingreso + "'"
                + " AND codigo_salida = '" + codigo_salida + "' AND cantidad = '" + cantidad + "'";

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
