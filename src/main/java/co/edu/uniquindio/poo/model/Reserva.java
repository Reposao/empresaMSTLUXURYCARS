package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Reserva {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private double valorReserva;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente, Vehiculo vehiculo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        calcularValorReserva();
    }

    private void calcularValorReserva() {
        int dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay());
        this.valorReserva = dias * vehiculo.getTarifaBase();
    }

    // Getters para cada propiedad que se necesita en la tabla
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public String getCedulaCliente() {
        return cliente != null ? cliente.getCedula() : "";
    }

    public String getNombre() {
        return cliente != null ? cliente.getNombre() : "";
    }

    public String getTelefono() {
        return cliente != null ? cliente.getTelefono() : "";
    }

    public String getModelo() {
        return vehiculo != null ? vehiculo.getModelo() : "";
    }

    public String getPlaca() {
        return vehiculo != null ? vehiculo.getMarca() : "";
    }

    public double getValorReserva() {
        return valorReserva;
    }
}