package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    public String matricula, marca, modelo;
    public int anioFabricacion;
    public double tarifaBase;

    /**
     * Metodo constructor para la clase vehiculo
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tarifaBase
     */

    Vehiculo(String matricula, String marca, String modelo, int anioFabricacion, double tarifaBase){
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.tarifaBase = tarifaBase;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    @Override
    public String toString() {
        return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", anioFabricacion="
                + anioFabricacion + ", tarifaBase=" + tarifaBase + "]";
    }
    
}
