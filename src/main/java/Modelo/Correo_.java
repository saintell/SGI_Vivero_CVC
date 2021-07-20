package Modelo;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Alvaro Jose
 */
public class Correo_ {

    String usuario;
    String contrasena;
    String nombreArchivo;
    public ArrayList destinos;
    String asunto;
    String mensaje;

    public Correo_() {

        this.destinos = new ArrayList();

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuarios) {
        this.usuario = usuarios;
    }

    public ArrayList getDestinos() {
        return destinos;
    }

    public void setDestinos(String destinos) {
        this.destinos.add(destinos);
    }

    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String toString() {

        return (" " + usuario + "," + " " + contrasena + "," + " " + nombreArchivo + "," + " " + destinos + "," + " " + asunto + "," + " " + mensaje);

    }

}
