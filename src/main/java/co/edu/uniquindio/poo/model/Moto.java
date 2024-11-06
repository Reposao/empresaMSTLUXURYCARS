package co.edu.uniquindio.poo.model;

/**
 * Esta es la clase de Moto la cual hereda de la clase Vehiculo
 */

public class Moto extends Vehiculo{
    private TipoCaja TipoCaja;

    /**
     * Constructor de la clase Moto
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param tarifaBase
     * @param tipoCaja
     */

    public Moto(String matricula, String marca, String modelo, int anioFabricacion, double tarifaBase,
            co.edu.uniquindio.poo.model.TipoCaja tipoCaja) {
        super(matricula, marca, modelo, anioFabricacion, tarifaBase);
        TipoCaja = tipoCaja;
    }

    public TipoCaja getTipoCaja() {
        return TipoCaja;
    }

    public void setTipoCaja(TipoCaja tipoCaja) {
        TipoCaja = tipoCaja;
    }
    
    /**
     * Metodo para calcular la tarifa de la reserva para una moto
     * @param dias
     * @param tipoCaja
     * @return
     */

    public double calcularTarifaMoto(int dias, TipoCaja tipoCaja){

        double costo = 0.0;
        
        if (getTipoCaja() == TipoCaja.MANUAL){
            costo = getTarifaBase() * dias;
        }
        else if (getTipoCaja() ==TipoCaja.AUTOMATICA){
            costo =(getTarifaBase() * dias) + 50000;
        }
        else {
            costo = 0;
        }
        return costo;
    }

    @Override
    public String toString() {
        return "Moto [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", anioFabricacion="
                + anioFabricacion + ", tarifaBase=" + tarifaBase + ", TipoCaja=" + TipoCaja + "]";
    }

    
    
}
