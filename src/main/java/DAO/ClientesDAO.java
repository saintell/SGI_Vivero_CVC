package DAO;

import Modelo.Cliente_;
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
public class ClientesDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearCliente(Cliente_ c) {

        sSql = "INSERT INTO cliente(id_cliente, nombre, celular)"
                + " values (?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setString(1, c.getCedula());
            pst.setString(2, c.getNombre());
            pst.setLong(3, c.getTelefono());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("duplicada")) {

                JOptionPane.showMessageDialog(null, "Cliente ya creado, presione enter en el campo de identificación para buscarlo.");

            }
            return false;
        }
    }

    public ResultSet buscar(String cedula) throws SQLException {
        sSql = "SELECT * FROM cliente WHERE id_cliente = '" + cedula + "' ";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public ResultSet buscar1() throws SQLException {
        sSql = "SELECT * FROM usuario WHERE usuario != ''";
        st = cn.createStatement();
        rs = st.executeQuery(sSql);
        return rs;
    }

    public DefaultTableModel mostrarACTIVOS() {
        DefaultTableModel modelo;

        String[] titulos = {"Usuario", "Nombre", "Apellido", "Celular", "Dirección"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT * FROM usuario WHERE nombre_usuario != '" + "' AND cargo != 'GERENTE' AND estado = 'ACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("usuario");
                registro[1] = rs.getString("nombre_usuario");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");
                registro[4] = rs.getString("direccion");

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

        String[] titulos = {"Usuario", "Nombre", "Apellido", "Celular", "Dirección"};

        String[] registro = new String[5];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSql = "SELECT * FROM usuario WHERE nombre_usuario != '" + "' AND cargo != 'GERENTE' AND estado = 'INACTIVO'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSql);

            while (rs.next()) {
                registro[0] = rs.getString("usuario");
                registro[1] = rs.getString("nombre_usuario");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");
                registro[4] = rs.getString("direccion");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public boolean actualizarCliente(String id_cliente, String nombre, long celular) {

        sSql = "UPDATE cliente SET nombre = '" + nombre + "', celular = '" + celular + "' WHERE id_cliente = '" + id_cliente + "'";

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

    public DefaultTableModel listarClientes(String busca) {

        DefaultTableModel modelo;
        String[] titulos = {"Cedula", "Nombre Completo", "Celular"};
        String registro[] = new String[3];
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

        sql = "SELECT * FROM cliente c WHERE (c.id_cliente LIKE  ('" + busca + "%') OR c.nombre LIKE ('" + busca + "%')  )";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("id_cliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("celular");

                modelo.addRow(registro);

            }

            if (contador == 0 && !busca.equals("")) {
                registro[0] = "Sin resultados...";
                registro[1] = "Sin resultados...";
                registro[2] = "Sin resultados...";
                modelo.addRow(registro);

            }

            return modelo;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
    }

    public DefaultTableModel buscarUsuario(String usuario) {

        DefaultTableModel modelo;
        String[] titulos = {"Usuario", "Nombre", "Apellido", "Celular", "Dirección"};
        String registro[] = new String[5];
        modelo = new DefaultTableModel(null, titulos);

        int contador = 0;

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";

        sql = "SELECT * FROM usuario WHERE usuario = '" + usuario + "' AND cargo != 'GERENTE'";

        try {
            Statement st = cn.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                contador++;
                registro[0] = rs.getString("usuario");
                registro[1] = rs.getString("nombre_usuario");
                registro[2] = rs.getString("apellido");
                registro[3] = rs.getString("celular");
                registro[4] = rs.getString("direccion");

                modelo.addRow(registro);

            }

            if (contador == 0 && !usuario.equals("")) {
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

    public boolean desactivar(String usuario) {

        sSql = "UPDATE usuario SET estado = 'INACTIVO' WHERE usuario = '" + usuario + "'";

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

    public boolean activar(String usuario) {

        sSql = "UPDATE usuario SET estado = 'ACTIVO' WHERE usuario = '" + usuario + "'";

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

    public boolean eliminarCliente(String id_cliente) {

        sSql = "DELETE FROM cliente WHERE id_cliente = '" + id_cliente + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, El cliente ya se encuentra en una salida." + "\n" + "Este no se puede eliminar.");
            return false;
        }
    }
}
