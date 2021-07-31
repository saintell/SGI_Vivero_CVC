package Modelo;

public class Ingreso_ {

    private String codigoIngreso;
    private int codigoEspecie;
    private String tamanoBolsa;
    private String rango;
    private int stock;
    private int disponibles;
    

    public Ingreso_(String codigoIngreso, int codigoEspecie, String tamanoBolsa, String rango, int stock, int disponibles) {

        this.codigoIngreso = codigoIngreso;
        this.codigoEspecie = codigoEspecie;
        this.tamanoBolsa = tamanoBolsa;
        this.stock = stock;
        this.rango = rango;
        this.disponibles = disponibles;

    }

    public int getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(int codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public String getTamanoBolsa() {
        return tamanoBolsa;
    }

    public void setTamanoBolsa(String tamanoBolsa) {
        this.tamanoBolsa = tamanoBolsa;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getCodigoIngreso() {
        return codigoIngreso;
    }

    public void setCodigoIngreso(String codigoIngreso) {
        this.codigoIngreso = codigoIngreso;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    

}
