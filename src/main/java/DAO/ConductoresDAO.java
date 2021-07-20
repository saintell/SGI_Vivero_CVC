package DAO;

import Modelo.Conductor_;
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
public class ConductoresDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearConductor(Conductor_ c) {

        sSql = "INSERT INTO conductor(id_conductor, nombre, apellido, celular, estado)"
                + " values (?, ?, ?, ?,?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setInt(1, c.getCedula());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getApellido());
            pst.setLong(4, Long.parseLong(c.getCelular()));
            pst.setString(5, c.getEstado().name());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "Conductor ya creado.");

            } else {
                System.out.println(e.getMessage());
            }

            return false;
        }
    }

    public ResultSet buscar(String cedula) throws SQLException {
        sSql = "SELECT * FROM conductor WHERE id_conductor = '" + cedula + "' ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscar1() throws SQLException {
        sSql = "SELECT * FROM conductor WHERE id_conductor != ''";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel mostrarACTIVOS() {
        DefaultTableModel modelo;

        String[] titulos = {"Cedula", "Nombre", "Apellido", "Celular"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT * FROM conductor WHERE id_conductor != '" + 0 + "' AND  estado = 'ACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("id_conductor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarINACTIVOS() {
        DefaultTableModel modelo;

        String[] titulos = {"Cedula", "Nombre", "Apellido", "Celular"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT * FROM conductor WHERE id_conductor != '" + 0 + "' AND estado = 'INACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("id_conductor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean actualizar(String cedula, String nombre, String apellido, long celular) {

        sSql = "UPDATE conductor SET id_conductor = '" + cedula + "', nombre = '" + nombre + "'"
                + ", apellido = '" + apellido + "', celular = '" + celular + "' WHERE id_conductor = '" + cedula + "'";

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

    public DefaultTableModel listarActivos(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Cédula", "Nombre", "Apellido", "Celular"};
        String registro[] = new String[4];
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

        sql = "SELECT * FROM conductor c WHERE (c.apellido LIKE '" + busca + "%' OR c.nombre LIKE '" + busca + "%'"
                + " OR CAST(c.id_conductor AS VARCHAR(10)) LIKE '" + busca + "%') AND estado = 'ACTIVO' ";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("id_conductor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");

                modelo.addRow(registro);

            }

            if (contador == 0 && !busca.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                registro[3] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public DefaultTableModel buscarConductor(String cedula) {

        DefaultTableModel modelo;
        String[] titulos = {"Cédula", "Nombre", "Apellido", "Celular"};
        String registro[] = new String[4];
        modelo = new DefaultTableModel(null, titulos);

        int contador = 0;

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";

        sql = "SELECT * FROM conductor c WHERE c.id_conductor ='" + cedula + "'   AND c.estado = 'ACTIVO' ";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("id_conductor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");

                modelo.addRow(registro);

            }

            if (contador == 0 && !cedula.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                registro[3] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public DefaultTableModel listarInactivos(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Cédula", "Nombre", "Apellido", "Celular"};
        String registro[] = new String[4];
        modelo = new DefaultTableModel(null, titulos);

        int contador = 0;

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";

        sql = "SELECT * FROM conductor c WHERE (c.apellido LIKE '" + busca + "%' OR c.nombre LIKE '" + busca + "%'"
                + " OR CAST(c.id_conductor AS VARCHAR(10)) LIKE '" + busca + "%') AND estado = 'INACTIVO' ";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("id_conductor");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");

                modelo.addRow(registro);

            }

            if (contador == 0 && !busca.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                registro[3] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean desactivar(String cedula) {

        sSql = "UPDATE conductor SET estado = 'INACTIVO' WHERE id_conductor = '" + cedula + "'";

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

    public boolean activar(String cedula) {

        sSql = "UPDATE conductor SET estado = 'ACTIVO' WHERE id_conductor = '" + cedula + "'";

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

    public boolean eliminarConductor(String id_conductor) {

        sSql = "DELETE FROM conductor WHERE id_conductor = '" + id_conductor + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, El conductor ya se encuentra en una salida." + "\n" + "Este no se puede eliminar.");
            return false;
        }
    }

}
