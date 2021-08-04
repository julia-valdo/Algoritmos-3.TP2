package edu.fiuba.algo3.Controlador.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaCantidadJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BotonVolverASeleccionHandler implements EventHandler<ActionEvent> {

    private StackPane seleccion;

    public BotonVolverASeleccionHandler(){
        super();
        this.seleccion = new VentanaCantidadJugadores();

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene seleccion = new Scene(this.seleccion);

        stage.setScene(seleccion);
        stage.show();
    }
}
