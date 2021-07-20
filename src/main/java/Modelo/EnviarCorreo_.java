
package Modelo;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Alvaro Jose
 */
public class EnviarCorreo_ {

    Correo_ correo = new Correo_();

    public boolean enviarCorreo_(Correo_ correo) {

        try {
            //        try {

            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correo.getUsuario());
            p.setProperty("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(p, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(correo.getMensaje());
            
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("Vivero.xlsx")));
            adjunto.setFileName("Vivero.xlsx");
            
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);
//            m.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(s);
            InternetAddress[] adresses = new InternetAddress[correo.getDestinos().size()];

            for (int i = 0; i < correo.getDestinos().size(); i++) {
                adresses[i] = new InternetAddress((String) correo.getDestinos().get(i));
            }

            message.setFrom(new InternetAddress(correo.getUsuario()));
            message.addRecipients(Message.RecipientType.TO, adresses);
            message.setSubject(correo.getAsunto());
            message.setContent(m, "text/html");

            Transport t = s.getTransport("smtp");
            t.connect(correo.getUsuario(), correo.getContrasena());
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;

        } catch (Exception e) {

            return false;
        }

    }

    public boolean conectar(String user, String pass) {

        try {

            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", user);
            p.setProperty("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(p, null);

            Transport t = s.getTransport("smtp");
            t.connect(user, pass);
            t.close();
            return true;

        } catch (Exception e) {

            System.out.println("Error" + " " + e);
            return false;
        }
    }

}
