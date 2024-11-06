package co.edu.uniquindio.poo.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import java.time.LocalDate;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Vehiculo;

public class ReservaViewController {

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private Label lbl_FechaInicio;

    @FXML
    private Label lbl_FechaFin;

    @FXML
    private ChoiceBox<Cliente> cb_Cliente;

    @FXML
    private ChoiceBox<Vehiculo> cb_Modelo;

    @FXML
    private DatePicker datePickerInicio; // Renombrado a 'datePickerInicio' para mantener consistencia

    @FXML
    private DatePicker datePickerFin;

    @FXML
    private TableView<Reserva> tbl_ListReservas;

    @FXML
    private TableColumn<Reserva, String> tbc_Fecha;

    @FXML
    private TableColumn<Reserva, String> tbc_Cedula;

    @FXML
    private TableColumn<Reserva, String> tbc_Nombre;

    @FXML
    private TableColumn<Reserva, String> tbc_Telefono;

    @FXML
    private TableColumn<Reserva, String> tbc_Modelo;

    @FXML
    private TableColumn<Reserva, String> tbc_Placa;

    @FXML
    private TableColumn<Reserva, Double> tbc_Valor;

    @FXML
    private Button btn_Crear;

    @FXML
    private Button btn_Eliminar;

    @FXML
    private Button btn_Actualizar;

    @FXML
    private Button btn_Calcular;

    @FXML
    private ImageView imageView;

    private ObservableList<Reserva> reservas;

    @FXML
    public void initialize() {
        reservas = FXCollections.observableArrayList();

        tbc_Fecha.setCellValueFactory(new PropertyValueFactory<>("fechaInicioReserva"));
        tbc_Cedula.setCellValueFactory(new PropertyValueFactory<>("cedulaCliente"));
        tbc_Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tbc_Telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        tbc_Modelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
        tbc_Placa.setCellValueFactory(new PropertyValueFactory<>("Placa"));
        tbc_Valor.setCellValueFactory(new PropertyValueFactory<>("valorReserva"));

        tbl_ListReservas.setItems(reservas);
    }

    public void setClientes(ObservableList<Cliente> clientes) {
        cb_Cliente.setItems(clientes);
    }

    public void setVehiculos(ObservableList<Vehiculo> vehiculos) {
        cb_Modelo.setItems(vehiculos);
    }

    @FXML
    private void crearReserva() {
        LocalDate fechaInicio = datePickerInicio.getValue();
        LocalDate fechaFin = datePickerFin.getValue();
        Cliente cliente = cb_Cliente.getValue();
        Vehiculo vehiculo = cb_Modelo.getValue();

        if (fechaInicio != null && fechaFin != null && cliente != null && vehiculo != null) {
            double valorReserva = calcularValorReserva(fechaInicio, fechaFin);
            Reserva reserva = new Reserva(fechaInicio, fechaFin, cliente, vehiculo);
            reservas.add(reserva);
            System.out.println("La Reserva ha sido creada: " + reserva);
            tbl_ListReservas.refresh(); // Asegura la actualización de la tabla
        } else {
            System.out.println("Completa todos los campos para continuar");
        }
    }

    @FXML
    private void eliminarReserva() {
        Reserva selectedReserva = tbl_ListReservas.getSelectionModel().getSelectedItem();
        if (selectedReserva != null) {
            reservas.remove(selectedReserva);
        } else {
            System.out.println("Seleccione tu reserva para eliminarla");
        }
    }

    

    @FXML
    private void calcularReserva() {
        LocalDate fechaInicio = datePickerInicio.getValue(); // Usar datePickerInicio
        LocalDate fechaFin = datePickerFin.getValue(); // Usar datePickerFin
        if (fechaInicio != null && fechaFin != null) {
            double valor = calcularValorReserva(fechaInicio, fechaFin);
            System.out.println("El valor de tu reserva es: " + valor);
        } else {
            System.out.println("Selecciona las fechas de la reserva desde el inicio hasta el fin.");
        }
    }

    private double calcularValorReserva(LocalDate fechaInicio, LocalDate fechaFin) {
        long dias = fechaFin.toEpochDay() - fechaInicio.toEpochDay();
        return dias * 10000; // Ajusta el costo por día según sea necesario
    }
}
