package Modelo;

public class Especie_ {

    private int codigo;
    private String nombreVulgar;
    private String nombreCientifico;
    private String familia;
    private String msnm;

    public Especie_(int codigo, String nombreVulgar, String nombreCientifico, String familia, String msnm) {
        this.codigo = codigo;
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.familia = familia;
        this.msnm = msnm;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getMsnm() {
        return msnm;
    }

    public void setMsnm(String msnm) {
        this.msnm = msnm;
    }

}
