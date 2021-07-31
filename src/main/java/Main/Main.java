package Main;

import DAO.UsuariosDAO;
import Vista.Login;
import Vista.RegistrarGerente;
import Vista.VistaSGI;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class Main {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        }

        try {

            UsuariosDAO uDao = new UsuariosDAO();
            ResultSet rs = uDao.buscar1();

            if (!rs.next()) {

                RegistrarGerente registrar = new RegistrarGerente();
                registrar.setVisible(true);

            } else {

//                Login login = new Login();
//                login.setVisible(true);
                VistaSGI vista = new VistaSGI();
                vista.setVisible(true);
            }
        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

    }

}
