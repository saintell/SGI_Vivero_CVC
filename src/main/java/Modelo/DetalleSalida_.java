package Modelo;

/**
 *
 * @author santiago
 */
public class DetalleSalida_ {

    private int codigo_salida;
    private String codigo_planta;
    private int cantidad;
    private String tamaño_destino;
    private int costo;
    private int total;
    private int pedidas;

    public DetalleSalida_(int codigo_salida, String codigo_planta, String tamaño_destino, int cantidad, int pedidas) {
        this.codigo_salida = codigo_salida;
        this.codigo_planta = codigo_planta;
        this.cantidad = cantidad;
        this.tamaño_destino = tamaño_destino;
        this.pedidas = pedidas;
    }

    public int getCodigo_salida() {
        return codigo_salida;
    }

    public void setCodigo_salida(int codigo_salida) {
        this.codigo_salida = codigo_salida;
    }

    public String getCodigo_planta() {
        return codigo_planta;
    }

    public void setCodigo_planta(String codigo_planta) {
        this.codigo_planta = codigo_planta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTamaño_destino() {
        return tamaño_destino;
    }

    public void setTamaño_destino(String tamaño_destino) {
        this.tamaño_destino = tamaño_destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPedidas() {
        return pedidas;
    }

    public void setPedidas(int pedidas) {
        this.pedidas = pedidas;
    }

}
