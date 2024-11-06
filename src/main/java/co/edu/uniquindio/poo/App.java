package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Empresa;
import co.edu.uniquindio.poo.model.Moto;
import co.edu.uniquindio.poo.model.TipoCaja;
import co.edu.uniquindio.poo.viewController.ReservaViewController;
import co.edu.uniquindio.poo.viewController.PrimaryController;

public class App extends Application {

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("MSTLUXURYCARS");

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("       Inicio de reserva    ");
        openViewPrincipal();
    }

    private void openViewPrincipal() {
        inicializarData();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("primary.fxml"));
            javafx.scene.layout.VBox rootLayout = (javafx.scene.layout.VBox) loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public void openCrudReserva() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("crudReserva.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            
            ReservaViewController reservaViewController = loader.getController();
            if (reservaViewController != null) {
                reservaViewController.setApp(this);
                reservaViewController.setClientes(empresa.getClientes()); // Establece los clientes en el controlador
                reservaViewController.setVehiculos(empresa.getVehiculos()); // Establece los vehículos en el controlador
            } else {
                System.out.println("El controlador reservaViewController es nulo");
            }

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Datos que se queman para las listas
     */
    public void inicializarData() {
        /**
         * clientes que se Visualizaran en el choiceBox
         */
        empresa.agregarCliente(new Cliente("1090272778","Alejo Rodriguez", "alejovargascxc@gmail.com", "3006921072"));
        empresa.agregarCliente(new Cliente("41950489","Sandra Rodriguez", "samyvargas58@gmail,com", "30090321043"));
        

        /**
         * Vehiculos que se Visualizaran en el choiceBox
         */
        empresa.agregarVehiculo(new Camioneta("LUS782", "Toyota", "LC300", 2024, 500000, 5));
        empresa.agregarVehiculo(new Moto("HMB69E", "Yamaha", "N-max connected", 2024, 690000, TipoCaja.AUTOMATICA));
        empresa.agregarVehiculo(new Moto("FEA78H", "Yamaha", "Mt-09", 2023, 800000, TipoCaja.AUTOMATICA));
        empresa.agregarVehiculo(new Auto("GFU578","MAZDA", "CX-30", 2023, 4000000, 4));
    }
}
