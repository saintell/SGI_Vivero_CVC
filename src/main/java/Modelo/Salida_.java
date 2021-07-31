package Modelo;

import java.sql.Date;

/**
 *
 * @author Alvaro Jose
 */
public class Salida_ {

    private int codigo_salida;
    private String numero_orden;
    private String motivo;
    private Date fecha;
    private int parcial;
    private String convenio;
    private String corregimiento;
    private String destino;
    private int total;
    private String id_cliente;
    private int id_conductor;
    private String placa;
    private String predio;
    private String carguista;
    private String observacion;
    private String id_conductor_temp;
    private String nombre_conductor_temp;
    private String apellido_conductor_temp;
    private String celular_conductor_temp;

    public Salida_(int codigo_salida, String numero_orden, String motivo, String predio, Date fecha, int parcial, String convenio, String corregimiento, String destino, int total, String id_cliente, int id_conductor, String placa, String carguista, String observacion, String id_conductor_temp, String nombre_conductor_temp, String apellido_conductor_temp, String celular_conductor_temp) {
        this.codigo_salida = codigo_salida;
        this.numero_orden = numero_orden;
        this.motivo = motivo;
        this.fecha = fecha;
        this.parcial = parcial;
        this.convenio = convenio;
        this.destino = destino;
        this.total = total;
        this.id_cliente = id_cliente;
        this.id_conductor = id_conductor;
        this.placa = placa;
        this.predio = predio;
        this.corregimiento = corregimiento;
        this.carguista = carguista;
        this.observacion = observacion;
        this.id_conductor_temp = id_conductor_temp;
        this.nombre_conductor_temp = nombre_conductor_temp;
        this.apellido_conductor_temp = apellido_conductor_temp;
        this.celular_conductor_temp = celular_conductor_temp;
    }

    public int getCodigo_salida() {
        return codigo_salida;
    }

    public void setCodigo_salida(int codigo_salida) {
        this.codigo_salida = codigo_salida;
    }

    public String getNumero_orden() {
        return numero_orden;
    }

    public void setNumero_orden(String numero_orden) {
        this.numero_orden = numero_orden;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getCorregimiento() {
        return corregimiento;
    }

    public void setCorregimiento(String corregimiento) {
        this.corregimiento = corregimiento;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public String getCarguista() {
        return carguista;
    }

    public void setCarguista(String carguista) {
        this.carguista = carguista;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getId_conductor_temp() {
        return id_conductor_temp;
    }

    public void setId_conductor_temp(String id_conductor_temp) {
        this.id_conductor_temp = id_conductor_temp;
    }

    public String getNombre_conductor_temp() {
        return nombre_conductor_temp;
    }

    public void setNombre_conductor_temp(String nombre_conductor_temp) {
        this.nombre_conductor_temp = nombre_conductor_temp;
    }

    public String getApellido_conductor_temp() {
        return apellido_conductor_temp;
    }

    public void setApellido_conductor_temp(String apellido_conductor_temp) {
        this.apellido_conductor_temp = apellido_conductor_temp;
    }

    public String getCelular_conductor_temp() {
        return celular_conductor_temp;
    }

    public void setCelular_conductor_temp(String celular_conductor_temp) {
        this.celular_conductor_temp = celular_conductor_temp;
    }

    public int getParcial() {
        return parcial;
    }

    public void setParcial(int parcial) {
        this.parcial = parcial;
    }
}
