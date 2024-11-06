package co.edu.uniquindio.poo.model;

/**
 * Esta es la clase de Auto la cual hereda de la clase Vehiculo
 */

public class Auto extends Vehiculo {
    private int puertas;
    /**
     * Metodo constructor para la clase Auto
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tarifaBase
     * @param puertas
     */
    
    public Auto(String matricula, String marca, String modelo, int anioFabricacion, double tarifaBase, int puertas){
        super(matricula, marca, modelo, anioFabricacion, tarifaBase);
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    /**
     * Metodo para calcular la tarifa de reserva para un auto
     * @param dias
     * @return
     */
    public double calcularTarifaAuto(int dias){
        return getTarifaBase() * dias;
    }

    @Override
    public String toString() {
        return "Auto [matricula=" + getMatricula() + ", marca=" + getMarca() + ", modelo=" + getModelo()
                + ", anioFabricacion=" + getAnioFabricacion() + ", tarifaBase=" + getTarifaBase() 
                + ", puertas=" + puertas + "]";
    }
}
