package Modelo;

import java.sql.Date;

public class DetalleIngreso_ {

    private int codigoEspecie;
    private int cantidad;
    private Date fecha;
    private String codigo_ingreso;

    public DetalleIngreso_(int codigoEspecie, int cantidad, Date fecha, String codigo_ingreso) {
        this.codigoEspecie = codigoEspecie;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.codigo_ingreso = codigo_ingreso;
    }


    public int getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(int codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigo_ingreso() {
        return codigo_ingreso;
    }

    public void setCodigo_ingreso(String codigo_ingreso) {
        this.codigo_ingreso = codigo_ingreso;
    }

}
