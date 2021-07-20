package Modelo;

/**
 *
 * @author Alvaro Jose
 */
public class Vehiculo_ {

    private String placa;
    private String marca;
    private String estado;

    public Vehiculo_(String placa, String marca, String estado) {
        this.placa = placa;
        this.marca = marca;
        this.estado = estado;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
