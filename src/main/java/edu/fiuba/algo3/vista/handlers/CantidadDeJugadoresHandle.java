package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.vista.ventanas.VentanaComienzo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CantidadDeJugadoresHandle implements EventHandler<ActionEvent> {

    private Integer cantidadDeJugadores;

    public CantidadDeJugadoresHandle(Integer cantidadDeJugadores){
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage =(Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Jugadores: " + this.cantidadDeJugadores);
        stage.show();
    }
}
