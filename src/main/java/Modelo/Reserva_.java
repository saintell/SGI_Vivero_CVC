package Modelo;

import java.sql.Date;

public class Reserva_ {

    private int codigo_reserva;
    private String id_cliente;
    private int codigo_planta;
    private String tamaño_bolsa;
    private String rango;
    private int cantidad;
    private Date fechaApertura;
    private Date fechaCierre;

    public Reserva_(int codigo_reserva, String id_cliente, int codigo_planta, String tamaño_bolsa, String rango, int cantidad, Date fechaApertura, Date fechaCierre) {
        this.codigo_reserva = codigo_reserva;
        this.id_cliente = id_cliente;
        this.codigo_planta = codigo_planta;
        this.tamaño_bolsa = tamaño_bolsa;
        this.rango = rango;
        this.cantidad = cantidad;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
    }

    public int getCodigo_reserva() {
        return codigo_reserva;
    }

    public void setCodigo_reserva(int codigo_reserva) {
        this.codigo_reserva = codigo_reserva;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCodigo_planta() {
        return codigo_planta;
    }

    public void setCodigo_planta(int codigo_planta) {
        this.codigo_planta = codigo_planta;
    }

    public String getTamaño_bolsa() {
        return tamaño_bolsa;
    }

    public void setTamaño_bolsa(String tamaño_bolsa) {
        this.tamaño_bolsa = tamaño_bolsa;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

}
