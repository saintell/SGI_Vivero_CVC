package Modelo;

public class Usuario_ {

    private String usuario;
    private String contraseña;
    private Cargo_ cargo;
    private String nombre;
    private String apellido;
    private String celular;
    private String direccion;
    private Estado_ estado;

    public Usuario_(String usuario, String contraseña, Cargo_ cargo, String nombre, String apellido, String celular, String direccion, Estado_ estado) {

        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cargo = cargo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.direccion = direccion;
        this.estado = estado;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Cargo_ getCargo() {
        return cargo;
    }

    public void setCargo(Cargo_ cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Estado_ getEstado() {
        return estado;
    }

    public void setEstado(Estado_ estado) {
        this.estado = estado;
    }

}
