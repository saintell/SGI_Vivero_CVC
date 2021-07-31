package DAO;

import Modelo.Ingreso_;
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
public class IngresoDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearIngreso(Ingreso_ i) {

        sSql = "INSERT INTO ingreso_planta(codigo_ingreso, codigo_planta, tamaño_bolsa, rango, stock, disponibles, reservadas)"
                + " values (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setString(1, i.getCodigoIngreso());
            pst.setInt(2, i.getCodigoEspecie());
            pst.setString(3, i.getTamanoBolsa());
            pst.setString(4, i.getRango());
            pst.setInt(5, i.getStock());
            pst.setInt(6, i.getDisponibles());
            pst.setInt(7, 0);

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

    public boolean actualizarStock(int cantidad, String codigo_ingreso) {

        sSql = "UPDATE ingreso_planta SET stock = '" + cantidad + " ', disponibles = '"+ cantidad + "' - reservadas WHERE codigo_ingreso = '" + codigo_ingreso + "'";

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

    public ResultSet buscar(String codigo_ingreso) throws SQLException {
        sSql = "SELECT * FROM ingreso_planta i, planta p WHERE codigo_ingreso = '" + codigo_ingreso + "' AND i.codigo_planta = p.codigo_planta ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarAlimentarInventario(String identificador) throws SQLException {
        sSql = "SELECT * FROM detalle_ingreso d,ingreso_planta i, planta p WHERE d.identificador = '" + identificador + "' AND i.codigo_planta = p.codigo_planta "
                + " AND d.codigo_ingreso =  i.codigo_ingreso ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarDisponibles() throws SQLException {

        sSql = "SELECT * FROM ingreso_planta i, planta p WHERE stock != 0 AND i.codigo_planta = p.codigo_planta ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarTodas() throws SQLException {
        sSql = "SELECT * FROM ingreso_planta i, planta p WHERE i.codigo_ingreso != '0' AND p.codigo_planta = i.codigo_planta";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel listar(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Codigo", "Nombre Común", "Nombre Científico", "Tamaño de Bolsa", "Rango", "Stock", "Disponibles", "Reservadas"};
        String registro[] = new String[8];
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

        sql = "SELECT * FROM ingreso_planta i, planta p WHERE (i.codigo_ingreso LIKE '" + busca + "%' OR p.nombre_vulgar LIKE '" + busca + "%'"
                + " OR i.tamaño_bolsa LIKE'" + busca + "%' OR i.rango LIKE '" + busca + "%') AND i.codigo_planta = p.codigo_planta"
                + " AND stock != 0 ORDER BY codigo_ingreso ASC";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("codigo_ingreso");
                registro[1] = rs.getString("nombre_vulgar");
                registro[2] = rs.getString("nombre_cientifico");
                registro[3] = rs.getString("tamaño_bolsa");
                registro[4] = rs.getString("rango");
                registro[5] = rs.getString("stock");
                registro[6] = rs.getString("disponibles");
                registro[7] = rs.getString("reservadas");

                modelo.addRow(registro);

            }

            if (contador == 0 && !busca.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                registro[3] = "Sin resultados...";
                registro[4] = "Sin resultados...";
                registro[5] = "Sin resultados...";

                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public DefaultTableModel mostrarAgotados() {
        DefaultTableModel modelo;

        String[] titulos = {"Código", "Nombre", "Tamaño", "Rango", "Disponibles"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        sSql = "SELECT i.codigo_ingreso, p.nombre_vulgar, i. tamaño_bolsa, i.rango, i.disponibles  FROM ingreso_planta i, planta p "
                + " WHERE p.codigo_planta != 0 AND i.codigo_planta = p.codigo_planta AND i.disponibles <= 0 ORDER BY codigo_ingreso ASC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("codigo_ingreso");
                registro[1] = rs.getString("nombre_vulgar");
                registro[2] = rs.getString("tamaño_bolsa");
                registro[3] = rs.getString("rango");
                registro[4] = rs.getString("disponibles");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public ResultSet buscarporCodigo(String codigo) throws SQLException {
        sSql = "SELECT * FROM ingreso_planta i, planta p WHERE i.codigo_ingreso = '" + codigo + "' AND p.codigo_planta = i.codigo_planta";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public boolean actualizarAlimentarInventario(String cantidad, String fecha, String codigo, String identificador) {
        sSql = "UPDATE detalle_ingreso SET cantidad = '" + cantidad + " ' , fecha = '" + fecha + "'  WHERE identificador = '" + identificador + "'  ";
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

    public boolean eliminarItemAlimentarInventario(String identificador) {
        sSql = "DELETE  FROM detalle_ingreso  WHERE  identificador = '" + identificador + "'  ";
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

    public ResultSet obtenerRegistroYstock(String identificador, String codigo) throws SQLException {
        sSql = "SELECT d.cantidad,i.stock from ingreso_planta i, detalle_ingreso d WHERE d.identificador = '" + identificador + "' AND i.codigo_ingreso = '" + codigo + "' ";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public boolean restarCantidadInventario(int cantidadResta, String codigo_ingreso) {
        sSql = "UPDATE ingreso_planta SET stock = stock - '" + cantidadResta + " ' WHERE codigo_ingreso = '" + codigo_ingreso + "'  ";
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

    public boolean eliminarIngresoPlanta(String codigo_ingreso) {
        sSql = "DELETE FROM ingreso_planta WHERE codigo_ingreso = '" + codigo_ingreso + "'  ";
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

    public boolean sumarCantidadInventario(int cantidadSuma, String codigo_ingreso) {
        sSql = "UPDATE ingreso_planta SET stock = stock + '" + cantidadSuma + " ' WHERE codigo_ingreso = '" + codigo_ingreso + "'  ";
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

    public ResultSet contarRegistros(String codigo) throws SQLException {
        sSql = "SELECT COUNT(codigo_ingreso) AS numero_registros FROM detalle_ingreso WHERE codigo_ingreso = '" + codigo + "' ";

        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

}
