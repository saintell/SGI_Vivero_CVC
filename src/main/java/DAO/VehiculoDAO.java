package DAO;

import Modelo.Vehiculo_;
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
public class VehiculoDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearVehiculo(Vehiculo_ v) {

        sSql = "INSERT INTO vehiculo(placa, marca, estado)"
                + " values (?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setString(1, v.getPlaca());
            pst.setString(2, v.getMarca());
            pst.setString(3, v.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "Vehículo ya creado.");

            } else {
                System.out.println(e.getMessage());
            }

            return false;
        }
    }

    public ResultSet buscar(String placa) throws SQLException {
        sSql = "SELECT * FROM vehiculo WHERE placa = '" + placa + "' ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscar1() throws SQLException {
        sSql = "SELECT * FROM vehiculo WHERE placa != ''";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel mostrarACTIVOS() {
        DefaultTableModel modelo;

        String[] titulos = {"Placa", "Marca"};

        String[] registro = new String[2];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT * FROM vehiculo WHERE placa != '" + "' AND marca != '" + "' AND estado = 'ACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("placa");
                registro[1] = rs.getString("marca");

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

        String[] titulos = {"Placa", "Marca"};

        String[] registro = new String[2];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT * FROM vehiculo WHERE placa != '" + "' AND marca != '" + "' AND estado = 'INACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("placa");
                registro[1] = rs.getString("marca");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean actualizar(String placa, String marca) {

        sSql = "UPDATE vehiculo SET  marca = '" + marca + "' WHERE placa = '" + placa + "'";

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

    public DefaultTableModel listar(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Placa", "Marca"};
        String registro[] = new String[2];
        modelo = new DefaultTableModel(null, titulos){

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

        sql = "SELECT * FROM vehiculo v WHERE (v.placa LIKE '" + busca + "%' OR v.marca LIKE '" + busca + "%')"
                + " AND estado = 'ACTIVO'";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("placa");
                registro[1] = rs.getString("marca");

                modelo.addRow(registro);

            }

            if (contador == 0 && !busca.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public boolean desactivar(String placa) {

        sSql = "UPDATE vehiculo SET estado = 'INACTIVO' WHERE placa = '" + placa + "'";

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

    public boolean activar(String placa) {

        sSql = "UPDATE vehiculo SET estado = 'ACTIVO' WHERE placa = '" + placa + "'";

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

}
