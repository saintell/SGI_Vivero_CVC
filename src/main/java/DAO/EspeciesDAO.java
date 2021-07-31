package DAO;

import Modelo.Especie_;
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
public class EspeciesDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearEspecie(Especie_ e) {

        sSql = "INSERT INTO planta(codigo_planta, nombre_vulgar, nombre_cientifico, familia, msnm)"
                + " values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setInt(1, e.getCodigo());
            pst.setString(2, e.getNombreVulgar());
            pst.setString(3, e.getNombreCientifico());
            pst.setString(4, e.getFamilia());
            pst.setString(5, e.getMsnm());

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

    public DefaultTableModel mostrarINACTIVOS() {
        DefaultTableModel modelo;

        String[] titulos = {"Nombre Vulgar", "Nombre Científico", "Familia", "Msnm"};

        String[] registro = new String[4];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        sSql = "SELECT * FROM planta WHERE codigo_planta != 0 AND nombre_cientifico != '" + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("nombre_vulgar");
                registro[1] = rs.getString("nombre_cientifico");
                registro[2] = rs.getString("familia");
                registro[3] = rs.getString("msnm");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean actualizar(String codigo_planta, String nombre_vulgar, String nombre_cientifico, String familia, String msnm) {

        sSql = "UPDATE planta SET nombre_vulgar = '" + nombre_vulgar + "', nombre_cientifico = '" + nombre_cientifico + "'"
                + ", familia = '" + familia + "', msnm = '" + msnm + "' WHERE codigo_planta = '" + codigo_planta + "'";

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

    public boolean eliminarEspecie(String codigo_planta) {

        sSql = "DELETE FROM planta WHERE codigo_planta = '" + codigo_planta + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, la planta ya está siendo usada." + "\n" + "Esta no se puede eliminar.");
            return false;
        }
    }

    public ResultSet buscarIngresoPlanta(int codigo_planta, String tamano_bolsa, String rango) throws SQLException {
        sSql = "SELECT * FROM ingreso_planta WHERE codigo_planta = '" + codigo_planta + "' AND tamaño_bolsa = '" + tamano_bolsa + "' AND rango = '" + rango + "' ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }
    
    public ResultSet buscarIngreso(String codigo) throws SQLException {
        sSql = "SELECT * FROM ingreso_planta i, planta p WHERE i.codigo_ingreso = '" + codigo + "' AND p.codigo_planta = i.codigo_planta";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscarEspecie(String codigo_planta) throws SQLException {
        sSql = "SELECT * FROM planta WHERE codigo_planta = '" + codigo_planta + "'";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel listar(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Código", "Nombre Vulgar", "Nombre Cientifico", "Familia", "Msnm"};
        String registro[] = new String[5];
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

        sql = "SELECT * FROM planta p WHERE (p.nombre_vulgar LIKE  ('" + busca + "%'))"
                + " AND codigo_planta != 0 AND nombre_vulgar != '" + "' ORDER BY codigo_planta ASC";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("codigo_planta");
                registro[1] = rs.getString("nombre_vulgar");
                registro[2] = rs.getString("nombre_cientifico");
                registro[3] = rs.getString("familia");
                registro[4] = rs.getString("msnm");

                modelo.addRow(registro);

            }

            if (contador == 0 && !busca.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                registro[3] = "Sin resultados...";
                registro[4] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public DefaultTableModel listarEspRes(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Código de planta", "Nombre Vulgar", "Nombre Cientifico", "Tamaño de bolsa", "Rango", "Stock", "Disponibles", "Identificador"};
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

        sql = "SELECT * FROM planta p, ingreso_planta i WHERE (i.codigo_ingreso LIKE ('"+ busca +"%') OR p.nombre_vulgar LIKE  ('" + busca + "%'))"
                + " AND p.codigo_planta = i. codigo_planta "
                + " AND nombre_vulgar != ''";

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
                registro[7] = rs.getString("codigo_planta");

                modelo.addRow(registro);

            }

            if (contador == 0) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                registro[3] = "Sin resultados...";
                registro[4] = "Sin resultados...";
                registro[5] = "Sin resultados...";
                registro[6] = "Sin resultados...";
                registro[7] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public DefaultTableModel buscarPlanta(String codigo_planta) {

        DefaultTableModel modelo;
        String[] titulos = {"Nombre Vulgar", "Nombre Cientifico", "Familia", "Msnm"};
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

        sql = "SELECT * FROM planta WHERE codigo_planta = '" + codigo_planta + "' ";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("nombre_vulgar");
                registro[1] = rs.getString("nombre_cientifico");
                registro[2] = rs.getString("familia");
                registro[3] = rs.getString("msnm");

                modelo.addRow(registro);

            }

            if (contador == 0 && !codigo_planta.equals("")) {
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

    public ResultSet MAXEspecie() throws SQLException {
        try {
            sSql = "SELECT MAX(codigo_planta) FROM planta ";
            st = cn.createStatement();
            rs = st.executeQuery(sSql);
            return rs;
        } catch (StackOverflowError e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return rs;
        }
    }

}
