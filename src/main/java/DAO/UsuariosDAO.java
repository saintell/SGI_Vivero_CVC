package DAO;

import Modelo.Usuario_;
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
public class UsuariosDAO {

    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    String sSql = " ";
    ResultSet rs;
    Statement st;
    int totalregistros;

    public boolean CrearUsuario(Usuario_ u) {

        sSql = "INSERT INTO usuario(usuario, contraseña, cargo, nombre_usuario, apellido, celular, direccion, estado)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pst = cn.prepareStatement(sSql);

            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getContraseña());
            pst.setString(3, u.getCargo().name());
            pst.setString(4, u.getNombre());
            pst.setString(5, u.getApellido());
            pst.setLong(6, Long.parseLong(u.getCelular()));
            pst.setString(7, u.getDireccion());
            pst.setString(8, u.getEstado().name());

            int n = pst.executeUpdate();

            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(null, "Usuario ya creado.");

            } else {
                System.out.println(e.getMessage());
            }

            return false;
        }
    }

    public ResultSet buscar(String usuario) throws SQLException {
        sSql = "SELECT * FROM usuario WHERE usuario = '" + usuario + "' ";
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
   
    public ResultSet contarUsuarios() throws SQLException {
        sSql = "SELECT COUNT(usuario) FROM usuario WHERE estado = 'ACTIVO'";
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
        modelo = new DefaultTableModel(null, titulos) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

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

    public boolean actualizar(String usuario,String contraseña, String nombre, String apellido, long celular, String direccion) {

        sSql = "UPDATE usuario SET nombre_usuario = '" + nombre + "',contraseña = '" + contraseña + "', apellido = '" + apellido + "'"
                + ", celular = '" + celular + "', direccion = '" + direccion + "' WHERE usuario = '" + usuario + "'";

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
        String[] titulos = {"Usuario", "Nombre", "Apellido", "Celular", "Dirección"};
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

        sql = "SELECT * FROM usuario u WHERE (u.apellido LIKE  ('" + busca + "%') OR u.usuario LIKE ('" + busca + "%') OR u.nombre_usuario LIKE "
                + "('" + busca + "%')) AND cargo != 'GERENTE' AND estado = 'ACTIVO'";

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
      public boolean eliminarUsuario(String usuario) {

        sSql = "DELETE FROM usuario WHERE usuario = '" + usuario + "'";

        try {

            PreparedStatement pst = cn.prepareStatement(sSql);

            int i = pst.executeUpdate();

            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, No se pudo eliminar el usuario.");
            return false;
        }
    }

}
