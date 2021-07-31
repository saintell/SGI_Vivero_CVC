package Reportes;

import DAO.ConexionBD;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class GenerarReporte {

    private ConexionBD conexion;

    private String url = new File("").getAbsolutePath();
    private String logo = url + "\\src\\main\\resources\\LogoBiodess.png";
    private String logo2 = url + "\\src\\main\\resources\\LogoCVC.png";

    public void remisionSalida(String cedula, int codigo, String numero_orden, String motivo) {

        try {
            conexion = new ConexionBD();

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("Remision_Salida.jasper");
            Map parameter = new HashMap();
            parameter.put("cedula", cedula);
            parameter.put("codigo_salida", codigo);
            parameter.put("numero_orden", numero_orden);
            parameter.put("logoBiodess", logo);
            parameter.put("logoCVC", logo2);
            parameter.put("motivo", motivo);

            JasperPrint print = JasperFillManager.fillReport(report, parameter, conexion.conectar());
            JasperViewer jv = new JasperViewer(print, false);
            jv.setTitle("Remisión de Salida");
            jv.setVisible(true);
        } catch (JRException ex) {
        }

    }
    public void remisionSalida2(String cedula, int codigo, String numero_orden, String motivo) {

        System.out.println(logo);
        try {
            conexion = new ConexionBD();

            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("Remision_Salida_copia.jasper");
            Map parameter = new HashMap();
            parameter.put("cedula", cedula);
            parameter.put("codigo_salida", codigo);
            parameter.put("numero_orden", numero_orden);
            parameter.put("logoBiodess", logo);
            parameter.put("logoCVC", logo2);
            parameter.put("motivo", motivo);

            JasperPrint print = JasperFillManager.fillReport(report, parameter, conexion.conectar());
            JasperViewer jv = new JasperViewer(print, false);
            jv.setTitle("Remisión de Salida");
            jv.setVisible(true);
        } catch (JRException ex) {
        }

    }

}
