package co.edu.uniquindio.poo.model;

public class Cliente {
    private String cedula, nombre, correo, telefono;

    /**
     * Metodo constructor para la clase Cliente
     * @param cedula
     * @param nombre
     * @param correo
     * @param telefono
     */

    public Cliente(String cedula, String nombre, String correo, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
                + "]";
    }
    
}